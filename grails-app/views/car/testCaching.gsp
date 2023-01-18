<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Test caching</title>
</head>

<body>
    <table class="table table-bordered">
        <tr>
            <th>Action</th>
            <th>Result</th>
        </tr>
        <tr>
            <td>Data service result</td>
            <td>${dataServiceResult}</td>
        </tr>
        <tr>
            <td>Dynamic finder</td>
            <td>${dynamicFinderResult}</td>
        </tr>
        <tr>
            <td>Criteria</td>
            <td>${criteriaResult}</td>
        </tr>
    </table>
</body>
</html>