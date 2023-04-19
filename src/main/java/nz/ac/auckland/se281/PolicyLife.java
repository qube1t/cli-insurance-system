package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class PolicyLife extends InsurancePolicy {
    public PolicyLife(User user, int sumInsured) {
        super(user, PolicyType.LIFE, sumInsured);
    }

    @Override
    public double getBasePremium() {
        return (1 + user.getAge() / 100) * sumInsured;
    }
}