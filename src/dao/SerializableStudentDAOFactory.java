package dao;

/**
 * Created by Илья on 05.05.2017.
 */
public class SerializableStudentDAOFactory extends DAOFactory {

    public SerializableStudentDAOFactory(String filename) {
        super(filename);
    }

    @Override
    public DAO getDAO() {
        return null;
    }
}
