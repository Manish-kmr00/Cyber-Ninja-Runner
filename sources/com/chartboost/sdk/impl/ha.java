package com.chartboost.sdk.impl;

import bolts.MeasurementEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\n\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\fJ\u001b\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u001b\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u0007\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u001b\u0010\u0007\u001a\u00020\t*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\u0007\u001a\u00020\t*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0010J\u001f\u0010\n\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/ha;", "", "Lcom/chartboost/sdk/impl/ka;", "event", "Lcom/chartboost/sdk/impl/i4;", "environment", "", "a", "(Lcom/chartboost/sdk/impl/ka;Lcom/chartboost/sdk/impl/i4;)Ljava/lang/String;", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;Lcom/chartboost/sdk/impl/i4;)Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lcom/chartboost/sdk/impl/ka;)Lorg/json/JSONObject;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "impressionAdType", "(Lorg/json/JSONObject;Lcom/chartboost/sdk/impl/i4;Ljava/lang/String;)Lorg/json/JSONObject;", "(Lcom/chartboost/sdk/impl/i4;Ljava/lang/String;)Lorg/json/JSONObject;", "impressionType", "", "(Lcom/chartboost/sdk/impl/i4;Ljava/lang/String;)I", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "jsonFactory", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function0<JSONObject> jsonFactory;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<JSONObject> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final JSONObject invoke() {
            return new JSONObject();
        }
    }

    public ha() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ha(Function0<? extends JSONObject> jsonFactory) {
        Intrinsics.checkNotNullParameter(jsonFactory, "jsonFactory");
        this.jsonFactory = jsonFactory;
    }

    public /* synthetic */ ha(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? a.b : function0);
    }

    public final JSONObject b(JSONObject jSONObject, ka kaVar) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject.put(MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY, kaVar.getName().getValue());
            jSONObject.put("event_message", kaVar.getMessage());
            jSONObject.put("event_type", kaVar.getType().name());
            jSONObject.put("event_timestamp", kaVar.j());
            JSONObject jSONObjectPut = jSONObject.put("event_latency", kaVar.getLatency());
            JSONObject jSONObject2 = jSONObjectPut;
            if (jSONObjectPut == null) {
                jSONObject2 = jSONObject;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final JSONObject c(JSONObject jSONObject, ka kaVar) {
        Object objM7904constructorimpl;
        JSONObject jSONObject2;
        JSONObject jSONObjectPut;
        try {
            Result.Companion companion = Result.INSTANCE;
            Mediation mediation = kaVar.getMediation();
            if (mediation != null) {
                jSONObject.put("mediation_sdk", mediation.mediationType);
                jSONObject.put("mediation_sdk_version", mediation.libraryVersion);
                jSONObjectPut = jSONObject.put("mediation_sdk_adapter_version", mediation.adapterVersion);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 == null) {
                jSONObject2 = jSONObjectPut;
                jSONObject2 = jSONObject;
            }
            jSONObject2 = jSONObjectPut;
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final JSONObject a(JSONObject jSONObject, ka kaVar) {
        Object objM7904constructorimpl;
        String adImpressionId;
        String adCreativeId;
        String templateUrl;
        JSONObject jSONObject2;
        da.a adSize;
        JSONObject jSONObjectPut;
        try {
            Result.Companion companion = Result.INSTANCE;
            String lowerCase = kaVar.getImpressionAdType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject.put("ad_type", lowerCase);
            da trackAd = kaVar.getTrackAd();
            if (trackAd == null || (adImpressionId = trackAd.getAdImpressionId()) == null) {
                adImpressionId = "missing impression id";
            }
            jSONObject.put("ad_impression_id", adImpressionId);
            da trackAd2 = kaVar.getTrackAd();
            if (trackAd2 == null || (adCreativeId = trackAd2.getAdCreativeId()) == null) {
                adCreativeId = "missing creative id";
            }
            jSONObject.put("ad_creative_id", adCreativeId);
            jSONObject.put("ad_location_id", kaVar.getLocation());
            da trackAd3 = kaVar.getTrackAd();
            if (trackAd3 == null || (templateUrl = trackAd3.getTemplateUrl()) == null) {
                templateUrl = "";
            }
            jSONObject.put("template_url", templateUrl);
            da trackAd4 = kaVar.getTrackAd();
            if (trackAd4 == null || (adSize = trackAd4.getAdSize()) == null) {
                jSONObject2 = null;
            } else {
                jSONObject.put("ad_height", adSize.getHeight());
                jSONObjectPut = jSONObject.put("ad_width", adSize.getWidth());
            }
            if (jSONObject2 == null) {
                jSONObject2 = jSONObjectPut;
                jSONObject2 = jSONObject;
            }
            jSONObject2 = jSONObjectPut;
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final JSONObject b(JSONObject jSONObject, i4 i4Var) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject.put("app_id", i4Var.getAppId());
            JSONObject jSONObjectPut = jSONObject.put("chartboost_sdk_version", i4Var.getChartboostSdkVersion());
            JSONObject jSONObject2 = jSONObjectPut;
            if (jSONObjectPut == null) {
                jSONObject2 = jSONObject;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final JSONObject c(JSONObject jSONObject, i4 i4Var) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, i4Var.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String());
            JSONObject jSONObjectPut = jSONObject.put("session_count", i4Var.getSessionCount());
            JSONObject jSONObject2 = jSONObjectPut;
            if (jSONObjectPut == null) {
                jSONObject2 = jSONObject;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final JSONObject a(JSONObject jSONObject, i4 i4Var) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject.put("device_id", i4Var.getDeviceId());
            jSONObject.put("device_make", i4Var.getDeviceMake());
            jSONObject.put("device_model", i4Var.getCom.ironsource.b9.i.l java.lang.String());
            jSONObject.put("device_os_version", i4Var.getDeviceOsVersion());
            jSONObject.put("device_platform", i4Var.getDevicePlatform());
            jSONObject.put("device_country", i4Var.getDeviceCountry());
            jSONObject.put("device_connection_type", i4Var.getDeviceConnectionType());
            JSONObject jSONObjectPut = jSONObject.put(BrandSafetyEvent.aw, i4Var.getDeviceOrientation());
            JSONObject jSONObject2 = jSONObjectPut;
            if (jSONObjectPut == null) {
                jSONObject2 = jSONObject;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final int b(i4 environment, String impressionType) {
        if (Intrinsics.areEqual(impressionType, u.b.g.getName())) {
            return environment.getSessionImpressionInterstitialCount();
        }
        if (Intrinsics.areEqual(impressionType, u.c.g.getName())) {
            return environment.getSessionImpressionRewardedCount();
        }
        if (Intrinsics.areEqual(impressionType, u.a.g.getName())) {
            return environment.getSessionImpressionBannerCount();
        }
        return 0;
    }

    public final JSONObject a(JSONObject jSONObject, i4 i4Var, String str) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObjectPut = jSONObject.put("payload", a(i4Var, str));
            JSONObject jSONObject2 = jSONObjectPut;
            if (jSONObjectPut == null) {
                jSONObject2 = jSONObject;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObject;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }

    public final String a(ka event, i4 environment) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(environment, "environment");
        String string = a(a(a(c(c(b(b(this.jsonFactory.invoke(), environment), event), environment), event), event), environment), environment, event.getImpressionAdType()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonFactory()\n          …)\n            .toString()");
        return string;
    }

    public final JSONObject a(i4 environment, String impressionAdType) {
        Object objM7904constructorimpl;
        JSONObject jSONObjectInvoke = this.jsonFactory.invoke();
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObjectInvoke.put("device_battery_level", environment.getDeviceBatteryLevel());
            jSONObjectInvoke.put("device_charging_status", environment.getDeviceChargingStatus());
            jSONObjectInvoke.put("device_language", environment.getDeviceLanguage());
            jSONObjectInvoke.put("device_timezone", environment.getDeviceTimezone());
            jSONObjectInvoke.put("device_volume", environment.getCom.ironsource.b9.i.P java.lang.String());
            jSONObjectInvoke.put("device_mute", environment.getDeviceMute());
            jSONObjectInvoke.put("device_audio_output", environment.getDeviceAudioOutput());
            jSONObjectInvoke.put("device_storage", environment.getDeviceStorage());
            jSONObjectInvoke.put("device_low_memory_warning", environment.getDeviceLowMemoryWarning());
            jSONObjectInvoke.put("device_up_time", environment.getDeviceUpTime());
            jSONObjectInvoke.put("chartboost_sdk_autocache_enabled", environment.getChartboostSdkAutocacheEnabled());
            jSONObjectInvoke.put("chartboost_sdk_gdpr", environment.getChartboostSdkGdpr());
            jSONObjectInvoke.put("chartboost_sdk_ccpa", environment.getChartboostSdkCcpa());
            jSONObjectInvoke.put("chartboost_sdk_coppa", environment.getChartboostSdkCoppa());
            jSONObjectInvoke.put("chartboost_sdk_lgpd", environment.getChartboostSdkLgpd());
            jSONObjectInvoke.put("session_duration", environment.getSessionDuration());
            JSONObject jSONObjectPut = jSONObjectInvoke.put("session_impression_count", b(environment, impressionAdType));
            JSONObject jSONObject = jSONObjectPut;
            if (jSONObjectPut == null) {
                jSONObject = jSONObjectInvoke;
            }
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot generate tracking body data: ", thM7907exceptionOrNullimpl);
        }
        Object obj = jSONObjectInvoke;
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            obj = objM7904constructorimpl;
        }
        return (JSONObject) obj;
    }
}
