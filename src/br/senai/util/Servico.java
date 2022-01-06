package br.senai.util;

import br.senai.bean.Colaborador;
import br.senai.bean.GerenteDepartamento;
import br.senai.bean.GerenteGeral;

import java.util.List;

public class Servico {

    public int gerarCodigo(List<Colaborador> colaboradores) {
        if (colaboradores.isEmpty()) {
            return 10000;
        } else {
            return colaboradores.get(colaboradores.size() - 1).getCodigo() + 1;
        }
    }

    public void salvar(Colaborador c, List<Colaborador> colaboradores) {
        if (c.getCodigo() > 0) {
            colaboradores.add(c);
        } else {
            for (int i = 0; i < colaboradores.size(); i++) {
                if (colaboradores.get(i).getCodigo() == c.getCodigo()) {
                    colaboradores.get(i).setNome(c.getNome());
                    colaboradores.get(i).setSetor(c.getSetor());
                    colaboradores.get(i).setSalario(c.getSalario());
                }
            }
        }
    }

    public Colaborador buscar(int codigo, List<Colaborador> colaboradores) {
        for (int i = 0; i < colaboradores.size(); i++) {
            if (codigo == colaboradores.get(i).getCodigo()) {
                return colaboradores.get(i);
            }
        }
        return null;
    }

    public void demitir(Colaborador operador, Colaborador colaborador) {
        if (operador instanceof GerenteGeral) {
            ((GerenteGeral) operador).demitir(colaborador);
        } else if (operador instanceof GerenteDepartamento &&
            ((GerenteDepartamento) operador).getDepartamento() == colaborador.getSetor()) {
            ((GerenteDepartamento) operador).demitir(colaborador);
        } else {
            System.out.println("Você não pode demitir este colaborador");
        }
    }

    public void listarTodos(List<Colaborador> colaboradores) {
        for (int i = 0; i < colaboradores.size(); i++) {
            colaboradores.get(i).toString();
        }
    }

    public void listarAtivos(List<Colaborador> colaboradores) {
        for (int i = 0; i < colaboradores.size(); i++) {
            if (colaboradores.get(i).isAtivo()) {
                colaboradores.get(i).toString();
            }
        }
    }

    public void listarInativos(List<Colaborador> colaboradores) {
        for (int i = 0; i < colaboradores.size(); i++) {
            if (!colaboradores.get(i).isAtivo()) {
                colaboradores.get(i).toString();
            }
        }
    }
}
