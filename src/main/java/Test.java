import java.sql.*;

import Entite.personne;
import Service.ServicePersonne;
public class Test {
    // static String url="jdbc:mysql://localhost:3306/esprit";
    // static String user="root";
    // static String password="";
    // static Connection con;
    // static Statement stmt;
     
    // public static void main(String[] args) {
    //     try {
    //          con = DriverManager.getConnection(url, user, password);
    //         System.out.println("cnx etablie");   
    //     } catch (SQLException e) {
    //         System.out.println(e);
    //     }
    //     try {
    //         stmt = con.createStatement();
    //         String sql = "INSERT INTO `personne` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, 'sallami', 'baha', '22')";
    //         stmt.executeUpdate(sql);
    //         System.out.println("personne ajouter");
    //         //afficher les personnes
    //         ResultSet rs = stmt.executeQuery("select * from personne");
    //         while (rs.next()) {
    //             System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt("age"));
    //         }
            
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    //}
    public static void main(String[] args) {
        ServicePersonne sp = new ServicePersonne();
        personne p = new personne(1, "si", "sui", 25);
        try {
            sp.ajouter(p);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            p.setId(1);
            sp.supprimer(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    
        try {
            p.setId(2);
            p.setNom("sallami modified");
            p.setPrenom("baha modified");
            p.setAge(22);
            sp.modifier(p);
        } catch (Exception e) {
            System.out.println(e);
        }

        
       // sp.readAll().forEach(e -> System.out.println(e));
        
    }
}


