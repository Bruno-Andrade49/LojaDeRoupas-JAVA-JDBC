package classesBean;

import java.sql.Date;

public class Venda {
	
	private int id_venda; //PK
	private double valor;
	private Vendedor vendedor; //FK para vendedor
	private Roupa roupa; //FK para roupa
	private Date dataCompra;
	private int qtd;
	
	public int getId_venda() {
		return id_venda;
	}
	
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public Roupa getRoupa() {
		return roupa;
	}
	
	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}
	
	public Date getDataCompra() {
		return dataCompra;
	}
	
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	@Override
	public String toString() {
		return "id_vendedor: " + vendedor + "id_roupa: " + roupa;
	}
	
}
