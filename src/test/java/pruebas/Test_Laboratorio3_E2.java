package pruebas;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Test_Laboratorio3_E2 {
	WebDriver dc;
	String driverPath = "C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\QAA\\EducacionIT\\Driver\\chromedriver.exe";
	String urlTest = "http://automationpractice.com/index.php";

	@BeforeSuite
	public void setUp() {
		// Set Propety
		System.setProperty("webdriver.chrome.driver", driverPath);
		// Declarar Objeto
		dc = new ChromeDriver();
		System.out.println("Inicio de suite de pruebas");

	}

	public WebDriver getDc() {
		return dc;
	}

	@BeforeTest
	
	public void IrURL() {
		// Abrir Url
		dc.get(urlTest);
	}
	
// hacer clip boton Sign in
	
	@Test(priority = 0)
	public void registrar() {
		PaginaInicio objInicio = new PaginaInicio(getDc());
		String titulo = objInicio.getLoginText();
		System.out.println(titulo);
		objInicio.clickLogin();
		Assert.assertEquals(titulo, "Sign in");
		PaginaLogin ObjLogin = new PaginaLogin(getDc());
		String titulo1 = ObjLogin.getTextTitleForm();
		System.out.println(titulo1);
		Assert.assertEquals(titulo1, "Authentication");
	}
	
//Crear cuenta Invalidad
	
	@Test(priority = 1, description = "Prueba de creación de cuenta inválida")
	public void crearCuentaInvalida() throws IOException {
		PaginaLogin objLogin = new PaginaLogin(dc);
		objLogin.sendKeysEmail("kat@9999");
		objLogin.clickCreate();
		String titulo = objLogin.getTextTitleForm();
		Assert.assertEquals(titulo, "Authentication");
		File screen = ((TakesScreenshot) dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias1\\Test.png"));

	}
	
//cerrar pagina
	
	@AfterTest
	public void cerrarPagina() throws InterruptedException {

		dc.quit();
	}
	
//fin de la prueba
	
	@AfterSuite
	public void finSuite() {
		System.out.println("Fin de suite de pruebas");
	}

}
