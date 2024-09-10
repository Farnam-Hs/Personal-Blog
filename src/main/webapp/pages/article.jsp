<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Personal Blog | ${article.title}</title>
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
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
            margin-top: 5px;
        }

        .article-container {
            width: 100%;
            max-width: 550px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            border: 2px solid black;
        }

        .article-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .article-date {
            color: #aaa;
            font-size: 15px;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .article-content {
            font-size: 17px;
            line-height: 1.6;
            color: #333;
            text-align: justify;
        }

        .article-content p {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="article-container">
    <div class="article-title">${article.title}</div>
    <div class="article-date">${article.responseFormatPublishDate}</div>
    <div class="article-content">
        ${article.content}
    </div>
</div>
</body>
</html>
