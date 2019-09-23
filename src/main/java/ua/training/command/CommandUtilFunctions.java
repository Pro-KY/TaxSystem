package ua.training.command;

import ua.training.persistance.beans.Report;
import ua.training.persistance.beans.TaxType;
import ua.training.util.RequestParameters;
import ua.training.util.exceptions.FileParsingException;
import ua.training.util.parsers.FileParser;
import ua.training.util.parsers.JsonFileParserImpl;
import ua.training.util.parsers.XmlFileParserImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.function.Function;

public class CommandUtilFunctions {
    private static final String REPORT_TYPE_FORM = "Form";
    private static final String REPORT_TYPE_JSON = "JSON";

    static Function<HttpServletRequest, Optional<Report>> extractParamsIntoReport = request -> {
        Optional<Report> result = Optional.empty();

        final String reportType = request.getParameter(RequestParameters.REPORT_CONTENT_TYPE);
        if (reportType.equals(REPORT_TYPE_FORM)) {
            final String quarter = request.getParameter(RequestParameters.REPORT_QUARTER);
            final String sum = request.getParameter(RequestParameters.REPORT_SUM);
            final String taxTypeJson = request.getParameter(RequestParameters.REPORT_TAXTYPE);

            final TaxType taxType = new TaxType(taxTypeJson);
            Report report = new Report.Builder().
                    quarter(Integer.valueOf(quarter))
                    .sum(Double.valueOf(sum))
                    .taxType(taxType).build();

            result = Optional.of(report);
        } else {
            try {
                final String reportContent = request.getParameter(RequestParameters.REPORT_CONTENT);

                if (reportContent != null && !reportContent.isEmpty()) {
                    FileParser<Report> fileParser =  reportType.equals(REPORT_TYPE_JSON) ? new JsonFileParserImpl() : new XmlFileParserImpl();
                    final Report reportFromFile = fileParser.parseFile(reportContent);
                    result = Optional.of(reportFromFile);
                }
            } catch (FileParsingException e) {
                // log
                result = Optional.empty();
                e.printStackTrace();
            }
        }
        return result;
    };
}
