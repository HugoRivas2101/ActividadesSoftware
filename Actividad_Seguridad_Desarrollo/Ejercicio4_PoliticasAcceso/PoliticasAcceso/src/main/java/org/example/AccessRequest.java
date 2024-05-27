package org.example;

class AccessRequest {
    private User user;
    private Resource resource;
    private String action;
    public AccessRequest(User user, Resource resource, String action) {
        this.user = user;
        this.resource = resource;
        this.action = action;
    }
    public User getUser() {
        return user;
    }
    public Resource getResource() {
        return resource;
    }
    public String getAction() {
        return action;
    }
}
