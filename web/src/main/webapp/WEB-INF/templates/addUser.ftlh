<!DOCTYPE html>
<#import "head.ftlh" as common>
<html>
<head>
    <@common.defaultHead title = "Add user form"/>
</head>
<body>
<form method="post" action="/user" enctype="form-data">
    <input type="submit" name="save" value="save"/><br/>
</form>
</body>
<#import "footer.ftlh" as common>
</html>