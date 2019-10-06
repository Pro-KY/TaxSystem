package ua.training.persistence.dao;

import ua.training.persistence.entities.ReportApproval;

import java.util.List;
import java.util.Optional;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApproval> getReportApprovalByUserId(long pageSize, long offSet, long userId);
    long countAllRows();
    Optional<ReportApproval> findByIdJoinReportJoinInspector(Long id);
}
