package br.ce.rodrigo.pages;

import org.openqa.selenium.By;

import br.ce.rodrigo.core.BasePage;

public class ResumoPage extends BasePage {
	
	public void excluirMovimentacao() {
		super.clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso() {
		return super.obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void selecionarAno(String ano) {
		super.selecionarCombo("ano", ano);
	}
	
	public void buscar() {
		super.clicarBotao(By.xpath("//input[@value='Buscar']"));
	}

}
