package ua.training.persistance.dao.jdbc.pagination;

public class Page {
    private int pageSize;
    private int offset;

    public Page(int pageSize, int offset) {
        this.pageSize = pageSize;
        this.offset = offset;
    }
}
