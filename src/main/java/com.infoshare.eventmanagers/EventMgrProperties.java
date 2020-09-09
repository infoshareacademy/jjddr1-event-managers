package main.java.com.infoshare.eventmanagers;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class EventMgrProperties {

    private static final String DEFAULT_PROPERTIES = "default.properties";
    private static String resourcePath;

    static Properties eventMgrProps = new Properties();

    public static Properties getProperties() {
        resourcePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        System.out.println(resourcePath + DEFAULT_PROPERTIES);
        {
            try (FileInputStream stream = new FileInputStream(resourcePath + DEFAULT_PROPERTIES)) {
                eventMgrProps.load(stream);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return eventMgrProps;

    }
}

