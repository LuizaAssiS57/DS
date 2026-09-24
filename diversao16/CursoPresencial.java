package diversao16;

public class CursoPresencial extends Curso{
    
    private String sala;
    private String turno;
    
	public CursoPresencial(int codigo, String nome, int cargaHoraria, double valor, String sala, String turno) {
		super(codigo, nome, cargaHoraria, valor);
		this.sala = sala;
		this.turno = turno;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public double realizarMatricula() {
        return getValor();
	}
    
	@Override
	public double realizarMatricula(double descontoPercetual) {
        double valorDesconto = getValor() * (descontoPercetual / 100.0);
        return getValor() - valorDesconto;
	}
    
    @Override
    public String exibirDados() {
        return super.exibirDados() + "\nTipo: Presencial\nSala: " + sala + "\nTurno: " + turno + "\n";
    }
    
}
