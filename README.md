# file_upload_backend
Please implement the challenge below with Java. It is not necessary to fulfil all below objectives. 
Consider any best coding practices you would use in your daily work. 
Web-Service 
Develop a Web service with following functionality. 
File upload 
Upload a text file and store it. 
one random line 
Return one random line of a previously uploaded file via http as text/plain, application/json or 
application/xml depending on the request accept header. All three headers must be supported. 
If the request is application/* please include following details in the response: 
• line number 
• file name 
• the letter which occurs most often in this line 
one random line backwards 
Return the requested random line backwards (choose all files) 
logest 100 lines 
Ruturn the 100 longest lines of all files uploaded 
20 longest line of one file 
Return the 20 longest lines of one file uploaded (choose file randomly or choose latest file) 