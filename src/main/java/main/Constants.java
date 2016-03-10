package main;

public class Constants {
	public static int TIME = 0;
	public static final int SLEEP_TIME = 2500;
	
	// Workaround to locate files when residing on server
	private static String locationOnServer = Constants.class.getProtectionDomain().getCodeSource().getLocation().getFile().toString();
	public static final String NORMS_FILE_ON_SERVER = locationOnServer.replaceAll("main/Constants.class", "norms.conf");
	public static final String GUI_BG_FILE_ON_SERVER = locationOnServer.replaceAll("main/Constants.class", "flow.jpg");

}
