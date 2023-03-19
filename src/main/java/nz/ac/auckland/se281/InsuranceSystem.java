package nz.ac.auckland.se281;

import java.util.LinkedHashMap;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private Integer numberOfProfiles;
  // using LinkedHashMap to preserve the order of insertion
  private LinkedHashMap<String, Object> users;
  private User loadedUser;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    this.numberOfProfiles = 0;
    this.users = new LinkedHashMap<String, Object>();

    this.loadedUser = null;
  }
  
  public void printDatabase() {
    // Prints the right message depending on the number of profiles.
    if (this.numberOfProfiles == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(this.numberOfProfiles.toString(), "s", ".");
      return;
    }
    else if (this.numberOfProfiles == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(this.numberOfProfiles.toString(), "", ":");
    }
    else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(this.numberOfProfiles.toString(), "s", ":");
    }

    // iterates through the users stored in the hash
    Integer i = 0;

    for (String userName : users.keySet()) {
      i++;
      // gets the user object from the hash using the username
      User user = (User) users.get(userName);
      // prints the details from user object
      // if the user is the loaded user, print asterisks
      if (this.loadedUser == user){
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage("*** ", i.toString(), userName, user.getAge().toString());
      }
      else {
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(i.toString(), userName, user.getAge().toString());
      }
    }

  }
  
  public void createNewProfile(String userName, String age) {


    int ageInt = Integer.parseInt(age);
    String formattedUserName = makeTitleCase(userName);

    // validation
    // see if a user is already loaded
    if (this.loadedUser != null){
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedUser.getUserName());
      return;
    } 
    // see if the username is too short
    else if (formattedUserName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(formattedUserName);
      return;
    } 
    // see if the age is invalid
    else if (ageInt < 0 || ageInt > 120){
      MessageCli.INVALID_AGE.printMessage(age);
      return;
    } 
    // see if the username is already taken
    else if (users.get(formattedUserName) != null){
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(formattedUserName);
      return;
    }
    
    // creating new user and adding to hash
    User user = new User(formattedUserName, ageInt);
    users.put(formattedUserName, user);
    this.numberOfProfiles++;
    System.out.println("New profile created for " + formattedUserName + " with age " + ageInt + ".");
    
  }

  private String makeTitleCase(String input) {
    // for formatting userName
    String formattedString = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    return formattedString;
  }

  public void loadProfile(String userName) {
    // setting the loaded user to be the inputed user
    String formattedUserName = makeTitleCase(userName);

    this.loadedUser = (User) users.get(formattedUserName);

    // check if user exists
    if (this.loadedUser == null) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(formattedUserName);
      return;
    }

    MessageCli.PROFILE_LOADED.printMessage(formattedUserName);
  }

  public void unloadProfile() {
    // check if a user is loaded
    if (this.loadedUser == null) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
      return;
    }

    // unloading the user
    String userName = this.loadedUser.getUserName();
    this.loadedUser = null;
    MessageCli.PROFILE_UNLOADED.printMessage(userName);
  }

  public void deleteProfile(String userName) {
    // check if user exists
    String formattedUserName = makeTitleCase(userName);
    if (users.get(formattedUserName) == null) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(formattedUserName);
      return;
    }

    // check if user is loaded, return error if so
    if (this.loadedUser == users.get(formattedUserName)) {
      MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(formattedUserName);
      return;
    }

    // delete the user
    users.remove(formattedUserName);
    this.numberOfProfiles--;
    MessageCli.PROFILE_DELETED.printMessage(formattedUserName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
