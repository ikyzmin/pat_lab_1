package strategy;

import model.Pupil;
import util.Pupils;

public class BubbleSort implements SortStrategy {
    @Override
    public Pupil[] sort(Pupil[] pupils) {
        float temp;
        Pupil tempPupil;
        Pupil [] sortedPupils = pupils;
        float[] averageMarks = getAverageMarksArray(pupils);
        for (int i = 0; i < averageMarks.length; i++) {
            for (int j = 1; j < (averageMarks.length - i); j++) {
                if (averageMarks[j - 1] > averageMarks[j]) {
                    //swap elements
                    tempPupil = sortedPupils[j - 1];
                    temp = averageMarks[j - 1];
                    sortedPupils[j - 1] = sortedPupils[j];
                    averageMarks[j - 1] = averageMarks[j];
                    sortedPupils[j] = tempPupil;
                    averageMarks[j] = temp;
                }

            }
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
