package Lig4;

public class Peca {

	private String tipoDaPeca;
	
	//determina o tipo da peça de acordo com o jogador
	public void setTipoDaPeca(int turno) {
		if(turno == 1) {
			tipoDaPeca = " X ";
		} else {
			tipoDaPeca = " O ";
		}
	}
	
	public String getTipoDaPeca() {
		return tipoDaPeca;
	}
}
