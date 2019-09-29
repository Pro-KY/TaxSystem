package ua.training.persistance.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.mappers.EnitityMapper;

import java.util.List;

public class JdbcPagination<T>  { // implements Pageable<T>
//    private int[] pages;
    private long pageSize;
    private long offSet = 0;
    private long startVisibleIndex = 0;
    private long endVisibleIndex = 4;
    private long currentPageIndex;

    private long allRowsAmount;
    private long allPagesAmount;

    private static final int DEFAULT_PAGE_SIZE = 5;
    private static final int DEFAULT_START_INDEX = 0;

    private static final Logger LOGGER = LogManager.getLogger(JdbcPagination.class);

    private JdbcTemplate jdbcTemplate;

    public JdbcPagination(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1
    public void countAllRowsAmount(String sql) {
        allRowsAmount = jdbcTemplate.countRows(sql);
    }

    // 2
    public void setPageSize(int pageSize) {
        if(pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }

        allPagesAmount = allRowsAmount / pageSize;
        allPagesAmount += allPagesAmount % pageSize > 0 ? 1 : 0;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getOffSet() {
        return offSet;
    }

    public List<T> getpageResult(String sql, EnitityMapper<T> entityEnitityMapper) {
        return jdbcTemplate.finAll(sql, entityEnitityMapper, pageSize, offSet);
    }

    // when clicked directly on the number
    private void changePagePosition(int chosenPageIndx) { //1
        this.currentPageIndex = chosenPageIndx;
    }
//
//    private void changePagePosition(int chosenPageIndx) {
//        this.currentPageIndex = chosenPageIndx;
////        if (currentPageIndx == endPageIndx) {
////            // check if we have next pages
////        }
////
////        if (currentPageIndx == startPageIndx) {
////            // check if we have prev pages
////        }
//    }

    public void calculateOffset() { // 2
        offSet = (currentPageIndex * pageSize) - 1;
    }

    public void handleNextButton() {
        if(currentPageIndex < endVisibleIndex) { // 1,1
            currentPageIndex+=1;
            // change Offset
        } else if(currentPageIndex < allPagesAmount){
            shiftPagesIndexes(true);
        }
    }

    public void handleBackButton() {
        if(currentPageIndex > startVisibleIndex) { // 1.2
            currentPageIndex-=1;
            // change Offset
        } else if(currentPageIndex > DEFAULT_START_INDEX){
            shiftPagesIndexes(false);
        }
    }

//    public void handlePreviousPageClick() {
//        if(currentPageIndex > startVisibleIndex && currentPageIndex < endVisibleIndex) {
//            currentPageIndex-=1;
//        }
//
//
//        if(currentPageIndex == startVisibleIndex && currentPageIndex > DEFAULT_START_INDEX) {
//            shiftPagesIndexesBackward();
//        }
//    }

    private void shiftPagesIndexes(boolean forward) {
        startVisibleIndex += forward ? 1 : -1;
        endVisibleIndex += forward ? 1 : -1;
        currentPageIndex += forward ? 1 : -1;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
