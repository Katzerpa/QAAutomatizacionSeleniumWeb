package Edit.EducacionIT;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	@Test
	public void lab2_E1() {
		// Propiedades para Ejecutar el driver de Chrome
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\QAA\\EducacionIT\\Driver\\chromedriver.exe");
		// Declarar Objeto
		WebDriver dc = new ChromeDriver();
		// Abrir Url
		dc.get("https://www.facebook.com/");

		// metodo wait explicito

		WebDriverWait myWaitVar = new WebDriverWait(dc,Duration.ofSeconds(10));

		// Nombre Formulario
		WebElement myNombre = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.name("firstname"))));
		myNombre.sendKeys("Karina");

		// Apellido Formulario
		WebElement myApellido = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.xpath("//*[@id=\"u_0_o\"]"))));
		myApellido.sendKeys("Zerpa");

		// email

		WebElement myEmail = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.name("reg_email__"))));
		myEmail.sendKeys("Karina@gmail.com");

		// Contraseña

		WebElement myContraseña = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.id("password_step_input"))));
		myContraseña.sendKeys("Ka1977**");

		// Seleccionar mes

		Select dropdown = new Select(
				myWaitVar.until(ExpectedConditions.elementToBeClickable(dc.findElement(By.id("month")))));
		dropdown.selectByValue("5");

		// Sleccionar Sexo
		WebElement radSex = myWaitVar.until(ExpectedConditions
				.elementToBeClickable(dc.findElement(By.xpath("//*[contains(@type,'radio') and @value=1 ]"))));
		radSex.click();

		// Boton Registrar
		WebElement buttonResg = myWaitVar.until(ExpectedConditions
				.elementToBeClickable(dc.findElement(By.xpath("(//button[text()='Registrarte'])[1]"))));
		buttonResg.click();

	}
}
