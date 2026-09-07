package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f9612a;
    private pt b;
    private final ie2 c;
    private final f90 d;
    private lj e;
    private final ViewTreeObserver.OnPreDrawListener f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a() {
        return true;
    }

    public final void a(Context context, o8 response, uz1 nativeAdPrivate, List preloadedDivKitDesigns) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(preloadedDivKitDesigns, "preloadedDivKitDesigns");
        lj ljVarA = this.d.a(context, response, nativeAdPrivate, preloadedDivKitDesigns, this.f9612a, this.b, this.f, this.c);
        this.e = ljVarA;
        ljVarA.a(null, new l90());
    }

    public /* synthetic */ m90(o3 o3Var, ViewGroup viewGroup, pt ptVar, ie2 ie2Var) {
        this(o3Var, viewGroup, ptVar, ie2Var, new f90(o3Var));
    }

    public m90(o3 adConfiguration, ViewGroup view, pt adEventListener, ie2 videoEventController, f90 contentControllerCreator) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(contentControllerCreator, "contentControllerCreator");
        this.f9612a = view;
        this.b = adEventListener;
        this.c = videoEventController;
        this.d = contentControllerCreator;
        this.f = new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.mobile.ads.impl.m90$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return m90.a();
            }
        };
    }

    public final void b() {
        lj ljVar = this.e;
        if (ljVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentController");
            ljVar = null;
        }
        ljVar.a();
    }
}
