package ua.training.persistance.dao.factory;

import ua.training.persistance.dao.*;
import ua.training.persistance.dao.impl.*;
import ua.training.persistance.db.datasource.MysqlDataSource;
import ua.training.persistance.db.datasource.MysqlMysqlDataSource;

// get Dao's via fabric
public class MysqlDaoFactory implements DaoFactory {
    // should I save one method with switch statement which accepts enum?
    private MysqlDataSource mysqlDataSource;
    private static MysqlDaoFactory instance;

    private MysqlDaoFactory() {
        this.mysqlDataSource = MysqlMysqlDataSource.getInstance();
    }

    @Override
    public void setDataSource(MysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }

    public static MysqlDaoFactory getInstance() {
        if (instance == null) {
            instance = new MysqlDaoFactory();
        }
        return instance;
    }

    @Override
    public ITaxTypeDao getTaxTypeDao() {
        final TaxTypeDaoImpl taxTypeDao = TaxTypeDaoImpl.getInstance();
        taxTypeDao.setDataSource(mysqlDataSource);
        return taxTypeDao;
    }

    @Override
    public IUserDao getUserDao() {
        final UserDaoImpl userDao = UserDaoImpl.getInstance();
        userDao.setDataSource(mysqlDataSource);
        return userDao;
    }

    @Override
    public IUserTypeDao getUserTypeDao() {
        final UserTypeDaoImpl userTypeDao = new UserTypeDaoImpl();
        userTypeDao.setDataSource(mysqlDataSource);
        return userTypeDao;
    }

    @Override
    public IReportDao getReportDao() {
        final ReportDaoImpl reportDaoImpl = ReportDaoImpl.getInstance();
        reportDaoImpl.setDataSource(mysqlDataSource);
        return reportDaoImpl;
    }

    @Override
    public IStateApprovalDao getReportStateDao() {
        final StateApprovalDaoImpl iReportDaoIml = StateApprovalDaoImpl.getInstance();
        iReportDaoIml.setDataSource(mysqlDataSource);
        return iReportDaoIml;
    }

    @Override
    public IReportApprovalDao getReportApprovalDao() {
        final ReportApprovalDaoImpl sendReportEventDaoImpl = ReportApprovalDaoImpl.getInstance();
        sendReportEventDaoImpl.setDataSource(mysqlDataSource);
        return sendReportEventDaoImpl;
    }
}
