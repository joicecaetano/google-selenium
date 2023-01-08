package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GoogleTest {
	private static WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(6000));
	}
	@AfterAll 
	static void afterAll() {
		driver.close();
		
	}

	@Test
	@Order(0)
	void testMenuBar() {
		var search = driver.findElement(By.xpath("//*[@title='Pesquisar']"));

		search.sendKeys("CONCERT TECHNOLOGIES");
		search.submit();

		var menuItens = driver.findElements(By.xpath("//*[starts-with(@class,'hdtb-mitem')]"));
		assertEquals("Todas", menuItens.get(0).getText());
		assertEquals("Notícias", menuItens.get(1).getText());
		assertEquals("Imagens", menuItens.get(2).getText());
		assertEquals("Maps", menuItens.get(3).getText());
		assertEquals("Vídeos", menuItens.get(4).getText());
		assertEquals("Mais", menuItens.get(5).getText());
	}

	@Test
	@Order(1)
	void testSearchResults() {
		var site = driver.findElement(By.xpath("//cite[@class='iUh30 tjvcx']"));
		assertEquals("https://www.concert.com.br", site.getText());

		var text = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
		assertEquals("CONCERT Technologies", text.getText());
	}
	@Test
	@Order(2)
	  void testModalApps() {
	    driver.findElement(By.xpath("//a[@aria-label='Google Apps']")).click();

	    WebElement iframe = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/iframe"));
	    driver.switchTo().frame(iframe);
	    var tes = driver.findElements(By.xpath("//*[@jsname='k77Iif']/li"));
	    assertEquals("Conta", tes.get(0).getText());
	    assertEquals("Pesquisa", tes.get(1).getText());
	    assertEquals("Maps", tes.get(2).getText());
	    assertEquals("YouTube", tes.get(3).getText());
	    assertEquals("Play", tes.get(4).getText());
	    assertEquals("Notícias", tes.get(5).getText());
	    assertEquals("Gmail", tes.get(6).getText());
	    
	    driver.switchTo().defaultContent();
	}
	@Test
	@Order(3)
	void testNavigation() {
		var site = driver.findElement(By.xpath("//cite[@class='iUh30 tjvcx']"));
		site.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(2000));
		assertEquals("https://www.concert.com.br/", driver.getCurrentUrl());
	}
}
