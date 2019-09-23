package ua.training.util.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import ua.training.persistance.beans.Report;
import ua.training.persistance.beans.TaxType;
import ua.training.util.exceptions.FileParsingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
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
                NodeList nList = document.getElementsByTagName("report");

                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        final String quarter = eElement.getElementsByTagName("quarter").item(0).getTextContent().trim();
                        final String taxtype = eElement.getElementsByTagName("taxtype").item(0).getTextContent().trim();
                        final String sum = eElement.getElementsByTagName("sum").item(0).getTextContent().trim();

                        final TaxType taxType = new TaxType(taxtype);
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
