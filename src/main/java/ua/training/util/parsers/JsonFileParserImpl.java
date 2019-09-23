package ua.training.util.parsers;

import org.json.JSONException;
import org.json.JSONObject;
import ua.training.persistance.beans.Report;
import ua.training.persistance.beans.TaxType;
import ua.training.util.exceptions.FileParsingException;

public class JsonFileParserImpl implements FileParser<Report> {
    @Override
    public Report parseFile(String jsonContent) throws FileParsingException {
        Report report = null;

        try {
            if (jsonContent != null && !jsonContent.isEmpty()) {
                JSONObject jsonObject = new JSONObject(jsonContent);
                final String taxtype = jsonObject.getString("taxtype");
                final double sum = jsonObject.getDouble("sum");
                final int quarter = jsonObject.getInt("quarter");


                final TaxType taxType = new TaxType(taxtype);
                report = new Report.Builder().
                        quarter(quarter)
                        .sum(sum)
                        .taxType(taxType).build();
            }
        } catch (JSONException e) {
            throw new FileParsingException("error occur during json file parsing");
        }

        return report;
    }
}
