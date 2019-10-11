package ua.training.command.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;
import ua.training.persistence.entities.User;
import ua.training.persistence.entities.UserType;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.function.Function;

public class CommandUtil {
    private static CommandUtil instance;
    private static final Logger log = LogManager.getLogger(CommandUtil.class);

    private CommandUtil() {}

    public static CommandUtil getInstance() {
        if (instance == null) {
            instance = new CommandUtil();
        }
        return instance;
    }

    public PaginationDto getCurrentPaginationDto(HttpSession session) {
        PaginationDto currentPaginationDto = (PaginationDto) session.getAttribute(Attributes.PAGINATION_INFO);
        if (currentPaginationDto == null) {
            currentPaginationDto = new PaginationDto();
        }

        return currentPaginationDto;
    }

    public Long getReportsApprovalTypeId(HttpSession session, HttpServletRequest request) {
        Long ReportsApprovalTypeId;

        final String stateApprovalIdParameter = request.getParameter(Parameters.REPORTS_APPROVAL_TYPE);

        if (stateApprovalIdParameter != null) {
            ReportsApprovalTypeId = Long.valueOf(stateApprovalIdParameter);
            session.setAttribute(Attributes.REPORTS_APPROVAL_TYPE, Long.valueOf(stateApprovalIdParameter));
        } else {
            ReportsApprovalTypeId = (Long) session.getAttribute(Attributes.REPORTS_APPROVAL_TYPE);
        }
        return ReportsApprovalTypeId;
    }

    public Function<HttpServletRequest, User> getUserMappingFunction = request -> {
        final String firstName = request.getParameter(Parameters.USER_FIRST_NAME);
        final String lastName = request.getParameter(Parameters.USER_LAST_NAME);
        final String email = request.getParameter(Parameters.EMAIL);
        final String password = request.getParameter(Parameters.PASSWORD);
        final String organization = request.getParameter(Parameters.USER_ORGANIZATION);
        final String address = request.getParameter(Parameters.USER_ADDRESS);
        final long userTypeId = Long.valueOf(request.getParameter(Parameters.USER_TYPE));
        return new User(firstName, lastName, organization, email, password, address, new UserType(userTypeId));
    };

}
