<#import "navbar.ftlh" as navbar/>
<#import "footer.ftlh" as footer/>

<#macro renderWith title="" scripts=[] styles=[]>

    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <base href="/">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <#list styles as styles>
            <link rel="stylesheet" href="${styles}">
        </#list>
        <title>${title}</title>
    </head>
    <body>
    <@navbar.navbar>

    </@navbar.navbar>

    <#nested>

    <@footer.footer>
    </@footer.footer>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/main.js"></script>
    <#list scripts as scripts>
        <script src="${scripts}"></script>
    </#list>
    </body>
    </html>

</#macro>