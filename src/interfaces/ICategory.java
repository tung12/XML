package interfaces;

import java.util.Map;

public interface ICategory {

	public Map<String,String> getCategory ();
	public Map<String,String> parseDocumentCategoryByStAX(String document);
}
