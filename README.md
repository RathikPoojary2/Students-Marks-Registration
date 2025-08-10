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

</ul>
