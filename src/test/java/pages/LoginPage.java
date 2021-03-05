package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends BasePage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		driver.navigate().to(URL_LOGIN);
	}

	public void fechar() {
		driver.quit();
	}

	public void preencheFormulario(String usuario, String senha) {
		driver.findElement(By.name("username")).sendKeys(usuario);
		driver.findElement(By.name("password")).sendKeys(senha);
	}

	public LeiloesPage clicaLogin() {
		driver.findElement(By.cssSelector(".btn-primary")).click();
		return new LeiloesPage(driver);
	}

	public boolean isPaginaDeLogin() {
		return driver.getCurrentUrl().equals(URL_LOGIN);
	}

	public Object getNomeUsuarioLogado() {
		try {
			return driver.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
		
	}

	public void navegaParaPaginaDeLances() {
		driver.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return driver.getPageSource().contains(texto);
	}

	public boolean isPaginaDeLoginComDadosInvalidos() {
		return driver.getCurrentUrl().equals(URL_LOGIN + "?error");
	}

}
