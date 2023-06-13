package Lig4;

public class Tabuleiro {
	
	private String[][] grid;
	
	public Tabuleiro(){
		grid = new String[6][7];
	}
	
	//cria um tabuleiro vazio
	public void newGrid() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				grid[i][j] = " - ";
			}
		}
	}
	
	//imprime o tabuleiro na tela
	public void displayGrid() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public String[][] getGrid() {
		return grid;
	}
}
