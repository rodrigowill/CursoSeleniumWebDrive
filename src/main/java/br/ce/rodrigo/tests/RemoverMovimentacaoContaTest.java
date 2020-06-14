package br.ce.rodrigo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rodrigo.core.BaseTest;
import br.ce.rodrigo.pages.ContasPage;
import br.ce.rodrigo.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest{
	
	MenuPage menu = new MenuPage();
	ContasPage contas = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menu.acessarTelaListar();
		contas.clicarExcluirConta("Conta com movimentacao");
		Assert.assertEquals("Conta em uso na movimentações", contas.obterMensagemErro());
	}

}
