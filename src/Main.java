import factory.SchoolboyFactory;
import model.Pupil;
import model.Student;
import util.Pupils;

import java.io.IOException;

/**
 * Created by ���� on 09.03.2017.
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
        student


    }
}