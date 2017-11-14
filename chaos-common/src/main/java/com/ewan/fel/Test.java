package com.ewan.fel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ewan on 17/10/23.
 */
public class Test {
    public static void main(String[] args) throws IOException {

        Map<String,String> file19 =new HashMap<String,String>();

        FileReader fr19=new FileReader("/Users/ewan/Downloads/19.txt");
        BufferedReader br=new BufferedReader(fr19);
        String line="";
        String[] arrs=null;
        while ((line=br.readLine())!=null) {
            arrs=line.split(",");
            file19.put(arrs[0],arrs[1]);
            System.out.println(arrs[0] + " : " + arrs[1] );
        }
        br.close();
        fr19.close();

        System.out.println(file19);


        FileReader fr20=new FileReader("/Users/ewan/Downloads/20.txt");
        BufferedReader br20=new BufferedReader(fr20);
        String line20="";
        String[] arrs20=null;
        while ((line20=br20.readLine())!=null) {
            arrs20=line20.split(",");

            if(file19.containsKey(arrs20[0])){
                file19.put(arrs20[0],arrs20[1]+"-"+file19.get(arrs20[0]));
            }

            //file19.put(arrs[0],arrs[1]);
            //System.out.println(arrs[0] + " : " + arrs[1] );
        }
        br20.close();
        fr19.close();

        System.out.println(file19);
    }
}
