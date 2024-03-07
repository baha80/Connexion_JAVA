package TestA;

import java.security.Provider.Service;

import Entite.personne;
import Service.ServicePersonne;


public class Test {
    public static void main(String[] args) {
        ServicePersonne sp = new ServicePersonne();
        personne p = new personne(1, "aaa", "aaa", 25);
        try {
            sp.ajouter(p);
        } catch (Exception e) {
            System.out.println(e);
        }

        sp.readAll().forEach(e -> System.out.println(e));
      
    }
    
}
