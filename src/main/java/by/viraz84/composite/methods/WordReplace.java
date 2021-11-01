package by.viraz84.composite.methods;

import by.viraz84.composite.entity.Component;
import by.viraz84.composite.entity.Composite;
import by.viraz84.composite.entity.PunctLeaf;
import by.viraz84.composite.entity.WordLeaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;


public class WordReplace {

    private final static Logger LOG = LoggerFactory.getLogger(WordReplace.class);

    public static ArrayList<String> swapFirstLast(Composite wholeText) {
        Composite text = (Composite) wholeText.getElem(0);
        Composite paragr = null;
        ArrayList<String> sentReplList = new ArrayList<String>();

        LOG.debug("text size: {}", text.getSize());
        for (int i = 0; i < text.getSize(); i++) {
            LOG.debug("TextAll = {}", text.getElem(i).getClass().getSimpleName());
            if (text.getElem(i).getClass().getSimpleName().equals("ListingLeaf")) {
                continue;
            } else {
                paragr = (Composite) text.getElem(i);
            }
            LOG.debug("TextParagr = {}", paragr.getClass().getSimpleName());
            for (int j = 0; j < paragr.getSize(); j++) {
                ArrayList<Component> sentNewList = new ArrayList<Component>();
                LOG.debug("paragr size: {}", paragr.getSize());
                Composite sentence = (Composite) paragr.getElem(j);
                LOG.debug("sentence size: {}", sentence.getSize());
                for (int k = 0; k < sentence.getSize(); k++) {
                    if (sentence.getElem(k).getClass().getSimpleName().equals("WordLeaf")) {
                        Component word = (WordLeaf) sentence.getElem(k);
                        if (!("").equals(word.toString())) {
                            LOG.info("Add__Word = {}", word);
                            sentNewList.add(word);
                        }
                    } else {
                        Component sign = (PunctLeaf) sentence.getElem(k);
                        if (!("").equals(sign.toString())) {
                            LOG.info("Add__Sign = {} ", sign);
                            sentNewList.add(sign);
                        }
                    }
                }
                for (int n = sentNewList.size() - 1; n > 0; n--) {
                    if (sentNewList.get(n).getClass().getSimpleName().equals("WordLeaf")) {
                        Collections.swap(sentNewList, 0, n);
                        break;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (Component item : sentNewList) {
                    sb.append(item);
                    sb.append(" ");
                }
                LOG.info("Result = {}", sb);
                sentReplList.add(sb.toString().trim());
            }
        }
        return sentReplList;
    }
}
