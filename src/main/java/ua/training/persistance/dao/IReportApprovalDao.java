package ua.training.persistance.dao;

import ua.training.persistance.entities.ReportApproval;

import java.util.List;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApproval> getPaginationList(long pageSize, long offSet, long userId);
    long countAllRows();
}
