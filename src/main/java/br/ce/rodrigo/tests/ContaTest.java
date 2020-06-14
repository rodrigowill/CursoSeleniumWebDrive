package br.ce.rodrigo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rodrigo.core.BaseTest;
import br.ce.rodrigo.pages.ContasPage;
import br.ce.rodrigo.pages.MenuPage;


public class ContaTest extends BaseTest {
	
	MenuPage menu = new MenuPage();
	ContasPage contas = new ContasPage();
	
	@Test
	public void test1InserirConta() {
		menu.acessarTelaInserirConta();
		contas.setNome("Conta do teste");
		contas.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contas.obterMensagemSucesso());
	}
	
	@Test
	public void test2alterarConta() {
		menu.acessarTelaListar();
		contas.clicarAlterarConta("Conta para alterar");
		contas.setNome("Conta alterada");
		contas.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contas.obterMensagemSucesso());
	}
	
	@Test
	public void test3InserirContaMesmoNome() {
		menu.acessarTelaInserirConta();
		contas.setNome("Conta mesmo nome");
		contas.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contas.obterMensagemErro());
	}
	
}
