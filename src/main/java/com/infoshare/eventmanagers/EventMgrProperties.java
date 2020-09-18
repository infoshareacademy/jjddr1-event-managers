package com.infoshare.eventmanagers;


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
 * Provides access to preferences for Event Manager app.
 * If the file app.properties does exist in the app working directory it is used as source,
 * if not default.properties is used as source of applications options.
 */


public class EventMgrProperties {

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
    public EventMgrProperties() {
        this.properties = getProperties();
    }

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
    public void setDateFormat(String newFormat) {
        if (validateDateFormat(newFormat)) {
            properties.setProperty(DATE_FORMAT, newFormat);
        } else {
            LOGGER.error("Niepoprawny format daty");
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
            properties.setProperty("sorting.order", newOrder.toLowerCase());
        } else {
            LOGGER.error("Podano niepoprawny porządek sortowania");
        }
    }

    /**
     * Loads default properties and stores it in app properties
     */
    public void resetProperties() {
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

    private boolean validateSortingOrder(String newSortingOrder) {
        for (SortingOrder value : SortingOrder.values()) {
            if (value.toString().equals(newSortingOrder)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateDateFormat(String newFormat) {

        try {
            new SimpleDateFormat(newFormat);
        } catch (IllegalArgumentException e) {
            LOGGER.warn(e.getMessage());
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
            LOGGER.error("Nie znaleziono pliku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties getPropertiesFromFile(String properties) {

        Properties newProperties = new Properties();
        try (FileInputStream stream = new FileInputStream(getResourcePath() + properties)) {
            newProperties.load(stream);
        } catch (FileNotFoundException e) {
            LOGGER.error("Nie znaleziono pliku.");
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

