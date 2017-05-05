package dao;

public class SerializableStudentDAOFactory extends DAOFactory {

    public SerializableStudentDAOFactory(String filename) {
        super(filename);
    }

    @Override
    public DAO getDAO() {
        return new StudentSerializableDAO(filename);
    }
}
