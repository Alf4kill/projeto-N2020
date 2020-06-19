package br.com.N2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_SEGMENTO")
public class SegmentoModel {
	
	private long idSegmento;
	private String nomeSegmento;
	private BotModel bot;
	
	public SegmentoModel() {
		
	}

	public SegmentoModel(long idSegmento, String nomeSegmento, BotModel bot) {
		super();
		this.idSegmento = idSegmento;
		this.nomeSegmento = nomeSegmento;
		this.bot = bot;
	}

	@Id
	@Column(name= "ID_SEGMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEGMENTO_SEQ")
	@SequenceGenerator(name= "SEGMENTO_SEQ", sequenceName = "SEGMENTO_SEQ", allocationSize = 1)
	public long getIdSegmento() {
		return idSegmento;
	}

	public void setIdSegmento(long idSegmento) {
		this.idSegmento = idSegmento;
	}

	@Column(name= "NOME_SEGMENTO")
	@NotNull(message = "nome de Segmento obrigatorio")
	@Size(min = 2, max = 50, message = "Nome deve ser entre 2 e 50 caracteres")
	public String getNomeSegmento() {
		return nomeSegmento;
	}

	public void setNomeSegmento(String nomeSegmento) {
		this.nomeSegmento = nomeSegmento;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_BOT", nullable = false)
	public BotModel getBot() {
		return bot;
	}

	public void setBotModel(BotModel bot) {
		this.bot = bot;
	}
	
	
	
	
}
