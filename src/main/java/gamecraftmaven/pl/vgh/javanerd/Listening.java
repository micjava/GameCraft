package gamecraftmaven.pl.vgh.javanerd;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Listening implements KeyListener, MouseListener, MouseMotionListener {

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:

			Component.isMoving = true;

			Component.dir = Component.character.movementSpeed;

			break;

		case KeyEvent.VK_A:

			Component.isMoving = true;

			Component.dir = -Component.character.movementSpeed;

			break;

		case KeyEvent.VK_W:

			Component.isJumping = true;
			
			break;
		//
		// case KeyEvent.VK_S:
		//
		// break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:

			if (Component.dir == Component.character.movementSpeed) {

				Component.isMoving = false;

			}
			break;

		case KeyEvent.VK_A:

			if (Component.dir == -Component.character.movementSpeed) {

				Component.isMoving = false;

			}
			break;

		case KeyEvent.VK_W:

			Component.isJumping = false;
			
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

    public void mouseClicked(MouseEvent e) {
          
    }

    public void mousePressed(MouseEvent e) {
          
    }

    public void mouseReleased(MouseEvent e) {
          
    }

    public void mouseEntered(MouseEvent e) {
          
    }

    public void mouseExited(MouseEvent e) {
          
    }

    public void mouseDragged(MouseEvent e) {
          
    }

    public void mouseMoved(MouseEvent e) {
          
    }

}
