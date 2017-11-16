/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

/**
 *
 * @author chris
 */
public class Keywords {
    public static String CLASS_MODIFIER_PRIVATE = "private";
	public static String CLASS_MODIFIER_PUBLIC = "public";
	
	public static String PRIMITIVE_TYPE_BOOLEAN = "boolean";
	public static String PRIMITIVE_TYPE_CHAR = "char";
	public static String PRIMITIVE_TYPE_INT = "int";
	public static String PRIMITIVE_TYPE_BYTE = "byte";
	public static String PRIMITIVE_TYPE_SHORT = "short";
	public static String PRIMITIVE_TYPE_LONG = "long";
	public static String PRIMITIVE_TYPE_FLOAT = "float";
	public static String PRIMITIVE_TYPE_DOUBLE = "double";
	public static String PRIMITIVE_TYPE_STRING = "String";
	
	public static String BOOLEAN_TRUE = "true";
	public static String BOOLEAN_FALSE = "false";
	
	
	/*
	 * Returns true if the keywords match. This is case-sensitive
	 */
	public static boolean matchesKeyword(String keyword, String textToMatch) {
		if(textToMatch.contains(keyword)) {
			return true;
		}
		else {
			return false;
		}
	}
}
