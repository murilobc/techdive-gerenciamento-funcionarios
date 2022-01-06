package br.senai.bean;

import br.senai.util.Util;

public class LiderTecnico extends Colaborador {
    private String especializacao;
    private double bonificacao = 455D;

    public LiderTecnico(int codigo, String nome, String setor, double salario, boolean ativo, String especializacao) {
        super(codigo, nome, setor, salario, ativo);
        this.especializacao = especializacao;
    }

    public double calcularSalario() {
        return getSalario() + this.bonificacao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Codigo: ").append(getCodigo()).append(" - Lider Técnico - Nome: ").append(getNome())
                .append("\nSetor: ").append(getSetor()).append(" - Salário: R$").append(Util.formatarReais(getSalario())).append(" - Ativo: ").append(isAtivo() ? "Sim":"Não")
                .append("\nEspecialização: ").append(getEspecializacao());
        return retorno.toString();
    }
}
