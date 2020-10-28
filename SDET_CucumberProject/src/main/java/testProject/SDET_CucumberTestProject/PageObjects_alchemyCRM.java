package testProject.SDET_CucumberTestProject;

public interface PageObjects_alchemyCRM {
	
	//login
	public final static String username = "//input[@id='user_name']";
	public final static String pass = "//input[@id='username_password']";
	public final static String login_button = "//input[@id='bigbutton']";
	public final static String suiteCRM_dashboard_text = "//ul[@class='nav nav-tabs nav-dashboard']/li/a[contains(text(),'SUITECRM DASHBOARD') and @data-toggle='tab']";
	
	
	//dashlets
	public final static String dashlet_count = "//td[@class='dashlet-title']";
	public final static String dashlets_text = "//td[@class='dashlet-title']//span[contains(text(),'My')]"; 
	
	//sales
	public final static String sales_link = "//ul[@class='nav navbar-nav']//span/a[text()='Sales']"; 
	public final static String leads_link = "//li[@class='topnav'][1]/span[2]/ul[1]/li[5]/a";
	public final static String create_lead_button = "//div[@class='actionmenulink' and text()='Create Lead']";
	public final static String create_lead_salutation = "//select[@id='salutation']";
	public final static String create_lead_firstname = "//input[@id='first_name']";
	public final static String create_lead_lastname = "//input[@id='last_name']";
	public final static String create_lead_mobile="//input[@id='phone_mobile']";
	public final static String create_lead_accountName="//input[@id='EditView_account_name']";
	public final static String create_lead_email = "//input[@id='Leads0emailAddress0']";
	public final static String create_lead_save_buttons = "//input[@id='SAVE']";
	public final static String create_lead_module_title_after_save= "//h2[@class='module-title-text']";
	public final static String view_leads_button = "//div[@class='actionmenulink' and text()='View Leads']";
	public final static String view_leads_name_column_value= "//table[@class='list view table-responsive']/tbody/tr[1]/td[3]//a";
	
	//Meeting
	public final static String activities_link = "//li[@class='topnav'][4]/span[2]/a";
	public final static String meetings_link="//li[@class='topnav'][4]/span[2]/ul/li[4]/a";
	public final static String schedule_meeting_button="//div[text()='Schedule Meeting']";
	public final static String create_meeting_subject="//input[@id='name']";
	public final static String create_meeting_location="//input[@id='location']";
	public final static String create_meeting_duration="//select[@id='duration']";
	public final static String create_meeting_description= "//textarea[@id='description']";
	public final static String add_invitees_first_name= "//input[@id='search_first_name']";
	public final static String add_invitees_last_name= "//input[@id='search_last_name']";
	public final static String add_invitees_search_button="//input[@id='invitees_search']";
	public final static String add_invitees_add_button="//input[@id='invitees_add_1']";
	public final static String create_meeting_save_buttons= "//input[@id='SAVE_HEADER']";
	public final static String create_meeting_module_title_text="//h2[@class='module-title-text']";
	public final static String view_meetings_button="//div[text()='View Meetings']";
	public final static String meetings_subject_column = "//table[@class='list view table-responsive']/tbody/tr[1]/td[4]//a";
	
	//Product
	public final static String all_link="//a[@id='grouptab_5']";
	public final static String products_link="//li[@class='topnav all']/span/ul/li/a[text()='Products']";
	public final static String createProduct_button="//div[text()='Create Product']";
	public final static String createProduct_productName="//input[@id='name']";
	public final static String createProduct_price="//input[@id='price']";
	public final static String createProduct_description="//textarea[@id='description']";
	public final static String createProduct_save_buttons="//input[@id='SAVE']";
	public final static String createProduct_module_title_text= "//h2[@class='module-title-text']";
	public final static String viewProducts="//div[text()='View Products']";
	public final static String product_name_column_value="//table[@class='list view table-responsive']/tbody/tr[1]/td[3]//a";
	
}
