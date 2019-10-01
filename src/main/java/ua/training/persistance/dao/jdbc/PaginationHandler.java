package ua.training.persistance.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;

import java.util.List;

public class PaginationHandler<T> {
    private long pageSize;
    private long offSet = 0;
    private long startVisibleIndex = 0;
    private long endVisibleIndex = 4;
    private long currentPageIndex;

    private long allRowsAmount;
    private long allPagesAmount;

    private static final int DEFAULT_PAGE_SIZE = 3; // 5
    private static final int DEFAULT_START_INDEX = 0;

    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private List<T> pageResult;

    private static final Logger log = LogManager.getLogger(PaginationHandler.class);


    public void setPaginationInfo(PaginationDto paginationDto) {
        paginationDto.setCurrentPageIndex(currentPageIndex);
        paginationDto.setEndVisibleIndex(endVisibleIndex);
        paginationDto.setStartVisibleIndex(startVisibleIndex);
        paginationDto.setLeftButtonDisabled(isLeftButtonDisabled);
        paginationDto.setRightButtonDisabled(isRightButtonDisabled);
        paginationDto.setAllPagesAmount(allPagesAmount);
    }

    public void setPageCurrentIndex(Long currentIndex) {
        currentPageIndex = (currentIndex != null) ? (Long) currentIndex : DEFAULT_START_INDEX;
        isLeftButtonDisabled = (currentPageIndex == startVisibleIndex);
        isRightButtonDisabled = currentPageIndex == endVisibleIndex;
    }

    public void setAllRowsAmount(long allRowsAmount) {
        this.allRowsAmount = allRowsAmount;
    }

    // 2
    public void setPageSize(String pageSize) {
        this.pageSize = (pageSize != null) ? Integer.valueOf(pageSize) : DEFAULT_PAGE_SIZE;
        log.info("page size: {}", pageSize);


        allPagesAmount = allRowsAmount / this.pageSize;
        allPagesAmount += allPagesAmount % this.pageSize > 0 ? 1 : 0;
    }

    // 3
    public void calculateOffset() { // 2
        offSet = currentPageIndex * pageSize;
    }

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

    public boolean isLeftButtonDisabled() {
        return isLeftButtonDisabled;
    }


    public boolean isRightButtonDisabled() {
        return isRightButtonDisabled;
    }

    public List<T> getPageResult() {
        return pageResult;
    }

    public void setPageResult(List<T> pageResult) {
        this.pageResult = pageResult;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getOffSet() {
        return offSet;
    }
}
