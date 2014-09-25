package com.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecompileDeleteMark {
	
	public static void main(String[] args) {
		File file=new File("C:/Users/Administrator/Desktop/com.pay.common-2.0-SNAPSHOT.src");
		List<File> javaFiles=new ArrayList<File>();
		listJavaFile(file, javaFiles);
		for(File aafile:javaFiles){
			try {
				deleteMark(aafile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void listJavaFile(File file,List<File> fileList){
		File[] files=file.listFiles();
		for(File sonFile:files){
			if(sonFile.isFile()&&sonFile.getName().endsWith(".java")){
				fileList.add(sonFile);
			}
			if(sonFile.isDirectory()){
				listJavaFile(sonFile, fileList);
			}
		}
	}

	
	public static void deleteMark(File file) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(file));
	    String s = null;
	    String haha="";
        while((s = reader.readLine())!=null){//使用readLine方法，一次读一行
        	haha+=s+"\n";
        }
        char[] aa=haha.toCharArray();
        List<Integer> indexs=new ArrayList<Integer>();
        for(int i=0;i<aa.length;i++){
        	if("/".equals(String.valueOf(aa[i]))){
        		if(i!=aa.length-1){
        			if("*".equals(String.valueOf(aa[i+1]))){
            			//说明是注释开始符
            			indexs.add(i);
            		}
        		}
        		if(i!=0){
        			if("*".equals(String.valueOf(aa[i-1]))){
            			indexs.add(i);
            		}
        		}
        		
        	}
        }
        System.out.print("有注释标签个数="+indexs.size());
        
        if(!indexs.isEmpty()){
        	 String result="";
             int length=haha.length();
             //如果首个注释前面有代码，则应该保留前面的代码
             if(indexs.get(0)!=0){
            	 result+=haha.substring(0,indexs.get(0));
             }
             for(int i=0;i<indexs.size()-1;i=i+2){
             	int beginIndex=indexs.get(i+1);
             	int endIndex=0;
             	if(i==indexs.size()-2){
             		endIndex=length;
             	}else{
             		endIndex=indexs.get(i+2);
             	}
             	
             	result+=haha.substring(beginIndex+1,endIndex);
             }
             
             System.out.print(result);
             FileOutputStream outputStream=new FileOutputStream(file);
             outputStream.write("".getBytes());
             outputStream.write(result.getBytes());
             outputStream.close();
        }
	}
}
