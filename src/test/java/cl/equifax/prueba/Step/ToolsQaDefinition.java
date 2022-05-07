package cl.equifax.prueba.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import cl.equifax.prueba.Page.ToolsQaPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToolsQaDefinition {

	ToolsQaPage toolsQaPage = new ToolsQaPage();

	@Given("presiono boton agregar")
	public void presiono_boton_agregar() {
		toolsQaPage.clickBtnAdd();

	}

	@And("completo formulario con los datos y agregar funcionario")
	public void completo_formulario_con_los_datos_y_agregar_funcionario(DataTable data) {
		List<Map<String, String>> list = data.asMaps(String.class, String.class);

		assertTrue("El Formulario no es visible", toolsQaPage.IsVisibleFormAgregar());

		toolsQaPage.sendKeysFirstName(list.get(0).get("First_Name"));
		toolsQaPage.sendKeysLastName(list.get(0).get("Last_Name"));
		toolsQaPage.sendKeysUserEmail(list.get(0).get("Email"));
		toolsQaPage.sendKeysAge(list.get(0).get("Age"));
		toolsQaPage.sendKeysSalary(list.get(0).get("Salary"));
		toolsQaPage.sendKeysDepartment(list.get(0).get("Department"));
		toolsQaPage.clickBtnSubmit();
	}

	@When("cambio nombre del funcionario {string} a {string}")
	public void cambio_nombre_del_funcionario_a(String nombre, String cambioNombre) {
		toolsQaPage.clickEditForName(nombre);
		toolsQaPage.IsVisibleFormAgregar();
		toolsQaPage.sendKeysFirstName(cambioNombre);
		toolsQaPage.clickBtnSubmit();

	}

	@When("valido que el nombre del funcionario haya sido cambiado a {string}")
	public void valido_que_el_nombre_del_funcionario_haya_sido_cambiado_a(String nombre) {
		assertTrue("Al parecer este nombre no se encuentra, o esta mal escrito",
				toolsQaPage.IsVisibleNameChange(nombre));
	}

	@When("elimino el ultimo funcionario agregado")
	public void elimino_el_ultimo_funcionario_agregado() {
		toolsQaPage.deleteLastUser();

	}

	@Then("valido elimacion del funcionaro")
	public void valido_elimacion_del_funcionaro() {
		assertFalse("El funcionario no fue eliminado", toolsQaPage.IsVisibleLastName());

	}

}
