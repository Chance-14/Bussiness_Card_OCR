//--------------------------------------
//Chance Coleman
//
//Per requirements of the programming challenge ContactInfo is my constructor class
//contains the getter and setter methods needed for the business cards
//
//--------------------------------------
public class ContactInfo {
  
  String name;
  String email;
  String phoneNumber;

  public ContactInfo() {                                              //Initialization method

  }

  public void setName(String name) {                                  //set the name 
    this.name = name;
  }

  public void setEmailAddress(String email) {                         //set the email address
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {                    //set the phone number
    this.phoneNumber = phoneNumber;
  }

  public String getName() {                                           //return the name 
    return name;
  }

  public String getEmailAddress() {                                   //return the email address
    return email;
  }

  public String getPhoneNumber() {                                    //return the phone number
    return phoneNumber;
  }
}
