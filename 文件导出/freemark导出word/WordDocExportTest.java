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
		//��ʼ�������ļ�
		Configuration configuration = new Configuration();
		//���ñ���
		configuration.setDefaultEncoding("utf-8");
		/** �ҵ�ftl�ļ��Ƿ���D�̵� **/
		// String fileDirectory = "D:\\";
		// configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
		String fileDirectory = "\\word\\";
		// �����ļ� maven ��Ŀ��Ĭ���� src/main/resources Ŀ¼��
		configuration.setClassForTemplateLoading(ClassLoader.class, fileDirectory);
		
		//����ģ��  
		Template template = configuration.getTemplate("test.ftl");
		//׼������ 
		Map<String, String> dataMap = new HashMap<String, String>();
		//��ftl�ļ�����${name}��Щ��ǩ�����б�ǩֵ����Ϊnull�����Ƴ�"",��Ȼ����
		dataMap.put("name", "����");
		dataMap.put("age", "14");
		//ָ�����word�ļ���·��
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
