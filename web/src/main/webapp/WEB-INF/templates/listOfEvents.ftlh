<#include "navbar.ftlh">
<div class="w3-content" style="max-width:800px;margin-top:46px">
    <ul>
        <#list events as eventDto>
            <li><#include "shortEventView.ftlh"></li>
        </#list>
    </ul>
</div>
<#include "footer.ftlh">