package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap f11740a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC4376q enumC4376q) {
        if (activity != null && this.f11740a.get(activity) == enumC4376q) {
            return false;
        }
        if (activity == null) {
            return true;
        }
        this.f11740a.put(activity, enumC4376q);
        return true;
    }
}
