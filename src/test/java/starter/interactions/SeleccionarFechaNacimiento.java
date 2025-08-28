package starter.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import starter.userinterface.PaginaLogin;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarFechaNacimiento implements Task {
    private  String dia;
    private  String mes;
    private  String ano;

    public SeleccionarFechaNacimiento(String dia, String mes, String ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public static SeleccionarFechaNacimiento con(String dia, String mes, String ano) {
        return instrumented (SeleccionarFechaNacimiento.class, dia, mes, ano);
    }
    @Override
    public <T extends Actor>void performAs(T actor) {
        System.out.println("Dia recibido: '" + dia + "'");
        System.out.println("Mes recibido: '" + mes + "'");
        System.out.println("Año recibido: '" + ano + "'");
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(dia).from(PaginaLogin.CAMPO_DIA),
                SelectFromOptions.byVisibleText(mes).from(PaginaLogin.CAMPO_MES),
                SelectFromOptions.byVisibleText(ano).from(PaginaLogin.CAMPO_AÑO)
        );
    }
}
