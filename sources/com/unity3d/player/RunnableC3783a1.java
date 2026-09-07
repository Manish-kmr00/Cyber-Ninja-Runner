package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class RunnableC3783a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8265a;
    final /* synthetic */ UnityPlayerForActivityOrService b;

    RunnableC3783a1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, String str) {
        this.b = unityPlayerForActivityOrService;
        this.f8265a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        U u = this.b.mSoftInput;
        if (u == null || (str = this.f8265a) == null || (editText = u.c) == null) {
            return;
        }
        editText.setText(str);
        u.c.setSelection(str.length());
    }
}
