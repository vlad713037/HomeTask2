package by.viraz84.composite.entity;

public class ListingLeaf implements Component {

    String str;

    public ListingLeaf(String str){
        this.str = str;
    }

    @Override
    public void parse() {
        System.out.print(str + " ");
    }

    @Override
    public String toString() {
        return str;
    }
}
