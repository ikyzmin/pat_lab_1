package strategy;

import model.Pupil;
import util.Pupils;

/**
 * Created by Илья on 08.04.2017.
 */
public class InsertionSort implements SortStrategy {
    @Override
    public Pupil[] sort(Pupil[] pupils) {
        Pupil[] sortedPupils = pupils;
        float[] averageMarks = getAverageMarksArray(pupils);
        for (int i = 1; i < averageMarks.length; i++) {
            float key = averageMarks[i];
            Pupil pupil = sortedPupils[i];
            int k = i - 1;
            while (k >= 0 && averageMarks[k] > key) {
                averageMarks[k + 1] = averageMarks[k];
                sortedPupils[k + 1] = sortedPupils[k];
                k--;
            }
            averageMarks[k + 1] = key;
            sortedPupils[k + 1] = pupil;
        }
        return sortedPupils;
    }

    private float[] getAverageMarksArray(Pupil[] pupils) {
        float[] averageMarks = new float[pupils.length];
        for (int i = 0; i < pupils.length; i++) {
            averageMarks[i] = Pupils.getAverageMarkValue(pupils[i]);
        }
        return averageMarks;
    }
}
