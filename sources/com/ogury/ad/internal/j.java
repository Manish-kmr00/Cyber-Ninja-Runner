package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;
import com.ogury.ad.common.OguryMediation;
import com.ogury.core.internal.InternalCore;
import com.ogury.core.internal.network.NetworkClient;
import com.ogury.core.internal.network.NetworkRequest;
import com.ogury.core.internal.network.NetworkResponse;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5 f7324a;
    public final p4 b;
    public final r4 c;
    public final i d;
    public final d4 e;
    public final m f;

    public j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        if (x5.c == null) {
            int millis = (int) TimeUnit.SECONDS.toMillis(t7.b.b.f7468a);
            Context context2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
            Intrinsics.checkNotNullParameter(context2, "context");
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            x5.c = new x5(new m2(applicationContext), new NetworkClient(millis, millis * 5));
        }
        x5 x5Var = x5.c;
        Intrinsics.checkNotNull(x5Var);
        Intrinsics.checkNotNullParameter(context, "context");
        if (p4.b == null) {
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            p4.b = new p4(applicationContext2);
        }
        p4 p4Var = p4.b;
        Intrinsics.checkNotNull(p4Var);
        r4 r4Var = r4.f7393a;
        i iVar = i.f7316a;
        d4.a aVar = d4.e;
        Context applicationContext3 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        d4 d4VarA = aVar.a(applicationContext3);
        m mVar = new m(context);
        this.f7324a = x5Var;
        this.b = p4Var;
        this.c = r4Var;
        this.d = iVar;
        this.e = d4VarA;
        this.f = mVar;
    }

    public final v8<l> a(final o adType, final d adConfig, final n6 n6Var, final String sessionId, final OguryMediation oguryMediation, final boolean z, final int i) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Function0 callable = new Function0() { // from class: com.ogury.ad.internal.j$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return j.a(this.f$0, adType, adConfig, n6Var, sessionId, oguryMediation, z, i);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        return new v8<>(callable, 0);
    }

    public static final l a(j jVar, o adType, d adConfig, n6 n6Var, String str, OguryMediation oguryMediation, boolean z, int i) throws JSONException, d9 {
        String str2;
        w6 w6Var;
        boolean z2;
        String strB;
        x5 x5Var = jVar.f7324a;
        m mVar = jVar.f;
        mVar.getClass();
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        b0 app = mVar.c;
        d8 permissionsHandler = mVar.g;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        String strB2 = app.b.b();
        String packageName = app.f7264a.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        Context context = app.f7264a;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str2 = "";
        }
        d0 app2 = new d0(strB2, packageName, str2, permissionsHandler.i());
        m8 sdk = new m8("5.0.1");
        d8 permissionsHandler2 = mVar.g;
        Intrinsics.checkNotNullParameter(permissionsHandler2, "permissionsHandler");
        j8 screen = new j8(permissionsHandler2.o(), permissionsHandler2.p(), permissionsHandler2.n(), permissionsHandler2.g(), permissionsHandler2.j(), permissionsHandler2.r());
        d8 permissionsHandler3 = mVar.g;
        Intrinsics.checkNotNullParameter(permissionsHandler3, "permissionsHandler");
        t3 locale = new t3(permissionsHandler3.k(), permissionsHandler3.l());
        d8 permissionsHandler4 = mVar.g;
        Intrinsics.checkNotNullParameter(permissionsHandler4, "permissionsHandler");
        String strQ = permissionsHandler4.q();
        Intrinsics.checkNotNullParameter(locale, "locale");
        o8 settings = new o8(strQ, locale, permissionsHandler4.d(), permissionsHandler4.a());
        d8 permissionsHandler5 = mVar.g;
        Intrinsics.checkNotNullParameter(permissionsHandler5, "permissionsHandler");
        o5 network = new o5(permissionsHandler5.m(), permissionsHandler5.c());
        d8 permissionsHandler6 = mVar.g;
        Intrinsics.checkNotNullParameter(permissionsHandler6, "permissionsHandler");
        z8 system = new z8(permissionsHandler6.b(), permissionsHandler6.h());
        d8 permissionsHandler7 = mVar.g;
        Intrinsics.checkNotNullParameter(permissionsHandler7, "permissionsHandler");
        da webview = new da(permissionsHandler7.s());
        z androidDevice = mVar.d;
        d8 permissionsHandler8 = mVar.g;
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(permissionsHandler8, "permissionsHandler");
        androidDevice.getClass();
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        String strE = permissionsHandler8.e();
        String strF = permissionsHandler8.f();
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(webview, "webview");
        Intrinsics.checkNotNullParameter(system, "system");
        o1 device = new o1("android", RELEASE, strE, strF, screen, settings, network, webview, system);
        k adRequest = new k(adConfig.f7276a, adConfig.b, adConfig.c, null, new u1(adConfig.d, adConfig.e));
        if (n6Var != null) {
            z androidDevice2 = mVar.d;
            Intrinsics.checkNotNullParameter(androidDevice2, "androidDevice");
            b7 b7Var = new b7(Integer.valueOf(n6Var.b), Integer.valueOf(n6Var.f7366a), Float.valueOf(androidDevice2.c.density));
            new w6.a();
            w6Var = new w6(b7Var);
        } else {
            w6Var = null;
        }
        a9 targeting = new a9(mVar.f != null ? e2.a() : null);
        t7 profigGateway = mVar.f7350a;
        g6 omidSdkChecker = mVar.h;
        Intrinsics.checkNotNullParameter(profigGateway, "profigGateway");
        Intrinsics.checkNotNullParameter(omidSdkChecker, "omidSdkChecker");
        profigGateway.getClass();
        if (t7.b.f.f7470a) {
            omidSdkChecker.getClass();
            try {
                Class.forName("com.iab.omid.library.ogury.Omid");
                z2 = true;
            } catch (Exception unused2) {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        e6 omidRequest = new e6(Boolean.valueOf(z2));
        n.a aVar = new n.a();
        Intrinsics.checkNotNullParameter(adType, "adType");
        aVar.f7360a = adType.f7369a;
        Intrinsics.checkNotNullParameter("load", "type");
        aVar.b = "load";
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        aVar.c = adRequest;
        aVar.d = w6Var;
        Intrinsics.checkNotNullParameter(omidRequest, "omidRequest");
        n adSync = new n(aVar.f7360a, aVar.b, aVar.c, aVar.d, omidRequest);
        m1 coreWrapper = mVar.b;
        e2 e2Var = mVar.f;
        Intrinsics.checkNotNullParameter(coreWrapper, "coreWrapper");
        q7 privacyCompliance = new q7(InternalCore.retrieveTcfConsentString(coreWrapper.f7352a), InternalCore.retrieveGppConsentString(coreWrapper.f7352a), InternalCore.retrieveGppSectionIdsString(coreWrapper.f7352a), InternalCore.getAllPublisherData(coreWrapper.f7352a), e2Var != null ? e2.a("IS_CHILD_UNDER_COPPA") : null, e2Var != null ? e2.a("IS_UNDER_AGE_OF_GDPR_CONSENT") : null);
        z androidDevice3 = mVar.d;
        Intrinsics.checkNotNullParameter(androidDevice3, "androidDevice");
        androidDevice3.b.getClass();
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        k9 uuidUtils = mVar.e;
        Intrinsics.checkNotNullParameter(uuidUtils, "uuidUtils");
        uuidUtils.getClass();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Intrinsics.checkNotNullParameter(app2, "app");
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(privacyCompliance, "privacyCompliance");
        Intrinsics.checkNotNullParameter(targeting, "targeting");
        Intrinsics.checkNotNullParameter(adSync, "adSync");
        JSONObject body = new c8(lValueOf, string, app2, sdk, device, privacyCompliance, targeting, adSync, null).a();
        x5Var.getClass();
        Intrinsics.checkNotNullParameter(body, "body");
        l9.a aVarB = l9.b();
        if ((aVarB == null ? -1 : l9.b.f7349a[aVarB.ordinal()]) == 1) {
            strB = l9.b("ad_sync", "sy", com.moloco.sdk.internal.services.bidtoken.s.f6343a);
        } else {
            strB = l9.b("ad_sync", "ms-bidder-adsync", com.moloco.sdk.internal.services.bidtoken.s.f6343a);
        }
        String string2 = body.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        NetworkRequest networkRequest = new NetworkRequest(strB, "POST", string2, x5Var.f7440a.c);
        x5.a("loadAd", networkRequest);
        NetworkResponse networkResponseExecute = x5Var.b.newCall(networkRequest).execute();
        x5.a("loadAd", networkRequest, networkResponseExecute);
        if (networkResponseExecute instanceof NetworkResponse.Success) {
            if (StringsKt.isBlank(((NetworkResponse.Success) networkResponseExecute).getResponseBody())) {
                jVar.e.a(n7.LE_011_ADSYNC_ERROR_NO_AD_RECEIVED, adConfig.f7276a, str, oguryMediation, p7.a(TuplesKt.to("from_ad_markup", Boolean.FALSE), TuplesKt.to("reload", Boolean.valueOf(z)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
                throw new d9(new Exception("onAdNotAvailable"), b9.AD_NOT_AVAILABLE);
            }
            jVar.e.a(o7.LI_003_SDK_EVENT_ADSYNC_RESPONSE_RECEIVED, adConfig.f7276a, str, oguryMediation, p7.a(TuplesKt.to("from_ad_markup", Boolean.FALSE), TuplesKt.to("reload", Boolean.valueOf(z))));
            try {
                return jVar.a(adType, adConfig, n6Var, str, oguryMediation, z, false, ((NetworkResponse.Success) networkResponseExecute).getResponseBody());
            } catch (Throwable th) {
                jVar.a(adConfig, str, oguryMediation, th, false, z, i);
                throw new d9(th, b9.PARSING_ERROR);
            }
        }
        if (networkResponseExecute instanceof NetworkResponse.Failure) {
            NetworkResponse.Failure failure = (NetworkResponse.Failure) networkResponseExecute;
            jVar.e.a(n7.LE_009_ADSYNC_ERROR_REQUEST_FAILED, adConfig.f7276a, str, oguryMediation, p7.a(TuplesKt.to("from_ad_markup", Boolean.FALSE), TuplesKt.to("reload", Boolean.valueOf(z)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), new JSONObject().put("stacktrace", failure.getException().getMessage()));
            throw new d9(failure.getException(), b9.REQUEST_FAILURE);
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        jVar.a(adConfig, str, oguryMediation, (Throwable) illegalStateException, false, z, i);
        throw new d9(illegalStateException, b9.UNKNOWN);
    }

    public final v8<l> a(final String adMarkup, final o adType, final d adConfig, final String sessionId, final OguryMediation oguryMediation, final boolean z, final int i) {
        Intrinsics.checkNotNullParameter(adMarkup, "adMarkup");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Function0 callable = new Function0() { // from class: com.ogury.ad.internal.j$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return j.a(this.f$0, adType, adConfig, sessionId, oguryMediation, z, adMarkup, i);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        return new v8<>(callable, 0);
    }

    public static final l a(j jVar, o oVar, d dVar, String str, OguryMediation oguryMediation, boolean z, String str2, int i) throws JSONException, d9 {
        try {
            return jVar.a(oVar, dVar, (n6) null, str, oguryMediation, z, true, str2);
        } catch (Throwable th) {
            jVar.a(dVar, str, oguryMediation, th, true, z, i);
            throw new d9(th, b9.PARSING_ERROR);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00a8  */
    public final l a(o oVar, d dVar, n6 n6Var, String str, OguryMediation oguryMediation, boolean z, boolean z2, String str2) throws JSONException, InterruptedException, d9, q4 {
        String str3;
        Object next;
        Object obj;
        Object obj2;
        q3 q3Var;
        r3 r3Var;
        this.e.a(o7.LI_012_SDK_EVENT_AD_PARSING, dVar.f7276a, str, oguryMediation, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z2)), TuplesKt.to("reload", Boolean.valueOf(z))));
        if (z2) {
            byte[] bArrDecode = Base64.decode(str2, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            str3 = new String(bArrDecode, Charsets.UTF_8);
        } else {
            str3 = str2;
        }
        i iVar = this.d;
        String str4 = dVar.f7276a;
        iVar.getClass();
        l lVarA = i.a(str3, oVar, str4, n6Var, str, z2, z, oguryMediation);
        r4 r4Var = this.c;
        d4 monitoringEventLogger = this.e;
        List<c> ads = lVarA.f7342a;
        p4 mraidDao = this.b;
        x5 oguryApi = this.f7324a;
        r4Var.getClass();
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        Intrinsics.checkNotNullParameter(ads, "ads");
        Intrinsics.checkNotNullParameter(mraidDao, "mraidDao");
        Intrinsics.checkNotNullParameter(oguryApi, "oguryApi");
        Iterator<T> it = ads.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((c) next).l.length() <= 0);
        c cVar = (c) next;
        String str5 = "loaded_source";
        if (cVar == null) {
            str5 = "loaded_source";
        } else {
            String str6 = cVar.l;
            SharedPreferences sharedPref = mraidDao.f7383a;
            Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
            if (Intrinsics.areEqual(str6, p8.a(sharedPref, "mraid_download_url"))) {
                SharedPreferences sharedPref2 = mraidDao.f7383a;
                Intrinsics.checkNotNullExpressionValue(sharedPref2, "sharedPref");
                if (p8.a(sharedPref2, "mraid_js").length() != 0) {
                    str5 = "loaded_source";
                }
            }
            o7 o7Var = o7.LI_014_SDK_EVENT_MRAID_REQUEST;
            r3 r3Var2 = cVar.A.f7388a;
            Intrinsics.checkNotNullParameter(r3Var2, "<this>");
            int iOrdinal = r3Var2.ordinal();
            if (iOrdinal == 0) {
                obj = "format";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = "sdk";
            }
            Pair pair = TuplesKt.to("loaded_source", obj);
            Pair pair2 = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
            Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
            Pair pair4 = TuplesKt.to("url", cVar.l);
            int i = cVar.K;
            monitoringEventLogger.a(o7Var, cVar, p7.a(pair, pair2, pair3, pair4, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
            r4.a(cVar.l, true, mraidDao, oguryApi);
        }
        d4 d4Var = this.e;
        o7 o7Var2 = o7.LI_013_SDK_EVENT_AD_PARSED;
        c cVar2 = (c) CollectionsKt.first((List) lVarA.f7342a);
        Pair pair5 = TuplesKt.to("from_ad_markup", Boolean.valueOf(z2));
        Pair pair6 = TuplesKt.to("reload", Boolean.valueOf(z));
        c cVar3 = (c) CollectionsKt.firstOrNull((List) lVarA.f7342a);
        if (cVar3 == null || (q3Var = cVar3.A) == null || (r3Var = q3Var.f7388a) == null) {
            obj2 = null;
        } else {
            Intrinsics.checkNotNullParameter(r3Var, "<this>");
            int iOrdinal2 = r3Var.ordinal();
            if (iOrdinal2 == 0) {
                obj2 = "format";
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                obj2 = "sdk";
            }
        }
        d4Var.a(o7Var2, cVar2, p7.a(pair5, pair6, TuplesKt.to(str5, obj2)));
        return lVarA;
    }

    public final void a(d dVar, String str, OguryMediation oguryMediation, Throwable th, boolean z, boolean z2, int i) throws JSONException {
        n7 n7Var;
        if (z) {
            n7Var = n7.LE_017_AD_ERROR_AD_MARKUP_PARSING_HAS_FAILED;
        } else {
            n7Var = n7.LE_017_AD_ERROR_AD_RESPONSE_PARSING_FAILED;
        }
        this.e.a(n7Var, dVar.f7276a, str, oguryMediation, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(z)), TuplesKt.to("reload", Boolean.valueOf(z2)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), new JSONObject().put("stacktrace", th.getMessage()));
    }
}
