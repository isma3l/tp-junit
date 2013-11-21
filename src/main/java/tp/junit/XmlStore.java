package tp.junit;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class XmlStore implements Store{
    Document doc;
    Element root;

    public XmlStore() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            root = doc.createElement("OKTest");
            doc.appendChild(root);
        } catch (ParserConfigurationException e) {

        }

    }
    private void agregarTest(Element blacklistelem, String TestCaseName) {
        Element nameTestCase = doc.createElement("testcase");
        Attr nameTC = doc.createAttribute("name");

        nameTC.setValue(TestCaseName);

        nameTestCase.setAttributeNode(nameTC);

        Attr nameElementTC = doc.createAttribute("name");
        nameElementTC.setValue(TestCaseName);

        blacklistelem.appendChild(nameTestCase);

    }
    public void guardar(String nameFile) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            Result result = new StreamResult(new java.io.File(nameFile + ".xml"));
            transformer.transform(source, result);
        } catch (TransformerException tfe) {
        }
    }
    @Override
    public void addTestToBlackList(ArrayList<TestState> blacklist) {
        Element blacklistelem = doc.createElement("Blacklist");
        Attr name = doc.createAttribute("name");
        name.isId();
        name.setValue("Blacklist");
        blacklistelem.setAttributeNode(name);
        root.appendChild(blacklistelem);

        for (TestState state : blacklist) {
                agregarTest(blacklistelem, state.getTestCaseName());
        }
    }

    @Override
    public ArrayList<TestState> getBlackList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
