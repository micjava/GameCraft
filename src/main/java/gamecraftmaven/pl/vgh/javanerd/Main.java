package gamecraftmaven.pl.vgh.javanerd;

import javax.swing.JFrame;

//token jd5h4y

public class Main {
 
	public static void main(String[] args) {
		Component component = new Component();
		
		JFrame frame = new JFrame();
		frame.add(component);
		frame.pack();
		frame.setTitle(Component.name);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		component.start();

	}

}