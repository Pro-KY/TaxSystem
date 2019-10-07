package ua.training.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.util.constans.Parameters;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

public class PaginationDto implements Serializable {
    private static final Logger log = LogManager.getLogger(PaginationDto.class);

    private Long currentPageIndex;
    private Boolean isNextClicked;
    private Boolean isPreviousClicked;
    private String pageSize;
    private Long userId;
    private static final long DEFAULT_START_INDEX = 0;
    private static final long DEFAULT_REPORTS_APPOROVAL_TYPE = 4;

    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private Long startPageIndex;
    private Long endPageIndex;
    private long allPagesAmount;
    private Long approvalReportsTypeId;

    private List paginationList;


    public void setPaginationRequestContent(HttpServletRequest request) {
        String selectedPageIndex = request.getParameter(Parameters.SELECTED_PAGE_INDEX);
        final String pageSize = request.getParameter(Parameters.PAGE_SIZE);
        final String isNextClicked = request.getParameter(Parameters.NEXT_PAGE_CLICK);
        final String isPreviousClicked = request.getParameter(Parameters.PREV_PAGE_CLICK);
        final String allReportsType = request.getParameter(Parameters.REPORTS_APPROVAL_TYPE);

        if (selectedPageIndex == null && currentPageIndex != null) {
            selectedPageIndex = currentPageIndex.toString();
        }

        this.currentPageIndex = (selectedPageIndex != null) ? Long.valueOf(selectedPageIndex) : DEFAULT_START_INDEX;
        this.isNextClicked = (isNextClicked != null) ? Boolean.valueOf(isNextClicked) : false;
        this.isPreviousClicked = (isPreviousClicked != null) ? Boolean.valueOf(isPreviousClicked) : false;
        this.approvalReportsTypeId = (allReportsType != null) ? Long.valueOf(allReportsType) : DEFAULT_REPORTS_APPOROVAL_TYPE;
        log.info("approvalReportsTypeId = {}", this.approvalReportsTypeId);

        this.pageSize = pageSize;
    }

    public Long getApprovalReportsTypeId() {
        return approvalReportsTypeId;
    }

    public void setApprovalReportsTypeId(Long approvalReportsTypeId) {
        this.approvalReportsTypeId = approvalReportsTypeId;
    }

    public List getPaginationList() {
        return paginationList;
    }

    public void setPaginationList(List paginationList) {
        this.paginationList = paginationList;
    }

    public PaginationDto() {
        currentPageIndex = DEFAULT_START_INDEX;
        this.isNextClicked =  false;
        this.isPreviousClicked = false;
    }

    public Long getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Long selectedPageIndex) {
        this.currentPageIndex = selectedPageIndex;
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
