package ua.training.persistence.dao;

import ua.training.persistence.entities.ReportApproval;
import ua.training.persistence.entities.StateApproval;

import java.util.List;
import java.util.Optional;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApproval> getReportApprovalListByUserId(long pageSize, long offSet, long userId);
    long countAllRowsForUserById(Long userId);
    long countAllRowsByStateApproval(StateApproval stateApproval);
    Optional<ReportApproval> findByIdJoinReportJoinInspector(Long id);
    Optional<ReportApproval> findByIdJoinUser(Long id);
    List<ReportApproval> getReportApprovalListByStateApproval(long pageSize, long offSet, StateApproval stateApproval);

}
