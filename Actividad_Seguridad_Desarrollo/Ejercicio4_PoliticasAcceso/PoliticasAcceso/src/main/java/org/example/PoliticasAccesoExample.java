package org.example;

public class PoliticasAccesoExample {
    public static void main(String[] args) {

        AccessControlSystem acs = new AccessControlSystem();

        //Se crean políticas de acceso a recursos.
        acs.addPolicy(new Policy("file", "admin", "read"));
        acs.addPolicy(new Policy("database", "user", "write"));

        //Se crean usuarios y se especifican los roles a los que pertenecen
        User admin = new User("1", "admin");
        User user = new User("2", "user");

        //Se crean recursos especificando el tipo al que pertenecen
        Resource file = new Resource("f1", "file");
        Resource database = new Resource("d1", "database");

        //Se crean solicitudes de acceso de usuarios a recursos, especificando la acción que se realizará
        AccessRequest request1 = new AccessRequest(admin, file, "read");
        AccessRequest request2 = new AccessRequest(user, database, "write");

        System.out.println("Request 1 (Admin, Read File): " + acs.evaluateRequest(request1)); // true
        System.out.println("Request 2 (User, Write Database): " + acs.evaluateRequest(request2)); //true
    }
}