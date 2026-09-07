package com.json;

import android.app.Activity;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: classes10.dex */
public class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MutableContextWrapper f3645a;

    public Activity a() {
        return (Activity) this.f3645a.getBaseContext();
    }

    public synchronized void a(Activity activity) {
        if (this.f3645a == null) {
            this.f3645a = new MutableContextWrapper(activity);
        }
        this.f3645a.setBaseContext(activity);
    }

    public synchronized void b() {
        this.f3645a = null;
    }
}
