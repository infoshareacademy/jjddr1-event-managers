<link href="/styles/favorite.css" rel="stylesheet">
<#if eventDto.isFavorite == true>
    <form method="post"
          action="/favoriteManager?userId=${userId}&favoriteId=${eventDto.getId()?c}&action=remove">
        <input type="submit" value="Usuń z ulubionych" class="fav-button" id="remove"/>
    </form>
<#elseif eventDto.isFavorite == false>
    <form method="post"
          action="/favoriteManager?userId=${userId}&favoriteId=${eventDto.getId()?c}&action=add">
        <input type="submit" class="fav-button" id="add"/>
    </form>
</#if>