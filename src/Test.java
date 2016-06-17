/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rakha Agung trimanda
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Test {
    
    
    public static class variabel{
        public static String kata = "Sedang apa! Kamu? saya. sedang, tidur dikamar.";
        public static String kata1 = "0200	0210	9180";
        public static Pattern path1, path2, path3, path4, path5;
        public static Matcher m1, m2, m3, m4, m5;
        public static boolean b1, b2, b3, b4, b5;
    }
    public static void main(String []args) throws IOException{
        cekTandabaca();
//       ambilKanan();
//        PrintFile();
        
//        String example = "Sedang apa!";
//        String regex = "!";
//        System.out.println(example.substring(example.lastIndexOf(regex) + 1));
    }
    
    public static String PrintFile() throws FileNotFoundException, IOException{
        String FileName = null;
        File file = new File("src/jar/test.txt");
          FileReader fr = new FileReader(file);
          BufferedReader br = new BufferedReader(fr);
          
          ArrayList<String> kms = new ArrayList<>();
            int x = 0;
            String hm;

            while ((hm = br.readLine())!= null) {                    
                kms.add(hm);
                x++;
            }
            String a="";
            for(String b: kms){
                a += b+"\t";
                
            }
            System.out.println(""+a);
        return null;
    }
    
    public static String right(String value, int length){
        return value.substring(value.length() - length);
    }
    
    public static String right1 (String value){
        return value.substring(value.lastIndexOf(" ") + 1);
    }
    
    public static void ambilKanan(){
        
        String pecah = right(variabel.kata1, 14);
        String[] pecah1 = pecah.split("\\s+");
        double[] pecah2 = new double[pecah1.length];
        
        for(int i=0; i<pecah1.length;i++){
            pecah2[i] = (Double.parseDouble(pecah1[i]))/1000;
            System.out.println((i+1)+". "+pecah2[i]);
        }
    }
    
    public static boolean cekTandabaca(){
        String[] pecah = variabel.kata.split("(?<=\\?|\\!|\\.|\\,)");
        
            variabel.path1 = Pattern.compile("(?<=\\?)");
            variabel.path2 = Pattern.compile("(?<=\\!)");
            variabel.path3 = Pattern.compile("(?<=\\.)");
            variabel.path4 = Pattern.compile("(?<=\\,)");
            variabel.path5 = Pattern.compile(" ");
            
            for (int i=0; i<pecah.length;i++){
                
                variabel.m1 = variabel.path1.matcher(pecah[i]);
                variabel.b1 = variabel.m1.find();
                
                variabel.m2 = variabel.path2.matcher(pecah[i]);
                variabel.b2 = variabel.m2.find();
                
                variabel.m3 = variabel.path3.matcher(pecah[i]);
                variabel.b3 = variabel.m3.find();
                
                variabel.m4 = variabel.path4.matcher(pecah[i]);
                variabel.b4 = variabel.m4.find();
                
                variabel.m5 = variabel.path5.matcher(pecah[i]);
                variabel.b5 = variabel.m5.find();
                
                    if (variabel.b1) {
//                        System.out.println("Tanda Tanya: "+pecah[i]);
    //                    variabel.printout.add(pecah[i]);
                        }else if(variabel.b2){
                            System.out.println("Tanda Seru: "+pecah[i]);
                            System.out.println("Pecahannya: "+right1(pecah[i]));
                        }else if(variabel.b3){
                            System.out.println("Titik: "+pecah[i]);
                            System.out.println("Pecahannya: "+right1(pecah[i]));
                        }else if (variabel.b4) {
                            System.out.println("Koma: "+pecah[i]);
                            System.out.println("Pecahannya: "+right1(pecah[i]));
                        }else if (variabel.b5) {
                            System.out.println("Spaci: "+pecah[i]);
                            System.out.println("Pecahannya: "+right1(pecah[i]));
                    }
//                    String a = "!";
//                    System.out.println("Pecahan "+right1(pecah[0], a));
//                    System.out.println(""+pecah[0]);
            }
        
                boolean containsWhitespace = false;
                for (int i = 0; i < variabel.kata.length() && !containsWhitespace; i++) {
                    if (Character.isWhitespace(variabel.kata.charAt(i))) {
                        if(containsWhitespace = true){
                            
                        }
                    }
                }
                return containsWhitespace;
        
    }
    
    
} 
 