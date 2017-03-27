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

    public StringAdapter(String[] adaptee) {
        this.adaptee = adaptee;
    }

    public void init(OutputStream stream) {
        target = stream;
    }

    public void adapt() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(target);
        PrintWriter writer = new PrintWriter(outputStreamWriter);
        for (String item : adaptee) {
            writer.println(item);
        }
        writer.close();
    }

    public String[] readFromSource(InputStream source) throws IOException {
        if (source == null) return null;
        InputStreamReader inputStreamReader = new InputStreamReader(source);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        ArrayList<String> lines = new ArrayList<>();
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (adaptee == null) {
                lines.add(line);
            } else {
                adaptee[i] = line;
                i++;
            }
        }
        if (adaptee == null) {
            adaptee = (String[]) lines.toArray();
        }
        bufferedReader.close();
        return adaptee;
    }

}
