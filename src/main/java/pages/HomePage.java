package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//button[@class='Button Button--transparent js-main-menu-btn MenuButton']")
	private WebElement bnzMenuButton;
	
	
	public void menuOptions(){
		
	bnzMenuButton.click();
	}
	
	@FindBy(xpath = "//span[text()='Payees']")
	private WebElement payeeOption;
	
	public void payees() {
		payeeOption.click();	
		
	}
}
