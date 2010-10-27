package org.xmlcml.euclid;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
/**
 * really just to remember at this stage
 * @author pm286
 *
 */
public class JodaDate {

// from W3C                                         2000-01-12T12:13:14Z
    private static final String DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZZ";
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATETIME_PATTERN);

    private static final String ZULU_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z";
    private static final DateTimeFormatter ZULU_FORMATTER = DateTimeFormat.forPattern(ZULU_DATETIME_PATTERN);


    public static String formatDate(DateTime datetime) {
        if (DateTimeZone.UTC.equals(datetime.getZone())) {
            return ZULU_FORMATTER.print(datetime);
        } else {
            return DATETIME_FORMATTER.print(datetime);
        }
    }
    
	public static String formatIsoDate(DateTime datetime) {
	    return ISODateTimeFormat.dateTime().print(datetime);
	}

    public static DateTime parseDate(String s) {
        if (s.endsWith("Z")) {
            MutableDateTime dateTime = ZULU_FORMATTER.parseMutableDateTime(s);
            dateTime.setZone(DateTimeZone.UTC);
            return dateTime.toDateTime();
        } else {
            return DATETIME_FORMATTER.parseDateTime(s);
        }
    }

    public static DateTime parseDate(String date, String format) {
	    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        MutableDateTime dateTime = dateTimeFormatter.parseMutableDateTime(date);
        return dateTime.toDateTime();
    }

    public static DateTime parseJavaDate(Date javaDate) {
    	long seconds = javaDate.getTime();
    	return new DateTime(seconds);
    }

    public static Date parseJodaDate(DateTime jodaDate) {
    	int year = jodaDate.getYear();
    	int month = jodaDate.getMonthOfYear();
    	int day = jodaDate.getDayOfMonth();
    	int hour = jodaDate.getHourOfDay();
    	int min = jodaDate.getMinuteOfDay();
    	int sec = jodaDate.getSecondOfMinute();
    	// arghh
    	Date date = new Date(year-1900, month, day, hour, min, sec);
    	return date;
    }


}
