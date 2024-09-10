---

<div align="center">

  # Personal Blog
  
</div>
  
---

## 🎯 Overview

This project is a web-based personal blog application built using Java Servlets, JSP, and Tomcat. It allows users to browse articles and provides an admin interface to add, edit, or delete blog posts. All articles are stored as JSON files in the filesystem.
<p align="center">
    <img src="images/design.png" alt="design"/>
</p>

---

## ✨ Features

- **View Articles:** Browse and read articles on the blog that their publishing date is today or earlier.
- **Admin Section:** Add, edit, and delete blog posts through the admin interface.
- **Article Management:** Articles are stored in JSON format, and basic file operations (CRUD) are performed via Java code.
- **Basic Authentication:** Admin section is protected with basic authentication for security.
- **Responsive UI:** The UI is styled with CSS and provides a clean and user-friendly interface.

---

## 🛠️ Technologies Used
- Java 17
- Servlets (Jakarta)
- JSP (Jakarta Server Pages) Generated with ChatGPT
- Gson (for handling JSON files)
- Apache Tomcat
- Maven

---

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Farnam-Hs/Personal-Blog.git
cd Personal-Blog
```

### 2. Build the Project
Use Maven to build the project:
```bash
mvn clean install
```

### 3. Deploy to Tomcat
Add the project to your Tomcat server in your IDE or manually.

### 4. Start Tomcat:
Start the Tomcat server

### 5. Access the Application
Open a web browser and navigate to:
```bash
http://localhost:8080/[Context-Path]
```

---

## 📘 Usage Example

**1. Viewing Articles:** On the home page, all blog articles will be listed. Click on a title to view the full article.

**2. Admin Actions:**
- Navigate to the admin section using the designated admin URL ```/admin``` or click on the Login button.
- Login with the correct credentials to access admin actions. (Username: admin | Password: admin)

**3. CRUD Operations:** 
- **Add New Article:** Click on the ```+``` button in the admin section, fill in the article title, choose the publishing date, write the content, and ```Publish```.
- **Edit Article:** Click on the edit button next to an article in the admin section, modify the title, content, or the publishing date and save.
- **Delete Article:** Click the delete button in the admin section to remove an article.
---

## ⚠️ Error Handling

- **Unauthorized Access (403):** Attempting to access restricted URLs will result in a 403 Forbidden error.
- **Not Found (404):** : Accessing non-existent pages or malformed URLs will result in a 404 Not Found error.
- **Internal Server Error (500):** If an unexpected issue occurs on the server (e.g., failure in file operations or processing), a 500 Internal Server Error will be shown to the user.
---

## 🖼️ Screenshots

**Home Page**
<img src="images/home.png" alt="home page"/>

**Article Page**
<img src="images/article.png" alt="article page"/>

**Login Page**
<img src="images/login.png" alt="login page"/>

**Admin Page**
<img src="images/admin.png" alt="admin page"/>

**New Article Page**
<img src="images/add.png" alt="new article page"/>

**Edit Article Page**
<img src="images/edit.png" alt="edit article page"/>

---

Sample solution for the [Personal Blog](https://roadmap.sh/projects/personal-blog) challenge from [roadmap.sh](https://roadmap.sh/).