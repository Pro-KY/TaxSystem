package ua.training.util.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import ua.training.persistance.entities.Report;
import ua.training.persistance.entities.TaxType;
import ua.training.util.exceptions.FileParsingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XmlFileParserImpl implements FileParser<Report> {
    @Override
    public Report parseFile(String xml) throws FileParsingException{
        Report report = null;

        if (xml != null && !xml.isEmpty()) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(xml));
                final Document document = builder.parse(is);
                document.getDocumentElement().normalize();
                NodeList reportTags = document.getElementsByTagName("report");

                for (int i = 0; i < reportTags.getLength(); i++) {
                    Node nNode = reportTags.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;

                        final String quarter = eElement.getElementsByTagName("quarter").item(0).getTextContent().trim();

                        TaxType taxType = null;
                        NodeList taxTypeElements = document.getElementsByTagName("taxtype");
                        for (int j = 0; j < taxTypeElements.getLength(); j++) {
                            String id = eElement.getElementsByTagName("id").item(0).getTextContent().trim();
                            String taxTypeText = eElement.getElementsByTagName("type").item(0).getTextContent().trim();
                            taxType = new TaxType(Long.valueOf(id), taxTypeText);
                        }

                        final String sum = eElement.getElementsByTagName("sum").item(0).getTextContent().trim();

                        report = new Report.Builder().
                                quarter(Integer.valueOf(quarter))
                                .sum(Double.valueOf(sum))
                                .taxType(taxType).build();
                    }
                }

            } catch (Exception e) {
                throw new FileParsingException("error occur during xml file parsing");
            }
        }

        return report;
    }
}
