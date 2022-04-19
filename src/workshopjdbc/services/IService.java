package workshopjdbc.services;

import java.sql.SQLException;
import java.util.List;

public interface IService <T> {
    void ajouter(T t) throws SQLException;
    List<T> afficher();
    void modifier(T t);
    void supprimer(T t);
}