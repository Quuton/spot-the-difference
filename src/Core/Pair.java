/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
package Core;
public class Pair {
    int XPos;
    int YPos;
    int XEnd;
    int YEnd;
    boolean found = false;

    public int getXPos() {
        return this.XPos;
    }

    public void setXPos(int XPos) {
        this.XPos = XPos;
    }

    public int getYPos() {
        return this.YPos;
    }

    public void setYPos(int YPos) {
        this.YPos = YPos;
    }

    public int getXEnd() {
        return this.XEnd;
    }

    public void setXEnd(int XEnd) {
        this.XEnd = XEnd;
    }

    public int getYEnd() {
        return this.YEnd;
    }

    public void setYEnd(int YEnd) {
        this.YEnd = YEnd;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean b) {
        found = b;
    }
    public Pair(int xpos, int ypos, int boundSize) {
        this.XPos = xpos;
        this.YPos = ypos;
        this.XEnd = xpos + boundSize;
        this.YEnd = ypos + boundSize;
    }
    
}
