package factory;

import model.Pupil;
import model.Student;

/**
 * Created by Илья on 09.03.2017.
 */
public class StudentFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String secondName, int size) {
        return new Student(secondName,size);
    }
}
