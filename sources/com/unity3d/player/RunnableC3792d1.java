package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class RunnableC3792d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f8273a;
    final /* synthetic */ int b;
    final /* synthetic */ UnityPlayerForActivityOrService c;

    RunnableC3792d1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, int i2) {
        this.c = unityPlayerForActivityOrService;
        this.f8273a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        U u = this.c.mSoftInput;
        if (u != null) {
            int i2 = this.f8273a;
            int i3 = this.b;
            EditText editText = u.c;
            if (editText == null || editText.getText().length() < (i = i3 + i2)) {
                return;
            }
            u.c.setSelection(i2, i);
        }
    }
}
