package dao;

import model.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Илья on 05.05.2017.
 */
public class StudentSerializableDAO extends DAO<Student> {

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private FileInputStream fis;
    private FileOutputStream fos;
    private ArrayList<Student> studentCache = new ArrayList<>();

    public StudentSerializableDAO(String filename) {
        super(filename);
        this.filename+=".std";
    }

    @Override
    void init(String filename) {
        try {
            fis = new FileInputStream(filename);
            fos = new FileOutputStream(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getEntity(int index) throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
        Student student = null;
        readAll();
        objectInputStream.close();
        return studentCache.get(index);
    }

    public void readAll() {
        try {
            studentCache.clear();
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
            studentCache=  (ArrayList)objectInputStream.readObject();
            objectInputStream.close();

        } catch (IOException e) {
            if (e instanceof EOFException) {
                return;
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntity(Student entity) throws IOException {
        readAll();
        objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        studentCache.add(entity);
        objectOutputStream.writeObject(studentCache);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
