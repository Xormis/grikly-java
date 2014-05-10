Grikly-Java
===========

## Description

Grikly Java is a library that wraps the [Grikly](http://grik.ly/) API.

## Usage

#### Sample Source:

Acquire Access Token:

     UserCredential userCredential = new UserCredential();
     userCredential.setEmail(email);
     userCredential.setPassword(password);
     AccessToken accessToken = Grikly.getAccessToken(apiKey, userCredential);


Using Grikly:

     Grikly grikly = new Grikly (apiKey);
     grikly.setAccessToken(accessToken);
     UserInfo userInfo = grikly.getUserInfo(userCredential);

    
#### Api methods Covered


     
## Necessary prerequisites
Java 1.5 or higher, Gson, Apache HttpClient


#### Building the source

The source can be built using Maven. The POM.xml contains all dependency required.
