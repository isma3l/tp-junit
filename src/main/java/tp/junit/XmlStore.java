package tp.junit;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlStore implements Store{
    private DocumentBuilder docBuilder;
    private Document doc;
    private Element root;
    private static final String filename="Store.xml";
    private static final String Blacklist="Blacklist";
    private static final String Testcase="testcase";
    private static final String Attname="name";
    public XmlStore() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {

        }

    }
    private void agregarTest(Element blacklistelem, String TestCaseName) {
        Element nameTestCase = doc.createElement(XmlStore.Testcase);
        Attr nameTC = doc.createAttribute(XmlStore.Attname);
        nameTC.setValue(TestCaseName);
        nameTestCase.setAttributeNode(nameTC);
        Attr nameElementTC = doc.createAttribute(XmlStore.Attname);
        nameElementTC.setValue(TestCaseName);
        blacklistelem.appendChild(nameTestCase);

    }
    public void guardar() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            Result result = new StreamResult(new java.io.File(XmlStore.filename));
            transformer.transform(source, result);
        } catch (TransformerException tfe) {
        }
    }
    @Override
    public void addTestToBlackList(ArrayList<TestState> blacklist) {
        doc = docBuilder.newDocument();
        root = doc.createElement(XmlStore.Blacklist);
        doc.appendChild(root);
        for (TestState state : blacklist)
            agregarTest(root, state.getTestCaseName());
        guardar();
    }

    @Override
    public ArrayList<String> getBlackList() {
        ArrayList<String> blacklist= new ArrayList<String>();
        try {
            doc=docBuilder.parse(new File(XmlStore.filename));
            NodeList nodeList = doc.getElementsByTagName(XmlStore.Testcase);
            for(int i=0; i<nodeList.getLength(); i++) {
                String testname=nodeList.item(i).getAttributes().getNamedItem(XmlStore.Attname).getNodeValue();
                blacklist.add(testname);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blacklist;
    }
}
