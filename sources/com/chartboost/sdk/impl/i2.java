package com.chartboost.sdk.impl;

import com.chartboost.sdk.ChartboostDSP;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.NetworkHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 Y2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\b\"BS\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010,\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000105\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bU\u0010VB=\b\u0016\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010,\u0012\u0006\u0010T\u001a\u00020S\u0012\b\u0010:\u001a\u0004\u0018\u000105\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bU\u0010WBE\b\u0016\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010,\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u00104\u001a\u00020\u0003\u0012\b\u0010:\u001a\u0004\u0018\u000105\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bU\u0010XJ!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0011\u0010\b\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\b\u0010\u0010J#\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0014J#\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0016J#\u0010\b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0019J#\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\b\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u001dJ'\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010 J\u001f\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010#J#\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00132\n\u0010&\u001a\u00060$j\u0002`%H\u0002¢\u0006\u0004\b\b\u0010'J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010(R\u0017\u0010+\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b*\u0010\rR\u001c\u00101\u001a\u0004\u0018\u00010,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00104\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010\rR\u0019\u0010:\u001a\u0004\u0018\u0001058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\b\b\u0010CR$\u0010K\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\b\b\u0010JR\u0016\u0010O\u001a\u00020L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006Z"}, d2 = {"Lcom/chartboost/sdk/impl/i2;", "Lcom/chartboost/sdk/impl/c2;", "Lorg/json/JSONObject;", "", "key", "", "value", "", "a", "(Ljava/lang/String;Ljava/lang/Object;)V", InneractiveMediationDefs.GENDER_FEMALE, "()V", CampaignEx.JSON_KEY_AD_K, "()Ljava/lang/String;", "i", "Lcom/chartboost/sdk/impl/d2;", "()Lcom/chartboost/sdk/impl/d2;", "Lcom/chartboost/sdk/impl/f2;", "serverResponse", "Lcom/chartboost/sdk/impl/e2;", "(Lcom/chartboost/sdk/impl/f2;)Lcom/chartboost/sdk/impl/e2;", "response", "(Lorg/json/JSONObject;Lcom/chartboost/sdk/impl/f2;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError;Lcom/chartboost/sdk/impl/f2;)V", "(Lcom/chartboost/sdk/impl/f2;Lcom/chartboost/sdk/internal/Model/CBError;)V", "g", "errorMessage", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/e2;", "", "status", "(ILjava/lang/String;)Lcom/chartboost/sdk/impl/e2;", "message", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(ILjava/lang/String;)Lorg/json/JSONObject;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "(Ljava/lang/Exception;)Lcom/chartboost/sdk/impl/e2;", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getPath", "path", "Lcom/chartboost/sdk/impl/f9;", "l", "Lcom/chartboost/sdk/impl/f9;", "j", "()Lcom/chartboost/sdk/impl/f9;", "requestBodyFields", "m", "getEventType", "eventType", "Lcom/chartboost/sdk/impl/i2$a;", "n", "Lcom/chartboost/sdk/impl/i2$a;", "getCallback", "()Lcom/chartboost/sdk/impl/i2$a;", "callback", "Lcom/chartboost/sdk/impl/l4;", "o", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "p", "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "body", "Lorg/json/JSONArray;", CampaignEx.JSON_KEY_AD_Q, "Lorg/json/JSONArray;", "h", "()Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", "bodyArray", "", "r", "Z", "checkStatusInResponseBody", "Lcom/chartboost/sdk/impl/c2$c;", "method", com.json.cc.r, "Lcom/chartboost/sdk/impl/k8;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "<init>", "(Lcom/chartboost/sdk/impl/c2$c;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/k8;Ljava/lang/String;Lcom/chartboost/sdk/impl/i2$a;Lcom/chartboost/sdk/impl/l4;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/k8;Lcom/chartboost/sdk/impl/i2$a;Lcom/chartboost/sdk/impl/l4;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/k8;Ljava/lang/String;Lcom/chartboost/sdk/impl/i2$a;Lcom/chartboost/sdk/impl/l4;)V", "s", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class i2 extends c2<JSONObject> {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String path;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final f9 requestBodyFields;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final String eventType;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final a callback;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final l4 eventTracker;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public JSONObject body;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public JSONArray bodyArray;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean checkStatusInResponseBody;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/chartboost/sdk/impl/i2$a;", "", "Lcom/chartboost/sdk/impl/i2;", "request", "Lorg/json/JSONObject;", "response", "", "a", "(Lcom/chartboost/sdk/impl/i2;Lorg/json/JSONObject;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/impl/i2;Lcom/chartboost/sdk/internal/Model/CBError;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(i2 request, CBError error);

        void a(i2 request, JSONObject response);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(c2.c method, String endpoint, String path, f9 f9Var, k8 priority, String str, a aVar, l4 eventTracker) {
        super(method, NetworkHelper.f1212a.a(endpoint, path), priority, null);
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.path = path;
        this.requestBodyFields = f9Var;
        this.eventType = str;
        this.callback = aVar;
        this.eventTracker = eventTracker;
        this.body = new JSONObject();
    }

    public void f() {
        n3 n3VarA;
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
        f9 f9Var = this.requestBodyFields;
        a("app", f9Var != null ? f9Var.h : null);
        f9 f9Var2 = this.requestBodyFields;
        a("model", f9Var2 != null ? f9Var2.f1016a : null);
        f9 f9Var3 = this.requestBodyFields;
        a("make", f9Var3 != null ? f9Var3.k : null);
        f9 f9Var4 = this.requestBodyFields;
        a(CommonUrlParts.DEVICE_TYPE, f9Var4 != null ? f9Var4.j : null);
        f9 f9Var5 = this.requestBodyFields;
        a("actual_device_type", f9Var5 != null ? f9Var5.l : null);
        f9 f9Var6 = this.requestBodyFields;
        a("os", f9Var6 != null ? f9Var6.b : null);
        f9 f9Var7 = this.requestBodyFields;
        a("country", f9Var7 != null ? f9Var7.c : null);
        f9 f9Var8 = this.requestBodyFields;
        a(POBConstants.KEY_LANGUAGE, f9Var8 != null ? f9Var8.d : null);
        f9 f9Var9 = this.requestBodyFields;
        a("sdk", f9Var9 != null ? f9Var9.g : null);
        a("user_agent", ab.b.a());
        f9 f9Var10 = this.requestBodyFields;
        a("timestamp", (f9Var10 == null || (caVarJ = f9Var10.j()) == null) ? null : String.valueOf(TimeUnit.MILLISECONDS.toSeconds(caVarJ.getCurrentTimeMillis())));
        f9 f9Var11 = this.requestBodyFields;
        a("session", f9Var11 != null ? Integer.valueOf(f9Var11.i()) : null);
        f9 f9Var12 = this.requestBodyFields;
        a("reachability", (f9Var12 == null || (v8VarG2 = f9Var12.g()) == null) ? null : v8VarG2.getConnectionTypeFromActiveNetwork());
        f9 f9Var13 = this.requestBodyFields;
        a("is_portrait", (f9Var13 == null || (w3VarB7 = f9Var13.b()) == null) ? null : Boolean.valueOf(w3VarB7.getIsPortrait()));
        f9 f9Var14 = this.requestBodyFields;
        a("scale", (f9Var14 == null || (w3VarB6 = f9Var14.b()) == null) ? null : Float.valueOf(w3VarB6.getScale()));
        f9 f9Var15 = this.requestBodyFields;
        a(POBConstants.KEY_BUNDLE, f9Var15 != null ? f9Var15.e : null);
        f9 f9Var16 = this.requestBodyFields;
        a("bundle_id", f9Var16 != null ? f9Var16.f : null);
        f9 f9Var17 = this.requestBodyFields;
        a("carrier", f9Var17 != null ? f9Var17.m : null);
        f9 f9Var18 = this.requestBodyFields;
        e7 e7VarD = f9Var18 != null ? f9Var18.d() : null;
        if (e7VarD != null) {
            a("mediation", e7VarD.getCom.amazon.device.ads.DtbConstants.MEDIATION_NAME java.lang.String());
            a("mediation_version", e7VarD.getLibraryVersion());
            a("adapter_version", e7VarD.getAdapterVersion());
        }
        f9 f9Var19 = this.requestBodyFields;
        a("timezone", f9Var19 != null ? f9Var19.o : null);
        f9 f9Var20 = this.requestBodyFields;
        a("connectiontype", (f9Var20 == null || (v8VarG = f9Var20.g()) == null || (openRTBConnectionType = v8VarG.getOpenRTBConnectionType()) == null) ? null : Integer.valueOf(openRTBConnectionType.getValue()));
        f9 f9Var21 = this.requestBodyFields;
        a("dw", (f9Var21 == null || (w3VarB5 = f9Var21.b()) == null) ? null : Integer.valueOf(w3VarB5.getDeviceWidth()));
        f9 f9Var22 = this.requestBodyFields;
        a("dh", (f9Var22 == null || (w3VarB4 = f9Var22.b()) == null) ? null : Integer.valueOf(w3VarB4.getDeviceHeight()));
        f9 f9Var23 = this.requestBodyFields;
        a("dpi", (f9Var23 == null || (w3VarB3 = f9Var23.b()) == null) ? null : w3VarB3.getDpi());
        f9 f9Var24 = this.requestBodyFields;
        a("w", (f9Var24 == null || (w3VarB2 = f9Var24.b()) == null) ? null : Integer.valueOf(w3VarB2.getWidth()));
        f9 f9Var25 = this.requestBodyFields;
        a("h", (f9Var25 == null || (w3VarB = f9Var25.b()) == null) ? null : Integer.valueOf(w3VarB.getHeight()));
        a("commit_hash", "f26a21259cbb49878f66b4d3322adcd53d3eaf74");
        f9 f9Var26 = this.requestBodyFields;
        r5 r5VarC = f9Var26 != null ? f9Var26.c() : null;
        a("identity", r5VarC != null ? r5VarC.getIdentifiers() : null);
        qa trackingState = r5VarC != null ? r5VarC.getTrackingState() : null;
        if (trackingState != qa.TRACKING_UNKNOWN) {
            a(CommonUrlParts.LIMIT_AD_TRACKING, Boolean.valueOf(trackingState == qa.TRACKING_LIMITED));
        }
        a("appsetidscope", r5VarC != null ? r5VarC.getSetIdScope() : null);
        f9 f9Var27 = this.requestBodyFields;
        m8 m8VarF = f9Var27 != null ? f9Var27.f() : null;
        Object tcfString = m8VarF != null ? m8VarF.getTcfString() : null;
        if (tcfString != null) {
            a("consent", tcfString);
        }
        a("pidatauseconsent", m8VarF != null ? m8VarF.getPiDataUseConsent() : null);
        f9 f9Var28 = this.requestBodyFields;
        String configVariant = (f9Var28 == null || (n3VarA = f9Var28.a()) == null) ? null : n3VarA.getConfigVariant();
        if (!v0.b().a(configVariant)) {
            a("config_variant", configVariant);
        }
        JSONObject privacyListAsJson = m8VarF != null ? m8VarF.getPrivacyListAsJson() : null;
        String gppString = m8VarF != null ? m8VarF.getGppString() : null;
        String gppSid = m8VarF != null ? m8VarF.getGppSid() : null;
        if (privacyListAsJson != null) {
            try {
                privacyListAsJson.put("gpp", gppString);
                privacyListAsJson.put("gpp_sid", gppSid);
            } catch (JSONException e) {
                b7.b("Failed to add GPP and/or GPP SID to request body", e);
            }
        }
        a("privacy", privacyListAsJson);
    }

    public final String g() {
        x2 x2Var = x2.f1185a;
        String strA = x2Var.a();
        int[] iArrB = x2Var.b();
        JSONObject jSONObject = new JSONObject();
        if (strA.length() > 0 && iArrB != null) {
            if (!(iArrB.length == 0)) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (int i : iArrB) {
                        jSONArray.put(i);
                    }
                    jSONObject.put("exchangeMode", 2);
                    jSONObject.put("bidFloor", 0.01d);
                    jSONObject.put("code", strA);
                    jSONObject.put("forceCreativeTypes", jSONArray);
                } catch (JSONException unused) {
                    return null;
                }
            }
        }
        return jSONObject.toString();
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final f9 getRequestBodyFields() {
        return this.requestBodyFields;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final JSONArray getBodyArray() {
        return this.bodyArray;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i2(String endpoint, String path, f9 f9Var, k8 priority, a aVar, l4 eventTracker) {
        this(c2.c.POST, endpoint, path, f9Var, priority, null, aVar, eventTracker);
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
    }

    public final void a(String key, Object value) {
        z1.a(this.body, key, value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i2(String endpoint, String path, f9 f9Var, k8 priority, String eventType, a aVar, l4 eventTracker) {
        this(c2.c.POST, endpoint, path, f9Var, priority, eventType, aVar, eventTracker);
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
    }

    public final String k() {
        return i();
    }

    public final String i() {
        return StringsKt.startsWith$default(this.path, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) ? this.path : RemoteSettings.FORWARD_SLASH_STRING + this.path;
    }

    @Override // com.chartboost.sdk.impl.c2
    public d2 a() {
        String strG;
        f();
        String string = this.body.toString();
        Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
        f9 f9Var = this.requestBodyFields;
        String str = f9Var != null ? f9Var.h : null;
        if (str == null) {
            str = "";
        }
        String str2 = f9Var != null ? f9Var.i : null;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str3 = String.format(Locale.US, "%s %s\n%s\n%s", Arrays.copyOf(new Object[]{getMethod(), k(), str2, string}, 4));
        Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
        String strA = s1.a(str3);
        HashMap map = new HashMap();
        map.put("Accept", "application/json");
        map.put("X-Chartboost-Client", n2.b());
        map.put("X-Chartboost-API", "9.8.3");
        map.put("X-Chartboost-App", str);
        map.put("X-Chartboost-Signature", strA);
        if (k9.f1061a.d()) {
            String strB = k9.b();
            String str4 = strB.length() > 0 ? strB : null;
            if (str4 != null) {
                map.put("X-Chartboost-Test", str4);
            }
            String strA2 = k9.a();
            if (strA2 != null) {
                map.put("X-Chartboost-Test", strA2);
            }
        }
        if (ChartboostDSP.INSTANCE.isDSP() && (strG = g()) != null && strG.length() != 0) {
            map.put("X-Chartboost-DspDemoApp", strG);
        }
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new d2(map, bytes, "application/json");
    }

    public final void b(String errorMessage) {
        this.eventTracker.mo4741track(r3.INSTANCE.a(ma.h.RESPONSE_JSON_SERIALIZATION_ERROR, errorMessage));
    }

    public final JSONObject b(int status, String message) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", status);
            jSONObject.put("message", message);
        } catch (JSONException e) {
            b7.b("Error creating JSON", e);
        }
        return jSONObject;
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(CBError error, f2 serverResponse) {
        if (error == null) {
            return;
        }
        b7.d("Request failure: " + getUri() + " status: " + error.getErrorDesc(), null);
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(this, error);
        }
        a(serverResponse, error);
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(JSONObject response, f2 serverResponse) {
        b7.d("Request success: " + getUri() + " status: " + (serverResponse != null ? serverResponse.getStatusCode() : -1), null);
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(this, response);
        }
        a(serverResponse, (CBError) null);
    }

    public final e2<JSONObject> a(String errorMessage) {
        JSONObject jSONObjectB = b(404, errorMessage);
        e2.Companion companion = e2.INSTANCE;
        CBError.c cVar = CBError.c.HTTP_NOT_FOUND;
        String string = jSONObjectB.toString();
        Intrinsics.checkNotNullExpressionValue(string, "errorJson.toString()");
        return companion.a(new CBError(cVar, string));
    }

    public final e2<JSONObject> a(int status, String errorMessage) {
        JSONObject jSONObjectB = b(status, errorMessage);
        e2.Companion companion = e2.INSTANCE;
        CBError.c cVar = CBError.c.HTTP_NOT_OK;
        String string = jSONObjectB.toString();
        Intrinsics.checkNotNullExpressionValue(string, "errorJson.toString()");
        return companion.a(new CBError(cVar, string));
    }

    public final e2<JSONObject> a(Exception e) {
        e2.Companion companion = e2.INSTANCE;
        CBError.c cVar = CBError.c.MISCELLANEOUS;
        String localizedMessage = e.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "";
        }
        return companion.a(new CBError(cVar, localizedMessage));
    }

    @Override // com.chartboost.sdk.impl.c2
    public e2<JSONObject> a(f2 serverResponse) {
        byte[] data;
        try {
            if (serverResponse == null || (data = serverResponse.getData()) == null) {
                data = new byte[0];
            }
            JSONObject jSONObject = new JSONObject(new String(data, Charsets.UTF_8));
            b7.d("Request " + i() + " succeeded. Response code: " + (serverResponse != null ? Integer.valueOf(serverResponse.getStatusCode()) : null) + ", body: " + jSONObject.toString(4), null);
            if (this.checkStatusInResponseBody) {
                int iOptInt = jSONObject.optInt("status");
                String innerMessage = jSONObject.optString("message");
                if (iOptInt == 404) {
                    Intrinsics.checkNotNullExpressionValue(innerMessage, "innerMessage");
                    return a(innerMessage);
                }
                if (iOptInt < 200 || iOptInt > 299) {
                    b7.b("Request failed due to status code " + iOptInt + " in message", null);
                    Intrinsics.checkNotNullExpressionValue(innerMessage, "innerMessage");
                    return a(iOptInt, innerMessage);
                }
            }
            return e2.INSTANCE.a(jSONObject);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            b(message);
            b7.b("parseServerResponse", e);
            return a(e);
        }
    }

    public final void a(f2 response, CBError error) {
        String string;
        String errorDesc;
        CBError.d type;
        z1.a[] aVarArr = new z1.a[5];
        aVarArr[0] = z1.a(com.json.cc.r, i());
        String str = "None";
        aVarArr[1] = z1.a("statuscode", response == null ? "None" : Integer.valueOf(response.getStatusCode()));
        if (error == null || (type = error.getType()) == null || (string = type.toString()) == null) {
            string = "None";
        }
        aVarArr[2] = z1.a("error", string);
        if (error != null && (errorDesc = error.getErrorDesc()) != null) {
            str = errorDesc;
        }
        aVarArr[3] = z1.a("errorDescription", str);
        aVarArr[4] = z1.a("retryCount", (Object) 0);
        JSONObject jSONObjectA = z1.a(aVarArr);
        Intrinsics.checkNotNullExpressionValue(jSONObjectA, "jsonObject(\n            …Count\", 0),\n            )");
        b7.a("sendToSessionLogs: " + jSONObjectA, null);
    }

    public final void a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.body = jSONObject;
    }

    public final void a(JSONArray jSONArray) {
        this.bodyArray = jSONArray;
    }
}
