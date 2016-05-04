package com.cubetech.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constant {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final String AUTH_ERROR = "authen fail";
	public static final String PARSING_ERROR = "parsing request fail";
	public static final String MISSING_PARAM_ERROR = "Missing require param(s)";
	
	/*
	 * CDR specific constants
	 */
	public static final DateFormat CDR_DATE_FORMAT = new SimpleDateFormat("yyMMddhhmmss");
	public static final String CDR_EXTENSION = ".cdr";
	public static final String CDR_DELIMITER = "|";
	public static final int CDR_MAX_NUMBER_OF_LINE = 1000;
	public static final String BREAK_LINE_STR = "\n";
	
	/*
	 * Database value constants
	 */
	public static final Integer CHANNEL_PROTOCOL_SMPP = 1;
	public static final String NAMESPACE_URI = "http://cubetech.com/model";
}
