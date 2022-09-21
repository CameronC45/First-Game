package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import objects.player.GameEntity;

import static helper.Constants.PPM;

public class CameraView extends GameEntity {


    public CameraView(float width, float height, Body body) {
        super(width, height, body);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
