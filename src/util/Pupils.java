package util;

import factory.PupilFactory;
import factory.StudentFactory;
import model.Pupil;

/**
 * Created by Илья on 09.03.2017.
 */
public class Pupils {

    private static PupilFactory sFactory = new StudentFactory();

    public static void setPupilFactory(PupilFactory factory) {
        sFactory = factory;
    }

    public static void printRegistry(Pupil pupil) {
        int size = pupil.getRegistrySize();
        for (int i = 0; i < size; i++) {
            System.out.println(String.format("%s : %s", pupil.getSubject(i), pupil.getMark(i)));
        }
    }

    public static Pupil createInstance(String name, int size) {
        return sFactory.createInstance(name, size);
    }

    public static float getAverageMarkValue(Pupil pupil) {
        int size = pupil.getRegistrySize();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += pupil.getMark(i);
        }
        return (float) sum / size;
    }
}
