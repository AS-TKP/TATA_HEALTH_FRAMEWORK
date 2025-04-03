package tata_health_generic_FilieUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomnumber = random.nextInt(1000);
		return randomnumber;
	}

	public String getSystemDate() {
		Date dateobj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String StartDate = sdf.format(dateobj);
		return StartDate;
	}

	public String getRequiredDate(int days) {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String StartDate = sim.format(date);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String EndDate = sim.format(cal.getTime());
		return EndDate;
	}
}
