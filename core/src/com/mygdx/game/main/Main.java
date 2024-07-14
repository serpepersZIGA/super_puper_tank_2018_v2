package com.mygdx.game.main;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.block.Block;
import com.mygdx.game.block.air;
import com.mygdx.game.block.dirt;
import com.mygdx.game.build.Build;
import com.mygdx.game.build.home_1;
import com.mygdx.game.bull.Bull;
import com.mygdx.game.data_base;
import com.mygdx.game.metod.Keyboard;
import com.mygdx.game.metod.Zoom;
import com.mygdx.game.metod.control_client;
import com.mygdx.game.metod.render_center;
import com.mygdx.game.particle.flame_spawn;
import com.mygdx.game.particle.particle;
import com.mygdx.game.soldat.Soldat;
import com.mygdx.game.transport.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter{
	public static ArrayList<Transport> player_obj = new ArrayList<>();
	public static ArrayList<Transport> enemy_obj = new ArrayList<>();
	public static ArrayList<Build>build = new ArrayList<>();
	public static ArrayList<Bull>bull_obj = new ArrayList<>();
	public static ArrayList<particle> flame_static_obj = new ArrayList<>();
	public static ArrayList<particle> flame_obj = new ArrayList<>();
	public static ArrayList<Soldat>soldat_obj = new ArrayList<>();
	public static ArrayList<particle>bang_obj = new ArrayList<>();
	public static ArrayList<particle>flame_particle_obj = new ArrayList<>();
	public static ArrayList<particle>liquid_obj = new ArrayList<>();
	public static ArrayList<com.mygdx.game.particle.flame_spawn>flame_spawn = new ArrayList<>();
	public static ArrayList<Transport>helicopter_obj = new ArrayList<>();
	public static ArrayList<Transport>debris = new ArrayList<>();

	public static ArrayList<sound.sound_archive>sa = new ArrayList<>();
	public static ArrayList<Block>block_air = new ArrayList<>();

	public static List<render_center>rc = new ArrayList<>();
	public static  ArrayList<Transport>tower_obj = new ArrayList<>();
	public static ArrayList<double[]> size_render = new ArrayList<>();
	public static ArrayList<com.mygdx.game.metod.control_client>control_client = new ArrayList<>();
	public static ArrayList<Block>block = new ArrayList<>();
	public static ArrayList<Zoom> Zoom_list = new ArrayList<>();
	public static data_base content_base;
	public static ArrayList<Sprite>sprites = new ArrayList<>();
	public static SpriteBatch batch;
	public static Keyboard keyboard;
	public static boolean press_w,press_s,press_a,press_d;
	public static boolean left_mouse,right_mouse;
	public static boolean press_w_client,press_s_client,press_a_client,press_d_client;
	public static int screenWidth = 1536;
	public static int screenHeight = 864;
	public static boolean left_mouse_client,right_mouse_client;
	public static double mouse_x_client,mouse_y_client;
	public static byte game_sost = 0;
	public int i,i_images;
	public static double zoom = 1;
	public static int mouse_x,mouse_y;
	public static ServerSocket Serversocket;
	public static ShapeRenderer render;
	public static OrthographicCamera camera;
	public static Socket socket;

	//public Thread thread = new Thread(new action_game_host());
	//private static OrthographicCamera camera;
	//public static File file = new File("src/buffer.data");
	public int width_2,height_2,x_block,y_block,width_block= 50,height_block =50,width_block_air= 20,height_block_air =20;
	Texture img;
	public Main(){
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false,1000, 1000);
		Main.sa.add(new sound.sound_archive());



//        if(game_sost == 0){
//            try {
//                String ip = InetAddress.getLocalHost().getHostAddress();
//                Serversocket = new ServerSocket(2451,5000);
//                socket = Serversocket.accept();
//                System.out.println(ip);
//                //DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
//                //DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
//                //ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
//
//                spawn_object();
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        else if(game_sost == 1){
//            //String ip = InetAddress.getLocalHost().getHostAddress();
//            socket = new Socket("127.0.0.1", 2451);
//            //ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
//        }
		//this.addMouseWheelListener(this);
		//input = new ObjectInputStream(main.Game.socket.getInputStream());
		//output = new ObjectOutputStream(main.Game.socket.getOutputStream());

		//main.display.main.display.addMouseWheelListener(this);
		//setFocusable(true);
	}


	private void spawn_object(){
		Main.player_obj.add(new player_cannon_flame(400,600,Main.player_obj));
		//Main.player_obj.add(new player_cannon_flame(600,600,Main.player_obj));
		Main.enemy_obj.add(new panzer_howitzer_mt1(700,800,enemy_obj));
		Main.build.add(new home_1(400,400,0));
		//Main.enemy_obj.add(new panzer_mt1_flame(700,600,Main.enemy_obj));
		//Main.enemy_obj.add(new track_remont_f1(400,600,Main.enemy_obj));
		Main.enemy_obj.add(new track_soldat_t1(700,600,Main.enemy_obj));
		//Main.build.add(new home_1(600,400,0));
		//Main.build.add(new home_1(800,400,0));
		//Main.build.add(new home_1(1000,400,0));
		//Main.build.add(new home_1(1170,400,0));
		Main.flame_spawn.add(new flame_spawn(500,500));
	}
	public void field(int width_field,int height_field){
		int quantity_width = width_field/this.width_block;
		int quantity_height = height_field/this.height_block;
		this.width_2 = this.width_block/2;
		this.height_2 = this.height_block/2;
		this.width_block*=1.24;
		this.height_block*=1.24;

		this.x_block = this.width_2;
		this.y_block = -1000;
		for(int i = quantity_height;i>0;i--){
			this.y_block += this.height_block;
			this.x_block = -1000;

			for(int i2 = quantity_width;i2>0;i2--){
				this.x_block += this.width_block;
				Main.block.add(new dirt(this.x_block,this.y_block));

			}
		}
		quantity_width = (int)(screenWidth/this.width_block_air);
		quantity_height = (int)(screenHeight/this.height_block_air);
		this.y_block = -20;
		for(int i = quantity_height+1;i>0;i--){
			this.y_block += this.height_block_air;
			this.x_block = -20;

			for(int i2 = quantity_width+1;i2>0;i2--){
				this.x_block += this.width_block_air;
				Main.block_air.add(new air(this.x_block,this.y_block));

			}
		}


	}

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		render = new ShapeRenderer();
		Main.rc.add(new render_center(700,0));
		batch = new SpriteBatch();
		content_base = new data_base();
		keyboard = new Keyboard();
		Gdx.input.setInputProcessor(keyboard);
		//Gdx.input.setInputProcessor(keyboard);
		spawn_object();
		field(5000,5000);
		keyboard.zoom_const();
	}
	@Override
	public void render () {
		new action_game_host();
	}
	@Override
	public void dispose () {
		batch.dispose();
		render.dispose();
		//img.dispose();
	}
	public void resize(int width,int height){}
}