package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private Integer numberOfProfiles;
  // private ArrayList<User> users;
  private HashMap<String, Object> users;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    this.numberOfProfiles = 0;
    this.users = new HashMap<String, Object>();
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

    // validation
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    User user = new User(userName, Integer.parseInt(age));
    users.put(userName, user);
    this.numberOfProfiles++;
    System.out.println("New profile created for " + userName + " with age " + age + ".");
    
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
