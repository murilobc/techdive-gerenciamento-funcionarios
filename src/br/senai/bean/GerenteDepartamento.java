package br.senai.bean;

import br.senai.util.Util;

public class GerenteDepartamento extends Colaborador {
    private String departamento;
    private double comissao = 0.125;

    public GerenteDepartamento(int codigo, String nome, String setor, double salario, boolean ativo, String departamento) {
        super(codigo, nome, setor, salario, ativo);
        this.departamento = departamento;
    }

    public void demitir(Colaborador colaborador) {
        if (colaborador.getSetor().equalsIgnoreCase(getDepartamento())) {
            colaborador.setAtivo(false);
        } else {
            System.out.println("Você não tem permissão para desligar este colaborador");
        }
    }

    public double calcularSalario() {
        return getSalario() * (1 + this.comissao);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
