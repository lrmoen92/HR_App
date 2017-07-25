package com.astontech.hr.domain.VO;

/**
 * Created by Logan.Moen on 7/12/2017.
 */
public class ElementVO {

    private String newElementType;
    private String newElements;
    private String[] newElementArray;

    public ElementVO(){}

    //custom methods
    public void splitNewElementsIntoArray(){
        this.setNewElementArray(this.newElements.split("\\r?\\n"));

    }


    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }

    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }
}
