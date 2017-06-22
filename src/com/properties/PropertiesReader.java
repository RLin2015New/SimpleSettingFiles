package com.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * @packageName com.properties
 * @projectName SimpleStartUp
 * @author lifl
 * @time 2017下午4:52:27
 * @tags
 * 
 * 从properties中读取配置。注意properties文件路径写法。
 * 比较好的解决方案，无需额外的解析文件，而且文件内支持最简单的注释语法
 * 
 */
public class PropertiesReader {

	/** 属性文件目录，采取相对路径，注意路径的写法 **/
	private static String propRootPath = "./src/com/properties/";

	/**
	 * SimpleStartUp TODO
	 */
	/**
	 * 
	 * @description
	 * @param path
	 * @return Properties
	 * @time 2017下午3:49:30
	 */
	public static Properties getProperties(String path) {
		// Properties pro = readProperties001(path);
		// return pro;
		Properties pro = new Properties();
		try {
			pro.load(ClassLoader.getSystemResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

	/**
	 * 
	 * @description
	 * @param path
	 * @return Properties
	 * @time 2017下午4:24:19
	 */
	public static Properties readProperties001(String path) {
		Properties pro = new Properties();
		try {

			FileInputStream fis;
			fis = new FileInputStream(path);
			pro.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

	/**
	 * 
	 * @description
	 * @param path
	 * @return Properties
	 * @time 2017下午4:24:22
	 */
	public static Properties readProperties002(String path) {
		Properties p = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(path));

			p.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * 
	 * @description
	 * @param path
	 * @return Properties
	 * @time 2017下午4:24:26
	 */
	public static Properties readProperties003(String path) {
		Properties p = new Properties();
		try {
			p.load(ClassLoader.getSystemResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public static void main(String[] args) {
		try {
			File directory = new File("");// 参数为空
			String courseFile;
			courseFile = directory.getCanonicalPath();
			System.out.println("当前主路径:" + courseFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties testPro = getProperties(propRootPath + "test.properties");
		System.out.println(System.getProperty("user.dir"));
		System.out.println("test:" + testPro.getProperty("test")); // null
		System.out.println("test.a:" + testPro.getProperty("test.a"));
		System.out.println("test.b:" + testPro.getProperty("test.b"));
	}
}
