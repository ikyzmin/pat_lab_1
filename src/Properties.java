import java.io.*;

/**
 * Created by Илья on 09.03.2017.
 */
public class Properties {

    private static Properties INSTANCE;

    private java.util.Properties properties;
    private FileOutputStream output;
    private FileInputStream input;

    private Properties() {
        try {
            output = new FileOutputStream("config.properties");
            properties = new java.util.Properties();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void storeProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        properties.store(output, null);
    }

    public String loadProperty(String key) throws IOException {
        if (input == null) {
            input = new FileInputStream("config.properties");
        }
        properties.load(input);
        return properties.getProperty(key);
    }

    public void listProperties(PrintStream console) throws IOException {
        if (properties.isEmpty()) {
            if (input == null) {
                input = new FileInputStream("config.properties");
            }
            properties.load(input);
        }
        properties.list(console);
    }


    public static Properties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Properties();
        }
        return INSTANCE;
    }
}
