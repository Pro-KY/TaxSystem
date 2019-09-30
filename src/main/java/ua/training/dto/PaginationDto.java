package ua.training.dto;

public class PaginationDto {
    private Object currentPageIndex;
    private String isNextClicked;
    private String isPreviousClicked;
    private String pageSize;
    private Long userId;

    public PaginationDto(Object pageIndex, String pageSize, String isNextClicked, String isPreviousClicked) {
        currentPageIndex = pageIndex;
        this.isNextClicked = isNextClicked;
        this.isPreviousClicked = isPreviousClicked;
        this.pageSize = pageSize;
    }

    public Object getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Object currentPageIndex) {
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
}
