package org.example;

import java.util.Base64;
import java.util.List;
import java.util.ArrayList;
import java.security.*;


class User {
    private String username;
    private String encryptedPassword;
    private List<Role> roles;

    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.encryptedPassword = encryptPassword(password);
        this.roles = new ArrayList<>();
    }
    public String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role){

        if(roles.contains(role)){
            roles.remove(role);
        }
        else{
            System.out.println("EL USUARIO NO TIENE ROLES ASOCIADOS -.-");
        }
    }

    public boolean authenticate(String username, String password) throws NoSuchAlgorithmException
    {
        return this.username.equals(username) &&
                this.encryptedPassword.equals(encryptPassword(password));
    }

    public boolean hasPermission(String permissionName) {
        for (Role role : roles) {
            for (Permission permission : role.getPermissions()) {
                if (permission.getName().equals(permissionName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public String getUsername() {
        return username;
    }

    public List<Role> getRoles(){
        return  roles;
    }
}