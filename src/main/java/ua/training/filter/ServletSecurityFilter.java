package ua.training.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.util.constans.Attributes;
import ua.training.util.properties.ViewProperties;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ua.training.util.properties.ViewProperties.FRAGMENT_PATH_SENT_REPORTS;
import static ua.training.util.properties.ViewProperties.PATH_MAIN;

public class ServletSecurityFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(ServletSecurityFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        logger.info("I'm here");

        if (session != null) {
            final Object isAuthorized = session.getAttribute(Attributes.IS_USER_AUTHORIZED);

            logger.info("isAuthorized - {}", isAuthorized);

            if(isAuthorized != null && (Boolean) isAuthorized) {
                final RequestDispatcher requestDispatcher = servletRequest.getServletContext().getRequestDispatcher(ViewProperties.getViewPath(PATH_MAIN));
                req.setAttribute(Attributes.FRAGMENT_PATH, ViewProperties.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
                requestDispatcher.forward(req, resp);
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() { }
}
