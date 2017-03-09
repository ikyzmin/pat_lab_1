package model;

/**
 * Created by Илья on 09.03.2017.
 */
public class Register implements Cloneable {


    public Register(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    private int mark;
    private String subject;

    public int getMark() {
        return mark;
    }

    public void setMark(int marks) {
        this.mark = marks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subjects) {
        this.subject = subjects;
    }
}
