package dao;


/**
 * Created by Илья on 05.05.2017.
 */
public abstract class DAOFactory {

    protected String filename;


    public DAOFactory(String filename) {
        this.filename = filename;
    }

    public abstract DAO getDAO();

}
