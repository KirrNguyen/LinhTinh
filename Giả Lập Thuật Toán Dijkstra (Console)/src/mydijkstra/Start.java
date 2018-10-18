/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydijkstra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KirrNguyen
 */
public class Start {
    int a,b;
    int x;
    ArrayList<Save> save = new ArrayList<Save>();
    ArrayList<Save> cachesave = new ArrayList<Save>();
    ArrayList<String> duongdi = new ArrayList<String>();
    ArrayList<Integer> dadiqua = new ArrayList<Integer>();
    int arr[][] = {{0,3,0,2,4},
                    {3,0,4,0,2},
                    {0,4,0,6,5},
                    {2,0,6,0,1},
                    {4,2,5,1,0}};
    public void CacheData(){
        for(int i = 0;i<arr.length;i++){
            Save Cache = new Save(-1, -1);
            save.add(Cache);
        }
    }
    public void newCache(){
        cachesave.clear();
        for(int i = 0;i<arr.length;i++){
            Save Cache = new Save(-1, -1);
            cachesave.add(Cache);
        }
    }
    public Start(){
        CacheData();
        newCache();
//        Scanner sn = new Scanner(System.in);
//        System.out.print("bat dau ");
//        a = sn.nextInt();
//        System.out.print("ket thuc ");
//        b = sn.nextInt();
//        run(0);
        Run(0);
    }
    public void Run(int x){
        Loop1(0);
        Loop2(vt);
        Loop3();
        Loop4();
        Loop5(vt);
        Loop6();
        Loop7();
        Loop8(vt);
        Loop9();
        Loop10();
    }
    int min = -1;
    int vt = 0;
    public void Loop1(int x){
        
        System.out.println("Loop 1");
        save.get(x).d = x;
        save.get(x).y = 0;
        
        dadiqua.add(x);
        for(int i = 0;i<arr.length;i++){
            if(check(i)){
                if(arr[x][i] != 0 ){
                    Save cache = new Save(arr[x][i], i);
                    if(save.get(i).y == -1){
                        save.get(i).y = arr[x][i] + save.get(x).y;
                        save.get(i).d = x;
                    }else if(cache.y + save.get(x).y < save.get(i).y){
                        save.get(i).y = arr[x][i] + save.get(x).y;
                        save.get(i).d = x;
                    }
                }
            }
        }
        ///
        for(int i = 0;i<save.size();i++){
            if(check(i))
                if(save.get(i).y != -1 && save.get(i).y != 0 ){
                    if(min == -1){
                        min = save.get(i).y;
                        vt = i;
                    }else if(save.get(i).y < min){
                        min = save.get(i).y;
                        vt = i;
                    }
                }
        }
        System.out.println("Min = " + min + " diem = " + vt);
        dadiqua.add(vt);
        /////
        for(int i = 0;i<save.size();i++){
            System.out.println("kgoang cach "+save.get(i).y+", diem "+(save.get(i).d));
        }
    }
    public void Loop2(int x){
        System.out.println("loop 2");
        System.out.println("bat dau "+x);
        cachesave.get(x).d = x;
        cachesave.get(x).y = 0;
        for(int i = 0;i<dadiqua.size();i++){
            System.out.println(""+dadiqua.get(i));
        }
        for(int i = 0;i<arr.length;i++){
            if(check(i)){
                if(arr[x][i] != 0){
                    Save cache = new Save(arr[x][i], i);
                    if(cachesave.get(i).y == -1){
                        cachesave.get(i).y = arr[x][i] + cachesave.get(x).y;
                        cachesave.get(i).d = x;
                    }
                    else if(cache.y + cachesave.get(x).y < cachesave.get(i).y){
                        cachesave.get(i).y = arr[x][i] + cachesave.get(x).y;
                        cachesave.get(i).d = x;
                    }
                 }
             }
        }
        
        for(int i = 0;i<cachesave.size();i++){
            System.out.println("kgoang cach "+cachesave.get(i).y+", diem "+(cachesave.get(i).d));
        }
    }
    public void Loop3(){
        System.out.println("Loop 3");
        for(int i = 0;i < cachesave.size();i++){
            if(cachesave.get(i).y != -1){
                if(save.get(i).y == -1){
                    save.get(i).y = cachesave.get(i).y + min;
                    save.get(i).d = cachesave.get(i).d;
                }else  if(cachesave.get(i).y + min < save.get(i).y){
                    save.get(i).y = cachesave.get(i).y + min;
                    save.get(i).d = cachesave.get(i).d;
                }
            }
        }
        for(int i = 0;i<cachesave.size();i++){
            System.out.println("kgoang cach "+save.get(i).y+", diem "+(save.get(i).d));
        }
    }
    public void Loop4(){
        //set lai min
        min = -1;
        vt = 0;
        System.out.println("Loop 4");
        for(int i = 0;i<save.size();i++){
            if(check(i)){
                if(save.get(i).y != -1 && save.get(i).y != 0 ){
                    if(min == -1){
                        min = save.get(i).y;
                        vt = i;
                    }else if(save.get(i).y < min){
                        min = save.get(i).y;
                        vt = i;
                    }
                }
            }
        }
        System.out.println("Min = " + min + " diem = " + vt);
        dadiqua.add(vt);
    }
    public void Loop5(int x){
        newCache();
        System.out.println("loop 5");
        System.out.println("bat dau "+x);
        cachesave.get(x).d = x;
        cachesave.get(x).y = 0;
        for(int i = 0;i<arr.length;i++){
            if(check(i)){
                if(arr[x][i] != 0){
                    Save cache = new Save(arr[x][i], i);
                    if(cachesave.get(i).y == -1){
                        cachesave.get(i).y = arr[x][i] + cachesave.get(x).y;
                        cachesave.get(i).d = x;
                    }
                    else if(cache.y + cachesave.get(x).y < cachesave.get(i).y){
                        cachesave.get(i).y = arr[x][i] + cachesave.get(x).y;
                        cachesave.get(i).d = x;
                    }
                }
            }
        }
        
        for(int i = 0;i<cachesave.size();i++){
            System.out.println("kgoang cach "+cachesave.get(i).y+", diem "+(cachesave.get(i).d));
        }
    }
    public void Loop6(){
        System.out.println("Loop 6");
        for(int i = 0;i < cachesave.size();i++){
            if(cachesave.get(i).y != -1){
                if(save.get(i).y == -1){
                    save.get(i).y = cachesave.get(i).y + min;
                    save.get(i).d = cachesave.get(i).d;
                }else  if(cachesave.get(i).y + min < save.get(i).y){
                    save.get(i).y = cachesave.get(i).y + min;
                    save.get(i).d = cachesave.get(i).d;
                }
            }
        }
        for(int i = 0;i<cachesave.size();i++){
            System.out.println("kgoang cach "+save.get(i).y+", diem "+(save.get(i).d));
        }
    }
    public void Loop7(){
        min = -1;
        vt = 0;
        System.out.println("Loop 7");
        for(int i = 0;i<save.size();i++){
            if(check(i)){
                if(save.get(i).y != -1 && save.get(i).y != 0 ){
                    if(min == -1){
                        min = save.get(i).y;
                        vt = i;
                    }else if(save.get(i).y < min){
                        min = save.get(i).y;
                        vt = i;
                    }
                }
            }
        }
        System.out.println("Min = " + min + " diem = " + vt);
        dadiqua.add(vt);
    }
    public void Loop8(int x){
        newCache();
        System.out.println("loop 8");
        System.out.println("bat dau "+x);
        cachesave.get(x).d = x;
        cachesave.get(x).y = 0;
        for(int i = 0;i<arr.length;i++){
            if(check(i)){
                if(arr[x][i] != 0){
                    Save cache = new Save(arr[x][i], i);
                    if(cachesave.get(i).y == -1){
                        cachesave.get(i).y = arr[x][i] + cachesave.get(x).y;
                        cachesave.get(i).d = x;
                    }
                    else if(cache.y + cachesave.get(x).y < cachesave.get(i).y){
                        cachesave.get(i).y = arr[x][i] + cachesave.get(x).y;
                        cachesave.get(i).d = x;
                    }
                }
            }
        }
        
        for(int i = 0;i<cachesave.size();i++){
            System.out.println("kgoang cach "+cachesave.get(i).y+", diem "+(cachesave.get(i).d));
        }
    }
    public void Loop9(){
         System.out.println("Loop 9");
        for(int i = 0;i < cachesave.size();i++){
            if(cachesave.get(i).y != -1){
                if(save.get(i).y == -1){
                    save.get(i).y = cachesave.get(i).y + min;
                    save.get(i).d = cachesave.get(i).d;
                }else  if(cachesave.get(i).y + min < save.get(i).y){
                    save.get(i).y = cachesave.get(i).y + min;
                    save.get(i).d = cachesave.get(i).d;
                }
            }
        }
        for(int i = 0;i<cachesave.size();i++){
            System.out.println("kgoang cach "+save.get(i).y+", diem "+(save.get(i).d));
        }
    }
    public void Loop10(){
        min = -1;
        vt = 0;
        System.out.println("Loop 7");
        for(int i = 0;i<save.size();i++){
            if(check(i)){
                if(save.get(i).y != -1 && save.get(i).y != 0 ){
                    if(min == -1){
                        min = save.get(i).y;
                        vt = i;
                    }else if(save.get(i).y < min){
                        min = save.get(i).y;
                        vt = i;
                    }
                }
            }else System.out.println("ket thuc");
        }
        System.out.println("Min = " + min + " diem = " + vt);
        dadiqua.add(vt);
    }
    public boolean check(int i){
        int boo = 0;
        for(int j = 0;j<dadiqua.size();j++){
            if(i == dadiqua.get(j)) boo++;
        }
        if(boo == 0) return true;
        else return false;
    }
    public void run(int x){
        for(int i = 0;i<5;i++){
            if(x == i){
                Save cache = new Save(0, x);
                save.add(cache);
            }else if(arr[x][i] != 0){
                Save cache = new Save(arr[x][i], i);
                save.add(cache);
            }else{
                Save cache = new Save(-1, i);
                save.add(cache);
            }
        }
        dadiqua.add(0);
        cachesave = save;
        
        System.out.println("nut");
        for(int i = 0;i<save.size();i++){
            System.out.println("kgoang cach "+save.get(i).y+", diem "+(save.get(i).d+1));
        }
        Continue(x);
        System.out.println(""+vt);
        Continue2(vt);
        //Sort(cachesave);
//        System.out.println("khoang cach");
//        for(int i = 0;i<cachesave.size();i++){
//            System.out.println("kgoang cach "+cachesave.get(i).y+", diem "+(cachesave.get(i).d+1));
//        }
    }
    
