package adapter;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by Илья on 27.03.2017.
 */
public class StringAdapter {

    private OutputStream target;
    private String[] adaptee;

    public StringAdapter() {
    }

    public void init(OutputStream stream) {
        target = stream;
    }

    public void adapt(String[] adaptee) throws IOException {
        for (String item : adaptee) {
            target.write(item.getBytes());
            target.write('\n');
        }
        //target.close();
    }


}
