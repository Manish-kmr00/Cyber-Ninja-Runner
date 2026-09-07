package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Da implements Cc {
    @Override // com.inmobi.media.Cc
    public void a() {
    }

    public void a(Ba renderView, String trackerName, Map macros) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
    }

    public abstract void a(Yb yb);

    public void a(boolean z) {
    }

    public void b(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void c(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void d() {
    }

    public void d(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullExpressionValue("Da", "TAG");
    }

    public void e(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullExpressionValue("Da", "TAG");
    }

    public void f(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void g(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void h(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void i(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void a(HashMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public void b(HashMap rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
    }

    public void c() {
        Intrinsics.checkNotNullExpressionValue("Da", "TAG");
    }

    public void a(EnumC3479n1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
    }

    public void a(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void a(Ba renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void a(Ba renderView, short s) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public void a(String eventType, Map kv) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
    }
}
