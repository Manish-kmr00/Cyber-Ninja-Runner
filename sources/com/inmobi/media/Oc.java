package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.exceptions.VastException;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public final class Oc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Oc f3161a = new Oc();
    public static final Lazy b = LazyKt.lazy(Nc.f3151a);
    public static final Lazy c = LazyKt.lazy(Mc.f3139a);

    public static void a(final C3389h ad, final AdConfig adConfig, final Pc pc, final L4 l4) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        ((ExecutorService) b.getValue()).execute(new Runnable() { // from class: com.inmobi.media.Oc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Oc.b(ad, adConfig, pc, l4);
            }
        });
    }

    public static final void b(C3389h ad, AdConfig adConfig, Pc pc, L4 l4) {
        Intrinsics.checkNotNullParameter(ad, "$ad");
        Intrinsics.checkNotNullParameter(adConfig, "$adConfig");
        Oc oc = f3161a;
        try {
            if (oc.a(ad.s(), pc)) {
                C3389h c3389hA = AbstractC3589v.a(ad, adConfig, l4);
                if (c3389hA == null) {
                    oc.a(ad, false, (short) 75);
                } else {
                    oc.a(c3389hA, true, (short) 0);
                }
            }
        } catch (VastException e) {
            oc.a(ad, false, e.getTelemetryErrorCode());
        } catch (JSONException unused) {
            oc.a(ad, false, (short) 58);
        }
    }

    public final synchronized boolean a(String str, Pc pc) {
        Lazy lazy = c;
        List list = (List) ((HashMap) lazy.getValue()).get(str);
        if (list != null) {
            list.add(new WeakReference(pc));
            return false;
        }
        ((HashMap) lazy.getValue()).put(str, CollectionsKt.mutableListOf(new WeakReference(pc)));
        return true;
    }

    public final synchronized void a(final C3389h c3389h, final boolean z, final short s) {
        Unit unit;
        List list = (List) ((HashMap) c.getValue()).remove(c3389h.s());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Pc pc = (Pc) ((WeakReference) it.next()).get();
                if (pc != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.Oc$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Oc.a(pc, c3389h, z, s);
                        }
                    });
                } else {
                    Intrinsics.checkNotNullExpressionValue("Oc", "TAG");
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Intrinsics.checkNotNullExpressionValue("Oc", "TAG");
        }
    }

    public static final void a(Pc pc, C3389h ad, boolean z, short s) {
        Intrinsics.checkNotNullParameter(ad, "$ad");
        pc.a(ad, z, s);
    }
}
