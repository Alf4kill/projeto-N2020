package br.com.N2020.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_BOT")
public class BotModel {

	private long idBot;
	private String nomeBot;
	private String msgInicial;
	private String msgFinal;
	private BigDecimal inativo;
	private String msgPadrao;
	private List<SegmentoModel> segmentoModel;
	
	public BotModel() {
		
	}

	public BotModel(long idBot, String nomeBot, String msgInicial, String msgFinal, BigDecimal inativo, String msgPadrao) {
		super();
		this.idBot = idBot;
		this.nomeBot = nomeBot;
		this.msgInicial = msgInicial;
		this.msgFinal = msgFinal;
		this.inativo = inativo;
		this.msgPadrao = msgPadrao;
		
	}
	
	@Id
	@Column(name = "ID_BOT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOT_SEQ")
	@SequenceGenerator(name = "BOT_SEQ", sequenceName = "BOT_SEQ", allocationSize = 1)
	public long getIdBot() {
		return idBot;
	}

	public void setIdBot(long idBot) {
		this.idBot = idBot;
	}

	@Column(name = "NOME_BOT")
	@NotNull(message = "Nome obrigatorio")
	@Size(min = 4, max = 30, message = "O nome do Bot deve ser entre 4 e 50 caracteres")
	public String getNomeBot() {
		return nomeBot;
	}

	public void setNomeBot(String nomeBot) {
		this.nomeBot = nomeBot;
	}
	
	@Column(name = "MSG_INICIAL")
	@NotNull(message = "Mensagem inicial obrigatorio")
	@Size(min = 10, max = 40, message = "A mensagem incial do Bot deve ter entre 10 e 50 caracteres")
	public String getMsgInicial() {
		return msgInicial;
	}

	public void setMsgInicial(String msgInicial) {
		this.msgInicial = msgInicial;
	}

	@Column(name = "MSG_FINAL")
	@NotNull(message = "Mensagem Final obrigatorio")
	@Size(min = 10, max = 40, message = "A mensagem final do Bot deve ter entre 10 e 50 caracteres")
	public String getMsgFinal() {
		return msgFinal;
	}

	public void setMsgFinal(String msgFinal) {
		this.msgFinal = msgFinal;
	}

	@Column(name = "INATIVO")
	@NotNull(message = "Tempo minimo obrigatorio")
	@DecimalMin(value = "5", message = "tempo minimo precisa ser acima de 5 segundos")
	public BigDecimal getInativo() {
		return inativo;
	}

	public void setInativo(BigDecimal inativo) {
		this.inativo = inativo;
	}
	
	@Column(name = "MSG_PADRAO")
	@NotNull(message = "Mensagem padrão obrigatorio")
	@Size(min = 10, max = 40, message = "A mensagem padrão do Bot deve ter entre 10 e 50 caracteres")
	public String getMsgPadrao() {
		return msgPadrao;
	}

	public void setMsgPadrao(String msgPadrao) {
		this.msgPadrao = msgPadrao;
	}

	@OneToMany(mappedBy = "bot")
	public List<SegmentoModel> getSegmentoModel() {
		return segmentoModel;
	}

	public void setSegmentoModel(List<SegmentoModel> segmentoModel) {
		this.segmentoModel = segmentoModel;
	}
	
	
	
	
	
}
