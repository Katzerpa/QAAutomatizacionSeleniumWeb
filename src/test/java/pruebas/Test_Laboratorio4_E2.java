package pruebas;
import org.testng.Assert;
import org.testng.annotations.*;
import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Laboratorio4_E2 {
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

	@BeforeTest

	public void IrURL() {
		// Abrir Url
		dc.get(urlTest);
	}

	// hacer clip boton Sign in

	@Test(priority = 0, description = "Prueba de Registro", dataProvider = "datos login invalido")

	public void irRegistroLogin(String user, String Password) throws Exception {
		PaginaInicio objInicio = new PaginaInicio(dc);
		String titulo = objInicio.getLoginText();
		System.out.println(titulo);
		objInicio.clickLogin();
		PaginaLogin login = new PaginaLogin(dc);
		login.InicioSeccion(user, Password);
		File screen = ((TakesScreenshot) dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias3\\Test.png"));
		String titulo1 = login.getTextTitleForm();
		System.out.println(titulo1);
		login.clickLogin();
		Assert.assertEquals(titulo1, "Authentication");
		screen = ((TakesScreenshot) dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias3\\Test1.png"));

	}

	@DataProvider(name = "datos login invalido")
	public Object[][] getData() throws Exception {
     String rutaExcel = "C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\Excel\\datosLab4_E2.xlsx";		
     String nombreHoja = "Hoja1";		
     Object datosExcel[][] = DatosExcel.leerExcel(rutaExcel, nombreHoja);
     return datosExcel;

	}

	// cerrar pagina

	@AfterTest
	public void cerrarPagina() throws InterruptedException {

		dc.quit();
	}

}
