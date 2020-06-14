package br.ce.rodrigo.core;

import static br.ce.rodrigo.core.DriverFactory.getDriver;
import static br.ce.rodrigo.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.rodrigo.pages.LoginPage;


public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	private LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.logar("rodrigo@soares.com", "123456789");
	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver(); 
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName + ".jpg"));
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
