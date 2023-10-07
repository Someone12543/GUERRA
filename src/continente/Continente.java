package continente;
import pais.Pais;
import java.util.List;

public class Continente {
	private String nome;
	private List<Pais> paises;
	
	public Continente(String nome, List<Pais> paises) {
		this.nome = nome;
		this.paises = paises;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPaises(List<Pais> paises){
		this.paises = paises;
	}
	
	public List<Pais> getPaises(){
		return paises;
	}
}
