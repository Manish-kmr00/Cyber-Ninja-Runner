package com.yandex.mobile.ads.impl;

import android.location.Location;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ys0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10766a;

    public ys0(Object taskObject) {
        Intrinsics.checkNotNullParameter(taskObject, "taskObject");
        this.f10766a = taskObject;
    }

    public final boolean b() {
        Object objA = co1.a.a(this.f10766a, "isComplete", new Object[0]);
        Boolean bool = objA instanceof Boolean ? (Boolean) objA : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final Location a() {
        Object objA = co1.a.a(this.f10766a, "getResult", new Object[0]);
        if (objA instanceof Location) {
            return (Location) objA;
        }
        return null;
    }
}
