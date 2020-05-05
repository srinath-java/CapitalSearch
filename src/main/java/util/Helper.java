package util;

public class Helper {
	
	private static String CAPITAL_BY_NAME_URI="CAPITAL_BY_NAME_URI";
	private static String CAPITAL_BY_CODE_URI="CAPITAL_BY_CODE_URI";
	private static String DEFAULT_CAPITAL_BY_NAME_URI="https://restcountries.eu/rest/v2/name";
	private static String DEFAULT_CAPITAL_BY_CODE_URI="https://restcountries.eu/rest/v2/alpha";

	
	public static String getRestURLforCaptialByName() {
		String envUrl=System.getenv(CAPITAL_BY_NAME_URI);
		return (envUrl!=null)?envUrl:DEFAULT_CAPITAL_BY_NAME_URI;
		
		
	}
	
	public static String getRestURLforCaptialByCode() {
		String envUrl=System.getenv(CAPITAL_BY_CODE_URI);
				return (envUrl!=null)?envUrl:DEFAULT_CAPITAL_BY_CODE_URI;
		
	}

}
