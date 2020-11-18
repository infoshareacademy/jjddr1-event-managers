<!DOCTYPE html>
<#import "head.ftlh" as common>
<html lang="pl">
<head>
    <@common.defaultHead title = "Rejestracja użytkownika"/>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body {
            text-align: center;
        }

        form {
            display: inline-block;
        }

    </style>
    <title>Strona Logowania</title>
</head>
<body onload="">
<!-- Podany login i/lub hasło są nieprawidłowe -->
<form action="/login" method="post">
    <fieldset>
        <div id="legend">
            <legend class="">Logowanie</legend>
        </div>
        <div id="error-message">
        </div>

        <div class="control-group">
            <!-- Username -->
            <label class="control-label" for="username">Nazwa użytkownika</label>
            <div class="controls">
                <input type="text" id="username" name="username" placeholder="Nazwa użytkownika" class="input-xlarge">
            </div>
        </div>
        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Hasło</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="Hasło" class="input-xlarge">
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Zaloguj</button>
            </div>

        </div>
    </fieldset>
</form>
</body>
</html>