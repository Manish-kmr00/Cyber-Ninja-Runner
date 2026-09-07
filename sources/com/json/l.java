package com.json;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class l implements sv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f3847a;

    public l(Activity activity) {
        this.f3847a = new WeakReference<>(activity);
    }

    @Override // com.json.sv
    public void a() {
        Activity activity = this.f3847a.get();
        if (activity == null) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        Window window = activity.getWindow();
        if (i < 30) {
            window.setFlags(1024, 1024);
            return;
        }
        WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsets.Type.statusBars());
        }
    }
}
