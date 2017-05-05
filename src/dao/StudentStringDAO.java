package dao;

import factory.StudentFactory;
import model.Student;
import util.Pupils;

import java.io.*;

/**
 * Created by Илья on 05.05.2017.
 */
public class StudentStringDAO extends DAO<Student> {

    public StudentStringDAO(String filename) {
        super(filename);
        this.filename += ".txt";
    }

    @Override
    void init(String filename) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getEntity(int index) throws IOException {
        Pupils.setPupilFactory(new StudentFactory());
        int registrySize = 0;
        int linesToSkip = 0;
        registrySize = Integer.valueOf(reader.readLine());
        linesToSkip = 2 * registrySize + 1;

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < linesToSkip; j++) {
                reader.readLine();
            }
            registrySize = Integer.valueOf(reader.readLine());
            linesToSkip = 2 * registrySize + 1;
        }
        Student student = (Student) Pupils.createInstance(reader.readLine(), registrySize);
        for (int i = 0; i < registrySize; i++) {
            student.addRegistryRecord(reader.readLine(), Integer.valueOf(reader.readLine()));
        }
        return student;
    }

    @Override
    public void saveEntity(Student entity) throws IOException {
        writer.write(String.valueOf(entity.getRegistrySize()));
        writer.newLine();
        writer.write(entity.getSecondName());
        writer.newLine();
        for (int i = 0; i < entity.getRegistrySize(); i++) {
            writer.write(entity.getSubject(i));
            writer.newLine();
            writer.write(String.valueOf(entity.getMark(i)));
            writer.newLine();
        }
        writer.flush();
    }
}
