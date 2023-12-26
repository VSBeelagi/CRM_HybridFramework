package com.crm.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	/**
	 * This method is used to read the data from property file
	 * @author Vijayalaxmi
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropetyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
