package model;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by Илья on 09.03.2017.
 */
public class Student implements Pupil,Cloneable{

    private String secondName;
    private int[] marks;
    private String[] subjects;

    public Student(String secondName, int arraysSize) {
        marks = new int[arraysSize];
        subjects = new String[arraysSize];
        this.secondName = secondName;
    }

    @Override
    public void addRegistryRecord(String subject, int mark) {
        addSubjects(subject);
        addMarks(mark);
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public int getRegistrySize() {
        return getMarksCount();
    }

    @Override
    public int getMark(int index) {
        return marks[index];
    }

    @Override
    public String getSubject(int index) {
        return subjects[index];
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public void addMarks(int... marks) {
        if (this.marks == null) {
            this.marks = marks;
        } else {
            int prevLength = this.marks.length;
            int newLenght = this.marks.length + marks.length;
            this.marks = Arrays.copyOf(this.marks, newLenght);
            for (int i = prevLength; i < newLenght; i++) {
                this.marks[i] = marks[i - prevLength];
            }
        }
    }

    public void addSubjects(String... subjects) {
        if (this.subjects == null) {
            this.subjects = subjects;
        } else {

            int prevLength = this.subjects.length;
            int newLenght = this.subjects.length + subjects.length;
            this.subjects = Arrays.copyOf(this.subjects, newLenght);
            for (int i = prevLength; i < newLenght; i++) {
                this.subjects[i] = subjects[i - prevLength];
            }
        }
    }

    public int getSubjectsCount() {
        return subjects.length;
    }

    public int getMarksCount() {
        return marks.length;
    }
}
