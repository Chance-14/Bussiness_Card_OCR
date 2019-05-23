//---------------------------------------//
//  Author: Chance Coleman               //
//  Date: 5/23/2019                      //
//  Asymmetrik Programming Challenge     //
//  Business Card OCR                    //
//---------------------------------------//


import java.io.*;
import java.util.*;

public class BusinessCardParser {
  public static void main(String args[]) throws FileNotFoundException{
    if(args.length == 0){
       System.out.println("No card provided.");
       System.exit(1);
    }
    //scan in the file 
    Scanner input = new Scanner(new File(args[0])); 
    
    //create an array list for keeping track of possible names
    ArrayList<String> list = new ArrayList<String>(); 
    
    //create the contact info for the getter/setter methods contained in the contact info class
    ContactInfo businessCard = new ContactInfo();
    
    //go through each line of the given the text file and evaluate the line with the given functions 
    while (input.hasNextLine()){
      String line = input.nextLine();
      findName(line, list, businessCard);
      findEmail(line,businessCard);
      findPhone(line,businessCard);
    }
    
    //return the information requested
    System.out.println("Name: " +businessCard.getName());
    System.out.println("Phone: " +businessCard.getPhoneNumber());
    System.out.println("Email: " +businessCard.getEmailAddress());

    //close the scanner
    input.close();
  }


//-------------------------------------------------------------------------------------------------------//
// Methods function is to find the name from the given text file
// i assume there is only alphabetical letters and also that the name is the shortest string
// if the line contains anything other than alphabetical letters it is disregarded
// i use an array list to keep track of each line that could potentially be a name (i.e. its only letters)
// with each new line i re-evaluate the list to find the new shortest string (i.e the name)
// i prefer to use finalName for readability and complexity purposes, it's not needed
// if there is two names on the card that are exactly the same length then the first name will be returned
//-------------------------------------------------------------------------------------------------------//

  public static void findName(String line, ArrayList<String> list, ContactInfo businessCard){
    String regexName = "^[ a-zA-Z]+$";
    if(line.matches(regexName)){
      list.add(line); 
    }
    String shortName = "";
    for(int i=0; i<list.size(); i++){
      if(i==0){
        shortName = list.get(i);
      }
      if(list.get(i).length() < shortName.length()){
        shortName = list.get(i);
      }
    }
    String finalName = shortName;
    businessCard.setName(finalName);
  }


//-------------------------------------------------------------------------------------------------------//
// this methods function is to find the email from the given data
// this regex assumes that the email is a valid email address, also this regex is not my own
// if the current line meets the requirements of the regex pattern that will become the new finalEmail
// this assumes that there will not be two emails on a card, if there is it will show the last email given
// one work around for that problem could have been to keep a list and show all of the given emails or
// possibly evaluated the emails for the persons name, however that creates another problem of course
//-------------------------------------------------------------------------------------------------------//

  public static void findEmail(String line, ContactInfo businessCard){
    String regexEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if(line.matches(regexEmail)){
      String finalEmail = line;
      businessCard.setEmailAddress(finalEmail);
    }
  }


//-------------------------------------------------------------------------------------------------------//
// this methods functions is to find the phone number from the given data
// this regex assumes that there will can be any alphabetical letters or special characters but it must have a set of 
// numerical values that match a typical phone number, (i.e. 111-222-3333)
// if the given line meets the pattern requirements we find and split the line at the colon (i.e. Phone: 546-406-..)
// once we have split the line we evaluate the first element of our created list, if that element is contained in the 
// if statements allowed key words then we proceed forward otherwise we wouldnt (i.e. Fax: 111-222-3333 wouldnt proceed)
// then we remove all the non-numerical characters from the line and set our finalPhone to the current line
// as with the email or names, if there is more than one then the last one will be returned
//-------------------------------------------------------------------------------------------------------//

  public static void findPhone(String line, ContactInfo businessCard){
    String regexPhone =  "^[s\\S]*\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";
      if(line.matches(regexPhone)){
        String[] parts = line.split("\\:");
        String before = parts[0];
        if(parts.length <2 || before.equals("Phone") || before.equals("Tel") || before.equals("Cell")){
          String finalPhone = line.replaceAll("[^\\d]","");
          businessCard.setPhoneNumber(finalPhone);
        }
      }
  }
}

