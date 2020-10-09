package com.infoshare.eventmanagers.properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;

/**
 * A singleton class providing access to preferences for Event Manager app.
 * If the file app.properties does exist in the app working directory it is used as source,
 * if not default.properties is used as source of applications options.
 */


public class EventMgrProperties {
    private static EventMgrProperties instance = null;

    private static final Logger LOGGER = LogManager.getLogger(EventMgrProperties.class);
    private static final String DEFAULT_PROPERTIES = "default.properties";
    private static final String APP_PROPERTIES = "app.properties";
    private static final String DATE_FORMAT = "date.format";
    private static final String RESOURCE_PATH = getResourcePath();

    private Properties properties;

    /**
     * Constructor.
     * Loads app or default properties.
     */
    public static EventMgrProperties getInstance()
    {
        if (instance == null)
            instance = new EventMgrProperties();
        return instance;
    }

    private EventMgrProperties(){
        properties = getProperties();
    }

    /**
     * @return date format as String.
     */
    public String getDateFormatAsString() {
        return properties.getProperty(DATE_FORMAT);
    }

    /**
     * @return DateTimeFormatter object with current date format
     */
    public DateTimeFormatter getDateFormatAsDateTimeFormatter() {
        return DateTimeFormatter.ofPattern(properties.getProperty(DATE_FORMAT));
    }

    /**
     * Checks if provided string is a valid date format and sets property if it's valid.
     * If invalid, displays an error message
     */

    public boolean setDateFormat(String newFormat) {
        if (validateDateFormat(newFormat)) {
            properties.setProperty(DATE_FORMAT, newFormat);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return String object with current sorting order
     */
    public String getSortingOrder() {
        return (String) properties.get("sorting.orderby");
    }

    /**
     * Sets sortin order.
     */
    public void setSortingOrder(String newOrder) {
            properties.setProperty("sorting.orderby", newOrder.toLowerCase());
    }

    /**
     * Switches property "sorting.ascending" between "true" and "false".
     */
    public void switchSortingDirection(){
        if (getSortingDirection().equals(Ascending.TRUE.toString().toLowerCase())) {
            setSortingDirection(Ascending.FALSE.toString().toLowerCase());
        }
        else {
            setSortingDirection(Ascending.TRUE.toString().toLowerCase());
        }
    }

    public String getSortingDirection(){
        return properties.getProperty("sorting.ascending");
    }

    public boolean checkIfAscending(){
        return getSortingDirection().equals("true");

    }

    public void setSortingDirection(String direction){
        properties.setProperty("sorting.ascending", direction);
    }

    /**
     * Loads default properties and stores it in app properties
     */
    public void resetProperties() throws FileNotFoundException {
        this.properties = getPropertiesFromFile(DEFAULT_PROPERTIES);
        saveProperties();
    }

    /**
     * Displays list of properties and values
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        properties.forEach((key, value) ->
                builder.append(key).append(":\t").append(value).append("\n"));
        return builder.toString();
    }


    private boolean validateDateFormat(String newFormat) throws IllegalArgumentException {

        new SimpleDateFormat(newFormat);
        return true;
    }

    private Properties getProperties() {
        Properties newProperties = null;
        if (!Files.exists(Path.of(APP_PROPERTIES))) {
            try {
                newProperties = getPropertiesFromFile(DEFAULT_PROPERTIES);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                newProperties = getPropertiesFromFile(APP_PROPERTIES);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } return newProperties;
    }

    public void saveProperties() throws FileNotFoundException {

        try (OutputStream stream = new FileOutputStream(getResourcePath() + APP_PROPERTIES)) {
            properties.store(stream, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties getPropertiesFromFile(String properties) throws FileNotFoundException {

        Properties newProperties = new Properties();
        try (FileInputStream stream = new FileInputStream(properties)) {
            newProperties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newProperties;
    }

    private static String getResourcePath() {
        return Objects.requireNonNull(Thread.currentThread().
                getContextClassLoader().getResource("")).getPath();
    }


}

