package com.infoshare.eventmanagers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;

enum SORTING_ORDER {
    host,
    date
}

/**
 * Provides access to preferences for Event Manager app.
 * If the file app.properties does exist in the app working directory it is used as source,
 * if not default.properties is used as source of applications options.
 */

public class EventMgrProperties {
    private final static String MENU_LINE = getLine();
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static Logger LOGGER = LogManager.getLogger(EventMgrProperties.class);
    private final String DEFAULT_PROPERTIES = "default.properties";
    private final String APP_PROPERTIES = "app.properties";
    private final String RESOURCE_PATH = getResourcePath();
    private final Properties properties;

    /**
     * Constructor.
     * Loads app or default properties.
     */
    public EventMgrProperties() {
        this.properties = getProperties();
    }

    /**
     * Displays main properties menu
     */
    public void displayPropertiesMenu() {
        while (true) {
            LOGGER.info("\n4########## Settings Menu ##########");
            LOGGER.info("Current settings:\n");
            LOGGER.info(this.toString());
            LOGGER.info("""
                    1: Change sorting order
                    2: Change date format
                    3: Reset to default
                    4: Save settings
                    Press [ENTER] to return to previous menu.""");
            LOGGER.info(MENU_LINE);
            LOGGER.info("Choose option:");
            String userInput = SCANNER.nextLine();
            if (userInput.equals("")) return;
            else
                try {
                    int input = Integer.parseInt(userInput);
                    switch (input) {
                        case 1 -> displaySortingOrderMenu();
                        case 2 -> displayDateFormatMenu();
                        case 3 -> {
                            resetProperties();
                            LOGGER.info("Settings reset to default.");
                        }
                        case 4 -> {
                            saveProperties();
                            LOGGER.info("Settings saved.");
                        }
                        default -> {
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    LOGGER.warn("Invalid input");
                }
        }
    }

    /**
     * Displays menu to change the sorting order
     */
    private void displaySortingOrderMenu() {
        while (true) {
            LOGGER.info("Choose sorting order");
            LOGGER.info("Currently sorting by: " + getSortingOrder());
            LOGGER.info("""
                    Choose option:
                    1: Sort by host
                    2: Sort by date
                    Press [ENTER] to return to previous menu.""");
            LOGGER.info(MENU_LINE);
            LOGGER.info("Choose option:");
            String userInput = SCANNER.nextLine();
            if (userInput.equals("")) return;
            else
                try {
                    int input = Integer.parseInt(userInput);
                    switch (input) {
                        case 1 -> {
                            setSortingOrder(SORTING_ORDER.host.toString());
                            return;
                        }
                        case 2 -> {
                            setSortingOrder(SORTING_ORDER.date.toString());
                            return;
                        }
                        default -> {
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    LOGGER.warn("Invalid input");
                }
        }
    }

    /**
     * Display window to change the date format
     */
    private void displayDateFormatMenu() {
        while (true) {
            LOGGER.info("Change date format");
            LOGGER.info("Current date format is: " + properties.getProperty("date.format"));
            LOGGER.info(MENU_LINE);
            LOGGER.info("Enter new date format or press enter to return to previous menu.");
            SCANNER.reset();
            String userInput = SCANNER.nextLine();
            if (userInput.equals("")) {
                return;
            } else {
                setDateFormat(userInput);
            }
        }
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
            LOGGER.info("Invalid sorting order");
        }
    }

    /**
     * Displays list of properties and values
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        properties.forEach((key, value) ->
                builder.append(key + ":\t" + value + "\n"));
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



    private static String getLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("─");
        }
        return sb.toString();
    }
}

