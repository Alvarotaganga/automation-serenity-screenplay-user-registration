package starter.userinterface;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaLogin {
    public static final Target BtnLoginRegister = Target.the("boton de inicio o registro")
            .located(By.xpath("//a[text()=' Signup / Login']"));

    public static final Target CAMPO_NAME = Target.the("campo de usuario")
            .located(By.xpath("//input[@data-qa='signup-name']"));

    public static final Target CAMPO_EMAIL = Target.the("Campo de contraseña")
            .located(By.xpath("//input[@data-qa='signup-email']"));

    public static final Target BtnLogin = Target.the("boton del registro")
            .located(By.xpath("//button[@data-qa='signup-button']"));

    public static final Target CAMPO_CONTRASEÑA = Target.the("campo para la contraseña")
            .located(By.xpath("//input[@data-qa='password']"));

    public static final Target CAMPO_FIRST_NAME = Target.the("primer nombre")
            .located(By.id("first_name"));

    public static final Target CAMPO_Mr = Target.the("elegir señor")
            .located(By.xpath("//input[@value='Mr']"));

    public static final Target CAMPO_Mrs = Target.the("elegir Señora")
            .located(By.xpath("//input[@value='Mrs']"));

    public static final Target CAMPO_DIA = Target.the("campo día de nacimiento")
            .located(By.id("days"));

    public static final Target CAMPO_MES = Target.the("campo mes de nacimiento")
            .located(By.id("months"));

    public static final Target CAMPO_AÑO = Target.the("campo año de nacimiento")
            .located(By.id("years"));

    public static final Target CAMPO_LastName = Target.the("apellido")
            .located(By.id("last_name"));

    public static final Target CAMPO_ADDRESS = Target.the("direccion")
            .located(By.id("address1"));

    public static final Target CAMPO_STATE = Target.the("estado")
            .located(By.id("state"));

    public static final Target CAMPO_CITY =  Target.the("ciudad")
            .located(By.id("city"));

    public static final Target CAMPO_ZIPCODE = Target.the("codigo postal")
            .located(By.id("zipcode"));

    public static final Target CAMPO_PHONE_NUMBER = Target.the("telefono")
            .located(By.id("mobile_number"));

    public static final Target BtnCreateAccount = Target.the("boton de crear cuenta")
            .located(By.xpath("//button[@data-qa='create-account']"));
}
