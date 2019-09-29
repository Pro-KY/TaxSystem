package ua.training.util.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.training.persistance.entities.Report;
import ua.training.util.exceptions.FileParsingException;

public class JsonFileParserImpl implements FileParser<Report> {
    @Override
    public Report parseFile(String jsonContent) throws FileParsingException {
        Report report = null;

        try {
            if (jsonContent != null && !jsonContent.isEmpty()) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                report = gson.fromJson(jsonContent, Report.class);
            }
        } catch (Exception e) {
            throw new FileParsingException("error occur during json file parsing");
        }

        return report;
    }
}
