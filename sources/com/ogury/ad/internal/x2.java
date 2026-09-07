package com.ogury.ad.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class x2 implements c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f7439a;
    public final z9 b;
    public final y9 c;
    public final n9 d;
    public final i1 e;
    public d2 f;
    public final o9 g;

    public x2(ViewGroup adContainer) {
        z9 webViewHelper = new z9();
        y9 overlapCalculator = new y9(webViewHelper);
        n9 viewHierarchy = new n9();
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(webViewHelper, "webViewHelper");
        Intrinsics.checkNotNullParameter(overlapCalculator, "overlapCalculator");
        Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
        this.f7439a = adContainer;
        this.b = webViewHelper;
        this.c = overlapCalculator;
        this.d = viewHierarchy;
        this.e = new i1();
        this.g = new o9(adContainer);
    }

    @Override // com.ogury.ad.internal.c2
    public final void a() {
        this.f = null;
        this.e.a();
    }

    @Override // com.ogury.ad.internal.c2
    public final void b() {
        this.e.a();
        int childCount = this.f7439a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View childAt = this.f7439a.getChildAt(i);
            if ((childAt instanceof d5) && ((d5) childAt).getContainsMraid()) {
                Function0 callable = new Function0() { // from class: com.ogury.ad.internal.x2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return x2.a(this.f$0, childAt);
                    }
                };
                Intrinsics.checkNotNullParameter(callable, "callable");
                v8 disposable = new v8(callable, 0).b(new Function1() { // from class: com.ogury.ad.internal.x2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return x2.a(this.f$0, childAt, (e) obj);
                    }
                });
                i1 i1Var = this.e;
                i1Var.getClass();
                Intrinsics.checkNotNullParameter(disposable, "disposable");
                i1Var.f7318a.add(disposable);
            }
        }
    }

    @Override // com.ogury.ad.internal.c2
    public final void a(d2 d2Var) {
        this.f = d2Var;
    }

    public static final e a(x2 x2Var, View view) {
        d5 webView = (d5) view;
        x2Var.getClass();
        try {
            e eVar = new e();
            View rootView = x2Var.f7439a.getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup root = (ViewGroup) rootView;
            x2Var.b.getClass();
            Rect rectB = z9.b(webView);
            z9 z9Var = x2Var.b;
            ViewGroup viewGroup = x2Var.f7439a;
            z9Var.getClass();
            Rect screenRect = z9.c(viewGroup);
            rectB.bottom = rectB.top + webView.getMeasuredHeight();
            rectB.right = rectB.left + webView.getMeasuredWidth();
            if (!rectB.intersect(screenRect)) {
                return eVar;
            }
            x2Var.d.getClass();
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(webView, "webView");
            ArrayList arrayList = new ArrayList();
            n9.a(root, arrayList);
            ArrayList<Rect> arrayListA = x2Var.c.a(arrayList.subList(arrayList.indexOf(webView) + 1, arrayList.size()), rectB);
            x2Var.c.getClass();
            int iA = y9.a(rectB, arrayListA);
            int measuredWidth = webView.getMeasuredWidth() * webView.getMeasuredHeight();
            Intrinsics.checkNotNullParameter(rectB, "<this>");
            int iHeight = measuredWidth - (rectB.height() * rectB.width());
            if (iHeight < 0) {
                iHeight = 0;
            }
            float f = measuredWidth;
            if (measuredWidth != 0) {
                eVar.c = 100.0f - (((iA + iHeight) * 100.0f) / f);
            } else {
                eVar.c = 0.0f;
            }
            if (eVar.c == 0.0f) {
                return eVar;
            }
            Intrinsics.checkNotNullParameter(arrayListA, "<this>");
            Intrinsics.checkNotNullParameter(screenRect, "containerRect");
            for (Rect rect : arrayListA) {
                Intrinsics.checkNotNullParameter(rect, "<this>");
                Intrinsics.checkNotNullParameter(screenRect, "screenRect");
                rect.offset(-screenRect.left, -screenRect.top);
            }
            Intrinsics.checkNotNullParameter(rectB, "<this>");
            Intrinsics.checkNotNullParameter(screenRect, "screenRect");
            rectB.offset(-screenRect.left, -screenRect.top);
            Intrinsics.checkNotNullParameter(arrayListA, "<set-?>");
            eVar.b = arrayListA;
            eVar.f7286a = rectB;
            return eVar;
        } catch (Throwable unused) {
            u3.f7411a.getClass();
            return new e();
        }
    }

    public static final Unit a(x2 x2Var, View view, e adExposure) {
        Intrinsics.checkNotNullParameter(adExposure, "it");
        d5 d5Var = (d5) view;
        x2Var.getClass();
        if (d5Var.k && !d5Var.l) {
            o9 o9Var = x2Var.g;
            o9Var.getClass();
            Intrinsics.checkNotNullParameter(adExposure, "adExposure");
            ViewParent parent = o9Var.f7378a.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null && viewGroup.getVisibility() != 0) {
                adExposure.c = 0.0f;
            }
            d5Var.getMraidCommandExecutor().a(adExposure);
            d2 d2Var = x2Var.f;
            if (d2Var != null) {
                d2Var.a(adExposure.c);
            }
        }
        return Unit.INSTANCE;
    }
}
