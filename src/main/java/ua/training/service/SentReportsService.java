package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.DtoMapper;
import ua.training.dto.PaginationDto;
import ua.training.dto.SentReportsDto;
import ua.training.persistance.dao.IReportApprovalDao;
import ua.training.persistance.dao.factory.MysqlDaoFactory;
import ua.training.persistance.dao.jdbc.PaginationHandler;
import ua.training.persistance.entities.ReportApproval;

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

        PaginationHandler<SentReportsDto> paginationHandler = new PaginationHandler<>();
        paginationHandler.setAllRowsAmount(allRows);
        paginationHandler.setPageSize(paginationDto.getPageSize());
        paginationHandler.setPageCurrentIndex(paginationDto.getCurrentPageIndex());
        paginationHandler.calculateOffset();

        final List<ReportApproval> paginationList = reportApprovalDao.getPaginationList(paginationHandler.getPageSize(), paginationHandler.getOffSet(), userId);
//        return paginationList.stream()
//                    .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
//                    .collect(Collectors.toList());

        final List<SentReportsDto> collect = paginationList.stream()
                .peek(reportApproval -> System.out.println(reportApproval.toString()))
                .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                .collect(Collectors.toList());
        paginationHandler.setPageResult(collect);
        return paginationHandler;
    }
}
