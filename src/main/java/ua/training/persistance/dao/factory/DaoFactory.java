package ua.training.persistance.dao.factory;

import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.IRoleDao;
import ua.training.persistance.db.datasource.MyDataSource;

public interface DaoFactory {
    void setMyDataSource(MyDataSource myDataSource);
     IUserDao getUserDao();
     IRoleDao getUserTypeDao();
}
