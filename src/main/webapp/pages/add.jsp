<!DOCTYPE html>
<html lang="en">
<head>
    <title>Personal Blog | New Article</title>
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
            padding-bottom: 10px;
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

        .input-group {
            margin-bottom: 20px;
            margin-right: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="date"], textarea {
            width: 100%;
            padding: 10px;
            border: 2px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        textarea {
            height: 200px;
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .update-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .update-title {
            font-size: 24px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="article-container">
    <div class="update-container">
        <h1 class="update-title">New Article</h1>
    </div>

    <form action="${pageContext.request.contextPath}/new" method="post">
        <div class="input-group">
            <label for="title">Article Title</label>
            <input type="text" id="title" name="title" value="">
        </div>

        <div class="input-group">
            <label for="publishDate">Publishing Date</label>
            <input type="date" id="publishDate" name="publishDate" value="" required>
        </div>

        <div class="input-group">
            <label for="content">Content</label>
            <textarea id="content" name="content"></textarea>
        </div>

        <input type="submit" value="Publish">
    </form>
</div>
</body>
</html>
