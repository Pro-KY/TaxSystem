package ua.training.persistance.dao;

import ua.training.persistance.beans.SendReportEvent;
import ua.training.persistance.dao.jdbc.pagination.Page;

import java.util.List;

public interface ISendReportEventDao extends IDao<SendReportEvent> {
    List<SendReportEvent> getPaginationList(Page page);
}
