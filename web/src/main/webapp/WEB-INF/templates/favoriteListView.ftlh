<#include "navbar.ftlh">
<div class=w3-content style="max-width: 800px; margin-top: 46px">
    <H2>Ulubione:</H2>
    <div class=w3-row>
        <div class=w3-third>
<#include "navbarCssStyle.ftlh">
<div class="row">
    <div class="w3-content" style="max-width:800px;margin-top:46px">
        <div class="w3-third">
            <#if start gte range>
            <a href="/favoriteList?userId=${userId}&start=${previous}&range=${range}">Poprzednie ${range}</a>
            </#if>&nbsp
        </div>
        <div class="w3-third">
        </div>
        <div class="w3-third" style="text-align: right">
            <#if next lt numberOfFavorites>
            <a href="/favoriteList?userId=${userId}&start=${next}&range=${range}">Następne ${range}</a>
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
