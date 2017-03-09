package model;

/**
 * Created by Илья on 09.03.2017.
 */
public interface Pupil extends Cloneable {

    void addRegistryRecord(String subject,int mark);
    String getSecondName();
    int getRegistrySize();
    int getMark(int index);
    String getSubject(int index);
    Object clone() throws CloneNotSupportedException;

}
