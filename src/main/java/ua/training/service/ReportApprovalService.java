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
import ua.training.persistence.entities.StateApproval;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.MessagePropertiesHandler;

import java.util.List;
import java.util.stream.Collectors;

import static ua.training.util.handler.properties.MessagePropertiesHandler.SERVICE_NULL_ENTITY_ERROR;

public class ReportApprovalService {
    private static final Logger log = LogManager.getLogger(ReportApprovalService.class);
    private MysqlDaoFactory daoFactory;

    private static ReportApprovalService instance;

    public static ReportApprovalService getInstance() {
        if (instance == null) {
            instance = new ReportApprovalService();
        }
        return instance;
    }

    private ReportApprovalService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public ReportApproval getReportApprovalById(Long id) {
        return daoFactory.getReportApprovalDao()
                .findByIdJoinUser(id)
                .orElseThrow(() -> new ServiceException(MessagePropertiesHandler.getMessage(SERVICE_NULL_ENTITY_ERROR)));
    }

    public long countAllReportsApprovalForUser(Long userId) {
        return daoFactory.getReportApprovalDao().countAllRowsForUserById(userId);
    }

    public PaginationDto getReportsApprovalByStateApproval(PaginationDto paginationDto, StateApproval stateApproval) {
        final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();

        final PaginationHandler paginationHandler = new PaginationHandler(paginationDto);
        final long allRows = reportApprovalDao.countAllRowsByStateApproval(stateApproval);
        paginationHandler.setAllRowsAmount(allRows);
        paginationHandler.handlePagination();

        final List<ReportApproval> paginationList = reportApprovalDao.
                getReportApprovalListByStateApproval(paginationHandler.getPageSize(), paginationHandler.getOffSet(), stateApproval);

        final List<SentReportsDto> collect = paginationList.stream()
                .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                .collect(Collectors.toList());

        paginationDto.setPaginationList(collect);
        paginationHandler.updatePaginationInfo();

        return paginationHandler.getPaginationDto();
    }

    public PaginationDto getReportsApprovalForUser(PaginationDto paginationDto, Long userId) {
        final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();

        final PaginationHandler paginationHandler = new PaginationHandler(paginationDto);
        final long allRows = countAllReportsApprovalForUser(userId);
        paginationHandler.setAllRowsAmount(allRows);
        paginationHandler.handlePagination();

        final List<ReportApproval> paginationList = reportApprovalDao.
                getReportApprovalListByUserId(paginationHandler.getPageSize(), paginationHandler.getOffSet(), userId);

        final List<SentReportsDto> collect = paginationList.stream()
                .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                .collect(Collectors.toList());

        paginationDto.setPaginationList(collect);
        paginationHandler.updatePaginationInfo();

        return paginationHandler.getPaginationDto();
    }
}
