import factory.SchoolboyFactory;
import model.Pupil;
import model.Schoolboy;
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

        System.out.println(properties == Properties.getInstance());
        Pupil student = Pupils.createInstance("Ivanov", 5);
        Pupils.setPupilFactory(new SchoolboyFactory());
        Pupil schoolboy = Pupils.createInstance("Vasya", 5);

        System.out.println(student);
        System.out.println(schoolboy);

        schoolboy.addRegistryRecord("new subject", 5);
        student.addRegistryRecord("new", 4);
        student.addRegistryRecord("new1", 5);
        Pupil studentClone = null;
        Pupil schoolClone = null;
        try {
            studentClone = (Pupil) student.clone();
            schoolClone = (Pupil) schoolboy.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("clone");
      //  System.out.println(studentClone);
        System.out.println(schoolClone);
        schoolboy.setSubject(0,"clone subject");
        schoolboy.setMark(0,4);
        Pupils.printRegistry(schoolboy);
        Pupils.printRegistry(schoolClone);
        Schoolboy schoolboy1 = new Schoolboy("Petrov",3);
        schoolboy1.setSubject(0,"sfs");

     //   studentClone.setMark(0, 3);
     //   studentClone.setSubject(1, "clone");

        //System.out.println(Pupils.getAverageMarkValue(studentClone));
      //  Pupils.printRegistry(studentClone);
    //    Pupils.printRegistry(student);


   /*     System.out.println(studentClone);
        System.out.println(schoolClone);
        System.out.println(student);
        System.out.println(schoolboy);*/



    }
}
