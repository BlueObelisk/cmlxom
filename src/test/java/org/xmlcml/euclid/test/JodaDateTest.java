package org.xmlcml.euclid.test;

import java.util.Date;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.xmlcml.euclid.JodaDate;

public class JodaDateTest {
	
	@Test
    public void testFormatDate() {
		DateTime datetime = new DateTime(1288135627973L);
		String dateTimeString = JodaDate.formatIsoDate(datetime);
		Assert.assertEquals("date string", "2010-10-27T00:27:07.973+01:00", dateTimeString);
    }

	@Test
    public void testParseDate() {
        DateTime dateTime = JodaDate.parseDate("2010-10-27T00:27:07+01:00");
		Assert.assertEquals("date millis", 1288135627000L, dateTime.getMillis());
    }

	@Test
    public void testParseDate1() {
        DateTime dateTime = JodaDate.parseDate("25/12/1984", "dd/mm/yyyy");
		Assert.assertEquals("date format", 443837520000L, dateTime.getMillis());
    }

	@Test
    public void testParseJavaDate() {
    	Date date = new Date(2001-1900, 12, 25, 10, 20, 30);
    	Assert.assertNotNull(date);
        DateTime dateTime = JodaDate.parseJavaDate(date);
    	Assert.assertNotNull(dateTime);
		Assert.assertEquals("date to datetime", 1011954030000L, dateTime.getMillis());
    }

	@Test
    public void testParseJodaDate() {
    	DateTime dateTime = new DateTime(1288135627000L);
        Date date = JodaDate.parseJodaDate(dateTime);
		Assert.assertEquals("datetime to date", "Sat Nov 27 00:27:07 GMT 2010", date.toString());
    }

}
