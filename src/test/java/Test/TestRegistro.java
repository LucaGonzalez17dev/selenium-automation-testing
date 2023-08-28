package Test;

import Pages.RegisterPage;
import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestRegistro {
    public WebDriver driver;
    public WebDriverWait wait;
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES.html");
    ExtentReports extent;



    @BeforeEach
    public void setUp() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.url("http://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("REGISTRO")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.clickCrearCuenta();
        registerPage.clickBotonRegister();
        test.log(Status.PASS, "Ingreso en el formulario de Registro");

        registerPage.escribirNombre("Luke");
        registerPage.escribirApellido("Skywalker");
        registerPage.escribirCorreo("jedi2@gmail.com");
        registerPage.escribirtelefono("123456789");
        registerPage.escribirContraseña("123456");
        registerPage.escribirRepetirContraseña("123456");
        registerPage.checkPrivacyPolicy();
        test.log(Status.PASS, "Ingreso todos los datos del Registro");
        registerPage.clickRegistrarse();
        registerPage.escribirProducto("iphone");
        registerPage.clickBuscar();
        test.log(Status.PASS, "Realiza Busqueda de iphone");
        registerPage.clickProducto();
        registerPage.confirmarCompra();
        test.log(Status.PASS, "Validación de Busqueda Exitosa");
    }



    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
        extent.flush();
    }
}
