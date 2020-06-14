package br.ce.rodrigo.pages;

import br.ce.rodrigo.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		super.clicarLink("Contas");
		super.clicarLink("Adicionar");
	}
	
	public void acessarTelaListar() {
		super.clicarLink("Contas");
		super.clicarLink("Listar");
	}
	
	public void acessarTelaInserirMovimentacao() {
		super.clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo() {
		super.clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaHome() {
		super.clicarLink("Home");
	}

}
