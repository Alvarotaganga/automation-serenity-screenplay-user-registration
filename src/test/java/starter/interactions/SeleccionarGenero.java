package starter.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.userinterface.PaginaLogin;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarGenero implements Task {
    private String genero;

    public SeleccionarGenero(String genero) {
        this.genero = genero;
    }

    public static SeleccionarGenero con(String genero) {
        return new SeleccionarGenero(genero);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Genero recibido: '" + genero + "'");
        String generoLimpio = genero.trim();
        if (generoLimpio.equalsIgnoreCase("Mr")){
            actor.attemptsTo(
                    WaitUntil.the(PaginaLogin.CAMPO_Mr, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(PaginaLogin.CAMPO_Mr)
            );
        }else if (generoLimpio.equalsIgnoreCase("Mrs")){
            actor.attemptsTo(
                    WaitUntil.the(PaginaLogin.CAMPO_Mrs, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(PaginaLogin.CAMPO_Mrs)
            );
        }else{
            System.out.println("Hubo un error al seleccionar el genero"+genero);
        }

    }
}
