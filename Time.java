

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {

	Date date = new Date();

	DateFormat dateFormat;
	DateFormat timeFormat;

	String s1,s2;

	String getDate() {
		dateFormat = DateFormat.getDateInstance(DateFormat.FULL, new Locale("en"));
		s1= dateFormat.format(date);
		return s1;
	}

	String getTime() {
		timeFormat = DateFormat.getTimeInstance(DateFormat.FULL, new Locale("en"));
		s2= timeFormat.format(date);
		return s2;
	}

}
