package ua.training.persistance.dao.impl;

import ua.training.persistance.dao.IStateApprovalDao;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.REPORT_STATE_BY_NANE;

public class StateApprovalDaoImpl implements IStateApprovalDao {
    private static StateApprovalDaoImpl instance;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(MyDataSource myDataSource) {
        jdbcTemplate.setDataSource(myDataSource);
    }

    private StateApprovalDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static StateApprovalDaoImpl getInstance() {
        if (instance == null) {
            instance = new StateApprovalDaoImpl();
        }
        return instance;
    }

    public StateApproval findByName(String name) {
        String sql = SqlPropertiesHandler.getSqlQuery(REPORT_STATE_BY_NANE);
//        jdbcTemplate.findByQuery(sql, );
        return null;
    }

    @Override
    public Long save(StateApproval bean) {
        return 0L;
    }

    @Override
    public Long update(StateApproval bean) {
        return 0L;
    }

    @Override
    public boolean delete(StateApproval bean) {
        return false;
    }

    @Override
    public Optional<StateApproval> findById(Long id) {
        return Optional.empty();
    }
}
