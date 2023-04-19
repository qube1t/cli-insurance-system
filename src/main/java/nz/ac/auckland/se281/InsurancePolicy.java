package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class InsurancePolicy {
    private PolicyType type;
    protected int sumInsured;
    protected User user;

    // private static int baseId = 0;

    public InsurancePolicy(User user, PolicyType type, int sumInsured) {
        this.user = user;
        this.type = type;
        this.sumInsured = sumInsured;
        // this.baseId++;
    }

    public double getBasePremium() {
        return -1;
    }
}