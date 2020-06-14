package br.ce.rodrigo.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.rodrigo.core.DriverFactory;
import br.ce.rodrigo.pages.LoginPage;
import br.ce.rodrigo.tests.ContaTest;
import br.ce.rodrigo.tests.MovimentacaoTest;
import br.ce.rodrigo.tests.RemoverMovimentacaoContaTest;
import br.ce.rodrigo.tests.ResumoTest;
import br.ce.rodrigo.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class	
})
public class SuiteGeral {

	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.logar("rodrigo@soares.com", "123456789");
		page.entrar();
		page.resetar();
		DriverFactory.killDriver();
	}
	
}
