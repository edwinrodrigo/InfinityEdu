package edu.ec.infinity.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

public class DateUtils {

	public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
	/**
	 * Number of milliseconds in a standard second.
	 * 
	 * @since 2.1
	 */
	public static final long MILLIS_PER_SECOND = 1000;
	/**
	 * Number of milliseconds in a standard minute.
	 * 
	 * @since 2.1
	 */
	public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
	/**
	 * Number of milliseconds in a standard hour.
	 * 
	 * @since 2.1
	 */
	public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
	/**
	 * Number of milliseconds in a standard day.
	 * 
	 * @since 2.1
	 */
	public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

	public static final int SECONDS_PER_MINUTE = 60;
	public static final int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;
	public static final int SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;
	public static final int SECONDS_PER_WEEK = 7 * SECONDS_PER_DAY;

	/**
	 * This is half a month, so this represents whether a date is in the top or
	 * bottom half of the month.
	 */
	public final static int SEMI_MONTH = 1001;

	/**
	 * Simple time format: "HH:mm"
	 */
	public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");
	/**
	 * Simple date format: "dd-MM-yyyy"
	 */
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	/**
	 * Full timestamp (date-time) format: "yyyy-MM-dd HH:mm:ss.SSS"
	 */
	public static final DateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static final DateFormat TIMESTAMP_SHORTFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * Validate date range, considering date, month and year only (not time).
	 * Returns true in the following cases:<br />
	 * 1. acceptBothNull is true, and both startDate and endDate are null<br />
	 * 2. acceptStartNull is true, and startDate is null (endDate being not
	 * null)<br />
	 * 3. acceptEndNull is true, and endDate is null (startDate being not
	 * null)<br />
	 * 4. acceptEquals is true and areSameDateMonthYear(startDate, endDate) is
	 * true<br />
	 * 5. truncate(startDate) is before truncate(endDate)
	 * 
	 * @see #areSameDateMonthYear(Date, Date)
	 * @see #truncate(Date)
	 */
	public static boolean validateRange(Date startDate, Date endDate, boolean acceptBothNull, boolean acceptStartNull,
			boolean acceptEndNull, boolean acceptEquals) {
		if (startDate == null && endDate == null) {
			// ambas fechas son null
			return acceptBothNull;
		} else if (startDate == null) {
			// la fecha inicial es null (y la final no)
			return acceptStartNull;
		} else if (endDate == null) {
			// la fecha final es null (y la inicial no)
			return acceptEndNull;
		} else if (areSameDateMonthYear(startDate, endDate)) {
			// ambas fechas son iguales en dia, mes y anio
			return acceptEquals;
		} else {
			// orden estricto de las fechas
			return truncate(startDate).before(truncate(endDate));
		}
	}

	/**
	 * Validate date range, considering date, month and year only (not time).
	 * Returns true in the following cases:<br />
	 * 1. acceptBothNull is true, and both startDate and endDate are null<br />
	 * 2. acceptEquals is true and areSameDateMonthYear(startDate, endDate) is
	 * true<br />
	 * 3. truncate(startDate) is before truncate(endDate)
	 */
	public static boolean validateRange(Date startDate, Date endDate, boolean acceptBothNull, boolean acceptEquals) {
		return validateRange(startDate, endDate, acceptBothNull, false, false, acceptEquals);
	}

	/**
	 * Validate date range, considering date, month and year only (not time).
	 * Returns true in the following cases:<br />
	 * 1. startDate is null and endDate is not null<br />
	 * 2. truncate(startDate) is before truncate(endDate)
	 * 
	 * @see #validateRange(Date, Date, boolean, boolean, boolean, boolean)
	 */
	public static boolean startIsNullOrBeforeEnd(Date startDate, Date endDate) {
		return validateRange(startDate, endDate, false, true, false, false);
	}

