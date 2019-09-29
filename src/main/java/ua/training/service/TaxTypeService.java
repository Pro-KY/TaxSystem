package ua.training.service;

import ua.training.persistance.dao.ITaxTypeDao;
import ua.training.persistance.dao.factory.MysqlDaoFactory;
import ua.training.persistance.entities.TaxType;

import java.util.List;

public class TaxTypeService {
    private MysqlDaoFactory daoFactory;

    public TaxTypeService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    private static TaxTypeService instance;

    public static TaxTypeService getInstance() {
        if (instance == null) {
            instance = new TaxTypeService();
        }
        return instance;
    }

    public List<TaxType> getAllTaxTypes() {
        final ITaxTypeDao taxTypeDao = daoFactory.getTaxTypeDao();
        return taxTypeDao.getAllTaxTypes();
    }
}
