package Aagotnes.demo.domain;

public class VoteOption {

    private String caption;
    private int presentationOrder;


    public VoteOption() {}


    public String getCaption() {
        return caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }


    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

}