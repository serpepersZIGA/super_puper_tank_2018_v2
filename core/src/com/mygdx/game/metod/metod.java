package com.mygdx.game.metod;

import com.mygdx.game.build.Build;
import com.mygdx.game.main.Main;
import com.mygdx.game.particle.particle;
import com.mygdx.game.soldat.Soldat;
import com.mygdx.game.transport.Transport;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.StrictMath.*;
import static java.sql.Types.NULL;

public class metod {
    public static double tower(double x, double y, double x_2, double y_2, double rotation_tower, double speed_tower) {
        double gh = atan2(y - y_2, x - x_2) / 3.1415926535 *180;
        gh +=90;
        if(gh>180 && rotation_tower<0){
            gh= -90;
        }
        if(gh<0 && rotation_tower>180){
            gh= 270;
        }
        if (rotation_tower > 269){rotation_tower = -89;}
        else if (rotation_tower < -89){rotation_tower = 269;}
        if (rotation_tower < gh) {
            rotation_tower += speed_tower;
        } else if (rotation_tower > gh) {
            rotation_tower -= speed_tower;
        }
        return rotation_tower;
    }
    public static double difference_rotation_sin(double x,double difference,double rotation){
        return x - (difference * sin(rotation * 3.1415926535 / 180.0));
    }
    public static double difference_rotation_cos(double x,double difference,double rotation){
        return x - (difference * cos(rotation * 3.1415926535 / 180.0));
    }
    public static double[]tower_xy(double x,double y,double fire_x,double fire_y,double difference,double rotation){
        double tower_x = difference_rotation_sin(x+fire_x,-difference,rotation);
        double tower_y = difference_rotation_cos(y+fire_y,-difference,rotation);
        double[]xy = {tower_x,tower_y};
        return xy;
    }
    public static double[]tower_xy_2(double x,double y,double fire_x,double fire_y,double difference,double difference_2,double rotation){
        double tower_x = difference_rotation_sin(x+fire_x,-difference,rotation);
        double tower_y = difference_rotation_cos(y+fire_y,-difference,rotation);
        tower_x = difference_rotation_sin(tower_x,-difference_2,rotation-90);
        tower_y = difference_rotation_cos(tower_y,-difference_2,rotation-90);
        double[]xy = {tower_x,tower_y};
        return xy;
    }
    public static double tower_player(double x, double y, double rotation_tower, double speed_tower) {
        return tower(x, y, Main.mouse_x, Main.mouse_y, rotation_tower, speed_tower);

    }
    public static int detection_near_build_i(ArrayList<Transport> obj_bot, int i, ArrayList<Build> obj) {
        int ind = 0;
        int radius = NULL;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            double g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
            if (radius == NULL || radius > g) {
                radius = (int)g;
                ind = i2;

            }
        }

        return ind;
    }
    public static int detection_near_transport_i(ArrayList<Transport> obj_bot, int i, ArrayList<Transport> obj) {
        double x = 0;
        double y = 0;
        int ind = 0;
        int radius = NULL;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            double g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
            if (radius == NULL || radius > g) {
                ind = i2;
                radius = (int)g;

            }
        }
        return ind;
    }
    public static int[] detection_near_transport_i_def(ArrayList<Transport> obj_bot, int i, ArrayList<Transport> obj) {
        double x = 0;
        double y = 0;
        int ind = NULL;
        int radius = NULL;
        double g;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
            if (radius > g || radius == NULL) {
                if(obj.get(i2).x != obj_bot.get(i).x && obj.get(i2).y != obj_bot.get(i).y) {
                    ind = i2;
                    radius = (int) g;
                }
            }
        }
        return new int[]{ind,radius};
    }
    public static int[] detection_near_soldat_transport_i_def(ArrayList<Soldat> obj_bot, int i, ArrayList<Transport> obj) {
        double x = 0;
        double y = 0;
        int ind = NULL;
        int radius = NULL;
        double g;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
            if (radius > g || radius == NULL) {
                if(obj.get(i2).x != obj_bot.get(i).x && obj.get(i2).y != obj_bot.get(i).y) {
                    ind = i2;
                    radius = (int) g;
                }
            }
        }
        return new int[]{ind,radius};
    }
    public static int[] detection_near_particle_xy_def(ArrayList<particle> obj_bot, int i, ArrayList<particle> obj) {
        double x = 0;
        double y = 0;
        double g;
        int gh;
        int ind = NULL;
        int radius = NULL;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
                    if (radius > g || radius == NULL) {
                        if (obj.get(i2).x != obj_bot.get(i).x && obj.get(i2).y != obj_bot.get(i).y) {
                        radius = (int)g;
                        ind = i2;}
                    }
        }
        gh = (int)(atan2(obj_bot.get(i).y - obj.get(ind).y, obj_bot.get(i).x - obj.get(ind).x) / 3.14 * 180);
        return new int[]{radius,gh,ind};
    }

    public static int detection_near_soldat_transport(ArrayList<Soldat> obj_bot, int i, ArrayList<Transport> obj) {
        double x = 0;
        double y = 0;
        int ind = NULL;
        int radius = NULL;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            double g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
            if (radius == NULL || radius > g) {
                ind = i2;
                radius = (int) g;

            }
        }
        return ind;
    }
    public static int detection_near_soldat_build(ArrayList<Soldat> obj_bot, int i, ArrayList<Build> obj) {
        double x = 0;
        double y = 0;
        int ind = NULL;
        int radius = NULL;
        for (int i2 = 0; i2 < obj.size(); i2++) {
            double g = sqrt(pow((obj_bot.get(i).x - obj.get(i2).x), 2) + pow(obj_bot.get(i).y - obj.get(i2).y, 2));
            if (radius == NULL || radius > g) {
                ind = i2;
                radius = (int) g;
            }
        }
        return ind;
    }

}
