package model;

import java.util.Iterator;

/**
 * Created by Илья on 08.04.2017.
 */
public class SchoolboyIterator implements Iterator<Schoolboy.Register> {


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
