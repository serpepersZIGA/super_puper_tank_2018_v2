package com.mygdx.game.block;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.main.Main;

import com.mygdx.game.metod.render_metod;

import static com.mygdx.game.main.Main.batch;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;
import static java.sql.Types.NULL;

public abstract class Block {
    public int x,y,x_rend,y_rend;
    public int width,height,transparency = -150,brightness,radius;
    public Texture img;
    public int width_zoom,height_zoom;
    private int i;
    //public Texture paint;
    public Pixmap pixmap;

    public void update(){
        center_render();
        render_metod.transorm_img(this.x_rend,this.y_rend,this.width_zoom,this.height_zoom,this.img);
        //g.drawImage(this.img,(int)((this.x_rend/correct_int)* Game_tank.zoom),(int)((this.y_rend/correct_int)* Game_tank.zoom),(int)(this.width* Game_tank.zoom),(int)(this.height* Game_tank.zoom),null);

    }
    public void all_action(){

    }
    public void update_air() {
        this.radius = NULL;
        for (i = 0; i < Main.flame_spawn.size(); i++) {
            int gh = (int) sqrt(pow(Main.flame_spawn.get(i).x_rend - this.x, 2) + pow(Main.flame_spawn.get(i).y_rend - this.y, 2));
            if (this.radius == NULL || this.radius > gh) {
                this.radius = gh;

            }
        }

        for (i = 0; i < Main.build.size(); i++) {
            if(Main.build.get(i).time_flame > 0) {
                int gh = (int) sqrt(pow(Main.build.get(i).x_rend - this.x, 2) + pow(Main.build.get(i).y_rend - this.y, 2));
                if (this.radius == NULL || this.radius > gh) {
                    this.radius = gh;

                }
            }
        }
        if(this.radius != NULL) {
            brightness = transparency + (int) (this.radius / Main.zoom);
            if (brightness < 0) {
                brightness = 0;
            } else if (brightness > 215) {
                brightness = 215;
            }
            Main.render.setColor(0,0,0,1-(1f/brightness)*40);
            Main.render.rect(x,y,width,height);
        } else{
            Main.render.setColor(0, 0, 0,0.8f);
            Main.render.rect(x,y,width,height);

        }
    }
    public void center_render(){
        double[]xy = Main.rc.get(0).render_obj(this.x,this.y);
        this.x_rend = (int)(xy[0]* Main.zoom);
        this.y_rend = (int)(xy[1]* Main.zoom);
    }




}
