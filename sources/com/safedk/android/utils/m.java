package com.safedk.android.utils;

import android.widget.Toast;
import com.safedk.android.SafeDK;

/* JADX INFO: loaded from: classes10.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f8165a;
    String b;

    public m(String str) {
        this(str, null);
    }

    public m(String str, String str2) {
        this.f8165a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(SafeDK.getInstance().m(), "SDK '" + this.f8165a + "' " + (this.b == null ? "" : "Toggle '" + this.b + "'") + " blocked by SafeDK", 0).show();
    }
}
