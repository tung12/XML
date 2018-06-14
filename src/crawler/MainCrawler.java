package crawler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

public class MainCrawler {

	private ServletContext context;
	
	public MainCrawler(ServletContext context) {
		this.context = context;
	}
	
	public ServletContext getContext() {
		return this.context;
	}
	
	protected BufferedReader getBufferdReaderUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		URLConnection urlConnection = url.openConnection();
		urlConnection.addRequestProperty("User-Agent", "Morilla/5.0 (Window NT 10.0; Win64; x64)");
		InputStream is = urlConnection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		return br;
	}
	
	protected XMLEventReader parseStringtoXMLUseStAX(String xmlString) throws UnsupportedEncodingException, XMLStreamException {
		byte[] byteArray = xmlString.getBytes("UTF-8");
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(bais);
		return eventReader;
	}
	
}
