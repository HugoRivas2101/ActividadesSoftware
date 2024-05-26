package org.example;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class GestionUsers {

    public static List<User> userList=new ArrayList<>();
    public static List<Role> roleList=new ArrayList<>();
    public static List<Permission> permissionsList=new ArrayList<>();

    public void registrarUser(String username, String password) {
        try {
            User newUser = new User(username, password);
            userList.add(newUser);
            System.out.println("Usuario registrado con éxito.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error al registrar el usuario");
        }
    }

    public void eliminarUser(String username){
        User name=getUserByUsername(username);
        userList.remove(name);
    }


    //Se añade un rol a la lista de roles totales
    public void registrarRol(String rolname){
        Role newRole= new Role(rolname);
        roleList.add(newRole);
        System.out.println("Rol registrado con éxito.");
    }

    public void addRol4User(String username, String rolname){
        User user=getUserByUsername(username);
        Role rol=getRolByName(rolname);
        user.addRole(rol);
    }

    public void addPermision4Rol(String rolname, String permissionname, String description){

        Permission permiso=getPermissionByName(permissionname);

        if(permiso==null){
            permiso=new Permission(permissionname,description);
        }
        Role rol=getRolByName(rolname);
        rol.addPermission(permiso);

        System.out.println("Permiso añadido");
    }

    public void showInfoUser(String username){
        User user=getUserByUsername(username);
        System.out.println("\nUsuario "+username+" tiene los roles: ");
        for(Role rol : user.getRoles()){
            System.out.println("*"+rol.getName()+"* con permisos ");
            for(Permission permiso: rol.getPermissions()){
                System.out.println(permiso.getName());
            }
        }
    }

    public void eliminarRolUser(String username, String rolname){
        User user=getUserByUsername(username);
        Role rol=getRolByName(rolname);
        user.removeRole(rol);
    }

    public static Role getRolByName(String rol){
        for(Role role : roleList){
            if(role.getName().equals(rol)){
                return role;
            }
        }
        return null;
    }
    public static Permission getPermissionByName(String permiso){
        for(Permission permission : permissionsList){
            if(permission.getName().equals(permiso)){
                return permission;
            }
        }
        return null;
    }
    public static User getUserByUsername(String username){
        for(User user:userList){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public List<User> getUserList() {
        return userList;
    }
}
