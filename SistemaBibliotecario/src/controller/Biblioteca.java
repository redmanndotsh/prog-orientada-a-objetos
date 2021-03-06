package controller;

import java.util.ArrayList;

import model.*;

public class Biblioteca {
	private String nomeFantasia;
	private String endereco;
	private ArrayList<Livro> livros;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Reserva> reserva;
	
	public Biblioteca() {
		usuarios = new ArrayList<Usuario>();
		livros = new ArrayList<Livro>();
		reserva = new ArrayList<Reserva>();
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	
	public int getQuantidadeDeUsuarios() {
		return usuarios.size();
	}
	
	public int getQuantidadeDeLivros() {
		return livros.size();
	}
	
	public String listarUsuarios() {
		String retorno = "";
		for (Usuario usuario : usuarios) {
			retorno += String.format(" • Matrícula: %s\n", usuario.getMatricula());
			retorno += String.format("     • Nome: %s\n", usuario.getNome());
			retorno += String.format("     • Telefone: %s\n", usuario.getTelefone());
			retorno += String.format("     • E-mail: %s\n", usuario.getEmail());
			retorno += String.format("     • Curso: %s\n", usuario.getCurso());
		}
		return retorno;
	}

	public String listarLivros() {
		String retorno = "";
		for (Livro livro : livros) {
			String emprestado;
			if (livro.getEmprestado()) {
				emprestado = "sim";
			} else {
				emprestado = "não";
			}
			retorno += String.format(" • Código: %d\n", livro.getCodigo());
			retorno += String.format("     • Título: %s\n", livro.getTitulo());
			retorno += String.format("     • Autor: %s\n", livro.getAutor());
			retorno += String.format("     • Emprestado: %s\n", emprestado);
		}
		return retorno;
	}
	
	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}
	
	public void emprestar() {
		if (getQuantidadeDeUsuarios() == 0 || getQuantidadeDeLivros() == 0) {
			System.out.println("Para o empréstimo é preciso, ao menos, um usuário e um livro. Tente cadastrá-los primeiro.");
		} else {
			System.out.println("Há usuários e livros aqui.");
		}
	}
	
	@Override
	public String toString() {
		return String.format(" • Nome fantasia: %s\n • Endereço: %s\n • Quantidade de usuários: %d\n • Quantidade de livros: %d", getNomeFantasia(), getEndereco(), getQuantidadeDeUsuarios(), getQuantidadeDeLivros());
	}
}
