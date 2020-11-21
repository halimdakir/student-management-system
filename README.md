## ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) ![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) **`JAVA EE / JAX-RS - Labb`** ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) ![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+)
        
 `F.Y.I No matter how you write First & Last name (Lower upper case) when you would like to` **POST** `or` **PUT** `or` **GET** `one, there is a customised annotation that makes first letter upper and the rest lower case, the first & last name will look like this:` **Halim**


### ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) **STUDENT** ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+)

` Json-body looks like that, keep in mind that all fields are mandatory except telephone numbers but if you type it, so you should type it correctly like that ex: +46 700 000 000, 0700000000, 0700-000 000 etc... and the email should be valid.`
            
           {
                "firstName": "Halim",
                "lastName": "Dakir",
                "email": "halim.dakir@iths.se",
                "phoneNumber": "0722 000 111"
            }
            

![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` students by subject: /se.iths/api/v1/student/studentbysubject/{subjectName}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` students by subject and teacher: /se.iths/api/v1/student/studentbyteacher-subject/{teacherName}/{subjectName}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **POST** ` Create a new student: /se.iths/api/v1/student/create`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` all students: /se.iths/api/v1/student/all`

![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` one student: /se.iths/api/v1/student/lastname/{lastName}`

![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` one student by id: /se.iths/api/v1/student/{id}`

![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **PUT** ` update a student: /se.iths/api/v1/student/update`

![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **DELETE** ` a student: /se.iths/api/v1/student/{lastName}`

### ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) **TEACHER** ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+)


` Json-body looks like that, keep in mind that all fields are mandatory except telephone numbers but if you type it, so you should type it correctly like that ex: +46 700 000 000, 0700000000, 0700-000 000 etc... and the email should be valid.`
            
           {
                "firstName": "Halim",
                "lastName": "Dakir",
                "email": "halim.dakir@iths.se",
                "phoneNumber": "0722 000 111"
            }


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` teacher by subject: /se.iths/api/v1/teacher/teacherbysubject/{subjectName}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **POST** ` Create a new teacher: /se.iths/api/v1/teacher/create`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` all teachers: /se.iths/api/v1/teacher/all`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` one teacher by id: /se.iths/api/v1/teacher/{id}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` one teacher by last name: /se.iths/api/v1/teacher/lastname/{lastName}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **PUT** ` update a teacher: /se.iths/api/v1/teacher/update`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **DELETE** ` a teacher: /se.iths/api/v1/teacher/{id}`


### ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) **SUBJECT** ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+)


` Json-body looks like that, keep in mind that this field are mandatory.`
            
           {
                "subjectName": "Java",
            }


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` count amount of subject by teacher firt name: /se.iths/api/v1/subject/countsubject_byteacher/{firstName}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **POST** ` Create a new subject: /se.iths/api/v1/subject/create`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` all subjects: /se.iths/api/v1/subject/all`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` one subject by id: /se.iths/api/v1/subject/{id}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **GET** ` subject by name: /se.iths/api/v1/subject/name/{name}`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **PUT** ` update a teacher: /se.iths/api/v1/subject/update`


![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) **DELETE** ` a teacher: /se.iths/api/v1/subject/{id}`