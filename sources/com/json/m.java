package com.json;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class m implements sv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f3879a;

    public m(Activity activity) {
        this.f3879a = new WeakReference<>(activity);
    }

    @Override // com.json.sv
    public void a() {
        Activity activity = this.f3879a.get();
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }
}
