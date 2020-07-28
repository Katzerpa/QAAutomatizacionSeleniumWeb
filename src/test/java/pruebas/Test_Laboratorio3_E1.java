package pruebas;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
public class Test_Laboratorio3_E1 {
	
	WebDriver dc;

	@BeforeSuite
	public void setUp(){
		// Set Propety
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\QAA\\EducacionIT\\Driver\\chromedriver.exe");
		// Declarar Objeto
		 dc = new ChromeDriver();
	}
	@BeforeTest
	public void IrURL(){
		// Abrir Url
		dc.get("https://www.facebook.com/"); 
	}
	@BeforeClass
	public void maximizarNavegador() { 
		dc.manage().window().maximize(); 
		}
   @Test
   public void registro() throws IOException {
	   
		// metodo wait explicito

		WebDriverWait myWaitVar = new WebDriverWait(dc,Duration.ofSeconds(10));

		// Nombre Formulario
		WebElement myNombre = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.name("firstname"))));
		myNombre.sendKeys("Karina");
		File screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test.png"));

		// Apellido Formulario
		WebElement myApellido = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.xpath("//*[@id=\"u_0_o\"]"))));
		myApellido.sendKeys("Zerpa");
		screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test1.png"));
		// email

		WebElement myEmail = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.name("reg_email__"))));
		myEmail.sendKeys("Karina@gmail.com");
		screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test2.png"));

		// Contraseña

		WebElement myContraseña = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.id("password_step_input"))));
		myContraseña.sendKeys("Ka1977**");
		
		screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test3.png"));

		// Seleccionar mes

		Select dropdown = new Select(
				myWaitVar.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.id("month")))));
		dropdown.selectByValue("5");
		
		screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test4.png"));

		// Sleccionar Sexo
		WebElement radSex = myWaitVar.until(ExpectedConditions
				.elementToBeClickable(dc.findElement(By.xpath("//*[contains(@type,'radio') and @value=1 ]"))));
		radSex.click();
		screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test5.png"));

		// Boton Registrar
		WebElement buttonResg = myWaitVar.until(ExpectedConditions
				.elementToBeClickable(dc.findElement(By.xpath("(//button[text()='Registrarte'])[1]"))));
		buttonResg.click();
		Assert.assertEquals(dc.getCurrentUrl(),"https://www.facebook.com/");
		screen=((TakesScreenshot)dc).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test6.png"));
		
   }
   @AfterTest
   public void cerrarPagina() throws InterruptedException{

   	dc.quit();
   }

   @AfterSuite
   public void finSuite(){
   	System.out.println("Fin de suite de pruebas"); 
   } 
   

}
