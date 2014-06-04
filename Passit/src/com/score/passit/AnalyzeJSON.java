package com.score.passit;

import org.json.JSONArray;
import org.json.JSONObject;

public class AnalyzeJSON {

	private String str = "";

	public AnalyzeJSON(String str) {
		this.str = str;
	}

	public String getData(String name,String name1) {
		String value = "";
		try {
			JSONObject nobj = new JSONObject(str);
			JSONObject n1obj = nobj.getJSONObject(name);
			value = n1obj.getString(name1); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
