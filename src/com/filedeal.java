package com;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * Created by doctli on 2015/11/29.
 */
public class filedeal {
    public static void clearFile(){
        try{
            FileWriter fileWriter=new FileWriter("list.txt",false);
            String temp="";
            fileWriter.write(temp);
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public  static String showFile(){
        File file=new File("list.txt");
        BufferedReader reader=null;
        String list="";
        try{
            reader=new BufferedReader(new FileReader(file));
            String tempString=null;
            int line=1;
            while ((tempString=reader.readLine())!=null){
                list+=line+": "+tempString+"\n";
                line++;
            }
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(reader!=null){
                try{
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public static void appendFile(String content){
        try{
            FileWriter fileWriter=new FileWriter("list.txt",true);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
