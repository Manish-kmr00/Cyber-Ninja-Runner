package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y71<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a81 f10709a;

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        a81 a81Var = this.f10709a;
        if (a81Var != null) {
            a81Var.d();
        }
    }

    public /* synthetic */ y71(j91 j91Var, ie2 ie2Var) {
        this(j91Var, ie2Var, new z71(ie2Var, j91Var));
    }

    public y71(j91 nativeMediaContent, ie2 videoEventController, z71 contentCompleteControllerFactory) {
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(contentCompleteControllerFactory, "contentCompleteControllerFactory");
        this.f10709a = contentCompleteControllerFactory.a();
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        a81 a81Var = this.f10709a;
        if (a81Var != null) {
            a81Var.c();
        }
    }
}
