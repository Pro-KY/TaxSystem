package ua.training.dto;

import java.io.Serializable;

public class PaginationDto implements Serializable {
    private Long currentPageIndex;
    private String isNextClicked;
    private String isPreviousClicked;
    private String pageSize;
    private Long userId;
    private static final int DEFAULT_START_INDEX = 0;

    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private long startVisibleIndex;
    private long endVisibleIndex;
    private long allPagesAmount;

    public PaginationDto(Object pageIndex, String pageSize, String isNextClicked, String isPreviousClicked) {
        currentPageIndex = (pageIndex != null) ? (Long) pageIndex : DEFAULT_START_INDEX;
        this.isNextClicked = isNextClicked;
        this.isPreviousClicked = isPreviousClicked;
        this.pageSize = pageSize;
    }

    public Long getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Long currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public String getIsNextClicked() {
        return isNextClicked;
    }

    public void setIsNextClicked(String isNextClicked) {
        this.isNextClicked = isNextClicked;
    }

    public String getIsPreviousClicked() {
        return isPreviousClicked;
    }

    public void setIsPreviousClicked(String isPreviousClicked) {
        this.isPreviousClicked = isPreviousClicked;
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

    public long getStartVisibleIndex() {
        return startVisibleIndex;
    }

    public void setStartVisibleIndex(long startVisibleIndex) {
        this.startVisibleIndex = startVisibleIndex;
    }

    public long getEndVisibleIndex() {
        return endVisibleIndex;
    }

    public void setEndVisibleIndex(long endVisibleIndex) {
        this.endVisibleIndex = endVisibleIndex;
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
                ", startVisibleIndex=" + startVisibleIndex +
                ", endVisibleIndex=" + endVisibleIndex +
                ", currentPageIndex=" + currentPageIndex +
                '}';
    }
}
