<!DOCTYPE html>
<html lang="pl">
<head>
    <#import "head.ftlh" as title>
    <@title.defaultHead title="Logowanie"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/styleLoginRegister.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        .nav body {
            font-family: "Lato", sans-serif
        }

        .nav .mySlides {
            display: none
        }



        body {
            text-align: center !important;
        }

        form {
            display: inline-block;
        }

    </style>
    <script src="javascript/loginValidators.js"></script>
</head>
<body
        <#if error?has_content>
    onload="printError()"
        </#if>>
<#include "navbarBodyLoginRegister.ftlh">
<!-- Podany login i/lub hasło są nieprawidłowe -->
<form action="/login" method="post">
    <fieldset>
        <div id="legend">
            <legend class="">Logowanie</legend>
        </div>


        <div class="control-group">
            <!-- Username -->
            <label class="control-label" for="username">Nazwa użytkownika</label>
            <div class="controls">
                <input type="text" id="username" name="username" placeholder="Nazwa użytkownika" class="input-xlarge"
                       onkeyup="clearError()"
                        <#if username?has_content>
                            value="${username}"
                        </#if>
                       required>
            </div>
        </div>
        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Hasło</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="Hasło" class="input-xlarge"
                       onkeyup="clearError()" required>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Zaloguj</button>
            </div>

        </div>
        <div id="error" class="text-error">

        </div>
    </fieldset>
</form>
</body>

</html>