	/**
	 * Validate date range, considering date, month and year only (not time).
	 * Returns true in the following cases:<br />
	 * 1. endDate is null and startDate is not null<br />
	 * 2. truncate(startDate) is before truncate(endDate)
	 * 
	 * @see #validateRange(Date, Date, boolean, boolean, boolean, boolean)
	 */
	public static boolean endIsNullOrAfterStart(Date startDate, Date endDate) {
		return validateRange(startDate, endDate, false, false, true, false);
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * @return cal.get(Calendar.YEAR)
	 */
	public static long getYear(Calendar cal) {
		return cal.get(Calendar.YEAR);
	}

	/**
	 * @return cal.get(Calendar.YEAR)
	 */
	public static long getYear(Date date) {
		return getCalendar(date).get(Calendar.YEAR);
	}

	/**
	 * @return cal.get(Calendar.MONTH) + 1
	 */
	public static long getMonth(Calendar cal) {
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * @return cal.get(Calendar.MONTH) + 1
	 */
	public static long getMonth(Date date) {
		return getCalendar(date).get(Calendar.MONTH) + 1;
	}

	/**
	 * @return cal.get(Calendar.YEAR)
	 */
	public static long getDayOfMonth(Calendar cal) {
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @return cal.get(Calendar.YEAR)
	 */
	public static long getDayOfMonth(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_MONTH);
	}

	public static Date getFirstDateMonth(Date dateFrom) {
		Calendar calFrom = Calendar.getInstance(); // fecha de hoy
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.DAY_OF_MONTH, 1); // primer dia de este mes
		return calFrom.getTime();
	}

	public static Date getFirstDateMonth() {
		return getFirstDateMonth(getCurrentDate());
	}

	public static Date getLastDateMonth(Date dateFrom) {
		Calendar calFrom = new GregorianCalendar(); // fecha de hoy
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.DAY_OF_MONTH, 1); // primer dia de este mes
		calFrom.add(Calendar.MONTH, 1); // sumar un mes
		calFrom.add(Calendar.DAY_OF_MONTH, -1); // restar un mes -> ultimo dia de este mes
		return calFrom.getTime();
	}

	public static Date getLastDateMonth() {
		return getLastDateMonth(getCurrentDate());
	}

	/**
	 * Tests for date equality based on date, month and year.
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean areSameDateMonthYear(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		return cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
	}

	public static boolean areSameDayMonth(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		return cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
	}

	public static boolean areSameHourDayMonthYear(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		return cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
				&& cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)
				&& cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
	}

	/**
	 * Tests for date equality based on month and year.
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean areSameMonthYear(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
	}

	public static boolean areSameYear(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
	}

	/**
	 * Adds a number of days to a date returning a new object. The original date
	 * object is unchanged.
	 *
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 * 
	 * @see org.apache.commons.lang.time.DateUtils#addDays(Date, int)
	 */
	public static Date addDays(Date date, long amount) {
		return org.apache.commons.lang.time.DateUtils.addDays(date, (int) amount);
	}

