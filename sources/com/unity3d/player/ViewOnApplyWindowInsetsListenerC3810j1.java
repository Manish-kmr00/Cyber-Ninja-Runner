package com.unity3d.player;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: com.unity3d.player.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class ViewOnApplyWindowInsetsListenerC3810j1 implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8283a;

    ViewOnApplyWindowInsetsListenerC3810j1(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8283a = unityPlayerForActivityOrService;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f8283a.invokeOnMainThread((Runnable) new W0(this, windowInsets));
        return windowInsets;
    }
}
