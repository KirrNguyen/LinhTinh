/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.NewGame.savedata;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KirrNguyen
 */
public class CheckException {
    String s1 = "Bạn Cần Nhập Tên Trò Chơi";
    String s2 = "Tên Đã Tồn Tại";
    String s3 = "Bạn Cần Nhập Đủ Câu Hỏi Trước Khi Lưu";
    String s4 = "Bạn cần nhập số dòng vào ô trước khi thêm";
    String s5 = "Hãy chọn cột của CÂU HỎI TỐI THƯỢNG";
    String s6 = "Chưa có dữ liệu khởi tạo!! Tạo dữ liệu trước khi lưu";
    String s7 = "Hãy nhập đầy đủ Câu Hỏi và Đáp Án trước khi lưu";
    public boolean CheckNameGame(String s){
        if(s.equals("")){
            JOptionPane.showMessageDialog(null, s1);
            return false;
        }else if(!savedata.CheckTable(s)){
            JOptionPane.showMessageDialog(null, s2);
            return false;
        }else {
            return true;
        }
    }
    public boolean CheckQuestion(String in1,String in2,String in3){
        if(in1.equals("") || in2.equals("") || in3.equals("")){
            JOptionPane.showMessageDialog(null, s3);
            return false;
        }else return true;
    }
    public boolean AddLine(String s){
        if(s.equals("")){
            JOptionPane.showMessageDialog(null, s4);
            return false;
        }else return true;
    }
    public boolean CheckColumn(int i){
        if(i == -1){
            JOptionPane.showMessageDialog(null, s5);
            return false;
        }
        return true;
    }
    public boolean CheckDataGame(ArrayList<Ochu> ochu){
        if(ochu.size() == 0){
            JOptionPane.showMessageDialog(null, s6);
            return false;
        }else{
            for(int i =0;i<ochu.size();i++){
                if(ochu.get(i).s.equals("") || ochu.get(i).ques1.equals("") ||
                   ochu.get(i).ques2.equals("") || ochu.get(i).ques3.equals("") ){
                    JOptionPane.showMessageDialog(null, s7);
                    return false;
                }
            }
        }
        return true;
    }
}
