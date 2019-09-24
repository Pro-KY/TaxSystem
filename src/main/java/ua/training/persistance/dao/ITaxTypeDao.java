package ua.training.persistance.dao;

import ua.training.persistance.entities.TaxType;

import java.util.List;
import java.util.Optional;

public interface ITaxTypeDao extends IDao<TaxType> {
    Optional<TaxType> getTaxTypeByType(TaxType taxType);

    List<TaxType> getAllTaxTypes();
}
