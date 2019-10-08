package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.IStateApprovalDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.StateApprovalMapperImpl;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.StateApproval;
import ua.training.util.properties.SqlProperties;

import java.util.Optional;

import static ua.training.util.properties.SqlProperties.FIND_REPORT_STATE_BY_NANE;

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

    public Optional<StateApproval> findByState(String state) {
        String sql = SqlProperties.getSqlQuery(FIND_REPORT_STATE_BY_NANE);
        return jdbcTemplate.findByQuery(sql, new StateApprovalMapperImpl(false), state);
    }

    @Override
    public Long save(StateApproval entity) {
        //TODO: implement
        return 0L;
    }

    @Override
    public Long update(StateApproval entity) {
        //TODO: implement
        return 0L;
    }

    @Override
    public boolean delete(StateApproval entity) {
        //TODO: implement
        return false;
    }

    @Override
    public Optional<StateApproval> findById(Long id) {
        return Optional.empty();
    }
}
