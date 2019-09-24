package ua.training.command.fragments;

import ua.training.command.ICommand;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class ReportFragmentCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("sendReport command");

        final String viewPath = getViewPath(PATH_USER_SEND_REPORT);
        request.setAttribute("fragmentPath", viewPath);

//        final TaxTypeService taxTypeService = ServiceFactory.getTaxTypeService();
//        final List<TaxType> allTaxTypes = taxTypeService.getAllTaxTypes();
//        request.setAttribute("allTaxTypes", allTaxTypes);

        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
