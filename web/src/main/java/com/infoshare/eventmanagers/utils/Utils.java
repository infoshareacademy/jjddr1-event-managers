package com.infoshare.eventmanagers.utils;

import com.infoshare.eventmanagers.dto.EventDto;


import java.util.List;

public class Utils {

    public static List<EventDto> saveJsonAsArray(String filePath) {
        return SaveJsonAsArray.loadEvents(filePath);
    }

}
