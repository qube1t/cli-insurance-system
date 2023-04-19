package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class InsurancePolicy {
    private PolicyType type;
    private int sumInsured;

    // private static int baseId = 0;

    public InsurancePolicy(PolicyType type, int sumInsured) {
        this.type = type;
        this.sumInsured = sumInsured;

        // this.baseId++;
    }
}