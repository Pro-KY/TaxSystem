package ua.training.persistance.dao.factory;

import ua.training.persistance.dao.*;
import ua.training.persistance.dao.daoimpl.*;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.db.datasource.MysqlMyDataSource;

// get Dao's via fabric
public class MySQLDaoFactory implements DaoFactory {
    // should I save one method with switch statement which accepts enum?
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
    public ITaxTypeDao getTaxTypeDao() {
        final TaxTypeDaoImpl taxTypeDao = TaxTypeDaoImpl.getInstance();
        taxTypeDao.setDataSource(myDataSource);
        return taxTypeDao;
    }

    @Override
    public IUserDao getUserDao() {
        final UserDaoImpl userDao = UserDaoImpl.getInstance();
        userDao.setDataSource(myDataSource);
        return userDao;
    }

    @Override
    public IUserTypeDao getUserTypeDao() {
        final UserTypeDaoImpl userTypeDao = new UserTypeDaoImpl();
        userTypeDao.setDataSource(myDataSource);
        return userTypeDao;
    }

    @Override
    public IReportDao getReportDao() {
        final ReportDaoIml reportDaoIml = ReportDaoIml.getInstance();
        reportDaoIml.setDataSource(myDataSource);
        return reportDaoIml;
    }

    @Override
    public IReportStateDao getReportStateDao() {
        final ReportStateDaoImpl iReportDaoIml = ReportStateDaoImpl.getInstance();
        iReportDaoIml.setDataSource(myDataSource);
        return iReportDaoIml;
    }

    @Override
    public ISendReportEventDao getSendReportEventDao() {
        final SendReportEventDaoImpl sendReportEventDaoImpl = SendReportEventDaoImpl.getInstance();
        sendReportEventDaoImpl.setDataSource(myDataSource);
        return sendReportEventDaoImpl;
    }
}
