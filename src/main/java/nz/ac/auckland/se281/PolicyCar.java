package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class PolicyCar extends InsurancePolicy {
    public PolicyCar(int sumInsured, String makeAndModel, String licensePlate, boolean mechanicalWarranty) {
        super(PolicyType.CAR, sumInsured);
    }
}