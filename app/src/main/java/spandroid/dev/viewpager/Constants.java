package spandroid.dev.viewpager;

/**
 * Created by sibaprasad on 17/12/17.
 */

public interface Constants {
    // USER DATA TYPE
    int DATA_TITLE = 0;
    int DATA_SMS = 1;
    int DATA_CALLOG = 2;
    int DATA_RECORD = 3;

    // USER TAB TYPE
    int TAB_SMS = 1;
    int TAB_CALLOG = 2;
    int TAB_AUDIO = 3;

    interface BundelKey {
        String TAB_TYPE = "tabType";
        String CHILD_DATA = "childData";
        String PARENT_DATA = "parentData";
        String ISFILTER_APPLIED = "isFilterApplied";
        String PARENT_POTITION = "parentPosition";
        String CHILD_POTITION = "childPosition";
        String SMS_BODY = "smsBody";
        String SMS_DATE = "smsDate";
        String SMS_TIME = "smsTime";
        String RECIEVER = "receiver";
        String SMS_DATA = "smsData";
        String RECORD_DATA = "recordData";
    }

    interface PreferenceKey {
        String TAB_TYPE = "tabType";
    }

    interface ViewHolderType {
        int ROW_HEADER = 0;
        int ROW_SMS = 1;
        int ROW_CALLOG = 2;
        int ROW_AUDIO = 3;
    }
}