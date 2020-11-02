package com.infoshare.eventmanagers.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.dto.OrganizerDto;
import com.infoshare.eventmanagers.dto.PlaceDto;
import com.infoshare.eventmanagers.dto.TicketDto;
import com.infoshare.eventmanagers.models.jsonModels.JsonEvent;
import com.infoshare.eventmanagers.models.jsonModels.JsonOrganizer;
import com.infoshare.eventmanagers.models.jsonModels.JsonPlace;
import com.infoshare.eventmanagers.models.jsonModels.JsonTicket;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SaveJsonAsArray {
    private static final ObjectMapper mapper = new ObjectMapper();

    static List<EventDto> loadEvents(String filePath) {
        List<JsonEvent> events = getJsonEvents(filePath);
        return parserJsonEventsListToEventsDtoList(events);
    }

    private static List<JsonEvent> getJsonEvents(String filePath) {
        List<JsonEvent> events = new ArrayList<>();
        if (Files.exists(Paths.get(filePath))) {
            try {
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                events = Arrays.asList(mapper.reader().forType(JsonEvent[].class).readValue(new URL("file:" + filePath)));

            } catch (SecurityException | OutOfMemoryError | IOException e) {
                e.printStackTrace();
            }
        }
        return events;
    }

    private static List<EventDto> parserJsonEventsListToEventsDtoList(List<JsonEvent> jsonEvents) {
        List<EventDto> eventDtoList = new ArrayList<>();
        for (JsonEvent jsonEvent : jsonEvents) {
            EventDto eventDto = new EventDto();
            eventDto.setName(jsonEvent.getName().replaceAll("\\s{2,}", " ").replaceAll("\\<.*?\\>", "").trim());
            eventDto.setId(Integer.parseInt(jsonEvent.getId()));
            eventDto.setPlace(fromJsonPlaceToPlaceDto(jsonEvent.getPlace()));
            eventDto.setStartDate(LocalDateTime.parse(jsonEvent.getStartDate().substring(0,16)));
            eventDto.setEndDate(LocalDateTime.parse(jsonEvent.getEndDate().substring(0,16)));
            eventDto.setUrl(jsonEvent.getUrls()!=null?jsonEvent.getUrls().getWww():null);
            eventDto.setAttachments(jsonEvent.getAttachments().length>0?jsonEvent.getAttachments()[0].getFileName():null);
            eventDto.setDescShort(jsonEvent.getDescShort().replaceAll("\\s{2,}", " ").replaceAll("\\<.*?\\>", "").trim());
            eventDto.setDescLong(jsonEvent.getDescLong().replaceAll("\\s{2,}", " ").replaceAll("\\<.*?\\>", "").trim());
            eventDto.setCategoryId(jsonEvent.getCategoryId());
            eventDto.setOrganizer(fromJsonOrganizerToOrganizerDto(jsonEvent.getOrganizer()));
            eventDto.setActive(jsonEvent.getActive());
            eventDto.setTicket(fromJsonTicketToTicketDto(jsonEvent.getTickets()));
            eventDtoList.add(eventDto);
        }


        return eventDtoList;
    }

    private static PlaceDto fromJsonPlaceToPlaceDto(JsonPlace jsonPlace) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(Integer.parseInt(jsonPlace.getId()));
        placeDto.setName(jsonPlace.getName());
        placeDto.setSubName(jsonPlace.getSubName());
        return placeDto;

    }

    private static OrganizerDto fromJsonOrganizerToOrganizerDto(JsonOrganizer jsonOrganizer) {
        OrganizerDto organizerDto = new OrganizerDto();
        organizerDto.setId(jsonOrganizer.getId());
        organizerDto.setDesignation(jsonOrganizer.getDesignation());
        return organizerDto;
    }

    private static TicketDto fromJsonTicketToTicketDto(JsonTicket jsonTicket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setType(jsonTicket.getType());
        return ticketDto;
    }
}
