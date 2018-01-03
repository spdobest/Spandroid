package spandroid.dev.utils;

import android.text.TextUtils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.YearMonth;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by root on 1/2/18.
 */

public class JodaDateUtils {

    private static String TAG = "JodaDateUtils";

    public static String getMonthFromDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("dd-MM-yyyy").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MMM");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedDateForExpenseChart(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("yyyy-MM-dd");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedDateForMFNFO(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy/MM/dd").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd/MMM/yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedDateForMFNFOLumsumUser(String strDate) {

        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("yyyy/MM/dd");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedLFOrderBook(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd/MM/yyyy hh:mm:ss aa");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedLFOrderBookNewOnlyDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd MMM yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedLFOrderBookNewOnlyTime(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("hh:mm:ss aa");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedDateForNAV(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("dd/MMMM/yyyy").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("ddMMMyyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd/MMM/yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getTimeStampForBeewise() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            e.printStackTrace( );
        }

        return currentMonthYear;
    }

    public static String getCurrentDateForComparison() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            e.printStackTrace( );
        }

        return currentMonthYear;
    }

    public static String getDayFromDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    /**
     * 
     * @param date
     * @return
     */
   /* public static Dob getDobFromDateForFacebook(String strDate) {
        Dob dob = new Dob();
        DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("MM/dd/yyyy").withLocale(Locale.ENGLISH));

        String day = "";
        String month = "";
        String year = "";

        try {
            day = dt.toString("dd");
            month = dt.toString("MM");
            year = dt.toString("yyyy");
            dob.setDay(day);
            dob.setMonth(month);
            dob.setYear(year);
        } catch (Exception ex) {

        }
        return dob;
    }

    public static Dob getDobFromDate(String strDate) {

        Dob dob = new Dob();
        DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("dd-MM-yyyy").withLocale(Locale.ENGLISH));

        String day = "";
        String month = "";
        String year = "";

        try {
            day = dt.toString("dd");
            month = dt.toString("MM");
            year = dt.toString("yyyy");
            dob.setDay(day);
            dob.setMonth(month);
            dob.setYear(year);
        } catch (Exception ex) {

        }
        return dob;
    }
*/
    public static LocalDateTime getJodaDateTimeFromString(String date) {
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (IllegalArgumentException e) {
            localDateTime = LocalDateTime.parse(date, DateTimeFormat.forPattern("YYYY-MM-dd"));
        }

        return localDateTime;
    }

    public static String getTimeStampForSocket() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String timeStamp = localDateTime.getHourOfDay() + ":" + localDateTime.getMinuteOfHour() + ":" + localDateTime.getSecondOfMinute();
        return timeStamp;
    }

    public static int getCurrentJodaDay() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.getDayOfMonth();
    }

    public static String getCurrentJodaMonthFirstDate() {
        DateTime dateTime = new DateTime().dayOfMonth().withMinimumValue().withTimeAtStartOfDay();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.print(dateTime);
    }

    public static String getCurrentJodaYearFirstDate() {
        DateTime dateTime = new DateTime().dayOfYear().withMinimumValue().withTimeAtStartOfDay();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.print(dateTime);
    }

    public static String getCurrentJodaMonthCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.print(localDateTime);
    }

    public static int getCurrentJodaYear() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.getYear();
    }

    public static String getPreviousDateYears(int years) {
        LocalDate localDate = new DateTime().minusYears(years).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
        return localDate.toString(fmt);
    }

    /**
     * @param date  string date e.g."28-05-1991"
     * @param years no.of years to add in date.
     * @return
     */
    public static String getNextDateYears(String date, int years) {
        DateTime dateTime = DateTimeFormat.forPattern("dd-MM-yyyy").parseDateTime(date);
        LocalDate localDate = dateTime.plusYears(years).toLocalDate();
        return localDate.toString();
    }


    public static String getOneMonthPreviousDate() {
        LocalDate localDate = new DateTime().minusMonths(1).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MMM");
        return localDate.toString(fmt);
    }


    public static String getOneMonthPrevious25Date() {
        DateTime dateTime25th = new DateTime().minusMonths(1).withDayOfMonth(25).withTimeAtStartOfDay();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.print(dateTime25th);
    }

    public static String getCurrentMonth24Date() {
        DateTime dateTime24th = endOfHour(endOfDay(new DateTime().withDayOfMonth(24)));
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.print(dateTime24th);
    }


    public static String getCurrentJodaDate() {
        LocalDate localDate = new LocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MMM");
        String str = localDate.toString(fmt);
        return str;
    }

    public static String getCurrentJodaMonthString() {
        LocalDate localDate = new LocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("MMM yyyy");
        String str = localDate.toString(fmt);
        return str;
    }

    public static String getOneMonthPreviousDateForBeeWise() {
        LocalDate localDate = new DateTime().minusMonths(1).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        return localDate.toString(fmt);
    }

    public static String getTwoMonthPreviousDateForBeeWise() {
        LocalDate localDate = new DateTime().minusMonths(2).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        return localDate.toString(fmt);
    }

    public static String getThreeMonthPreviousDateForBeeWise() {
        LocalDate localDate = new DateTime().minusMonths(3).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        return localDate.toString(fmt);
    }

    public static String getDaysPreviousDateForBeeWise(int days) {
        LocalDate localDate = new DateTime().minusDays(days).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        return localDate.toString(fmt);
    }

    public static String getMonthsPreviousDateForBeeWise(int months) {
        LocalDate localDate = new DateTime().minusMonths(months).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        return localDate.toString(fmt);
    }

    public static long getTimeBefore(int days) {
        return new DateTime().minusDays(days).getMillis();
    }

    public static String getCurrentJodaDateForBeeWise() {
        LocalDate localDate = new LocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        String str = localDate.toString(fmt);
        return str;
    }

    public static String getCurrentJodaDateWithoutYear() {
        LocalDate localDate = new LocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("MM-dd");
        String str = localDate.toString(fmt);
        return str;
    }

    public static String getCurrentDate() {
        DateTime dateTime25th = new DateTime(System.currentTimeMillis() + 60000);
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
        return dtf.print(dateTime25th);
    }

    public static Date getCurrentDateTimeInDateFormat() {
        return new Date(System.currentTimeMillis());
    }

    public static long getTime(String date) {
        DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(date);
        return dateTime.getMillis();
    }

    public static long getTimeForSelectedDate(String timeStamp) {
        DateTime dateTime = DateTimeFormat.forPattern("dd-MM-yyyy").parseDateTime(timeStamp);
        return dateTime.getMillis();
    }

    public static String getDateTimeFormat(String dateTime) {
        if (TextUtils.isEmpty(dateTime) == false) {
            int indexOfopenBrace = dateTime.indexOf("(");
            int indexOfplus = dateTime.indexOf("+");

            if (indexOfopenBrace != -1 && indexOfplus != -1 && indexOfopenBrace < indexOfplus) {
                String subString = dateTime.substring(indexOfopenBrace + 1, indexOfplus);
                String foramttedDate = getDate(ObjectUtils.getLongFromString(subString));

                if (!TextUtils.isEmpty(foramttedDate)) {
                    String convertedDate = "";

                    try {
                        DateTime dt = DateTime.parse(foramttedDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
                        convertedDate = dt.toString("dd MMM yyyy");
                    } catch (Exception ex) {
                        ex.printStackTrace( );
                    }

                    return convertedDate;
                }
            }
        }
        return "";
    }

    public static String getDateTime(String dateTime) {
        if (TextUtils.isEmpty(dateTime) == false) {
            int indexOfopenBrace = dateTime.indexOf("(");
            int indexOfplus = dateTime.indexOf("+");

            if (indexOfopenBrace != -1 && indexOfplus != -1 && indexOfopenBrace < indexOfplus) {
                String subString = dateTime.substring(indexOfopenBrace + 1, indexOfplus);
                String foramttedDate = getDate(ObjectUtils.getLongFromString(subString));

                if (!TextUtils.isEmpty(foramttedDate)) {
                    String convertedDate = "";

                    try {
                        DateTime dt = DateTime.parse(foramttedDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
                        convertedDate = dt.toString("dd-MMM-yyyy HH:mm");
                    } catch (Exception ex) {
                        ex.printStackTrace( );
                    }

                    return convertedDate;
                }
            }
        }
        return "";
    }

    public static String getDateTimeForMF(String dateTime) {
        if (TextUtils.isEmpty(dateTime) == false) {
            int indexOfopenBrace = dateTime.indexOf("(");
            int indexOfplus = dateTime.indexOf("+");

            if (indexOfopenBrace != -1 && indexOfplus != -1 && indexOfopenBrace < indexOfplus) {
                String subString = dateTime.substring(indexOfopenBrace + 1, indexOfplus);
                String foramttedDate = getDate(ObjectUtils.getLongFromString(subString));

                if (!TextUtils.isEmpty(foramttedDate)) {
                    String convertedDate = "";

                    try {
                        DateTime dt = DateTime.parse(foramttedDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
                        convertedDate = dt.toString("ddMMMyyyy HH:mm");
                    } catch (Exception ex) {
                        ex.printStackTrace( );
                    }

                    return convertedDate;
                }
            }
        }
        return "";
    }

    public static String getDate(long timeInMilliseconds) {
        DateTime dateTime = new DateTime(timeInMilliseconds);
        return dateTime.toString("yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDateWithoutSeconds(long timeInMilliseconds) {
        Date date = new Date();
        date.setTime(timeInMilliseconds);
        return date;
    }

    public static String getConvertedDateWithDash(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("dd-MM-yyyy").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("yyyy-MM-dd");
        } catch (Exception ex) {
            ex.printStackTrace(  );
        }

        return convertedDate;
    }

    public static String getTimeFromDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("M/d/yyyy hh:mm:ss aa").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("HH:mm");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getCutOffTimeForLumsum(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("HH:mm");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }


    public static String getConvertedDateForArqRecomm(String strDate) {
        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            String convertedDate = dt.toString("dd-MMM-yyyy");
            return convertedDate;
        } catch (Exception e) {
            e.printStackTrace( );
        }
        return "";
    }


    public static String getConvertedDateForArqRecommNew(String strDate) {
        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            String convertedDate = dt.toString("dd MMM yyyy");
            return convertedDate;
        } catch (Exception e) {
            e.printStackTrace( );
        }
        return "";
    }


    public static String getTimeFromDateV2(String strDate) {
        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss a").withLocale(Locale.ENGLISH));
            String convertedDate = dt.toString("HH:mm");
            return convertedDate;
        } catch (Exception e) {
            e.printStackTrace( );
        }
        return "";
    }

    public static String getCurrentDateForQuote() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return currentMonthYear;
    }

    public static String getNavDate(String strDate) {
        try {
            String date = strDate.substring(0, strDate.indexOf(" "));
            String convertedDate = date.replace("/", " ");
            return convertedDate;
        } catch (Exception e) {
            e.printStackTrace( );
        }
        return "";
    }


    public static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }

    /**
     * To get Date in "MMMM YYYY" format (Ex: April 2017)
     *
     * @param  
     * @return currentMonthYear
     */
    public static String getCurrentMonthYear() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("MMMM yyyy");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }
        return currentMonthYear;
    }

    public static String getCurrentMonthandYear() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("MMM yyyy");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentMonthYear;
    }

    public static String getCurrentMonth() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("MMM");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentMonthYear;
    }

    public static String getMonthandYear(String datestr) {
        String currentMonthYear = "";

        try {

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);
            Date date = df.parse(datestr);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy", Locale.ROOT);
            currentMonthYear = simpleDateFormat.format(date.getTime());
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }
        return currentMonthYear;
    }


    /**
     * @return Remaining day's in current month
     */
    public static int getDaysLeftInMonth() {
        Calendar cal = Calendar.getInstance();
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days - cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Date[] getDaysOfWeek(Date refDate, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(refDate);
        calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
        Date[] daysOfWeek = new Date[7];

        for (int i = 0; i < 7; i++) {
            daysOfWeek[i] = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        return daysOfWeek;
    }


    public static String getCurrentMonth(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MMM");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    /**
     * To get Date in "MMMM dd" format (Ex: April 01)
     *
     * @param date
     * @return currentDayOfMonth
     */
    public static String getCurrentDayOfMonth(Date date) {
        String currentDayOfMonth = "";

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd", Locale.ROOT);
            //simpleDateFormat.setCalendar(calendar);
            currentDayOfMonth = simpleDateFormat.format(calendar.getTime());
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }
        return currentDayOfMonth;
    }

    public static long getDifferenceBetweenDates(String mReminderDate) {
        DateTime dateTime = DateTimeFormat.forPattern("dd-MM-yyyy").parseDateTime(mReminderDate);
        long longRemindeDate = dateTime.getMillis();
        long longCurrentDate = new DateTime().getMillis();
        long diff = longRemindeDate - longCurrentDate;
        long dayDifference = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return dayDifference;
    }

    public static String getDayMonthFromDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd MMM");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getDayMonthYearFromDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd MMM yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getMonthDayFromDate(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MMMM dd");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getConvertedDateForFilter(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd-MM-yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static boolean isBetweenDates(String startDate, String endDate, String transactionDate) {
        boolean isInbetweenDates = false;
        Date dateStart;
        Date dateEnd;
        Date dateTransaction;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);
            String transDate = getConvertedDateForFilter(transactionDate);
            dateTransaction = sdf.parse(transDate);

            if (TextUtils.isEmpty(startDate) && TextUtils.isEmpty(endDate)) {
                isInbetweenDates = true;
            } else if (TextUtils.isEmpty(startDate)) {
                dateEnd = sdf.parse(endDate);
                if (dateTransaction.before(dateEnd)) {
                    isInbetweenDates = true;
                } else {
                    if (dateTransaction.toString().equalsIgnoreCase(dateEnd.toString())) {
                        isInbetweenDates = true;
                    }
                }
            } else if (TextUtils.isEmpty(endDate)) {
                dateStart = sdf.parse(startDate);
                if (dateTransaction.after(dateStart)) {
                    isInbetweenDates = true;
                } else {
                    if (dateTransaction.toString().equalsIgnoreCase(dateStart.toString())) {
                        isInbetweenDates = true;
                    }
                }
            } else {

                dateStart = sdf.parse(startDate);
                dateEnd = sdf.parse(endDate);
                if (dateTransaction.after(dateStart) && dateTransaction.before(dateEnd)) {
                    isInbetweenDates = true;
                } else {
                    if (dateTransaction.toString().equalsIgnoreCase(dateStart.toString()) || dateTransaction.toString().equalsIgnoreCase(dateEnd.toString())) {
                        isInbetweenDates = true;
                    }
                }
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return isInbetweenDates;
    }

    public static String getCurrentMonthFromDDMMYYYYFormat(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("dd-mm-yyyy").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MMM");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    /*public static int weeekOfTheMonth(String date){


        String input = "20130507";
        String format = "yyyyMMdd";

        SimpleDateFormat df = new SimpleDateFormat(format, Locale.ROOT);
        Date date = df.parse(input);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_MONTH);


        Calendar ca1 = Calendar.getInstance();
        ca1.set(2012, Calendar.SEPTEMBER, 20);
        ca1.setMinimalDaysInFirstWeek(1);
        int wk = ca1.get(Calendar.WEEK_OF_MONTH);
        System.out.println("Week of Month :" + wk);
    }*/

    /**
     * To get Date in "MMMM dd" format (Ex: April 01)
     *
     * @param  
     * @return currentDayOfMonth
     */
    public static String getCurrentDayOfMonthForGraph(String day) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(day, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MMMM dd");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }


    public static String getDateIn_dd_MMMFormat(String inputDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(inputDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd MMM");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getMonthNumber(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MM");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getPreviousJodaYearFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -182); // to get previous year add -1
        Date nextYear = cal.getTime();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String date4th = originalFormat.format(cal.getTime());
        return date4th;
    }

    public static String getSixMonthsBackFromCurrentDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -6); // to get previous year add -1
        Date nextYear = cal.getTime();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String date4th = originalFormat.format(cal.getTime());
        return date4th;
    }

    public static List<Integer> getMonthsNumberBetween2Dates(String date2, String date1) {

        List<Integer> listMonthsNumber = new ArrayList<>();

        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

        Calendar beginCalendar = Calendar.getInstance();
        Calendar finishCalendar = Calendar.getInstance();

        try {
            beginCalendar.setTime(formater.parse(date1));
            finishCalendar.setTime(formater.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        beginCalendar.add(Calendar.MONTH, 1);

        while (beginCalendar.before(finishCalendar)) {
            // add one month to date per loop
            String date = formater.format(beginCalendar.getTime()).toUpperCase();
//            System.out.println("My Dates " + date);
            listMonthsNumber.add(ObjectUtils.getIntFromString(getMonthNumber(date)));
            beginCalendar.add(Calendar.MONTH, 1);
        }
        listMonthsNumber.remove(0);
        String date = formater.format(beginCalendar.getTime()).toUpperCase();
//        System.out.println("My Dates 123" + date);
        listMonthsNumber.add(ObjectUtils.getIntFromString(getMonthNumber(date)));


        return listMonthsNumber;
    }

    public static String getDateTimeForMargin(String dateTime) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(dateTime, DateTimeFormat.forPattern("dd MMM yyyy").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("dd-MMM-yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static boolean compareDates(String dateToConvert) {
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);

        Date date;
        try {
            date = targetFormat.parse(dateToConvert);

            Date today = new Date();
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
            today = targetFormat.parse(originalFormat.format(new Date()));

            if (today.compareTo(date) < 0)
                return false;
            else if (today.compareTo(date) > 0)
                return true;
            else
                return true;

        } catch (ParseException ex) {

        }
        return false;
    }

    public static String getCurrentCacheDate() {
        Date today = new Date();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        String currenrtDay = "";

        try {
            today = targetFormat.parse(originalFormat.format(new Date()));
            currenrtDay = targetFormat.format(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currenrtDay;
    }

    public static String getDateInDDMMYYYYFormat(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);

        String currenrtDay = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currenrtDay = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currenrtDay;
    }

    public static String getDateInBewiseDateFormat(String strDate) {

        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);

        String currenrtDay = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currenrtDay = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currenrtDay;
    }

    public static String getConvertedDateWithTime(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.ROOT);

        String currentMonth = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currentMonth = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currentMonth;
    }

    public static String getConvertedDateForPortfolio(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);

        String currentMonth = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currentMonth = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currentMonth;
    }

    public static int getMonthNumberFromMonthname(String monthName) {
        Date date = null;
        int monthNumber = -1;
        try {
            date = new SimpleDateFormat("MMM", Locale.ROOT).parse(monthName);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            monthNumber = cal.get(Calendar.MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return monthNumber + 1;
    }

    public static int getYear(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy", Locale.ROOT);

        String currentyear = "";
        int year = 0;
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currentyear = targetFormat.format(date);
            year = ObjectUtils.getIntFromString(currentyear);
        } catch (ParseException ex) {

        }
        return year;
    }

    public static String getDateInYYMMDDFromDDMMYYYY(String strDate) {

        String oldFormat = "dd-MM-yyyy";
        String newFormat = "yyyy-MM-dd";

        String currenrtDay = "";
        Date date;
        String formatedDate = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat, Locale.ROOT);
        Date myDate = null;
        try {
            myDate = dateFormat.parse(strDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat(newFormat, Locale.ROOT);
        formatedDate = timeFormat.format(myDate);
        return formatedDate;
    }

    public static String getMonthYearFromDate(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("MMMM yyyy", Locale.ROOT);

        String currenrtDay = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currenrtDay = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currenrtDay;
    }

    public static List<String> getLast7DaysList() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

        List<String> listLast7Days = new ArrayList<>();


        String date0St = originalFormat.format(cal.getTime());
        String weekDateRange0 = JodaDateUtils.getDateIn_dd_MMMFormat(date0St);
        listLast7Days.add(weekDateRange0);

        for (int i = 0; i < 6; i++) {
            cal.add(Calendar.DATE, -1);
            String date1St = originalFormat.format(cal.getTime());
            String weekDateRange1 = JodaDateUtils.getDateIn_dd_MMMFormat(date1St);
            listLast7Days.add(weekDateRange1);
        }
        return listLast7Days;
    }

    public static List<Date> getMonthsDatesWeekwise() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String formatted = originalFormat.format(cal.getTime());

        List<Date> listDatesWeekwise = new ArrayList<>();

        try {
//            String dateWeekFirst = originalFormat.format(cal.getTime());
//            listDatesWeekwise.add(originalFormat.parse(dateWeekFirst));

            for (int i = 0; i < 4; i++) {
                cal.add(Calendar.DATE, -7);

                String dateWeek = originalFormat.format(cal.getTime());
                listDatesWeekwise.add(originalFormat.parse(dateWeek));
            }
        } catch (ParseException e) {
            e.printStackTrace( );
        }

        //    Collections.reverse(listDatesWeekwise);

        return listDatesWeekwise;
    }

    public static List<String> getWeekRange(List<Date> listWeekDays) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String formatted = originalFormat.format(cal.getTime());

        List<String> listDatesWeekwise = new ArrayList<>();

        String dateWeekFirst = originalFormat.format(cal.getTime());
        //  listDatesWeekwise.add(originalFormat.parse(dateWeekFirst));


        for (int i = 0; i < listWeekDays.size(); i++) {
            cal.setTime(listWeekDays.get(i));
            cal.add(Calendar.DATE, 1);
            String date1 = originalFormat.format(cal.getTime());
            cal.add(Calendar.DATE, 6);
            String date2 = originalFormat.format(cal.getTime());

            listDatesWeekwise.add(JodaDateUtils.getDateIn_dd_MMMFormat(date1) + "-" + JodaDateUtils.getDateIn_dd_MMMFormat(date2));
            cal.add(Calendar.DATE, -8);
        }

        Collections.reverse(listDatesWeekwise);

        return listDatesWeekwise;
    }

    public static String getDateInYYMMDDFromYYYYddmm(String strDate) {

        String oldFormat = "yyyy-MM-dd";
        String newFormat = "ddMMMyyyy";

        String currenrtDay = "";
        Date date;
        String formatedDate = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat, Locale.ROOT);
        Date myDate = null;
        try {
            myDate = dateFormat.parse(strDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat(newFormat, Locale.ROOT);
        formatedDate = timeFormat.format(myDate);
        return formatedDate;
    }

    public static String getConvertedDateForNavDate(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);

        String currentMonth = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currentMonth = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currentMonth;
    }

    public static String getLfTransactionFormatDate(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("MMM dd,yyyy", Locale.ROOT);
        String currentMonth = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currentMonth = targetFormat.format(date);
        } catch (ParseException ex) {

        }

        return currentMonth;
    }

    public static String getMFChartFormatDate(Calendar cal) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM", Locale.ROOT);
            return format1.format(cal.getTime());
        } catch (Exception e) {

        }
        return "";
    }

    public static String getStockChartFormatDate(Calendar cal) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MM/yyyy", Locale.ROOT);
            return format1.format(cal.getTime());
        } catch (Exception e) {

        }
        return "";
    }

    public static String getStockMonthChartFormatDate(Calendar cal) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MMM dd,yyyy", Locale.ROOT);
            return format1.format(cal.getTime());
        } catch (Exception e) {

        }
        return "";
    }

    public static String getExplainChartFormatDate(Calendar cal) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("ddMMMyyyy", Locale.ROOT);
            return format1.format(cal.getTime());
        } catch (Exception e) {

        }
        return "";
    }

    public static String getFutureDateFromCurrDate(String currDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy", Locale.ROOT);
        try {
            Date d = sdf.parse(currDate);
        } catch (ParseException ex) {

        }

        return "";
    }

    public static String getTimeInHHMMFormat(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("HH:mm:ss", Locale.ROOT);

        String currenrtDay = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currenrtDay = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currenrtDay;
    }

    public static String getsixmonthJodaYearFirstDate() {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.MONTH, -6); // to get previous year add -1
        Date nextYear = cal.getTime();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String date4th = originalFormat.format(cal.getTime());
        return date4th;
    }

    public static Date getGraphSelectedDate(String selectedDate) {

        Date date = new Date();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        try {
            date = originalFormat.parse(selectedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getLFWithdrawalFormatDate(Calendar cal) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy", Locale.ROOT);
            return format1.format(cal.getTime());
        } catch (Exception e) {

        }
        return "";
    }

    public static String getDateInYYYY_MM_dd_HH_mm_ss(String strDate) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

        String currenrtDay = "";
        Date date;
        try {
            date = originalFormat.parse(strDate);
            currenrtDay = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currenrtDay;
    }

    public static String getCurrentday() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd", Locale.ROOT);
        String formattedDate = dateFormat.format(date);
        String strmonth = formattedDate.toString();//2017-08-09
//        System.out.println(strmonth);
        return strmonth;
    }

    public static String getEndday(String enddate) {
        String strmonth = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT).parse(enddate);
            DateFormat dateFormat = new SimpleDateFormat("dd", Locale.ROOT);
            String formattedDate = dateFormat.format(date);
            strmonth = formattedDate.toString();//2017-08-09
