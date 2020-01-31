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
            kerdes = "Mi az, négy lába van,\nasztal de nem szék?";
            valasz1 = "Szék";
            valasz2 = "Asztal";
            valasz3 = "Kecske";
            valasz4 = "Attila";
            helyesID = 2;
        }
        if(id == 1){
            kerdes = "Hány kutyavásár volt Budán a rege szerint?";
            valasz1 = "Kettő";
            valasz2 = "Egy se";
            valasz3 = "Három";
            valasz4 = "Több mint száz";
            helyesID = 0;//kérdésszáma
        }
        if(id == 2){
            kerdes = "Nyomj rá a pontra.";
            valasz1 = "Pont";
            valasz2 = "PONT";
            valasz3 = ".";
            valasz4 = "pont";
            helyesID = 0;//kérdésben lévő .
        }
        if(id == 3){
            kerdes = "Milyen színűa pendroid logo?";
            valasz1 = "Zöld";//kek hatter
            valasz2 = "Kék";//piros háttér
            valasz3 = "Lila";//Lila háttér
            valasz4 = "Piros";//Zöld háttér
            helyesID = 1;
        }
        if(id == 4){
            kerdes = "Melyik a gyorsabb?";
            valasz1 = "";//felvillan 0,5 secre mind
            valasz2 = "";//egymás után
            valasz3 = "";//ez legyen először
            valasz4 = "";//Utánna meg 1 sec delay mindre...
            helyesID = 3;
        }if(id == 6){
            kerdes = "Melyik a kakukktojás?";
            valasz1 = "Apple";
            valasz2 = "Microsoft";
            valasz3 = "Lenovo";
            valasz4 = "Semmi";
            helyesID = 4;
        }if(id == 7){
            kerdes = "Ki készítette a játékot?";
            valasz1 = "Céhessteg";
            valasz2 = "Microsoft";
            valasz3 = "Valve";
            valasz4 = "Ubisoft";
            helyesID = 1;
        }
        if(id == 8){
            kerdes = "Melyik a legkissebb pont?";
            valasz1 = "";
            valasz2 = "";
            valasz3 = "";
            valasz4 = "";
            helyesID = 0;//kissebb-nagyobb pontok lesznek, de a kérdésben az i pontjára kellene rányomni...
        }
        if(id == 10){
            kerdes = "Ha van 6 almám és elveszel belőle 4-et, akkor hány almád lesz?";
            valasz1 = "-2";
            valasz2 = "2";
            valasz3 = "-6";
            valasz4 = "-4";
            helyesID = 4;
        }if(id == 11){
            kerdes = "Hányszor lehet maximum elfelezni egy papír lapot?";
            valasz1 = "13szor";
            valasz2 = "1szer";
            valasz3 = "Végtelenszer";
            valasz4 = "152szer";
            helyesID = 2;
        }

    }
}
