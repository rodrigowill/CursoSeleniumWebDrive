package br.ce.rodrigo.pages;

import static br.ce.rodrigo.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.rodrigo.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentacao(String data) {
		super.escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		super.escrever("data_pagamento", data);
	}

	public void setDescricao(String descricao) {
		super.escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		super.escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		super.escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		super.selecionarCombo("conta", conta);
	}
	
	public void setStatusPago() {
		super.clicarRadio("status_pago");
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
	
	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for (WebElement erro : erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
	
}
