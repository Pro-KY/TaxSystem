package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;
import ua.training.dto.SentReportsDto;
import ua.training.service.SentReportsService;
import ua.training.service.ServiceFactory;
import ua.training.util.constans.Attributes;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.util.constans.Attributes.SENT_REPORTS_LIST;
import static ua.training.util.handler.properties.ViewPropertiesHandler.FRAGMENT_PATH_SENT_REPORTS;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class SentReportsCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SentReportsCommand.class);
    private SentReportsService sentReportsService;

    public SentReportsCommand() {
        this.sentReportsService = ServiceFactory.getSentReportsService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("in SentReportsCommand");
        request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
//        final int pageSize = (int) request.getSession().getAttribute(Attributes.PAGE_SIZE);
//        final int pageIndex = (int) request.getSession().getAttribute(Attributes.CURRENT_PAGE_INDEX);

        final int pageSize = 5;
        final int pageIndex = 0;
        final PaginationDto paginationDto = new PaginationDto(pageIndex, false, false, pageSize);

        final List<SentReportsDto> sentReports;
        try {
            sentReports = sentReportsService.getSentReports(paginationDto);
            request.setAttribute(SENT_REPORTS_LIST, sentReports);
            System.out.println(sentReports.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        request.setAttribute(Attributes.SENT_REPORTS_LIST, sentReports);
        // session pas pagination parameters
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
