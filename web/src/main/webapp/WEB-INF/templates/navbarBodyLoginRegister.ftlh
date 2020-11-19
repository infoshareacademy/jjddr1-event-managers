

<!-- Navbar -->
<div class="nav w3-top">
    <div class="w3-bar w3-black w3-card">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
           href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i
                    class="fa fa-bars"></i></a>

        <a href="#home" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="/list" class="w3-bar-item w3-button w3-padding-large w3-hide-small">WYDARZENIA</a>
        <a href="#kontakt" class="w3-bar-item w3-button w3-padding-large w3-hide-small">KONTAKT</a>
        <#if isLogged?exists>
            <a href="/favoriteList?start=0&range=10" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ULUBIONE</a>
            <a href="/properties" class="w3-bar-item w3-button w3-padding-large w3-hide-small">USTAWIENIA</a>
            <a href="/logout" class="w3-bar-item w3-button w3-padding-large w3-hover-red w3-hide-small  w3-right">Wyloguj</a>
        <#else>
            <a href="/login"
               class="w3-bar-item w3-button w3-padding-large w3-hover-red w3-hide-small  w3-right">Zaloguj</a>
            <a href="/register" class="w3-bar-item w3-button w3-padding-large w3-hover-red w3-hide-small  w3-right">Zarejestruj</a>
        </#if>

        <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
                    class="fa fa-search"></i></a>


    </div>
</div>

