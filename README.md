Grikly-Java
===========

## Description

Grikly Java is a library that wraps the [Grikly](http://grik.ly/) API.

## Usage

#### Sample Source:

Synchronous:

     Grikly grikly = new Grikly (apiKey);
     Card card = grikly.getCard(cardId);

Asychronous:

    Grikly grikly = new Grikly (apiKey);
    grikly.fetchCard (cardId,new ResponseListener <Card>(){
      public void response (Card result)
      {
         System.out.println (result);
      }
    });
    
#### Api methods Covered


     
## Necessary prerequisites
Java 1.5 or higher, Gson, Jersey Client


#### Building the source

The source can be built using Maven. The POM.xml contains all dependency required.
