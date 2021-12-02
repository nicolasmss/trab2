package com.bcopstein.Interface.DTO;

public class ItemCarrinhoDTO {
  private int codigo;
  private int quantidade;

  public ItemCarrinhoDTO(int codigo, int quantidade) {
    this.codigo = codigo;
    this.quantidade = quantidade;
  }

  public ItemCarrinhoDTO() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  @Override
  public String toString() {
    return "ItemCarrinho [codigo=" + codigo + ", qtd=" + quantidade + "]";
  }
}
