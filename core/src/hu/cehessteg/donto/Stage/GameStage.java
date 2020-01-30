package hu.cehessteg.donto.Stage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStage extends MyStage {

    public static AssetList assetList = new AssetList();
    static {

    }

    //STATIKUS VÁLTOZÓK
    public static boolean isAct;
    public static boolean isDead;


    public GameStage(MyGame game) {
        super(new ResponseViewport(900), game);
        assignment();
        setSizesAndPositions();
        addActors();
    }

    private void assignment()
    {
        isAct = true;
        isDead = false;
    }

    private void setSizesAndPositions()
    {
        /**SIZES**/

        /**POSITIONS**/
    }

    private void addActors()
    {

    }


    @Override
    public void act(float delta) {
        super.act(delta);
        /**
         * ÜTKŐZÉSVIZSGÁLATOK
         * */
        if (isAct) {//Az isAct változó false lesz, ha a játékos veszít vagy megállítja, így ezek nem futnak le feleslegesen

        }
        else{
        }
    }
}
