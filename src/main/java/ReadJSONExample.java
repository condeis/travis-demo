import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 
 * 
 * @author CONDEIS
 *
 */

public class ReadJSONExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
 
		try (FileReader reader = new FileReader("identity.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONObject identity = (JSONObject) obj;
			String chaine= identity.toJSONString();
			System.out.println(identity.toString());
			System.out.println("_______________________________________________________________");
			
			System.out.println(chaine);
			// Iterate over employee array
			// countryList.forEach( ctr -> parseCountryObject( (ctr) ) );

		//	countryList.forEach(ctr -> parseCountryObject((JSONObject) ctr));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {"name":"Israel","dial_code":"+972","code":"IL"}
	 * 
	 * @param employee
	 */
	private static void parseCountryObject(JSONObject ctrObject) {

		String name = (String) ctrObject.get("name");
		// System.out.println(name);

		String dialCode = (String) ctrObject.get("dial_code");
		// System.out.println(dialCode);

		String code = (String) ctrObject.get("code");
		System.out.println("name:" + name + " - dial_code:" + dialCode + " - code:" + code);
	}
}