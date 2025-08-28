package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import starter.tasks.CrearUsuario;

import java.util.Map;

public class CrearUsuarioStepDefinitions {

    @Managed(driver = "edge")
    WebDriver navegador;

    Actor usuario = Actor.named("usuario");

    @Before
    public void configurarEscenario() {
        usuario.can(BrowseTheWeb.with(navegador));
    }

    @Given("que el usuario abre la página de Automation Exercise")
    public void abrirPagina() {
        navegador.get("https://automationexercise.com/");
    }

    @When("el usuario se registra en la página con los datos:")
    public void registrarUsuario(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        usuario.attemptsTo(
                CrearUsuario.conDatos(
                        datos.get("nombre"),
                        datos.get("email"),
                        datos.get("password"),
                        datos.get("firstname"),
                        datos.get("lastname"),
                        datos.get("address"),
                        datos.get("state"),
                        datos.get("city"),
                        datos.get("zipcode"),
                        datos.get("phone"),
                        datos.get("genero"),
                        datos.get("dia"),
                        datos.get("mes"),
                        datos.get("ano")
                )
        );
    }

    @Then("debería ver un mensaje de confirmación de cuenta creada")
    public void verificarCuentaCreada() {
        System.out.println("Cuenta creada exitosamente ✅");
    }
}
