package ua.training.persistance.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;

public class PaginationHandler { // implements Pageable<T>
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

    private static final Logger LOGGER = LogManager.getLogger(PaginationHandler.class);

    public PaginationHandler(PaginationDto paginationDto) {
        setPageSize(paginationDto.getPageSize());
        currentPageIndex = (paginationDto.getCurrentPageIndex() != null) ? (Long) paginationDto.getCurrentPageIndex() : DEFAULT_START_INDEX;
    }

    public void setAllRowsAmount(long allRowsAmount) {
        this.allRowsAmount = allRowsAmount;
    }

    // 2
    private void setPageSize(String pageSize) {
       this.pageSize = (pageSize != null) ? Integer.valueOf(pageSize) : DEFAULT_PAGE_SIZE;

        allPagesAmount = allRowsAmount / this.pageSize;
        allPagesAmount += allPagesAmount % this.pageSize > 0 ? 1 : 0;
    }

    // 3
    public void calculateOffset() { // 2
        offSet = currentPageIndex * pageSize;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getOffSet() {
        return offSet;
    }

    // when clicked directly on the number
//    private void changePagePosition(int chosenPageIndx) { //1
//        this.currentPageIndex = chosenPageIndx;
//    }

    public void handleNextButtonClick() {
        if(currentPageIndex < endVisibleIndex) { // 1,1
            currentPageIndex+=1;
            // change Offset
        } else if(currentPageIndex < allPagesAmount){
            shiftPagesIndexes(true);
        }
    }

    public void handleBackButtonClick() {
        if(currentPageIndex > startVisibleIndex) { // 1.2
            currentPageIndex-=1;
            // change Offset
        } else if(currentPageIndex > DEFAULT_START_INDEX){
            shiftPagesIndexes(false);
        }
    }

    private void shiftPagesIndexes(boolean forward) {
        startVisibleIndex += forward ? 1 : -1;
        endVisibleIndex += forward ? 1 : -1;
        currentPageIndex += forward ? 1 : -1;
    }
}
