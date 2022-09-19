package objects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import core.GameScreen;

import static helper.Constants.PPM;

public class Player extends GameEntity{

    private int jumpCounter;
    private TextureRegion playerStand;

    public Player(float width, float height, Body body, GameScreen gameScreen) {
        super(width, height, body);
        playerStand = gameScreen.getTextureAtlas().findRegion("Idle");
        this.speed = 15f;
        this.jumpCounter = 0;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;

        checkUserInput();
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    private void checkUserInput(){
        velX = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.D))
            velX = 1;
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            velX = -1;

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jumpCounter < 2){
            float force = body.getMass() * 20;
            body.setLinearVelocity(body.getLinearVelocity().x, 0);
            body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
            jumpCounter++;
        }

        //reset jumpcounter
        if(body.getLinearVelocity().y == 0){
            jumpCounter = 0;
        }

        body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
    }
}
