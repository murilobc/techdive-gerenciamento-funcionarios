package br.senai.bean;

import br.senai.util.Util;

public class Colaborador {
    public int codigo;
    public String nome;
    public String setor;
    public double salario;
    public boolean ativo;

    public Colaborador(int codigo, String nome, String setor, double salario, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.setor = setor;
        this.salario = salario;
        this.ativo = ativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Codigo: ").append(getCodigo()).append(" - Colaborador - Nome: ").append(getNome())
                .append("\nSetor: ").append(getSetor()).append(" - Salário: R$").append(Util.formatarReais(getSalario())).append(" - Ativo: ").append(isAtivo() ? "Sim":"Não");
        return retorno.toString();
    }
}
