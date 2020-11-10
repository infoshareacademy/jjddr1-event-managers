<!DOCTYPE html>
<#import "head.ftlh" as common>
<html>
<head>
    <@common.defaultHead title = "Ustawienia użytkownika"/>
</head>
<body>
<form method="post" action="/properties" enctype="form-data">

    <label for="sortOrder">Sortowanie po:</label>
    <input name="sortOrder" type="text"/>

    <label for="ascending">Sortowanie rosnąco (wpisz "true"), malejąco (wpisz "false")</label>
    <input name="ascending" type="text"/>

    <label for="dateFormat">Wpisz format daty: </label>
    <input name="dateFormat" type="text"/>

    <input type="submit" name="save" value="save"/><br/>
</form>
</body>
<#import "footer.ftlh" as common>
</html>