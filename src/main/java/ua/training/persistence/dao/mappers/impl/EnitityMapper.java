package ua.training.persistence.dao.mappers.impl;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class EnitityMapper<T> {
    protected T mappedEntity;
    Map<String, Integer> columnsIndexes = new LinkedHashMap<>();
    public abstract T mapToEntity(ResultSet resultSet);

    public EnitityMapper() { }

    public void setIndexesInJoinQuery(int[] indexes) {
        final Set<String> keys = columnsIndexes.keySet();
        final Iterator<String> iterator = keys.iterator();

        for (int i = 0; i < keys.size(); i++) {
            final String key = iterator.next();
            columnsIndexes.put(key, indexes[i]);
        }
    }
}
