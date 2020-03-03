package com.shangh.guog.wordexport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordDocExportTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		//初始化配置文件
		Configuration configuration = new Configuration();
		//设置编码
		configuration.setDefaultEncoding("utf-8");
		/** 我的ftl文件是放在D盘的 **/
		// String fileDirectory = "D:\\";
		// configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
		String fileDirectory = "\\word\\";
		// 加载文件 maven 项目，默认在 src/main/resources 目录下
		configuration.setClassForTemplateLoading(ClassLoader.class, fileDirectory);
		
		//加载模板  
		Template template = configuration.getTemplate("test.ftl");
		//准备数据 
		Map<String, String> dataMap = new HashMap<String, String>();
		//在ftl文件中有${name}这些标签，其中标签值不能为null，须制成"",不然报错
		dataMap.put("name", "张三");
		dataMap.put("age", "14");
		//指定输出word文件的路径
		String outFilePath = "D:\\myFreeMarker.doc";
		File docFile = new File(outFilePath);
		FileOutputStream fos = new FileOutputStream(docFile);
		Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
		template.process(dataMap, out);

		if (out != null) {
			out.close();
		}
	}
}
