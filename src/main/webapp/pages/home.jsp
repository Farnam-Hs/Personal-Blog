<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Personal Blog | Home</title>
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
            margin-bottom: 15px;
            margin-top: 5px;
            border-bottom: 2px solid #d3d3d3;
            padding-bottom: 20px;
        }

        .login-button {
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: lighter;
            text-decoration: none;
            position: absolute;
            top: 30px;
            right: 20px;
            background-color: #52dd71;
            color: black;
        }

        .blog-container {
            position: relative;
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
            margin-bottom: 25px;
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

        .article-list li span {
            margin-left: 10px;
            white-space: nowrap;
        }

        .article-date {
            color: #aaa;
            font-size: 15px;
            font-weight: bold;
            white-space: nowrap;
            margin-left: 10px;
        }

        .article-list::-webkit-scrollbar {
            width: 8px;
        }

        .article-list::-webkit-scrollbar-thumb {
            background-color: #ccc;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="blog-container">
    <h1>Personal Blog</h1>
    <a href="${pageContext.request.contextPath}/login" class="login-button">Login</a>
    <ul class="article-list">
        <c:forEach var="article" items="${articles}">
            <li>
                <a href="${pageContext.request.contextPath}/article/${article.id}">${article.title}</a>
                <span class="article-date">${article.responseFormatPublishDate}</span>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
