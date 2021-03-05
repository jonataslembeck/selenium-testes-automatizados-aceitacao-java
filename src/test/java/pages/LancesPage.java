package pages;

public class LancesPage extends BasePage {

	private static final String URL_LANCES = "http://localhost:8080/leiloes";
	
	public LancesPage() {
		super(null);
		driver.navigate().to(URL_LANCES);
	}
	
	public boolean isPaginaAtual() {
		return driver.getCurrentUrl().equals(URL_LANCES);
	}
	
	public boolean isTituloLeilaoVisivel() {
		return driver.getPageSource().contains("Dados do Leilão");
	}
}
