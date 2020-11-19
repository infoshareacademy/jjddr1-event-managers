<!DOCTYPE html>
<html lang="pl">
<head>
    <#import "head.ftlh" as title>
    <@title.defaultHead title="Ustawienia"/>
    <#include "navbarCssStyle.ftlh">
</head>
<body>
<#include "navbarBody.ftlh">
<div class="propertiesForm">
    <div class="w3-content" style="max-width:800px;margin-top:46px">
        <form method="post" action="/properties" enctype="form-data">
            <div>
                <label for="sortOrder">Sortowanie po :</label>
                <input name="sortOrder" type="text"/>
            </div>
            <div>
                <label for="ascending">Sortowanie rosnaco (wpisz "true"), malejaco (wpisz "false")</label>
                <input name="ascending" type="text"/>
            </div>
            <div>
                <label for="dateFormat">Wpisz format daty: </label>
                <input name="dateFormat" type="text"/>
            </div>
            <div>
                <input type="submit" name="save" value="zapisz"/><br/>
            </div>
            <div>
                <input type="submit" name="default" value="domyslne"/><br/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<#include "footer.ftlh">
