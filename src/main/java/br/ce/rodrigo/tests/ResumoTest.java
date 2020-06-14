package br.ce.rodrigo.tests;

import static br.ce.rodrigo.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.rodrigo.core.BaseTest;
import br.ce.rodrigo.core.DriverFactory;
import br.ce.rodrigo.pages.MenuPage;
import br.ce.rodrigo.pages.ResumoPage;

public class ResumoTest extends BaseTest{

	private MenuPage menu = new MenuPage();
	private ResumoPage resumo = new ResumoPage();

	@Test
	public void test1ExcluirMovimentacao() {
		menu.acessarTelaResumo();
		resumo.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumo.obterMensagemSucesso());
	}

//	@Test(expected=NoSuchElementException.class) // n�o � muito indicado pq pode gerar falso positivo caso em outra linha dessa o mesmo erro
	@Test
	public void test2ResumoMensal() {
		menu.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		/* Abaixo tbm n�o � t�o indicada
		try {
			DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
			Assert.fail();
		} catch(NoSuchElementException e) {}  */
		
		resumo.selecionarAno("2016");
		resumo.buscar();
		
		List<WebElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementos.size());
		
	}
	
}
