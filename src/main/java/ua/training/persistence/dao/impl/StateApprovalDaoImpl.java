package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.IStateApprovalDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.StateApprovalMapperImpl;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.StateApproval;
import ua.training.util.properties.SqlProperties;

import java.util.Optional;

import static ua.training.util.properties.SqlProperties.*;

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
        String sql = SqlProperties.getSqlQuery(FIND_STATE_APPROVAL_BY_STATE);
        return jdbcTemplate.findByQuery(sql, new StateApprovalMapperImpl(false), state);
    }

    @Override
    public Long save(StateApproval entity) {
        String sql = SqlProperties.getSqlQuery(SAVE_STATE_APPROVAL);
        return jdbcTemplate.saveOrUpdate(sql, entity.getState());
    }

    @Override
    public Long update(StateApproval entity) {
        String sql = SqlProperties.getSqlQuery(UPDATE_STATE_APPROVAL);
        return jdbcTemplate.saveOrUpdate(sql, entity.getState(), entity.getId());
    }

    @Override
    public boolean delete(StateApproval entity) {
        String sql = SqlProperties.getSqlQuery(DELETE_STATE_APPROVAL);
        return jdbcTemplate.delete(sql, entity.getId());
    }

    @Override
    public Optional<StateApproval> findById(Long id) {
        String sql = SqlProperties.getSqlQuery(SqlProperties.FIND_INSPECTOR_CHANGING_BY_ID);
        final StateApprovalMapperImpl stateApprovalMapper = new StateApprovalMapperImpl(false);
        return jdbcTemplate.findByQuery(sql, stateApprovalMapper, id);
    }
}
