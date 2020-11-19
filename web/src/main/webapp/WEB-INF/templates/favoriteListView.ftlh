<!DOCTYPE html>
<html lang="pl">
<head>
    <#import "head.ftlh" as title>
    <@title.defaultHead title="home"/>
    <#include "navbarCssStyle.ftlh">
</head>
<body>
<#include "navbarBody.ftlh">
<div class=w3-content style="max-width: 800px; margin-top: 46px">
    <H2>Ulubione:</H2>
    <div class=w3-row>
        <div class=w3-third>
<div class="row">
    <div class="w3-content" style="max-width:800px;margin-top:46px">
        <div class="w3-third">
            <#if start gte range>
            <a href="/favoriteList?start=${previous}&range=${range}">Poprzednie ${range}</a>
            </#if>&nbsp
        </div>
        <div class="w3-third">
        </div>
        <div class="w3-third" style="text-align: right">
            <#if next lt numberOfFavorites>
            <a href="/favoriteList?start=${next}&range=${range}">Następne ${range}</a>
            </#if>&nbsp
        </div>
    </div>

    <div class="w3-container">
        <ul>
            <#list events as eventDto>
                <li><#include "shortEventView.ftlh"></li>
            </#list>
        </ul>
    </div>
</div>
<#include "footer.ftlh">
</body>
</html>

