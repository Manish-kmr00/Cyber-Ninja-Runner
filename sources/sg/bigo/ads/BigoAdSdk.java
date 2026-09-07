package sg.bigo.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.models.Protocol;
import net.pubnative.lite.sdk.models.RemoteConfigFeature;
import org.json.JSONArray;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.a.j;
import sg.bigo.ads.api.core.d;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.m;
import sg.bigo.ads.common.n.e;
import sg.bigo.ads.common.o;
import sg.bigo.ads.common.p.h;
import sg.bigo.ads.common.utils.f;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes8.dex */
public class BigoAdSdk {
    private static sg.bigo.ads.controller.e.a c;
    private static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f12456a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final CopyOnWriteArrayList<InitListener> e = new CopyOnWriteArrayList<>();
    private static final List<Pair<String, String>> f = new ArrayList();

    /* JADX INFO: renamed from: sg.bigo.ads.BigoAdSdk$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12461a;

        static {
            int[] iArr = new int[ConsentOptions.values().length];
            f12461a = iArr;
            try {
                iArr[ConsentOptions.LGPD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12461a[ConsentOptions.GDPR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12461a[ConsentOptions.CCPA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12461a[ConsentOptions.COPPA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface InitListener {
        void onInitialized();
    }

    public static a a(Context context) {
        if (d == null) {
            d = new a(context);
        }
        if (!d.c) {
            d.b(context);
        }
        return d;
    }

    public static sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> a(final sg.bigo.ads.api.b bVar, sg.bigo.ads.controller.c cVar) {
        String str;
        bVar.g.f = System.currentTimeMillis();
        sg.bigo.ads.controller.a aVar = new sg.bigo.ads.controller.a(cVar);
        if (!f12456a.get()) {
            aVar.a(0, 1000, 0, "Please initialize SDK before request ads.", new Pair<>(bVar, null));
            return null;
        }
        b(c.f13437a);
        final sg.bigo.ads.controller.e.a aVar2 = c;
        if (q.a((CharSequence) aVar2.e.f13454a.getAppKey())) {
            aVar.a(0, 1013, 10000, "App id cannot be empty, please pass the id when initializing bigo sdk.", new Pair(bVar, null));
            return null;
        }
        d dVarB = bVar.b();
        if (dVarB != null) {
            aVar.a(0, dVarB.f13101a, dVarB.b, dVarB.c, new Pair(bVar, null));
            return null;
        }
        int i = 0;
        byte b2 = 0;
        if (!sg.bigo.ads.common.x.a.p()) {
            final sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> c0884a = new sg.bigo.ads.controller.e.a.C0884a<>(bVar, aVar, b2 == true ? 1 : 0);
            sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.9
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    if (bVar.f()) {
                        ((sg.bigo.ads.api.b) c0884a.f13450a).b(0);
                        a.a(a.this, c0884a);
                    } else {
                        a.this.l.b();
                        a.this.f.a(new e.a() { // from class: sg.bigo.ads.controller.e.a.9.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // sg.bigo.ads.controller.e.e.a
                            public final void a(int i2) {
                                a.a(a.this, 1, (Map) null);
                                ((sg.bigo.ads.api.b) c0884a.f13450a).b(i2);
                                a.a(a.this, c0884a);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // sg.bigo.ads.controller.e.e.a
                            public final void a(int i2, int i3, String str2) {
                                ((sg.bigo.ads.api.b) c0884a.f13450a).b(i2);
                                if (a.this.b.H()) {
                                    a.a(a.this, c0884a);
                                } else {
                                    a.this.a(c0884a, 1008, i3, str2);
                                }
                            }
                        }, 1);
                    }
                }
            });
            return c0884a;
        }
        String str2 = "Missing CCPA consent";
        if (sg.bigo.ads.common.x.a.l() == 2) {
            str = "Missing GDPR consent";
            i = 1;
        } else {
            str = "Missing CCPA consent";
        }
        if (sg.bigo.ads.common.x.a.n() == 2) {
            i++;
            str = "Missing LGPD consent";
        }
        if (sg.bigo.ads.common.x.a.m() == 2) {
            i++;
        } else {
            str2 = str;
        }
        if (sg.bigo.ads.common.x.a.o() == 2) {
            i++;
            str2 = "Missing COPPA consent";
        }
        aVar.a(0, 1001, 800, i > 1 ? "Missing user consent" : str2, new Pair(bVar, null));
        return null;
    }

    private static void a(final Context context, final ConsentOptions consentOptions, boolean z) {
        boolean zA = a(consentOptions, z);
        if (z || !zA) {
            return;
        }
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.2
            @Override // java.lang.Runnable
            public final void run() {
                HashMap map = new HashMap();
                map.put(ConsentOptions.GDPR, Integer.valueOf(sg.bigo.ads.common.x.a.l()));
                map.put(ConsentOptions.LGPD, Integer.valueOf(sg.bigo.ads.common.x.a.n()));
                map.put(ConsentOptions.CCPA, Integer.valueOf(sg.bigo.ads.common.x.a.m()));
                map.put(ConsentOptions.COPPA, Integer.valueOf(sg.bigo.ads.common.x.a.o()));
                map.remove(consentOptions);
                sg.bigo.ads.common.t.a.a(2, 5, "", "Revoking user consent...The cached data of user will be deleted now.");
                sg.bigo.ads.core.d.c cVarA = sg.bigo.ads.core.d.c.a();
                if (cVarA.b != null) {
                    cVarA.b.c.f();
                }
                sg.bigo.ads.core.b.b bVarA = sg.bigo.ads.core.b.b.a();
                if (bVarA.f13513a != null) {
                    bVarA.f13513a.b.g();
                }
                sg.bigo.ads.core.e.a.c cVarA2 = sg.bigo.ads.core.e.a.c.a();
                cVarA2.e = context.getApplicationContext();
                cVarA2.b();
                cVarA2.f13565a.clear();
                sg.bigo.ads.core.player.b bVarA2 = sg.bigo.ads.core.player.b.a();
                Context context2 = context;
                if (bVarA2.g != null) {
                    sg.bigo.ads.common.h.b bVar = bVarA2.g;
                    sg.bigo.ads.common.h.b.b.a();
                    bVar.f13192a.clear();
                    bVar.c.clear();
                    bVar.b.clear();
                    bVar.d.clear();
                }
                if (bVarA2.d != null) {
                    bVarA2.d.clear();
                }
                if (bVarA2.e != null) {
                    bVarA2.e.clear();
                }
                if (bVarA2.f != null) {
                    bVarA2.f.clear();
                }
                h.a.f13258a.e(context2);
                f.b(new File(o.a(context)));
                sg.bigo.ads.common.g.a.a.a();
                sg.bigo.ads.common.x.a.r();
                BigoAdSdk.a(consentOptions);
                for (Map.Entry entry : map.entrySet()) {
                    int i = AnonymousClass5.f12461a[((ConsentOptions) entry.getKey()).ordinal()];
                    if (i == 1) {
                        sg.bigo.ads.common.x.a.d(((Integer) entry.getValue()).intValue());
                    } else if (i == 2) {
                        sg.bigo.ads.common.x.a.b(((Integer) entry.getValue()).intValue());
                    } else if (i == 3) {
                        sg.bigo.ads.common.x.a.c(((Integer) entry.getValue()).intValue());
                    } else if (i == 4) {
                        sg.bigo.ads.common.x.a.e(((Integer) entry.getValue()).intValue());
                    }
                }
            }
        });
    }

    static /* synthetic */ void a(final String str) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.4
            @Override // java.lang.Runnable
            public final void run() {
                if (BigoAdSdk.c != null) {
                    for (Pair pair : BigoAdSdk.f) {
                        BigoAdSdk.c.a((String) pair.first, (String) pair.second);
                    }
                    Map<String, String> mapB = sg.bigo.ads.controller.a.d.b(str);
                    if (!k.a(mapB)) {
                        for (Map.Entry<String, String> entry : mapB.entrySet()) {
                            BigoAdSdk.c.a(entry.getKey(), entry.getValue());
                        }
                    }
                }
                BigoAdSdk.f.clear();
            }
        });
    }

    static /* synthetic */ boolean a(ConsentOptions consentOptions) {
        return a(consentOptions, false);
    }

    private static boolean a(ConsentOptions consentOptions, boolean z) {
        int i = z ? 1 : 2;
        int i2 = AnonymousClass5.f12461a[consentOptions.ordinal()];
        if (i2 == 1) {
            if (i == sg.bigo.ads.common.x.a.n()) {
                return false;
            }
            sg.bigo.ads.common.x.a.d(i);
            return true;
        }
        if (i2 == 2) {
            if (i == sg.bigo.ads.common.x.a.l()) {
                return false;
            }
            sg.bigo.ads.common.x.a.b(i);
            return true;
        }
        if (i2 == 3) {
            if (i == sg.bigo.ads.common.x.a.m()) {
                return false;
            }
            sg.bigo.ads.common.x.a.c(i);
            return true;
        }
        if (i2 != 4 || i == sg.bigo.ads.common.x.a.o()) {
            return false;
        }
        sg.bigo.ads.common.x.a.e(i);
        return true;
    }

    public static void addExtraHost(final String str, final String str2) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.3
            @Override // java.lang.Runnable
            public final void run() {
                if (BigoAdSdk.c == null || !BigoAdSdk.f12456a.get()) {
                    BigoAdSdk.f.add(Pair.create(str, str2));
                } else {
                    BigoAdSdk.c.a(str, str2);
                }
            }
        });
    }

    private static void b(Context context) {
        if (!sg.bigo.ads.common.m.b.f()) {
            sg.bigo.ads.common.t.a.a(0, 3, "GDPR", "GDPRContent is not changed, so return");
            return;
        }
        sg.bigo.ads.common.m.b.g();
        if (!sg.bigo.ads.common.x.b.a()) {
            sg.bigo.ads.common.x.b.f13361a = context.getApplicationContext();
        }
        if (!sg.bigo.ads.common.m.b.a()) {
            sg.bigo.ads.common.m.b.a(context.getApplicationContext());
        }
        if (sg.bigo.ads.common.m.a.b()) {
            a(context, ConsentOptions.GDPR, sg.bigo.ads.common.m.a.a());
        }
    }

    public static String getBidderToken() {
        String str;
        if (f12456a.get()) {
            sg.bigo.ads.controller.e.a aVar = c;
            if (aVar != null) {
                if (aVar.e == null) {
                    return null;
                }
                sg.bigo.ads.controller.e.f fVar = aVar.g;
                if (fVar == null) {
                    fVar = new sg.bigo.ads.controller.e.f();
                    aVar.g = fVar;
                }
                return fVar.a(aVar.e);
            }
            str = "Error to get bidder token with empty controller.";
        } else {
            str = "Please initialize SDK before get bidder token.";
        }
        sg.bigo.ads.common.t.a.a(0, "BigoAdSdk", str);
        return null;
    }

    public static String getHashId() {
        return "c5a60fc";
    }

    public static String getSDKVersion() {
        return "50201";
    }

    public static String getSDKVersionName() {
        return "5.2.1";
    }

    public static void initialize(Context context, AdConfig adConfig, InitListener initListener) {
        boolean z = f12456a.get();
        boolean z2 = !z;
        if (z) {
            sg.bigo.ads.common.t.a.a(2, 5, "", "Bigo Ads SDK init had been invoked.");
        }
        if (sg.bigo.ads.controller.e.c.a().b.get() == -1) {
            sg.bigo.ads.common.t.a.a(2, 5, "", "Bigo Ads SDK wait to initing due to empty config.");
            z2 = true;
        }
        if (!z2) {
            sg.bigo.ads.common.t.a.a(2, 5, "", "Avoid initializing Bigo Ads SDK repeatedly.");
            if (initListener != null) {
                initListener.onInitialized();
                return;
            }
            return;
        }
        if (initListener != null) {
            e.add(initListener);
        }
        m.a(context);
        m.a(adConfig);
        Context applicationContext = context.getApplicationContext();
        m.a(applicationContext);
        if (b.getAndSet(true)) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsDebug = adConfig.isDebug();
        sg.bigo.ads.common.y.a.a((int) (System.currentTimeMillis() / 1000));
        sg.bigo.ads.common.x.b.f13361a = applicationContext;
        sg.bigo.ads.common.m.b.a(applicationContext);
        sg.bigo.ads.common.d.a.a().a(applicationContext);
        b(context);
        t.a(zIsDebug);
        final String extra = adConfig.getExtra(AdConfig.EXTRA_KEY_HOST_RULES);
        final sg.bigo.ads.controller.e.a aVar = new sg.bigo.ads.controller.e.a(applicationContext, adConfig);
        c = aVar;
        final Runnable runnable = new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.1
            @Override // java.lang.Runnable
            public final void run() {
                BigoAdSdk.f12456a.set(true);
                BigoAdSdk.b.set(false);
                BigoAdSdk.a(extra);
                sg.bigo.ads.common.t.a.a(2, 4, "", "Initialized Bigo Ads SDK successfully.");
                for (InitListener initListener2 : BigoAdSdk.e) {
                    if (initListener2 != null) {
                        initListener2.onInitialized();
                    }
                }
                BigoAdSdk.e.clear();
                if (c.a.a().isEmpty()) {
                    return;
                }
                sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        sg.bigo.ads.core.d.b.c(a.c());
                        a.b();
                    }
                });
            }
        };
        aVar.j = jElapsedRealtime;
        aVar.e.f13454a = adConfig;
        aVar.g = new sg.bigo.ads.controller.e.f();
        sg.bigo.ads.common.n.d.a(new sg.bigo.ads.common.n.a() { // from class: sg.bigo.ads.controller.e.a.4
            @Override // sg.bigo.ads.common.n.a
            public final void a(Throwable th) {
                sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(th));
            }
        });
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.5
            /* JADX WARN: Code duplicated, block: B:24:0x0231  */
            /* JADX WARN: Code duplicated, block: B:25:0x0237  */
            /* JADX WARN: Code duplicated, block: B:28:0x0261  */
            /* JADX WARN: Code duplicated, block: B:29:0x0267  */
            /* JADX WARN: Code duplicated, block: B:32:0x02b1  */
            /* JADX WARN: Code duplicated, block: B:33:0x02b6  */
            /* JADX WARN: Code duplicated, block: B:36:0x0394  */
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                sg.bigo.ads.core.d.c cVarA;
                Context context2;
                sg.bigo.ads.core.d.a.a aVar2;
                sg.bigo.ads.controller.d.f fVar;
                d dVar;
                sg.bigo.ads.core.b.b bVarA;
                Context context3;
                sg.bigo.ads.core.b.a.a aVar3;
                sg.bigo.ads.controller.d.b bVar;
                d dVar2;
                sg.bigo.ads.common.h.a.a aVar4;
                sg.bigo.ads.core.player.b bVarA2;
                Context context4;
                boolean zA;
                Runnable runnable2;
                final a aVar5 = a.this;
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                HashMap map = new HashMap();
                d dVar3 = aVar5.e;
                dVar3.d = dVar3.b.getPackageName();
                dVar3.e = sg.bigo.ads.common.utils.c.a(dVar3.b);
                dVar3.f = sg.bigo.ads.common.utils.c.b(dVar3.b);
                dVar3.g = sg.bigo.ads.common.aa.b.b(dVar3.b);
                dVar3.h = q.d(Build.MANUFACTURER);
                dVar3.i = q.d(Build.MODEL);
                dVar3.j = sg.bigo.ads.common.aa.b.d(dVar3.b);
                Point pointD = sg.bigo.ads.common.utils.e.d(dVar3.b);
                dVar3.k = pointD.x + VastAttributes.HORIZONTAL_POSITION + pointD.y;
                float fA = sg.bigo.ads.common.utils.e.a(dVar3.b);
                dVar3.l = (int) (10.0f * fA);
                if (fA > 0.0f) {
                    dVar3.m = Math.round(pointD.x / fA) + VastAttributes.HORIZONTAL_POSITION + Math.round(pointD.y / fA);
                }
                PackageInfo packageInfoE = sg.bigo.ads.common.utils.c.e(dVar3.b, "com.google.android.gms");
                if (packageInfoE != null) {
                    dVar3.n = packageInfoE.versionName;
                }
                dVar3.o = sg.bigo.ads.common.aa.b.f(dVar3.b);
                dVar3.p = sg.bigo.ads.common.aa.a.a();
                dVar3.q = sg.bigo.ads.common.aa.a.b();
                dVar3.r = p.b(dVar3.b);
                dVar3.t = sg.bigo.ads.common.utils.c.f(dVar3.b, dVar3.d);
                dVar3.s = sg.bigo.ads.common.z.a.a();
                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                map.put("1", String.valueOf(jElapsedRealtime4));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 1 cost: " + String.valueOf(jElapsedRealtime4));
                sg.bigo.ads.a aVarA = BigoAdSdk.a(aVar5.f13437a);
                if (q.a((CharSequence) aVarA.f12462a)) {
                    aVarA.f12462a = aVar5.e.f13454a.getAppKey();
                }
                long jElapsedRealtime5 = SystemClock.elapsedRealtime();
                long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime3;
                map.put("2", String.valueOf(jElapsedRealtime6));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 2 cost: " + String.valueOf(jElapsedRealtime6));
                if (TextUtils.equals(aVar5.e.f13454a.getAppKey(), aVarA.f12462a)) {
                    aVar5.d.f13381a.b(aVar5.f13437a);
                    aVar5.b.b(aVar5.f13437a);
                    aVar5.c.b(aVar5.f13437a);
                }
                long jElapsedRealtime7 = SystemClock.elapsedRealtime();
                long jElapsedRealtime8 = SystemClock.elapsedRealtime() - jElapsedRealtime5;
                map.put("3", String.valueOf(jElapsedRealtime8));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 3 cost: " + String.valueOf(jElapsedRealtime8));
                aVar5.b.v();
                h.a().a(aVar5.b.D());
                sg.bigo.ads.common.g.a.a.a(aVar5.f13437a, new sg.bigo.ads.common.g.a.a.InterfaceC0865a() { // from class: sg.bigo.ads.controller.e.a.7
                    @Override // sg.bigo.ads.common.g.a.a.InterfaceC0865a
                    public final void a() {
                        sg.bigo.ads.common.g.a.a.b("tb_addata", "end_time < " + System.currentTimeMillis(), null);
                        t.a();
                    }

                    @Override // sg.bigo.ads.common.g.a.a.InterfaceC0865a
                    public final void a(String str2) {
                        sg.bigo.ads.core.d.b.a(3000, 10101, str2);
                    }
                });
                long jElapsedRealtime9 = SystemClock.elapsedRealtime();
                long jElapsedRealtime10 = SystemClock.elapsedRealtime() - jElapsedRealtime7;
                map.put(Protocol.VAST_1_0_WRAPPER, String.valueOf(jElapsedRealtime10));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 4 cost: " + String.valueOf(jElapsedRealtime10));
                sg.bigo.ads.core.e.a.c cVarA2 = sg.bigo.ads.core.e.a.c.a();
                Context context5 = aVar5.f13437a;
                r rVar = aVar5.b.f13404a;
                sg.bigo.ads.controller.d.d dVar4 = new sg.bigo.ads.controller.d.d(aVar5.d);
                cVarA2.e = context5;
                if (!cVarA2.b.getAndSet(true)) {
                    cVarA2.c = rVar;
                    cVarA2.d = dVar4;
                    if (cVarA2.c.f13115a) {
                        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.c.3
                            public AnonymousClass3() {
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "init retry tracker");
                                Set set = c.this.f13565a;
                                f fVar2 = f.a.f13571a;
                                set.addAll(f.a(0L, c.this.c));
                                c.this.d();
                            }
                        });
                    } else {
                        str = "config invalid";
                    }
                    cVarA = sg.bigo.ads.core.d.c.a();
                    context2 = aVar5.f13437a;
                    aVar2 = aVar5.b.f;
                    fVar = new sg.bigo.ads.controller.d.f(aVar5.e, aVar5.d);
                    dVar = aVar5.e;
                    if (cVarA.c.getAndSet(true)) {
                        sg.bigo.ads.common.t.a.a(0, 3, "Stats", "already init.");
                    } else {
                        cVarA.f13548a = aVar2;
                        cVarA.d = dVar;
                        cVarA.b = new sg.bigo.ads.core.d.b.b(context2, cVarA.f13548a, fVar, dVar);
                    }
                    bVarA = sg.bigo.ads.core.b.b.a();
                    context3 = aVar5.f13437a;
                    aVar3 = aVar5.b.g;
                    bVar = new sg.bigo.ads.controller.d.b(aVar5.e, aVar5.d);
                    dVar2 = aVar5.e;
                    if (bVarA.b.getAndSet(true)) {
                        sg.bigo.ads.common.t.a.a(0, 3, "Callback", "already init.");
                    } else {
                        bVarA.f13513a = new sg.bigo.ads.core.b.b.a(context3, aVar3, bVar, dVar2);
                    }
                    sg.bigo.ads.common.form.b bVarA3 = sg.bigo.ads.common.form.b.a();
                    sg.bigo.ads.controller.d.c cVar = new sg.bigo.ads.controller.d.c(aVar5.e, aVar5.d);
                    bVarA3.f13157a.set(true);
                    bVarA3.b = cVar;
                    sg.bigo.ads.core.d.a.a().f13534a = new sg.bigo.ads.controller.d.e(aVar5.e, aVar5.d);
                    aVar4 = aVar5.b.e;
                    j jVarN = aVar5.b.n();
                    bVarA2 = sg.bigo.ads.core.player.b.a();
                    context4 = aVar5.f13437a;
                    zA = jVarN.a(12);
                    bVarA2.c = context4;
                    if (bVarA2.b.getAndSet(true)) {
                        sg.bigo.ads.common.h.b.a("already init.", (sg.bigo.ads.common.h.a) null);
                    } else {
                        bVarA2.i = aVar4;
                        bVarA2.g = new sg.bigo.ads.common.h.b(context4, bVarA2.i, zA, bVarA2);
                        bVarA2.h = new sg.bigo.ads.core.player.a(bVarA2);
                        bVarA2.d = new ArrayList();
                        bVarA2.e = new ArrayList();
                        bVarA2.f = new Hashtable();
                        bVarA2.c();
                        sg.bigo.ads.common.p.h.a.f13258a.a(aVar4);
                        sg.bigo.ads.common.p.d.a.f13255a.a(aVar4);
                        sg.bigo.ads.common.p.h.a.f13258a.d(context4);
                        sg.bigo.ads.common.p.d.a.f13255a.d(context4);
                    }
                    long jElapsedRealtime11 = SystemClock.elapsedRealtime();
                    long jElapsedRealtime12 = SystemClock.elapsedRealtime() - jElapsedRealtime9;
                    map.put("5", String.valueOf(jElapsedRealtime12));
                    sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 5 cost: " + String.valueOf(jElapsedRealtime12));
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.controller.e.a.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            sg.bigo.ads.core.c.c.a.f13533a.a(a.this.f13437a, a.this.b.C());
                        }
                    });
                    long jElapsedRealtime13 = SystemClock.elapsedRealtime();
                    long jElapsedRealtime14 = SystemClock.elapsedRealtime() - jElapsedRealtime11;
                    map.put("6", String.valueOf(jElapsedRealtime14));
                    sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 6 cost: " + String.valueOf(jElapsedRealtime14));
                    sg.bigo.ads.controller.f.a.a(aVar5.f13437a, aVar5);
                    sg.bigo.ads.common.aa.b.g(aVar5.f13437a);
                    aVar5.l.a();
                    aVar5.d.a(RtspMediaSource.DEFAULT_TIMEOUT_MS, "[sdk init]");
                    long jElapsedRealtime15 = SystemClock.elapsedRealtime() - jElapsedRealtime13;
                    map.put("7", String.valueOf(jElapsedRealtime15));
                    sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 7 cost: " + String.valueOf(jElapsedRealtime15));
                    runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    a.a(a.this, 0, map);
                }
                str = "already init";
                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", str);
                cVarA = sg.bigo.ads.core.d.c.a();
                context2 = aVar5.f13437a;
                aVar2 = aVar5.b.f;
                fVar = new sg.bigo.ads.controller.d.f(aVar5.e, aVar5.d);
                dVar = aVar5.e;
                if (cVarA.c.getAndSet(true)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "Stats", "already init.");
                } else {
                    cVarA.f13548a = aVar2;
                    cVarA.d = dVar;
                    cVarA.b = new sg.bigo.ads.core.d.b.b(context2, cVarA.f13548a, fVar, dVar);
                }
                bVarA = sg.bigo.ads.core.b.b.a();
                context3 = aVar5.f13437a;
                aVar3 = aVar5.b.g;
                bVar = new sg.bigo.ads.controller.d.b(aVar5.e, aVar5.d);
                dVar2 = aVar5.e;
                if (bVarA.b.getAndSet(true)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "Callback", "already init.");
                } else {
                    bVarA.f13513a = new sg.bigo.ads.core.b.b.a(context3, aVar3, bVar, dVar2);
                }
                sg.bigo.ads.common.form.b bVarA4 = sg.bigo.ads.common.form.b.a();
                sg.bigo.ads.controller.d.c cVar2 = new sg.bigo.ads.controller.d.c(aVar5.e, aVar5.d);
                bVarA4.f13157a.set(true);
                bVarA4.b = cVar2;
                sg.bigo.ads.core.d.a.a().f13534a = new sg.bigo.ads.controller.d.e(aVar5.e, aVar5.d);
                aVar4 = aVar5.b.e;
                j jVarN2 = aVar5.b.n();
                bVarA2 = sg.bigo.ads.core.player.b.a();
                context4 = aVar5.f13437a;
                zA = jVarN2.a(12);
                bVarA2.c = context4;
                if (bVarA2.b.getAndSet(true)) {
                    sg.bigo.ads.common.h.b.a("already init.", (sg.bigo.ads.common.h.a) null);
                } else {
                    bVarA2.i = aVar4;
                    bVarA2.g = new sg.bigo.ads.common.h.b(context4, bVarA2.i, zA, bVarA2);
                    bVarA2.h = new sg.bigo.ads.core.player.a(bVarA2);
                    bVarA2.d = new ArrayList();
                    bVarA2.e = new ArrayList();
                    bVarA2.f = new Hashtable();
                    bVarA2.c();
                    sg.bigo.ads.common.p.h.a.f13258a.a(aVar4);
                    sg.bigo.ads.common.p.d.a.f13255a.a(aVar4);
                    sg.bigo.ads.common.p.h.a.f13258a.d(context4);
                    sg.bigo.ads.common.p.d.a.f13255a.d(context4);
                }
                long jElapsedRealtime16 = SystemClock.elapsedRealtime();
                long jElapsedRealtime17 = SystemClock.elapsedRealtime() - jElapsedRealtime9;
                map.put("5", String.valueOf(jElapsedRealtime17));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 5 cost: " + String.valueOf(jElapsedRealtime17));
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.controller.e.a.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        sg.bigo.ads.core.c.c.a.f13533a.a(a.this.f13437a, a.this.b.C());
                    }
                });
                long jElapsedRealtime18 = SystemClock.elapsedRealtime();
                long jElapsedRealtime19 = SystemClock.elapsedRealtime() - jElapsedRealtime16;
                map.put("6", String.valueOf(jElapsedRealtime19));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 6 cost: " + String.valueOf(jElapsedRealtime19));
                sg.bigo.ads.controller.f.a.a(aVar5.f13437a, aVar5);
                sg.bigo.ads.common.aa.b.g(aVar5.f13437a);
                aVar5.l.a();
                aVar5.d.a(RtspMediaSource.DEFAULT_TIMEOUT_MS, "[sdk init]");
                long jElapsedRealtime110 = SystemClock.elapsedRealtime() - jElapsedRealtime18;
                map.put("7", String.valueOf(jElapsedRealtime110));
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The init step 7 cost: " + String.valueOf(jElapsedRealtime110));
                runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                a.a(a.this, 0, map);
            }
        });
        e.a(new sg.bigo.ads.common.n.a() { // from class: sg.bigo.ads.controller.e.a.6
            @Override // sg.bigo.ads.common.n.a
            public final void a(Throwable th) {
                String name = Thread.currentThread().getName();
                if (name.contains("ReportNet") || name.contains("Stat-Worker")) {
                    return;
                }
                sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(th));
            }
        });
    }

    public static boolean isInitialized() {
        return f12456a.get();
    }

    public static boolean isOffice() {
        return true;
    }

    public static void setUserConsent(Context context, final ConsentOptions consentOptions, final boolean z) {
        String str;
        if (!sg.bigo.ads.common.x.b.a()) {
            sg.bigo.ads.common.x.b.f13361a = context.getApplicationContext();
        }
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.c.1
            /* JADX WARN: Code duplicated, block: B:18:0x004e  */
            /* JADX WARN: Code duplicated, block: B:19:0x0050  */
            /* JADX WARN: Code duplicated, block: B:23:0x0058  */
            /* JADX WARN: Code duplicated, block: B:26:0x0061  */
            /* JADX WARN: Code duplicated, block: B:27:0x006a  */
            /* JADX WARN: Code duplicated, block: B:30:0x0081  */
            /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
            @Override // java.lang.Runnable
            public final void run() {
                String strValueOf;
                String str2;
                String str3;
                String str4;
                String str5;
                String strValueOf2;
                a aVar;
                ConsentOptions consentOptions2 = consentOptions;
                boolean z2 = z;
                int i = AnonymousClass3.f13120a[consentOptions2.ordinal()];
                if (i == 1) {
                    strValueOf = String.valueOf(sg.bigo.ads.common.x.a.n());
                    str2 = "lgpd";
                } else if (i == 2) {
                    strValueOf = String.valueOf(sg.bigo.ads.common.x.a.m());
                    str2 = RemoteConfigFeature.UserConsent.CCPA;
                } else {
                    if (i != 3) {
                        if (i != 4) {
                            str4 = "";
                            str3 = str4;
                        } else {
                            strValueOf = String.valueOf(sg.bigo.ads.common.x.a.l());
                            str2 = "gdpr";
                        }
                        if (z2) {
                            str5 = "1";
                        } else {
                            str5 = "2";
                        }
                        String str6 = sg.bigo.ads.controller.e.f.f13459a ? "1" : "0";
                        if (sg.bigo.ads.common.m.b.h()) {
                            strValueOf2 = String.valueOf(sg.bigo.ads.common.m.b.c());
                        } else {
                            strValueOf2 = "-1";
                        }
                        aVar = new a(str4, str3, str5, str6, strValueOf2, sg.bigo.ads.common.m.b.b(), sg.bigo.ads.common.m.b.d());
                        if (BigoAdSdk.isInitialized()) {
                            a.a(aVar);
                            return;
                        }
                        HashMap map = new HashMap();
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(a.b(aVar));
                        map.put("user_consent_event", jSONArray.toString());
                        map.put(CommonUrlParts.UUID, sg.bigo.ads.common.x.a.q());
                        sg.bigo.ads.core.d.b.c(map);
                    }
                    strValueOf = String.valueOf(sg.bigo.ads.common.x.a.o());
                    str2 = "coppa";
                }
                str3 = strValueOf;
                str4 = str2;
                if (z2) {
                    str5 = "1";
                } else {
                    str5 = "2";
                }
                String str7 = sg.bigo.ads.controller.e.f.f13459a ? "1" : "0";
                if (sg.bigo.ads.common.m.b.h()) {
                    strValueOf2 = String.valueOf(sg.bigo.ads.common.m.b.c());
                } else {
                    strValueOf2 = "-1";
                }
                aVar = new a(str4, str3, str5, str7, strValueOf2, sg.bigo.ads.common.m.b.b(), sg.bigo.ads.common.m.b.d());
                if (BigoAdSdk.isInitialized()) {
                    a.a(aVar);
                    return;
                }
                HashMap map2 = new HashMap();
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(a.b(aVar));
                map2.put("user_consent_event", jSONArray2.toString());
                map2.put(CommonUrlParts.UUID, sg.bigo.ads.common.x.a.q());
                sg.bigo.ads.core.d.b.c(map2);
            }
        });
        if (consentOptions == ConsentOptions.GDPR && sg.bigo.ads.common.m.a.b()) {
            str = "Filter the consent status from user: ";
        } else {
            a(context, consentOptions, z);
            str = "Update the consent status from user: ";
        }
        sg.bigo.ads.common.t.a.a(2, 4, "", str.concat(String.valueOf(z)));
    }
}
