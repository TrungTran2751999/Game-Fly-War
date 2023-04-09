package CacheLoader;


import mainGame.History;
import objectgame.PanelClear;
import objectgame.Player;
import objectgame.Score;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataHistory {
    public static ArrayList<String> datas;
    private FileWriter fw;
    public static boolean isInterrupt;
    private final String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\data\\data.csv";
    public DataHistory(){
        datas = new ArrayList<>();
        getDataHistory();
    }
    public void writeDataHistory(ArrayList<String> datas){
        try{
            fw= new FileWriter(path);
            for(String data:datas){
                String[] dataString = data.split(",");
                fw.write(dataString[0]+","+dataString[1]+","+dataString[2]);
                fw.write("\n");
            }
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void getDataHistory(){
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String frStr = br.readLine();
            while (frStr!=null){
                datas.add(frStr);
                frStr = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateDataHistory(){
        if(isInterrupt == false){
            if(Player.isDeath){
                String time = getCurrentTime();
                String score = Integer.toString(Score.scoreCount);
                String status = "Game Over";
                datas.add(time + ","+score+","+status);
                for(String data:datas){
                    writeDataHistory(datas);
                }
                isInterrupt = true;
            }
            if(PanelClear.isClearGame){
                String time = getCurrentTime();
                String score = Integer.toString(Score.scoreCount);
                String status = "Game Clear";
                datas.add(time + ","+score+","+status);
                for(String data:datas){
                    writeDataHistory(datas);
                }
                isInterrupt = true;
            }
        }
    }
    public String getCurrentTime(){
        return new SimpleDateFormat("dd-MM-YYYY HH:mm:ss").format(new Date());
    }

}