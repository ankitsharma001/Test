package pageMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
public class addEmployeePage {
	private static final By Employee = By.xpath(".//a[@href='#'][contains(text(),'Employee')]");
	private static final By AddEmployee = By.xpath(".//a[contains(text(),'Add Employee')]");
	private static final By Branch = By.id("branch");
	private static final By EmployeeName = By.id("txt_name");
	private static final By EmployeeCode = By.id("txt_empid");	
	private static final By Role = By.id("role");
	private static final By PhoneNumber = By.id("txt_phone");
	private static final By EmailID = By.id("txt_email");
	private static final By RadioMale = By.xpath(".//*[@value='M']");
	private static final By RadioFelmale = By.xpath(".//*[@value='F']");
	private static final By BloodGroup = By.id("id='bloodgroup");
	private static final By Address = By.id("txt_address");
	private static final By Stoppage = By.xpath(".//*[@title='Select Stoppage']");
	private static final By MaxTime = By.id("txt_maxtime");
	private static final By EmgContact = By.id("txt_emgcontact");
	private static final By EmpPageButton = By.id("btn_sumbit");
	private static final By AssignFixedSch = By.id("chck_assignSchedule");
	
	public void clickOnAddEmployee(){
		$(Employee).shouldBe(Condition.visible).click();
		$(AddEmployee).shouldBe(Condition.visible).click();
	}
	
	public void selecBranch(){
		Select dropdown = new Select($(Branch).shouldBe(Condition.visible));
		dropdown.selectByVisibleText("Main Branch");
	}
	
	public void enterEmployeeName(){
		$(EmployeeName).shouldBe(Condition.visible).setValue("Ankit");
	}
	
	public void enterEmployeeCode(){
		$(EmployeeCode).shouldBe(Condition.visible).setValue("1234");
	}
	
	public void selectRole(){
		Select dropdown = new Select($(Role).shouldBe(Condition.visible));
		dropdown.selectByVisibleText("Employee");
	}
	
	public void enterPhoneNumber(){
		$(PhoneNumber).shouldBe(Condition.visible).setValue("789461213");
	}
	
	public void enterEmailID(){
		$(EmailID).shouldBe(Condition.visible).setValue("fataka@role.com");
	}
	
	public void selectRadioButton(boolean var){
		boolean status = $(RadioMale).shouldBe(Condition.visible).isSelected();
		if(status!=var)
			$(RadioMale).click();
		else
			$(RadioFelmale).click();
	}
	
	public void selectBloodGroup(){
		Select dropdown = new Select($(BloodGroup).shouldBe(Condition.visible));
		dropdown.selectByVisibleText("A+");
	}
	
	public void enterAddress(){
		$(Address).shouldBe(Condition.visible).setValue("Bangalore");
	}
	
	public void pickupStoppage(){
		$$(Stoppage).filterBy(Condition.text("Select Stoppage")).get(0).click();getClass();
		//code not complete need to be done
	}
	
	public void dropStoppage(){
		$$(Stoppage).filterBy(Condition.text("Select Stoppage")).get(1).click();
		//code not complete need to be done
	}
	
	public void maxTime(){
		$(MaxTime).shouldBe(Condition.visible).setValue("1");
	}
	
	public void enterEmergencyContactNumber(){
		$(EmgContact).shouldBe(Condition.visible).setValue("7894651230");
	}
	
	public void checkAssignFixedSchedule(){
		$(AssignFixedSch).shouldBe(Condition.visible).click();
		
	}
	public void SubmitButton(){
		$(EmpPageButton).shouldBe(Condition.visible).click();
	}
}