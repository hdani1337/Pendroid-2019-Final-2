package hu.cehessteg.donto;

import java.util.ArrayList;

public class Valasz {
    public int valaszID;
    public static ArrayList<String> valaszok;

    public Valasz(Kerdes kerdes){
        this.valaszID = kerdes.id;
        setValaszok();
    }

    private void setValaszok(){
        valaszok = new ArrayList<>();
        /**
         * ADD ANSWERS HERE SEPARATED WITH COMMAS FROM EACH OTHER
         * **/
    }

    public String getValaszok(int id){
        return valaszok.get(id);
    }
}
