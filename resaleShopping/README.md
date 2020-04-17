# Car Resale Shopping Website


## The server of Resale Shopping website

### This project is built in Java Spring Boot framework with Mongo DB database. ###

Following are the steps of installations of the project:

##### set up Mongo DB database #####

Following are the guidelines to run mongoDb as a docker image. 
Node: refer [link](https://docs.mongodb.com/manual/installation/) for manual MongoDB installation.

1. [install the docker](https://docs.docker.com/get-docker/)
2. install the docker image from docker hub

     `docker pull mongo`
    
3. Get the image id of the mongo and run the Mongo DB in docker container. 
    Specify the ip and port in the command to expose port externally. 

      `docker image ls`
 
     `docker run -p 0.0.0.0:27017:27017 <image_id>`
     
 4. Mongo Server is up and running.   
  
 5. Confirm the MongoDB connection properties in application.properties file.
 

 6. Create a executable jar file of the application and run the jar.
  
     `java -jar ../resaleShopping-0.0.1-SNAPSHOT.jar `
     
 7. The  API can be refered from {serverURL}/swagger-ui.html
     

     
   
