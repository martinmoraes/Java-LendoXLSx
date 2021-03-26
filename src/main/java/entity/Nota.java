package entity;

public class Nota {
	private String nome;
	private String RA;
	private double nota01;
	private double nota02;
	private double media;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String none) {
		this.nome = none;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public double getNota01() {
		return nota01;
	}
	public void setNota01(double d) {
		this.nota01 = d;
	}
	public double getNota02() {
		return nota02;
	}
	public void setNota02(double nota02) {
		this.nota02 = nota02;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	
	
	@Override
	public String toString() {
		return "Nota [nome=" + nome + ", RA=" + RA + ", nota01=" + nota01 + ", nota02=" + nota02 + ", media=" + media
				+ "]";
	}
	
	
	

	
	
}
