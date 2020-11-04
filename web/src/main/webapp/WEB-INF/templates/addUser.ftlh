<!DOCTYPE html>
<#import "common.ftlh" as common>
<html>
<head>
    <@common.defaultHead title = "Home"/>
</head>
<body>
<H1>${eventDto.getDescShort()}</H1>
<p>Data: ${eventDto.getStartDate().toString()}. Organizator: ${eventDto.getOrganizer().getDesignation()}</p>
<p>Miejsce: ${eventDto.getPlace().getName()}</p>
<p>${eventDto.getDescLong()}</p>

</body>
</html>