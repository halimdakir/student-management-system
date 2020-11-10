##  **JAVA EE / JAX-RS - Labb**

##### `` Json-body looks like that, keep in mind that all fields are mandatory except telephone numbers but if you type it, so you should type it correctly like that ex: +46 700 000 000, 0700000000, 0700-000 000 etc... and the email should be valid.``
            {
                "firstName": "Halim",
                "lastName": "Dakir",
                "email": "halim.dakir@iths.se",
                "phoneNumber": "0722 000 111"
            }
            
###### `` ¤ POST Create new a student: http://localhost:8080/se.iths/api/v1/student/create``
![Post](https://user-images.githubusercontent.com/3110131/98452523-42fe6280-2150-11eb-9de8-7465554b865f.jpg)
###### `` ¤ GET all students: http://localhost:8080/se.iths/api/v1/student/all``
![GetAll](https://user-images.githubusercontent.com/3110131/98452570-b3a57f00-2150-11eb-9e04-ff13d426b2c3.jpg)
###### `` ¤ GET one student: http://localhost:8080/se.iths/api/v1/student/{lastName}``
![Getone-ok](https://user-images.githubusercontent.com/3110131/98452599-11d26200-2151-11eb-86f2-80682e489337.jpg)
![Getone-notFound](https://user-images.githubusercontent.com/3110131/98452772-8a85ee00-2152-11eb-96f3-bc57e377eb17.jpg)
###### `` ¤ PUT update a student: http://localhost:8080/se.iths/api/v1/student/update``
![update](https://user-images.githubusercontent.com/3110131/98452622-62e25600-2151-11eb-848a-ec4dfda7c3a8.jpg)
###### `` ¤ DELETE a student: http://localhost:8080/se.iths/api/v1/student/{lastName}``
![delete-ok](https://user-images.githubusercontent.com/3110131/98452671-ca000a80-2151-11eb-8bec-ebaadf5d5f79.jpg)
![delete-notFound](https://user-images.githubusercontent.com/3110131/98452676-cec4be80-2151-11eb-9bff-1b9f4a9070ea.jpg)
