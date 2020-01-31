package hu.cehessteg.donto;


import java.util.ArrayList;

public class Kerdes {
    public static ArrayList<String> kerdesek = new ArrayList<>();
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

    public static void addQuestions(){
        kerdesek.add("Mi az, négy lába van, asztal de nem szék?");
    }

    public void setValaszok(){
        switch (id){
            case 1:{
                valasz1 = "Szék";
                valasz2 = "Asztal";
                valasz3 = "Kecske";
                valasz4 = "Attila";
            }
        }
    }
}
