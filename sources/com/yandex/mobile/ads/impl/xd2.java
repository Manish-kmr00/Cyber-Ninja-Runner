package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xd2 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rr0 f10646a;
    private final ap b;
    private final ru c;

    public xd2(rr0 link, ap clickListenerCreator, ru ruVar) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(clickListenerCreator, "clickListenerCreator");
        this.f10646a = link;
        this.b = clickListenerCreator;
        this.c = ruVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b.a(this.c != null ? new rr0(this.f10646a.a(), this.f10646a.c(), this.f10646a.d(), this.c.b(), this.f10646a.b()) : this.f10646a).onClick(view);
    }
}
