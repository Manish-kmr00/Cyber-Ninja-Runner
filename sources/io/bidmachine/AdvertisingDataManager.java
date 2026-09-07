package io.bidmachine;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import io.bidmachine.core.Logger;
import io.bidmachine.utils.SharedPreferenceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class AdvertisingDataManager {
    private static final String GENERATED_ADVERTISING_ID = UUID.randomUUID().toString();
    private static final List<AdvertisingDataRetriever> PERSONAL_DATA_RETRIEVER_LIST;
    private static final String SHARED_PREFERENCES_NAME = "ad_core_preferences";
    private static final String UUID_ID = "uuid";
    private static final String ZERO_ADVERTISING_ID = "00000000-0000-0000-0000-000000000000";
    private static AdvertisingData advertisingData;
    private static String storedAdvertisingId;
    private static AdvertisingDataRetriever successfulAdvertisingDataRetriever;

    AdvertisingDataManager() {
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        PERSONAL_DATA_RETRIEVER_LIST = arrayList;
        arrayList.add(new GoogleAdvertisingDataRetriever());
        arrayList.add(new HuaweiAdvertisingDataRetriever());
    }

    static void updateInfo(Context context) {
        AdvertisingDataRetriever advertisingDataRetriever = successfulAdvertisingDataRetriever;
        if (advertisingDataRetriever != null) {
            AdvertisingData advertisingDataRetrieve = advertisingDataRetriever.retrieve(context);
            if (advertisingDataRetrieve != null) {
                advertisingData = advertisingDataRetrieve;
                return;
            }
            return;
        }
        for (AdvertisingDataRetriever advertisingDataRetriever2 : PERSONAL_DATA_RETRIEVER_LIST) {
            AdvertisingData advertisingDataRetrieve2 = advertisingDataRetriever2.retrieve(context);
            if (advertisingDataRetrieve2 != null) {
                successfulAdvertisingDataRetriever = advertisingDataRetriever2;
                advertisingData = advertisingDataRetrieve2;
                return;
            }
        }
    }

    static boolean isLimitAdTrackingEnabled() {
        AdvertisingData advertisingData2 = advertisingData;
        return advertisingData2 != null && advertisingData2.isLimitAdTrackingEnabled();
    }

    static String getAdvertisingId(Context context, boolean z) {
        if (z) {
            return ZERO_ADVERTISING_ID;
        }
        AdvertisingData advertisingData2 = advertisingData;
        String id = advertisingData2 != null ? advertisingData2.getId() : null;
        return (TextUtils.isEmpty(id) || ZERO_ADVERTISING_ID.equals(id)) ? obtainStoredAdvertisingId(context) : id;
    }

    private static String obtainStoredAdvertisingId(Context context) {
        if (!TextUtils.isEmpty(storedAdvertisingId)) {
            return storedAdvertisingId;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        String strOptString = SharedPreferenceUtils.optString(sharedPreferences, "uuid", null);
        storedAdvertisingId = strOptString;
        if (!TextUtils.isEmpty(strOptString)) {
            return storedAdvertisingId;
        }
        storedAdvertisingId = GENERATED_ADVERTISING_ID;
        sharedPreferences.edit().putString("uuid", storedAdvertisingId).apply();
        return storedAdvertisingId;
    }

    public static class AdvertisingData {
        private final String id;
        private final boolean limitAdTrackingEnabled;

        public AdvertisingData(String str, boolean z) {
            this.id = str;
            this.limitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.id;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    private static abstract class AdvertisingDataRetriever {
        private final AtomicBoolean isRetrieverAvailable = new AtomicBoolean(true);

        protected abstract AdvertisingData createAdvertisingData(Context context) throws Throwable;

        public AdvertisingData retrieve(Context context) {
            if (!isRetrieverAvailable()) {
                return null;
            }
            try {
                return createAdvertisingData(context);
            } catch (NoClassDefFoundError e) {
                setIsRetrieverAvailable(false);
                Logger.w(e);
                return null;
            } catch (Throwable th) {
                Logger.w(th);
                return null;
            }
        }

        protected void setIsRetrieverAvailable(boolean z) {
            this.isRetrieverAvailable.set(z);
        }

        private boolean isRetrieverAvailable() {
            return this.isRetrieverAvailable.get();
        }
    }

    private static class GoogleAdvertisingDataRetriever extends AdvertisingDataRetriever {
        private GoogleAdvertisingDataRetriever() {
        }

        @Override // io.bidmachine.AdvertisingDataManager.AdvertisingDataRetriever
        protected AdvertisingData createAdvertisingData(Context context) throws Throwable {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                if (advertisingIdInfo != null) {
                    return new AdvertisingData(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
                }
                return null;
            } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException unused) {
                setIsRetrieverAvailable(false);
                return null;
            }
        }
    }

    private static class HuaweiAdvertisingDataRetriever extends AdvertisingDataRetriever {
        private HuaweiAdvertisingDataRetriever() {
        }

        @Override // io.bidmachine.AdvertisingDataManager.AdvertisingDataRetriever
        protected AdvertisingData createAdvertisingData(Context context) throws Throwable {
            com.huawei.hms.ads.identifier.AdvertisingIdClient.Info advertisingIdInfo = com.huawei.hms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new AdvertisingData(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
            }
            return null;
        }
    }
}
