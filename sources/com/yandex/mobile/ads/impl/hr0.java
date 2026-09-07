package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9128a;
    private final wr b;
    private final e1 c;
    private final int d;
    private final j1 e;
    private final o3 f;
    private final ir0 g;
    private final aw h;

    public final gr0<ExtendedNativeAdView> a(Context context, ViewGroup container, m61 nativeAdPrivate, pt nativeAdEventListener, k3 adCompleteListener, ds1 closeVerificationController, y42 timeProviderContainer, i20 divKitActionHandlerDelegate, y20 y20Var, m6 m6Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(divKitActionHandlerDelegate, "divKitActionHandlerDelegate");
        o3 adConfiguration = this.f;
        o8<?> adResponse = this.f9128a;
        j1 adActivityListener = this.e;
        int i = this.d;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        List<be0> designCreators = (adResponse.n() == qs.f ? new js1(adConfiguration, adActivityListener, new fs1(adConfiguration, adActivityListener, i)) : new aq0(adConfiguration, adActivityListener, new zp0(adConfiguration, adActivityListener, i), new y41())).a(context, this.f9128a, nativeAdPrivate, this.b, nativeAdEventListener, this.c, this.h, adCompleteListener, closeVerificationController, timeProviderContainer, divKitActionHandlerDelegate, y20Var, m6Var);
        ir0 ir0Var = this.g;
        o8<?> adResponse2 = this.f9128a;
        wr contentCloseListener = this.b;
        e1 eventController = this.c;
        ir0Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse2, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(designCreators, "designCreators");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(designCreators, 10));
        Iterator<T> it = designCreators.iterator();
        while (it.hasNext()) {
            arrayList.add(((be0) it.next()).a(context, adResponse2, nativeAdPrivate, contentCloseListener, nativeAdEventListener, eventController));
        }
        return new gr0<>(context, container, arrayList, new fr0(arrayList), new dr0(), new cr0());
    }

    public /* synthetic */ hr0(Context context, o8 o8Var, wr wrVar, e1 e1Var, int i, v1 v1Var, o3 o3Var) {
        this(context, o8Var, wrVar, e1Var, i, v1Var, o3Var, new ir0(), new cw(context, o3Var, new xq1().b(o8Var, o3Var)).a());
    }

    public hr0(Context context, o8 adResponse, wr contentCloseListener, e1 eventController, int i, v1 adActivityListener, o3 adConfiguration, ir0 layoutDesignsProvider, aw debugEventsReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(layoutDesignsProvider, "layoutDesignsProvider");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        this.f9128a = adResponse;
        this.b = contentCloseListener;
        this.c = eventController;
        this.d = i;
        this.e = adActivityListener;
        this.f = adConfiguration;
        this.g = layoutDesignsProvider;
        this.h = debugEventsReporter;
    }

    public final ArrayList a(Context context, ExtendedNativeAdView container, m61 nativeAdPrivate, pt adEventListener, k3 adCompleteListener, ds1 closeVerificationController, tl1 progressIncrementer, l6 divKitActionHandlerDelegate, ArrayList arrayList, y20 y20Var, g6 adPod, yp closeTimerProgressIncrementer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        Intrinsics.checkNotNullParameter(progressIncrementer, "progressIncrementer");
        Intrinsics.checkNotNullParameter(divKitActionHandlerDelegate, "divKitActionHandlerDelegate");
        Intrinsics.checkNotNullParameter(adPod, "adPod");
        Intrinsics.checkNotNullParameter(closeTimerProgressIncrementer, "closeTimerProgressIncrementer");
        int i = 0;
        if (nativeAdPrivate instanceof uz1) {
            uz1 uz1Var = (uz1) nativeAdPrivate;
            List<m6> listB = adPod.b();
            ArrayList arrayListD = uz1Var.d();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayListD.size();
            while (i < size) {
                m6 m6Var = (m6) CollectionsKt.getOrNull(listB, i);
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = arrayListD;
                int i2 = size;
                int i3 = i;
                List<m6> list = listB;
                arrayList3.add(a(context, container, (m61) arrayList4.get(i3), new d32(adEventListener), adCompleteListener, closeVerificationController, new y42(progressIncrementer, new h6(listB), new k6(m6Var != null ? m6Var.a() : 0L), new i6(adPod, i), closeTimerProgressIncrementer), divKitActionHandlerDelegate, arrayList != null ? (y20) CollectionsKt.getOrNull(arrayList, i3) : null, m6Var));
                i = i3 + 1;
                arrayListD = arrayList4;
                listB = list;
                arrayList2 = arrayList3;
                size = i2;
            }
            ArrayList arrayList5 = arrayList2;
            List<m6> list2 = listB;
            m6 m6Var2 = (m6) CollectionsKt.getOrNull(list2, arrayListD.size());
            gr0<ExtendedNativeAdView> gr0VarA = y20Var != null ? a(context, container, uz1Var, adEventListener, adCompleteListener, closeVerificationController, new y42(progressIncrementer, new h6(list2), new k6(m6Var2 != null ? m6Var2.a() : 0L), new sf1(), closeTimerProgressIncrementer), divKitActionHandlerDelegate, y20Var, m6Var2) : null;
            if (gr0VarA != null) {
                arrayList5.add(gr0VarA);
            }
            return arrayList5;
        }
        List<m6> listB2 = adPod.b();
        ArrayList arrayList6 = new ArrayList();
        h6 h6Var = new h6(listB2);
        m6 m6Var3 = (m6) CollectionsKt.firstOrNull((List) listB2);
        arrayList6.add(a(context, container, nativeAdPrivate, adEventListener, adCompleteListener, closeVerificationController, new y42(progressIncrementer, h6Var, new k6(m6Var3 != null ? m6Var3.a() : 0L), new i6(adPod, 0), closeTimerProgressIncrementer), divKitActionHandlerDelegate, arrayList != null ? (y20) CollectionsKt.firstOrNull((List) arrayList) : null, (m6) CollectionsKt.firstOrNull((List) listB2)));
        m6 m6Var4 = (m6) CollectionsKt.getOrNull(listB2, 1);
        gr0<ExtendedNativeAdView> gr0VarA2 = y20Var != null ? a(context, container, nativeAdPrivate, adEventListener, adCompleteListener, closeVerificationController, new y42(progressIncrementer, new h6(listB2), new k6(m6Var4 != null ? m6Var4.a() : 0L), new sf1()), divKitActionHandlerDelegate, y20Var, m6Var4) : null;
        if (gr0VarA2 != null) {
            arrayList6.add(gr0VarA2);
        }
        return arrayList6;
    }
}
