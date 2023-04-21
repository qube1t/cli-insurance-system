package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class InsurancePolicy {
  private PolicyType type;
  protected int sumInsured;
  protected User user;
  protected double premium;

  public InsurancePolicy(User user, PolicyType type, int sumInsured) {
    this.user = user;
    this.type = type;
    this.sumInsured = sumInsured;
  }

  public abstract double getBasePremium();

  public abstract void printSummary();

  public void setDiscountedPremium(int noOfPolicies) {
    // calculate discounted premium using no of policies of the user
    this.premium = getBasePremium();

    if (noOfPolicies == 2)
      this.premium *= 0.9;
    else if (noOfPolicies > 2)
      this.premium *= 0.8;

  }

  public PolicyType getType() {
    return type;
  }

  public double getDiscountedPremium() {
    return premium;
  }

}
