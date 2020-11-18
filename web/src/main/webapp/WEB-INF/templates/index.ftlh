<!DOCTYPE html>
<html lang="pl">
<head>
    <#import "head.ftlh" as title>
    <@title.defaultHead title="home"/>
    <#include "navbarCssStyle.ftlh">
</head>
<body>
<#include "navbarBody.ftlh">
<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

    <!-- Automatic Slideshow Images -->
    <div class="mySlides w3-display-container w3-center">
        <img src="images/pic1.jpg" style="width:100%">
        <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h3>PGE ARENA GDAŃSK</h3>
            <h4>25 grudnień 2020</h4>
            <p><b>Super impreza na największym stadionie w Trójmieście!</b></p>
        </div>
    </div>
    <div class="mySlides w3-display-container w3-center">
        <img src="images/pic2.jpg" style="width:100%">
        <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h3>Spodek w Katowicach</h3>
            <h4>1 luty 2020</h4>
            <p><b>Festiwal Jazz Music</b></p>
        </div>
    </div>
    <div class="mySlides w3-display-container w3-center">
        <img src="images/pic4.jpg" style="width:100%">
        <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h3>Warszawa Stadion</h3>
            <h4>15 maj 2020</h4>
            <p><b>Konkurs karaoke dla wszystkich ;)</b></p>
        </div>
    </div>

    <!-- The Band Section -->
    <div class="w3-container w3-content w3-center w3-padding-64" style="max-width:800px" id="home">
        <h2 class="w3-wide">event.managers</h2>
        <p class="w3-opacity"><i>We love music</i></p>
        <p class="w3-justify">event.managers to liderzy internetowej bazy eventów oraz sprzedaży biletów w branży
            kulturalno – rozrywkowej w Polsce. Współpracujemy z największymi krajowymi i międzynarodowymi
            organizatorami
            imprez, świadcząc usługi sprzedaży indywidualnej, korporacyjnej, a także promocji i kompleksowej obsługi
            imprez. Oferujemy systemy sprzedaży biletów i kontroli wejść na wszystkie wydarzenia kulturalne i
            sportowe.
            Udostępniamy naszym organizatorom i partnerom kompletne rozwiązania technologiczne do bieżącej edycji
            oraz
            śledzenia trendów sprzedaży. Jesteśmy pionierem nowoczesnych technologii dla rynku e – commerce.</p>
        <div class="w3-row w3-padding-32">
            <div class="w3-third">
                <p>Name</p>
                <img src="/w3images/bandmember.jpg" class="w3-round w3-margin-bottom" alt="Random Name"
                     style="width:60%">
            </div>
            <div class="w3-third">
                <p>Name</p>
                <img src="/w3images/bandmember.jpg" class="w3-round w3-margin-bottom" alt="Random Name"
                     style="width:60%">
            </div>
            <div class="w3-third">
                <p>Name</p>
                <img src="/w3images/bandmember.jpg" class="w3-round" alt="Random Name" style="width:60%">
            </div>
        </div>
    </div>

    <!-- The Wydarzenia Section -->
    <div class="w3-black" id="wydarzenia">
        <div class="w3-container w3-content w3-padding-64" style="max-width:800px">
            <h2 class="w3-wide w3-center">WYDARZENIA</h2>
            <p class="w3-opacity w3-center"><i>Nie przegap!</i></p><br>

            <ul class="w3-ul w3-border w3-white w3-text-grey">
                <li class="w3-padding">September <span class="w3-tag w3-red w3-margin-left">Sold out</span></li>
                <li class="w3-padding">October <span class="w3-tag w3-red w3-margin-left">Sold out</span></li>
                <li class="w3-padding">November <span class="w3-badge w3-right w3-margin-right">3</span></li>
            </ul>

            <div class="w3-row-padding w3-padding-32" style="margin:0 -16px">
                <div class="w3-third w3-margin-bottom">
                    <img src="/w3images/newyork.jpg" alt="New York" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>New York</b></p>
                        <p class="w3-opacity">Fri 27 Nov 2016</p>
                        <p>Praesent tincidunt sed tellus ut rutrum sed vitae justo.</p>
                        <button class="w3-button w3-black w3-margin-bottom"
                                onclick="document.getElementById('ticketModal').style.display='block'">Buy Tickets
                        </button>
                    </div>
                </div>
                <div class="w3-third w3-margin-bottom">
                    <img src="/w3images/paris.jpg" alt="Paris" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>Paris</b></p>
                        <p class="w3-opacity">Sat 28 Nov 2016</p>
                        <p>Praesent tincidunt sed tellus ut rutrum sed vitae justo.</p>
                        <button class="w3-button w3-black w3-margin-bottom"
                                onclick="document.getElementById('ticketModal').style.display='block'">Buy Tickets
                        </button>
                    </div>
                </div>
                <div class="w3-third w3-margin-bottom">
                    <img src="/w3images/sanfran.jpg" alt="San Francisco" style="width:100%"
                         class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>San Francisco</b></p>
                        <p class="w3-opacity">Sun 29 Nov 2016</p>
                        <p>Praesent tincidunt sed tellus ut rutrum sed vitae justo.</p>
                        <button class="w3-button w3-black w3-margin-bottom"
                                onclick="document.getElementById('ticketModal').style.display='block'">Buy Tickets
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Ticket Modal -->
    <div id="ticketModal" class="w3-modal">
        <div class="w3-modal-content w3-animate-top w3-card-4">
            <header class="w3-container w3-teal w3-center w3-padding-32">
        <span onclick="document.getElementById('ticketModal').style.display='none'"
              class="w3-button w3-teal w3-xlarge w3-display-topright">×</span>
                <h2 class="w3-wide"><i class="fa fa-suitcase w3-margin-right"></i>Tickets</h2>
            </header>
            <div class="w3-container">
                <p><label><i class="fa fa-shopping-cart"></i> Tickets, $15 per person</label></p>
                <input class="w3-input w3-border" type="text" placeholder="How many?">
                <p><label><i class="fa fa-user"></i> Send To</label></p>
                <input class="w3-input w3-border" type="text" placeholder="Enter email">
                <button class="w3-button w3-block w3-teal w3-padding-16 w3-section w3-right">PAY <i
                            class="fa fa-check"></i></button>
                <button class="w3-button w3-red w3-section"
                        onclick="document.getElementById('ticketModal').style.display='none'">Close <i
                            class="fa fa-remove"></i></button>
                <p class="w3-right">Need <a href="#" class="w3-text-blue">help?</a></p>
            </div>
        </div>
    </div>

    <!-- The Contact Section -->
    <div class="w3-container w3-content w3-padding-64" style="max-width:800px" id="kontakt">
        <h2 class="w3-wide w3-center">KONTAKT</h2>
        <p class="w3-opacity w3-center"><i>Skontaktuj się z nami!</i></p>
        <div class="w3-row w3-padding-32">
            <div class="w3-col m6 w3-large w3-margin-bottom">
                <i class="fa fa-map-marker" style="width:30px"></i> Plaża w Gdańsku<br>
                <i class="fa fa-phone" style="width:30px"></i> +48 666 666 666<br>
                <i class="fa fa-envelope" style="width:30px"> </i> info@eventmanagers.com<br>
            </div>
            <div class="w3-col m6">
                <form action="/action_page.php" target="_blank">
                    <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
                        <div class="w3-half">
                            <input class="w3-input w3-border" type="text" placeholder="Name" required name="Name">
                        </div>
                        <div class="w3-half">
                            <input class="w3-input w3-border" type="text" placeholder="Email" required name="Email">
                        </div>
                    </div>
                    <input class="w3-input w3-border" type="text" placeholder="Message" required name="Message">
                    <button class="w3-button w3-black w3-section w3-right" type="submit">WYŚLIJ</button>
                </form>
            </div>
        </div>
    </div>

    <!-- End Page Content -->
</div>

<!-- Image of location/map -->
<img src="images/plaza.jpg" class="w3-image w3-greyscale-min" style="width:100%">

<script>
    // Automatic Slideshow - change image every 4 seconds
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {
            myIndex = 1
        }
        x[myIndex - 1].style.display = "block";
        setTimeout(carousel, 4000);
    }

    // Used to toggle the menu on small screens when clicking on the menu button
    function myFunction() {
        var x = document.getElementById("navDemo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }

    // When the user clicks anywhere outside of the modal, close it
    var modal = document.getElementById('ticketModal');
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
<#include "footer.ftlh">
</body>
</html>
