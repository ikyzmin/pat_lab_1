package dao;

import java.io.*;

/**
 * Created by Илья on 05.05.2017.
 */
public abstract class DAO<E> {

    protected BufferedWriter writer;
    protected BufferedReader reader;
    protected String filename;

    public DAO(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.filename = filename;
        init(filename);
    }

    abstract void init(String filename);

    public abstract E getEntity(int index) throws IOException, ClassNotFoundException;

    public abstract void saveEntity(E entity) throws IOException;
}
