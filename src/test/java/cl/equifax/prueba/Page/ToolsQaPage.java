package cl.equifax.prueba.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cl.equifax.prueba.Context.Context;
import cl.equifax.prueba.Context.ScenarioContext;

public class ToolsQaPage extends Base {

	private ScenarioContext scenarioContext;

	public ToolsQaPage() {
		super(driver);
	}

	@FindBy(xpath = "//button[@id='addNewRecordButton']")
	public WebElement btnAgregar;
	@FindBy(xpath = "//form[@id='userForm']")
	public WebElement formAgregar;
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement inputFirstName;
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement inputLastName;
	@FindBy(xpath = "//input[@id='userEmail']")
	public WebElement inputUserEmail;
	@FindBy(xpath = "//input[@id='age']")
	public WebElement inputAge;
	@FindBy(xpath = "//input[@id='salary']")
	public WebElement inputSalary;
	@FindBy(xpath = "//input[@id='department']")
	public WebElement inputDepartment;
	@FindBy(xpath = "//button[@id='submit']")
	public WebElement btnSubmit;

	public void clickBtnAdd() {
		waitUntilElementIsElementClickable(btnAgregar);
		btnAgregar.click();
	}

	public boolean IsVisibleFormAgregar() {
		waitUntilElementIsVisible(formAgregar);
		return isVisible(formAgregar);
	}

	public void sendKeysFirstName(String firstName) {
		waitUntilElementIsVisible(inputFirstName);
		inputFirstName.clear();
		inputFirstName.sendKeys(firstName);
	}

	public void sendKeysLastName(String lastName) {
		waitUntilElementIsVisible(inputLastName);
		inputLastName.sendKeys(lastName);
	}

	public void sendKeysUserEmail(String email) {
		waitUntilElementIsVisible(inputUserEmail);
		inputUserEmail.sendKeys(email);
	}

	public void sendKeysAge(String age) {
		waitUntilElementIsVisible(inputAge);
		inputAge.sendKeys(age);
	}

	public void sendKeysSalary(String salary) {
		waitUntilElementIsVisible(inputSalary);
		inputSalary.sendKeys(salary);
	}

	public void sendKeysDepartment(String department) {
		waitUntilElementIsVisible(inputDepartment);
		inputDepartment.sendKeys(department);
	}

	public void clickBtnSubmit() {
		waitUntilElementIsVisible(btnSubmit);
		waitUntilElementIsElementClickable(btnSubmit);
		btnSubmit.click();

	}

	public void clickEditForName(String nombre) {
		WebElement selector = getDriver()
				.findElement(By.xpath("//div[contains(text(),'" + nombre + "')]/..//span[@title='Edit']"));
		waitUntilElementIsVisible(selector);
		waitUntilElementIsElementClickable(selector);
		selector.click();
	}

	public boolean IsVisibleNameChange(String nombre) {
		WebElement selector = getDriver().findElement(By.xpath("//div[contains(text(),'" + nombre + "')]/.."));
		waitUntilElementIsVisible(selector);
		return isVisible(selector);
	}

	public void deleteLastUser() {

		WebElement selector = getDriver()
				.findElement(By.xpath("(//span[contains(@id,'delete')])[last()]/../../..//div[@role='gridcell'][1]"));
		String UserDelete = selector.getText();
		scenarioContext = new ScenarioContext();
		scenarioContext.setContext(Context.USER, UserDelete);
		By deleteSelector = By.xpath(String.format("(//span[contains(@id,'delete')])[last()]"));
		waitUntilElementIsVisible(deleteSelector);
		WebElement delete = getDriver().findElement(deleteSelector);
		delete.click();

	}

	public boolean IsVisibleLastName() {
		String nameRemove = (String) scenarioContext.getContext(Context.USER);
		By deleteTable = By.xpath(String.format("//div[contains(text(),'" + nameRemove + "')]/.."));
		return isVisible(deleteTable);
	}

}
