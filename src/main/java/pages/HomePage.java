package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//button[@class='Button Button--transparent js-main-menu-btn MenuButton']")
	private WebElement bnzMenuButton;

	@FindBy(xpath = "//span[text()='Payees']")
	private WebElement payeeOption;

	@FindBy(xpath = "//span[text()='Pay or transfer']")
	private WebElement paymentOption;

	public void menuOptions() {
		bnzMenuButton.click();
	}

	public void payees() {
		payeeOption.click();
	}

	public void payments() {
		paymentOption.click();
	}
}
