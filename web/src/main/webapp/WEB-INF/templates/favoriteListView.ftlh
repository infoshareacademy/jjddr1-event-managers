<#include "navbarCssStyle.ftlh">
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
                    <form method="post" action="/favoriteManager?userId=${userId}&favoriteId=${eventDto.getId()?c}&action=remove">
                        <input type="submit" value="Usuń z ulubionych" />
                    </form>
<#--                    <button type="submit" onclick="" formmethod="post" formaction="/favoriteManager?userId=${userId}&favoriteId=${eventDto.getId()?c}&action=remove">Usuń z ulubionych</button>-->
                </li>
            </#list>
        </ul>
    </div>
</div>
<#include "footer.ftlh">