package org.Mess.DbConfig;
import java.util.*;
import java.io.*;
public class pathHelper {
	static Properties p=new  Properties();
	
	static {
		File file=new File(".");
		String path=file.getAbsolutePath();
		String mainPath=path.substring(0, path.length()-1);
		String Mainpath=mainPath+"src\\org\\Mess\\DbConfig\\db.properties";
//		System.out.println(Mainpath);
		try {
			FileInputStream fin=new FileInputStream(Mainpath);
			p.load(fin);
			
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
		}
	}
 
}
