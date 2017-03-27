import adapter.StringAdapter;
import factory.SchoolboyFactory;
import model.Pupil;
import model.Schoolboy;
import model.Student;
import util.Pupils;

import java.io.*;

/**
 * Created by Илья on 09.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            runAdapter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runAdapter() throws IOException {
        StringAdapter stringAdapter = new StringAdapter(new String[]{"foo", "bar", "school", "ufo"});
        File file = new File("test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        stringAdapter.init(new FileOutputStream(file));
        stringAdapter.adapt();
        String[] readed = stringAdapter.readFromSource(new FileInputStream(file));
        for (String item : readed) {
            System.out.println(item);
        }
    }
}
