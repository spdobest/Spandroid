package spandroid.dev.utils;

import android.content.Context;
import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import spandroid.dev.R;
import spandroid.dev.app.SpandroidApplication;

public class ObjectUtils {

    Context mContext;

    private static final String TAG = "ObjectUtils";

    public static double getLFEarnedMoney(double bankBalance) {
        /**
         * This code is calcualting interest on bank balance.
         * 0.08 % rate of interest applied
         * Please check before remove the code
         */
        return (bankBalance * 0.08);
    }

    public static boolean indexExists(final HashMap map, final int index) {
        return index >= 0 && index < map.size();
    }

    public static boolean indexExists(final List list, final int index) {
        return index >= 0 && index < list.size();
    }

    public static boolean arrayIndexExist(String[] data, int index) {
        try {
            String s = data[index];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static String parseString(String number) {
        return number.indexOf(".") < 0 ? number : number.replaceAll("0*$", "").replaceAll("\\.$", "");
    }

    public static boolean isNotNull(Object o) {
        if (o != null) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String s) {
        if (s != null && s.trim().length() > 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(List s) {
        if (s != null && s.size() > 0) {
            return false;
        }
        return true;
    }

    public static int getIntFromString(String number) {

        if (number != null) {
            int numberInt = 0;

            number = number.replaceAll("\\s+", "");
            number = number.replaceAll(",", "");
            number = number.replaceAll(SpandroidApplication.getInstance().getResources().getString(R.string.Rs_symbol), "");
            try {
                numberInt = Integer.parseInt(number);
            } catch (NumberFormatException e) {
               e.printStackTrace();
            }
            return numberInt;
        } else {
            return 0;
        }
    }

    public static int getIntFromStringWithDefaultValue(String number, int defaultValue) {

        if (number != null) {
            int value = getIntFromString(number);
            if (value == 0) {
                value = defaultValue;
            }
            return value;
        } else {
            return defaultValue;
        }
    }

    public static long getLongFromString(String number) {

        if (number != null) {
            long numberInt = 0;

            number = number.replaceAll("\\s+", "");
            number = number.replaceAll(",", "");
            number = number.replaceAll(SpandroidApplication.getInstance().getResources().getString(R.string.Rs_symbol), "");
            try {
                numberInt = Long.parseLong(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return numberInt;
        } else {
            return 0;
        }
    }

    public static long getLongFromStringWithDefaultValue(String number, long defaultValue) {

        if (number != null) {
            long value = getLongFromString(number);
            if (value == 0) {
                value = defaultValue;
            }
            return value;
        } else {
            return defaultValue;
        }
    }

    public static float getFloatFromString(String number) {

        if (number != null) {
            float numberFloat = 0;

            number = number.replaceAll("\\s+", "");
            number = number.replaceAll(",", "");
            number = number.replaceAll(SpandroidApplication.getInstance().getResources().getString(R.string.Rs_symbol), "");
            try {
                numberFloat = Float.parseFloat(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return numberFloat;
        } else {
            return 0;
        }
    }

    public static double getDoubleFromString(String number) {
        if (!TextUtils.isEmpty(number)) {
            double numberDouble = 0;
            number = number.replaceAll("\\s+", "");
            number = number.replaceAll(",", "");
            number = number.replaceAll(SpandroidApplication.getInstance().getResources().getString(R.string.Rs_symbol), "");

            try {
                numberDouble = Double.parseDouble(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            return numberDouble;
        } else {
            return 0;
        }
    }


    public static float getFloatFromStringWithDefaultValue(String number, float defaultValue) {

        if (number != null) {
            float numberInt = getFloatFromString(number);
            if (numberInt == 0) {
                numberInt = defaultValue;
            }
            return numberInt;
        } else {
            return defaultValue;
        }
    }

    public static String getStringFromInt(int number) {

        if (number != 0) {
            String numberString = "0";
            try {
                numberString = Integer.toString(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return numberString;
        } else {
            return "0";
        }
    }

/*
    public static void sortBeewiseList(List<BeeWiseResponse> beeWiseResponseList) {
        Collections.sort(beeWiseResponseList, new Comparator<BeeWiseResponse>() {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

            @Override
            public int compare(BeeWiseResponse beeWiseResponseT1, BeeWiseResponse beeWiseResponseT2) {

                if (beeWiseResponseT1 != null && beeWiseResponseT1.getMessageTimestamp() != null &&
                        beeWiseResponseT2 != null && beeWiseResponseT2.getMessageTimestamp() != null) {
                    try {
                        return f.parse(beeWiseResponseT2.getMessageTimestamp()).compareTo(f.parse(beeWiseResponseT1.getMessageTimestamp()));
                    } catch (ParseException e) {
                        throw new IllegalArgumentException(e);
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
        });
    }

    public static void sortMessageDataList(List<MessageData> beeWiseResponseList) {
        Collections.sort(beeWiseResponseList, new Comparator<MessageData>() {
            @Override
            public int compare(MessageData t1, MessageData t2) {
                if (t1 != null && t1.getMessage_timestamp_long() != 0 && t2 != null && t2.getMessage_timestamp_long() != 0) {
                    return Long.compare(t2.getMessage_timestamp_long(), t1.getMessage_timestamp_long());
                } else {
                    return 0;
                }
            }
        });
    }

    public static void sortClientGoalList(List<ClientGoal> clientGoalList) {
        Collections.sort(clientGoalList, (clientGoalT1, clientGoalT2) -> {

            if (clientGoalT1 != null && clientGoalT2 != null) {
                return String.valueOf(clientGoalT2.getClientGoalId()).compareTo(String.valueOf(clientGoalT1.getClientGoalId()));
            } else {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void sortScriptDetailsOptionList(List<ScriptDetailsOption> scriptDetailsOptionList) {
        if (ObjectUtils.isNotNull(scriptDetailsOptionList) && scriptDetailsOptionList.size() > 0) {
            Collections.sort(scriptDetailsOptionList, new Comparator<ScriptDetailsOption>() {
                DateFormat f = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);

                @Override
                public int compare(ScriptDetailsOption t1, ScriptDetailsOption t2) {

                    if (t1 != null && t1.getExpiryDate() != null &&
                            t2 != null && t2.getExpiryDate() != null) {
                        try {
                            return f.parse(t1.getExpiryDate()).compareTo(f.parse(t2.getExpiryDate()));
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            });
        }
    }

    public static void sortScriptDetailsListForStrikePrice(List<ScriptDetails> scriptDetailsOptionList) {
        if (ObjectUtils.isNotNull(scriptDetailsOptionList) && scriptDetailsOptionList.size() > 0) {
            Collections.sort(scriptDetailsOptionList, (t1, t2) -> {

                if (t1 != null && t1.getnStrikePrice() != null && t2 != null && t2.getnStrikePrice() != null) {
                    return t1.getnStrikePrice().compareTo(t2.getnStrikePrice());
                } else {
                    throw new IllegalArgumentException();
                }
            });
        }
    }

    public static void sortScriptDetailsList(List<ScriptDetails> scriptDetailsOptionList) {
        if (ObjectUtils.isNotNull(scriptDetailsOptionList) && scriptDetailsOptionList.size() > 0) {
            Collections.sort(scriptDetailsOptionList, new Comparator<ScriptDetails>() {
                DateFormat f = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);

                @Override
                public int compare(ScriptDetails t1, ScriptDetails t2) {

                    if (t1 != null && t1.getExpiryDate() != null &&
                            t2 != null && t2.getExpiryDate() != null) {
                        try {
                            return f.parse(t1.getExpiryDate()).compareTo(f.parse(t2.getExpiryDate()));
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            });
        }
    }

    public static void sortIsinDetailsList(List<IsinResponseItem> scriptDetailsOptionList) {
        if (ObjectUtils.isNotNull(scriptDetailsOptionList) && scriptDetailsOptionList.size() > 0) {
            Collections.sort(scriptDetailsOptionList, new Comparator<IsinResponseItem>() {
                DateFormat f = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);

                @Override
                public int compare(IsinResponseItem t1, IsinResponseItem t2) {

                    if (t1 != null && t1.getExpiryDate() != null &&
                            t2 != null && t2.getExpiryDate() != null) {
                        try {
                            return f.parse(t1.getExpiryDate()).compareTo(f.parse(t2.getExpiryDate()));
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            });
        }
    }

    public static void sortPortfolioEquityResponse(List<PortfolioEquity> portfolioEquity, int isAscending, int byParameter) {

        Collections.sort(portfolioEquity, (portfolioEquity1, portfolioEquity2) -> {
            if (portfolioEquity1 != null && portfolioEquity2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioEquity2.getCompanyName()).compareTo(String.valueOf(portfolioEquity1.getCompanyName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf((portfolioEquity2.getNetChange())+"0").compareTo(Double.valueOf((portfolioEquity1.getNetChange())+"0"));
                    } else if (byParameter == 2) {
                        return Double.valueOf((portfolioEquity2.getCurrMKTValue())+"0").compareTo(Double.valueOf((portfolioEquity1.getCurrMKTValue())+"0"));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioEquity1.getCompanyName()).compareTo(String.valueOf(portfolioEquity2.getCompanyName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf((portfolioEquity1.getNetChange())+"0").compareTo(Double.valueOf((portfolioEquity2.getNetChange())+"0"));
                    } else if (byParameter == 2) {
                        return Double.valueOf((portfolioEquity1.getCurrMKTValue())+"0").compareTo(Double.valueOf((portfolioEquity2.getCurrMKTValue())+"0"));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortPortfolioMfResponse(List<PortfolioMutual> portfolioMutual, int isAscending, int byParameter) {
        Collections.sort(portfolioMutual, (portfolioMf1, portfolioMf2) -> {

            if (portfolioMf1 != null && portfolioMf2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioMf2.getSchemeName()).compareTo(String.valueOf(portfolioMf1.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioMf2.getLastNAVPrice()).compareTo(Double.valueOf(portfolioMf1.getLastNAVPrice()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioMf2.getCurrMKTValue()).compareTo(Double.valueOf(portfolioMf1.getCurrMKTValue()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioMf1.getSchemeName()).compareTo(String.valueOf(portfolioMf2.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioMf1.getLastNAVPrice()).compareTo(Double.valueOf(portfolioMf2.getLastNAVPrice()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioMf1.getCurrMKTValue()).compareTo(Double.valueOf(portfolioMf2.getCurrMKTValue()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }

            return 1;

        });
    }

    public static void sortPortfolioOtherResponse(List<PortfolioCurrency> portfolioCurrencies, int isAscending, int byParameter) {
        Collections.sort(portfolioCurrencies, (portfolioCurrency1, portfolioCurrency2) -> {

            if (portfolioCurrency1 != null && portfolioCurrency2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioCurrency2.getSymbol()).compareTo(String.valueOf(portfolioCurrency1.getSymbol()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioCurrency2.getLtp()).compareTo(Double.valueOf(portfolioCurrency1.getLtp()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioCurrency2.getCurrMKTValue()).compareTo(Double.valueOf(portfolioCurrency1.getCurrMKTValue()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioCurrency1.getSymbol()).compareTo(String.valueOf(portfolioCurrency2.getSymbol()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioCurrency1.getLtp()).compareTo(Double.valueOf(portfolioCurrency2.getLtp()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioCurrency1.getCurrMKTValue()).compareTo(Double.valueOf(portfolioCurrency2.getCurrMKTValue()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortPortfolioEquityPnlResponse(List<PortfolioEquityPnl> portfolioEquityPnls, int isAscending, int byParameter) {

        Collections.sort(portfolioEquityPnls, (portfolioEquity1, portfolioEquity2) -> {
            if (portfolioEquity1 != null && portfolioEquity2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioEquity2.getCoName()).compareTo(String.valueOf(portfolioEquity1.getCoName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioEquity2.getRealizedGainLoss()).compareTo(Double.valueOf(portfolioEquity1.getRealizedGainLoss()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioEquity2.getPnLIntraday()).compareTo(Double.valueOf(portfolioEquity1.getPnLIntraday()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioEquity1.getCoName()).compareTo(String.valueOf(portfolioEquity2.getCoName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioEquity1.getRealizedGainLoss()).compareTo(Double.valueOf(portfolioEquity2.getRealizedGainLoss()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioEquity1.getPnLIntraday()).compareTo(Double.valueOf(portfolioEquity2.getPnLIntraday()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortPortfolioMfPnlResponse(List<PortfolioMutualFundPnl> portfolioMutualFundPnls, int isAscending, int byParameter) {

        Collections.sort(portfolioMutualFundPnls, (portfolioEquity1, portfolioEquity2) -> {
            if (portfolioEquity1 != null && portfolioEquity2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioEquity2.getSchemeName()).compareTo(String.valueOf(portfolioEquity1.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioEquity2.getRealizedGainLoss()).compareTo(Double.valueOf(portfolioEquity1.getRealizedGainLoss()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioEquity2.getBuyValue()).compareTo(Double.valueOf(portfolioEquity1.getBuyValue()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(portfolioEquity1.getSchemeName()).compareTo(String.valueOf(portfolioEquity2.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(portfolioEquity1.getRealizedGainLoss()).compareTo(Double.valueOf(portfolioEquity2.getRealizedGainLoss()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(portfolioEquity1.getBuyValue()).compareTo(Double.valueOf(portfolioEquity2.getBuyValue()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortMFHoldingResponse(List<MutualFundHoldingsResponse.MutualFundHoldingObject> holdingList, boolean isAscending, int byParameter) {
        Collections.sort(holdingList, (object1, object2) -> {

            if (object1 != null && object2 != null) {
                if (isAscending) {
                    if (byParameter == 0) {
                        return String.valueOf(object1.getSchemeName()).compareTo(String.valueOf(object2.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(object1.getNAV()).compareTo(Double.valueOf(object2.getNAV()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(object1.getAvailableUnitsInDP()).compareTo(Double.valueOf(object2.getAvailableUnitsInDP()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(object2.getSchemeName()).compareTo(String.valueOf(object1.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(object2.getNAV()).compareTo(Double.valueOf(object1.getNAV()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(object2.getAvailableUnitsInDP()).compareTo(Double.valueOf(object1.getAvailableUnitsInDP()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortARQPortfolioResponse(List<ARQPSStockHealthCheckScoreResponse.HealthScoreData.HealthScoreTable1Item> holdingList, boolean isAscending, int byParameter) {
        Collections.sort(holdingList, (object1, object2) -> {

            if (object1 != null && object2 != null) {
                if (isAscending) {
                    if (byParameter == 0) {
                        return String.valueOf(object1.getCoName()).compareTo(String.valueOf(object2.getCoName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(object1.getScore()).compareTo(Double.valueOf(object2.getScore()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(object2.getCoName()).compareTo(String.valueOf(object1.getCoName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(object2.getScore()).compareTo(Double.valueOf(object1.getScore()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortMFOrderBookResponse(List<MutualFundOrderBookResponse.MutualFundOrderStatusObject> orderList, boolean isAscending, int byParameter) {
        Collections.sort(orderList, (object1, object2) -> {

            if (object1 != null && object2 != null) {
                if (isAscending) {
                    if (byParameter == 0) {
                        return String.valueOf(object1.getSchemeName()).compareTo(String.valueOf(object2.getSchemeName()));
                    } else if (byParameter == 1) {
                        try {
                            DateFormat f = new SimpleDateFormat("ddMMMyyyy HH:mm", Locale.ROOT);
                            return f.parse(object1.getDtModifiedTime()).compareTo(f.parse(object2.getDtModifiedTime()));
                        }catch (Exception e){

                        }
                    } else if (byParameter == 2) {
                        return Double.valueOf(object1.getnAppAmount()).compareTo(Double.valueOf(object2.getnAppAmount()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(object2.getSchemeName()).compareTo(String.valueOf(object1.getSchemeName()));
                    } else if (byParameter == 1) {
                        try {
                            DateFormat f = new SimpleDateFormat("ddMMMyyyy HH:mm", Locale.ROOT);
                            return f.parse(object2.getDtModifiedTime()).compareTo(f.parse(object1.getDtModifiedTime()));
                        }catch (Exception e){

                        }
                    } else if (byParameter == 2) {
                        return Double.valueOf(object2.getnAppAmount()).compareTo(Double.valueOf(object1.getnAppAmount()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortMFNFOResponse(List<MutualFundNFOResponse.MutualFundNFOItem> nfoList, boolean isAscending, int byParameter) {
        Collections.sort(nfoList, (object1, object2) -> {

            if (object1 != null && object2 != null) {
                if (isAscending) {
                    if (byParameter == 0) {
                        return String.valueOf(object1.getScheme_Name()).compareTo(String.valueOf(object2.getScheme_Name()));
                    } else if (byParameter == 1) {
                        return String.valueOf(object1.getPlanName()).compareTo(String.valueOf(object2.getPlanName()));
                    } else if (byParameter == 2) {
                        try {
                            DateFormat f = new SimpleDateFormat("yyyy/mm/dd", Locale.ROOT);
                            return f.parse(object1.getEnd_Date()).compareTo(f.parse(object2.getEnd_Date()));
                        } catch (Exception e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(object2.getScheme_Name()).compareTo(String.valueOf(object1.getScheme_Name()));
                    } else if (byParameter == 1) {
                        return String.valueOf(object2.getPlanName()).compareTo(String.valueOf(object1.getPlanName()));
                    } else if (byParameter == 2) {
                        try {
                            DateFormat f = new SimpleDateFormat("yyyy/mm/dd", Locale.ROOT);
                            return f.parse(object2.getEnd_Date()).compareTo(f.parse(object1.getEnd_Date()));
                        } catch (Exception e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }


    public static void sortQsipResponse(List<ArqRecommendationBasketItem> arqRecommendationses, int isAscending, int byParameter) {

        Collections.sort(arqRecommendationses, (arqRecommendation1, arqRecommendation2) -> {
            if (arqRecommendation1 != null && arqRecommendation2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(arqRecommendation2.getSchemeName()).compareTo(String.valueOf(arqRecommendation1.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(arqRecommendation2.getAUM()).compareTo(Double.valueOf(arqRecommendation1.getAUM()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(arqRecommendation2.getReturnYear_3()).compareTo(Double.valueOf(arqRecommendation1.getReturnYear_3()));
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(arqRecommendation1.getSchemeName()).compareTo(String.valueOf(arqRecommendation2.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(arqRecommendation1.getAUM()).compareTo(Double.valueOf(arqRecommendation2.getAUM()));
                    } else if (byParameter == 2) {
                        return Double.valueOf(arqRecommendation1.getReturnYear_3()).compareTo(Double.valueOf(arqRecommendation2.getReturnYear_3()));
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }

    public static void sortQsipOrderBookResponse(List<ListSipOrderDetails> listSipOrderDetailses, int isAscending, int byParameter) {

        Collections.sort(listSipOrderDetailses, (listSipOrderDetailsComparator1, listSipOrderDetailsComparator2) -> {
            if (listSipOrderDetailsComparator1 != null && listSipOrderDetailsComparator2 != null) {
                if (isAscending == 0) {
                    if (byParameter == 0) {
                        return String.valueOf(listSipOrderDetailsComparator2.getSchemeName()).compareTo(String.valueOf(listSipOrderDetailsComparator1.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(listSipOrderDetailsComparator2.getInstallmentAmount()).compareTo(Double.valueOf(listSipOrderDetailsComparator1.getInstallmentAmount()));
                    } else if (byParameter == 2) {
                        try {
                            DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ROOT);
                            return f.parse(listSipOrderDetailsComparator2.getStartDate()).compareTo(f.parse(listSipOrderDetailsComparator1.getStartDate()));
                        } catch (Exception e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                } else {
                    if (byParameter == 0) {
                        return String.valueOf(listSipOrderDetailsComparator1.getSchemeName()).compareTo(String.valueOf(listSipOrderDetailsComparator2.getSchemeName()));
                    } else if (byParameter == 1) {
                        return Double.valueOf(listSipOrderDetailsComparator1.getInstallmentAmount()).compareTo(Double.valueOf(listSipOrderDetailsComparator2.getInstallmentAmount()));
                    } else if (byParameter == 2) {
                        try {
                            DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ROOT);
                            return f.parse(listSipOrderDetailsComparator1.getStartDate()).compareTo(f.parse(listSipOrderDetailsComparator2.getStartDate()));
                        } catch (Exception e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            return 1;

        });
    }
*/

    public static int getMiddleElementIndex(List list) {

        if (isNotNull(list)) {
            int value = list.size() % 2;

            int middleIndex = list.size() / 2;

            int evenMid = middleIndex - 1;

            if (value == 0) {
                return evenMid;
            } else {
                return middleIndex;
            }
        }
        return 0;
    }

    public static String indianCurrencyFormatWithoutRuppes(String strValue) {
        Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) format).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) format).setDecimalFormatSymbols(decimalFormatSymbols);
        String formattedAmount = format.format(new BigDecimal(strValue));
        return formattedAmount;
    }

    public static String indianCurrencyFormatWithRuppes(String strValue) {
        String formattedAmount = SpandroidApplication.getInstance().getResources().getString(R.string.Rs_symbol) + " " + indianCurrencyFormatWithoutRuppes(strValue);
        return formattedAmount;
    }

   /* public static void sortScripSearch(List<ScriptSearchResponseV2> scripSearchList) {
        Collections.sort(scripSearchList, (scripSearchT1, scripSearchT2) -> {

            if (scripSearchT1 != null && scripSearchT2 != null) {
                return String.valueOf(scripSearchT1.getsSymbol()).compareTo(String.valueOf(scripSearchT2.getsSymbol()));
            } else {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void sortFundSchemeSearch(List<MutualFundSchemeSearchResponse.MutualFundSchemeSearchObject> SearchList) {
        Collections.sort(SearchList, (scripSearchT1, scripSearchT2) -> {

            if (scripSearchT1 != null && scripSearchT2 != null) {
                return scripSearchT1.getScheme_Name().compareTo(scripSearchT2.getScheme_Name());
            } else {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void sortFundSchemeSearchTradeMF(List<MutualFundSchemeNameSearchModelTradeMF.SearchModel> SearchList) {
        Collections.sort(SearchList, (scripSearchT1, scripSearchT2) -> {

            if (scripSearchT1 != null && scripSearchT2 != null) {
                return scripSearchT1.getScheme_name().compareTo(scripSearchT2.getScheme_name());
            } else {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void sortFundNameSearch(List<MutualFundNameSearchResponse.MutualFundNameSearchObject> SearchList) {
        Collections.sort(SearchList, (scripSearchT1, scripSearchT2) -> {

            if (scripSearchT1 != null && scripSearchT2 != null) {
                return scripSearchT1.getAMC_NAME().compareTo(scripSearchT2.getAMC_NAME());
            } else {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void sortBestFiveAsce(List<BestFiveItem> scriptDetailsOptionList) {
        if (ObjectUtils.isNotNull(scriptDetailsOptionList) && scriptDetailsOptionList.size() > 0) {
            Collections.sort(scriptDetailsOptionList, (t1, t2) -> {

                if (t1 != null && t1.getStrPrice() != null && t2 != null && t2.getStrPrice() != null) {
                    if (t1.getStrPrice().equalsIgnoreCase("-")) {
                        return t2.getStrPrice().compareTo(t1.getStrPrice());
                    } else {
                        return t1.getStrPrice().compareTo(t2.getStrPrice());
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            });
        }
    }

    public static void sortBestFiveDesc(List<BestFiveItem> scriptDetailsOptionList) {
        if (ObjectUtils.isNotNull(scriptDetailsOptionList) && scriptDetailsOptionList.size() > 0) {
            Collections.sort(scriptDetailsOptionList, (t1, t2) -> {

                if (t1 != null && t1.getStrPrice() != null && t2 != null && t2.getStrPrice() != null) {
                    return t2.getStrPrice().compareTo(t1.getStrPrice());
                } else {
                    throw new IllegalArgumentException();
                }
            });
        }
    }*/

    public static float convertFloatWithDecimal(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static String get0DecimalString(String value) {
        try {
            double doubleValue = ObjectUtils.getDoubleFromString(value);
            return ((long) doubleValue) + "";
        } catch (Exception e) {
            return value;
        }
    }

    public static String get2DecimalString(String value) {
        try {
            String toConvert = String.format("%.2f", (new BigDecimal(value)));
            return toConvert;
        } catch (Exception e) {
            return value;
        }
    }

    public static String get1DecimalString(String value) {
        try {
            String toConvert = String.format("%.1f", (new BigDecimal(value)));
            return toConvert;
        } catch (Exception e) {
            return value;
        }
    }

    public static String get2DecimalStringFromFloat(float fvalue) {
        String value = String.valueOf(fvalue);
        try {
            String toConvert = String.format("%.2f", (new BigDecimal(value)));
            return toConvert;
        } catch (Exception e) {
            return value;
        }
    }

    public static String get4DecimalString(String value) {
        try {
            String toConvert = String.format("%.4f", (new BigDecimal(value)));
            return toConvert;
        } catch (Exception e) {
            return value;
        }
    }



    public static boolean checkTickValue(String strPrice, String strTickSize) {
        if (strTickSize.contains(".")) {
            double doubleTick;
            int intLen = strTickSize.length() - 2;
            if (intLen < 0) {
                intLen = 1;
            }
            double doublePower = Math.pow(10, intLen);
            doubleTick = getFloatFromString(strTickSize) * doublePower;
            double dblPrice = getDoubleFromString(strPrice);
            dblPrice = dblPrice * doublePower;
            String result = String.format("%.2f", doubleTick);
            doubleTick = ObjectUtils.getDoubleFromString(result);

            result = String.format("%.2f", dblPrice);
            dblPrice = ObjectUtils.getDoubleFromString(result);

            if (dblPrice % doubleTick != 0) {
                return false;
            }
        }

        return true;
    }

    public static String dateFormatForQuote(String strDate) {
        try {
            String[] tempS = strDate.split(" ");
            String str1 = tempS[0];

            StringBuilder str2 = new StringBuilder(tempS[1]);
            str2.insert(2, ':');
            str2.insert(5, ':');

            tempS = tempS[0].split("-");
            str1 = tempS[2] + "-" + tempS[1] + "-" + tempS[0];
            return str1 + " " + str2;
        } catch (Exception e) {
            e.printStackTrace();
            return strDate;
        }
    }

   /* public static void sortProduct(List<ProductInfo> infoList) {
        if (ObjectUtils.isNotNull(infoList) && infoList.size() > 0) {
            Collections.sort(infoList, (t1, t2) -> {

                if (t1 != null && t1.getStrValue() != null && t2 != null && t2.getStrValue() != null) {
                    return t1.getStrValue().compareTo(t2.getStrValue());
                } else {
                    throw new IllegalArgumentException();
                }
            });
        }
    }

    public static boolean checkProductContains(List<ProductInfo> list, String name) {
        for (ProductInfo item : list) {
            if (item.getStrValue().equals(name)) {
                return true;
            }
        }

        return false;
    }*/

    public static String getStringFromFloat(float number) {

        if (number != 0) {
            String numberString = "0";
            try {
                numberString = Float.toString(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return numberString;
        } else {
            return "0";
        }
    }

    public static String getStringFromDouble(double number) {

        if (number != 0) {
            String numberString = "0";
            try {
                numberString = Double.toString(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return numberString;
        } else {
            return "0";
        }
    }

/*
    public static void sortTopSpendListByAmount(List<SpendItem> spendList) {

        Collections.sort(spendList, new Comparator<SpendItem>() {

            @Override
            public int compare(SpendItem spendItemT1, SpendItem spendItemT2) {

                return Float.compare(spendItemT2.getTotalAmmount(), spendItemT1.getTotalAmmount());
            }
        });
    }

    public static void sortTopSpendListByAmountWIthoutInvestment(List<SpendItem> spendList) {

        Collections.sort(spendList, new Comparator<SpendItem>() {

            @Override
            public int compare(SpendItem spendItemT1, SpendItem spendItemT2) {
                if(!spendItemT1.getCategory().equalsIgnoreCase("Investment") && !spendItemT2.getCategory().equalsIgnoreCase("Investment")){
                    return Float.compare(spendItemT2.getTotalAmmount(), spendItemT1.getTotalAmmount());
                }
                else {
                    return 1;
                }
            }
        });
    }

    public static void sortDashBoardCard(List<DashBoardItem> dashBoard) {


        Collections.sort(dashBoard, new Comparator<DashBoardItem>() {
            public int compare(DashBoardItem firstItem, DashBoardItem secondItem) {
                return firstItem.getPosition() - secondItem.getPosition();
            }
        });
    }

    public static void sortBankFormats(List<BankFormatModel> bankFormatModels) {

        Collections.sort(bankFormatModels, new Comparator<BankFormatModel>() {
            public int compare(BankFormatModel firstItem, BankFormatModel secondItem) {
                return Long.compare(secondItem.getId(), firstItem.getId());
            }
        });
    }
*/

    public static String getStringFromLong(long number) {

        if (number != 0) {
            String numberString = "0";
            try {
                numberString = Long.toString(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return numberString;
        } else {
            return "0";
        }
    }



    /*public static void sortGoalListByPriority(List<GoalSelectResponse.GoalList> list) {
        if(ObjectUtils.isNotNull(list)){
            Collections.sort(list, new Comparator<GoalSelectResponse.GoalList>() {
                @Override
                public int compare(final GoalSelectResponse.GoalList object1, final GoalSelectResponse.GoalList object2) {

                    int goalPriority1 = ObjectUtils.getIntFromString(object1.getGoalPriority());
                    int goalPriority2 = ObjectUtils.getIntFromString(object2.getGoalPriority());
                    if(goalPriority1 > goalPriority2){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            });
        }
    }*/

    public static String get3DecimalString(String value) {
        try {
            String toConvert = String.format("%.3f", (new BigDecimal(value)));
            return toConvert;
        } catch (Exception e) {
            return value;
        }
    }

    public static boolean compareDates(Date currentDate, Date lastUpdatedDate, Date tenClockDate){
        return currentDate.after(tenClockDate) && currentDate.after(lastUpdatedDate) ;

    }


    public static <T> List<List<T>> getBatchesFromList(List<T> largeList , int chunkSize) {
        List<List<T>> chunkList = new ArrayList<>();
        for (int i = 0 ; i <  largeList.size() ; i += chunkSize) {
            chunkList.add(largeList.subList(i , i + chunkSize >= largeList.size() ? largeList.size() : i + chunkSize));
        }
        return chunkList;
    }

}
