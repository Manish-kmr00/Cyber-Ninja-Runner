package com.unity3d.player;

import android.util.Log;

/* JADX INFO: loaded from: classes12.dex */
abstract class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f8204a;

    protected static void Log(int i, String str) {
        if (f8204a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
