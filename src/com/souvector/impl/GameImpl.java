package com.souvector.impl;

import javax.swing.JOptionPane;

import com.souvector.game.interfaces.AnimalInterface;
import com.souvector.game.nodes.NodeTree;

public class GameImpl implements AnimalInterface<NodeTree> {
	
	public static int index = 1;
	public static NodeTree root;

	@Override
	public void addAnimal(NodeTree nodeTree) {
		
		String animal = JOptionPane.showInputDialog(null, "What animal did you think of?");

		String characteristics = JOptionPane
				.showInputDialog("An " + animal + "______ but an " + nodeTree.value + " not.");

		String aux = nodeTree.value;
		nodeTree.value = characteristics;
		nodeTree.nodeRight = new NodeTree(++index, animal);
		nodeTree.nodeLeft = new NodeTree(++index, aux);
		
	}

	@Override
	public void ask(NodeTree nodeTree) {
		
		// Ask if is the correct animal
				int question = JOptionPane.showConfirmDialog(null, "The animal you thought of " + nodeTree.value, "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (question == 0) {
					// If is the correct answer
					
					if (nodeTree.nodeRight == null)
						JOptionPane.showMessageDialog(null, "I won!");
					// Question again to check if is the correct animal thought of
					
					else {
					
						ask(nodeTree.nodeRight);
					}
					
					//If answer is not, add a new animal. If the nodeLeft is empty or goes to the next question
				} else {
					if (nodeTree.nodeLeft == null)
						addAnimal(nodeTree);
					else {
						ask(nodeTree.nodeLeft);
					}
				}
		
	}

	@Override
	public NodeTree getTree() {
		
		return root;
	}

	@Override
	public void setTree(NodeTree tree) {
		
		root = tree;
		
	}




	

}
