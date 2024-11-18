package genericLibrary;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	public static int getRandomNumber() {
		return new Random().nextInt(9999);
	}
	
	public static String getTimeStamp() {
		return LocalDateTime.now().toString().replace(":", "-");
	}

}
