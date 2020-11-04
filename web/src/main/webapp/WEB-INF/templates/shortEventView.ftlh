<div class="w3-content" style="max-width:600px;margin-top:46px">

    <H3><A href ="viewOne?id=${eventDto.getId()?c}"> ${eventDto.getName()}</a></H3>
    <p>Opis: ${eventDto.getDescShort()}</p>
    <p>Data: ${eventDto.getStartDate().toString()}.<br>Organizator: ${eventDto.getOrganizer().getDesignation()}</p>
    <p>Miejsce: ${eventDto.getPlace().getName()}</p>
</div>