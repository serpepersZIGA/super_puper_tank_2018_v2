package com.mygdx.game.block;

import java.awt.*;

public class air extends Block {
    public air(int x,int y){
        this.width = 20;this.height =20;
        this.x = x;
        this.y = y;
    }
    public void all_action(){
        super.update_air();
    }

}
