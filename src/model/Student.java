package model;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by ���� on 09.03.2017.
 */
public class Student implements Pupil {

    private String secondName;
    private int[] marks;
    private String[] subjects;
    private int marksSize = 0;
    private int subjectsSize = 0;

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
        return Math.max(getMarksCount(), getSubjectsCount());
    }

    @Override
    public int getMark(int index) {
        return marks[index];
    }

    @Override
    public void setSubject(int index, String value) {
        subjects[index] = value;
    }

    @Override
    public void setMark(int index, int value) {
        marks[index] = value;
    }

    @Override
    public String getSubject(int index) {
        return subjects[index];
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.marks = new int[this.marks.length];
        clone.subjects  = new String[this.subjects.length];
        clone.subjectsSize = 0;
        clone.marksSize = 0;
        for (int i = 0; i < getRegistrySize(); i++) {
            clone.addRegistryRecord(getSubject(i), getMark(i));
        }
        return clone;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
        marksSize = marks.length;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
        subjectsSize = subjects.length;
    }

    public void addMarks(int... marks) {
        if (this.marks == null) {
            this.marks = marks;
        } else {
            int prevLength = this.marks.length;
            int newLenght = marks.length;
            if (marksSize + newLenght > this.marks.length) {
                newLenght = this.marks.length + marks.length;
            }
            this.marks = Arrays.copyOf(this.marks, Math.max(newLenght,this.marks.length));
            for (int i = marksSize; i < newLenght+marksSize; i++) {
                this.marks[i] = marks[i-marksSize];
            }
            marksSize+=newLenght;
        }
    }

    public void addSubjects(String... subjects) {
        if (this.subjects == null) {
            this.subjects = subjects;
        } else {

            int newLenght = subjects.length;
            if (subjectsSize + newLenght > this.subjects.length) {
                newLenght = this.subjects.length + subjects.length;
            }
            this.subjects = Arrays.copyOf(this.subjects,Math.max(newLenght,this.subjects.length));

            for (int i = subjectsSize; i < newLenght+subjectsSize; i++) {
                this.subjects[i] = subjects[i-subjectsSize];
            }
            subjectsSize+=newLenght;
        }
    }

    public int getSubjectsCount() {
        return subjectsSize;
    }

    public int getMarksCount() {
        return marksSize;
    }

    @Override
    public String toString() {
        return String.format("Student-%1$s-%2$s", secondName, getRegistrySize());
    }
}
