package hu.cehessteg.donto;

import java.util.ArrayList;

public class Kerdes {
    public int id;
    public static ArrayList<String> kerdesek;
    public ArrayList<Valasz> valaszokList;

    public Kerdes(int id){
        this.id = id-1;
        addQuestions();
    }

    private void addQuestions(){
        kerdesek = new ArrayList<>();
        /**
         * ADDING QUESTIONS HERE
         * **/

        /**
         * FILL UP VALASZOK ARRAYLIST HERE
         * **/
        for (int i = 0; i < kerdesek.size(); i++)
            valaszokList.add(new Valasz(this));
    }
}
