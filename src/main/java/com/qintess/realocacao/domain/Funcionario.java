package com.qintess.realocacao.domain;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome.")
	@Size(min = 3, max = 60, message = "O nome do funcionário deve ter entre {1} e {100} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	
	private String estado;
	
	private String colaboradorCiente;
	
	private String resource;
	
	private Long re;
	
	private String codigo;
	
	private String perfil;
	
	private int baseDeHoras;
	
	private int custoHora;
	
	private String observacao;
	
	private String cliente;
	
	private String gestor;
	
	private String disponibilidade;
	
	private String parecerTecnico;
	
	private String parecerComportamental;
	
	private String voluntario;
	
	private String motivo;
	
	private String status;
	
	private String assistendeDeRealocacao;
	
	private String contato;
	
	private String cv;
	
	private String bh;
	
	private String feriasProgramadas;
	
	private String custoMes;
	
	
	
//	@NotNull(message = "Selecione o objetivo relativo ao funcionario.")
//	@ManyToOne
//	@JoinColumn(name = "id_objetivo_fk")
//	private Objetivo objetivo;
//	
//
//	
	
	private String objetivo;

	
	public String getCustoMes() {
		return custoMes;
	}

	public void setCustoMes(String custoMes) {
		this.custoMes = custoMes;
	}

	@JoinColumn
	private Integer idade;
	
	@JoinColumn
	private String experiencia;
	
	private String cursos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	
	public String getColaboradorCiente() {
		return colaboradorCiente;
	}

	public void setColaboradorCiente(String colaboradorCiente) {
		this.colaboradorCiente = colaboradorCiente;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public Long getRe() {
		return re;
	}

	public void setRe(Long re) {
		this.re = re;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public int getBaseDeHoras() {
		return baseDeHoras;
	}

	public void setBaseDeHoras(int baseDeHoras) {
		this.baseDeHoras = baseDeHoras;
	}

	public int getCustoHora() {
		return custoHora;
	}

	public void setCustoHora(int custoHora) {
		this.custoHora = custoHora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getParecerTecnico() {
		return parecerTecnico;
	}

	public void setParecerTecnico(String parecerTecnico) {
		this.parecerTecnico = parecerTecnico;
	}

	public String getParecerComportamental() {
		return parecerComportamental;
	}

	public void setParecerComportamental(String parecerComportamental) {
		this.parecerComportamental = parecerComportamental;
	}

	public String getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssistendeDeRealocacao() {
		return assistendeDeRealocacao;
	}

	public void setAssistendeDeRealocacao(String assistendeDeRealocacao) {
		this.assistendeDeRealocacao = assistendeDeRealocacao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getFeriasProgramadas() {
		return feriasProgramadas;
	}

	public void setFeriasProgramadas(String feriasProgramadas) {
		this.feriasProgramadas = feriasProgramadas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	
//
//	public Objetivo getObjetivo() {
//		return objetivo;
//	}
//
//	public void setObjetivo(Objetivo objetivo) {
//		this.objetivo = objetivo;
//	}

}