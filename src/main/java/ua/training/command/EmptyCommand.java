package ua.training.command;

import ua.training.util.PropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class EmptyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
//        final ResourceBundle viewProperties = new PropertiesHandler().getViewProperties();
        final ResourceBundle viewProperties = PropertiesHandler.getInstance().getViewProperties();
        return viewProperties.getString("path.page.login");
    }
}
