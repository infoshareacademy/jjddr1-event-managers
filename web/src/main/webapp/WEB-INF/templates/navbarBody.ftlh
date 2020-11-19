

<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-black w3-card">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
           href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i
                    class="fa fa-bars"></i></a>

        <a href="#home" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="/list" class="w3-bar-item w3-button w3-padding-large w3-hide-small">WYDARZENIA</a>
        <a href="/favoriteList?start=0&range=10" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ULUBIONE</a>
        <a href="/properties" class="w3-bar-item w3-button w3-padding-large w3-hide-small">USTAWIENIA</a>
        <a href="#kontakt" class="w3-bar-item w3-button w3-padding-large w3-hide-small">KONTAKT</a>
        <#if Session?exists>

        <a href="/properties" class="w3-bar-item w3-button w3-padding-large w3-hide-small"> ${Session.get("id")}</a>
        </#if>
        <a href="/properties" class="w3-bar-item w3-button w3-padding-large w3-hide-small">USTAWIENIA</a>
        <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
                    class="fa fa-search"></i></a>
        <a href="/login" class="w3-bar-item w3-button w3-padding-large w3-hover-red w3-hide-small  w3-right">Zaloguj</a>
        <a href="/register" class="w3-bar-item w3-button w3-padding-large w3-hover-red w3-hide-small  w3-right">Zarejestruj</a>

    </div>
</div>

<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
    <a href="#login" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">BAND</a>
    <a href="#wydarzenia" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">TOUR</a>
    <a href="#kontakt" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">CONTACT</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">HOME</a>
</div>