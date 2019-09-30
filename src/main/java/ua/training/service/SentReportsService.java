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
    private static final Logger LOGGER = LogManager.getLogger(SentReportsService.class);
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

    public List<SentReportsDto> getSentReports(PaginationDto paginationDto) {
        final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();
        final long allRows = reportApprovalDao.countAllRows();
        final Long userId = paginationDto.getUserId();

        PaginationHandler paginationHandler = new PaginationHandler(paginationDto);
        paginationHandler.setAllRowsAmount(allRows);
        paginationHandler.calculateOffset();

        final List<ReportApproval> paginationList = reportApprovalDao.getPaginationList(paginationHandler.getPageSize(), paginationHandler.getOffSet(), userId);
        return paginationList.stream()
                    .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                    .collect(Collectors.toList());
    }
}
