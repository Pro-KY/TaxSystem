package ua.training.persistance.dao.factory;

import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.IRoleDao;
import ua.training.persistance.dao.daoimpl.RoleDaoImpl;
import ua.training.persistance.dao.daoimpl.UserDaoImpl;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.db.datasource.MysqlMyDataSource;

// get Dao's via fabric
public class MySQLDaoFactory implements DaoFactory {
    // should I create one method with switch statement which accepts enum?
    private MyDataSource myDataSource;
    private static MySQLDaoFactory instance;

    public MySQLDaoFactory() {
        this.myDataSource = MysqlMyDataSource.getInstance();
    }

    @Override
    public void setMyDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public static MySQLDaoFactory getInstance() {
        if (instance == null) {
            instance = new MySQLDaoFactory();
        }
        return instance;
    }

    @Override
    public IUserDao getUserDao() {
        final UserDaoImpl userDao = new UserDaoImpl();
        userDao.setMyDataSource(myDataSource);
        return userDao;
    }

    @Override
    public IRoleDao getUserTypeDao() {
        final RoleDaoImpl userTypeDao = new RoleDaoImpl();
        userTypeDao.setMyDataSource(myDataSource);
        return userTypeDao;
    }
}
