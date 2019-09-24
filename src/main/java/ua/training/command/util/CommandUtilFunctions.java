package ua.training.command.util;

import ua.training.persistance.entities.Report;
import ua.training.persistance.entities.TaxType;
import ua.training.util.constans.Parameters;
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

    public static Function<HttpServletRequest, Optional<Report>> extractParamsIntoReport = request -> {
        Optional<Report> result = Optional.empty();

        final String reportType = request.getParameter(Parameters.REPORT_CONTENT_TYPE);
        if (reportType.equals(REPORT_TYPE_FORM)) {
            final String quarter = request.getParameter(Parameters.REPORT_QUARTER);
            final String sum = request.getParameter(Parameters.REPORT_SUM);
            final String taxTypeId = request.getParameter(Parameters.REPORT_TAXTYPE_ID);

            final TaxType taxType = new TaxType(Long.valueOf(taxTypeId), null);
            Report report = new Report.Builder().
                    quarter(Integer.valueOf(quarter))
                    .sum(Double.valueOf(sum))
                    .taxType(taxType).build();

            result = Optional.of(report);
        } else {
            try {
                final String reportContent = request.getParameter(Parameters.REPORT_CONTENT);

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
