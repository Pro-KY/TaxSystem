package ua.training.command.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;
import ua.training.util.constans.Attributes;

import javax.servlet.http.HttpSession;

public class CommandUtil {
    private static CommandUtil instance;
    private static final Logger log = LogManager.getLogger(CommandUtil.class);

    private CommandUtil() { }

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

}
