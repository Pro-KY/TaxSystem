package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;
import ua.training.dto.SentReportsDto;
import ua.training.persistance.dao.jdbc.PaginationHandler;
import ua.training.persistance.entities.User;
import ua.training.service.SentReportsService;
import ua.training.service.ServiceFactory;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        //TODO: map via json mapper
        final Object pageIndex = request.getSession().getAttribute(Attributes.CURRENT_PAGE_INDEX);
        final String pageSize = request.getParameter(Parameters.PAGE_SIZE);
        final String isNextClicked = request.getParameter(Parameters.NEXT_PAGE_CLICK);
        final String isPreviousClicked = request.getParameter(Parameters.PREV_PAGE_CLICK);
        final HttpSession session = request.getSession();

        final User user = (User) session.getAttribute(Attributes.USER);
        final PaginationDto paginationDto = new PaginationDto(pageIndex, pageSize, isNextClicked, isPreviousClicked);
        paginationDto.setUserId(user.getId());

        final PaginationHandler<SentReportsDto> paginationHandler = sentReportsService.getSentReports(paginationDto);
        final List<SentReportsDto> sentReports = paginationHandler.getPageResult();
        paginationHandler.setPaginationDtoData(paginationDto);

        session.setAttribute(Attributes.CURRENT_PAGE_INDEX, paginationDto.getCurrentPageIndex());
        request.setAttribute(SENT_REPORTS_LIST, sentReports);
        request.setAttribute(Attributes.PAGINATION_INFO, paginationDto);

        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
