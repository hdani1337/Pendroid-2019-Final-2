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
        else if(id == 1){
            kerdes = "Hány kutyavásár volt\nBudán a rege szerint?";
            valasz1 = "Kettö";
            valasz2 = "Egy se";
            valasz3 = "Három";
            valasz4 = "Több mint száz";
            helyesID = 0;//
        }
        else if(id == 2){
            kerdes = "Nyomj rá a pontra.";
            valasz1 = "Pont";
            valasz2 = "PONT";
            valasz3 = ".";
            valasz4 = "pont";
            helyesID = 0;//kérdésben lévő .
        }
        else if(id == 3){
            kerdes = "Milyen színű a Pendroid logo?";
            valasz1 = "Zöld";//kek hatter
            valasz2 = "Kék";//piros háttér
            valasz3 = "Lila";//Lila háttér
            valasz4 = "Piros";//Zöld háttér
            helyesID = 1;
        }
        else if(id == 4){
            kerdes = "Melyik a gyorsabb?";
            valasz1 = "";//felvillan 0,5 secre mind
            valasz2 = "";//egymás után
            valasz3 = "";//ez legyen először
            valasz4 = "";//Utánna meg 1 sec delay mindre...
            helyesID = 3;
        }
        else if(id == 5){
            kerdes = "Melyik a jegesmedve kedvence?";
            valasz1 = "Pingvin";
            valasz2 = "Hal";
            valasz3 = "Rozmár";
            valasz4 = "Fóka";
            helyesID = 2;
        }
        else if(id == 6){
            kerdes = "Melyik a kakukktojás?";
            valasz1 = "Apple";
            valasz2 = "Microsoft";
            valasz3 = "Lenovo";
            valasz4 = "Semmi";
            helyesID = 4;
        }
        else if(id == 7){
            kerdes = "Ki készítette a játékot?";
            valasz1 = "Céhessteg";
            valasz2 = "Microsoft";
            valasz3 = "Valve";
            valasz4 = "Ubisoft";
            helyesID = 1;
        }
        else if(id == 8){
            kerdes = "Melyik a legkissebb pont?";
            valasz1 = "";
            valasz2 = "";
            valasz3 = "";
            valasz4 = "";
            helyesID = 0;//kissebb-nagyobb pontok lesznek, de a kérdésben az i pontjára kellene rányomni...
        }
        else if(id == 9){
            //setstage to bombstage
        }
        else if(id == 10){
            kerdes = "Ha van 6 almám és elveszel\nbelöle 4-et,\nakkor hány almád lesz?";
            valasz1 = "-2";
            valasz2 = "2";
            valasz3 = "-6";
            valasz4 = "-4";
            helyesID = 4;
        }
        else if(id == 11){
            kerdes = "Hányszor lehet maximum\nelfelezni egy papír lapot?";
            valasz1 = "13szor";
            valasz2 = "1szer";
            valasz3 = "Végtelenszer";
            valasz4 = "152szer";
            helyesID = 2;
        }
        else if(id == 12){
            //setstage to GordonRamsayminigame
        }
        else if(id == 13){
            kerdes = "Mit loptak el az oroszok?";
            valasz1 = "Kombináltfogót";
            valasz2 = "Tankot";
            valasz3 = "Karácsonyt";
            valasz4 = "Szását";
            helyesID = 2;
        }
        else if(id == 14){
            kerdes = "Hányadik kérdés ez?";
            valasz1 = "14.";
            valasz2 = "15.";
            valasz3 = "16.";
            valasz4 = "13.";
            helyesID = 1;//nincs kérdésszám feltüntetve!!
        }
        else if(id == 15){
            kerdes = "Keresd a hibát!";
            valasz1 = "42";
            valasz2 = "Gyógyszerész";
            valasz3 = "Farkas";
            valasz4 = "Java";
            helyesID = 0;//lehetőleg fejjel lefelé legyen a kérdés száma feltüntetve, ha nem akkor csak 51.
        }//hiányzik az 9,12


    }
}
