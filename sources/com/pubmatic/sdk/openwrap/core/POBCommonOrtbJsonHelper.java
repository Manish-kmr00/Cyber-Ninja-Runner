package com.pubmatic.sdk.openwrap.core;

import android.app.Application;
import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.playon.bridge.Ad;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBDSAComplianceStatus;
import com.pubmatic.sdk.common.models.POBDataProvider;
import com.pubmatic.sdk.common.models.POBExternalUserId;
import com.pubmatic.sdk.common.models.POBSegment;
import com.pubmatic.sdk.common.models.POBUserInfo;
import com.pubmatic.sdk.common.utility.POBSharedPreferenceUtil;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u001cJ\u001f\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ+\u0010#\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0003¢\u0006\u0004\b\u001b\u0010'J\u001f\u0010\u001b\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010+J\u001f\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010+J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010+J!\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u0017J)\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010.J\u001f\u0010,\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010\u001cJ\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010\u0011J\u001f\u00100\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\u001cJ\u001d\u0010\u001b\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0002¢\u0006\u0004\b\u001b\u00104R\u0014\u00105\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/POBCommonOrtbJsonHelper;", "", "<init>", "()V", "Lcom/pubmatic/sdk/openwrap/core/POBRequest;", "request", "Lorg/json/JSONArray;", "getImpressionJsonArray", "(Lcom/pubmatic/sdk/openwrap/core/POBRequest;)Lorg/json/JSONArray;", "getCurrencyJson", "()Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "getMeasurementJson", "()Lorg/json/JSONObject;", "regsExt", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;)V", "Landroid/content/Context;", "context", "Lcom/pubmatic/sdk/common/POBAdFormat;", "placementType", "getUserJson", "(Landroid/content/Context;Lcom/pubmatic/sdk/common/POBAdFormat;)Lorg/json/JSONObject;", "getRegsJson", "(Landroid/content/Context;)Lorg/json/JSONObject;", "regsJsonObject", "a", "(Landroid/content/Context;Lorg/json/JSONObject;)V", "d", "e", "json", "", "key", Ad.VERIFICATIONPARAM, "addParamToJson", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/pubmatic/sdk/common/models/POBUserInfo;", "userInfo", "(Lcom/pubmatic/sdk/common/models/POBUserInfo;)Lorg/json/JSONArray;", "Lcom/pubmatic/sdk/common/models/POBDataProvider;", "dataProvider", "dataJson", "(Lcom/pubmatic/sdk/common/models/POBDataProvider;Lorg/json/JSONObject;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "userExtJsonObject", "(Landroid/content/Context;Lcom/pubmatic/sdk/common/POBAdFormat;Lorg/json/JSONObject;)V", "userExt", InneractiveMediationDefs.GENDER_FEMALE, "", "Lcom/pubmatic/sdk/common/models/POBExternalUserId;", "userIds", "(Ljava/util/List;)Lorg/json/JSONArray;", "TAG", "Ljava/lang/String;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1})
public final class POBCommonOrtbJsonHelper {
    public static final POBCommonOrtbJsonHelper INSTANCE = new POBCommonOrtbJsonHelper();
    public static final String TAG = "POBCommonOrtbJsonHelper";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[POBUserInfo.Gender.values().length];
            iArr[POBUserInfo.Gender.MALE.ordinal()] = 1;
            iArr[POBUserInfo.Gender.FEMALE.ordinal()] = 2;
            iArr[POBUserInfo.Gender.OTHER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private POBCommonOrtbJsonHelper() {
    }

    private final void a(JSONObject regsJsonObject) throws JSONException {
        Boolean boolIsCoppa = POBInstanceProvider.getSdkConfig().isCoppa();
        if (boolIsCoppa != null) {
            regsJsonObject.put("coppa", boolIsCoppa.booleanValue() ? 1 : 0);
        }
    }

    @JvmStatic
    public static final void addParamToJson(JSONObject json, String key, String param) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (json == null || POBUtils.isNullOrEmpty(param)) {
            return;
        }
        try {
            json.put(key, param);
        } catch (JSONException unused) {
            POBLog.warn(TAG, "Unable to add " + key + " and " + param, new Object[0]);
        }
    }

