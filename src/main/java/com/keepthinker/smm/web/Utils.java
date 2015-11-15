package com.keepthinker.smm.web;

public class Utils {
	
	/**
	 * return true if params array doesn't contain null or zero-length string 
	 */
	public static boolean checkParamsValid(String... params){
		for(String param :params){
			if(param == null || param.equals("")){
				return false;
			}
		}
		return true;
	}
}
