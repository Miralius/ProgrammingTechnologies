<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="MathForm" class="beans.MathForm" scope="session"/>
<html>
<%if (MathForm == null) {%>
<meta http-equiv="refresh" content="5; URL=/index.jsp"/>
<%
    }
%>
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №3</title>
    <link rel="stylesheet" href="html/style.css">
</head>
<body>
<h1>Возведение в степень</h1>

<form action="html/result.html">
    <fieldset>
        <legend>Возведение в степень</legend>
        <p>
            <label for="base">Число:</label>
            <p id="base" name="base">
                <jsp:getProperty name="MathForm" property="base"/>
            </p>
        </p>
        <p>
            <label for="power">Степень:</label>
            <p id="power" name="power">
              <jsp:getProperty name="MathForm" property="power"/>
            </p>
        </p>
        <p>
            <label for="result">Результат:</label>
            <p id="result" name="result">
                <jsp:getProperty name="MathForm" property="result"/>
            </p>
        </p>
    </fieldset>
    <p><a href="result.xml" download="">Скачать результат</a></p>
    <input type="button" onclick="history.back();" value="Назад"/>
</form>
</body>
</html>



