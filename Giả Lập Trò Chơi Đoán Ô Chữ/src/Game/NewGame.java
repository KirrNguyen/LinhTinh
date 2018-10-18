/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.Window.WINDOW_HEIGHT;
import static Game.Window.WINDOW_WIDTH;
import static Game.Window.pMain;
import static Game.Window.panelmain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author KirrNguyen
 */
public class NewGame extends JPanel{
    
    JTextField Input = new JTextField(); // số ô
    JTextField InputString = new JTextField(); // chuỗi
    
    JLabel TextInput = new JLabel("Số Ô");
    JLabel TextInputString = new JLabel("Chuỗi");
    
    JButton Edit = new JButton(); // sửa
    JButton Delete = new JButton(); // xóa
    
    
    JLabel TextAllLine = new JLabel("Tổng Số Dòng");
    JLabel EditLine = new JLabel("(Có Thể Sửa)");
    JTextField Line = new JTextField(); // tổng số dòng
    JLabel TextLine = new JLabel("Thêm Số Dòng");
    JButton AddLine = new JButton();
    
    JButton Add1Line = new JButton();
       
    
    JLabel TextQues1 = new JLabel("Câu hỏi 1");
    JLabel TextQues2 = new JLabel("Câu hỏi 2");
    JLabel TextQues3 = new JLabel("Câu hỏi 3");
    
    
    JTextField Ques1 = new JTextField();
    JTextField Ques2 = new JTextField();
    JTextField Ques3 = new JTextField();
    
    JLabel TextNameGame = new JLabel("Tên Trò Chơi");
    JTextField NameGame = new JTextField();
    
    JButton Save = new JButton();
    JButton Back = new JButton();
    
