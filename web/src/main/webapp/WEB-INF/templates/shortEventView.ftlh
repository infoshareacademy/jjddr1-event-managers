<div class="w3-content" style="max-width:600px;margin-top:46px">

    <H3>
        <A href="viewOne?id=${eventDto.getId()?c}"> ${eventDto.getName()} <#if isLogged ?exists><#include "favoriteButton.ftlh"></#if></a>
    </H3>
    <p>Opis: ${eventDto.getDescShort()}</p>
    <p>Data: ${eventDto.formatLocalDateTime(eventDto.getStartDate(), "yyyy-MM-dd")}.</p>
    <p>Organizator: ${eventDto.getOrganizer().getDesignation()}</p>
    <p>Miejsce: ${eventDto.getPlace().getName()}</p>
</div>