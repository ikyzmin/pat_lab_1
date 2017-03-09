package factory;

import model.Pupil;

/**
 * Created by Илья on 09.03.2017.
 */
public interface PupilFactory {
    Pupil createInstance(String secondName,int size);
}
