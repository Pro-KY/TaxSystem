package ua.training.persistence.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;

import java.util.List;

public class PaginationHandler<T> {
    private long pageSize;
    private long offSet = 0;
    private long startVisibleIndex;
    private long endVisibleIndex;
    private long currentPageIndex;

    private long allRowsAmount;
    private long allPagesAmount;

    private static final int DEFAULT_PAGE_SIZE = 3; // 5
    private static final int DEFAULT_START_INDEX = 0;
    private static final int DEFAULT_END_INDEX = 4;

    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private List<T> pageResult;

    private static final Logger log = LogManager.getLogger(PaginationHandler.class);

    public PaginationHandler(Long startVisibleIndex, Long endVisibleIndex, Long currentPageIndex) {
        this.startVisibleIndex = (startVisibleIndex != null) ? startVisibleIndex : DEFAULT_START_INDEX;
        this.endVisibleIndex = (endVisibleIndex != null) ? endVisibleIndex : DEFAULT_END_INDEX;
        this.currentPageIndex = (currentPageIndex != null) ? (Long) currentPageIndex : DEFAULT_START_INDEX;
//        changeButtonsState();
    }

    public void handlePagination() {
        calculateAllPagesAmount();
        calculateEndVisibleIndex();
        changeButtonsState();
    }

    public void setPaginationInfo(PaginationDto paginationDto) {
        paginationDto.setCurrentPageIndex(currentPageIndex);
        paginationDto.setStartPageIndex(startVisibleIndex);
        paginationDto.setEndPageIndex(endVisibleIndex);
        paginationDto.setLeftButtonDisabled(isLeftButtonDisabled);
        paginationDto.setRightButtonDisabled(isRightButtonDisabled);
        paginationDto.setAllPagesAmount(allPagesAmount);
        paginationDto.setPageSize(String.valueOf(pageSize));
    }

    public void setAllRowsAmount(long allRowsAmount) {
        this.allRowsAmount = allRowsAmount;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = (pageSize != null) ? Integer.valueOf(pageSize) : DEFAULT_PAGE_SIZE;
        log.info("page size: {}", pageSize);
//        calculateAllPagesAmount();
    }

    public void calculateAllPagesAmount() {
        allPagesAmount = allRowsAmount / this.pageSize;
        allPagesAmount += allPagesAmount % this.pageSize > 0 ? 1 : 0;
    }

    public void calculateEndVisibleIndex() {
        log.info("endVisibleIndex before - {}", endVisibleIndex);
        if (allPagesAmount == 0) {
            endVisibleIndex = 0;
        } else if(endVisibleIndex == 0 & allPagesAmount > DEFAULT_END_INDEX) {
            endVisibleIndex = DEFAULT_END_INDEX;
        } else if(allPagesAmount < DEFAULT_END_INDEX) {
            endVisibleIndex = allPagesAmount-1;
        }
        log.info("endVisibleIndex after - {}", endVisibleIndex);

    }

    // 3
    public void calculateOffset() { // 2
        offSet = currentPageIndex * pageSize;
    }

    public void handleNextButtonClick() {
        if(currentPageIndex < endVisibleIndex) {
            currentPageIndex += 1;
        } else if(currentPageIndex == endVisibleIndex) {
            shiftPagesIndexes(true);
        }
        changeButtonsState();
        calculateOffset();
    }

    public void handlePreviousButtonClick() {
        if(currentPageIndex > startVisibleIndex) {
            currentPageIndex-=1;
        } else if(currentPageIndex == startVisibleIndex) {
                shiftPagesIndexes(false);
        }
        changeButtonsState();
        calculateOffset();
    }

    public void changeButtonsState() {
        isLeftButtonDisabled = (currentPageIndex == startVisibleIndex) & (currentPageIndex == DEFAULT_START_INDEX);
        isRightButtonDisabled = currentPageIndex == allPagesAmount-1;
    }

    private void shiftPagesIndexes(boolean forward) {
        startVisibleIndex += forward ? 1 : -1;
        endVisibleIndex += forward ? 1 : -1;
        currentPageIndex += forward ? 1 : -1;

        log.info("shift indexes");
        log.info("startVisibleIndex - {}", startVisibleIndex);
        log.info("endVisibleIndex - {}", endVisibleIndex);
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
