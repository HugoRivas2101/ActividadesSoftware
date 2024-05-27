package org.example;

class Policy {
    private String resourceType;
    private String requiredRole;
    private String action;
    public Policy(String resourceType, String requiredRole, String action) {
        this.resourceType = resourceType;
        this.requiredRole = requiredRole;
        this.action = action;
    }
    public boolean evaluate(AccessRequest request) {
        return request.getResource().getType().equals(resourceType)
                && request.getUser().getRole().equals(requiredRole)
                && request.getAction().equals(action);
    }
}
