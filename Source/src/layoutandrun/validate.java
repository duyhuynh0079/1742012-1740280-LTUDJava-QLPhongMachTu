package layoutandrun;

import java.util.regex.Pattern;

public class validate {
	public static boolean isNumber(String str)//ham check input so
	{
		return Pattern.matches("[0-9]+", str);
	}
	
	public static boolean isWord(String str)// ham check input chu
	{
		return Pattern.matches("[\\p{L}\\s]+", str);
	}
}
