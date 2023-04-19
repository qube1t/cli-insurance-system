package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class PolicyCar extends InsurancePolicy {
    private String makeAndModel;
    private String licensePlate;
    private boolean mechanicalWarranty;

    public PolicyCar(User user, int sumInsured, String makeAndModel, String licensePlate, boolean mechanicalWarranty) {
        super(user, PolicyType.CAR, sumInsured);

        this.makeAndModel = makeAndModel;
        this.licensePlate = licensePlate;
        this.mechanicalWarranty = mechanicalWarranty;
    }

    @Override
    public double getBasePremium() {
        double initialBasePremium;
        if (user.getAge() < 25) {
            initialBasePremium = 0.15 * sumInsured;
        } else {
            initialBasePremium = 0.1 * sumInsured;
        }

        if (mechanicalWarranty) {
            return initialBasePremium + 80;
        } else {
            return initialBasePremium;
        }
    }
}