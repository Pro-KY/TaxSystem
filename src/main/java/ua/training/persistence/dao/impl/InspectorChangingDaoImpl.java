package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.IInspectorChangingDao;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.InspectorChanging;

import java.util.Optional;

public class InspectorChangingDaoImpl implements IInspectorChangingDao {
    private MysqlDataSource mysqlDataSource;

    public void setDataSource(MysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }

    @Override
    public Long save(InspectorChanging entity) {
        return null;
    }

    @Override
    public Long update(InspectorChanging entity) {
        return null;
    }

    @Override
    public boolean delete(InspectorChanging entity) {
        return false;
    }

    @Override
    public Optional<InspectorChanging> findById(Long id) {
        return Optional.empty();
    }
}
