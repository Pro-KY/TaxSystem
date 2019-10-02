package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.DtoMapper;
import ua.training.dto.PaginationDto;
import ua.training.dto.SentReportsDto;
import ua.training.persistence.dao.IReportApprovalDao;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.dao.jdbc.PaginationHandler;
import ua.training.persistence.entities.ReportApproval;

import java.util.List;
import java.util.stream.Collectors;

public class SentReportsService {
    private static final Logger log = LogManager.getLogger(SentReportsService.class);
    private MysqlDaoFactory daoFactory;

    private static SentReportsService instance;

    public static SentReportsService getInstance() {
        if (instance == null) {
            instance = new SentReportsService();
        }
        return instance;
    }

    private SentReportsService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    // PaginationHandler as a return type
//    public List<SentReportsDto> getSentReports(PaginationDto paginationDto) {
    public PaginationHandler<SentReportsDto> getSentReports(PaginationDto paginationDto) {
        final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();
        final long allRows = reportApprovalDao.countAllRows();
        log.info("allRows {}", allRows);
        final Long userId = paginationDto.getUserId();

        final Long startVisibleIndex = paginationDto.getStartPageIndex();
        final Long endVisibleIndex = paginationDto.getEndPageIndex();
        final Long currentPageIndex = paginationDto.getCurrentPageIndex();

        PaginationHandler<SentReportsDto> paginationHandler = new PaginationHandler<>(startVisibleIndex, endVisibleIndex, currentPageIndex);
        paginationHandler.setAllRowsAmount(allRows);
        paginationHandler.setPageSize(paginationDto.getPageSize());
        paginationHandler.handlePagination();

        if(paginationDto.getNextClicked()) {
            paginationHandler.handleNextButtonClick();
        } else if (paginationDto.getPreviousClicked()) {
            paginationHandler.handlePreviousButtonClick();
        } else {
            paginationHandler.calculateOffset();
        }

        final List<ReportApproval> paginationList = reportApprovalDao.getPaginationList(paginationHandler.getPageSize(), paginationHandler.getOffSet(), userId);

        final List<SentReportsDto> collect = paginationList.stream()
                .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                .collect(Collectors.toList());
        paginationHandler.setPageResult(collect);
        return paginationHandler;
    }
}
