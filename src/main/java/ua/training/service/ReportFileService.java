package ua.training.service;

import ua.training.dto.SendReportDto;
import ua.training.persistence.entities.Report;
import ua.training.util.constans.ReportContentType;
import ua.training.util.exceptions.FileParsingException;
import ua.training.util.parsers.FileParser;
import ua.training.util.parsers.JsonFileParserImpl;
import ua.training.util.parsers.XmlFileParserImpl;

import java.util.Optional;

public class ReportFileService {

    private static ReportFileService instance;

    public static ReportFileService getInstance() {
        if (instance == null) {
            instance = new ReportFileService();
        }
        return instance;
    }

    private ReportFileService() {}

    public Optional<Report> parseReportFile(SendReportDto sendReportDto) {
        Optional<Report> result = Optional.empty();

        try {
            final String reportFileContent = sendReportDto.getReportFileContent();
            boolean isReportTypeJson = sendReportDto.getReportContentTypeId() == ReportContentType.JSON.getId();

            if (reportFileContent != null && !reportFileContent.isEmpty()) {
                FileParser<Report> fileParser = isReportTypeJson ? new JsonFileParserImpl() : new XmlFileParserImpl();
                final Report reportFromFile = fileParser.parseFile(reportFileContent);
                result = Optional.of(reportFromFile);
            }
        } catch (FileParsingException e) {
            result = Optional.empty();
            e.printStackTrace();
        }

        return result;
    }
}
