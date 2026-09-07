package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.ad.OguryAdError;
import com.ogury.ad.OguryShowErrorCode;
import com.ogury.ad.common.OguryMediation;
import com.ogury.core.internal.IntegrationLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7408a;
    public final c0 b;
    public final t2 c;
    public final o d;
    public final t7 e;
    public final d4 f;
    public final a6 g;
    public final w5 h;
    public final String i;
    public final OguryMediation j;
    public final m4 k;
    public final e9 l;

    public u(Context context, c0 appBackgroundChecker, t2 internetChecker, o adType, String sessionId, OguryMediation oguryMediation) {
        m4 cacheStore = m4.f7354a;
        t7 profigGateway = t7.f7405a;
        d4.a aVar = d4.e;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        d4 monitoringEventLogger = aVar.a(applicationContext);
        a6 ogurySdk = a6.f7259a;
        w5 oguryAds = w5.f7430a;
        e9 timeUtils = new e9();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appBackgroundChecker, "appBackgroundChecker");
        Intrinsics.checkNotNullParameter(internetChecker, "internetChecker");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(profigGateway, "profigGateway");
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        Intrinsics.checkNotNullParameter(ogurySdk, "ogurySdk");
        Intrinsics.checkNotNullParameter(oguryAds, "oguryAds");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(cacheStore, "cacheStore");
        Intrinsics.checkNotNullParameter(timeUtils, "timeUtils");
        this.f7408a = context;
        this.b = appBackgroundChecker;
        this.c = internetChecker;
        this.d = adType;
        this.e = profigGateway;
        this.f = monitoringEventLogger;
        this.g = ogurySdk;
        this.h = oguryAds;
        this.i = sessionId;
        this.j = oguryMediation;
        this.k = cacheStore;
        this.l = timeUtils;
    }

    /* JADX WARN: Code duplicated, block: B:96:0x03c7  */
    public final boolean a(s sVar, boolean z, d adConfig, List<c> ads, boolean z2, boolean z3, int i, int i2) throws JSONException {
        boolean z4;
        long jLongValue;
        Long l;
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(ads, "ads");
        u3.f7411a.getClass();
        u3.a(" showConditionsAreMet --> reloadAttempts = " + i + "      maxReloadAttempts = " + i2);
        Context context = this.f7408a;
        this.g.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        com.ogury.ad.common.a aVar = a6.b;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        aVar.b.getClass();
        if (s7.a.a(context).b().length() == 0 && aVar.h == 1) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (module not set up)");
            this.f.a(n7.SE_003_SDK_NEVER_INITIALIZED, adConfig.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z3)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3000, "The ad could not be displayed because the SDK appears to have not been started."));
            return false;
        }
        this.g.getClass();
        if (aVar.c()) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (module not set up)");
            this.f.a(n7.SE_003_SDK_NOT_INITIALIZED, adConfig.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z3)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3000, "The ad could not be displayed because the SDK appears to have not been started."));
            return false;
        }
        this.g.getClass();
        if (aVar.a()) {
            this.f.a(n7.SE_003_SDK_INITIALIZATION_FAILED, adConfig.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z3)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3001, "The ad could not be displayed because the SDK is not properly initialized."));
            return false;
        }
        if (a(3100)) {
            a(3100, z2, z3, ads, adConfig, i);
            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3100, "The ad could not be displayed due to an invalid SDK configuration."));
            return false;
        }
        this.k.getClass();
        l4 l4VarC = m4.c();
        if (l4VarC != null) {
            d4 d4Var = this.f;
            n7 n7Var = n7.SE_002_CONFIG_RESTRICTIONS_AD_EXPIRED;
            c cVarA = l4VarC.a();
            a1 a1Var = l4VarC.a().G;
            Pair pair = TuplesKt.to("expiration_source", (a1Var != null ? a1Var.f7256a : null) != null ? Reporting.Key.CLICK_SOURCE_TYPE_AD : "profig");
            a1 a1Var2 = l4VarC.a().G;
            if (a1Var2 == null || (l = a1Var2.f7256a) == null) {
                this.e.getClass();
                jLongValue = t7.b.d.d;
            } else {
                jLongValue = l.longValue();
            }
            Pair pair2 = TuplesKt.to("expiration_time", Long.valueOf(jLongValue));
            this.l.getClass();
            d4Var.a(n7Var, cVarA, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z3)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), p7.b(pair, pair2, TuplesKt.to("time_span", Long.valueOf(f9.a(e9.a() - l4VarC.b())))));
            z4 = true;
        } else {
            z4 = false;
        }
        if (i > i2) {
            this.f.a(n7.SE_011_CONDITIONS_NOT_MET_WV_TERMINATED, adConfig.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z3)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3204, "The ad could not be displayed because the WebView was terminated by the system, resulting in the ad being unloaded due to high resource consumption by the application."));
            return false;
        }
        if (!z || ads.isEmpty()) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (no ad loaded)");
            IntegrationLogger.d("[Ads][" + this.d.b() + "][show] Triggering onAdError() callback");
            if (sVar == null) {
                IntegrationLogger.d("[Ads][" + this.d.b() + "][show] No ad listener registered");
            }
            if (z4) {
                a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3200, "The ad could not be displayed because the retention time of the loaded ad has expired."));
            } else {
                this.f.a(n7.SE_004_PRECACHE_ERROR_NO_AD_LOADED, adConfig.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z3)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
                if (sVar != null) {
                    sVar.e();
                }
            }
            return false;
        }
        Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(OguryShowErrorCode.AD_DISABLED_UNSPECIFIED_REASON), Integer.valueOf(OguryShowErrorCode.VIEW_IN_BACKGROUND), Integer.valueOf(OguryShowErrorCode.ANOTHER_AD_ALREADY_DISPLAYED), 3002}).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (a(iIntValue)) {
                a(iIntValue, z2, z3, ads, adConfig, i);
                if (iIntValue == 3002) {
                    a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, iIntValue, "The ad could not be displayed because there is no active Internet connection."));
                } else if (iIntValue == 3100) {
                    a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, iIntValue, "The ad could not be displayed due to an invalid SDK configuration."));
                } else if (iIntValue == 3104) {
                    this.e.getClass();
                    String str = t7.b.d.c;
                    int iHashCode = str.hashCode();
                    if (iHashCode != -1984720000) {
                        if (iHashCode != -1879742975) {
                            if (iHashCode == 659206911 && str.equals("COUNTRY_NOT_OPEN")) {
                                a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, 3101, "The ad could not be displayed because ads are disabled; the user’s country is not yet available for advertising."));
                            } else {
                                a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, OguryShowErrorCode.AD_DISABLED_UNSPECIFIED_REASON, "The ad could not be displayed because ads are disabled for an unspecified reason."));
                            }
                        } else if (str.equals("CONSENT_MISSING")) {
                            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, OguryShowErrorCode.AD_DISABLED_CONSENT_MISSING, "The ad could not be displayed because ads are disabled; the user consent is missing or has not been provided."));
                        } else {
                            a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, OguryShowErrorCode.AD_DISABLED_UNSPECIFIED_REASON, "The ad could not be displayed because ads are disabled for an unspecified reason."));
                        }
                    } else if (str.equals("CONSENT_DENIED")) {
                        a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, OguryShowErrorCode.AD_DISABLED_CONSENT_DENIED, "The ad could not be displayed because ads are disabled for an unspecified reason."));
                    } else {
                        a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, OguryShowErrorCode.AD_DISABLED_UNSPECIFIED_REASON, "The ad could not be displayed because ads are disabled for an unspecified reason."));
                    }
                } else if (iIntValue == 3202) {
                    a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, iIntValue, "The ad could not be displayed because the application was running in the background."));
                } else if (iIntValue == 3203) {
                    a(sVar, new OguryAdError(OguryAdError.Type.SHOW_ERROR, iIntValue, "The ad could not be displayed because another ad is currently being displayed."));
                }
                return false;
            }
        }
        return true;
    }

    public final boolean a(int i) {
        boolean zA;
        if (i == 3002) {
            zA = this.c.a(this.f7408a);
        } else if (i == 3100) {
            this.e.getClass();
            zA = t7.b.f7463a;
        } else {
            if (i != 3104) {
                if (i == 3202) {
                    c0 c0Var = this.b;
                    Context context = this.f7408a;
                    c0Var.getClass();
                    return c0.a(context);
                }
                if (i != 3203) {
                    IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (error code: " + i + ")");
                    throw new IllegalArgumentException("Illegal argument " + i);
                }
                if (this.d.d()) {
                    this.h.getClass();
                    if (w5.c) {
                        return true;
                    }
                }
                if (this.d.e()) {
                    this.h.getClass();
                    if (w5.b) {
                        return true;
                    }
                }
                return false;
            }
            this.e.getClass();
            zA = t7.b.d.f7465a;
        }
        return true ^ zA;
    }

    public final void a(int i, boolean z, boolean z2, List<c> list, d dVar, int i2) throws JSONException {
        if (i == 3002) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (No Internet connection)");
            this.f.a(n7.SE_010_CONDITIONS_NOT_MET_NO_INTERNET, (c) CollectionsKt.first((List) list), p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
            return;
        }
        if (i == 3100) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (missing configuration)");
            if (list.isEmpty()) {
                this.f.a(n7.SE_006_PROFIG_ERROR_PROFIG_NOT_SYNCED, dVar.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
                return;
            } else {
                this.f.a(n7.SE_006_PROFIG_ERROR_PROFIG_NOT_SYNCED, (c) CollectionsKt.first((List) list), p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
                return;
            }
        }
        if (i == 3104) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (Ad serving has been disabled)");
            this.f.a(n7.SE_001_CONFIG_RESTRICTIONS_AD_DISABLED, dVar.a(), this.i, this.j, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
        } else if (i == 3202) {
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (Activity in background)");
            this.f.a(n7.SE_008_CONDITIONS_NOT_MET_VIEW_IN_BACKGROUND, (c) CollectionsKt.first((List) list), p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
        } else {
            if (i != 3203) {
                return;
            }
            IntegrationLogger.e("[Ads][" + this.d.b() + "][show] Failed to show (Another ad already displayed)");
            this.f.a(n7.SE_009_CONDITIONS_NOT_MET_ANOTHER_AD_ALREADY_DISPLAYED, (c) CollectionsKt.first((List) list), p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
        }
    }

    public final void a(s sVar, OguryAdError oguryAdError) {
        IntegrationLogger.d("[Ads][" + this.d.b() + "][show] Triggering onAdError() callback");
        if (sVar == null) {
            IntegrationLogger.d("[Ads][" + this.d.b() + "][show] No ad listener registered");
        }
        if (sVar != null) {
            sVar.a(oguryAdError);
        }
    }
}
