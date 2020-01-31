package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Vezetek extends OneSpriteStaticActor {

    public static final String LILA = "other/vezetek_l.png";
    public static final String LILA_CUT = "other/vezetekek_l_cut.png";

    public static final String ZOLD = "other/vezetek_z.png";
    public static final String ZOLD_CUT = "other/vezetek_z_cut.png";

    public static final String SARGA = "other/vezetek_s.png";
    public static final String SARGA_CUT = "other/vezetek_s_cut.png";

    public static final String KEK = "other/vezetek_k.png";
    public static final String KEK_CUT = "other/vezetek_k_cut.png";

    public static final String PIROS = "other/vezetek_p.png";
    public static final String PIROS_CUT = "other/vezetek_p_cut.png";

    public static AssetList assetList;
    static {
        assetList = new AssetList();
        assetList.addTexture(LILA);
        assetList.addTexture(LILA_CUT);
        assetList.addTexture(ZOLD);
        assetList.addTexture(ZOLD_CUT);
        assetList.addTexture(SARGA);
        assetList.addTexture(SARGA_CUT);
        assetList.addTexture(KEK);
        assetList.addTexture(KEK_CUT);
        assetList.addTexture(PIROS);
        assetList.addTexture(PIROS_CUT);
    }

    public Vezetek(MyGame game, String szin) {
        super(game, getHash(false, szin));
        addListeners(szin);
        setHeight(getHeight()*0.77f);
    }

    private static String getHash(boolean elvagva, String szin){
        System.out.println(szin);
        if(!elvagva){
            if(szin.equals("piros")) return PIROS;
            else if(szin.equals("kék")) return KEK;
            else if(szin.equals("zöld")) return ZOLD;
            else if(szin.equals("sárga")) return SARGA;
            else return LILA;
        }
        else{
            if(szin == "piros") return PIROS_CUT;
            else if(szin == "kék") return KEK_CUT;
            else if(szin == "zöld") return ZOLD_CUT;
            else if(szin == "sárga") return SARGA_CUT;
            else return LILA_CUT;
        }
    }

    public void szakad(String szin){
        sprite.setTexture(game.getMyAssetManager().getTexture(getHash(true, szin)));
    }

    private void addListeners(final String szin){
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                szakad(szin);
            }
        });
    }
}
