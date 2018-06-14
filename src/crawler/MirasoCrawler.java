package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;





import interfaces.ICategory;

public class MirasoCrawler extends MainCrawler implements ICategory  {
	private static final String URL_DOMAIN = "http://miraso.vn/";
	public MirasoCrawler(ServletContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Map<String, String> getCategory() {
		// TODO Auto-generated method stub
		BufferedReader reader =null;
		try {
			reader = getBufferdReaderUrl(URL_DOMAIN);
			String line ="";
			String document="";
			boolean tmpStart=false;
			boolean tmpFound=false; 
			while((line = reader.readLine()) != null) {
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "TEst");
				if(line.contains("<a href=\"san-pham/my-pham>")) {
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "START");
				}
				if(tmpStart && line.contains("<a href=\"san-pham/cham-soc-da\">")) {
					break;
				}
				if(tmpStart) {
					document +=line.trim();
				}
				if(tmpFound && line.contains("</a>")) {
					tmpStart=true;
				}
				if(line.contains("<a href=\"san-pham/my-pham>")) {
					tmpFound=true;
				}
			}
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(reader !=null) {
					reader.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		Map<String,String> test =  new HashMap<String,String>();
		return test;
	}
	@Override
	public Map<String, String> parseDocumentCategoryByStAX(String document) {
		// TODO Auto-generated method stub
		Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "parseDocumentCategoryByStAX");
		Map<String,String> test =  new HashMap<String,String>();
		return test;
	}

	

	
	
	

}
