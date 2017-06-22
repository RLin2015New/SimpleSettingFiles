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
 * @time 2017����4:52:27
 * @tags
 * 
 * ��properties�ж�ȡ���á�ע��properties�ļ�·��д����
 * �ȽϺõĽ���������������Ľ����ļ��������ļ���֧����򵥵�ע���﷨
 * 
 */
public class PropertiesReader {

	/** �����ļ�Ŀ¼����ȡ���·����ע��·����д�� **/
	private static String propRootPath = "./src/com/properties/";

	/**
	 * SimpleStartUp TODO
	 */
	/**
	 * 
	 * @description
	 * @param path
	 * @return Properties
	 * @time 2017����3:49:30
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
	 * @time 2017����4:24:19
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
	 * @time 2017����4:24:22
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
	 * @time 2017����4:24:26
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
			File directory = new File("");// ����Ϊ��
			String courseFile;
			courseFile = directory.getCanonicalPath();
			System.out.println("��ǰ��·��:" + courseFile);
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
