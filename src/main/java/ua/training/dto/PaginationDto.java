package ua.training.dto;

public class PaginationDto {
    private long currentPageIndex;
    private boolean selectionAction;
    private boolean nextPageAction;
    private int pageSize;

    public PaginationDto(long currentPageIndex, boolean selectionAction, boolean nextPageAction, int pageSize) {
        this.currentPageIndex = currentPageIndex;
        this.selectionAction = selectionAction;
        this.nextPageAction = nextPageAction;
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(long currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public boolean isSelectionAction() {
        return selectionAction;
    }

    public void setSelectionAction(boolean selectionAction) {
        this.selectionAction = selectionAction;
    }

    public boolean isNextPageAction() {
        return nextPageAction;
    }

    public void setNextPageAction(boolean nextPageAction) {
        this.nextPageAction = nextPageAction;
    }
}
