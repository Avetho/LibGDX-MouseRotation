package srotate;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class sRotate extends ApplicationAdapter implements InputProcessor{

    SpriteBatch batch;
    Texture imgreticle, imgsprite;
    Sprite spReticle, spChar;
    int nCursorX, nCursorY;
    float fCharRot, fCharMove, fCharAdditive, fPosX, fPosY;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgreticle = new Texture("badlogic.jpg");
        imgsprite = new Texture("characterSprite0.png");
        spReticle = new Sprite(imgreticle);
        spReticle.setOrigin(spReticle.getWidth() / 2, spReticle.getHeight() / 2);
        spReticle.setSize(Gdx.graphics.getWidth() / 200, Gdx.graphics.getWidth() / 200);
        spChar = new Sprite(imgsprite);
        spChar.setSize(Gdx.graphics.getWidth() / 8, Gdx.graphics.getWidth() / 10);
        fPosY = Gdx.graphics.getHeight() / 2;
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.exit(3);
        }
        nCursorX = Gdx.input.getX();
        nCursorY = Gdx.graphics.getHeight() - Gdx.input.getY();
        fCharRot = findAngle(fPosX, fPosY, nCursorX, nCursorY);
        fCharMove = (nCursorY-fPosY)/25;
        fPosY += fCharMove;
        spChar.setRotation(fCharRot - 90);
        fPosX = Gdx.graphics.getWidth() / 5;
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(spChar, fPosX - (spChar.getWidth() / 2), fPosY - (spChar.getHeight() / 2), spChar.getOriginX(), spChar.getOriginY(), spChar.getHeight(), spChar.getWidth(), spChar.getScaleX(), spChar.getScaleY(), spChar.getRotation(), true);
        batch.draw(spReticle, nCursorX - (spReticle.getWidth() / 2), nCursorY - (spReticle.getHeight() / 2), spReticle.getOriginX(), spReticle.getOriginY(), spReticle.getWidth(), spReticle.getHeight(), spReticle.getScaleX(), spReticle.getScaleY(), spReticle.getRotation());
        batch.end();
    }

    public float findAngle(double dX1, double dY1, double dX2, double dY2) {
        float fAngle;
        fAngle = (float) Math.toDegrees(Math.atan2(dY1 - dY2, dX1 - dX2));
        return fAngle;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }
}