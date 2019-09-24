package ua.training.persistance.dao.factory;

import ua.training.persistance.dao.*;
import ua.training.persistance.db.datasource.MyDataSource;

public interface DaoFactory {
    void setMyDataSource(MyDataSource myDataSource);
     IUserDao getUserDao();
     IUserTypeDao getUserTypeDao();
     ITaxTypeDao getTaxTypeDao();
     IReportDao getReportDao();
    IReportStateDao getReportStateDao();
}
