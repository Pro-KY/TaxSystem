import ua.training.persistance.beans.User;
import ua.training.persistance.dao.daoimpl.UserDaoImpl;
import ua.training.util.exceptions.DaoException;
import ua.training.util.exceptions.FileParsingException;
import ua.training.util.parsers.FileParser;
import ua.training.util.parsers.JsonFileParserImpl;
import ua.training.util.parsers.XmlFileParserImpl;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<report>\n" +
                "\t<quarter>\n" +
                "\t\t3\n" +
                "   </quarter>\n" +
                "   \n" +
                "   <taxtype>\n" +
                "\t\tТуристичний збір\n" +
                "   </taxtype>\n" +
                "\n" +
                "\t<sum>\n" +
                "\t\t1200\n" +
                "   </sum>\n" +
                "</report>";

        String json = "{\n" +
                "\ttaxtype: \"Єдиний податок (ЕП)\",\n" +
                "\tsum: 1366,\n" +
                "\tquarter: 2\n" +
                "}";

        XmlFileParserImpl xmlFileParser = new XmlFileParserImpl();
        FileParser jsonparser = new JsonFileParserImpl();
        try {
            jsonparser.parseFile(json);
        } catch (FileParsingException e) {
            e.printStackTrace();
        }
    }

}
