package dao;

import model.Student;

import java.io.*;

/**
 * Created by Илья on 05.05.2017.
 */
public class StudentSerializableDAO extends DAO<Student> {

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    public StudentSerializableDAO(String filename) {
        super(filename);
    }

    @Override
    void init(String filename) {
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getEntity(int index) {
        return null;
    }

    @Override
    public void saveEntity(Student entity) {

    }
}
