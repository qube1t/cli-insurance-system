package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class PolicyHome extends InsurancePolicy {
    private String propertyAddress;
    private boolean isRental;

    public PolicyHome(User user, int sumInsured, String propertyAddress, boolean isRental) {
        super(user, PolicyType.HOME, sumInsured);

        this.propertyAddress = propertyAddress;
        this.isRental = isRental;
    }

    @Override
    public double getBasePremium() {
        if (isRental) {
            return 0.02 * sumInsured;
        } else {
            return 0.01 * sumInsured;
        }
    }

    @Override
    public void printSummary() {
        MessageCli.PRINT_DB_HOME_POLICY.printMessage(propertyAddress, Integer.toString(sumInsured),
                String.valueOf((int) getBasePremium()),
                String.valueOf((int) getDiscountedPremium()));
    }
}