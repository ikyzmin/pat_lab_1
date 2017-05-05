package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Илья on 05.05.2017.
 */
public abstract class DAO<E> {

    protected BufferedWriter writer;
    protected BufferedReader reader;

    public DAO(String filename){
        init(filename);
    }

    abstract void init(String filename);

    public abstract E getEntity(int index);
    public abstract void saveEntity(E entity);
}
