package Edit.EducacionIT;

import org.testng.annotations.Test;
//import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class Laboratorio1 {
//--
	@Test
	public void lab1_E1() {

		// Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\QAA\\EducacionIT\\Driver\\chromedriver.exe");
		// Declarar Objeto
		WebDriver driver = new ChromeDriver();
		// Abrir Url
		driver.get("https://selenium.dev/");
		// Cerrar URL
		driver.close();

	}// Fin lab1_E1
//---

	@Test
	public void lab_E2() {
		try {
			//// Propiedades para Ejecutar el driver de firefox
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\QAA\\EducacionIT\\Driver\\geckodriver.exe");
			// Declarar Objeto
			WebDriver driver = new FirefoxDriver();
			driver.get("https://selenium.dev/");
			driver.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}// Fin lab1_E2

	// -----
	@Test
	public void lab1_E3() {

		// Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\INFORMATICA\\Desktop\\EducacionIT\\QAA\\EducacionIT\\Driver\\chromedriver.exe");
		// Declarar Objeto
		WebDriver driver = new ChromeDriver();
		// Abrir Url
		driver.get("https://selenium.dev/");
		// Input
		WebElement myElement = driver.findElement(By.id("gsc-i-id1"));
		myElement.sendKeys("hola");

		// Enter
		WebElement textbox = driver.findElement(By.id("gsc-i-id1"));
		textbox.sendKeys(Keys.ENTER);

		// Cerrar URL

		driver.close();

	}// Fin lab1_E3

}
