<!DOCTYPE html>
<html lang="en">
<title>event.managers</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body {
        font-family: "Lato", sans-serif
    }

    .mySlides {
        display: none
    }
</style>
<body>

<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-black w3-card">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
           href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i
                    class="fa fa-bars"></i></a>

        <a href="#home" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <a href="#wydarzenia" class="w3-bar-item w3-button w3-padding-large w3-hide-small">WYDARZENIA</a>


        <div class="w3-dropdown-hover w3-hide-small">
            <button class="w3-padding-large w3-button" title="#ulubione">ULUBIONE <i class="fa fa-caret-down"></i></button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <a href="#" class="w3-bar-item w3-button">najbliższe</a>
                <a href="#" class="w3-bar-item w3-button">dodaj</a>
                <a href="#" class="w3-bar-item w3-button">usuń</a>
            </div>
        </div>
        <a href="#kontakt" class="w3-bar-item w3-button w3-padding-large w3-hide-small">KONTAKT</a>
        <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
                    class="fa fa-search"></i></a>
        <a href="#login" class="w3-bar-item w3-button w3-padding-large w3-hover-red w3-hide-small  w3-right">Log in</a>

    </div>
</div>

<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
    <a href="#login" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">BAND</a>
    <a href="#wydarzenia" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">TOUR</a>
    <a href="#kontakt" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">CONTACT</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">HOME</a>
</div>