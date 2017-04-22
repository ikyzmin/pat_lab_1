package model;

import util.Pupils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Илья on 09.03.2017.
 */
public class Schoolboy implements Pupil {

    private String secondName;
    private Register[] registry;
    private int registrySize;

    public Schoolboy(String secondName, int size) {
        registry = new Register[size];
        for (int i = 0; i < registry.length; i++) {
            registry[i] = new Register("", 0);
        }
        this.secondName = secondName;
    }

    public Register[] getRegistry() {
        return registry;
    }

    public void setRegistry(Register[] registry) {
        this.registry = registry;
        registrySize = registry.length;
    }


    @Override
    public void addRegistryRecord(String subject, int mark) {
        addMarks(new Register(subject, mark));
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public int getRegistrySize() {
        return registry.length;
    }

    @Override
    public int getMark(int index) {
        return registry[index].getMark();
    }

    @Override
    public void setSubject(int index, String value) {
        registry[index].setSubject(value);
    }

    @Override
    public void setMark(int index, int value) {
        registry[index].setMark(value);
    }

    @Override
    public String getSubject(int index) {
        return registry[index].getSubject();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Schoolboy clone = (Schoolboy) super.clone();
        clone.registry = new Register[this.registry.length];
        clone.registrySize = 0;
        for (int i = 0; i < getRegistrySize(); i++) {
            clone.addRegistryRecord(getRegistry()[i].getSubject(), getRegistry()[i].getMark());
        }

        return clone;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void addMarks(Register... registers) {
        if (this.registry == null) {
            this.registry = registers;
        } else {
            int newLenght = registers.length;
            if (registrySize + newLenght > this.registry.length) {
                newLenght = this.registry.length + registers.length;
            }
            this.registry = Arrays.copyOf(this.registry, Math.max(this.registry.length, newLenght));
            for (int i = registrySize; i < newLenght + registrySize; i++) {
                this.registry[i] = registers[i - registrySize];
            }
            registrySize += newLenght;
        }
    }

    @Override
    public String toString() {
        return String.format("Schoolboy-%1$s-%2$s", secondName, Pupils.getAverageMarkValue(this));
    }

    class Register {


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

        @Override
        public String toString() {
            return String.format("Subject: %s\nMark: %s", subject, mark);
        }
    }

    public SchoolboyIterator iteator() {
        return new SchoolboyIterator(this);
    }

    public class SchoolboyIterator implements Iterator<Register> {


        private Schoolboy schoolboy;
        private int index = 0;

        public SchoolboyIterator(Schoolboy schoolboy) {
            this.schoolboy = schoolboy;
        }

        @Override
        public boolean hasNext() {
            return index >= 0 && index < schoolboy.getRegistrySize();
        }

        @Override
        public Schoolboy.Register next() {
            Schoolboy.Register value = schoolboy.getRegistry()[index];
            index++;
            return value;
        }
    }

}
