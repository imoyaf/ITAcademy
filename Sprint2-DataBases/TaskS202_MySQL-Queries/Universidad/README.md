# Sprint 2: Databases - Task 2
# MySQL Queries

<br/>

### Description

<br/>

#### Database Universidad

**Please download the database from the file schema `universidad.sql`, view the E-R diagram in an editor, and perform the following queries:**

1.	    Return a list with the first surname, second surname, and name of all students. The list should be sorted alphabetically in ascending order by first surname, second surname, and name.

2.	    Find the name and two surnames of students who have not registered their phone number in the database.

3.	    Return the list of students born in 1999.

4.	    Return the list of professors who have not registered their phone number in the database and whose NIF ends with "K."

5.	    Return the list of subjects taught in the first semester of the third year of the degree with identifier 7.

6.	    Return a list of professors along with the name of the department to which they are associated. The list should return four columns: first surname, second surname, name, and department name. The result should be sorted alphabetically in ascending order by surname and name.

7.	    Return a list with the name of the subjects, start year, and end year of the school year for the student with NIF 26902806M.

8.	    Return a list with the names of all departments that have professors teaching any subject in the Degree in Computer Engineering (Plan 2015).

9.	    Return a list with all students who enrolled in any subject during the 2018/2019 school year.

<br/>

**Resolve the following six queries using LEFT JOIN and RIGHT JOIN:**

1.	    Return a list with the names of all professors and the departments they are associated with. The list should also show professors who are not associated with any department. The list should return four columns: department name, first surname, second surname, and professor’s name. The result should be sorted alphabetically in ascending order by department name, surnames, and name.

2.	    Return a list with professors who are not associated with any department.

3.	    Return a list with departments that do not have associated professors.

4.	    Return a list with professors who do not teach any subjects.

5.	    Return a list with subjects that do not have an assigned professor.

6.	    Return a list with all departments that have not taught subjects in any school year.

<br/>

**Summary Queries:**

1.	    Return the total number of students.

2.	    Calculate how many students were born in 1999.

3.	    Calculate how many professors are in each department. The result should only show two columns: one with the department name and another with the number of professors in that department. The result should only include departments that have associated professors and should be sorted in descending order by the number of professors.

4.	    Return a list with all departments and the number of professors in each. Note that there may be departments without associated professors, and these departments should also appear in the list.

5.	    Return a list with the names of all degrees in the database and the number of subjects each has. Note that there may be degrees without associated subjects, and these degrees should also appear in the list. The result should be sorted in descending order by the number of subjects.

6.	    Return a list with the names of all degrees in the database and the number of subjects each has, for degrees that have more than 40 associated subjects.

7.	    Return a list showing the names of degrees and the total number of credits for each type of subject. The result should have three columns: degree name, subject type, and the sum of credits for all subjects of that type.

8.	    Return a list showing how many students enrolled in any subject in each school year. The result should display two columns: one column with the starting year of the school year and another with the number of enrolled students.

9.	    Return a list with the number of subjects taught by each professor. The list should include professors who do not teach any subjects. The result should display five columns: id, name, first surname, second surname, and the number of subjects. The result should be sorted in descending order by the number of subjects.

10.	    Return all the data of the youngest student.

11.	    Return a list of professors who have an associated department but do not teach any subjects.