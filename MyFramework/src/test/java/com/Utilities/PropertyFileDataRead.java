package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileDataRead 
{
	public Properties properties;
	public PropertyFileDataRead()
	{
		properties=new Properties();
		File file=new File(System.getProperty("user.dir") +"\\TestDataAndConfigs\\Configurations.properties");
		FileInputStream fs;
		try {
			fs = new FileInputStream(file);
			properties.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String readData(String key)
	{
		return properties.getProperty(key);
	}
}
