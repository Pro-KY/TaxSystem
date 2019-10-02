package ua.training.persistence.dao.factory;

import ua.training.persistence.dao.*;
import ua.training.persistence.db.datasource.MysqlDataSource;

public interface DaoFactory {
    void setDataSource(MysqlDataSource mysqlDataSource);
    IUserDao getUserDao();
    IUserTypeDao getUserTypeDao();
    ITaxTypeDao getTaxTypeDao();
    IReportDao getReportDao();
    IStateApprovalDao getReportStateDao();
    IReportApprovalDao getReportApprovalDao();
}
