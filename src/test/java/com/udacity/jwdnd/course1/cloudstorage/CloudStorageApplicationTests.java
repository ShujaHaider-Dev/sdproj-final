package com.udacity.jwdnd.course1.cloudstorage;
import com.udacity.jwdnd.course1.cloudstorage.page.*;
import com.udacity.jwdnd.course1.cloudstorage.page.tab.CredentialsTab;
import com.udacity.jwdnd.course1.cloudstorage.page.tab.NoteTab;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {
	private static WebDriver driver;
	private static SignupPage signupPage;
	private static LoginPage loginPage;
	private static HomePage homePage;
	private static NoteTab notesTab;
	private static CredentialsTab credentialsTab;
	@LocalServerPort
	private int port;
	public String baseURL;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}
	@BeforeEach
	public void beforeEach() {
		baseURL = "http://localhost:" + port;
		driver = new ChromeDriver();
		signupPage = new SignupPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		notesTab = new NoteTab(driver);
		credentialsTab = new CredentialsTab(driver);
	}
	@AfterEach
	public void afterEach() {
		driver.quit();
	}
	
	@Test
	public void userCantUseServiceWithoutLogin() {
		driver.get(baseURL + "/signup");
		Assertions.assertEquals("Sign Up", driver.getTitle());
		driver.get(baseURL + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
		driver.get(baseURL + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void userCanLogoutAndNotBeAbleToAccess() {
		driver.get(baseURL + "/signup");
		signupPage.signUp("mecool", "mecool", "mecool", "mecool");
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		homePage.logout();
		Assertions.assertEquals("Login", driver.getTitle());
		driver.get(baseURL + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void userCanCreateANote() throws InterruptedException {
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		notesTab.clickNotesTab();
		Thread.sleep(2000);
		notesTab.clickAddNoteButton();
		Thread.sleep(2000);
		notesTab.setNoteTitle("mecool");
		notesTab.setNoteDescription("mecool");
		Assertions.assertEquals("mecool", notesTab.getNoteTitle());
		Assertions.assertEquals("mecool", notesTab.getNoteDescription());
	}

	@Test
	public void userCanEditANote() throws InterruptedException {
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		notesTab.clickNotesTab();
		Thread.sleep(2000);
		notesTab.clickAddNoteButton();
		Thread.sleep(2000);
		notesTab.setNoteTitle("mecool");
		notesTab.setNoteDescription("mecool");
		Thread.sleep(2000);
		notesTab.clickNoteEdit();
		Thread.sleep(2000);
		notesTab.setNoteTitle("mecool2");
		notesTab.setNoteDescription("mecool2");
		Assertions.assertEquals("mecool2", notesTab.getNoteTitle());
		Assertions.assertEquals("mecool2", notesTab.getNoteDescription());
	}

	@Test
	public void userCanDeleteANote() throws InterruptedException {
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		notesTab.clickNotesTab();
		Thread.sleep(2000);
		notesTab.clickAddNoteButton();
		Thread.sleep(2000);
		notesTab.setNoteTitle("mecool");
		notesTab.setNoteDescription("mecool");
		Thread.sleep(2000);
		notesTab.clickNoteDelete();
		assertThrows(NoSuchElementException.class, () -> notesTab.getNoteTitle());
		assertThrows(NoSuchElementException.class, () -> notesTab.getNoteDescription());
	}

	@Test
	public void userCanCreateCredentials() throws InterruptedException {
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		credentialsTab.clickCredentialsTab();
		Thread.sleep(2000);
		credentialsTab.clickAddCredentialButton();
		Thread.sleep(2000);
		credentialsTab.setCredentialURL("https://mecool.com");
		credentialsTab.setCredentialUsername("mecool");
		credentialsTab.setCredentialPassword("mecool");
		Assertions.assertEquals("https://mecool2.com", credentialsTab.getCredentialURL());
		Assertions.assertEquals("mecool2", credentialsTab.getCredentialUsername());
		Assertions.assertEquals("mecool2", credentialsTab.getCredentialPassword());
	}

	@Test
	public void userCanEditCredentials() throws InterruptedException {
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		credentialsTab.clickCredentialsTab();
		Thread.sleep(2000);
		credentialsTab.clickAddCredentialButton();
		Thread.sleep(2000);
		credentialsTab.setCredentialURL("https://mecool.com");
		credentialsTab.setCredentialUsername("mecool");
		credentialsTab.setCredentialPassword("mecool");
		Thread.sleep(2000);
		credentialsTab.clickCredentialEdit();
		Thread.sleep(2000);
		credentialsTab.setCredentialURL("https://mecool2.com");
		credentialsTab.setCredentialUsername("mecool2");
		credentialsTab.setCredentialPassword("mecool2");
		Assertions.assertEquals("https://mecool2.com", credentialsTab.getCredentialURL());
		Assertions.assertEquals("mecool2", credentialsTab.getCredentialUsername());
		Assertions.assertEquals("mecool2", credentialsTab.getCredentialPassword());
	}

	@Test
	public void userCanDeleteCredentials() throws InterruptedException {
		driver.get(baseURL + "/login");
		loginPage.login("mecool", "mecool");
		credentialsTab.clickCredentialsTab();
		Thread.sleep(2000);
		credentialsTab.clickAddCredentialButton();
		Thread.sleep(2000);
		credentialsTab.setCredentialURL("https://mecool.com");
		credentialsTab.setCredentialUsername("mecool");
		credentialsTab.setCredentialPassword("mecool");
		Thread.sleep(2000);
		credentialsTab.clickCredentialDelete();
		assertThrows(NoSuchElementException.class, () -> credentialsTab.getCredentialURL());
		assertThrows(NoSuchElementException.class, () -> credentialsTab.getCredentialUsername());
		assertThrows(NoSuchElementException.class, () -> credentialsTab.getCredentialPassword());
	}
}