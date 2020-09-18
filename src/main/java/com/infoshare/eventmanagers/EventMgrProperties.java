package com.infoshare.eventmanagers;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * Provides access to preferences for Event Manager app.
 * If the file app.properties does exist in the app working directory it is used as source,
 * if not default.properties is used as source of applications options.
 */

public class EventMgrProperties {

    private final Properties properties;
    private final String DEFAULT_PROPERTIES = "default.properties";
    private final String APP_PROPERTIES = "app.properties";
    private final String RESOURCE_PATH = getResourcePath();
    public EventMgrProperties() {
        this.properties = getProperties();
    }

    /**
     * Loads default properties and stores it in app properties
     */
    public void resetProperties() {
        getPropertiesFromFile(DEFAULT_PROPERTIES);
        saveProperties();
    }

    /**
     * @return DateTimeFormatter object with current date format
     */
    public DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern(properties.getProperty("date.format"));
    }

    /**
     * Checks if provided string is a valid date format and sets property if it's valid.
     * If invalid, displays an error message
     */

    public void setDateFormat(String newFormat) {
        if (validateDateFormat(newFormat)) {
            properties.setProperty("date.format", newFormat);
        } else {
            System.out.println("Invalid date format");
        }
    }

    /**
     * @return String object with current sorting order
     */
    public String getSortingOrder() {
        return (String) properties.get("sorting.order");
    }

    /**
     * Checks if provided string is a valid sorting order and sets property if valid.
     * If invalid, displays an error message.
     */
    public void setSortingOrder(String newOrder) {
        if (validateSortingOrder(newOrder)) {
            properties.setProperty("sorting.order", newOrder);
        } else {
            System.out.println("Invalid sorting order");
        }
    }

    /**
     * Displays list of properties and values
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        properties.forEach((key, value) ->
                builder.append(key + ":\t" + value + "\n").toString());
        return builder.toString();
    }

    private boolean validateSortingOrder(String newSortingOrder) {
        for (SORTING_ORDER value : SORTING_ORDER.values()) {
            if (value.toString().equals(newSortingOrder)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateDateFormat(String newFormat) {
        DateFormat df = new SimpleDateFormat();
        try {
            df.parse(newFormat);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private Properties getProperties() {

        if (!Files.exists(Path.of(RESOURCE_PATH + APP_PROPERTIES))) {
            return getPropertiesFromFile(DEFAULT_PROPERTIES);
        } else {
            return getPropertiesFromFile(APP_PROPERTIES);
        }
    }

    public void saveProperties() {

        try (OutputStream stream = new FileOutputStream(getResourcePath() + APP_PROPERTIES)) {
            properties.store(stream, "");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties getPropertiesFromFile(String properties) {

        Properties eventMgrProps = new Properties();
        try (FileInputStream stream = new FileInputStream(getResourcePath() + properties)) {
            eventMgrProps.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventMgrProps;
    }

    private String getResourcePath() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    enum SORTING_ORDER {
        host,
        date
    }


}

