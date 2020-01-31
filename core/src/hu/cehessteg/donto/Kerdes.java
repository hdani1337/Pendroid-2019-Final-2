package hu.cehessteg.donto;


import java.util.ArrayList;

public class Kerdes {
    public int id;
    public String kerdes;
    public int helyesID;

    public String valasz1;
    public String valasz2;
    public String valasz3;
    public String valasz4;

    public Kerdes(int id){
        this.id = id-1;
        setValaszok();
    }

    public void setValaszok(){
        if(id == 0){
            kerdes = "Mi az, négy lába van, asztal de nem szék?";
            valasz1 = "Szék";
            valasz2 = "Asztal";
            valasz3 = "Kecske";
            valasz4 = "Attila";
            helyesID = 2;
        }
    }
}
