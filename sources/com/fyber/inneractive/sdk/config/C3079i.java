package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3079i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1709a;
    public WeakReference b;

    public C3079i(Context context, Context context2) {
        C3078h c3078h = new C3078h(this);
        this.f1709a = context2;
        if (context instanceof Activity) {
            this.b = new WeakReference(context);
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(c3078h);
        }
    }

    public final Context a() {
        Context context = (Context) AbstractC3256u.a(this.b);
        return context != null ? context : this.f1709a;
    }
}
