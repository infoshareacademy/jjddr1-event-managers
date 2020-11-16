package com.infoshare.eventmanagers;

import com.infoshare.eventmanagers.dao.EventDao;
import com.infoshare.eventmanagers.utils.Utils;

public class Main {
    public static void main(String[] args) {
        EventDao eventDao = new EventDao();
        eventDao.saveAll(Utils.saveJsonAsArray("/home/szymon/Documents/InfoShare/jjddr1-event-managers/web/src/main/resources/events.json)"));
    }
}
