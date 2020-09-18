package com.infoshare.eventmanagers;

public class Main {
    public static final EventMgrProperties SETTINGS = EventMgrProperties.getInstance();

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.run();
    }
}
