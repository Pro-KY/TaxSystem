package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.dao.IReportDao;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.entities.Report;

import java.sql.Connection;
import java.util.Optional;

public class IReportDaoIml implements IReportDao {
    private static IReportDaoIml instance;
    private MyDataSource myDataSource;

    public void setDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    private IReportDaoIml() {}

    public static IReportDaoIml getInstance() {
        if (instance == null) {
            instance = new IReportDaoIml();
        }
        return instance;
    }

    @Override
    public void save(Report entity) {
        final Connection connection = myDataSource.getConnection();
//        PreparedStatement ps = connection.prepareStatement(SQL);

    }

    @Override
    public void update(Report entity) {

    }

    @Override
    public void delete(Report entity) {

    }

    @Override
    public Optional<Report> getById(Long id) {
        return Optional.empty();
    }
}
