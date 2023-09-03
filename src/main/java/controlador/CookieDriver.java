package controlador;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CookieDriver {

    private WebDriver driver;

    public CookieDriver(){

    }

    public void initDriver(){
        driver = new EdgeDriver();
    }

    public void ventanaGrande(){
        driver.manage().window().maximize();
    }

    public void web(){
        driver.get("https://orteil.dashnet.org/cookieclicker/");
    }

    public void wait5(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p")));
    }

    public void aceptaCookies(){
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
        driver.manage().deleteAllCookies();
    }

    public void cargaPartida(String partida){
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("O").keyUp(Keys.CONTROL).build().perform();
        driver.findElement(By.id("textareaPrompt")).sendKeys(partida);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void clickBigCookie(){
        try {
            driver.findElement(By.id("bigCookie")).click();
        } catch (ElementClickInterceptedException e) {
            System.err.println("No deja click en la big cookie " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
        } catch (Exception e) {
            System.err.println("ERRORRR");
            System.err.println(e.initCause(e));
        }
        try {
            //click goldenCookie
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[5]/div")).click();
            System.out.println("Coookie! " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));

        } catch (Exception e) {

        }
    }

    public void cerrarDriver(){
        driver.close();
    }


}
