package com.mygdx.game.transport;

import com.mygdx.game.metod.render_metod;
import com.mygdx.game.main.Main;

import java.util.ArrayList;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class player_cannon_fragmention extends Transport {
    public player_cannon_fragmention(double x, double y, ArrayList<Transport> tr){
        this.x = x;this.y = y;
        this.speed_inert = 0;this.speed = 0;
        this.max_speed = 4;this.min_speed = -4;
        this.max_hp = 1200;
        this.spisok = tr;
        this.damage = 250;
        this.armor = 50;
        this.penetration = 7;
        this.acceleration = 0.2;
        this.rotation_tower = 0;
        this.rotation_corpus = 0;
        this.team = 1;
        this.difference = -18;
        this.tower_x_const = 8;
        this.tower_y_const = 40;
        this.tower_x = 0;
        this.tower_y = 0;
        this.reload_max = 120;
        this.height = 1;
        this.tower_image = "src/image/player/tower_player_1.png";
        this.corpus_image = "src/image/player/corpus_player_many_tower_1.png";
        this.tower_img = Main.content_base.tower_player;
        this.corpus_img = Main.content_base.corpus_player;
        this.t = 0;
        this.damage_fragment = 12;
        this.penetration_fragment = 4;
        this.x_tower = 15;
        this.y_tower = 20;
        this.sound_fire = Main.sa.get(0).cannon;

        this.corpus_width = 50;
        this.corpus_height = 129;
        this.tower_width = 35;
        this.tower_height = 55;


        this.speed_tower = 1;this.speed_rotation = 0.5;
        data();
        this.tower_obj.add(new tower_bull_tank_player(18,55,52,-12,5,2,20,12, this.id_unit,
                (byte)1,(byte)1,Main.content_base.tower_player,this.spisok,Main.sa.get(0).machinegun));
        this.tower_obj.add(new tower_bull_tank_player(18,55,52,12,5,2,20,12, this.id_unit,
                (byte)1,(byte)1,Main.content_base.tower_player,this.spisok,Main.sa.get(0).machinegun));


    }
    public void all_action(int i) {
        super.all_action(i);
        super.host_control();
        super.motor_player();
        super.fire_player_fragmentation_bull();
        super.build_corpus(Main.build);
        corpus_corpus(this.enemy_spisok,(byte)1);
        corpus_corpus_def_xy(this.enemy_spisok,(byte)1);
        super.tower_xy();
        super.tower_player();
        //corpus_bull(main.Main.bull_obj,this.team);
        super.transport_delete(i,this.spisok);
        Main.rc.get(0).x = this.x;
        Main.rc.get(0).y = this.y;
        super.all_action(i);
        center_render();
        render_metod.transorm_img((int) this.x_rend, (int) this.y_rend,this.corpus_width,this.corpus_height,this.rotation_corpus,this.corpus_img);
        tower_iteration();
        this.tower_x = this.tower_x+((this.y_tower) *sin(-this.rotation_tower*3.1415926535/180));
        this.tower_y = this.tower_y+((this.y_tower) *cos(-this.rotation_tower*3.1415926535/180));
        render_metod.transorm_img((int) this.x_tower_rend, (int) this.y_tower_rend,this.tower_width,this.tower_height,this.rotation_tower,this.tower_img,x_tower* Main.zoom,y_tower
                * Main.zoom);
    }
}
