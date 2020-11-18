<!DOCTYPE html>
<#import "head.ftlh" as common>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <Title>Rejestracja użytkownika</Title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="/javascript/registerValidators.js"></script>
    <style>
        body {
            text-align: center;
        }

        form {
            display: inline-block;
        }

    </style>
    <title>Strona Rejestracji</title>
</head>
<body>
<form action="/register" method="post" onsubmit="//return checkAll();">
    <fieldset>
        <div id="legend">
            <legend class="">Rejestracja</legend>
        </div>
        <br>
        <div class="control-group">
            <!-- Username -->
            <label class="control-label" for="username">Nazwa użytkownika</label>
            <div class="controls">
                <input type="text" id="username" name="username" placeholder="Nazwa użytkownika" class="input-xlarge"
                       required
                        <#if username?has_content>
                            value="${username}"
                        </#if>
                       onkeyup=" validateUsername()">
                <div id="username-error"></div>
            </div>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">E-mail</label>
            <div class="controls">
                <input type="text" id="email" name="email" placeholder="E-mail" class="input-xlarge" required
                        <#if email?has_content>
                            value="${email}"
                        </#if>
                       onkeyup=" validateEmail()">
                <div id="email-error"></div>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Hasło</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="Hasło" class="input-xlarge" required
                       onkeyup="checkPassword()"
                >
                <p class="help-block">Hasło musi zawierać co najmniej 8 znaków, w tym jedną dużą literę, jedną małą oraz
                    cyfrę
                <div id="password-error"></div>
            </div>
        </div>

        <div class="control-group">
            <!-- Password -->
            <label class="control-label" for="password_confirm">Powtórz hasło</label>
            <div class="controls">
                <input type="password" id="password_confirm" name="password_confirm" placeholder="Powtórz hasło"
                       onkeyup="isPasswordsAreTheSame()"
                       class="input-xlarge">
                <div id="password-confirm-error"></div>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Zarejestruj
                </button>
            </div>
        </div>
    </fieldset>
</form>
</body>
</html>