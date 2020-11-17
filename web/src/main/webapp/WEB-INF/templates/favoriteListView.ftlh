<#include "navbar.ftlh">
<div class="row">
    <div class="w3-content" style="max-width:800px;margin-top:46px">
        <div class="w3-third">
            <#if start gte range>
                <a href="/favoriteList?userId=${userId}&start=${previous}&range=${range}">Poprzednie ${range}</a>
            </#if>
        </div>
        <div class="w3-third">
        </div>
        <div class="w3-third">
            <a href="/favoriteList?userId=${userId}&start=${next}&range=${range}">Następne ${range}</a>
        </div>
    </div>
</div>

<div class="row">

    <div class="w3-content" style="max-width:800px;margin-top:46px">
        <H2>Wydarzenia:</H2>
        <ul>
            <#list events as eventDto>
                <li>
                    <#include "shortEventView.ftlh">
                    <#if eventDto.isFavorite == true>
                        <form method="post"
                              action="/favoriteManager?userId=${userId}&favoriteId=${eventDto.getId()?c}&action=remove">
                            <input type="submit" value="Usuń z ulubionych"/>
                        </form>
                    <#elseif eventDto.isFavorite == false>
                        <form method="post"
                              action="/favoriteManager?userId=${userId}&favoriteId=${eventDto.getId()?c}&action=add">
                            <input type="submit" value="Dodaj do ulubionych"/>
                        </form>
                    </#if>
                </li>
            </#list>
        </ul>
    </div>
</div>
<#include "footer.ftlh">