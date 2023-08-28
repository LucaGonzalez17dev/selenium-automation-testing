package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    private By nombre = By.id("input-firstname");
    private By apellido = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By repassword = By.id("input-confirm");
    private By privacyPolicy = By.cssSelector("input[type='checkbox'][name='agree'][value='1']");
    private By btnRegistrarse = By.cssSelector("input[type='submit'][value='Continue']");
    private By btnCrearCuenta = By.cssSelector("[title='My Account']");
    private By btnRegister = By.cssSelector("a[href='https://opencart.abstracta.us:443/index.php?route=account/register']");
    private By searchbox = By.cssSelector("input[type='text'][name='search']");
    private By searchbtn = By.cssSelector("[class=\"fa fa-search\"]");
    private By iphoneImg = By.className("img-responsive");
    private By añadirAlCarrito = By.cssSelector("[type='button'][id='button-cart']");




    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickCrearCuenta() throws InterruptedException {
        this.clickear(btnCrearCuenta);
    }
    public void clickBotonRegister() throws InterruptedException {
        this.clickear(btnRegister);
    }
    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, nombre);
    }
    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, apellido);
    }
    public void escribirCorreo(String mail) throws InterruptedException {
        this.sendText(mail, email);
    }
    public void escribirtelefono(String telefono) throws InterruptedException {
        this.sendText(telefono, telephone);
    }
    public void escribirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }
    public void escribirRepetirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, repassword);
    }
    public void clickRegistrarse() throws InterruptedException {
        this.clickear(btnRegistrarse);
    }
    public void checkPrivacyPolicy() {
        WebElement privacyCheckbox = driver.findElement(privacyPolicy);
        if (!privacyCheckbox.isSelected()) {
            privacyCheckbox.click();
        }
    }
    public void escribirProducto(String producto) throws InterruptedException {
        this.sendText(producto, searchbox);
        //Thread.sleep(500);
        this.sendKey(Keys.ENTER, searchbox);
    }
    public void clickBuscar() throws InterruptedException {
        this.clickear(searchbtn);
    }
    public void clickProducto() throws InterruptedException {
        this.clickear(iphoneImg);

}
    public void confirmarCompra() throws InterruptedException {
        this.clickear(añadirAlCarrito);
}

}
