package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018¨\u00061"}, d2 = {"Lcom/chartboost/sdk/impl/q2;", "Lcom/chartboost/sdk/impl/i2;", "", InneractiveMediationDefs.GENDER_FEMALE, "()V", "", "key", "", "value", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;Ljava/lang/Object;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "m", "n", "o", "p", "Lcom/chartboost/sdk/impl/m8;", "privacyBodyFields", "a", "(Lcom/chartboost/sdk/impl/m8;)V", CampaignEx.JSON_KEY_AD_Q, "l", "Lorg/json/JSONObject;", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lorg/json/JSONObject;", "sdkBody", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "appBody", "v", "deviceBody", "w", "adBody", VastAttributes.HORIZONTAL_POSITION, "bidRequestBody", "Lcom/chartboost/sdk/impl/c2$c;", "method", "host", "path", "Lcom/chartboost/sdk/impl/f9;", "requestBodyFields", "Lcom/chartboost/sdk/impl/k8;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "eventType", "Lcom/chartboost/sdk/impl/i2$a;", "callback", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/c2$c;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/k8;Ljava/lang/String;Lcom/chartboost/sdk/impl/i2$a;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class q2 extends i2 {

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final JSONObject sdkBody;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final JSONObject appBody;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final JSONObject deviceBody;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final JSONObject adBody;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public final JSONObject bidRequestBody;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1112a;

        static {
            int[] iArr = new int[qa.values().length];
            try {
                iArr[qa.TRACKING_LIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[qa.TRACKING_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f1112a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(c2.c method, String host, String path, f9 requestBodyFields, k8 priority, String str, i2.a aVar, l4 eventTracker) {
        super(method, host, path, requestBodyFields, priority, str, aVar, eventTracker);
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(requestBodyFields, "requestBodyFields");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.sdkBody = new JSONObject();
        this.appBody = new JSONObject();
        this.deviceBody = new JSONObject();
        this.adBody = new JSONObject();
        this.bidRequestBody = new JSONObject();
    }

    public final void b(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        z1.a(this.adBody, key, value);
        a(Reporting.Key.CLICK_SOURCE_TYPE_AD, this.adBody);
    }

    public final void c(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        z1.a(this.sdkBody, key, value);
        a("sdk", this.sdkBody);
    }

    @Override // com.chartboost.sdk.impl.i2
    public void f() {
        m();
        n();
        o();
        q();
        l();
    }

    public final void m() {
        JSONObject jSONObject = this.appBody;
        f9 requestBodyFields = getRequestBodyFields();
        z1.a(jSONObject, "app", requestBodyFields != null ? requestBodyFields.h : null);
        JSONObject jSONObject2 = this.appBody;
        f9 requestBodyFields2 = getRequestBodyFields();
        z1.a(jSONObject2, POBConstants.KEY_BUNDLE, requestBodyFields2 != null ? requestBodyFields2.e : null);
        JSONObject jSONObject3 = this.appBody;
        f9 requestBodyFields3 = getRequestBodyFields();
        z1.a(jSONObject3, "bundle_id", requestBodyFields3 != null ? requestBodyFields3.f : null);
        z1.a(this.appBody, SDKAnalyticsEvents.PARAMETER_SESSION_ID, "");
        z1.a(this.appBody, "ui", -1);
        z1.a(this.appBody, "test_mode", Boolean.FALSE);
        a("app", this.appBody);
    }

    public final void n() {
        z1.a(this.bidRequestBody, "app", z1.a(z1.a("ver", h4.INSTANCE.a())));
        a("bidrequest", this.bidRequestBody);
    }

    public final void o() {
        w3 w3VarB;
        w3 w3VarB2;
        w3 w3VarB3;
        w3 w3VarB4;
        w3 w3VarB5;
        v8 v8VarG;
        m7 openRTBConnectionType;
        w3 w3VarB6;
        w3 w3VarB7;
        v8 v8VarG2;
        ca caVarJ;
        f9 requestBodyFields = getRequestBodyFields();
        JSONObject jSONObject = requestBodyFields != null ? requestBodyFields.m : null;
        z1.a[] aVarArr = new z1.a[5];
        aVarArr[0] = z1.a("carrier_name", jSONObject != null ? jSONObject.optString("carrier-name") : null);
        aVarArr[1] = z1.a("mobile_country_code", jSONObject != null ? jSONObject.optString("mobile-country-code") : null);
        aVarArr[2] = z1.a("mobile_network_code", jSONObject != null ? jSONObject.optString("mobile-network-code") : null);
        aVarArr[3] = z1.a("iso_country_code", jSONObject != null ? jSONObject.optString("iso-country-code") : null);
        aVarArr[4] = z1.a("phone_type", jSONObject != null ? Integer.valueOf(jSONObject.optInt("phone-type")) : null);
        z1.a(this.deviceBody, "carrier", z1.a(aVarArr));
        JSONObject jSONObject2 = this.deviceBody;
        f9 requestBodyFields2 = getRequestBodyFields();
        z1.a(jSONObject2, "model", requestBodyFields2 != null ? requestBodyFields2.f1016a : null);
        JSONObject jSONObject3 = this.deviceBody;
        f9 requestBodyFields3 = getRequestBodyFields();
        z1.a(jSONObject3, "make", requestBodyFields3 != null ? requestBodyFields3.k : null);
        JSONObject jSONObject4 = this.deviceBody;
        f9 requestBodyFields4 = getRequestBodyFields();
        z1.a(jSONObject4, CommonUrlParts.DEVICE_TYPE, requestBodyFields4 != null ? requestBodyFields4.j : null);
        JSONObject jSONObject5 = this.deviceBody;
        f9 requestBodyFields5 = getRequestBodyFields();
        z1.a(jSONObject5, "actual_device_type", requestBodyFields5 != null ? requestBodyFields5.l : null);
        JSONObject jSONObject6 = this.deviceBody;
        f9 requestBodyFields6 = getRequestBodyFields();
        z1.a(jSONObject6, "os", requestBodyFields6 != null ? requestBodyFields6.b : null);
        JSONObject jSONObject7 = this.deviceBody;
        f9 requestBodyFields7 = getRequestBodyFields();
        z1.a(jSONObject7, "country", requestBodyFields7 != null ? requestBodyFields7.c : null);
        JSONObject jSONObject8 = this.deviceBody;
        f9 requestBodyFields8 = getRequestBodyFields();
        z1.a(jSONObject8, POBConstants.KEY_LANGUAGE, requestBodyFields8 != null ? requestBodyFields8.d : null);
        f9 requestBodyFields9 = getRequestBodyFields();
        z1.a(this.deviceBody, "timestamp", (requestBodyFields9 == null || (caVarJ = requestBodyFields9.j()) == null) ? null : String.valueOf(TimeUnit.MILLISECONDS.toSeconds(caVarJ.getCurrentTimeMillis())));
        JSONObject jSONObject9 = this.deviceBody;
        f9 requestBodyFields10 = getRequestBodyFields();
        z1.a(jSONObject9, "reachability", (requestBodyFields10 == null || (v8VarG2 = requestBodyFields10.g()) == null) ? null : v8VarG2.getConnectionTypeFromActiveNetwork());
        JSONObject jSONObject10 = this.deviceBody;
        f9 requestBodyFields11 = getRequestBodyFields();
        z1.a(jSONObject10, "is_portrait", (requestBodyFields11 == null || (w3VarB7 = requestBodyFields11.b()) == null) ? null : Boolean.valueOf(w3VarB7.getIsPortrait()));
        JSONObject jSONObject11 = this.deviceBody;
        f9 requestBodyFields12 = getRequestBodyFields();
        z1.a(jSONObject11, "scale", (requestBodyFields12 == null || (w3VarB6 = requestBodyFields12.b()) == null) ? null : Float.valueOf(w3VarB6.getScale()));
        JSONObject jSONObject12 = this.deviceBody;
        f9 requestBodyFields13 = getRequestBodyFields();
        z1.a(jSONObject12, "timezone", requestBodyFields13 != null ? requestBodyFields13.o : null);
        JSONObject jSONObject13 = this.deviceBody;
        f9 requestBodyFields14 = getRequestBodyFields();
        z1.a(jSONObject13, "connectiontype", (requestBodyFields14 == null || (v8VarG = requestBodyFields14.g()) == null || (openRTBConnectionType = v8VarG.getOpenRTBConnectionType()) == null) ? null : Integer.valueOf(openRTBConnectionType.getValue()));
        JSONObject jSONObject14 = this.deviceBody;
        f9 requestBodyFields15 = getRequestBodyFields();
        z1.a(jSONObject14, "dw", (requestBodyFields15 == null || (w3VarB5 = requestBodyFields15.b()) == null) ? null : Integer.valueOf(w3VarB5.getDeviceWidth()));
        JSONObject jSONObject15 = this.deviceBody;
        f9 requestBodyFields16 = getRequestBodyFields();
        z1.a(jSONObject15, "dh", (requestBodyFields16 == null || (w3VarB4 = requestBodyFields16.b()) == null) ? null : Integer.valueOf(w3VarB4.getDeviceHeight()));
        JSONObject jSONObject16 = this.deviceBody;
        f9 requestBodyFields17 = getRequestBodyFields();
        z1.a(jSONObject16, "dpi", (requestBodyFields17 == null || (w3VarB3 = requestBodyFields17.b()) == null) ? null : w3VarB3.getDpi());
        JSONObject jSONObject17 = this.deviceBody;
        f9 requestBodyFields18 = getRequestBodyFields();
        z1.a(jSONObject17, "w", (requestBodyFields18 == null || (w3VarB2 = requestBodyFields18.b()) == null) ? null : Integer.valueOf(w3VarB2.getWidth()));
        JSONObject jSONObject18 = this.deviceBody;
        f9 requestBodyFields19 = getRequestBodyFields();
        z1.a(jSONObject18, "h", (requestBodyFields19 == null || (w3VarB = requestBodyFields19.b()) == null) ? null : Integer.valueOf(w3VarB.getHeight()));
        z1.a(this.deviceBody, "user_agent", ab.b.a());
        z1.a(this.deviceBody, "device_family", "");
        z1.a(this.deviceBody, "retina", Boolean.FALSE);
        p();
        f9 requestBodyFields20 = getRequestBodyFields();
        m8 m8Var = requestBodyFields20 != null ? requestBodyFields20.r : null;
        if (m8Var != null) {
            a(m8Var);
        }
        a("device", this.deviceBody);
    }

    public final void p() {
        f9 requestBodyFields = getRequestBodyFields();
        r5 r5VarC = requestBodyFields != null ? requestBodyFields.c() : null;
        if (r5VarC != null) {
            z1.a(this.deviceBody, "identity", r5VarC.getIdentifiers());
            int i = a.f1112a[r5VarC.getTrackingState().ordinal()];
            if (i == 1) {
                z1.a(this.deviceBody, CommonUrlParts.LIMIT_AD_TRACKING, Boolean.TRUE);
            } else if (i == 2) {
                z1.a(this.deviceBody, CommonUrlParts.LIMIT_AD_TRACKING, Boolean.FALSE);
            }
            Integer setIdScope = r5VarC.getSetIdScope();
            if (setIdScope != null) {
                z1.a(this.deviceBody, "appsetidscope", Integer.valueOf(setIdScope.intValue()));
                return;
            }
            return;
        }
        b7.b("Missing identity in the CB SDK. This will affect ads performance.", null);
    }

    public final void a(m8 privacyBodyFields) {
        String tcfString = privacyBodyFields.getTcfString();
        if (tcfString != null) {
            z1.a(this.deviceBody, "consent", tcfString);
        }
        z1.a(this.deviceBody, "pidatauseconsent", privacyBodyFields.getPiDataUseConsent());
        JSONObject privacyListAsJson = privacyBodyFields.getPrivacyListAsJson();
        if (privacyListAsJson != null) {
            try {
                privacyListAsJson.put("gpp", privacyBodyFields.getGppString());
                privacyListAsJson.put("gpp_sid", privacyBodyFields.getGppSid());
            } catch (JSONException e) {
                b7.b("Failed to add GPP and/or GPP SID to request body", e);
            }
            z1.a(this.deviceBody, "privacy", privacyListAsJson);
        }
    }

    public final void q() {
        n3 n3VarA;
        e7 e7VarD;
        JSONObject jSONObject = this.sdkBody;
        f9 requestBodyFields = getRequestBodyFields();
        String configVariant = null;
        z1.a(jSONObject, "sdk", requestBodyFields != null ? requestBodyFields.g : null);
        f9 requestBodyFields2 = getRequestBodyFields();
        if (requestBodyFields2 != null && (e7VarD = requestBodyFields2.d()) != null) {
            z1.a(this.sdkBody, "mediation", e7VarD.getCom.amazon.device.ads.DtbConstants.MEDIATION_NAME java.lang.String());
            z1.a(this.sdkBody, "mediation_version", e7VarD.getLibraryVersion());
            z1.a(this.sdkBody, "adapter_version", e7VarD.getAdapterVersion());
        }
        z1.a(this.sdkBody, "commit_hash", "f26a21259cbb49878f66b4d3322adcd53d3eaf74");
        f9 requestBodyFields3 = getRequestBodyFields();
        if (requestBodyFields3 != null && (n3VarA = requestBodyFields3.a()) != null) {
            configVariant = n3VarA.getConfigVariant();
        }
        if (!v0.b().a(configVariant)) {
            z1.a(this.sdkBody, "config_variant", configVariant);
        }
        a("sdk", this.sdkBody);
    }

    public final void l() {
        JSONObject jSONObject = this.adBody;
        f9 requestBodyFields = getRequestBodyFields();
        z1.a(jSONObject, "session", requestBodyFields != null ? Integer.valueOf(requestBodyFields.i()) : null);
        if (this.adBody.isNull(Reporting.EventType.CACHE)) {
            z1.a(this.adBody, Reporting.EventType.CACHE, Boolean.FALSE);
        }
        if (this.adBody.isNull("amount")) {
            z1.a(this.adBody, "amount", 0);
        }
        if (this.adBody.isNull("retry_count")) {
            z1.a(this.adBody, "retry_count", 0);
        }
        if (this.adBody.isNull("location")) {
            z1.a(this.adBody, "location", "");
        }
        a(Reporting.Key.CLICK_SOURCE_TYPE_AD, this.adBody);
    }
}
