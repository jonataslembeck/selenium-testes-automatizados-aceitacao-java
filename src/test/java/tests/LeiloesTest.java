package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.CadastroLeilaoPage;
import pages.LeiloesPage;
import pages.LoginPage;

public class LeiloesTest {

	private LoginPage paginaDeLogin = new LoginPage();
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void setUp() {
		paginaDeLogin.preencheFormulario("fulano", "pass");
		paginaDeLeiloes = paginaDeLogin.clicaLogin();
		paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach
	public void tearDown() {
		paginaDeLeiloes.fechar();
	}
	
	@Test
	public void validaCadastroLeilaoSucessoTest() {
		String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
		String nome = "Leilão do dia " + dataHoje;
		String valor = "500.00";
		
		paginaDeCadastro.informaNome(nome);
		paginaDeCadastro.informaValorInicial(valor);
		paginaDeCadastro.informaDataAbertura(dataHoje);
		paginaDeLeiloes = paginaDeCadastro.clicaSalvar();
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, dataHoje));
	}
	
	@Test
	public void validaCamposObrigatoriosCadastroLeilaoTest() {
		paginaDeLeiloes = paginaDeCadastro.clicaSalvar();
		
		Assert.assertFalse(paginaDeCadastro.isPaginaAtual());
		Assert.assertTrue(paginaDeLeiloes.isPaginaAtual());
		Assert.assertTrue(paginaDeCadastro.isMensagensValidacaoVisiveis());
	}
}
