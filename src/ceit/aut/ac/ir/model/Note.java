package ceit.aut.ac.ir.model;

import java.io.Serializable;
/**
 * this is a class to keep notes features
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    public Note (String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}

