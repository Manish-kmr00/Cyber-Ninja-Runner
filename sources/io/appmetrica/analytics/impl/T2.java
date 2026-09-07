package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.appmetrica.analytics.profile.UserProfile;
import io.appmetrica.analytics.profile.UserProfileUpdate;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class T2 implements Ka {
    public static final HashSet m = new HashSet(Arrays.asList(1, 13));
    public static final R2 n = new R2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f11358a;
    protected final C4568xh b;
    protected final PublicLogger c;
    protected final C4350on d;
    protected final C4467tg e;
    protected final C6 f;
    public final X g;
    protected final C4320ni h;
    public C4462tb i;
    public final C4264lc j;
    public final T9 k;
    public final C4590ye l;

    public T2(Context context, C4320ni c4320ni, C4568xh c4568xh, T9 t9, C4264lc c4264lc, C4350on c4350on, C4467tg c4467tg, C6 c6, X x, C4590ye c4590ye) {
        this.f11358a = context.getApplicationContext();
        this.h = c4320ni;
        this.b = c4568xh;
        this.k = t9;
        this.d = c4350on;
        this.e = c4467tg;
        this.f = c6;
        this.g = x;
        this.l = c4590ye;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c4568xh.b().getApiKey());
        this.c = orCreatePublicLogger;
        c4568xh.a(new Tk(orCreatePublicLogger, "Crash Environment"));
        if (AbstractC4429s3.a(c4568xh.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = c4264lc;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put error environment pair <%s, %s>", str, str2);
        I8 i8 = this.b.c;
        i8.b.b(i8.f11191a, str, str2);
    }

    public final void b(Map<String, String> map) {
        if (In.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public final void c(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        C4462tb c4462tb = this.i;
        c4462tb.f11779a.removeCallbacks(c4462tb.c, c4462tb.b.b.b.getApiKey());
        this.b.e = true;
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4("", str, 3, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        this.c.info("Clear app environment", new Object[0]);
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C3984a6 c3984a6N = C4082e4.n();
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        c4320ni.a(new C4319nh(c3984a6N, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        C4462tb c4462tb = this.i;
        C4462tb.a(c4462tb.f11779a, c4462tb.b, c4462tb.c);
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4("", str, 6400, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.b.e = false;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this;
    }

    public String j() {
        return "[BaseReporter]";
    }

    public void k() {
        String str;
        C4118ff c4118ff;
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C4217jf c4217jf = c4568xh.d;
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c4568xh.b.getApiKey());
        Set set = C9.f11086a;
        JSONObject jSONObject = new JSONObject();
        if (c4217jf != null && (c4118ff = c4217jf.f11619a) != null) {
            try {
                jSONObject.put("preloadInfo", c4118ff.c());
            } catch (Throwable unused) {
            }
        }
        String string = jSONObject.toString();
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(string, "", 6144, 0, orCreatePublicLogger);
        c4082e4.c(str);
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.c.info("Pause session", new Object[0]);
        c(null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        this.c.info("Put app environment: <%s, %s>", str, str2);
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C3984a6 c3984a6B = C4082e4.b(str, str2);
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str3 = c4568xh.f;
        }
        c4320ni.a(new C4319nh(c3984a6B, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        StackTraceElement[] stackTraceElementArrB;
        Y y = new Y(new Z(this, map));
        C4436sa c4436sa = new C4436sa();
        C4264lc c4264lc = C4455t4.i().f11773a;
        Thread threadA = y.a();
        Map mapC = null;
        try {
            stackTraceElementArrB = y.b();
            if (stackTraceElementArrB == null) {
                try {
                    stackTraceElementArrB = threadA.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArrB = null;
        }
        Tm tm = (Tm) c4436sa.apply(threadA, stackTraceElementArrB);
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Ym());
        try {
            mapC = y.c();
        } catch (SecurityException unused3) {
        }
        if (mapC != null) {
            treeMap.putAll(mapC);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            if (thread != threadA && thread != null) {
                arrayList.add((Tm) c4436sa.apply(thread, (StackTraceElement[]) entry.getValue()));
            }
        }
        a(new S(tm, arrayList, c4264lc.b()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        for (C4469ti c4469ti : eCommerceEvent.toProto()) {
            C4082e4 c4082e4 = new C4082e4(LoggerStorage.getOrCreatePublicLogger(c4568xh.b.getApiKey()));
            EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
            c4082e4.d = 41000;
            c4082e4.b = c4082e4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) c4469ti.f11783a)));
            c4082e4.g = c4469ti.b.getBytesTruncated();
            C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
            synchronized (c4568xh) {
                str = c4568xh.f;
            }
            c4320ni.a(new C4319nh(c4082e4, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        C4442sg c4442sg = new C4442sg(str, a(th));
        C4320ni c4320ni = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(c4442sg));
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(byteArray, str, 5892, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4("", str, 1, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        Di di = S2.f11342a;
        di.getClass();
        Nn nnA = di.a(revenue);
        if (!nnA.f11273a) {
            this.c.warning("Passed revenue is not valid. Reason: " + nnA.b, new Object[0]);
            return;
        }
        C4320ni c4320ni = this.h;
        Ei ei = new Ei(revenue, this.c);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C4082e4 c4082e4A = C4082e4.a(LoggerStorage.getOrCreatePublicLogger(c4568xh.b.getApiKey()), ei);
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        c4320ni.a(new C4319nh(c4082e4A, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str)));
        this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + " " + revenue.currency, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        C4325nn c4325nnA = AbstractC4400qn.a(th, new S(null, null, this.j.b()), null, (String) this.k.b.a(), (Boolean) this.k.c.a());
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.d.b();
        c4320ni.a(c4320ni.b.a(c4325nnA, c4568xh));
        this.c.info("Unhandled exception received: " + c4325nnA, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        String str;
        An an = new An(An.c);
        Iterator<UserProfileUpdate<? extends Bn>> it = userProfile.getUserProfileUpdates().iterator();
        while (it.hasNext()) {
            Bn userProfileUpdatePatcher = it.next().getUserProfileUpdatePatcher();
            ((AbstractC4614zd) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(an);
        }
        Fn fn = new Fn();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < an.f11064a.size(); i++) {
            SparseArray sparseArray = an.f11064a;
            Iterator it2 = ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values().iterator();
            while (it2.hasNext()) {
                arrayList.add((Cn) it2.next());
            }
        }
        fn.f11148a = (Cn[]) arrayList.toArray(new Cn[arrayList.size()]);
        Nn nnA = n.a(fn);
        if (!nnA.f11273a) {
            this.c.warning("UserInfo wasn't sent because " + nnA.b, new Object[0]);
            return;
        }
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C3984a6 c3984a6A = C4082e4.a(fn);
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        c4320ni.a(new C4319nh(c3984a6A, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str)));
        this.c.info("User profile received", new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        d(null);
        this.c.info("Resume session", new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        this.c.info("Send event buffer", new Object[0]);
        C4320ni c4320ni = this.h;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        C4082e4 c4082e4 = new C4082e4("", "", 256, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
        this.c.info("Updated data sending enabled: %s", Boolean.valueOf(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c4082e4.p = Collections.singletonMap(str, bArr);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C4082e4 c4082e4 = new C4082e4(LoggerStorage.getOrCreatePublicLogger(c4568xh.b.getApiKey()));
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c4082e4.d = 40962;
        c4082e4.c(str);
        c4082e4.b = c4082e4.e(str);
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str2 = c4568xh.f;
        }
        c4320ni.a(new C4319nh(c4082e4, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        C4320ni c4320ni = this.h;
        B b = new B(adRevenue, z, this.c);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        C4082e4 c4082e4A = C4082e4.a(LoggerStorage.getOrCreatePublicLogger(c4568xh.b.getApiKey()), b);
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        c4320ni.a(new C4319nh(c4082e4A, false, 1, null, new C4568xh(c4367pf, counterConfiguration, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + AbstractC4288mb.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(str2, str, 1, 0, publicLogger);
        c4082e4.l = EnumC4435s9.JS;
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (In.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(str2, str, 1, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    public final C4325nn a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTrace;
        if (th == null) {
            stackTrace = null;
            th2 = null;
        } else if (th instanceof R1) {
            stackTrace = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTrace = null;
        }
        return AbstractC4400qn.a(th2, new S(null, null, this.j.b()), stackTrace != null ? Arrays.asList(stackTrace) : null, (String) this.k.b.a(), (Boolean) this.k.c.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        B6 b6 = new B6(new C4442sg(str2, a(th)), str);
        C4320ni c4320ni = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(b6));
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(byteArray, str2, 5896, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        C4325nn c4325nnA = this.l.a(pluginErrorDetails);
        C4320ni c4320ni = this.h;
        C4076dn c4076dn = c4325nnA.f11690a;
        String str = c4076dn != null ? (String) WrapUtils.getOrDefault(c4076dn.f11522a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(c4325nnA));
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(byteArray, str, 5891, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c4320ni.a(new C4082e4("", str, 1, 0, publicLogger), this.b, 1, map);
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(map == null ? null : map.toString()), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ya, io.appmetrica.analytics.impl.InterfaceC4014bb
    public void a(C4325nn c4325nn) {
        C4320ni c4320ni = this.h;
        C4568xh c4568xh = this.b;
        c4320ni.d.b();
        C4319nh c4319nhA = c4320ni.b.a(c4325nn, c4568xh);
        C4568xh c4568xh2 = c4319nhA.e;
        InterfaceC4422rl interfaceC4422rl = c4320ni.e;
        if (interfaceC4422rl != null) {
            c4568xh2.b.setUuid(((C4398ql) interfaceC4422rl).g());
        } else {
            c4568xh2.getClass();
        }
        c4320ni.c.b(c4319nhA);
        this.c.info("Unhandled exception received: " + c4325nn, new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C4325nn c4325nnA;
        C4590ye c4590ye = this.l;
        if (pluginErrorDetails != null) {
            c4325nnA = c4590ye.a(pluginErrorDetails);
        } else {
            c4590ye.getClass();
            c4325nnA = null;
        }
        C4442sg c4442sg = new C4442sg(str, c4325nnA);
        C4320ni c4320ni = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(c4442sg));
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(byteArray, str, 5896, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        if (m.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        int type = moduleEvent.getType();
        String name = moduleEvent.getName();
        String value = moduleEvent.getValue();
        Map<String, Object> environment = moduleEvent.getEnvironment();
        Map<String, byte[]> extras = moduleEvent.getExtras();
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(value, name, 8192, type, publicLogger);
        c4082e4.c = AbstractC4288mb.b(environment);
        if (extras != null) {
            c4082e4.p = extras;
        }
        this.h.a(c4082e4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.impl.Ya, io.appmetrica.analytics.impl.InterfaceC3978a0
    public final void a(S s) {
        W w = new W(s, (String) this.k.b.a(), (Boolean) this.k.c.a());
        C4320ni c4320ni = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(w));
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(byteArray, "", 5968, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("ANR was reported ");
        Tm tm = s.f11339a;
        publicLogger2.info(sb.append(tm != null ? "Thread[name=" + tm.f11369a + ",tid={" + tm.c + ", priority=" + tm.b + ", group=" + tm.d + "}] at " + CollectionsKt.joinToString$default(tm.f, "\n", null, null, 0, null, null, 62, null) : null).toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        C4325nn c4325nnA;
        C4590ye c4590ye = this.l;
        if (pluginErrorDetails != null) {
            c4325nnA = c4590ye.a(pluginErrorDetails);
        } else {
            c4590ye.getClass();
            c4325nnA = null;
        }
        B6 b6 = new B6(new C4442sg(str2, c4325nnA), str);
        C4320ni c4320ni = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(b6));
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(byteArray, str2, 5896, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(String str) {
        C4320ni c4320ni = this.h;
        C3984a6 c3984a6A = C3984a6.a(str);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c3984a6A, c4568xh), c4568xh, 1, null);
    }
}
