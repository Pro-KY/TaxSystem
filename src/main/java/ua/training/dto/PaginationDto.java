package ua.training.dto;

import java.io.Serializable;

public class PaginationDto implements Serializable {
    private Long currentPageIndex;
    private Boolean isNextClicked;
    private Boolean isPreviousClicked;
    private String pageSize;
    private Long userId;
    private static final long DEFAULT_START_INDEX = 0;

    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private Long startPageIndex;
    private Long endPageIndex;
    private long allPagesAmount;

    public PaginationDto(String pageIndex, String pageSize, String isNextClicked, String isPreviousClicked, Long startPageIndex, Long endPageIndex) {
        currentPageIndex = (pageIndex != null) ? Long.valueOf(pageIndex) : DEFAULT_START_INDEX;
        this.isNextClicked = (isNextClicked != null) ? Boolean.valueOf(isNextClicked) : false;
        this.isPreviousClicked = (isPreviousClicked != null) ? Boolean.valueOf(isPreviousClicked) : false;
        this.pageSize = pageSize;
        this.startPageIndex = startPageIndex;
        this.endPageIndex = endPageIndex;
    }

    public PaginationDto() {
        currentPageIndex = DEFAULT_START_INDEX;
        this.isNextClicked =  false;
        this.isPreviousClicked = false;
    }

    public Long getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Long currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public Boolean getNextClicked() {
        return isNextClicked;
    }

    public void setNextClicked(Boolean nextClicked) {
        isNextClicked = nextClicked;
    }

    public Boolean getPreviousClicked() {
        return isPreviousClicked;
    }

    public void setPreviousClicked(Boolean previousClicked) {
        isPreviousClicked = previousClicked;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean getIsLeftButtonDisabled() {
        return isLeftButtonDisabled;
    }

    public void setLeftButtonDisabled(boolean leftButtonDisabled) {
        isLeftButtonDisabled = leftButtonDisabled;
    }

    public boolean getIsRightButtonDisabled() {
        return isRightButtonDisabled;
    }

    public void setRightButtonDisabled(boolean rightButtonDisabled) {
        isRightButtonDisabled = rightButtonDisabled;
    }

    public Long getStartPageIndex() {
        return startPageIndex;
    }

    public void setStartPageIndex(long startPageIndex) {
        this.startPageIndex = startPageIndex;
    }

    public Long getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(long endPageIndex) {
        this.endPageIndex = endPageIndex;
    }

    public long getAllPagesAmount() {
        return allPagesAmount;
    }

    public void setAllPagesAmount(long allPagesAmount) {
        this.allPagesAmount = allPagesAmount;
    }

    @Override
    public String toString() {
        return "PaginationDto{" +
                "isLeftButtonDisabled=" + isLeftButtonDisabled +
                ", isRightButtonDisabled=" + isRightButtonDisabled +
                ", startPageIndex=" + startPageIndex +
                ", endPageIndex=" + endPageIndex +
                ", currentPageIndex=" + currentPageIndex +
                ", isNextClicked=" + isNextClicked +
                ", isPreviousClicked=" + isPreviousClicked +
                '}';
    }
}
