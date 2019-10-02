package ua.training.persistence.dao;

import ua.training.persistence.entities.ReportApproval;

import java.util.List;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApproval> getPaginationList(long pageSize, long offSet, long userId);
    long countAllRows();
}
