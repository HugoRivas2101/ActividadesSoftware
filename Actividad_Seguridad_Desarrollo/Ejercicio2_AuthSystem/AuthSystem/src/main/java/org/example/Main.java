package org.example;

public class Main {
    public static void main(String[] args) {

        GestionUsers gestionUsuarios=new GestionUsers();

        //Se registran los usuarios
        gestionUsuarios.registrarUser("Hugo","Password1");
        gestionUsuarios.registrarUser("Cleber","Password2");

        //Se registran los roles
        gestionUsuarios.registrarRol("Analista BD");
        gestionUsuarios.registrarRol("Administrador BD");
        gestionUsuarios.registrarRol("Administrador Correo");
        gestionUsuarios.registrarRol("Usuario Correo");

        //Se añaden permisos a los roles
        gestionUsuarios.addPermision4Rol("Analista BD", "Acceso BD", "Acceso a BD");
        gestionUsuarios.addPermision4Rol("Analista BD", "Lectura BD", "Lectura a BD");
        gestionUsuarios.addPermision4Rol("Administrador BD", "Acceso BD", "Acceso a BD");
        gestionUsuarios.addPermision4Rol("Administrador Correo", "Acceso Correo", "Acceso a Correo");
        gestionUsuarios.addPermision4Rol("Usuario Correo", "Acceso Correo", "Acceso a Correo");

        //Añadir roles a usuarios
        gestionUsuarios.addRol4User("Hugo","Analista BD");
        gestionUsuarios.addRol4User("Hugo","Usuario Correo");
        gestionUsuarios.addRol4User("Cleber","Usuario Correo");


        //Comprobar la autenticacion de los usuarios en el sistema

        AuthServer authserver=new AuthServer();

        authserver.autenticarUser("Hugo","Password1");
        authserver.permisoUser("Hugo", "Acceso BD");

        //Mostrar info de usuarios
        gestionUsuarios.showInfoUser("Hugo");
        gestionUsuarios.showInfoUser("Cleber");

    }
}