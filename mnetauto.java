/*
 * Author: Ruturaj but only god knows code how it got run.!
 */
package mnet_Maven.mnet;

import java.util.Scanner;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mnetautomation {
	public static void main(String[] args) throws Exception {
		Thread.sleep(1000);
		// declaration and instantiation of objects/variables
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\LENOVO\\Desktop\\geckodriver-v0.30.1-win64\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		// comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\Desktop\\chromedriver_win32\\chromedriver.exe");

		// disable notification chrome
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		// opt.setExperimentalOption("prefs", prefs);

		// disable notificaion in firfox wala browser

		// FirefoxOptions opt = new FirefoxOptions();
		// opt.addPreference("dom.webnotification.enabled", true);

		// WebDriver driver = new FirefoxDriver(opt);
		WebDriver driver = new ChromeDriver(opt);

		driver.manage().window().maximize();
		String baseUrl = "https://m-net.in";
		String expectedTitle = "Loading... | INSTANCE";
		String actualTitle = "QA Link";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();

	
		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed! Matched Expected URL");
		} else {
			System.out.println("Test Failed! Mismatched Expected URL");
		}

		// close Fire fox
		// driver.close();
		String CurentUrl = driver.getCurrentUrl();
		System.out.println("Here is URl You just loaded  " + CurentUrl);
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.name("username"));
		login.sendKeys("ruturaj");
		System.out.println("UserName Found");
		WebElement term = driver.findElement(By.xpath(
				"//*[@id=\'m_login\']/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[2]/div/div[1]/label/span"));
		term.click();
		WebElement proceed = driver.findElement(By.xpath(
				"//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button"));
		proceed.click();
		Thread.sleep(2000);
		WebElement pass = driver.findElement(By.name("password"));
		Thread.sleep(2000);
		pass.sendKeys("######");
		Thread.sleep(2000);
		WebElement login_button = driver.findElement(By.xpath(
				"//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button"));
		Thread.sleep(2000);
		login_button.click();

		Thread.sleep(2000);
		if (driver.findElement(By.xpath(
				"//mat-dialog-container[@id='mat-dialog-0']/m-login-warning-dialog/div[2]/div/m-spinner-button/button/span/span"))
				.isDisplayed()) {
			driver.findElement(By.xpath(
					"//mat-dialog-container[@id='mat-dialog-0']/m-login-warning-dialog/div[2]/div/m-spinner-button/button/span/span"))
					.click();
			System.out.println("Checking Override found!");

		} else if (driver.findElement(By.xpath(
				"//*[@id=\\\"m_login\\\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button"))
				.isDisplayed()) {
			driver.findElement(By.xpath(
					"//*[@id=\\\"m_login\\\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button"))
					.click();
			System.out.println("Logged In successfully!");
		}
		Thread.sleep(1000);
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		// String alertMessage = driver.switchTo().alert().getText(); // capture alert
		// message
		// System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(1000);
	
		// Inbox Connect Code
		// WebElement viewallconnect =
		// driver.findElement(By.xpath("//*[@id=\"view_all_text\"]"));
		// viewallconnect.click();

		WebElement Connect = driver.findElement(By.xpath("//*[@id=\"m-header\"]/div/div/div[1]/ul/li[2]/a"));
		Connect.click();
		System.out.println("Got in Connect successfully!");
		Thread.sleep(3000);
		// WebElement Unreadconnect = driver.findElement(
		// By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[1]/div[2]/div/div[1]/div[1]"));
		// Unreadconnect.click();

		// WebElement Recent = driver.findElement(By.xpath(""));
		// Recent.click();

		//..................................................................connect start......................!!!!!!

 		WebElement recentDirectMessage = driver.findElement(By.xpath(
				"/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-unread-message/div/div[1]/div[1]/div[3]"));
		recentDirectMessage.click();

		System.out.println("Recent DM!");
		Thread.sleep(2000);
		WebElement recentGroupMessage = driver.findElement(By.xpath(
				"/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-unread-message/div/div[1]/div[1]/div[4]"));
		recentGroupMessage.click();

		System.out.println("Recent GM!");
 		Thread.sleep(2000);
		WebElement recentCollaborationMessage = driver.findElement(By.xpath(
				"/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-unread-message/div/div[1]/div[1]/div[5]"));
		recentCollaborationMessage.click();

		System.out.println("Recent CM!");
		Thread.sleep(2000);
		WebElement AllThreads = driver.findElement(
				By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[1]/div[2]/div/div[1]/div[2]"));
		AllThreads.click();
		Thread.sleep(1000);

		WebElement unreadAllThreadDm = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[2]"));
		unreadAllThreadDm.click();
		System.out.println("Clicked on DM unreadThreads");

		Thread.sleep(1000);
		WebElement unreadAllThreadGm = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[3]"));
		unreadAllThreadGm.click();
		System.out.println("Clicked on Group Unread Threads");

		Thread.sleep(1000);
		WebElement unreadAllThreadCM = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[4]"));
		unreadAllThreadCM.click();
		System.out.println("Clicked on Collabs unread Threads");

		Thread.sleep(1000);
		WebElement unreadAllThreadApproval = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[5]"));
		unreadAllThreadApproval.click();
		System.out.println("CLicked on Approvals unread threads");
		
		Thread.sleep(1000);
		WebElement unreadAllThreadException= driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[6]/span/mat-select/div/div[2]"));
		unreadAllThreadException.click();
		System.out.println("Clicked on Exception threads");

		Thread.sleep(1000);
		WebElement unreadAllThreadPob= driver.findElement(By.id("mat-option-12"));
		unreadAllThreadPob.click();
		System.out.println("Clicked on POB threads");

		Thread.sleep(1000);
		WebElement unreadAllThreaddropdown1= driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[6]/span/mat-select/div/div[2]"));
		unreadAllThreaddropdown1.click();
		System.out.println("Clicked on  threads dropdown");

		Thread.sleep(1000);
		WebElement unreadAllThreadClose = driver.findElement(By.id("mat-option-17"));
		unreadAllThreadClose.click();
		System.out.println("Clicked on Close threads");

		Thread.sleep(1000);
		WebElement unreadAllThreaddropdown2= driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-all-threads/div/div[1]/div/div[2]/div/div[6]/span/mat-select/div/div[2]"));
		unreadAllThreaddropdown2.click();

		Thread.sleep(1000);
		final WebElement unreadAllThreadOpen = driver.findElement(By.id("mat-option-20"));
		unreadAllThreadOpen.click();
		System.out.println("Clicked on Open threads");


		Thread.sleep(1000);
		WebElement SearchNameThread = driver.findElement(By.xpath("//*[@id='allthread_search_thread_field']"));
		SearchNameThread.sendKeys("Pankaj");
		System.out.println("Searched Pankaj Name in threads");

		Thread.sleep(1000);
		WebElement New_DM = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[1]/div[2]/div/div[3]/perfect-scrollbar/div/div[1]/div[1]/div/span/img"));
		New_DM.click();


		Thread.sleep(1000);
		 WebElement click_DM_popup_name = driver.findElement(By.xpath("//*[@id='selectedMembers']/div"));
		click_DM_popup_name.click();

		try{
		Thread.sleep(1000);
		WebElement search_name_in_dm = driver.findElement(By.xpath("//ng-select[@id='selectedMembers']/div/div/div[2]/input"));
		search_name_in_dm.sendKeys("Vapt5");

		}
		catch (Exception n)
		{
			throw(n);
		}

		Thread.sleep(2000);
		WebElement Click_name = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-new-direct-message/form/section/div[1]/ng-select/ng-dropdown-panel/div[2]/div[2]/div"));
		Click_name.click();

		Thread.sleep(1000);
		WebElement Enter_your_description = driver.findElement(By.xpath("//*[@id='inlineFormInputGroupUsername2']/div[2]/div[1]"));
		Enter_your_description.sendKeys("Hello There This is Automated Message triggered By Selenium Java!");

	 	Thread.sleep(1000);
		WebElement create_dm_send_button = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-new-direct-message/form/div/button[2]"));
		create_dm_send_button.click();
		System.out.println("DM Created A Unique Message Sent to User!");

		Thread.sleep(2000);
		WebElement hamburger_menu_thread = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-app-live-chat/div[1]/m-app-messages/div/div[1]/div[2]/div[7]/m-app-message/div/div[2]/div[1]/div/div"));
		hamburger_menu_thread.click();

		System.out.println("Create A New Thread Popup open!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div")).click();
		
		WebElement Enter_Descption_in_thread = driver.findElement(By.xpath("//*[@id='inlineFormInputGroupUsername2']/div[2]/div[1]"));
		Enter_Descption_in_thread.sendKeys("Hello This is Automated Thread Created By Selenium!");

		Thread.sleep(3000);
		WebElement create_thread_send_button = driver.findElement(By.xpath("/html/body/m-modules/modal-container/div[2]/m-create-thread/form/div/button[2]"));
		create_thread_send_button.click();

		Thread.sleep(5000);
		WebElement click_close_thread_button = driver.findElement(By.xpath("/html/body/m-modules/m-right-drawer-sidebar/div[2]/div/div[2]/div/div[2]/div/div/m-right-drawer-thread-messages/div[2]/div/div[1]/div[2]/div[3]/div/span/span[2]"));
		click_close_thread_button.click();
		System.out.print("Thread has been closed");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='m_right_drawer_sidebar_close']/img")).click();
		Thread.sleep(3000);
		WebElement enter_message_dm_input = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-app-live-chat/div[1]/m-app-messages/div/div[2]/div[2]/quill-editor/div[2]/div[1]"));
		enter_message_dm_input.sendKeys("Sharing One Excel file!");

		Thread.sleep(1000);
		try {
		
		WebElement upload_file = driver.findElement(By.id("fileInput"));
		//WebElement upload_file = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-app-live-chat/div[1]/m-app-messages/div/div[2]/div[2]/quill-editor/div[1]/span[11]/button[2]"));
		upload_file.sendKeys("C:/Users/LENOVO/Desktop/Approval_Report (1).xlsx");

		} catch (Exception e)
 		{
			try {
				throw(e);
			} catch (Exception e1) {
				// Auto-generated catch block
				e1.printStackTrace();
			}
		}


		System.out.println(click_DM_popup_name);

		Thread.sleep(1000);
		WebElement Confidentail_file_checkmark_true = driver.findElement(By.xpath("//*[@id='inbox_center_section']/div[2]/div[2]/quill-editor/div[1]/div/div/div[2]/span[1]/input"));
		Confidentail_file_checkmark_true.click();

		Thread.sleep(3000);
		WebElement click_enter_to_send_message = driver.findElement(By.xpath("//*[@id=\'inbox_center_section\']/div[2]/div[2]/quill-editor/div[1]/span[11]/button[3]"));
		click_enter_to_send_message.click();
		System.out.println("Attachment with message been send in DM");

		Thread.sleep(1000);

		//Collaboration Initiated.

		Thread.sleep(2000);
		WebElement click_on_plus_icon_collab_popup = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[1]/div[2]/div/div[3]/perfect-scrollbar/div/div[1]/div[2]/div/span/img"));
		click_on_plus_icon_collab_popup.click();
		
		//Scanner scanner_collab_name;
		Thread.sleep(4000);
		Scanner scanner_collab_name = new Scanner(System.in);
		System.out.println("Enter Unique Name to Channel: ");
		String name = scanner_collab_name.nextLine();
		System.out.println("Channel Creation process begin...!");

		

		//
		Thread.sleep(3000);
		WebElement click_on_title_collab = driver.findElement(By.id("title"));
		click_on_title_collab.sendKeys(name);
		scanner_collab_name.close();

		Thread.sleep(2000);

		WebElement select_first_user = driver.findElement(By.xpath("//*[@id='selectedMembers']/div/div/div[2]/input"));
		select_first_user.sendKeys("Abhishek");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-create-channel/section/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();

		Thread.sleep(1000);
		/* 
		WebElement select_second_user = driver.findElement(By.xpath("//*[@id='selectedMembers']/div/div/div[3]/input"));
		select_second_user.sendKeys("Sreeram");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-create-channel/section/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();

		Thread.sleep(1000);
		WebElement select_third_user = driver.findElement(By.xpath("//*[@id='selectedMembers']/div/div/div[4]/input"));
		select_third_user.sendKeys("Santosh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-create-channel/section/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();

		Thread.sleep(1000);
		WebElement select_fourth_user = driver.findElement(By.xpath("//*[@id='selectedMembers']/div/div/div[5]/input"));
		select_fourth_user.sendKeys("Shubhra");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-create-channel/section/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();

		Thread.sleep(1000);
		WebElement select_fifth_user = driver.findElement(By.xpath("//*[@id='selectedMembers']/div/div/div[6]/input"));
		select_fifth_user.sendKeys("Pankaj");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-create-channel/section/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();
		
		Thread.sleep(1000);
		WebElement select_sixth_user = driver.findElement(By.xpath("//*[@id='selectedMembers']/div/div/div[7]/input"));
		select_sixth_user.sendKeys("Rakesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/m-create-channel/section/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();
		System.out.println("Members added in channel Successfully!"); */

		try{
		Thread.sleep(3000);
		WebElement enter_collab_description = driver.findElement(By.xpath("//*[@id='mat-dialog-1']/m-create-channel/section/form/div/textarea"));
		enter_collab_description.sendKeys("Hello Folks This is Automated Message Triggered!");
	    Thread.sleep(1000);
	} 
		catch (Exception d){
			System.err.print("Error while adding In description");
		}
		WebElement click_create_collab_button = driver.findElement(By.xpath("//*[@id='mat-dialog-1']/m-create-channel/div/button[2]"));
		click_create_collab_button.click();
	
		System.out.println("Collab Created Successfully!");
		

 
		////************************************ */
		Thread.sleep(3000);
		WebElement enter_message_collab_input = driver.findElement(By.xpath("//*[@id='inbox_center_section']/div[2]/div[2]/quill-editor/div[2]/div[1]"));
		enter_message_collab_input.sendKeys("Sharing One PDF");

		Thread.sleep(1000);
		
		WebElement upload_file_collab = driver.findElement(By.id("fileInput"));
		//WebElement upload_file = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-app-live-chat/div[1]/m-app-messages/div/div[2]/div[2]/quill-editor/div[1]/span[11]/button[2]"));
		upload_file_collab.sendKeys("C:/Users/LENOVO/Desktop/MediaWare/ChannelMix.pdf");


		Thread.sleep(1000);
		WebElement Confidentail_file_checkmark_true_cl = driver.findElement(By.xpath("//*[@id='inbox_center_section']/div[2]/div[2]/quill-editor/div[1]/div/div/div[2]/span[1]/input"));
		Confidentail_file_checkmark_true_cl.click();

		Thread.sleep(5000);
		WebElement click_enter_to_send_message_cl = driver.findElement(By.xpath("//*[@id=\'inbox_center_section\']/div[2]/div[2]/quill-editor/div[1]/span[11]/button[3]"));
		click_enter_to_send_message_cl.click();
		System.out.println("Attachment with message been send in Collab");
		
		Thread.sleep(2000);
		WebElement view_doc_click = driver.findElement(By.xpath("//*[@id='inbox_center_section']/div[1]/div[2]/div[2]/m-app-message/div/div[2]/div[2]/div/div[1]/span[2]/div/span[2]/img"));
		view_doc_click.click();

		Thread.sleep(1000);
		//close view display
		driver.findElement(By.xpath("/html/body/m-modules/modal-container/div[2]/m-document-view-files/div/div[1]/div[2]/span/i")).click();
		

		Thread.sleep(2000);
		WebElement hamburger_menu_thread = driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-app-live-chat/div[1]/m-app-messages/div/div[1]/div[2]/div[2]/m-app-message/div/div[2]/div[1]/div/div/mat-icon"));
		hamburger_menu_thread.click();

		System.out.println("Create A New Thread Popup open in Collab!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div")).click();
		
		WebElement Enter_Descption_in_thread = driver.findElement(By.xpath("//*[@id='inlineFormInputGroupUsername2']/div[2]/div[1]"));
		Enter_Descption_in_thread.sendKeys("Hello This is Automated Thread Created By Selenium!");

		Thread.sleep(3000);
		WebElement create_thread_send_button = driver.findElement(By.xpath("/html/body/m-modules/modal-container/div[2]/m-create-thread/form/div/button[2]"));
		create_thread_send_button.click();


		//Thread IN collabs with attachments 
		Thread.sleep(1000);
		WebElement enter_message_collab_thread_input = driver.findElement(By.xpath("//*[@id='footer-right_drawer_thread_messages_list_editor']/div[2]/quill-editor/div[2]/div[1]"));
		enter_message_collab_thread_input.sendKeys("Sharing One GIF file...!");

		Thread.sleep(1000);
		
		WebElement upload_file_in_thread_collab = driver.findElement(By.xpath("/html/body/m-modules/m-right-drawer-sidebar/div[2]/div/div[2]/div/div[2]/div/div/m-right-drawer-thread-messages/div[2]/div/div[3]/div[2]/quill-editor/div[1]/span[11]/button[2]/span/div/input"));
		upload_file_in_thread_collab.sendKeys("C:/Users/LENOVO/Desktop/MediaWare/deviation_popup.gif");


		Thread.sleep(4000);
		WebElement Confidentail_file_checkmark_true_collab_thread = driver.findElement(By.name("confidential_file"));
		Confidentail_file_checkmark_true_collab_thread.click();

		Thread.sleep(5000);
		WebElement click_enter_to_send_message_collab_thread = driver.findElement(By.xpath("/html/body/m-modules/m-right-drawer-sidebar/div[2]/div/div[2]/div/div[2]/div/div/m-right-drawer-thread-messages/div[2]/div/div[3]/div[2]/quill-editor/div[1]/span[11]/button[3]"));
		click_enter_to_send_message_collab_thread.click();
		System.out.println("Attachment with message has been sent in Collab Thread!");
		Thread.sleep(5000);
		WebElement click_close_thread_button = driver.findElement(By.xpath("/html/body/m-modules/m-right-drawer-sidebar/div[2]/div/div[2]/div/div[2]/div/div/m-right-drawer-thread-messages/div[2]/div/div[1]/div[2]/div[3]/div/span/span[2]"));
		click_close_thread_button.click();
		System.out.print("Collab Thread has been closed..!");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='m_right_drawer_sidebar_close']/img")).click();
		Thread.sleep(3000);
	
	
	}
}
