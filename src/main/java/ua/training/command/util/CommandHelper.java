package ua.training.command.util;

import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constans.Attributes.ERROR_CODE;
import static ua.training.util.constans.Attributes.ERROR_MSG;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_ERROR;

public class CommandHelper {
    public static String getErrorPage(HttpServletRequest request) {
        request.setAttribute(ERROR_CODE, 11); // just for testing purposes
        request.setAttribute(ERROR_MSG, "error =(");
        return ViewPropertiesHandler.getViewPath(PATH_ERROR);
    }
//    public static Function<SendReportDto, Optional<Report>> parseReportFile = dto -> {
//        Optional<Report> result = Optional.empty();
//
//            try {
//                final String reportFileContent = dto.getReportFileContent();
//                boolean isReportTypeJson = dto.getReportContentTypeId() == ReportContentType.FORM.getId();
//
//                if (reportFileContent != null && !reportFileContent.isEmpty()) {
//                    FileParser<Report> fileParser = isReportTypeJson ? new JsonFileParserImpl() : new XmlFileParserImpl();
//                    final Report reportFromFile = fileParser.parseFile(reportFileContent);
//                    result = Optional.of(reportFromFile);
//                }
//            } catch (FileParsingException e) {
//                // log
//                result = Optional.empty();
//                e.printStackTrace();
//            }
//
//        return result;
//    };
}
