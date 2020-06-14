package br.ce.rodrigo.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rodrigo.core.BaseTest;
import br.ce.rodrigo.pages.MenuPage;
import br.ce.rodrigo.pages.MovimentacaoPage;
import br.ce.rodrigo.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private MovimentacaoPage page = new MovimentacaoPage();
	
	@Test
	public void test1InserirMovimentacao() {
		menu.acessarTelaInserirMovimentacao();
		Date dataAtual = DataUtils.obterDataComDiferencaDias(0);		
		page.setDataMovimentacao(DataUtils.obterDataFormatada(dataAtual));
		page.setDataPagamento(DataUtils.obterDataFormatada(dataAtual));
		page.setDescricao("Movimentação do Teste");
		page.setInteressado("Interessado qualquer");
		page.setValor("500");
		page.setConta("Conta para movimentacoes");
		page.setStatusPago();
		page.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void test2ValidarCamposObrigatorios() {
		menu.acessarTelaInserirMovimentacao();
		page.salvar();
		List<String> erros = page.obterErros();
//		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0)); // n�o � ideal pq fica muito ingessado com rela��o a posi��o das mensagens
//		Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio")); // melhorou, mas seria necess�rio uma linha pra cada mensagem
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
		Assert.assertEquals(6, erros.size()); // para garantir que está vindo apenas as 6 msg q conheço
	}
	
	@Test
	public void test3InserirMovimentacaoFutura() {
		menu.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		page.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		page.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		
		page.setDescricao("Movimentação futura do teste");
		page.setInteressado("Interessado qualquer");
		page.setValor("500");
		page.setConta("Conta para movimentacoes");
		page.setStatusPago();
		page.salvar();
		List<String> erros = page.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}

}
