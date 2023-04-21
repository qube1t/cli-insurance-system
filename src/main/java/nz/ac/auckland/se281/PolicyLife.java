package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class PolicyLife extends InsurancePolicy {
  public PolicyLife(User user, int sumInsured) {
    super(user, PolicyType.LIFE, sumInsured);
  }

  @Override
  public double getBasePremium() {
    return (1 + (double) user.getAge() / 100) * (double) sumInsured / 100;
  }

  @Override
  public void printSummary() {
    MessageCli.PRINT_DB_LIFE_POLICY.printMessage(Integer.toString(sumInsured),
        String.valueOf((int) getBasePremium()),
        String.valueOf((int) getDiscountedPremium()));
  }
}
