package org.example;



class Resource {
    private String id;
    private String type;
    public Resource(String id, String type) {
        this.id = id;
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
}