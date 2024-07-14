package com.mygdx.game.transport;

import com.mygdx.game.main.Main;
import com.mygdx.game.metod.render_metod;

import java.awt.*;
import java.util.ArrayList;

public class track_soldat_t1 extends Transport {
    public track_soldat_t1(double x,double y, ArrayList<Transport> tr) {
        this.x = x;
        this.y = y;
        this.speed_inert = 0;
        this.speed = 0;
        this.max_speed = 4;
        this.min_speed = -4;
        this.damage = 5;
        this.spisok = tr;
        this.penetration = 20;
        this.max_hp = 1500;
        this.hp = this.max_hp;
        this.acceleration = 0.2;
        this.rotation_tower = 0;
        this.rotation_corpus = 70;
        this.difference = 0;
        this.tower_x_const = -10;
        this.tower_y_const = 3;
        this.tower_x = 0;
        this.tower_y = 0;
        this.medic_help = 0;
        this.height = 1;
        this.behavior = 2;
        this.reload_max = 180;
        this.reload = this.reload_max;
        this.team = 2;
        this.t = 0;
        this.time_spawn_soldat_max = 200;
        this.hill = 4;
        this.corpus_img = Main.content_base.track_enemy_1lvl;
        this.corpus_width = 35;
        this.corpus_height = 100;


        this.speed_tower = 1;
        this.speed_rotation = 1;
        data();
    }
    public void all_action(int i){
        super.all_action(i);
        super.motor_bot_bypass(i,Main.enemy_obj,Main.player_obj);
        super.build_corpus(Main.build);
        super.corpus_corpus_def_xy(Main.enemy_obj,(byte)1);
        super.spawn_soldat(Main.soldat_obj);
        super.transport_delete_2(i,Main.enemy_obj);
        center_render();
        render_metod.transorm_img(this.x_rend,this.y_rend,this.width_corpus_zoom,this.height_corpus_zoom,this.rotation_corpus,this.corpus_img);
    }
    public void update(){
        indicator_hp_2();
    }
}
