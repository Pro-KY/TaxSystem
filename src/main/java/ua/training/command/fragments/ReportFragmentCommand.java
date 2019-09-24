package ua.training.command.fragments;

import ua.training.command.ICommand;
import ua.training.persistance.entities.TaxType;
import ua.training.service.ServiceFactory;
import ua.training.service.TaxTypeService;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class ReportFragmentCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("sendReport command");

        final String parameter = request.getParameter("sum");
        System.out.println(parameter);

        final String viewPath = getViewPath(PATH_USER_SEND_REPORT);
        request.setAttribute("fragmentPath", viewPath);

        final TaxTypeService taxTypeService = ServiceFactory.getTaxTypeService();
        final List<TaxType> allTaxTypes = taxTypeService.getAllTaxTypes();
        request.setAttribute("allTaxTypes", allTaxTypes);

        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
