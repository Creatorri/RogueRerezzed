/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import dungeon.Level;
import render.Sprite;

/**
 *
 * @author Torri
 */
public class Stairway extends RogueEntity{
    public Stairway(Level l1) {
        super(l1);
        this.spawn(l1.getRoom(rand.nextInt(l1.numRooms)));
        this.sp = new Sprite("Stairway");
    }
    @Override
    public void turn(){}
    @Override
    public void death(){}
}
