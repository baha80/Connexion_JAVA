package Service;

import java.sql.SQLException;
import java.util.List;

public interface IService <T>{
    public void ajouter(T t) throws SQLException;
    public void supprimer(T t) throws SQLException;;
    public void modifier(T t)throws SQLException;;
    public void afficher()throws SQLException;;
    List<T> readAll()throws SQLException;
    public T findById(int id)throws SQLException;
}
