package ua.training.persistance.dao.jdbc.pagination;

import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.dao.mappers.BeanMapper;

public class JdbcPagination<T>  { // implements Pageable<T>
    private JdbcTemplate jdbcTemplate;
//    private int pageSize;
//    private int offSet;
    private String sql;
    private BeanMapper<T> beanMapper;

//    public JdbcPagination(String sql, BeanMapper<T> beanMapper, int pageSize, int offSet) {
    public JdbcPagination(String sql, BeanMapper<T> beanMapper, int pageSize) {
//        this.pageSize = pageSize;
//        this.offSet = offSet;
        this.sql = sql;
        this.beanMapper = beanMapper;
        jdbcTemplate = JdbcTemplate.getInstance();
    }

//    public List<T> getNextPage() {
//        offSet += pageSize;
//        return getPaginationResult();
//    }
//
//    public List<T> getPreviousPage() {
//        offSet -= pageSize;
//        return getPaginationResult();
//    }

//    private List<T> getPaginationResult() {
//        return jdbcTemplate.finAll(sql, beanMapper, pageSize, offSet);
//    }


    public boolean hasPreviousPage() {
        return false;
    }

    public boolean hasNextPage() {
        return false;
    }
}
