package br.ce.rodrigo.pages;

import org.openqa.selenium.By;

import br.ce.rodrigo.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		super.escrever("nome", nome);
	}
	
	public void salvar() {
		super.clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return super.obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro() {
		return super.obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarAlterarConta(String string) {
		super.obterCelula("Conta", string, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clicarExcluirConta(String string) {
		super.obterCelula("Conta", string, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}

}
