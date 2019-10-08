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
import ua.training.persistence.entities.User;
import ua.training.util.constans.StateApprovalEnum;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.properties.MessageProperties;

import java.util.List;
import java.util.stream.Collectors;

import static ua.training.util.properties.MessageProperties.SERVICE_NULL_ENTITY_ERROR;

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

    public PaginationDto getUntreatedReports(PaginationDto paginationDto, StateApproval stateApproval, User inspector) {
        final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();

        boolean isStateApprovalProcessing = stateApproval.getId().equals(StateApprovalEnum.PROCESSING.getStateId());

        final PaginationHandler paginationHandler = new PaginationHandler(paginationDto);
        final long allRows = isStateApprovalProcessing ?
                reportApprovalDao.countAllByStateApproval(stateApproval) :
                reportApprovalDao.countAllByStateApprovalAndInspector(stateApproval, inspector);

        paginationHandler.setAllRowsAmount(allRows);
        paginationHandler.handlePagination();

        List<ReportApproval> paginationList;
        final long pageSize = paginationHandler.getPageSize();
        final long offSet = paginationHandler.getOffSet();

        if(isStateApprovalProcessing) {
            paginationList = reportApprovalDao.getReportApprovalListByStateApproval(pageSize, offSet, stateApproval);
        } else {
            paginationList = reportApprovalDao.getReportApprovalListByStateAndInspector(pageSize, offSet, stateApproval, inspector);
        }

        final List<SentReportsDto> collect = paginationList.stream()
                .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                .collect(Collectors.toList());

        paginationDto.setPaginationList(collect);
        paginationHandler.updatePaginationInfo();

        return paginationHandler.getPaginationDto();
    }


    public void updateReportApproval(Long reportApprovalId, String refusalCause, Long stateApprovalId) {
        final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();

        final ReportApproval reportApproval = reportApprovalDao
                .findById(reportApprovalId)
                .orElseThrow(() -> new ServiceException(MessageProperties.getMessage(SERVICE_NULL_ENTITY_ERROR)));

        reportApproval.setRefusalCause(refusalCause);
        reportApproval.setStateApproval(new StateApproval(stateApprovalId));
        reportApprovalDao.update(reportApproval);
    }

    public ReportApproval getReportApprovalById(Long id) {
        return daoFactory.getReportApprovalDao()
                .findByIdJoinUser(id)
                .orElseThrow(() -> new ServiceException(MessageProperties.getMessage(SERVICE_NULL_ENTITY_ERROR)));
    }

    public long countAllReportsApprovalForUser(Long userId) {
        return daoFactory.getReportApprovalDao().countAllForUserById(userId);
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
