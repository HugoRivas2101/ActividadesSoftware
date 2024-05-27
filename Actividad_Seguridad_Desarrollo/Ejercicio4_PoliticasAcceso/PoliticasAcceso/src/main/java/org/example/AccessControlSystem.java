package org.example;
import java.util.ArrayList;
import java.util.List;
class AccessControlSystem {
    private List<Policy> policies;
    public AccessControlSystem() {
        policies = new ArrayList<>();
    }
    public void addPolicy(Policy policy) {
        policies.add(policy);
    }
    public boolean evaluateRequest(AccessRequest request) {
        for (Policy policy : policies) {
            if (policy.evaluate(request)) {
                return true;
            }
        }
        return false;
    }
}
