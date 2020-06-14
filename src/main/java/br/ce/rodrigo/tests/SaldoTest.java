package br.ce.rodrigo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rodrigo.core.BaseTest;
import br.ce.rodrigo.pages.HomePage;
import br.ce.rodrigo.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	HomePage home = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menu.acessarTelaHome();
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
	}

}
