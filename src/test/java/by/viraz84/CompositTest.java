package by.viraz84;

import by.viraz84.composite.entity.*;
import by.viraz84.composite.methods.TextParser;
import by.viraz84.composite.methods.WordReplace;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class CompositTest {

    @Test
    public void testComposit() {
        Component c1 = new ListingLeaf("Жить, хорошо");
        Composite composite = new Composite();
        composite.add(c1);
        Assertions.assertThat(composite.getElem(0)).isEqualTo(c1);
    }

    @Test
    public void testComposit2() {
        Component c1 = new ListingLeaf("Жить, хорошо.");
        Component c2 = new ListingLeaf("А хорошо жить.");
        Component c3 = new ListingLeaf("Еще лучше ).");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);

        composite2.add(composite1);

        Assertions.assertThat(composite1.getSize()).isEqualTo(3);
        Assertions.assertThat(composite2.getSize()).isEqualTo(1);
    }

    @Test
    public void testComposit3() {
        Component c1 = new ListingLeaf("Жить, хорошо.");
        Component c2 = new ListingLeaf("А хорошо жить.");
        Component c3 = new ListingLeaf("Еще лучше ).");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);

        composite2.add(c1);
        composite2.add(c2);
        composite2.add(c3);

        Assertions.assertThat(composite1.getElem(2)).isEqualTo(composite2.getElem(2));
        Assertions.assertThat(composite1.getElem(1)).isEqualTo(c2);
    }

    @Test
    public void testComposit4() {
        Component c1 = new ListingLeaf("Жить, хорошо.");
        Component c2 = new ListingLeaf("А хорошо жить.");
        Component c3 = new ListingLeaf("Еще лучше ).");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);
        composite2.add(composite1);

        Assert.assertEquals("Composite", composite2.getClass().getSimpleName());
        Assert.assertEquals("Composite", composite2.getElem(0).getClass().getSimpleName());
        Assert.assertEquals("ListingLeaf", composite1.getElem(1).getClass().getSimpleName());

    }

    @Test
    public void testComposit5() {
        Component c1 = new WordLeaf("Java");
        Composite composite = new Composite();
        composite.add(c1);
        Assertions.assertThat(composite.getElem(0)).isEqualTo(c1);
    }

    @Test
    public void testComposit6() {
        Component c1 = new WordLeaf("Hello");
        Component c2 = new WordLeaf("Java");
        Component c3 = new WordLeaf("Start");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);

        composite2.add(composite1);

        Assertions.assertThat(composite1.getSize()).isEqualTo(3);
        Assertions.assertThat(composite2.getSize()).isEqualTo(1);
    }

    @Test
    public void testComposit7() {
        Component c1 = new WordLeaf("Hello");
        Component c2 = new WordLeaf("Java");
        Component c3 = new WordLeaf("Start");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);

        composite2.add(c1);
        composite2.add(c2);
        composite2.add(c3);
        System.out.println(c2);

        Assertions.assertThat(composite1.getElem(2)).isEqualTo(composite2.getElem(2));
        Assertions.assertThat(composite1.getElem(1)).isEqualTo(c2);
    }

    @Test
    public void testComposit8() {
        Component c1 = new WordLeaf("Hello");
        Component c2 = new WordLeaf("Java");
        Component c3 = new WordLeaf("Start");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);
        composite2.add(composite1);

        Assert.assertEquals("Composite", composite2.getClass().getSimpleName());
        Assert.assertEquals("Composite", composite2.getElem(0).getClass().getSimpleName());
        Assert.assertEquals("WordLeaf", composite1.getElem(1).getClass().getSimpleName());
    }

    @Test
    public void testComposit9() {
        Component c1 = new PunctLeaf(".");
        Composite composite = new Composite();
        composite.add(c1);
        Assertions.assertThat(composite.getElem(0)).isEqualTo(c1);
    }

    @Test
    public void testComposit10() {
        Component c1 = new PunctLeaf(".");
        Component c2 = new PunctLeaf(",");
        Component c3 = new PunctLeaf("!");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);

        composite2.add(composite1);

        Assertions.assertThat(composite1.getSize()).isEqualTo(3);
        Assertions.assertThat(composite2.getSize()).isEqualTo(1);
    }

    @Test
    public void testComposit11() {
        Component c1 = new PunctLeaf(".");
        Component c2 = new PunctLeaf(",");
        Component c3 = new PunctLeaf("!");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);

        composite2.add(c1);
        composite2.add(c2);
        composite2.add(c3);

        Assertions.assertThat(composite1.getElem(2)).isEqualTo(composite2.getElem(2));
        Assertions.assertThat(composite1.getElem(1)).isEqualTo(c2);
    }

    @Test
    public void testComposit12() {
        Component c1 = new PunctLeaf(".");
        Component c2 = new PunctLeaf(",");
        Component c3 = new PunctLeaf("!");

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(c1);
        composite1.add(c2);
        composite1.add(c3);
        composite2.add(composite1);

        Assert.assertEquals("Composite", composite2.getClass().getSimpleName());
        Assert.assertEquals("Composite", composite2.getElem(0).getClass().getSimpleName());
        Assert.assertEquals("PunctLeaf", composite1.getElem(1).getClass().getSimpleName());

    }

    @Test
    public void initPath() {
        String path = "textTestPath.txt";
        TextParser textParser = new TextParser();
        Assertions.assertThat(textParser.init(path)).isEqualTo("Hello good java.");
    }

    @Test
    public void testTextParagr() {
        TextParser tp = new TextParser();
        Composite composite1 = new Composite();
        String st = "\t Hello java.";
        Assertions.assertThat(tp.textToParagr(composite1, st).getClass().getSimpleName()).isEqualTo("Composite");
       }
    @Test
    public void testParagrToSent() {
        TextParser tp = new TextParser();
        Composite composite1 = new Composite();
        String st = "Hello, java.";
        Assertions.assertThat(tp.paragrToSent(composite1, st).getClass().getSimpleName()).isEqualTo("Composite");
        }

    @Test
    public void testSentToLexemes() {
        TextParser tp = new TextParser();
        Composite composite1 = new Composite();
        String st = "Hello,";
        Assertions.assertThat(tp.sentToLexemes(composite1, st).getClass().getSimpleName()).isEqualTo("Composite");

    }


    @Test
    public void testReplace1() {
        String path = "textTest2.txt";
        ArrayList<String> exp1 = new ArrayList<String>();
        exp1.add("java good Hello .");
        TextParser tp1 = new TextParser();
        Composite c1 = tp1.parse("textTest2.txt");
        //c1.parse();
        ArrayList<String> act1 = WordReplace.swapFirstLast(c1);
        System.out.println(exp1.size());
        System.out.println(act1);
        Assertions.assertThat(act1).isEqualTo(exp1);

    }
    @Test
    public void testReplace2() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("собой понимать , что вокруг все связано между Важно .");
        expected.add("везде окружает нас Природа .");
        TextParser testRepl = new TextParser();
        Composite c1 = testRepl.parse("textTest.txt");
        ArrayList<String> actual = WordReplace.swapFirstLast(c1);
        System.out.println(actual.size());
        System.out.println(actual);
        for (int i=0; i < actual.size(); i++) {
            Assertions.assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }

}

