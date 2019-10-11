package ua.training.persistence.dao;

import ua.training.persistence.entities.ReportApproval;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.User;

import java.util.List;
import java.util.Optional;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApproval> getReportApprovalListByUserId(long pageSize, long offSet, long userId);
    long countAllbyUserId(Long userId);
    long countAllByStateApproval(StateApproval stateApproval);
    long countAllByStateApprovalAndInspector(StateApproval stateApproval, User user);
    Optional<ReportApproval> findByIdJoinReportJoinInspector(Long id);
    Optional<ReportApproval> findByIdJoinReportJoinUser(Long id);
    Optional<ReportApproval> findByIdJoinUser(Long id);
    List<ReportApproval> getReportApprovalListByStateApproval(long pageSize, long offSet, StateApproval stateApproval);
    List<ReportApproval> getReportApprovalListByStateAndInspector(long pageSize, long offSet, StateApproval stateApproval, User inspector);

}