    // tim gia tri nho nhat
    public void Continue(int input){
        
        for(int i = 0;i<save.size();i++){
            if(input != save.get(i).d){
                if(save.get(i).y != -1){
                    if(min == -1){
                        min = save.get(i).y;
                        vt = save.get(i).d;
                    }else if(save.get(i).y < min){
                        min = save.get(i).y;
                        vt = save.get(i).d;
                    }
                }
            }
        }
        // tăng giá trị lên 1 (tạm thời)
        //vt++;
        System.out.println("Min = " + min + " diem = " + vt);
        dadiqua.add(vt);
    }
    
    public void Continue2(int x){
//        for(int i = 0;i<dadiqua.size();i++){
//            System.out.println(""+dadiqua.get(i));
//        }
//        System.out.println(""+save.get(4).y);
//        System.out.println(""+save.get(2).y);
        for(int i = 0;i<5;i++){
            for(int j = 0;j<dadiqua.size();j++){
                if(i != dadiqua.get(j)){
                    if(arr[x][i] != 0){
                        Save cache = new Save(arr[x][i], i);
                        if(save.get(i).y == -1){
                            save.get(i).y = cache.y + arr[x][i];
                            save.get(i).d = x;
                        }else if(cache.y + save.get(x).y < save.get(i).y){
                            save.get(i).y = cache.y + save.get(x).y;
                            save.get(i).d = x;
                        }
                        //save.add(cache);
                    }
                }
//                else{
//                    Save cache = new Save(-1, i);
//                    save.add(cache);
//                }
            }
        }
        for(int i = 0;i<save.size();i++){
            System.out.println("kgoang cach "+save.get(i).y+", diem "+(save.get(i).d+1));
        }
        
    }
    
    
    public void Sort(ArrayList<Save> save){
//        Collections.sort(save, new Comparator<Save>() {
//            @Override
//            public int compare(Save sv1, Save sv2) {
//                if (sv1.y < sv2.y) {
//                    return -1;
//                } else {
//                    if (sv1.y == sv2.y) {
//                        return 0;
//                    } else {
//                        return 1;
//                    }
//                }
//            }
//        });
        Save cache = new Save(0, 0);
            for(int i = 0;i < save.size() - 1;i++){
                for(int j = i + 1;j < save.size();j++){
                    if(save.get(i).y > save.get(j).y){
                        cache.d = save.get(i).d;
                        cache.y = save.get(i).y;

                        save.get(i).d = save.get(j).d;
                        save.get(i).y = save.get(j).y;

                        save.get(j).d = cache.d;
                        save.get(j).y = cache.y;
                }
            }
        }
    }

    
}
