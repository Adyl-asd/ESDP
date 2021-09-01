<#import "navbar.ftlh" as navbar/>

<#macro renderWith title="" scripts=[]>

    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <base href="/">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <title>${title}</title>
    </head>
    <body>
    <@navbar.navbar>

    </@navbar.navbar>
    <#nested>

    <script src="js/jquery-3.6.0.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/main.js"></script>
    <#list scripts as scripts>
        <script src="${scripts}"></script>
    </#list>
    </body>
    </html>

</#macro>