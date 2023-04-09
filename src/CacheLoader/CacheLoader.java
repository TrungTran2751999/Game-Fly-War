package CacheLoader;

import objectgame.BackGround;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CacheLoader {
    private final String pathBackGround = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\background.txt";
    private String linkBg = null;
    private HashMap<String, HashMap<String, Integer>> backGroundList;
    public CacheLoader() throws IOException {
        loadBackGround();
    }

    public void setLinkBg(String linkBg) {
        this.linkBg = linkBg;
    }

    public String getLinkBg() {
        return linkBg;
    }

//    public static void main(String[] args) throws IOException {
//        CacheLoader cacheLoader = new CacheLoader();
//        cacheLoader.loadBackGround();
//        System.out.println(cacheLoader.getBackGroundList());
//    }
    public void loadBackGround() throws IOException {
        backGroundList = new HashMap<String, HashMap<String, Integer>>();
        FileReader fr = new FileReader(pathBackGround);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String frameBG = null;
        if(br.readLine() == null){
            System.out.println("No data");
            throw new IOException();
        }else{
            fr = new FileReader(pathBackGround);
            br = new BufferedReader(fr);
            HashMap<String, Integer> hashStr= new HashMap<>();
            while ((line = br.readLine()).equals(""));
            int n = Integer.parseInt(line);
            for(int i=1; i<=2; i++){
                line=br.readLine();
                frameBG = line;
                for(int j=1; j<=4; j++){
                    line=br.readLine();
                    String[] str = line.split(" ");
                    hashStr.put(str[0], Integer.parseInt(str[1]));
                }
                backGroundList.put(frameBG, hashStr);
                hashStr = new HashMap<>();
            }
        }
        line = br.readLine();
        setLinkBg(line);
    }

    public HashMap<String, HashMap<String, Integer>> getBackGroundList() {
        return backGroundList;
    }

}
