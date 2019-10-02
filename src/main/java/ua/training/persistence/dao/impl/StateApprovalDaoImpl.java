package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.IStateApprovalDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.StateApproval;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.REPORT_STATE_BY_NANE;

public class StateApprovalDaoImpl implements IStateApprovalDao {
    private static StateApprovalDaoImpl instance;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(MysqlDataSource mysqlDataSource) {
        jdbcTemplate.setDataSource(mysqlDataSource);
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
