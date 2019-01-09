package com.sachin.java;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJson {

	public static void main(String[] args) {
		try {
			File file = new File("src/main/resources/Data.json");
		    String JSONContent = FileUtils.readFileToString(file, "utf-8");
		    
		    JSONObject jsonOuterRoot = new JSONObject(JSONContent);
		    
		    JSONObject jsonInnerRoot = (JSONObject) jsonOuterRoot.get("list");
		    
		    JSONArray jsonArray = jsonInnerRoot.getJSONArray("equipment_type");
		    
		    String[][] recordSet = new String[jsonArray.length()][6];
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jObj = jsonArray.getJSONObject(i);
		    	
		    	recordSet[i][0] = (String) jObj.get("___name")!=null?
		    									(String) jObj.get("___name"):null;
		    	recordSet[i][1] = (String) jObj.get("_company_id")!=null?
		    									(String) jObj.get("_company_id"):null;
		    	recordSet[i][2] = (String) jObj.get("_applies_to")!=null?
		    									(String) jObj.get("_applies_to"):null;
		    	recordSet[i][3] = (String) jObj.get("_descr")!=null?
		    									(String) jObj.get("_descr"):null;
		    	recordSet[i][4] = (String) jObj.get("_id")!=null?
		    									(String) jObj.get("_id"):null;
//		    	recordSet[i][4] = (String) jObj.get("_exchange_type")!=null?
//		    									(String) jObj.get("_exchange_type"):null;
		    }
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	System.out.println("******* Record  "+i+"  **********");
		    	for(int j=0;j<5;j++) {
			    	System.out.println(recordSet[i][j]);
		    	}
		    	System.out.println("*****************************");
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
