package Controller;

import Model.model;
import View.view;

public class tetrisGame {
	public static void main(String[] args) {
		model Model = new model(20, 10);
		view View = new view(Model);
		controlGame ControlGame = new controlGame(Model, View);
	}
}