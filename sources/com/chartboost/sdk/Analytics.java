package com.chartboost.sdk;

import com.chartboost.sdk.impl.b7;
import com.chartboost.sdk.impl.y2;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007JD\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J0\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\""}, d2 = {"Lcom/chartboost/sdk/Analytics;", "", "()V", "trackInAppAmazonStorePurchaseEvent", "", "title", "", "description", "price", "currency", SDKConstants.PARAM_PRODUCT_ID, SDKConstants.PARAM_USER_ID, SDKConstants.PARAM_PURCHASE_TOKEN, "trackInAppGooglePlayPurchaseEvent", "purchaseData", "purchaseSignature", "trackInAppPurchaseEvent", "iAPPurchaseInfoMap", "Ljava/util/HashMap;", "Lcom/chartboost/sdk/Analytics$IAPPurchaseInfo;", "iapType", "Lcom/chartboost/sdk/Analytics$IAPType;", "trackLevelInfo", "eventLabel", "type", "Lcom/chartboost/sdk/Analytics$LevelType;", "mainLevel", "", "subLevel", "CustomEventType", "IAPPurchaseInfo", "IAPType", "LevelType", "MiscRevenueGeneratingEventType", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Analytics {
    public static final Analytics INSTANCE = new Analytics();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/chartboost/sdk/Analytics$CustomEventType;", "", "(Ljava/lang/String;I)V", "CustomEventType1", "CustomEventType2", "CustomEventType3", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum CustomEventType {
        CustomEventType1,
        CustomEventType2,
        CustomEventType3
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/chartboost/sdk/Analytics$IAPPurchaseInfo;", "", "(Ljava/lang/String;I)V", "PRODUCT_ID", "PRODUCT_TITLE", "PRODUCT_DESCRIPTION", "PRODUCT_PRICE", "PRODUCT_CURRENCY_CODE", "GOOGLE_PURCHASE_DATA", "GOOGLE_PURCHASE_SIGNATURE", "AMAZON_PURCHASE_TOKEN", "AMAZON_USER_ID", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum IAPPurchaseInfo {
        PRODUCT_ID,
        PRODUCT_TITLE,
        PRODUCT_DESCRIPTION,
        PRODUCT_PRICE,
        PRODUCT_CURRENCY_CODE,
        GOOGLE_PURCHASE_DATA,
        GOOGLE_PURCHASE_SIGNATURE,
        AMAZON_PURCHASE_TOKEN,
        AMAZON_USER_ID
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/chartboost/sdk/Analytics$IAPType;", "", "(Ljava/lang/String;I)V", "GOOGLE_PLAY", "AMAZON", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum IAPType {
        GOOGLE_PLAY,
        AMAZON
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/chartboost/sdk/Analytics$LevelType;", "", "levelType", "", "(Ljava/lang/String;II)V", "getLevelType", "()I", "HIGHEST_LEVEL_REACHED", "CURRENT_AREA", "CHARACTER_LEVEL", "OTHER_SEQUENTIAL", "OTHER_NONSEQUENTIAL", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LevelType {
        HIGHEST_LEVEL_REACHED(1),
        CURRENT_AREA(2),
        CHARACTER_LEVEL(3),
        OTHER_SEQUENTIAL(4),
        OTHER_NONSEQUENTIAL(5);

        private final int levelType;

        LevelType(int i) {
            this.levelType = i;
        }

        public final int getLevelType() {
            return this.levelType;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/chartboost/sdk/Analytics$MiscRevenueGeneratingEventType;", "", "(Ljava/lang/String;I)V", "MiscRevenueGeneratingEventType1", "MiscRevenueGeneratingEventType2", "MiscRevenueGeneratingEventType3", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum MiscRevenueGeneratingEventType {
        MiscRevenueGeneratingEventType1,
        MiscRevenueGeneratingEventType2,
        MiscRevenueGeneratingEventType3
    }

    private Analytics() {
    }

    @JvmStatic
    public static final void trackInAppAmazonStorePurchaseEvent(String title, String description, String price, String currency, String productID, String userID, String purchaseToken) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(productID, "productID");
        if (Chartboost.isSdkStarted()) {
            y2.b.k().a().a(productID, title, description, price, currency, null, null, userID, purchaseToken, IAPType.AMAZON);
        } else {
            b7.b("You need to call Chartboost.startWithAppId() before tracking in-app purchases", null, 2, null);
        }
    }

    @JvmStatic
    public static final void trackInAppGooglePlayPurchaseEvent(String title, String description, String price, String currency, String productID, String purchaseData, String purchaseSignature) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(productID, "productID");
        if (Chartboost.isSdkStarted()) {
            y2.b.k().a().a(productID, title, description, price, currency, purchaseData, purchaseSignature, null, null, IAPType.GOOGLE_PLAY);
        } else {
            b7.b("You need to call Chartboost.startWithAppId() before tracking in-app purchases", null, 2, null);
        }
    }

    @JvmStatic
    public static final void trackInAppPurchaseEvent(HashMap<IAPPurchaseInfo, String> iAPPurchaseInfoMap, IAPType iapType) {
        Intrinsics.checkNotNullParameter(iAPPurchaseInfoMap, "iAPPurchaseInfoMap");
        Intrinsics.checkNotNullParameter(iapType, "iapType");
        if (!Chartboost.isSdkStarted()) {
            b7.b("You need to call Chartboost.startWithAppId() before tracking in-app purchases", null, 2, null);
            return;
        }
        String str = iAPPurchaseInfoMap.get(IAPPurchaseInfo.GOOGLE_PURCHASE_DATA);
        String str2 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE);
        String str3 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.AMAZON_USER_ID);
        String str4 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.AMAZON_PURCHASE_TOKEN);
        String str5 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.PRODUCT_ID);
        String str6 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.PRODUCT_TITLE);
        String str7 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.PRODUCT_DESCRIPTION);
        String str8 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.PRODUCT_PRICE);
        String str9 = iAPPurchaseInfoMap.get(IAPPurchaseInfo.PRODUCT_CURRENCY_CODE);
        if (str5 == null || str5.length() == 0 || str6 == null || str6.length() == 0 || str7 == null || str7.length() == 0 || str8 == null || str8.length() == 0 || str9 == null || str9.length() == 0) {
            b7.b("Null object is passed. Please pass a valid value object", null, 2, null);
        } else {
            y2.b.k().a().a(str5, str6, str7, str8, str9, str, str2, str3, str4, iapType);
        }
    }

    @JvmStatic
    public static final void trackLevelInfo(String eventLabel, LevelType type, int mainLevel, String description) {
        Intrinsics.checkNotNullParameter(eventLabel, "eventLabel");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        trackLevelInfo(eventLabel, type, mainLevel, 0, description);
    }

    @JvmStatic
    public static final void trackLevelInfo(String eventLabel, LevelType type, int mainLevel, int subLevel, String description) {
        Intrinsics.checkNotNullParameter(eventLabel, "eventLabel");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        if (Chartboost.isSdkStarted()) {
            y2.b.k().a().a(eventLabel, type, mainLevel, subLevel, description, System.currentTimeMillis());
        } else {
            b7.b("You need to call Chartboost.startWithAppId() before tracking in-app purchases", null, 2, null);
        }
    }
}
