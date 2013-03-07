package Pacman;

import java.awt.geom.Point2D;

public class SimpleMazeBoard extends Board{

	SimpleMazeBoard(){
		super();
		super.boarddata = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWDDDDDDDDDDDDDDDDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDWWDDDDWWDDDDWWDWWWWWWWWWWWWDWWWWWDWWDWWWWWDWWWWWWWWWWWWDWWWWWDWWDWWWWWDWWWWWWWWWWWWDWWDDDD DDDDDWWDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDDDDWWWWWWWWDDDDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDWWDDDDDDDDDDWWDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDWWDWWWWWWWWDWWDWWWWWWWWWWWWDDDDDDDWWDDDDDDDWWWWWWWWWWWWDWWWWWDWWDWWWWWDWWWWWWWWWWWWDWWWWWDWWDWWWWWDWWWWWWWWWWWWDDDDDDD DDDDDDDDWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW";
		for(int g = Ghost.GHOST_BLINKY; g <= Ghost.GHOST_CLYDE; g++) {
			ghosts[g].setPosition(new Point2D.Double(-1,-1));
		}
		ghosts[Ghost.GHOST_BLINKY].setPosition(new Point2D.Double(13,11));
		super.initGrids();
	}
	
	
}