    public static CreateData savedata = new CreateData();
    CheckException Checked = new CheckException();
    ArrayList<Ochu> Ochu = new ArrayList<Ochu>();
    int row = 0;
    public static int x,y;
    int colunm = -1;
    boolean drag = false;
    public static int RectClick = 0; // khung Click
    public static boolean click = false;
    
    
    public NewGame(){
        this.setLayout(null);
        //this.setBounds(0, 0, 995, 570);
        TextAllLine.setBounds(24*30 , 24*2, 24 * 8, 24);
        Line.setBounds(24*30 , 24*3, 24 * 8, 24);
        EditLine.setBounds(24*27 , 24*3, 24 * 8, 24);
        
        TextLine.setBounds(24*30,  24*4, 24 * 4, 24);
        AddLine.setBounds(24*34 , 24*4, 24 * 5, 24);
        AddLine.setText("Thêm Dòng");
        
        Add1Line.setBounds(24*34 , 24*5, 24 * 5, 24);
        Add1Line.setText("Thêm 1 Dòng");
        
        Input.setBounds(24*33 , 24*6, 24 * 5, 24);
        TextInput.setBounds(24*30 , 24*6, 24 * 5, 24);
        
        InputString.setBounds(24*33 , 24*7, 24 * 5, 24);
        TextInputString.setBounds(24*30 , 24*7, 24 * 5, 24);
        
        Edit.setBounds(24*30 , 24*8 + 10, 24 * 8, 24);
        Edit.setText("Sửa");
        
        Delete.setBounds(24*30 , 24*9 + 15, 24 * 8, 24);
        Delete.setText("Xóa");
              
        TextQues1.setBounds(24*27 , 24*13 + 15, 24 * 8, 24);
        TextQues2.setBounds(24*27 , 24*14 + 15, 24 * 8, 24);
        TextQues3.setBounds(24*27 , 24*15 + 15, 24 * 8, 24);
        Ques1.setBounds(24*30 , 24*13 + 15, 24 * 8, 24);
        Ques2.setBounds(24*30 , 24*14 + 15, 24 * 8, 24);
        Ques3.setBounds(24*30 , 24*15 + 15, 24 * 8, 24);
        
        NameGame.setBounds(24*30 , 24*17 + 15, 24 * 8, 24);
        
        
        TextNameGame.setBounds(24*27 , 24*17 + 15, 24 * 8, 24);
        Save.setBounds(24*30 , 24*18 + 15, 24 * 8, 24*2);
        Save.setText("Lưu");
        
        Back.setBounds(24*30 , 24*20 + 15, 24 * 8, 24*2);
        Back.setText("Trở Về");
        
        this.add(Line);
        this.add(TextLine);
        this.add(AddLine);
        this.add(Add1Line);
        
        this.add(Input);
        this.add(InputString);
        this.add(Edit);
        this.add(Delete);
               
        this.add(Ques1);
        this.add(Ques2);
        this.add(Ques3);
        
        this.add(NameGame);
        this.add(Save);
        
        this.add(Back);
        
        this.add(TextInput);
        this.add(TextInputString);
        this.add(TextQues1);
        this.add(TextQues2);
        this.add(TextQues3);
        this.add(TextNameGame);
        this.add(TextAllLine);
        this.add(EditLine);
        
        AddAction();
    }
    
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        draw(g);
        // Khung lựa chọn FINAL QUESTION
        for(int j = 0;j<20;j++){
            g.setColor(Color.red);
            g.drawRect(24 + 24*j, 24*2, 24, 24);
            g.drawString(String.valueOf(j + 1), 24 + 24*j + 6, 24*2 + 12 + 6);
            //g.drawRect(0, 24*3 + 24*j, 24, 24);
        }
        // Khung CREATE GAME
        g.setColor(Color.red);
        g.drawRect(24 - 1, 24*3 - 1, 24*20 + 2, 24*20 + 2);
        // Khung EDIT ROW
        g.setColor(Color.blue);
        g.drawRect(24*colunm, 24*3, 24, 24*Ochu.size());
        g.drawRect(24*colunm - 1, 24*3 - 1, 24 + 2, 24*Ochu.size() + 2);
        g.drawRect(24*colunm - 2, 24*3 - 2, 24 + 4, 24*Ochu.size() + 4);
        

    }
    public void draw(Graphics g){
        for(int i=0;i<Ochu.size();i++){
            char[] arr = Ochu.get(i).s.toCharArray();
            // vẽ các ô vuông
            for(int j = 0;j<Ochu.get(i).size;j++){
                Ochu.get(i).draw(g);
            }
            
            // khung viền
            try{
                if(click){
                    g.setColor(Color.red);
                    g.drawRect(Ochu.get(RectClick).x, y, Ochu.get(RectClick).size * 24, 24);
                    g.drawRect(Ochu.get(RectClick).x-1, y-1, Ochu.get(RectClick).size * 24 + 2, 26);
                    g.drawRect(Ochu.get(RectClick).x-2, y-2, Ochu.get(RectClick).size * 24 + 4, 28);
                }
            }catch(Exception ex){
               
            }    
        }
    }

    // chọn cột đáp án
    public String getColString(int x){
        String s = "";
        for(int i=0;i<Ochu.size();i++){
            char[] arr = Ochu.get(i).s.toCharArray();
            s += arr[x - Ochu.get(i).x/24];
        }
        System.out.println(""+s);
        return s;
    }
    /// lưu ô chữ tạm thời
    public void saveCache(){
        row = Integer.parseInt(Input.getText());
        Ochu.get(RectClick).size = row;
        for(int i=0;i<Ochu.size();i++){
            if(Ochu.get(i).y == y) {
                Ochu.get(i).s = InputString.getText();
                Ochu.get(i).ques1 = Ques1.getText();
                Ochu.get(i).ques2 = Ques2.getText();
                Ochu.get(i).ques3 = Ques3.getText();
            }   
        }
              
    }

    public void AddAction(){
        AddLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Checked.AddLine(Line.getText())){
                    Ochu.removeAll(Ochu);
                    int line = Integer.parseInt(Line.getText());
                    for(int i =0;i<line;i++){
                        Ochu ochu = new Ochu(24, 24*3 + 24*i, 3, "","","","");
                        Ochu.add(ochu);
                    }
                }
                repaint();
            }
        });
        
        Add1Line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Ochu O = new Ochu(24,24*3 + 24*Ochu.size(), 3 ,"","","","");
                    Ochu.add(O);
                    
                }catch(Exception ex){
                    System.out.println("AddLine");
                }
                Line.setText(String.valueOf(Ochu.size()));
                repaint();
            }
        });
        
        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Checked.CheckQuestion(Ques1.getText(), Ques2.getText(), Ques3.getText())){
                        saveCache();
                }
                repaint();
            }
        });
        
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Ochu.remove(Ochu.size()-1);
                    repaint();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Không thể xóa");
                }
            }
        });
   
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Checked.CheckDataGame(Ochu)){
                    if(Checked.CheckNameGame(NameGame.getText())){
                        if(Checked.CheckColumn(colunm)) {
                            savedata.CreateTable(NameGame.getText());
                            for(int i = 0;i < Ochu.size();i++)
                                savedata.CreateNewData(NameGame.getText(), Ochu.get(i));
                            savedata.CreateColumn(NameGame.getText());
                        }
                    }
                }
                repaint();    
            }
        });
        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    pMain.removeAll();
                }catch(Exception ex){}
                    panelmain.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                    panelmain.setControl();
                    pMain.add(panelmain);
                    pMain.repaint();
                }
        });
    }
}