//            System.out.println(strmonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strmonth;
    }

    public static String getCurrentyear() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.ROOT);
        String formattedDate = dateFormat.format(date);
        String strmonth = formattedDate.toString();//2017-08-09
//        System.out.println(strmonth);
        return strmonth;
    }

    public static int getdaysinMonth(int iYear, int iMonth, int iDay) {
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return daysInMonth;
    }

    public static int daysBetween(String d1, String d2) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        Date date1 = null;
        Date date2 = null;
        int diff = 0;

        try {

            date1 = f.parse(d1);
            date2 = f.parse(d2);
            diff = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diff;
    }


    public static int differenceInMonths(String d1, String d2) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        Date date1 = null;
        Date date2 = null;
        int diff = 0;

        try {

            date1 = f.parse(d1);
            date2 = f.parse(d2);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(date1);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(date2);
            diff = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static String getStartDate() {
        //start from current day
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String formattedDate = dateFormat.format(date);
        String strmonth = formattedDate.toString();//2017-08-09
//        System.out.println(strmonth);
        return strmonth;
    }

    public static String getEndDate(int limitdays) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.DATE, limitdays);
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String date4th = originalFormat.format(cal.getTime());
        return date4th;
    }

    public static String getDateFromParticularMonth(int intMonth, String currDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, intMonth);

        Date tomorrow = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ROOT);

        String strDate = dateFormat.format(tomorrow);
        //String strDate = getFutureDateFromCurrDate(currDate);

        if (!TextUtils.isEmpty(strDate)) {
            return strDate;
        } else {
            return "";
        }
    }


    public static String getDateFromDays(int days, String currDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, days);
        Date tomorrow = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ROOT);

        String strDate = dateFormat.format(tomorrow);

        //String strDate = getFutureDateFromCurrDate(currDate);

        if (!TextUtils.isEmpty(strDate)) {
            return strDate;
        } else {
            return "";
        }
    }

    public static String getSipStartDateFormat(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("ddMMMyyyy").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("yyyy-MM-dd HH:mm");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getSipStartDateFormatForGoal(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("ddMMMyyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getSipDateFromString(String strDate, String format) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern(format).withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("ddMMMyyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getDateFromtoToFormat(String strDate, String fromFormat, String toFormat) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern(fromFormat).withLocale(Locale.ENGLISH));
            convertedDate = dt.toString(toFormat);
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getTimeFormated(String strDate) {
        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(strDate, DateTimeFormat.forPattern("HH:mm:ss").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("HH:mm");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }

        return convertedDate;
    }

    public static String getMonthNameFromMonthNumber(int monthNumber) {

        String[] monthNameArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "OCt", "Nov", "Dec"};

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMM", Locale.ROOT);
        cal.set(Calendar.MONTH, monthNumber);
        String month_name = month_date.format(cal.getTime());
        if (monthNumber < 12) {
            return monthNameArray[monthNumber];
        } else {
            return "";
        }
    }

    public static String getCurrentDateTime() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd MMM yyyy HH:mm:ss");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return currentMonthYear;
    }

    public static long getDateForGoal() {

        SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa", Locale.ROOT);

        Date date = null;
        try {
            date = originalFormat.parse(JodaDateUtils.getCurrentDateForComparison() + " 10:00:00 PM");
        } catch (ParseException ex) {
            ex.printStackTrace( );
        }
        if (date == null) {
            return System.currentTimeMillis();
        } else {
            return date.getTime();
        }
    }

    public static int getMonthCountBetween2Dates(int endYear, int endMonth) {
        DateTime date1 = new DateTime().withDate(endYear, endMonth, 28);
        DateTime date2 = new DateTime().withDate(ObjectUtils.getIntFromString(getCurrentyear()), ObjectUtils.getIntFromString(getCurrentMonthNumber()), 28);
        int monthCount = Months.monthsBetween(date2, date1).getMonths();
        return monthCount;
    }

    public static String getCurrentMonthNumber() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("MM");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return currentMonthYear;
    }

    public static String getCurrentDateMMM() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MMM/yyyy");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return currentMonthYear;
    }

    public static String getPastWeekDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MMM/yyyy", Locale.ROOT);
        calendar.add(Calendar.DATE, -7);
        String currentTime = formatter1.format(calendar.getTime());
        return currentTime;
    }

    public static String showDate(boolean isTomorrow, String format) {
        String date;
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat(format, Locale.ROOT);

        if (isTomorrow) {
            date = dateFormat.format(tomorrow);
        } else {
            date = dateFormat.format(today);
        }

        return date;
    }

    public static boolean compareTimeForQsip() {
        String currentTime = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm");
            currentTime = dtf.print(localDateTime);
            String datadb = "14:00";

            if (currentTime.compareTo(datadb) >= 0) {
                return true;
            }

        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return false;
    }

    public static void getFutureDate(Date currentDate, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, days);

        Date futureDate = cal.getTime();
    }

    public static boolean compareDates(String d1, String d2) {
        boolean tag = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);

            if (date1.equals(date2) || date1.after(date2)) {
                tag = true;
            }

        } catch (ParseException ex) {
            ex.printStackTrace();

        }
        return tag;
    }

    public static long getCurrentMonthsFirstDateInMilliSeconds() {
        Calendar c = Calendar.getInstance();   // this takes current date
        c.set(Calendar.DAY_OF_MONTH, 1);
        long time = c.getTimeInMillis();
        return time;
    }

    public static String getNextDateForGoal() {
        LocalDate localDate = new DateTime().plusDays(1).toLocalDate();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        return localDate.toString(fmt);
    }

    public static String getDateInYYYY_mm_ddFrom_mmm_yyyy(String inputDate) {
        if (!TextUtils.isEmpty(inputDate)) {
            String reqDate = "";
            try {
                DateFormat inputFormat = new SimpleDateFormat("MMM yyyy", Locale.ROOT);
                DateFormat outputFormat = new SimpleDateFormat("yyyy-MM", Locale.ROOT);
                //   String inputDateStr="2013-06-24";
                Date date = null;
                date = inputFormat.parse(inputDate);

                reqDate = outputFormat.format(date);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return reqDate + "-28";
        } else {
            return "";
        }

    }

    public static DateTime endOfYear(DateTime dateTime) {
        return endOfDay(dateTime).withMonthOfYear(12).withDayOfMonth(31);
    }

    public static DateTime beginningOfYear(DateTime dateTime) {
        return beginningOfMonth(dateTime).withMonthOfYear(1);
    }

    public static DateTime endOfMonth(DateTime dateTime) {
        return endOfDay(dateTime).withDayOfMonth(dateTime.dayOfMonth().getMaximumValue());
    }

    public static DateTime beginningOfMonth(DateTime dateTime) {
        return beginningOfday(dateTime).withDayOfMonth(1);
    }

    public static DateTime endOfDay(DateTime dateTime) {
        return endOfHour(dateTime).withHourOfDay(23);
    }

    public static DateTime beginningOfday(DateTime dateTime) {
        return beginningOfHour(dateTime).withHourOfDay(0);
    }

    public static DateTime beginningOfHour(DateTime dateTime) {
        return dateTime.withMillisOfSecond(0).withSecondOfMinute(0).withMinuteOfHour(0);
    }

    public static DateTime endOfHour(DateTime dateTime) {
        return dateTime.withMillisOfSecond(999).withSecondOfMinute(59).withMinuteOfHour(59);
    }

    public static String getCurrentDateYYYYMMDD() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        String currentTime = formatter1.format(calendar.getTime());
        return currentTime;
    }

    public static String getMonthNumberFromMMM_YYYY(String inputDate) {
        DateFormat inputFormat = new SimpleDateFormat("MMM yyyy", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("MM", Locale.ROOT);

        String currentMonth = "";
        Date date;
        try {
            date = inputFormat.parse(inputDate);
            currentMonth = targetFormat.format(date);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        return currentMonth;
    }

    public static String getYearFromMMM_YYYY(String inputDate) {
        DateFormat inputFormat = new SimpleDateFormat("MMM yyyy", Locale.ROOT);
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy", Locale.ROOT);

        String currentMonth = "";
        Date date;
        try {
            date = inputFormat.parse(inputDate);
            currentMonth = targetFormat.format(date);
        } catch (ParseException ex) {

        }
        return currentMonth;
    }

    public static int getCurrentJodaMonth() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.getMonthOfYear();
    }

    public static String getDateMMMYYYYFormatFromYYYYMMDD(String dateInYYYYMMDD) {
        if (!TextUtils.isEmpty(dateInYYYYMMDD)) {
            try {
                DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
                DateTime jodatime = dtf.parseDateTime(dateInYYYYMMDD);
                DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MMM yyyy");

                return dtfOut.print(jodatime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static String getMMMYYYYfromYYYYMMDD(String date) {

        String convertedDate = "";

        try {
            DateTime dt = DateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            convertedDate = dt.toString("MMM yyyy");
        } catch (Exception ex) {
            ex.printStackTrace( );
        }
        return convertedDate;
    }

    public static int differenceBetween2DatesinYears(String dobdate, String targetDate) {
        int yearDiffinYears = 0;
        if (!TextUtils.isEmpty(dobdate) && !TextUtils.isEmpty(targetDate)) {
            DateTime dateTimeTargetDate = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(targetDate);
            DateTime dateTimeDob = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(dobdate);

            long longTargetDateInMillis = dateTimeTargetDate.getMillis();
            long longDobInMillis = dateTimeDob.getMillis();
            Period period = new Period(longDobInMillis, longTargetDateInMillis);

            yearDiffinYears = period.getYears();
        }
        return yearDiffinYears;
    }


    public static String convertDDMMYYYY_to_YYYYMMDD(String inputDate) {
        String convertedDate = "";
        if (!TextUtils.isEmpty(inputDate)) {
            try {
                DateTime dt = DateTime.parse(inputDate, DateTimeFormat.forPattern("dd-MM-yyyy").withLocale(Locale.ENGLISH));
                convertedDate = dt.toString("yyyy-MM-dd");
            } catch (Exception ex) {
                ex.printStackTrace( );
            }
            return convertedDate;
        }
        return convertedDate;
    }

    public static String convertYYYYMMDD_to_DDMMYYYY(String inputDate) {
        String convertedDate = "";
        if (!TextUtils.isEmpty(inputDate)) {
            try {
                DateTime dt = DateTime.parse(inputDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
                convertedDate = dt.toString("dd-MM-yyyy");
            } catch (Exception ex) {
                ex.printStackTrace( );
            }
            return convertedDate;
        }
        return convertedDate;
    }

    public static String getOneMonthPreviousStartDate() {
        DateTime dateTime = new DateTime().minusMonths(1);

        DateTime start = JodaDateUtils.beginningOfMonth(dateTime);

        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        return dtf.print(start);
    }

    public static String getOneMonthPreviousEndDate() {
        DateTime dateTime = new DateTime().minusMonths(1);

        DateTime end = JodaDateUtils.endOfMonth(dateTime);

        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        return dtf.print(end);
    }

    public static String getDateTimeForMFOrderDetail(String foramttedDate) {
        if (!TextUtils.isEmpty(foramttedDate)) {
            String convertedDate = "";
            try {
                DateTime dt = DateTime.parse(foramttedDate, DateTimeFormat.forPattern("ddMMMyyyy HH:mm").withLocale(Locale.ENGLISH));
                convertedDate = dt.toString("ddMMMyyyy HH:mm a");
            } catch (Exception ex) {
                ex.printStackTrace( );
            }

            return convertedDate;
        }

        return "";
    }

    public static String getCurrentDateInddMMyyyy() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return currentMonthYear;
    }


    public static String getCurrentDateInyyyyMMdd() {
        String currentMonthYear = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
            currentMonthYear = dtf.print(localDateTime);
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return currentMonthYear;
    }
    public static int getMonthBefore(int noOfMonths) {
        return new DateTime().minusMonths(noOfMonths).getMonthOfYear();
    }

    public static String getDateForHealthInsurance(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("d/M/yyyy");
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.YEAR, year);
        String dateformatted = date.format(cal.getTime());
        return dateformatted;
    }



    public static String convertDateInYYYYmmddToddMMMYYYY(String inputDate) {
        String convertedDate = "";
        if (!TextUtils.isEmpty(inputDate)) {
            try {
                DateTime dt = DateTime.parse(inputDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
                convertedDate = dt.toString("dd MMM yyyy");
            } catch (Exception ex) {
                ex.printStackTrace( );
            }
            return convertedDate;
        }
        return convertedDate;
    }

    public static String addYearToDate(String yearsToAdd, String strDate, boolean isinYYYYMMDDFormat) {
        String targetDate = "";
        DateTime dateTime;
        int years = ObjectUtils.getIntFromString(yearsToAdd);
        try {
            if (isinYYYYMMDDFormat) {
                dateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(strDate);
            } else {
                dateTime = DateTimeFormat.forPattern("dd-MM-yyyy").parseDateTime(strDate);
            }

            if (!isinYYYYMMDDFormat) {
                String convertedDate = dateTime.toString("yyyy-MM-dd");
                dateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(convertedDate);
            }

            LocalDate localDate = dateTime.plusYears(years).toLocalDate();

            if (ObjectUtils.isNotNull(localDate)) {
                targetDate = localDate.toString();
            }

        } catch (Exception ex) {
            ex.printStackTrace( );
        }
        return targetDate;
    }

    public static String convertDateInYYYY_mm_ddToddMMMYYYY(String inputDate) {
        String convertedDate = "";
        if (!TextUtils.isEmpty(inputDate)) {
            try {
                DateTime dt = DateTime.parse(inputDate, DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
                convertedDate = dt.toString("dd-MMM-yyyy");
            } catch (Exception ex) {
                ex.printStackTrace( );
            }
            return convertedDate;
        }
        return convertedDate;
    }

}
