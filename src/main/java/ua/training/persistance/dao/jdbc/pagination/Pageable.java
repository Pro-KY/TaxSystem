package ua.training.persistance.dao.jdbc.pagination;

import java.util.List;

public interface Pageable<T> {
     List<T> getNextPage();
     List<T> getPreviousPage();
     boolean hasPreviousPage();
     boolean hasNextPage();
}
