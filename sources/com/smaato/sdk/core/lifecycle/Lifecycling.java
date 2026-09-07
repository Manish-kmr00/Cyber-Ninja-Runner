package com.smaato.sdk.core.lifecycle;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes12.dex */
public abstract class Lifecycling {
    public static Lifecycle of(View view) {
        return new ViewLifecycle(view);
    }

    public static Lifecycle of(Activity activity) {
        return new ActivityLifecycle(activity);
    }

    public static Lifecycle wrap(LifecycleOwner lifecycleOwner) {
        return new AndroidXLifecycle(lifecycleOwner);
    }
}
