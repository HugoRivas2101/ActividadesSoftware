package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
class Permission {
    private String name;
    private String description;
    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
}