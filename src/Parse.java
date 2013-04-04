import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
//import org.w3c.tidy.Tidy;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Parse
{
    public static void main(String[] args) throws SAXException, IOException, TransformerConfigurationException, ParserConfigurationException, XPathExpressionException, XPatherException
    {
        
/*
       URL url = new URL("http://home.ccil.org/~cowan/XML/tagsoup/");    	
       URLConnection urlConn = url.openConnection();
       urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
        
       InputStream stream = urlConn.getInputStream();
       InputSource content = new InputSource(stream);
       
       DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
       builder.isNamespaceAware();
       Document doc = builder.newDocument();
       
       DOMResult domResult = new DOMResult(doc);
       
       SAXTransformerFactory stf = (SAXTransformerFactory) TransformerFactory.newInstance();
       TransformerHandler th = stf.newTransformerHandler();
       th.setResult(domResult);
       
       XMLReader tagsoupParser = new org.ccil.cowan.tagsoup.Parser();
       tagsoupParser.setContentHandler(th);
       tagsoupParser.parse(content);

       
       XPathFactory factory = XPathFactory.newInstance();
       XPath xpath = factory.newXPath();
       Object result = xpath.evaluate("//li/a/text()",doc, XPathConstants.NODESET);
       NodeList nodes = (NodeList) result;
       
       for (int i = 0; i < nodes.getLength(); i++)
       {
    	   System.out.println(nodes.item(i).getNodeValue());
       }
	   System.out.println("end");
	   */
    	
//---------------------
    	CleanerProperties props = new CleanerProperties();
// set some properties to non-default values
	props.setTranslateSpecialEntities(true);
	props.setTransResCharsToNCR(true);
	props.setOmitComments(true);
// do parsing
//	TagNode tagNode = new HtmlCleaner(props).clean(new URL("http://wiki.teamliquid.net/starcraft2/3_Gate_Robo"));
	TagNode tagNode = new HtmlCleaner(props).clean(new URL("http://www.idei74.ru/shop/21590/"));
	//Object[] nodes = tagNode.evaluateXPath("//h1[@id='firstHeading']");
	Object[] nodes = tagNode.evaluateXPath(".//*[@id='cat02']/tbody/tr/td/a");
	Object[] node1 = tagNode.evaluateXPath(".//*[@id='cat02']/tbody/tr/td/p");
	Object[] node2 = tagNode.evaluateXPath(".//*[@id='cat02']/tbody/tr/td/div/big");
	for (int i = 0; i < node1.length; i++) {
		System.out.println(((TagNode)nodes[i]).getText());
		System.out.println(((TagNode)node1[i]).getText());
		System.out.println(((TagNode)node2[i]).getText());
		System.out.println("----next----");
	}    	
//	TagNode Headernode = (TagNode)nodes[0];
//	System.out.println("Цена: " + Headernode.getText());
//	System.out.println("------------------------------");
//	nodes = tagNode.evaluateXPath("//table[@class='wikitable collapsible']");
//	if(nodes == null || nodes.length == 0){
//	nodes = tagNode.evaluateXPath("//table[@class='wikitable collapsible collapsed']");
//	}
//	TagNode node = (TagNode)nodes[0];
//	nodes = node.evaluateXPath("//li//a");
//	Object[] nodes1;
//	nodes1 = node.evaluateXPath("//li");
//	for (int i = 0; i < nodes1.length; i++) {
//		System.out.print(((TagNode)nodes1[i]).getText());
//	}    	
   }  

}
//tagsoupParser.setFeature(org.ccil.cowan.tagsoup.Parser.namespacesFeature, false);
//tagsoupParser.setFeature(org.ccil.cowan.tagsoup.Parser.namespacePrefixesFeature, false);
