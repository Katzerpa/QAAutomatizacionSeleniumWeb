package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaLogin {
	WebDriver dc;

	// Registrar correo Nuevo
	@FindBy(id = "email_create")
	WebElement emailAddress;

	// boton crear cuenta
	@FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span[1]")
	WebElement CreateAccount;

	@FindBy(xpath = "//*[@id='columns']/div[1]/span[2]")
	WebElement titleForm;
	// Ingresar correo usuario creado
	@FindBy(id = "email")
	WebElement UserMail;
	// Contraseña
	@FindBy(id = "passwd")
	WebElement PasswordMail;
	// Boton Login
	@FindBy(id ="SubmitLogin")
	 WebElement btnLogin;

	// Espera Implicita
	public PaginaLogin(WebDriver driver) {
		this.dc = driver;
		// Inicializa los elementos con una espera implicita
		PageFactory.initElements(new AjaxElementLocatorFactory(dc, 20), this);
	}

	public void sendKeysEmail(String user) {
		emailAddress.clear();
		emailAddress.sendKeys(user);
	}

	public void clickCreate() {
		CreateAccount.click();
	}

	public String getTextTitleForm() {
		return titleForm.getText();
	}

	// Inicio Seccion

	public void InicioSeccion(String user, String Password) {
		UserMail.clear();
		UserMail.sendKeys(user);
		PasswordMail.clear();
		PasswordMail.sendKeys(Password);	
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
	}

