package com.souvector.play;

import javax.swing.JOptionPane;

import com.souvector.game.nodes.NodeTree;
import com.souvector.impl.GameImpl;



public class GamePlay {

	public static int index = 1;
	
	public static void main(String[] args) {
		
		
		GameImpl root = new GameImpl();
		
		JOptionPane.showMessageDialog(null, "Think of an Animal");
		
		// Check if the tree is empty
				if (root.getTree() == null) {
					root.setTree(new NodeTree(index, "live in the water?"));
					root.getTree().nodeLeft = new NodeTree(++index, "Monkey");
					root.getTree().nodeRight = new NodeTree(++index, "Shark");
				}
				int quit = 1;
				
				do {
					// First quest
					int answer = JOptionPane.showConfirmDialog(null, "The animal you thought of " + root.getTree().value,
							"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					//If answer is Yes enter the right node, otherwise enter the left
					if (answer == 0) {
						root.ask(root.getTree().nodeRight);
					} else {
						root.ask(root.getTree().nodeLeft);
					}
					// Close the game
					if (answer == JOptionPane.CLOSED_OPTION) {
						quit = 0;
					}

				} while (quit == 1);

	}

}
