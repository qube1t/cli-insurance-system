package nz.ac.auckland.se281;

import java.util.ArrayList;

public class User {
    private String userName;
    private int age;

    private ArrayList<InsurancePolicy> policies = new ArrayList<InsurancePolicy>();

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
        MessageCli.NEW_POLICY_CREATED.printMessage(userName, policy.getType().toString());
    }

    public void removePolicy(InsurancePolicy policy) {
        this.policies.remove(policy);
    }

    public int getNumberOfPolicies() {
        return this.policies.size();
    }

}
