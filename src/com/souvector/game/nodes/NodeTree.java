package com.souvector.game.nodes;

public class NodeTree {

	public int element;
	public NodeTree nodeLeft;
	public NodeTree nodeRight;
	public String value;

	// Constructor that set the values of tree
	public NodeTree(int elemento, String valor) {
		System.out.println(elemento + " - " + valor);
		this.element = elemento;
		this.value = valor;
	}

	public NodeTree() {

	}
	
	
}
