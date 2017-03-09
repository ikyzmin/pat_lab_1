package factory;

import model.Pupil;
import model.Schoolboy;

/**
 * Created by ���� on 09.03.2017.
 */
public class SchoolboyFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String secondName, int size) {
        return new Schoolboy(secondName,size);
    }
}
