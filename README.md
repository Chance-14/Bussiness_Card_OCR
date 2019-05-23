# Bussiness_Card_OCR
## Description
  This is my response to the programming challenge from Asymmetrik. I choose to do the business card OCR challenge,
  I thought about doing the particle system but decided i didn't know enough about javascript to attempt that at this point. 
  Program takes in a text file, the business card, and parses the data given to find the Name, Phone number, and email address
  of the person.

## Instructions 
  Download files required (BusinessCardParser.java and ConactInfo.java). You can also download the card files if you so
  desire, but you will be required to have/use one later. Using terminal (i used a linux machine) navigate to the 
  directory of the downloaded files and if they are the only files in that directory use the command:  
  ```
    javac *.java 
  ```
  However if there is more java files found in that directory i recommend just using the command:
  ```
    javac BusinessCardParser.java
  ```
  this will compile both of the files needed for executing this program. 
  
  Once you have compiled these java files you should have .class files for each respective .java file and you can now execute:
  ```
    java BusinessCardParser card.txt
  ```
  card.txt is the text file that contains the business card to run the program against.
  
