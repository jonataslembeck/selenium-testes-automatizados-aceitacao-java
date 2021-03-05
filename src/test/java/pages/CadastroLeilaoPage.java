package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage extends BasePage {
	
	
	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	
	public CadastroLeilaoPage(WebDriver driver) {
		super(driver);
	}

	public void fechar() {
		driver.quit();
	}

	public void informaNome(String nome) {
		driver.findElement(By.id("nome")).sendKeys(nome);
	}

	public void informaValorInicial(String valor) {
		driver.findElement(By.id("valorInicial")).sendKeys(valor);
	}

	public void informaDataAbertura(String data) {
		driver.findElement(By.id("dataAbertura")).sendKeys(data);
	}

	public LeiloesPage clicaSalvar() {
		driver.findElement(By.id("button-submit")).click();
		return new LeiloesPage(driver);
	}

	public boolean isPaginaAtual() {
		return driver.getCurrentUrl().equals(URL_CADASTRO_LEILOES);
	}

	public boolean isMensagensValidacaoVisiveis() {
		String pageSource = driver.getPageSource();
		return pageSource.contains("minimo 3 caracteres") 
				&& pageSource.contains("não deve estar em branco")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}

}
