package com.txt_readLine;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
/**
 * 
 * @packageName com.txt_readLine
 * @projectName SimpleStartUp
 * @author lifl
 * @time 2017����4:49:20
 * @tags
 * 
 *  ��������򵥵������ļ��ķ��������ǿɶ��Բ���
 *  ���� org.apache.commons.io.FileUtils;
 * 
 */
public class FileLineReader {
	private static String fileRootPath = "./src/com/txt_readLine/";
	@SuppressWarnings("unchecked")
	public static List<String> readLines(String path){
		List<String> keywords  = null;
		try {
			keywords= FileUtils.readLines(new File(fileRootPath+path), "GB2312");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keywords;
	}
	/**
	 * ����
	 * @description
	 * @param args 
	 * void 
	 * @time 2017����4:52:10
	 */
	public static void main(String[] args){
		List<String> lines = readLines("p.txt");
		for(String oneline:lines){
			System.out.println("line:"+oneline);
		}
		
	}
}

