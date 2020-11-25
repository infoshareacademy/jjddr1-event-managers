package com.infoshare.eventmanagers.utils;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.models.Event;
import com.sun.mail.smtp.DigestMD5;
import org.apache.commons.codec.digest.DigestUtils;


import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Event> saveJsonAsArray(String filePath) {
        List<EventDto> eventsDto = SaveJsonAsArray.loadEvents(filePath);
        List<Event> eventsList = new ArrayList<>();
        for (EventDto eventDto : eventsDto) {
            eventsList.add(EventDto.toEvent(eventDto));
        }
        return eventsList;
    }

    public static String encodePassword(String password) {
        return DigestUtils.md5Hex(password);
    }


}
