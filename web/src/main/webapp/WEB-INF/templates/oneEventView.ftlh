<#include "navbar.ftlh">
<div class="w3-content" style="max-width:1200px;margin-top:46px">

    <H1>${eventDto.getName()}</H1>
    <p>Data: ${eventDto.getStartDate().toString()}.<br>
        Miejsce: ${eventDto.getPlace().getName()}</p>
    <p>${eventDto.getDescLong()}</p>
    <p>Organizator: ${eventDto.getOrganizer().getDesignation()}</p>

</div>
<#include "footer.ftlh">
