import adapter.StringAdapter;
import factory.SchoolboyFactory;
import model.Pupil;
import model.Schoolboy;
import strategy.BubbleSort;
import strategy.InsertionSort;
import strategy.SortStrategy;
import util.Pupils;

import java.io.*;
import java.util.Random;


public class Main {

    public static final String[] pupilsNames = {"Vasya", "MITROFAN", "Dima", "Kolya", "Nastya", "Oleg", "Dmitri", "Polina", "Nikita", "Viktor"};

    public static void main(String[] args) {
        try {
            runAdapter();
            Pupils.setPupilFactory(new SchoolboyFactory());
            Schoolboy schoolboy = (Schoolboy) Pupils.createInstance("Vasya", 5);
            schoolboy.addRegistryRecord("sub", 4);
            schoolboy.addRegistryRecord("sub1", 5);
            schoolboy.addRegistryRecord("sub2", 2);
            schoolboy.addRegistryRecord("sub3", 3);
            Schoolboy.SchoolboyIterator iterator = schoolboy.iteator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            Random random = new Random();

            Pupil[] pupils = new Pupil[pupilsNames.length];
            for (int i = 0; i < pupilsNames.length; i++) {
                pupils[i] = Pupils.createInstance(pupilsNames[i], 5);
                pupils[i].addRegistryRecord("sub", random.nextInt(4) + 1);
                pupils[i].addRegistryRecord("sub1", random.nextInt(4) + 1);
                pupils[i].addRegistryRecord("sub2", random.nextInt(4) + 1);
                pupils[i].addRegistryRecord("sub3", random.nextInt(4) + 1);
                pupils[i].addRegistryRecord("sub4", random.nextInt(4) + 1);
            }
            System.out.println("before sort:");
            for (int i = 0; i < pupils.length; i++) {
                System.out.println(pupils[i]);
            }
            SortStrategy sortStrategy = new BubbleSort();
            Pupil[] sortedPupils;
            sortedPupils = sortStrategy.sort(pupils);
            System.out.println("after bubble sort:");
            for (int i = 0; i < sortedPupils.length; i++) {
                System.out.println(sortedPupils[i]);
            }

            SortStrategy insertionSort = new InsertionSort();
            Pupil[] insertionSortedPupils;
            insertionSortedPupils = insertionSort.sort(pupils);
            System.out.println("after insertion sort:");
            for (int i = 0; i < insertionSortedPupils.length; i++) {
                System.out.println(insertionSortedPupils[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runAdapter() throws IOException {
        StringAdapter stringAdapter = new StringAdapter();
        File file = new File("test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        stringAdapter.init(System.out);//new FileOutputStream(file));
        stringAdapter.adapt(new String[]{"foo", "bar", "school", "ufo"});
    }
}
