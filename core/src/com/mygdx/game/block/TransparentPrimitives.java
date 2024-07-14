//package com.mygdx.game.block;
//
//import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Pixmap;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
//public class TransparentPrimitives implements ApplicationListener {
//
//    private SpriteBatch batch;
//    private OrthographicCamera camera;
//
//    @Override
//    public void create() {
//        batch = new SpriteBatch();
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//
//        // Создать текстуру для квадрата
//        Pixmap squarePixmap = new Pixmap(100, 50, Pixmap.Format.RGBA8888);
//        squarePixmap.setColor(1, 1, 0, 0.5f); // Желтый полупрозрачный
//        squarePixmap.fillRectangle(0, 0, 100, 50);
//        Texture squareTexture = new Texture(squarePixmap);
//
//        // Создать текстуру для круга
//        Pixmap circlePixmap = new Pixmap(100, 50, Pixmap.Format.RGBA8888);
//        circlePixmap.setColor(1, 0, 0, 0.25f); // Красный прозрачный на четверть
//        circlePixmap.fillCircle(50, 25, 25);
//        Texture circleTexture = new Texture(circlePixmap);
//
//        // Очистить текстуры после их использования
//        //squarePixmap.dispose();
//        //circlePixmap.dispose();
//    }
//
//    @Override
//    public void render() {
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        batch.begin();
//        batch.draw(squareTexture, 100, 100);
//        batch.draw(circleTexture, 300, 100);
//        batch.end();
//    }
//
//    @Override
//    public void dispose() {
//        batch.dispose();
//        squareTexture.dispose();
//        circleTexture.dispose();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        camera.setToOrtho(false, width, height);
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//}
