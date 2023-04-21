package nz.ac.auckland.se281;

import java.util.ArrayList;

public class User {
  private String userName;
  private int age;

  private ArrayList<InsurancePolicy> policies = new ArrayList<InsurancePolicy>();
  private double totalPremium;

  public User(String userName, int age) {
    this.userName = userName;
    this.age = age;
  }

  public String getUserName() {
    return this.userName;
  }

  public int getAge() {
    return this.age;
  }

  public void addPolicy(InsurancePolicy policy) {
    // validations for life insurance
    if (policy.getType() == Main.PolicyType.LIFE) {
      // check if user is over 100 years old
      if (this.age > 100) {
        MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(userName);
        return;
      } else {
        // check if user already has a life insurance policy
        for (InsurancePolicy p : this.policies) {
          if (p.getType() == Main.PolicyType.LIFE) {
            MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(userName);
            return;
          }
        }
      }
    }

    this.policies.add(policy);

    // apply discounts
    for (InsurancePolicy p : this.policies) {
      p.setDiscountedPremium(this.getNumberOfPolicies());
    }

    // print success msg and summary
    MessageCli.NEW_POLICY_CREATED.printMessage(policy.getType().toString().toLowerCase(),
        userName);
    policy.printSummary();

    // set total premium of the user
    setTotalPremium();

  }

  public void removePolicy(InsurancePolicy policy) {
    this.policies.remove(policy);
  }

  public int getNumberOfPolicies() {
    return this.policies.size();
  }

  private void setTotalPremium() {
    this.totalPremium = 0;

    for (InsurancePolicy p : this.policies) {
      this.totalPremium += p.getDiscountedPremium();
    }
  }

  public double getTotalPremium() {
    return this.totalPremium;
  }

  public void printPolicies() {
    for (InsurancePolicy p : this.policies) {
      p.printSummary();
    }
  }

}
