<jsp:useBean id="MathForm" class="beans.MathForm" scope="session"/>
<jsp:setProperty name="MathForm" property="*"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta charset="UTF-8" content="">
    <title>Лабораторная работа №3</title>
    <link rel="stylesheet" href="html/style.css">
</head>
<body>
<h1>Возведение в степень</h1>

<form action="index.jsp" id="myForm" method="post">
    <fieldset>
        <legend>Возведение в степень</legend>
        <p>
            <label for="base">Число</label>
            <input type="text" id="base" name="base" placeholder="Введите Число" autofocus/>
        </p>
        <p>
            <label for="power">Степень</label>
            <input type="text" id="power" name="power" placeholder="Введите степень"/>
        </p>
    </fieldset>
    <p>
        <button class="submit" type="submit" onclick="checkInputData()">Возвести!</button>
    </p>

    <%if (MathForm.isOkStatus()){%>
    <jsp:forward page="/html/result.html"/>
    <%}
    %>

</form>
<%--suppress RequiredAttributes --%>
<script>
    function checkInputData() {
        const input = document.getElementById("base");
        const inputValue = input.value;
        const input2 = document.getElementById("power");
        const inputValue2 = input2.value;
        const regex1 = new RegExp("^[-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$");
        const regex2 = new RegExp("^([0-9]+([.][0-9]*)?|[.][0-9]+)$");
        if (!(regex2.test(inputValue))) {
            input.setCustomValidity("Введите неотрицательное число");
        } else if (!(regex1.test(inputValue2))) {
            input2.setCustomValidity("Введите число");
        } else{
            input.setCustomValidity('');
            input2.setCustomValidity('');
        }
    }
</script>
</body>
</html>


