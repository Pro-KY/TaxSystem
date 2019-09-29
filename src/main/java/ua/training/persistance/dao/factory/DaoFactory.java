package ua.training.persistance.dao.factory;

import ua.training.persistance.dao.*;
import ua.training.persistance.db.datasource.MysqlDataSource;

public interface DaoFactory {
    void setDataSource(MysqlDataSource mysqlDataSource);
    IUserDao getUserDao();
    IUserTypeDao getUserTypeDao();
    ITaxTypeDao getTaxTypeDao();
    IReportDao getReportDao();
    IStateApprovalDao getReportStateDao();
    IReportApprovalDao getReportApprovalDao();
}
