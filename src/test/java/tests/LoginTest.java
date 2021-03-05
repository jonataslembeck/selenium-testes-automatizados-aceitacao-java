package tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import pages.LoginPage;

public class LoginTest {

	private LoginPage paginaDeLogin = new LoginPage();

	@AfterEach
	public void tearDown() {
		paginaDeLogin.fechar();
	}

	@Test
	public void validarLoginComDadosValidosTest() {
		paginaDeLogin.preencheFormulario("fulano", "pass");
		paginaDeLogin.clicaLogin();

		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}

	@Test
	public void validarLoginComDadosInvalidosTest() {
		paginaDeLogin.preencheFormulario("fulano", "passsssss");
		paginaDeLogin.clicaLogin();

		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}

	@Test
	public void validarAcessoPaginaRestritaSemEstarLogadoTest() {
		paginaDeLogin.navegaParaPaginaDeLances();

		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}

}
