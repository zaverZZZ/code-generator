package org.zaver.code.utils;

import org.apache.commons.lang3.StringUtils;
import org.zaver.code.enums.Enums;
import org.zaver.code.model.Column;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {
	
	/**首字母大写
	 * @param string
	 * @return
	 */
	public static String toUpperFristChar(String string) {  
	    char[] charArray = string.toCharArray();
	    if(charArray[0]>='a'&&charArray[0]<='z') charArray[0] -= 32;
	    return String.valueOf(charArray);  
	}

	/**首字母小写
	 * @param string
	 * @return
	 */
	public static String toLowerFristChar(String string) {
		char[] charArray = string.toCharArray();
		if(charArray[0]>='A'&&charArray[0]<='Z')charArray[0] += 32;
		return String.valueOf(charArray);
	}

	/**
	 * 下划线转驼峰(首字母大写)
	 * @return
	 */
	public static String makeTableName(String tableName) {
		String[] split = tableName.split("_");
		String beanName = "";
		for (String s : split) {
			beanName += toUpperFristChar(s);
		}
	    return beanName;  
	}
	/**
	 * 下划线转驼峰(首字母小写)
	 * @return
	 */
	public static String makeColumnName(String str) {
		String s = makeTableName(str);
		return toLowerFristChar(s);
	}

	public static String typeConversion(String type) {
		switch (type) {
			case "INT":
				type = "Integer";
				break;
			case "VARCHAR":
				type = "String";
				break;
			case "BIGINT":
				type = "Long";
				break;
			case "TINYINT":
				type = "Integer";
				break;
			case "TEXT":
				type = "String";
				break;
			case "DOUBLE":
				type = "Double";
				break;
			case "FLOAT":
				type = "Float";
				break;
			default:
				break;
		}
		return type;
	}

	public static StringBuffer getModelFileString(String tableName,List<Column> list) {
		if(list==null||list.size()==0)return null;  // 不处理空表
		StringBuffer sb = new StringBuffer();
		sb.append("package " + Enums.PACKAGE_NAME.getValue() + "." + Enums.MODELPACK_NAME.getValue() + ";\n\n");
		sb.append("import java.io.Serializable;\n\n");
		sb.append("public class " + Utils.makeTableName(tableName) + " implements Serializable" + "{\n\n");
		sb.append("    private static final long serialVersionUID = 1L;\n\n");
		for (Column po : list) {
			sb.append(po.toString());
		}
		sb.append("\n");
		for (Column po : list) {
			sb.append(po.toGetString());
			sb.append(po.toSetString());
		}
		sb.append("}");
		return sb;
	}

	public static StringBuffer getDaoFileString(String tableName) {
		StringBuffer sb = new StringBuffer();
		sb.append("package " + Enums.PACKAGE_NAME.getValue()+"."+Enums.DAOPACK_NAME.getValue() + ";\n\n");
        sb.append("import com.baomidou.mybatisplus.core.mapper.BaseMapper;\n");
        sb.append("import "+Enums.PACKAGE_NAME.getValue()
                +"."+Enums.MODELPACK_NAME.getValue()
                +"."+Utils.makeTableName(tableName)+";\n");
        sb.append("import org.springframework.stereotype.Repository;\n\n");
        sb.append("@Repository\n");
		sb.append("public interface "
                + Utils.makeTableName(tableName) + Utils.toUpperFristChar(Enums.DAOPACK_NAME.getValue())
				+" extends BaseMapper<"+Utils.makeTableName(tableName)+">" + "{\n\n}");
		return sb;
	}

	public static StringBuffer getServiceFileString(String tableName) {
		StringBuffer sb = new StringBuffer();
		sb.append("package " + Enums.PACKAGE_NAME.getValue()+"."+Enums.SERVICEPACK_NAME.getValue() + ";\n\n");
		sb.append("import com.baomidou.mybatisplus.extension.service.IService;\n");
		sb.append("import "+Enums.PACKAGE_NAME.getValue()
				+"."+Enums.MODELPACK_NAME.getValue()
				+"."+Utils.makeTableName(tableName)+";\n\n");
		sb.append("public interface "
				+ Utils.makeTableName(tableName) + Utils.toUpperFristChar(Enums.SERVICEPACK_NAME.getValue())
				+ " extends IService<"+Utils.makeTableName(tableName)+">" + "{\n\n}");
		return sb;
	}

	public static StringBuffer getServiceImplFileString(String tableName) {
		StringBuffer sb = new StringBuffer();
		sb.append("package " + Enums.PACKAGE_NAME.getValue()+"."
				+ Enums.SERVICEPACK_NAME.getValue() + Enums.IMPLPACK_NAME.getValue()+";\n\n");
		sb.append("import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;\n");
		sb.append("import "+Enums.PACKAGE_NAME.getValue()
				+"."+Enums.DAOPACK_NAME.getValue()
				+"."+Utils.makeTableName(tableName)+Utils.toUpperFristChar(Enums.DAOPACK_NAME.getValue())+";\n");
		sb.append("import "+Enums.PACKAGE_NAME.getValue()
				+"."+Enums.MODELPACK_NAME.getValue()
				+"."+Utils.makeTableName(tableName)+";\n\n");
		sb.append("public class "
				+ Utils.makeTableName(tableName) + Utils.toUpperFristChar(Enums.SERVICEPACK_NAME.getValue())
				+ Utils.toUpperFristChar(Enums.IMPLPACK_NAME.getValue())
				+ " extends ServiceImpl<"
				+ Utils.makeTableName(tableName)+Utils.toUpperFristChar(Enums.DAOPACK_NAME.getValue())+", "
				+ Utils.makeTableName(tableName)+">" + " implements "
				+ Utils.makeTableName(tableName) + Utils.toUpperFristChar(Enums.SERVICEPACK_NAME.getValue())+"{\n\n}");
		return sb;
	}

	public static StringBuffer getMapperFileString(String tableName) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
		sb.append("<mapper namespace=\""+Enums.PACKAGE_NAME.getValue()
				+"." + Enums.DAOPACK_NAME.getValue()
				+ "." + Utils.makeTableName(tableName)+Utils.toUpperFristChar(Enums.DAOPACK_NAME.getValue())
				+"\">\n\n");
		sb.append("</mapper>");
		return sb;
	}


	public static boolean toFile(String fileType,String packageName,StringBuffer sb,String tableName,String filePostfix){
		String property = System.getProperty("user.dir") + "\\src";
		String[] split = packageName.split("\\.");
		String dirPath = StringUtils.join(split, "\\");
		Path b = Paths.get(property + "\\" + dirPath);
		try {
			Files.createDirectories(b);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		// 新文件路径名称
		String filePath = b.toString() + "\\" + Utils.makeTableName(tableName) + filePostfix+"."+fileType;
		System.out.println(filePath);
		Path f = Paths.get(filePath);
		try {
			Files.deleteIfExists(f);
			Files.createFile(f);
			WriteStringToFile(f.toString(), sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("can't create file");
			return false;
		}
		return true;
	}

	public static void WriteStringToFile(String filePath, String dataStr) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(dataStr.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
