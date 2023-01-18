<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Cars</title>
</head>

<body>
    <g:link action="testCaching" class="btn btn-primary" role="button">Test caching</g:link>
    <table class="table table-bordered">
        <tr>
            <th>Name</th>
        </tr>
        <g:each in="${cars}" var="car">
            <tr>
                <td><g:link action="show" id="${car.id}">${car.name}</g:link></td>
            </tr>
        </g:each>
    </table>
</body>
</html>