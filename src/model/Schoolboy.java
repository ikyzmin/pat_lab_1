package model;

import java.util.Arrays;

/**
 * Created by Илья on 09.03.2017.
 */
public class Schoolboy implements Pupil {

    private String secondName;
    private Register[] registry;

    public Schoolboy(String secondName, int size) {
        registry = new Register[size];
        this.secondName = secondName;
    }

    public Register[] getRegistry() {
        return registry;
    }

    public void setRegistry(Register[] registry) {
        this.registry = registry;
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
    public String getSubject(int index) {
        return registry[index].getSubject();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void addMarks(Register... registers) {
        if (this.registry == null) {
            this.registry = registers;
        } else {
            int prevLength = this.registry.length;
            int newLenght = this.registry.length + registers.length;
            this.registry = Arrays.copyOf(this.registry, newLenght);
            for (int i = prevLength; i < newLenght; i++) {
                this.registry[i] = registers[i - prevLength];
            }
        }
    }

}
