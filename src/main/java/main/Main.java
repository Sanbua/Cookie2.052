package main;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        //Driver navegador
        System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe"); // casa

        WebDriver driver = new EdgeDriver();

        //Maximizar la ventana
        driver.manage().window().maximize();

        //Abrir cookie cliker
        driver.get("https://orteil.dashnet.org/cookieclicker/");

        //esperar 5seg
        //waiting();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p")));

        //aceptar cookies
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
        driver.manage().deleteAllCookies();

        //cargar partida con control + o
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("O").keyUp(Keys.CONTROL).build().perform();
        driver.findElement(By.id("textareaPrompt")).sendKeys(leerLog());
        action.sendKeys(Keys.ENTER).build().perform();

        //click cookie bigCookie
        while (true) {
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

    }

    /*
    public static void waiting() {
        //esperar 5seg
        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
     */
    public static String leerLog() throws FileNotFoundException, IOException {
        File file = new File("log\\logSave");

        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(streamReader);
        String line = new String();

        while (br.ready()) {
            line = br.readLine();
        }

        return line;


    }
}
