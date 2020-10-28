package testProject.SDET_CucumberTestProject;

public class PageObjects_alchemy {
	
	//Test1
	public final static String username = "//input[@id='user_login']";
	public final static String pass = "//input[@id='user_pass']";
	public final static String login_button = "//input[@id='wp-submit']";
	public final static String user_menu = "//div[@class='wp-menu-name' and text()='Users']";
	public final static String add_new_button = "//a[@class='page-title-action' and text()='Add New']";
	public final static String new_user_username = "//input[@id='user_login']"; 
	public final static String new_user_email = "//input[@id='email']"; 
	public final static String new_user_firstname = "//input[@id='first_name']";
	public final static String new_user_lastname = "//input[@id='last_name']";
	public final static String new_user_website = "//input[@class='code']";
	public final static String show_password_button = "//button[text()='Show password']";
	public final static String new_user_password = "//input[@id='pass1']";
	public final static String notification_checkbox="//input[@id='send_user_notification']";
	public final static String new_user_role="//select[@id='role']";
	public final static String add_new_user_button = "//input[@id='createusersub']";
	public final static String confirm_weak_password_checkbox = "//input[@class='pw-checkbox']";
	public final static String new_user_message= "//div[@id='message']/p";
	
	//Test2
	public final static String jobs_link = "//li[@id='menu-item-24']/a[text()='Jobs']";
	public final static String keyword_text = "//input[@id='search_keywords']";
	public final static String search_jobs_button = "//input[@value='Search Jobs']";
	public final static String freelance_checkbox="//input[@id='job_type_freelance']";
	public final static String internship_checkbox="//input[@id='job_type_internship']";
	public final static String partTime_checkbox="//input[@id='job_type_part-time']";
	public final static String temporary_checkbox="//input[@id='job_type_temporary']";
	public final static String position_list = "//div[@class='location' and contains(text(),'Pune')]/../div[@class='position']/h3";
	public final static String job_headline = "//h1[@class='entry-title']";
	public final static String applyForJob_button = "//input[@value='Apply for job']";
	
	//Test3
	public final static String post_a_job_link="//li[@id='menu-item-26']/a[text()='Post a Job']";
	public final static String sign_in_button="//a[@class='button' and contains(text(),'Sign in')]";
	
	public final static String job_title_text = "//input[@id='job_title']";
	public final static String job_type_ddn="//select[@id='job_type']";
	public final static String description_text = "//body[@id='tinymce']";
	public final static String preview_button="//input[@name='submit_job']";
	public final static String submit_listing_button="//input[@id='job_preview_submit_button']";
	public final static String job_submit_message="//div[contains(text(),'Job listed successfully')]";
	public final static String description_check="//div[@class='job_description']/p";
	public final static String job_dashboard="//a[contains(text(),'Job Dashboard')]";
	
}
