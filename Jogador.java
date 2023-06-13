package Lig4;

public class Jogador {
	
	private int turno;
	
	public Jogador() {
		setTurno(1);
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	//troca o turno de cada jogador
	public void trocarTurno() {
		if(getTurno() == 1) {
			setTurno(2);
		} else {
			setTurno(1);
		}
	}
}
