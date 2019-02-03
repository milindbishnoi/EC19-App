package com.elementsculmyca.ec19_app;

public class EventListModel {

    private String ctitle;
    private String cContent;
    public EventListModel(String ctitle,String cContent)
    {
        this.ctitle = ctitle;
        this.cContent =cContent;
    }

    public String getcContent() {
        return cContent;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) { this.ctitle = ctitle; }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

}
