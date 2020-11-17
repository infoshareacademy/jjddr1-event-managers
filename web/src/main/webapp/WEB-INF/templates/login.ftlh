<#include "navbar.ftlh">
<!-- Container starts -->
<div class=w3-content style="max-width: 800px; margin-top: 46px">
    <H2>Login:</H2>
    <form action="/login" method="post">
        <label for="user">User:</label><input type="text" id="user" name="user"><br>
        <label for="password">Password:</label><input type="password" id="password" name="password">
        <button type="submit">Log In</button>
    </form>
</div>
<#include "footer.ftlh">