    private final void b(JSONObject regsExt) throws JSONException {
        POBDSAComplianceStatus dsaComplianceStatus = POBInstanceProvider.getSdkConfig().getDsaComplianceStatus();
        Intrinsics.checkNotNullExpressionValue(dsaComplianceStatus, "getSdkConfig().dsaComplianceStatus");
        if (dsaComplianceStatus != POBDSAComplianceStatus.NOT_REQUIRED) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(POBConstants.KEY_DSA_REQUIRED, dsaComplianceStatus.getValue());
            jSONObject.put(POBConstants.KEY_PUB_RENDER, 2);
            jSONObject.put(POBConstants.KEY_DATA_TO_PUB, 1);
            regsExt.put(POBConstants.KEY_DSA, jSONObject);
        }
    }

    private final void c(POBDataProvider dataProvider, JSONObject dataJson) throws JSONException {
        Map<String, POBSegment> segments = dataProvider.getSegments();
        Intrinsics.checkNotNullExpressionValue(segments, "dataProvider.segments");
        if (segments.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (POBSegment pOBSegment : segments.values()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", pOBSegment.getSegId());
            String it = pOBSegment.getName();
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.length() <= 0) {
                    it = null;
                }
                if (it != null) {
                    jSONObject.put("name", it);
                }
            }
            String it2 = pOBSegment.getValue();
            if (it2 != null) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                String str = it2.length() > 0 ? it2 : null;
                if (str != null) {
                    jSONObject.put("value", str);
                }
            }
            jSONArray.put(jSONObject);
        }
        if (jSONArray.length() > 0) {
            dataJson.put("segment", jSONArray);
        }
    }

    private final void d(Context context, JSONObject regsExt) throws JSONException {
        String stringFromSharedPreference = POBSharedPreferenceUtil.getStringFromSharedPreference(context, "IABGPP_HDR_GppString", null);
        if (POBUtils.isNullOrEmpty(stringFromSharedPreference)) {
            return;
        }
        regsExt.put("gpp", stringFromSharedPreference);
    }

    private final void e(Context context, JSONObject regsExt) throws JSONException {
        String stringFromSharedPreference = POBSharedPreferenceUtil.getStringFromSharedPreference(context, "IABGPP_GppSID", null);
        if (stringFromSharedPreference != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : StringsKt.split$default((CharSequence) stringFromSharedPreference, new String[]{"_"}, false, 0, 6, (Object) null)) {
                try {
                    jSONArray.put(Integer.parseInt(str));
                } catch (NumberFormatException unused) {
                    POBLog.warn(TAG, POBLogConstants.MSG_INVALID_GPP_SID, str);
                }
            }
            if (jSONArray.length() > 0) {
                regsExt.put("gpp_sid", jSONArray);
            }
        }
    }

    private final void f(Context context, JSONObject userExt) throws JSONException {
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            userExt.put(POBConstants.KEY_SESSION_DURATION, POBInstanceProvider.getApplicationSessionHandler(application).getSessionDuration());
        } else {
            POBLog.error(TAG, POBLogConstants.MSG_FAILED_TO_GET_APPLICATION_INSTANCE, new Object[0]);
        }
    }

    @JvmStatic
    public static final JSONArray getCurrencyJson() {
        JSONArray jSONArrayPut = new JSONArray().put("USD");
        Intrinsics.checkNotNullExpressionValue(jSONArrayPut, "JSONArray().put(\"USD\")");
        return jSONArrayPut;
    }

    @JvmStatic
    public static final JSONArray getImpressionJsonArray(POBRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        JSONArray jSONArray = new JSONArray();
        POBImpression[] impressions = request.getImpressions();
        if (impressions != null) {
            for (POBImpression pOBImpression : impressions) {
                try {
                    jSONArray.put(pOBImpression.getImpressionJson());
                } catch (JSONException e) {
                    POBLog.error(TAG, "Exception occurred in getImpressionJson(): " + e.getMessage(), new Object[0]);
                }
            }
        }
        return jSONArray;
    }

    @JvmStatic
    public static final JSONObject getMeasurementJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("omidpn", POBCommonConstants.PARTNER_NAME);
            jSONObject.putOpt("omidpv", "4.5.1");
            return new JSONObject().putOpt("ext", jSONObject);
        } catch (JSONException e) {
            POBLog.error(TAG, "Exception occurred in getMeasurementParam() : " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JvmStatic
    public static final JSONObject getRegsJson(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            JSONObject jSONObject = new JSONObject();
            POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper = INSTANCE;
            pOBCommonOrtbJsonHelper.a(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            pOBCommonOrtbJsonHelper.b(context, jSONObject2);
            pOBCommonOrtbJsonHelper.a(context, jSONObject2);
            pOBCommonOrtbJsonHelper.d(context, jSONObject2);
            pOBCommonOrtbJsonHelper.e(context, jSONObject2);
            pOBCommonOrtbJsonHelper.b(jSONObject2);
            if (jSONObject2.length() == 0) {
                return jSONObject;
            }
            jSONObject.put("ext", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            POBLog.error(TAG, "Exception occurred in getRegsJson() : " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    @JvmStatic
    public static final JSONObject getUserJson(Context context, POBAdFormat placementType) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject jSONObject = new JSONObject();
        try {
            POBUserInfo it = POBInstanceProvider.getSdkConfig().getUserInfo();
            if (it != null) {
                POBUserInfo.Gender gender = it.getGender();
                int i = gender == null ? -1 : WhenMappings.$EnumSwitchMapping$0[gender.ordinal()];
                if (i == 1) {
                    jSONObject.put("gender", "M");
                } else if (i == 2) {
                    jSONObject.put("gender", "F");
                } else if (i == 3) {
                    jSONObject.put("gender", "O");
                }
                if (it.getBirthYear() > 0) {
                    jSONObject.put("yob", it.getBirthYear());
                }
                if (!POBUtils.isNullOrEmpty(it.getKeywords())) {
                    jSONObject.put("keywords", it.getKeywords());
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                JSONArray jSONArrayA = a(it);
                if (jSONArrayA.length() > 0) {
                    jSONObject.put("data", jSONArrayA);
                }
            }
            JSONObject jSONObjectA = INSTANCE.a(context, placementType);
            if (jSONObjectA.length() > 0) {
                jSONObject.put("ext", jSONObjectA);
            }
            return jSONObject;
        } catch (JSONException e) {
            POBLog.error(TAG, "Exception occurred in getUserJson() : " + e.getMessage(), new Object[0]);
            return jSONObject;
        }
    }

    private final void a(Context context, JSONObject regsExt) throws JSONException {
        String stringFromSharedPreference = POBSharedPreferenceUtil.getStringFromSharedPreference(context, "IABUSPrivacy_String", null);
        if (POBUtils.isNullOrEmpty(stringFromSharedPreference)) {
            return;
        }
        regsExt.put("us_privacy", stringFromSharedPreference);
    }

    private final void b(Context context, JSONObject regsExt) throws JSONException {
        Integer integerFromSharedPreference = POBSharedPreferenceUtil.getIntegerFromSharedPreference(context, "IABTCF_gdprApplies");
        if (integerFromSharedPreference != null) {
            regsExt.put("gdpr", integerFromSharedPreference.intValue());
        }
    }

    private static final JSONArray a(POBUserInfo userInfo) {
        JSONArray jSONArray = new JSONArray();
        try {
            List<POBDataProvider> dataProviders = userInfo.getDataProviders();
            Intrinsics.checkNotNullExpressionValue(dataProviders, "userInfo.getDataProviders()");
            for (POBDataProvider dataProvider : dataProviders) {
                JSONObject jSONObject = new JSONObject();
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(dataProvider, "dataProvider");
                pOBCommonOrtbJsonHelper.a(dataProvider, jSONObject);
                pOBCommonOrtbJsonHelper.c(dataProvider, jSONObject);
                pOBCommonOrtbJsonHelper.b(dataProvider, jSONObject);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            POBLog.error(TAG, "Exception occurred in getUserDataJson() : " + e.getMessage(), new Object[0]);
        }
        return jSONArray;
    }

    private final void b(POBDataProvider dataProvider, JSONObject dataJson) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject ext = dataProvider.getExt();
        if (ext != null) {
            jSONObject = ext;
        }
        if (dataProvider.getSegTax() > 0) {
            jSONObject.put(POBConstants.KEY_SEGTAX, dataProvider.getSegTax());
        }
        if (jSONObject.length() > 0) {
            dataJson.put("ext", jSONObject);
        }
    }

    private final void c(Context context, JSONObject userExt) throws JSONException {
        String stringFromSharedPreference = POBSharedPreferenceUtil.getStringFromSharedPreference(context, "IABTCF_TCString", null);
        if (POBUtils.isNullOrEmpty(stringFromSharedPreference)) {
            return;
        }
        userExt.put("consent", stringFromSharedPreference);
    }

    private final void c(JSONObject userExt) throws JSONException {
        Map<String, List<POBExternalUserId>> externalUserIds = POBInstanceProvider.getSdkConfig().getExternalUserIds();
        Intrinsics.checkNotNullExpressionValue(externalUserIds, "getSdkConfig().externalUserIds");
        JSONArray jSONArray = new JSONArray();
        if (externalUserIds.isEmpty()) {
            externalUserIds = null;
        }
        if (externalUserIds != null) {
            for (Map.Entry<String, List<POBExternalUserId>> entry : externalUserIds.entrySet()) {
                String key = entry.getKey();
                List<POBExternalUserId> value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("source", key);
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(value, "value");
                jSONObject.put(POBConstants.KEY_UIDS, pOBCommonOrtbJsonHelper.a(value));
                jSONArray.put(jSONObject);
            }
        }
        if (jSONArray.length() > 0) {
            userExt.put(POBConstants.KEY_EIDS, jSONArray);
        }
    }

    private final void a(POBDataProvider dataProvider, JSONObject dataJson) throws JSONException {
        String id = dataProvider.getId();
        if (id != null) {
            if (id.length() <= 0) {
                id = null;
            }
            if (id != null) {
                dataJson.put("id", id);
            }
        }
        dataJson.put("name", dataProvider.getName());
    }

    private final JSONObject a(Context context, POBAdFormat placementType) {
        JSONObject jSONObject = new JSONObject();
        try {
            c(context, jSONObject);
            c(jSONObject);
            f(context, jSONObject);
            a(context, placementType, jSONObject);
            POBLog.debug(TAG, jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            POBLog.error(TAG, "Exception occurred in getUserExtJson() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    private final void a(Context context, POBAdFormat placementType, JSONObject userExtJsonObject) throws JSONException {
        if (placementType != null) {
            Context applicationContext = context.getApplicationContext();
            Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
            if (application != null) {
                userExtJsonObject.put(POBConstants.KEY_IMP_DEPTH, POBInstanceProvider.getImpDepthHandler(POBInstanceProvider.getApplicationSessionHandler(application)).getImpressions(placementType));
            } else {
                POBLog.error(TAG, POBLogConstants.MSG_FAILED_TO_GET_APPLICATION_INSTANCE, new Object[0]);
            }
        }
    }

    private final JSONArray a(List userIds) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator it = userIds.iterator();
        while (it.hasNext()) {
            POBExternalUserId pOBExternalUserId = (POBExternalUserId) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", pOBExternalUserId.getId());
            if (pOBExternalUserId.getAtype() > 0) {
                jSONObject.put(POBConstants.KEY_ATYPE, pOBExternalUserId.getAtype());
            }
            JSONObject extension = pOBExternalUserId.getExtension();
            if (extension != null) {
                if (extension.length() == 0) {
                    extension = null;
                }
                if (extension != null) {
                    jSONObject.put("ext", extension);
                }
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
