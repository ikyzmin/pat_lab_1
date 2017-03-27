package model;

/**
 * Created by Илья on 27.03.2017.
 */
public class PupilSyncWrapper implements Pupil {

    public static PupilSyncWrapper wrap(Pupil p){
        return new PupilSyncWrapper(p);
    }

    private Pupil pupil;

    private PupilSyncWrapper(Pupil p){
        pupil = p;
    }

    @Override
    public void addRegistryRecord(String subject, int mark) {
        synchronized (this){
            pupil.addRegistryRecord(subject,mark);
        }
    }

    @Override
    public String getSecondName() {
        return pupil.getSecondName();
    }

    @Override
    public int getRegistrySize() {
        return pupil.getRegistrySize();
    }

    @Override
    public int getMark(int index) {
        return pupil.getMark(index);
    }

    @Override
    public void setSubject(int index, String value) {
        synchronized (this){
            pupil.setSubject(index,value);
        }
    }

    @Override
    public void setMark(int index, int value) {
        synchronized (this){
            pupil.setMark(index, value);
        }
    }

    @Override
    public String getSubject(int index) {
        return pupil.getSubject(index);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return pupil.clone();
    }
}
