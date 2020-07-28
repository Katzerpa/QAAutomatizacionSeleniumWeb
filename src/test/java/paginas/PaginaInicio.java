package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaInicio {

	WebDriver dc;
	
	// Buscar Botton
	@FindBy(xpath = "//*[@class='login']")
	WebElement btnLogin;

	// ----
	public  PaginaInicio(WebDriver driver) {
		this.dc = driver;
		// Inicializa los elementos con una espera implicita
		PageFactory.initElements(new AjaxElementLocatorFactory(dc, 20), this);
	}
	// -----
	//-----
	public void clickLogin(){
		btnLogin.click(); }
	//-----
	

    public String getLoginText(){
    	return btnLogin.getText();
   }
}
