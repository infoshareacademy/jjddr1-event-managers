<#include "navbar.ftlh">
<div class="w3-content" style="max-width:800px;margin-top:46px">

    <H1>${eventDto.getDescShort()}</H1>
    <p>Data: ${eventDto.getStartDate().toString()}. Organizator: ${eventDto.getOrganizer().getDesignation()}</p>
    <p>Miejsce: ${eventDto.getPlace().getName()}</p>

</div>
<#include "footer.ftlh">
