package ua.training.persistance.dao.mappers.impl2;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class EnitityMapper<T> {
    protected T mappedEntity;
    ResultSet resultSet;
    Map<String, Integer> columnsIndexes = new LinkedHashMap<>();
//    abstract void setDefaultColumnsIndexes(int[] indexes);
    public abstract T mapToEntity(ResultSet resultSet);
//    public abstract void mapToEntity();
//    public abstract void mapToEntity();

    public EnitityMapper() { }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public EnitityMapper(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public T getMappedEntity() {
        return mappedEntity;
    };

    // setIndexesInJoinQuery
    protected void setIndexesInJoinQuery(int[] indexes) {
        final Set<String> keys = columnsIndexes.keySet();
        final Iterator<String> iterator = keys.iterator();

        for (int i = 0; i < keys.size(); i++) {
            final String key = iterator.next();
            columnsIndexes.put(key, indexes[i]);
        }
    }
}
