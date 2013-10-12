package me.s.y.mpp.codegenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader of text files with class information, generates ClassToGen objects from such files.
 * 
 * @author Sergey Yakimovich
 *
 */
public class SimpleReader {
	
	public static List<ClassToGen> readClass(String fileName) throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(new File(fileName)));
			String line = null;
			boolean classTitle = true;
			List<ClassToGen> classesToGen = new ArrayList<ClassToGen>();
			ClassToGen currClass = null;
			while((line = br.readLine()) != null){
				if(line.trim().isEmpty()){
					classTitle = true;
					continue;
				}
				if(classTitle){
					if(currClass != null){
						classesToGen.add(currClass);
					}
					currClass = new ClassToGen();
					currClass.setName(line.trim());
					classTitle = false;
				} else{
					if(line.contains("(")){
						MethodToGen method = new MethodToGen();
						if(line.startsWith("+")){
							method.setAccessModifier(AM.PUBL);
							line = line.substring(1);
						} else if(line.startsWith("-")){
							method.setAccessModifier(AM.PRIV);
							line = line.substring(1);
						} else if(line.startsWith("#")){
							method.setAccessModifier(AM.PROT);
							line = line.substring(1);
						} else {
							method.setAccessModifier(AM.EMPT);
						}
						String[] a = line.split("\\(");
						if(a.length != 2){
							continue;
						}
						method.setName(a[0]);
						String[] b = a[1].split("\\)");
						if(b.length != 2){
							continue;
						}
						method.setReturnType(b[1].replaceAll(":", "").trim());
						String[] rawParams = b[0].split(",");
						ParamToGen[] params = new ParamToGen[rawParams.length];
						for(int i=0; i<rawParams.length; i++){
							String[] parts = rawParams[i].split(":");
							if(parts.length < 2){
								continue;
							}
							String paramName = parts[0].trim();
							String paramType = parts[1].trim();
							params[i] = new ParamToGen();
							params[i].setType(paramType);
							params[i].setName(paramName);
						}
						method.setParams(params);
						currClass.addMethod(method);
					} else {
						FieldToGen field = new FieldToGen();
						if(line.startsWith("+")){
							field.setAccessModifier(AM.PUBL);
							line = line.substring(1);
						} else if(line.startsWith("-")){
							field.setAccessModifier(AM.PRIV);
							line = line.substring(1);
						} else if(line.startsWith("#")){
							field.setAccessModifier(AM.PROT);
							line = line.substring(1);
						} else {
							field.setAccessModifier(AM.EMPT);
						}
						String[] parts = line.split(":");
						if(parts.length < 2){
							continue;
						}
						String fieldName = parts[0].trim();
						String fieldType = parts[1].trim();
						field.setType(fieldType);
						field.setName(fieldName);
						currClass.addField(field);
					}
				}
			}
			if(currClass != null){
				classesToGen.add(currClass);
			}
			return classesToGen;
		} finally {
			if(br != null){
				try{
					br.close();
				} catch (Throwable t){}
			}
		}
	}
}
