package ua.training.command.util;

public class CommandFunctions {
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
