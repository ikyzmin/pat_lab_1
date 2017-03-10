import factory.SchoolboyFactory;
import model.Pupil;
import model.Student;
import util.Pupils;

import java.io.IOException;

/**
 * Created by Илья on 09.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        Properties properties = Properties.getInstance();
        try {
            properties.storeProperty("Prop1", "1");
            properties.storeProperty("Prop2", "2");
            properties.storeProperty("Prop3", "3");
            properties.storeProperty("Prop4", "4");

            properties.listProperties(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pupil student = Pupils.createInstance("Ivanov",5);
        Pupils.setPupilFactory(new SchoolboyFactory());
        Pupil schoolboy = Pupils.createInstance("Vasya",5);

        System.out.println(student);
        System.out.println(schoolboy);
        Pupil studentClone = null;
        Pupil schoolClone = null;
        try {
            studentClone = (Pupil)student.clone();
            schoolClone  = (Pupil)schoolboy.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(studentClone);
        System.out.println(schoolClone);

        schoolClone.addRegistryRecord("new subject",5);
        studentClone.addRegistryRecord("new",4);
        studentClone.addRegistryRecord("new1",5);


        System.out.println(studentClone);
        System.out.println(schoolClone);
        System.out.println(student);
        System.out.println(schoolboy);


    }
}
