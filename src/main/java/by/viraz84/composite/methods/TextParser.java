package by.viraz84.composite.methods;
import by.viraz84.composite.entity.Composite;
import by.viraz84.composite.entity.ListingLeaf;
import by.viraz84.composite.entity.PunctLeaf;
import by.viraz84.composite.entity.WordLeaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextParser {
    private final static Logger LOG = LoggerFactory.getLogger(TextParser.class);

    final static String REGEX_TEXT = "(?s)((\\t)[^\\t]+)";
    final static String REGEX_PARAGRAPH = "(?:[^\\n][\\n]?)+";
    final static String REGEX_SENTENCE = "([А-ЯA-Z]([^?!.\\(]|\\([^\\)]*\\))*[.?!])";
    final static String REGEX_LEXEME = "((\\s*)[А-ЯA-Zа-яa-z]*(\\p{Blank}|\\p{P})|(\\p{P}\\p{Blank}))";
    final static String REGEX_WORD =  "([А-ЯA-Zа-яa-z]+)";
    final static String REGEX_PUNCTUATION = "\\p{P}";


    public TextParser(){
    }

    public Composite parse(String path){
        String text = init(path);
        Composite wholeText = new Composite();
        wholeText = textToParagr(wholeText, text);
        return wholeText;
    }

    public String init(final String path)  {
        String text = "";
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(path);
            byte[] bytes = new byte[fileIn.available()];
            fileIn.read(bytes);
            text = new String(bytes);
            LOG.info("*************TEXT********* : {} ",text);
            }
        catch (FileNotFoundException e) {
            LOG.error("Error exception FNF {}", e.getMessage());
            System.out.println("Error exc_1");
            }
        catch (IOException e) {
            LOG.error("Error exception IO  {}", e.getMessage());
            System.out.println("Error exc_2");
        } finally {
             try {
            fileIn.close();
            }catch(IOException e2) {
                 LOG.error("Error exception IO in fileclose {}", e2.getMessage());
                 System.out.println(e2.getMessage());
            }
        }
        return text;
    }

    public Composite textToParagr(Composite wholeText, String text){
        Composite paragrList = new Composite();
        ListingLeaf paragrLeaf;

        Pattern textPatternListingParagr = Pattern.compile(REGEX_TEXT);
        Matcher textMatcherListingParagr = textPatternListingParagr.matcher(text);

        while (textMatcherListingParagr.find()){
            String paragrAndListing = textMatcherListingParagr.group();

            if (Pattern.matches(REGEX_PARAGRAPH, paragrAndListing)){
                LOG.info("Paragr: {}", paragrAndListing);
                paragrList = paragrToSent(paragrList, paragrAndListing);
            } else {
                paragrLeaf = new ListingLeaf(paragrAndListing);
                paragrList.add(paragrLeaf);
            }
        }
        wholeText.add(paragrList);
        return wholeText;
    }

    public Composite paragrToSent(Composite paragrList, String paragr){
        Composite sentList = new Composite();
        String sent;
        Pattern textPatternSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher textMatcherSentence = textPatternSentence.matcher(paragr);

        while (textMatcherSentence.find()){
            sent = textMatcherSentence.group();
            LOG.info("Sentence: {}", sent);
            sentList = sentToLexemes(sentList, sent);
        }

        paragrList.add(sentList);
        return paragrList;
    }

    public Composite sentToLexemes(Composite sentList, String sent){
        Composite lexemeList = new Composite();
        String lexeme;
        WordLeaf wordLeaf;
        PunctLeaf signLeaf;
        Pattern textPatternLexeme = Pattern.compile(REGEX_LEXEME);
        Matcher textMatcherLexeme = textPatternLexeme.matcher(sent);
        Pattern textPatternWord = Pattern.compile(REGEX_WORD);
        Pattern textPatternPunctuation = Pattern.compile(REGEX_PUNCTUATION);

        while (textMatcherLexeme.find()){
            lexeme = textMatcherLexeme.group().trim();
           LOG.info("Lexeme: {}", lexeme);
            Matcher textMatcherWord = textPatternWord.matcher(lexeme);
            if (textMatcherWord.find()) {
                String word = textMatcherWord.group();
                wordLeaf = new WordLeaf(word);
                LOG.info("Word: {}", wordLeaf);
                lexemeList.add(wordLeaf);
            }
            Matcher textMatcherPunctuation = textPatternPunctuation.matcher(lexeme);
            if (textMatcherPunctuation.find()) {
                String sign = textMatcherPunctuation.group();
                signLeaf = new PunctLeaf(sign);
                LOG.info("Sign: {}", signLeaf);
                lexemeList.add(signLeaf);
            }
        }
        sentList.add(lexemeList);
        return sentList;
    }

}
