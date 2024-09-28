package steps;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class test {
    public static void main(String[] args){

        WebDriver driver;
        WebDriverWait wait;

        // Mengatur WebDriverManager untuk menangani setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Membuat Intance dari ChromeDriver
        driver = new ChromeDriver();
        // Membuat Instance dari WebDriverWait dengan waktu tunggu (misalnya, 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Full Screen browser windows
        driver.manage().window().maximize();

        // Membuka halaman google
        driver.get("https://www.saucedemo.com/");

        // print judul halaman
        System.out.println("title of the page is" + driver.getTitle());

        // Mencari field username dan memasukkan username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Mencari field password dan memasukan password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Mencari button login dan click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Asser jika login telah suskes dengan cara mengecek bahwa caontainer inventory
        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
        inventoryContainer.isDisplayed();
//        Assert.ass(inventoryContainer.isDisplayed(), "inventory container should be display after login");


        // Menutup browser
        driver.quit();
    }
}
