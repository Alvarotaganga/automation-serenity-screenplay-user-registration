package starter.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.interactions.SeleccionarFechaNacimiento;
import starter.interactions.SeleccionarGenero;
import starter.userinterface.PaginaLogin;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearUsuario implements Task {
    private final String nombre;
    private final String email;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String state;
    private final String city;
    private final String zipcode;
    private final String phone;
    private final String genero;
    private final String dia;
    private final String mes;
    private final String ano;

    public CrearUsuario(String nombre, String email, String password, String firstname, String lastname, String address, String state, String city, String zipcode, String phone,String genero, String dia, String mes, String ano) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.genero = genero;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

    }

    public static CrearUsuario conDatos(String nombre,String email, String password, String firstname, String lastname, String address, String state, String city, String zipcode, String phone,String genero,String dia,String mes,String ano) {
        return instrumented(CrearUsuario.class,nombre,email,password,firstname,lastname,address,state,city,zipcode,phone,genero,dia,mes,ano);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaLogin.BtnLoginRegister),

                WaitUntil.the(PaginaLogin.CAMPO_NAME, isVisible()).forNoMoreThan(10).seconds(),


                Enter.theValue(nombre).into(PaginaLogin.CAMPO_NAME),
                Enter.theValue(email).into(PaginaLogin.CAMPO_EMAIL),


                Click.on(PaginaLogin.BtnLogin),


                SeleccionarGenero.con(genero),

                WaitUntil.the(PaginaLogin.CAMPO_CONTRASEÑA, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue(password).into(PaginaLogin.CAMPO_CONTRASEÑA),
                SeleccionarFechaNacimiento.con(dia, mes, ano),
                Enter.theValue(firstname).into(PaginaLogin.CAMPO_FIRST_NAME),
                Enter.theValue(lastname).into(PaginaLogin.CAMPO_LastName),
                Enter.theValue(address).into(PaginaLogin.CAMPO_ADDRESS),
                SelectFromOptions.byVisibleText("United States").from(By.id("country")),
                Enter.theValue(state).into(PaginaLogin.CAMPO_STATE),
                Enter.theValue(city).into(PaginaLogin.CAMPO_CITY),
                Enter.theValue(zipcode).into(PaginaLogin.CAMPO_ZIPCODE),
                Enter.theValue(phone).into(PaginaLogin.CAMPO_PHONE_NUMBER),


                WaitUntil.the(PaginaLogin.BtnCreateAccount, isVisible()).forNoMoreThan(10).seconds(),


                Click.on(PaginaLogin.BtnCreateAccount)
        );
    }
}
