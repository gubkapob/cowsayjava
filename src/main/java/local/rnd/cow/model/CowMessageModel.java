package local.rnd.cow.model;

public class CowMessageModel {

    private final String text;

    public CowMessageModel(String text){
        this.text = (text == null) ? "" : text;
    }

    public String getText(){
        return text;
    }
}