
package br.com.decola.entidade;

import java.math.BigDecimal;
import java.util.Date;

public class Viagem {
    private int id;
    private String destino;
    private Date dataPartida;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	private Date dataRetorno;
	public void setPreco(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
	public void setDescricao(String string) {
		// TODO Auto-generated method stub
		
	}
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal getPreco() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters e Setters
}
