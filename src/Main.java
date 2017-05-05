import adapter.StringAdapter;
import dao.DAO;
import dao.DAOFactory;
import dao.SerializableStudentDAOFactory;
import dao.StringStudentDAOFactory;
import factory.SchoolboyFactory;
import factory.StudentFactory;
import model.Pupil;
import model.Schoolboy;
import model.Student;
import strategy.BubbleSort;
import strategy.InsertionSort;
import strategy.SortStrategy;
import util.Pupils;

import java.io.*;
import java.util.Random;


public class Main {

    public static final String[] pupilsNames = {"Vasya", "MITROFAN", "Dima", "Kolya", "Nastya", "Oleg", "Dmitri", "Polina", "Nikita", "Viktor"};

    public static void main(String[] args) {
        DAOFactory daoFactory;
        daoFactory = new StringStudentDAOFactory("students");
        DAO studentDAO = daoFactory.getDAO();
        Pupils.setPupilFactory(new StudentFactory());
        int selection = 5;
        Pupil pupil = null;
        for (int i = 0; i < 10; i++) {
            pupil = Pupils.createInstance(pupilsNames[i], 5);
            Random random = new Random();
            pupil.addRegistryRecord("sub", random.nextInt(4) + 1);
            pupil.addRegistryRecord("sub1", random.nextInt(4) + 1);
            pupil.addRegistryRecord("sub2", random.nextInt(4) + 1);
            pupil.addRegistryRecord("sub3", random.nextInt(4) + 1);
            pupil.addRegistryRecord("sub4", random.nextInt(4) + 1);
            if (i == selection) {
                System.out.println(pupil);
            }
            try {
                studentDAO.saveEntity(pupil);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Student student;
        try {
            student = (Student) studentDAO.getEntity(selection);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
