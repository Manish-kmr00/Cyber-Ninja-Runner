package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ae0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8397a;
    private final ViewGroup b;
    private final wr c;
    private final o3 d;
    private final pt e;
    private final hr0 f;
    private final l3 g;

    public final vd0 a(Context context, m61 nativeAdPrivate, wr contentCloseListener) {
        ArrayList arrayList;
        y20 y20Var;
        y20 y20VarPrevious;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        ds1 ds1Var = new ds1(context, new w20(nativeAdPrivate, contentCloseListener, this.d.q().c(), new e30(), new k30()), contentCloseListener);
        y1 y1VarA = this.g.a(this.f8397a, ds1Var);
        List<y20> listC = nativeAdPrivate.c();
        if (listC != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listC) {
                if (Intrinsics.areEqual(((y20) obj).e(), e10.c.a())) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        List<y20> listC2 = nativeAdPrivate.c();
        if (listC2 != null) {
            ListIterator<y20> listIterator = listC2.listIterator(listC2.size());
            do {
                if (!listIterator.hasPrevious()) {
                    y20VarPrevious = null;
                    break;
                }
                y20VarPrevious = listIterator.previous();
            } while (!Intrinsics.areEqual(y20VarPrevious.e(), e10.d.a()));
            y20Var = y20VarPrevious;
        } else {
            y20Var = null;
        }
        u61 u61VarA = nativeAdPrivate.a();
        g6 g6VarA = u61VarA != null ? u61VarA.a() : null;
        if (Intrinsics.areEqual(this.f8397a.x(), b10.AD_POD.a()) && g6VarA != null && ((nativeAdPrivate instanceof uz1) || y20Var != null)) {
            pt ptVar = this.e;
            return new j6(context, nativeAdPrivate, ptVar, ds1Var, arrayList, y20Var, this.b, y1VarA, contentCloseListener, this.f, g6VarA, new ExtendedNativeAdView(context), new x1(nativeAdPrivate, contentCloseListener, ptVar), new tl1(), new yp(), new sr1(new h52()));
        }
        return new zd0(this.f.a(context, this.b, nativeAdPrivate, this.e, new rm1(y1VarA), ds1Var, new y42(new tl1(), new oy1(this.f8397a), new sy1(this.f8397a), new ry1(), new yp()), new ty1(), arrayList != null ? (y20) CollectionsKt.firstOrNull((List) arrayList) : null, null), contentCloseListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ae0(Context context, o8 o8Var, RelativeLayout relativeLayout, wr wrVar, e1 e1Var, int i, v1 v1Var, o3 o3Var) {
        this(context, o8Var, relativeLayout, wrVar, e1Var, v1Var, o3Var, new q81(v1Var, new sd0(iw1.a.a().a(context))), new hr0(context, o8Var, wrVar, e1Var, i, v1Var, o3Var), new l3(v1Var));
        int i2 = iw1.l;
    }

    public ae0(Context context, o8 adResponse, RelativeLayout container, wr contentCloseListener, e1 eventController, v1 adActivityListener, o3 adConfiguration, pt adEventListener, hr0 layoutDesignsControllerCreator, l3 adCompleteListenerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(layoutDesignsControllerCreator, "layoutDesignsControllerCreator");
        Intrinsics.checkNotNullParameter(adCompleteListenerCreator, "adCompleteListenerCreator");
        this.f8397a = adResponse;
        this.b = container;
        this.c = contentCloseListener;
        this.d = adConfiguration;
        this.e = adEventListener;
        this.f = layoutDesignsControllerCreator;
        this.g = adCompleteListenerCreator;
    }
}
