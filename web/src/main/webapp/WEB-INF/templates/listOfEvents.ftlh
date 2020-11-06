<#include "navbar.ftlh">
<!-- Container starts -->
<div class=w3-content style="max-width: 800px; margin-top: 46px">
    <H2>Wydarzenia:</H2>
    <div class=w3-row>
        <div class=w3-third>
            <#if start gte range>
                <a href="/list?start=${previous}&range=${range}">Poprzednie ${range}</a>
            </#if>&nbsp
        </div>
        <div class="w3-third">
            &nbsp
        </div>
        <div class="w3-third" style="text-align: right">
            <#if next lt numberOfEvents>
            <a href="/list?start=${next}&range=${range}">Następne ${range}</a>
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