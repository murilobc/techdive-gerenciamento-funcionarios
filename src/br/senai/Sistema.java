package br.senai;

import br.senai.bean.Colaborador;
import br.senai.bean.GerenteDepartamento;
import br.senai.bean.GerenteGeral;
import br.senai.bean.LiderTecnico;
import br.senai.util.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    Scanner input = new Scanner(System.in);
    List<Colaborador> colaboradores = new ArrayList<Colaborador>();
    Servico servico = new Servico();

    public void iniciar() {

        StringBuilder retorno = new StringBuilder();
        retorno.append("Escolha uma opcão:\n")
                .append("1 - Adicionar um colaborador\n")
                .append("2 - Ver detalhes de um colaborador\n")
                .append("3 - Demitir um colaborador\n")
                .append("4 - Atualizar informações de um colaborador\n")
                .append("5 - Listar todos os colaboradores\n")
                .append("6 - Listar colaboradores ativos\n")
                .append("7 - Listar colaboradores desligados\n")
                .append("0 - Sair\n");

        System.out.println(retorno);
        String opcao = input.nextLine();
        if (opcao.isBlank()) {
            System.out.println("Opção inválida");
        } else {
            switch (opcao) {
                case "1":
                    menuAdicionar();
                    break;
                case "2":
                    menuDetalhes();
                    break;
                case "3":
                    menuDemitir();
                    break;
                case "4":
                    menuAtualizar();
                    break;
                case "5":
                    menuListarTodos();
                    break;
                case "6":
                    menuListarAtivos();
                    break;
                case "7":
                    menuListarDesligados();
                    break;
                case "0":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    iniciar();
            }
        }

    }

    private void menuListarDesligados() {
        servico.listarInativos(colaboradores);
    }

    private void menuListarAtivos() {
        servico.listarAtivos(colaboradores);
    }

    private void menuListarTodos() {
        servico.listarTodos(colaboradores);
    }

    private void menuAtualizar() {
        System.out.println("Informe o código do colaborador");
        String codigo = input.nextLine();

        Colaborador c = servico.buscar(Integer.valueOf(codigo), colaboradores);

        System.out.println("Nome do colaborador");
        String nome = input.nextLine();
        String setor = "Geral";
        if (!(c instanceof GerenteGeral)) {
            System.out.println("Informe o setor de trabalho");
            setor = input.nextLine();
        }
        System.out.println("Informe o salário do colaborador");
        String salario = input.nextLine();

        c.setNome(nome);
        c.setSetor(setor);
        c.setSalario(Double.valueOf(salario));

        servico.salvar(c, colaboradores);


    }

    private void menuDemitir() {
        System.out.println("Informe seu codigo");
        String codigoOperador = input.nextLine();
        System.out.println("Informe o código do colaborador a ser demitido");
        String codigoColadorador = input.nextLine();

        Colaborador operador = servico.buscar(Integer.valueOf(codigoOperador), colaboradores);
        Colaborador colaborador = servico.buscar(Integer.valueOf(codigoColadorador), colaboradores);

        servico.demitir(operador, colaborador);
    }

    private void menuDetalhes() {
        System.out.println("Informe o código do colaborador");
        String codigo = input.nextLine();
        Colaborador c = servico.buscar(Integer.valueOf(codigo), colaboradores);
        if (c == null) {
            System.out.println("Colaborador inexistente");
        } else {
            System.out.println(c.toString());
        }
    }

    private void menuAdicionar() {
        System.out.println("1 - Colaborador\n2 - Lider Técnico\n3 - Gerente de Departamento\n4 - Gerente Geral");
        String opcao = input.nextLine();


        if (!opcao.isBlank()) {
            System.out.println("Nome do colaborador");
            String nome = input.nextLine();
            String setor = "Geral";
            if (!"4".equalsIgnoreCase(opcao)) {
                System.out.println("Informe o setor de trabalho");
                setor = input.nextLine();
            }
            System.out.println("Informe o salário do colaborador");
            String salario = input.nextLine();
            int codigo = servico.gerarCodigo(colaboradores);
            Colaborador c = null;

            if ("1".equalsIgnoreCase(opcao)) {
                c = new Colaborador(codigo, nome, setor, Double.valueOf(salario), true);
            } else if ("2".equalsIgnoreCase(opcao)) {
                System.out.println("Informe a especilização");
                String especializacao = input.nextLine();
                c = new LiderTecnico(codigo, nome, setor, Double.valueOf(salario), true, especializacao);
            } else if ("3".equalsIgnoreCase(opcao)) {
                System.out.println("Informe o departamente a ser chefiado");
                String departamento = input.nextLine();
                c = new GerenteDepartamento(codigo, nome, setor, Double.valueOf(salario), true, departamento);
            } else if ("4".equalsIgnoreCase(opcao)) {
                c = new GerenteGeral(codigo, nome, setor, Double.valueOf(salario), true, setor);
            }

            servico.salvar(c, colaboradores);

            System.out.println("Colaborador criado!");
            System.out.println(c.toString());
        } else {
            System.out.println("Opção inválida");
        }

    }

}
