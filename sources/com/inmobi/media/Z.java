package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdConfig.AdQualityConfig f3249a;
    public final L4 b;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public final CopyOnWriteArrayList f;
    public AdQualityControl g;
    public Xc h;
    public AdQualityResult i;
    public String j;
    public JSONObject k;
    public final AtomicBoolean l;

    public Z(AdConfig.AdQualityConfig adQualityConfig, L4 l4) {
        Intrinsics.checkNotNullParameter(adQualityConfig, "adQualityConfig");
        this.f3249a = adQualityConfig;
        this.b = l4;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new CopyOnWriteArrayList();
        this.h = Xc.UNKNOWN;
        this.j = "";
        this.k = new JSONObject();
        this.l = new AtomicBoolean(false);
    }

    public final boolean a() {
        if (this.c.get()) {
            a("ad quality session is already in progress. skipping...");
            return false;
        }
        if (!this.f3249a.getEnabled()) {
            a("config kill switch - false. ad quality will skip");
            return false;
        }
        if (this.g == null) {
            a("setup not done. skipping");
            return false;
        }
        Xc xc = this.h;
        if (xc != Xc.UNKNOWN && xc != Xc.HIDDEN) {
            return true;
        }
        a("ad view is not visible. skipping");
        return false;
    }

    public final void a(AdQualityResult adQualityResult, boolean z) {
        if (adQualityResult.getBeaconUrl().length() == 0) {
            a("beacon is empty");
            return;
        }
        C3344da process = new C3344da(adQualityResult);
        T t = new T(this, z);
        U shouldProcess = U.f3207a;
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
        ScheduledExecutorService scheduledExecutorService = P.f3162a;
        P.a(0L, new C3333d(shouldProcess, process, t));
    }

    public final void a(final Ba ba, final long j, final boolean z, final C3543ra c3543ra) {
        a("isCapture started - " + this.l.get() + ", isReporting - " + z);
        if (this.l.get() && !z) {
            a((Exception) null, "Screenshot process already in progress... skipping...");
        } else {
            ba.post(new Runnable() { // from class: com.inmobi.media.Z$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Z.a(this.f$0, ba, j, z, c3543ra);
                }
            });
        }
    }

    public static final void a(Z this$0, View adView, long j, boolean z, C3543ra c3543ra) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adView, "$adView");
        Intrinsics.checkNotNullParameter("AdQualityManager", "tag");
        Intrinsics.checkNotNullParameter("starting capture - draw", "message");
        Log.i("AdQualityManager", "starting capture - draw");
        this$0.getClass();
        Intrinsics.checkNotNullParameter(adView, "adView");
        C3459lb process = new C3459lb(adView, this$0.f3249a);
        if (!z) {
            this$0.f.add(process);
        }
        X x = new X(this$0, process, z, c3543ra);
        Y shouldProcess = new Y(this$0);
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
        ScheduledExecutorService scheduledExecutorService = P.f3162a;
        P.a(j, new C3333d(shouldProcess, process, x));
        this$0.l.set(!z);
    }

    public final void a(final Activity activity, final long j, final boolean z, final C3543ra c3543ra) {
        a("isCapture started - " + this.l.get() + ", isReporting - " + z);
        if (this.l.get() && !z) {
            a((Exception) null, "Screenshot process already in progress... skipping...");
        } else {
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.inmobi.media.Z$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Z.a(this.f$0, activity, j, z, c3543ra);
                }
            });
        }
    }

    public static final void a(Z this$0, Activity activity, long j, boolean z, C3543ra c3543ra) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.a("activity is visible");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        Intrinsics.checkNotNullParameter(window, "window");
        C3641y9 process = new C3641y9(window, this$0.f3249a);
        if (!z) {
            this$0.f.add(process);
        }
        X x = new X(this$0, process, z, c3543ra);
        Y shouldProcess = new Y(this$0);
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
        ScheduledExecutorService scheduledExecutorService = P.f3162a;
        P.a(j, new C3333d(shouldProcess, process, x));
        this$0.l.set(!z);
    }

    public final void a(String str, byte[] bArr, boolean z) {
        Context contextD = C3517pb.d();
        if (contextD != null) {
            Bb process = new Bb(contextD.getFilesDir().getAbsolutePath() + "/adQuality/screenshots", bArr);
            if (!z) {
                this.f.add(process);
            }
            V v = new V(this, z, process, str);
            W shouldProcess = W.f3221a;
            Intrinsics.checkNotNullParameter(process, "process");
            Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
            ScheduledExecutorService scheduledExecutorService = P.f3162a;
            P.a(0L, new C3333d(shouldProcess, process, v));
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0097  */
    public final void a(boolean z) {
        String beacon;
        AdQualityResult adQualityResult;
        Intrinsics.checkNotNullParameter("AdQualityManager", "tag");
        Intrinsics.checkNotNullParameter("checking for trigger", "message");
        Log.i("AdQualityManager", "checking for trigger");
        AdQualityControl adQualityControl = this.g;
        if (adQualityControl == null || (beacon = adQualityControl.getBeacon()) == null) {
            return;
        }
        if (this.f.isEmpty() && this.d.get() && !this.e.get()) {
            this.e.set(true);
            a("session end - queuing result");
            AdQualityResult adQualityResult2 = this.i;
            if (adQualityResult2 == null) {
                adQualityResult2 = new AdQualityResult("null", null, beacon, null, 8, null);
            }
            a(adQualityResult2, true);
            return;
        }
        if (this.d.get() && !z && !this.e.get()) {
            this.e.set(true);
            a("session stop - queuing result");
            ScheduledExecutorService scheduledExecutorService = P.f3162a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
                try {
                    try {
                        scheduledExecutorService.shutdownNow();
                    } catch (InterruptedException unused) {
                        scheduledExecutorService.shutdownNow();
                        Thread.currentThread().interrupt();
                        adQualityResult = this.i;
                        if (adQualityResult == null) {
                            adQualityResult = new AdQualityResult("null", null, beacon, null, 8, null);
                        }
                        a(adQualityResult, true);
                        return;
                    }
                } catch (Exception e) {
                    Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
                    Intrinsics.checkNotNullParameter("shutdown fail", "message");
                    Log.e("AdQualityComponent", "shutdown fail", e);
                    Thread.currentThread().interrupt();
                }
            }
            adQualityResult = this.i;
            if (adQualityResult == null) {
                adQualityResult = new AdQualityResult("null", null, beacon, null, 8, null);
            }
            a(adQualityResult, true);
            return;
        }
        String message = "list size - " + this.f.size() + " session end triggered - " + this.d.get() + " queue triggered - " + this.e + " waiting";
        Intrinsics.checkNotNullParameter("AdQualityManager", "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i("AdQualityManager", message);
    }

    public final void a(String str) {
        L4 l4 = this.b;
        if (l4 != null) {
            ((M4) l4).a("AdQualityManager", str);
        }
    }

    public final void a(Exception exc, String str) {
        Unit unit;
        if (exc != null) {
            L4 l4 = this.b;
            if (l4 != null) {
                ((M4) l4).a("AdQualityManager", str, exc);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        L4 l5 = this.b;
        if (l5 != null) {
            ((M4) l5).b("AdQualityManager", S.a("Error with null exception : ", str));
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
