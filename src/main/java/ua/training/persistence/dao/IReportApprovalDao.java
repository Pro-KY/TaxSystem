package ua.training.persistence.dao;

import ua.training.persistence.entities.ReportApproval;

import java.util.List;
import java.util.Optional;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApproval> getReportApprovalListByUserId(long pageSize, long offSet, long userId);
    long countAllRowsForUserById(Long userId);
    Optional<ReportApproval> findByIdJoinReportJoinInspector(Long id);
    Optional<ReportApproval> findByIdJoinUser(Long id);
}
