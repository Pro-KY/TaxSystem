package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.service.SendReportService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.FRAGMENT_PATH_SENT_REPORTS;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class SentReportsCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SentReportsCommand.class);
    private SendReportService sendReportService;

    public SentReportsCommand() {
        this.sendReportService = new SendReportService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("in SentReportsCommand");
        request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SENT_REPORTS));

        final String pageOffset = request.getParameter(Parameters.PAGE_OFFSET);
        final String pageSize = request.getParameter(Parameters.PAGE_SIZE);

//        page page = new page(pageSize, pageOffset);
//        List<ReportApproval> pageList = null;
//        try {
//            pageList = sendReportService.getNexPage(page);
//            pageList.forEach(i -> {
//                if(i == null) System.out.println("one ell is null");
//                else {
//                    System.out.println(i.toString());
//                }
//            });
//            logger.info(pageList.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.debug(e.getMessage());
//        }

//        request.setAttribute(Attributes.PAGE_LIST, pageList);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
