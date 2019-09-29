package ua.training.persistance.dao;

import ua.training.dto.PaginationDto;
import ua.training.dto.ReportApprovalDto;
import ua.training.persistance.entities.ReportApproval;

import java.util.List;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    List<ReportApprovalDto> getPaginationList(PaginationDto page);
}
