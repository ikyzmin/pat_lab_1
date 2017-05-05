package dao;

import model.Student;

import java.io.*;

/**
 * Created by Илья on 05.05.2017.
 */
public class StudentStringDAO extends DAO<Student> {

    public StudentStringDAO(String filename) {
        super(filename);
    }

    @Override
    void init(String filename) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
        } catch (FileNotFoundException e) {
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
