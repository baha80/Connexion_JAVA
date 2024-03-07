package Service;
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;

import Entite.personne;
import Utils.DataSource;

public class ServicePersonne implements IService<personne> {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    private List<personne> personnes;


    public ServicePersonne() {
        try {
            ste = con.createStatement();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void ajouter(personne t) {
        try {
            String sql = "INSERT INTO `personne` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getAge() + "')";
            ste.executeUpdate(sql);
            System.out.println("personne ajouter");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void supprimer(personne t) {
        try {
            String sql = "DELETE FROM `personne` WHERE `personne`.`id` = " + t.getId();
            ste.executeUpdate(sql);
            System.out.println("personne supprimer");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modifier(personne t) {
        try {
            String sql = "UPDATE `personne` SET `nom` = '" + t.getNom() + "', `prenom` = '" + t.getPrenom() + "', `age` = '" + t.getAge() + "' WHERE `personne`.`id` = " + t.getId();
            ste.executeUpdate(sql);
            System.out.println("personne modifier");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void afficher() {
        try {
            ResultSet rs = ste.executeQuery("select * from personne");
            personnes = new ArrayList<>();
            while (rs.next()) {
                personnes.add(new personne(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt("age")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<personne> readAll() {
       try {
            ResultSet rs = ste.executeQuery("select * from personne");
            personnes = new ArrayList<>();
            while (rs.next()) {
                //affichage 
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt("age"));
                //personnes.add(new personne(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt("age")));
            }
            }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    @Override
    public personne findById(int id) {
        try {
            ResultSet rs = ste.executeQuery("select * from personne where id=" + id);
            if (rs.next()) {
                return new personne(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void ajouterPST(personne t) {
        try {
            String sql = "INSERT INTO `personne` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setInt(3, t.getAge());
            pst.executeUpdate();
            System.out.println("personne ajouter");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
