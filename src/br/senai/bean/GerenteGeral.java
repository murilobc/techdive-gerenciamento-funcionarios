package br.senai.bean;

import br.senai.util.Util;

public class GerenteGeral extends GerenteDepartamento {
    private double comissao = 0.225;

    public GerenteGeral(int codigo, String nome, String setor, double salario, boolean ativo, String departamento) {
        super(codigo, nome, setor, salario, ativo, departamento);
        this.comissao = comissao;
    }

    public void demitir(Colaborador colaborador) {
        colaborador.setAtivo(false);
    }

    public double calcularSalario() {
        return getSalario() * (1 + this.comissao);
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Codigo: ").append(getCodigo()).append("- Gerente de Departamento - Nome: ").append(getNome())
                .append("\nSetor: ").append(getSetor()).append(" - Salário: R$").append(Util.formatarReais(getSalario())).append(" - Ativo: ").append(isAtivo() ? "Sim":"Não")
                .append("\nDepartamento Responsavel: ").append(getDepartamento()).append(" Comissão: ").append((this.comissao * 100)).append("%");
        return retorno.toString();
    }

}
