package mainGame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class History extends JFrame{
    private JTable table;
    private JScrollPane jScrollPane;
    private String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\data\\data.csv";
    public static ArrayList<String> arrayList;
    public static String[][] datas;
    private String[] columnNames = { "time", "score", "status"};
    public History(){
        arrayList = new ArrayList<>();
        getDataHistory();
        convertToData();
        table = new JTable();
        jScrollPane = new JScrollPane();
    }
    public void showTable(){
        arrayList = new ArrayList<>();
        getDataHistory();
        convertToData();
        importData();
        setSize(400, 300);
        setVisible(true);
    }
    public void importData(){
        remove(jScrollPane);
        table = new JTable(datas, columnNames);
        jScrollPane = new JScrollPane(table);
        add(jScrollPane);
        table.setEnabled(false);
    }
    public void getDataHistory(){
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String frStr = br.readLine();
            while (frStr!=null){
                arrayList.add(frStr);
                frStr = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void convertToData(){
        datas = new String[arrayList.size()][3];
        for(int i=0; i<arrayList.size(); i++){
            String[] dataSplit = arrayList.get(i).split(",");
            datas[i] = dataSplit;
        }
    }

}
