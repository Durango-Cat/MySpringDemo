package main.java.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * 系统时间操作、获取工具类
 */
public final class TimesUtils {

	public static final int SECOND_IN_MINUTE = 60, SECOND_IN_HOUR = SECOND_IN_MINUTE * 60,
			SECOND_IN_10_MINUTE = SECOND_IN_MINUTE * 10, SECOND_IN_20_MINUTE = SECOND_IN_MINUTE * 20,
			SECOND_IN_30_MINUTE = SECOND_IN_MINUTE * 30,SECOND_IN_DAY = SECOND_IN_HOUR * 24,
			SECOND_IN_MONTH = SECOND_IN_DAY * 30, SECOND_IN_YEAR = SECOND_IN_MONTH * 12, DAYS_IN_WEEK = 7;

	private TimesUtils() {
	}

	/**
	 * @return UNIX timestamp(ms).
	 */
	public static long getUTCTimestampOnMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * @return UNIX timestamp(s).
	 */
	public static int getUTCTimestampOnSec() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	/**
	 * Get the UNIX epoch with milliseconds of the provided millisecond
	 * timestamp
	 *
	 * @param timestamp
	 *            a millisecond timestamp (milliseconds since UNIX epoch)
	 * @return The current UTC UNIX timestamp with milliseconds.
	 */
	public static double getUTCTimestampWithMilliseconds(long timestamp) {
		return timestamp / 1000.0;
	}

	/**
	 * @return 获取当前时刻的整点分钟数的Timestamp
	 */
	public static int getUTCTimestampOnMinute() {
		int ret = getUTCTimestampOnSec();
		ret -= ret % TimesUtils.SECOND_IN_MINUTE;
		return ret;
	}

	/**
	 * @return 以当前时间提前 x 分钟作为计算的结束时间（取整点分钟数）
	 */
	public static int getWholePointCalculationPointOnSec() {
		int ret = getUTCTimestampOnSec();
		ret = ret - ret % TimesUtils.SECOND_IN_MINUTE - 300;
		return ret;
	}

	/**
	 * @return 以当前时间提前 x 分钟作为计算的结束时间
	 */
	public static int getCalculationPointOnSec() {
		int ret = getUTCTimestampOnSec();
		ret = ret - 300;
		return ret;
	}

	/**
	 * @return 获取当天所在的 00:00 点时刻的时间
	 */
	public static int getUTCTimestampOnDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return (int) (calendar.getTimeInMillis() / 1000);
	}

	/**
	 * @param timestamp
	 *            timestamp
	 * @return 获取当前时间的整数分钟时间戳
	 */
	public static int getUTCTimestampOnMinute(int timestamp) {
		return timestamp - timestamp % TimesUtils.SECOND_IN_MINUTE;
	}

	/**
	 * 获取当前时刻在当天的分钟数
	 *
	 * @return minute of day.
	 */
	public static int getMinuteOfDay(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
	}

	/**
	 * @return 获取当前时刻在当天的秒数
	 */
	public static int getSecondsOfDay(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		return getMinuteOfDay(cal) * 60 + cal.get(Calendar.SECOND);
	}

	public static void main(String[] args) {

		// String s = "<a name=\"covered_26\">Rule <!-- exportTextBegin
		// --></a><a href=" +
		// "\"https://192.168.1.187/afa/session-eebeaf5710a70ac4b7051fbd387ecda0/firewalls/afa-1638/orig_rules.html?"
		// +
		// "row=rule_26\">26</a> is covered by rule <a href=\"" +
		// "https://192.168.1.187/afa/session-eebeaf5710a70ac4b7051fbd387ecda0/firewalls/afa-1638/orig_rules.html?"
		// +
		// "row=rule_24\">24</a><!-- exportTextEnd -->. <br><br>";
		// String st = ">(\\w*)</a>\\s*is covered by rule\\s*<a.*>(\\w*)</a>";
		//
		// Pattern pattern = Pattern.compile(st);
		// final Matcher matcher = pattern.matcher(s);
		// while (matcher.find()) {
		// System.out.println(matcher.group(1));
		// System.out.println(matcher.group(2));
		// }

		// FastDateFormat DATE_TIME_FORMAT =
		// FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss",
		// Locale.CHINA);
		//
		// int v1 = getWholePointCalculationPointOnSec();
		// System.out.println(v1+"\t"+DATE_TIME_FORMAT.format(v1*1000L));
		//
		// int timeOffset = BaselineService.getCurrentRound(v1, "day", 300);
		// System.out.println(timeOffset);

	}
    public static FastDateFormat DATE_TIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
	/**
	 * @return 获取时间戳的格式化字符串
	 */
	public static String getFormattedDateTime() {
        /**
         * yyyy-MM-dd HH:mm:ss
         */

		return DATE_TIME_FORMAT.format(Calendar.getInstance());
	}

	/**
	 * @param datetime
	 *            datetime(s)
	 * @return 获取时间戳的格式化字符串
	 */
	public static String getFormattedDateTimeOnDebug(int datetime) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(datetime * 1000L);
		return DATE_TIME_FORMAT.format(cal);
	}

	/**
	 * @param date1
	 *            date1
	 * @param date2
	 *            date2
	 * @return 获取两个时间的差
	 */
	public static double getTimeGap(Date date1, Date date2) {
		return date2.getTime() - date1.getTime();
	}

}
