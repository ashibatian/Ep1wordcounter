package wordcounter.controller;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

@RestController
public class usercontroller {
    static String ignorechar="#,.?![]{}*><:";
    static HashMap<String, Vector<Vector<String>>> dict=new HashMap<String,Vector<Vector<String>>>();
    static int lineNum = 0;
    static String preWord = "";
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
    @RequestMapping(value = "/users/{word}",method = RequestMethod.GET)
    public String getNum(@PathVariable String word, @RequestParam int showmore){
        readFile();
        boolean it2 = dict.containsKey(word);
        if(it2==false)
            return "nosuchword";
        else
        {
            Vector<Vector<String>> temp=dict.get(word);
            String res="";
            if(showmore==1)
            for(Vector<String> temp2:temp) {
              res+="linenumber:\n";
                res+=temp2.elementAt(0);
                res+="\n";
                res+="lastword:\n";
                res+=temp2.elementAt(2);
                res+="\n";
                res+="linecontent:\n";
                res+=temp2.elementAt(3);
                res+="\n";
            }
            return "number: "+temp.size()+"\n"+res;
        }
    }}
