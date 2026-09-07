package com.ogury.ad.internal;

import android.graphics.Rect;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f7286a;
    public List<Rect> b;
    public float c;

    public e() {
        List<Rect> listEmptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(listEmptyList, "emptyList(...)");
        this.b = listEmptyList;
    }

    public final float a() {
        return this.c;
    }

    public final List<Rect> b() {
        return this.b;
    }

    public final Rect c() {
        return this.f7286a;
    }
}
