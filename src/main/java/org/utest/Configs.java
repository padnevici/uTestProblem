package org.utest;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Configs {
	private static Configs instance = null;
	private DocumentBuilderFactory factory = null;
	private DocumentBuilder builder = null;
	private Document doc = null;
	private XPathFactory xpathFactory = null;
	private XPath xpath = null;

	protected Configs() {
		factory = DocumentBuilderFactory.newInstance();
		xpathFactory = XPathFactory.newInstance();
		factory.setNamespaceAware(true);
		xpath = xpathFactory.newXPath();
		
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse("src/resources/Config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Configs getInstance() {
		if (instance == null) {
			instance = new Configs();
		}
		return instance;
	}

	public String getUrl() {
		String url = "";
		
		try {
            XPathExpression expr =
                xpath.compile("configs/defaultURL");
            url = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
		return url;
	}
	
	public String getBrowser() {
		String browserType = "";
		
		try {
            XPathExpression expr =
                xpath.compile("configs/mainBrowser");
            browserType = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
		return browserType;
	}
	
	public long getImplicitWaitTime() {
		long time = 0;
		
		try {
            XPathExpression expr =
                xpath.compile("configs/implicitWaitMls");
            time = Long.parseLong((String) expr.evaluate(doc, XPathConstants.STRING));
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
		return time;
	}
	
	public long getImplicitSeleniumWaitTime() {
		long time = 0;
		
		try {
            XPathExpression expr =
                xpath.compile("configs/implicitSeleniumWaitSec");
            time = Long.parseLong((String) expr.evaluate(doc, XPathConstants.STRING));
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
		return time;
	}
}
