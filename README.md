# Students-Marks-Registration

A Java Servlet-based web application for student marks entry and search functionality using MySQL as the database.

<h1>Features</h1>
<ul>
<li>Add Student Marks — Enter details like roll number, name, section, subjects, and lab scores.</li>

<li>search Student Marks — Retrieve student details by roll number.</li>

<li>Styled HTML forms for a clean user interface.</li>

<li>Uses MySQL JDBC for database connectivity.</li>
</ul>

<h1>Database Setup</h1>
<ul><li>Create a Databse</li><br>

  CREATE DATABASE java_full_stack;
<br>
<li>Create Students table</li><br>
<pre>
CREATE TABLE students (
    rollnumber VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    section VARCHAR(10),
    course1 INT,
    course2 INT,
    course3 INT,
    course4 INT,
    course5 INT,
    course6 INT,
    lab1 INT,
    lab2 INT
);
</pre><br>
<li>Update the username and password in both InsertData.java and Search.java</li><br>
<pre>
  DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/java_full_stack", 
    "root", 
    "password"
);

</pre>
</ul>

<h4>Steps to connect servlet to the database</h4>
<ol>
  <li>Load the Driver </li>
  <li>Create a database Connection</li>
  <li>Create a Statement or Prepared Statement</li>
  <li>Store it in the ResultSet</li>
  <li>Close the Connection</li>
</ol>
<h1>Installation</h1>
Java JDK      -(https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher)<br>
Apache Tomcat-(https://tomcat.apache.org/download-90.cgi) (version 10.1)<br>
MySQL Server-(https://dev.mysql.com/downloads/mysql/)<br>
MySQL Connector JAR file -(https://dev.mysql.com/downloads/connector/j/)
 
