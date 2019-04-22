package br.com.lucastadeu.AEP;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Tarefa{
  
  @Id
  	private Long id;
	private String descricao;
	private String dataCriacao;
	private String situacao;
	private String responsavel;
	private int horasEstimadas;
	
	public enum Status{
		NAO_INICIADA,
		EM_PROGRESSO,
		TERMINADA,
		BLOQUEADA
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public float getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

}
