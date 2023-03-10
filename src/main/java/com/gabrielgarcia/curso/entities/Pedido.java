package com.gabrielgarcia.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabrielgarcia.curso.entities.enums.PedidoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // Formata o instant no banco																						// de dados
	private Instant momento;

	private Integer pedidoStatus;

	@ManyToOne // Muitos pedidos para um cliente
	@JoinColumn(name = "ClienteId")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemDePedido> items = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL) //  1 para 1 mapeando para ter o mesmo ID
	private Pagamento pagamento;
	
	public Pedido() {
	}

	public Pedido(Long id, Instant momento, PedidoStatus pedidoStatus, Usuario cliente) {
		this.id = id;
		this.momento = momento;
		setPedidoStatus(pedidoStatus); // Recebendo em PedidoStatus e passando para int
		this.cliente = cliente;
	}
	
	public Double getTotal() {
		
		double total = 0.0;
		for(ItemDePedido x : items) {
			 total = total +  x.getSubTotal(); 
		}
		return total;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.ValorDe(pedidoStatus); // Pegando o n??mero inteiro e passando para PedidoStatus
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
		this.pedidoStatus = pedidoStatus.getCodigo(); // Passando para int
		} 
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemDePedido> getItems(){
		return items;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", momento=" + momento + ", cliente=" + cliente + "]";
	}

}
