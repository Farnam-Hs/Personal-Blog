<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Personal Blog | Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            font-size: 32px;
            font-weight: bold;
            margin-bottom: 10px;
            margin-top: 5px;
            padding-bottom: 10px;
            position: relative;
        }

        .header-holder {
            display: grid;
            grid-template-columns: 2fr 1fr;
            border-bottom: 2px solid #d3d3d3;
            margin-bottom: 15px;
        }

        .header-buttons {
            position: relative;
            top: 10px;
            display: flex;
            gap: 10px;
            height: 29px;
            justify-content: flex-end;
        }

        .add-link {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #52dd71;
            color: black;
            height: 19px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: lighter;
        }

        .logout-button {
            padding: 5px 10px;
            border: none;
            height: 29px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: lighter;
            background-color: #bfbfbf;
            color: black;
        }

        .blog-container {
            width: 100%;
            max-width: 550px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            border: 2px solid black;
        }

        .article-list {
            list-style: none;
            padding: 0;
            margin: 0;
            max-height: 500px;
            overflow-y: auto;
        }

        .article-list li {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            padding-right: 10px;
        }

        .article-list li a {
            text-decoration: none;
            font-size: 19px;
            color: #333;
            max-width: 350px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .article-list li a:hover {
            text-decoration: underline;
        }

        .article-list li:hover {
            background-color: #f1f1f1;
        }

        .button-group {
            display: flex;
            gap: 10px;
        }

        .button-group .edit-link {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #ffea00;
            color: black;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
        }

        .button-group .edit-link:hover {
            text-decoration: none;
        }

        .delete-button {
            padding: 5px 10px;
            background-color: #f65a69;
            color: black;
            font-size: 14px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .article-list::-webkit-scrollbar {
            width: 8px;
        }

        .article-list::-webkit-scrollbar-thumb {
            background-color: #ccc;
            border-radius: 4px;
        }

        .message {
            margin-top: 20px;
            padding: 10px;
            background-color: #e7f3e7;
            border: 1px solid #52dd71;
            color: #2e7d32;
            border-radius: 5px;
            text-align: center;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="blog-container">
    <div class="header-holder">
        <div class="header">
            <h1>Personal Blog</h1>
        </div>
        <div class="header-buttons">
            <a href="${pageContext.request.contextPath}/new" class="add-link">+</a>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="logout-button">Logout</button>
            </form>
        </div>
    </div>

    <ul class="article-list">
        <c:forEach var="article" items="${articles}">
            <li>
                <a href="${pageContext.request.contextPath}/article/${article.id}">${article.title}</a>
                <div class="button-group">
                    <a href="${pageContext.request.contextPath}/edit/${article.id}" class="edit-link">Edit</a>
                    <form action="${pageContext.request.contextPath}/delete/${article.id}" method="post">
                        <button type="submit" class="delete-button">Delete</button>
                    </form>
                </div>
            </li>
        </c:forEach>
    </ul>

    <c:if test="${not empty message}">
        <div class="message">
                ${message}
        </div>
    </c:if>
</div>
</body>
</html>
