package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private Integer numberOfProfiles;
  // using LinkedHashMap to preserve the order of insertion
  private LinkedHashMap<String, Object> users;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    this.numberOfProfiles = 0;
    this.users = new LinkedHashMap<String, Object>();
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
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(i.toString(), userName, user.age.toString());
    }

  }
  
  public void createNewProfile(String userName, String age) {

    // format userName
    String formattedUserName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    // validation
    if (formattedUserName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(formattedUserName);
      return;
    } else if (users.get(formattedUserName) != null){
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(formattedUserName);
      return;
    }

    User user = new User(formattedUserName, Integer.parseInt(age));
    users.put(formattedUserName, user);
    this.numberOfProfiles++;
    System.out.println("New profile created for " + formattedUserName + " with age " + age + ".");
    
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
