package main.java;

import java.util.*;
import java.io.*;
public class main {
    static String ignorechar="#,.?![]{}*><:";
    static HashMap<String, Vector<Vector<String>>> dict=new HashMap<String,Vector<Vector<String>>>();
    static int lineNum = 0;
    static String preWord = "";
    public static void main(String args[]) {

        readFile();
        Scanner in = new Scanner(System.in);
        System.out.println("inputword");
        String s = in.nextLine();
        boolean it2 = dict.containsKey(s);
        if(it2==false)
            System.out.println("nosuchword");
        else
        {
            Vector<Vector<String>> temp=dict.get(s);
            System.out.println("number");
            System.out.println(temp.size());
            for(Vector<String> temp2:temp) {
                System.out.println("linenumber");
                System.out.println(temp2.elementAt(0));
                System.out.println("lastword");
                System.out.println(temp2.elementAt(2));
                System.out.println("linecontent");
                System.out.println(temp2.elementAt(3));
            }
        }
    }
    public static int getonlynum(String str)
    {
        readFile();
        boolean it3 = dict.containsKey(str);
        if(it3==false)
            return 0;
        else
            return dict.get(str).size();
    }
    public static void readFile() {
        String pathname = "src/main/java/shakespeare.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                lineNum++;
                if(line == "by William Shakespeare")
                {
                    lineNum = 1;
                }
                //System.out.println("1");
                if(line.length()>0&&line.charAt(line.length()-1) == '-')
                {
                    String temp = "";
                    // temp=br.readLine();
                    line = line.substring(0, line.length() - 1) + temp;
                }
                //System.out.println("2");
                for (int i = 0; i < ignorechar.length();i++)
                {
                    int index = line.indexOf(ignorechar.charAt(i));
                    //System.out.println(index);
                    while(index != -1)
                    {
                        StringBuilder sb = new StringBuilder(line);
                        sb.replace(index, index+1, " ");
                        line=sb.toString();
                        ///System.out.println(line.charAt(index));
                        index = line.indexOf(ignorechar.charAt(i));
                    }
                }
                //System.out.println("3");
                StringTokenizer oo = new StringTokenizer(line);
                int wordNum = 0;
                while (oo.hasMoreTokens())
                {
                    String word = "";
                    word=oo.nextToken();
                    //System.out.println(word);
                    wordNum++;
                    if(word == "")
                    {
                        continue;
                    }
                    Vector<String> info=new Vector<String>();
                    info.addElement(String.valueOf(lineNum));
                    info.addElement(String.valueOf(wordNum));
                    info.addElement(preWord);
                    info.addElement(line);
                    boolean it = dict.containsKey(word);
                    if(it == false)
                    {
                        Vector<Vector<String>> term=new Vector<Vector<String>>();
                        dict.put(word,term);
                    }
                    dict.get(word).addElement(info);
                    preWord = word;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}