package com.mygdx.game.particle;
import com.mygdx.game.main.Main;
import com.mygdx.game.metod.rand;


public class acid extends particle {
    public acid(double x,double y){
        this.x = x;
        this.y = y;
        this.size = rand.rand(16,24);
        //this.size_render = (int)(size*Main.zoom);
        this.speed_x = 0;
        this.speed_y = 0;
        this.color = new float[]{(float)1/255*51, (float)1/255*179, (float)1/255*51};
        this.interval_rise_size = -0.02;


    }
    public void all_action(int i){
        //super.move_particle();
        super.liquid_physic(i,Main.liquid_obj);
        //super.size_rise();
        super.size_rise_delete(Main.liquid_obj,i);
        center_render();
        Main.render.setColor(color[0],color[1],color[2],1);
        Main.render.circle(this.x_rend,this.y_rend,(int)(size*Main.zoom),(int)(size*Main.zoom));
        //super.clear();
    }

}
