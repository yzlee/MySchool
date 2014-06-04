package com.score.passit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class GetPostUtil {
	
	public static String sendPost(String url ,String params){
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try{
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			
			conn.setRequestProperty("accesstoken","7c56824bcdbf7a87b8027c087f03f72a");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.connect();
			
			out = new PrintWriter(conn.getOutputStream());
			out.print(params);
			out.flush();
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
		    while((line = in.readLine())!=null){
		    	result = result + "\n" + line;
		    }
			
		}catch (Exception e){
			System.out.println("POST WRONG" + e);
			e.printStackTrace();
		}
		
		finally{
			try{
				if(out != null)
				{
					out.close();
				}
				if(in != null)
				{
					in.close();
				}
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
