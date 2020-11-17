<#include "navbar.ftlh">
<div class="propertiesForm">
    <div class="w3-content" style="max-width:800px;margin-top:46px">
        <form method="post" action="/properties" enctype="form-data">
            <div>
                <label for="sortOrder">Sortowanie po :</label>
                <input name="sortOrder" type="text"/>
            </div>
            <div>
                <label for="ascending">Sortowanie rosnąco (wpisz "true"), malejąco (wpisz "false")</label>
                <input name="ascending" type="text"/>
            </div>
            <div>
                <label for="dateFormat">Wpisz format daty: </label>
                <input name="dateFormat" type="text"/>
            </div>
            <div>
                <input type="submit" name="save" value="save"/><br/>
            </div>
        </form>
    </div>
</div>
<#include "footer.ftlh">
