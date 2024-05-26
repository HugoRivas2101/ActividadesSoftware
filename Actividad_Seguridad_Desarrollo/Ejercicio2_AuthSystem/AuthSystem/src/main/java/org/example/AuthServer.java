package org.example;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AuthServer {

    public boolean autenticarUser(String username, String password) {
        for (User user : GestionUsers.userList) {
            if(user.getUsername().equals(username)){
                try {
                    if (user.authenticate(username, password)) {
                        System.out.println("\nUsuario autenticado en el sistema correctamente.");
                        return true;
                    }
                } catch (NoSuchAlgorithmException e) {
                    System.out.println("\nError al autenticar usuario");
                }
            }
        }

        System.out.println("\nNombre de usuario o contraseña incorrectos.");
        return false;
    }

    public boolean permisoUser(String username, String permissionName) {

        User user=GestionUsers.getUserByUsername(username);
        boolean havePermiso=user.hasPermission(permissionName);
        if(havePermiso){
            System.out.println("El usuario "+username+" posee el permiso "+permissionName);
            return true;
        }
        return false;
    }
}
