package com.d954mas.game.shaderdemo.utils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Artem on 01.10.2015.
 */
public class UIUtils {
    //TODO compare values
    public static Array<TextureAtlas.AtlasRegion> getRegionsByPrefix(String prefix, TextureAtlas atlas) {
        Array<TextureAtlas.AtlasRegion> toRet = new Array<>();
        for (TextureAtlas.AtlasRegion atlasRegion : atlas.getRegions()) {
            if (atlasRegion.name.startsWith(prefix)) {
                toRet.add(atlasRegion);
            }
        }
       // toRet.sort((o1, o2) -> -Objects.compare(o1.name, o2.name));
        return toRet;
    }


    /**
     * Resizes component proportionally by its new width
     */
    public static Actor setSizeByWidth(Actor actor, float newWidth) {
        float scaleHeight=actor.getHeight()/actor.getWidth();
        actor.setSize(newWidth,newWidth*scaleHeight);
        return actor;
    }

    /**
     * Resizes component proportionally by its new height
     */
    public static Actor setSizeByHeight(Actor actor, float newHeight) {
        float scaleWidth= actor.getWidth() /  actor.getHeight();
        actor.setSize(newHeight * scaleWidth, newHeight);
        return actor;
    }

    /**
     * Resizes cell proportionally by its new height according to actor inside
     */
    public static Cell setSizeByWidth(Cell cell, float newWidth) {
        Actor actor=setSizeByWidth(cell.getActor(), newWidth);
        cell.width(actor.getWidth()).height(actor.getHeight());
        return cell;
    }

    /**
     * Resizes cell proportionally by its new height according to actor inside
     */
    public static Cell setSizeByHeight(Cell cell, float newHeight) {
        Actor actor=setSizeByHeight(cell.getActor(), newHeight);
        cell.width(actor.getWidth()).height(actor.getHeight());
        return cell;
    }

    public static Actor setToCenter(Actor actor,float width,float height){
        actor.setX(width/2f-actor.getWidth()/2f);
        actor.setY(height / 2f - actor.getHeight() / 2f);
        return actor;
    }
    public static Actor setToCenter(Actor actor,Group group){
        actor.setX(group.getWidth()/2f-actor.getWidth()/2f);
        actor.setY(group.getHeight() / 2f - actor.getHeight() / 2f);
        return actor;
    }



}
