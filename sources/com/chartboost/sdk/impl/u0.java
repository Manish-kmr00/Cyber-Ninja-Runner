package com.chartboost.sdk.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Analytics;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010'\u001a\u00020%\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b3\u00104J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJe\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\r\u0010\u0019J\u000f\u0010\r\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\r\u0010\u001bJ#\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\r\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u001eJ\u0017\u0010\r\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010 J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\r\u0010\"J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010!\u001a\u00020#H\u0002¢\u0006\u0004\b\r\u0010$R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/chartboost/sdk/impl/u0;", "", "", "eventLabel", "Lcom/chartboost/sdk/Analytics$LevelType;", "type", "", "mainLevel", "subLevel", "description", "", "timestamp", "", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/Analytics$LevelType;IILjava/lang/String;J)V", SDKConstants.PARAM_PRODUCT_ID, "title", "price", "currency", "purchaseData", "purchaseSignature", SDKConstants.PARAM_USER_ID, SDKConstants.PARAM_PURCHASE_TOKEN, "Lcom/chartboost/sdk/Analytics$IAPType;", "iapType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/Analytics$IAPType;)V", "", "()Z", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "", "(Ljava/lang/String;)F", "requestData", "(Lorg/json/JSONObject;)V", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", "Lcom/chartboost/sdk/impl/p9;", "Lcom/chartboost/sdk/impl/p9;", "sdkInitializer", "Lcom/chartboost/sdk/impl/g2;", "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/d9;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", "Lcom/chartboost/sdk/impl/l4;", "d", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/p9;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/d9;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p9 sdkInitializer;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final d9 requestBodyBuilder;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final l4 eventTracker;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1148a;

        static {
            int[] iArr = new int[Analytics.IAPType.values().length];
            try {
                iArr[Analytics.IAPType.GOOGLE_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Analytics.IAPType.AMAZON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f1148a = iArr;
        }
    }

    public u0(p9 sdkInitializer, g2 networkService, d9 requestBodyBuilder, l4 eventTracker) {
        Intrinsics.checkNotNullParameter(sdkInitializer, "sdkInitializer");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(requestBodyBuilder, "requestBodyBuilder");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.sdkInitializer = sdkInitializer;
        this.networkService = networkService;
        this.requestBodyBuilder = requestBodyBuilder;
        this.eventTracker = eventTracker;
    }

    public final JSONObject b(String purchaseData, String purchaseSignature) throws JSONException {
        if (purchaseData != null && purchaseData.length() != 0 && purchaseSignature != null && purchaseSignature.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("purchaseData", purchaseData);
            jSONObject.put("purchaseSignature", purchaseSignature);
            jSONObject.put("type", Analytics.IAPType.GOOGLE_PLAY.ordinal());
            return jSONObject;
        }
        b7.b("Null object is passed for for purchase data or purchase signature", null, 2, null);
        return new JSONObject();
    }

    public final JSONObject a(String userID, String purchaseToken) throws JSONException {
        if (userID != null && userID.length() != 0 && purchaseToken != null && purchaseToken.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SDKConstants.PARAM_USER_ID, userID);
            jSONObject.put(SDKConstants.PARAM_PURCHASE_TOKEN, purchaseToken);
            jSONObject.put("type", Analytics.IAPType.AMAZON.ordinal());
            return jSONObject;
        }
        b7.b("Null object is passed for for amazon user id or amazon purchase token", null, 2, null);
        return new JSONObject();
    }

    public final boolean a() {
        return this.sdkInitializer.getIsSDKInitialized();
    }

    public final void a(JSONObject requestData) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s%s", Arrays.copyOf(new Object[]{"/post-install-event/", "iap"}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        i2 i2Var = new i2("https://live.chartboost.com", str, this.requestBodyBuilder.a(), k8.NORMAL, "iap", null, this.eventTracker);
        i2Var.a("iap", requestData);
        i2Var.checkStatusInResponseBody = true;
        this.networkService.a(i2Var);
    }

    public final void a(JSONArray requestData) {
        i2 i2Var = new i2("https://live.chartboost.com", "/post-install-event/tracking", this.requestBodyBuilder.a(), k8.NORMAL, "tracking", null, this.eventTracker);
        i2Var.a("track_info", requestData);
        i2Var.checkStatusInResponseBody = true;
        this.networkService.a(i2Var);
    }

    public final void a(String productID, String title, String description, String price, String currency, String purchaseData, String purchaseSignature, String userID, String purchaseToken, Analytics.IAPType iapType) {
        JSONObject jSONObjectB;
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(iapType, "iapType");
        try {
            if (!a()) {
                b7.b("You need call Chartboost.startWithAppId() before tracking in-app purchases", null, 2, null);
                return;
            }
            float fA = a(price);
            if (fA == -1.0f) {
                return;
            }
            int i = a.f1148a[iapType.ordinal()];
            if (i == 1) {
                jSONObjectB = b(purchaseData, purchaseSignature);
            } else if (i == 2) {
                jSONObjectB = a(userID, purchaseToken);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (jSONObjectB.length() == 0) {
                b7.b("Error while parsing the receipt to a JSON Object", null, 2, null);
                return;
            }
            String string = jSONObjectB.toString();
            Intrinsics.checkNotNullExpressionValue(string, "receipt.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("localized-title", title);
            jSONObject.put("localized-description", description);
            jSONObject.put("price", Float.valueOf(fA));
            jSONObject.put("currency", currency);
            jSONObject.put(SDKConstants.PARAM_PRODUCT_ID, productID);
            jSONObject.put("receipt", strEncodeToString);
            a(jSONObject);
        } catch (Exception e) {
            b7.b("", e);
        }
    }

    public final void a(String eventLabel, Analytics.LevelType type, int mainLevel, int subLevel, String description, long timestamp) {
        Intrinsics.checkNotNullParameter(eventLabel, "eventLabel");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        try {
            if (!a()) {
                b7.b("You need call Chartboost.startWithAppId() before tracking in-app purchases", null, 2, null);
                return;
            }
            if (eventLabel.length() == 0) {
                b7.b("Invalid value: event label cannot be empty or null", null, 2, null);
                return;
            }
            if (mainLevel >= 0 && subLevel >= 0) {
                if (description.length() == 0) {
                    b7.b("Invalid value: description cannot be empty or null", null, 2, null);
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_label", eventLabel);
                jSONObject.put("event_field", type.getLevelType());
                jSONObject.put("main_level", mainLevel);
                jSONObject.put("sub_level", subLevel);
                jSONObject.put("description", description);
                jSONObject.put("timestamp", timestamp);
                jSONObject.put("data_type", "level_info");
                jSONArray.put(jSONObject);
                a(jSONArray);
                return;
            }
            b7.b("Invalid value: Level number should be > 0", null, 2, null);
        } catch (Exception e) {
            b7.b("", e);
        }
    }

    public final float a(String price) {
        try {
            Matcher matcher = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(price);
            matcher.find();
            String result = matcher.group();
            if (TextUtils.isEmpty(result)) {
                b7.b("Invalid price object", null, 2, null);
                return -1.0f;
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            return Float.parseFloat(result);
        } catch (IllegalStateException e) {
            b7.b("Invalid price object", e);
            return -1.0f;
        }
    }
}
