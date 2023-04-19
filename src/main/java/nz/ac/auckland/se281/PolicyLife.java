package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class PolicyLife extends InsurancePolicy {
    public PolicyLife(int sumInsured, String makeAndModel, String licensePlate, boolean mechanicalWarranty) {
        super(PolicyType.CAR, sumInsured);
    }
}