package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringsUtils {

    public static String[] substringsBetween(String str,String open, String  close){

        if(str==null || isEmpty(open) || isEmpty(close)){
            return null;
        }
        int strLen=str.length();
        if(strLen==0){
            return new String[0];
        }
        final int closeLen=close.length();
        final int openLen=open.length();
        final List<String>list=new ArrayList<>();
        int pos=0;
        while(pos<strLen-closeLen){
            int start=str.indexOf(open,pos);
            if(start<0){
                break;
            }
            start+=openLen;
            final int end=str.indexOf(close,start);
            if(end<0){
                break;
            }
            list.add(str.substring(start,end));
            pos=end+closeLen;
        }
        if(list.isEmpty()){
            return null;
        }
        return list.toArray(new String[0]);
    }

    public static boolean isEmpty(String str){
        return str.isEmpty();
    }

}
