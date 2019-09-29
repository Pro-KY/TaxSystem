package ua.training.dto;

import java.sql.Timestamp;

public class ReportApprovalDto {
    Long reportNumber;
    String approvalState;
    String inspectorName;
    Timestamp sentDate;
}