	/**
	 * <p>
	 * Truncate this date, leaving the field specified as the most significant
	 * field.
	 * </p>
	 *
	 * <p>
	 * For example, if you had the datetime of 28 Mar 2002 13:45:01.231, if you
	 * passed with HOUR, it would return 28 Mar 2002 13:00:00.000. If this was
	 * passed with MONTH, it would return 1 Mar 2002 0:00:00.000.
	 * </p>
	 * 
	 * @param date
	 *            the date to work with
	 * @param field
	 *            the field from <code>Calendar</code> or <code>SEMI_MONTH</code>
	 * @return the rounded date
	 * @throws IllegalArgumentException
	 *             if the date is <code>null</code>
	 * @throws ArithmeticException
	 *             if the year is over 280 million
	 * 
	 * @see org.apache.commons.lang.time.DateUtils#truncate(Date, int)
	 */
	public static Date truncate(Date date) {
		return org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DATE);
	}

	public static Date truncate(Date date, int format) {
		return org.apache.commons.lang.time.DateUtils.truncate(date, format);
	}

	/**
	 * Sets the hours field to a date returning a new object. Hours range from 0-23.
	 * The original date object is unchanged.
	 *
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to set
	 * @return a new Date object set with the specified value
	 * @throws IllegalArgumentException
	 *             if the date is null
	 * 
	 * @see org.apache.commons.lang.time.DateUtils#addHours(Date, int)
	 */
	public static Date setHours(Date date, int amount) {
		return org.apache.commons.lang.time.DateUtils.setHours(date, amount);
	}

	/**
	 * Sets the minute field to a date returning a new object. The original date
	 * object is unchanged.
	 *
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to set
	 * @return a new Date object set with the specified value
	 * @throws IllegalArgumentException
	 *             if the date is null
	 * 
	 * @see org.apache.commons.lang.time.DateUtils#setMinutes(Date, int)
	 */
	public static Date setMinutes(Date date, int amount) {
		return org.apache.commons.lang.time.DateUtils.setMinutes(date, amount);
	}

	/**
	 * Sets the seconds field to a date returning a new object. The original date
	 * object is unchanged.
	 *
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to set
	 * @return a new Date object set with the specified value
	 * @throws IllegalArgumentException
	 *             if the date is null
	 * 
	 * @see org.apache.commons.lang.time.DateUtils#setSeconds(Date, int)
	 */
	public static Date setSeconds(Date date, int amount) {
		return org.apache.commons.lang.time.DateUtils.setSeconds(date, amount);
	}

	/**
	 * @see http://www.java2s.com/Code/Java/Development-Class/DateDiffcomputethedifferencebetweentwodates.htm
	 *      fecha2 - fecha 1
	 */
	public static long getDiffDays(Date date1, Date date2) {
		// Get msec from each, and subtract.
		long diff = truncate(date2).getTime() - truncate(date1).getTime();
		return diff / MILLIS_PER_DAY;
	}

	public static String getDiffDate(Date date1, Date date2) {
		// Get msec from each, and subtract.
		Long diff = date2.getTime() - date1.getTime();
		Double daysD = ((double) diff) / (1000 * 60 * 60 * 24);
		Long daysL = (long) Math.floor(daysD);
		Double hoursD = (daysD - daysL) * 24;
		Long hoursL = (long) Math.floor(hoursD);
		Long minutes = (long) ((hoursD - hoursL) * 60);
		String value = minutes + " m.";

		if (!hoursL.equals(0L) || !minutes.equals(0L)) {
			value = hoursL + " h. " + value;
		}
		if (!daysL.equals(0L)) {
			value = daysL + " d. " + value;
		}
		return value;
	}

	/**
	 * Permite obtener la cantidad de meses que existe entre 2 fechas
	 * 
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return int
	 */
	public static final int getDiffMonths(Date fechaInicial, Date fechaFinal) {
		Calendar calInicial = new GregorianCalendar();
		calInicial.setTime(fechaInicial);
		Calendar calFinal = new GregorianCalendar();
		calFinal.setTime(fechaFinal);
		int mesInicial = (calInicial.get(Calendar.YEAR) * 12) + calInicial.get(Calendar.MONTH);
		int mesFinal = (calFinal.get(Calendar.YEAR) * 12) + calFinal.get(Calendar.MONTH);
		return mesFinal - mesInicial;
	}

	/**
	 * Permite obtener la cantidad de meses que existe entre 2 fechas
	 * 
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return String[] poicion 0 : año - poicion 1 : meses - poicion 1 : dia
	 */
	public synchronized static String[] getDiffDates(Date fechaInicio, Date fechaFin) {
		// Fecha inicio
		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(fechaInicio);
		int diaInicio = calendarInicio.get(Calendar.DAY_OF_MONTH);
		int mesInicio = calendarInicio.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
		int anioInicio = calendarInicio.get(Calendar.YEAR);

		// Fecha fin
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(fechaFin);
		int diaFin = calendarFin.get(Calendar.DAY_OF_MONTH);
		int mesFin = calendarFin.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
		int anioFin = calendarFin.get(Calendar.YEAR);

		int anios = 0;
		int mesesPorAnio = 0;
		int diasPorMes = 0;
		int diasTipoMes = 0;
		String diferencia[] = { "0", "0", "0" };

		//
		// Calculo de días del mes
		//
		if (mesInicio == 2) {
			// Febrero
			if ((anioFin % 4 == 0) && ((anioFin % 100 != 0) || (anioFin % 400 == 0))) {
				// Bisiesto
				diasTipoMes = 29;
			} else {
				// No bisiesto
				diasTipoMes = 28;
			}
		} else if (mesInicio <= 7) {
			// De Enero a Julio los meses pares tienen 30 y los impares 31
			if (mesInicio % 2 == 0) {
				diasTipoMes = 30;
			} else {
				diasTipoMes = 31;
			}
		} else if (mesInicio > 7) {
			// De Julio a Diciembre los meses pares tienen 31 y los impares 30
			if (mesInicio % 2 == 0) {
				diasTipoMes = 31;
			} else {
				diasTipoMes = 30;
			}
		}

		//
		// Calculo de diferencia de año, mes y dia
		//
		if ((anioInicio > anioFin) || (anioInicio == anioFin && mesInicio > mesFin)
				|| (anioInicio == anioFin && mesInicio == mesFin && diaInicio > diaFin)) {
			return diferencia;
		} else {
			if (mesInicio <= mesFin) {
				anios = anioFin - anioInicio;
				if (diaInicio <= diaFin) {
					mesesPorAnio = mesFin - mesInicio;
					diasPorMes = diaFin - diaInicio;
				} else {
					if (mesFin == mesInicio) {
						anios = anios - 1;
					}
					mesesPorAnio = (mesFin - mesInicio - 1 + 12) % 12;
					diasPorMes = diasTipoMes - (diaInicio - diaFin);
				}
			} else {
				anios = anioFin - anioInicio - 1;
				System.out.println(anios);
				if (diaInicio > diaFin) {
					mesesPorAnio = mesFin - mesInicio - 1 + 12;
					diasPorMes = diasTipoMes - (diaInicio - diaFin);
				} else {
					mesesPorAnio = mesFin - mesInicio + 12;
					diasPorMes = diaFin - diaInicio;
				}
			}
		}

		diferencia[0] = String.valueOf(anios);
		diferencia[1] = String.valueOf(mesesPorAnio);
		diferencia[2] = String.valueOf(diasPorMes);
		return diferencia;

	}/* getDiffDates */

	/**
	 * Adds a number of months to a date returning a new object. The original date
	 * object is unchanged.
	 *
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 * 
	 * @see org.apache.commons.lang.time.DateUtils#addMonths(Date, int)
	 */
	public static Date addMonths(Date date, long amount) {
		return org.apache.commons.lang.time.DateUtils.addMonths(date, (int) amount);
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @since 2009-09-02
	 */
	public static Date getRoundedTime(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int round = Math.round((float) calendar.get(Calendar.MINUTE) / 30);
		calendar.set(Calendar.MINUTE, round == 2 ? 0 : round * 30);
		if (round == 2)
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param dayOfWeekDate
	 * @param weekStartDate
	 * @return
	 */
	public static Date getDateFromWeek(Date dayOfWeekDate, Date weekStartDate) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dayOfWeekDate);
		return getDateFromWeek(cal.get(Calendar.DAY_OF_WEEK), weekStartDate);
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @since 2009-09-02
	 */
	public static String getFormattedRoundedTime(Date date) {
		return getFormattedTime(getRoundedTime(date));
	}

	/**
	 * 
	 * @return
	 * @since 2012-02-26
	 */
	public static String getFormattedTime() {
		return getFormattedTime(getCurrentDate());
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @since 2010-05-26
	 */
	public static String getFormattedTime(Date date) {
		return getFormattedDate(date, TIME_FORMAT);
	}

	/**
	 * 
	 * @return
	 * @since 2012-12-02
	 */
	public static String getFormattedTimestamp() {
		return getFormattedTimestamp(getCurrentDate());
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @since 2012-12-02
	 */
	public static String getFormattedTimestamp(Date date) {
		return getFormattedDate(date, TIMESTAMP_FORMAT);
	}

	public static String getFormattedShortTime(Date date) {
		return getFormattedDate(date, TIMESTAMP_SHORTFORMAT);
	}

	/**
	 * 
	 * @return current date formatted as "dd-MM-yyyy"
	 * @since 2012-02-02
	 * @see #DATE_FORMAT
	 * @see #getFormattedDate(Date, DateFormat)
	 */
	public static String getFormattedDate() {
		return getFormattedDate(getCurrentDate(), DATE_FORMAT);
	}

	/**
	 * 
	 * @param date
	 * @return date formatted as "dd-MM-yyyy"
	 * @since 2012-02-02
	 * @see #DATE_FORMAT
	 * @see #getFormattedDate(Date, DateFormat)
	 */
	public static String getFormattedDate(Date date) {
		return getFormattedDate(date, DATE_FORMAT);
	}

	/**
	 * 
	 * @param pattern
	 * @return current date formatted with given pattern
	 * @since 2012-04-25
	 * @see SimpleDateFormat
	 * @see #getFormattedDate(Date, DateFormat)
	 */
	public static String getFormattedDate(String pattern) {
		return getFormattedDate(getCurrentDate(), new SimpleDateFormat(pattern));
	}

	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return date formatted with given pattern
	 * @since 2009-09-02
	 * @see SimpleDateFormat
	 * @see #getFormattedDate(Date, DateFormat)
	 */
	public static String getFormattedDate(Date date, String pattern) {
		return getFormattedDate(date, new SimpleDateFormat(pattern));
	}

	/**
	 * 
	 * @param date
	 * @param dateFormat
	 * @return date formatted with given format
	 * @since 2012-02-02
	 */
	public static String getFormattedDate(Date date, DateFormat dateFormat) {
		if (date == null || dateFormat == null) {
			return StringUtils.EMPTY;
		}
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return date parsed as "dd-MM-yyyy"
	 * @since 2012-04-25
	 * @see #DATE_FORMAT
	 * @see #getFormattedDate(Date, DateFormat)
	 */
	public static Date getParsedDate(String date) {
		return getParsedDate(date, DATE_FORMAT);
	}

	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @since 2012-04-25
	 */
	public static Date getParsedDate(String date, String pattern) {
		return getParsedDate(date, new SimpleDateFormat(pattern));
	}

	/**
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 * @since 2012-04-25
	 */
	public static Date getParsedDate(String date, DateFormat dateFormat) {
		if (StringUtils.isBlank(date) || dateFormat == null) {
			return null;
		}
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 * @since 2012-04-25
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 
	 * @param date
	 * @param weekStartDate
	 * @return
	 */
	public static Date getDateFromWeek(int dayOfWeek, Date weekStartDate) {
		Calendar fixedCal = new GregorianCalendar();
		fixedCal.setTime(weekStartDate);
		while (fixedCal.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
			fixedCal.add(Calendar.DATE, 1);
		}
		return fixedCal.getTime();
	}

	/**
	 * Tests for date equality based on month and year.
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean areSameMonthYearOrLeast(Date date1, Date date2) {
		boolean condition = false;
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		condition = cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		if (!condition) {
			int anio1 = cal1.get(Calendar.YEAR);
			int anio2 = cal2.get(Calendar.YEAR);
			int mes1 = cal1.get(Calendar.MONTH);
			int mes2 = cal2.get(Calendar.MONTH);
			if (anio1 >= anio2) {
				if (anio1 > anio2) {
					condition = true;
				} else {
					if (mes1 >= mes2) {
						condition = true;
					}
				}
			}
		}
		return condition;
	}

	public static Date getFirstDateYear(Date dateFrom) {
		Calendar calFrom = Calendar.getInstance(); // fecha de hoy
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.DAY_OF_YEAR, 1); // primer dia de este anio
		return calFrom.getTime();
	}

	/**
	 * month boundaries crossed between dates
	 * 
	 * @param minuend
	 * @param subtrahend
	 * @return
	 * @see http://www.coderanch.com/t/381676/java/java/number-months-between-two-given
	 */
	public static int monthsBetween(Date minuend, Date subtrahend) {
		Calendar cal = Calendar.getInstance();
		// default will be Gregorian in US Locales
		cal.setTime(minuend);
		int minuendMonth = cal.get(Calendar.MONTH);
		int minuendYear = cal.get(Calendar.YEAR);
		cal.setTime(subtrahend);
		int subtrahendMonth = cal.get(Calendar.MONTH);
		int subtrahendYear = cal.get(Calendar.YEAR);

		// the following will work okay for Gregorian but will not
		// work correctly in a Calendar where the number of months
		// in a year is not constant
		return ((minuendYear - subtrahendYear) * cal.getMaximum(Calendar.MONTH)) + (minuendMonth - subtrahendMonth);
	}

	/**
	 * numero de dias entre dos fechas
	 * 
	 * @param fechaIni
	 * @param fecha2
	 * @return
	 */
	public static long daysBetween(Date fechaIni, Date fechaFin) {
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; // Milisegundos al dia
		return ((fechaFin.getTime() - fechaIni.getTime()) / MILLSECS_PER_DAY);
	}

	/**
	 * 
	 * @param fechaIni
	 *            : Fecha inicial
	 * @param fechaFin
	 *            : Fecha final
	 * @return the value 0 if the argument fechaFin is equal to this fechaIni; a
	 *         value less than 0 if this fechaIni is before the Date fechaFin; and a
	 *         value greater than 0 if this fechaIni is after the Date fechaFin.
	 */
	public static int compareTo(Date fechaIni, Date fechaFin) {
		String fechaIniS = DateUtils.getFormattedDate(fechaIni);
		String fechaFinS = DateUtils.getFormattedDate(fechaFin);
		Date fechaIniFormat = DateUtils.getParsedDate(fechaIniS);
		Date fechaFinFormat = DateUtils.getParsedDate(fechaFinS);

		return fechaIniFormat.compareTo(fechaFinFormat);
	}

	/**
	 * Metodo que convierte un String a Date
	 * 
	 * @param fecha
	 * @return
	 */
	public static Date convertStringToDate(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String strFecha = fecha;
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(strFecha);
			return fechaDate;
		} catch (ParseException ex) {
			ex.printStackTrace();
			return fechaDate;
		}
	}

	/**
	 * Metodo que retorna en tipo Long el anio actual
	 * 
	 * @return
	 */
	public static Long currentYear() {
		Calendar calendar = getCalendar(getCurrentDate());
		return getYear(calendar);
	}

	/**
	 * Metodo que retorna en tipo Long el mes actual
	 * 
	 * @return
	 */
	public static Long currentMonth() {
		Calendar calendar = getCalendar(getCurrentDate());
		return getMonth(calendar);
	}

	/**
	 * Se considera la primera semana de un anio (semana W01) aquella que contiene
	 * el primer jueves de dicho anio, o lo que es lo mismo, aquella que contiene el
	 * dia 4 de enero. Los dias de la semana se representan numericamente con un
	 * digito, siendo el primero dia el lunes (dia 1) y el ultimo el domingo (dia
	 * 7). La semana empieza siempre, por tanto, en lunes.
	 * 
	 * @return
	 */
	public static Integer getNumeroSemana(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setMinimalDaysInFirstWeek(4);
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * Metodo que obtiene el nombre del dia de la semana
	 * 
	 * @return
	 */
//	public static String getDiaSemana(Date date) {
//		GregorianCalendar cal = new GregorianCalendar();
//		cal.setTime(date);
//		int numeroDia = cal.get(Calendar.DAY_OF_WEEK);
//		String dia;
//		switch (numeroDia) {
//		case 1:
//			dia = GenericDTO.FIELD_DOMINGO;
//			break;
//		case 2:
//			dia = GenericDTO.FIELD_LUNES;
//			break;
//		case 3:
//			dia = GenericDTO.FIELD_MARTES;
//			break;
//		case 4:
//			dia = GenericDTO.FIELD_MIERCOLES;
//			break;
//		case 5:
//			dia = GenericDTO.FIELD_JUEVES;
//			break;
//		case 6:
//			dia = GenericDTO.FIELD_VIERNES;
//			break;
//		case 7:
//			dia = GenericDTO.FIELD_SABADO;
//			break;
//		default:
//			dia = null;
//			break;
//		}
//		return dia;
//	}

	/**
	 * Metodo que obtiene el codigo del dia de la semana
	 * 
	 * @return
	 */
//	public static String getCodigoDiaSemana(Date date) {
//		GregorianCalendar cal = new GregorianCalendar();
//		cal.setTime(date);
//		int numeroDia = cal.get(Calendar.DAY_OF_WEEK);
//		String codDia;
//		switch (numeroDia) {
//		case 1:
//			codDia = GenericDTO.FIELD_DOM;
//			break;
//		case 2:
//			codDia = GenericDTO.FIELD_LUN;
//			break;
//		case 3:
//			codDia = GenericDTO.FIELD_MAR;
//			break;
//		case 4:
//			codDia = GenericDTO.FIELD_MIE;
//			break;
//		case 5:
//			codDia = GenericDTO.FIELD_JUE;
//			break;
//		case 6:
//			codDia = GenericDTO.FIELD_VIE;
//			break;
//		case 7:
//			codDia = GenericDTO.FIELD_SAB;
//			break;
//		default:
//			codDia = null;
//			break;
//		}
//		return codDia;
//	}

}
