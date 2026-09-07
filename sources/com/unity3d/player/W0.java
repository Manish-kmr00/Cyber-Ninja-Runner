package com.unity3d.player;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes8.dex */
final class W0 extends V0 {
    final /* synthetic */ WindowInsets b;
    final /* synthetic */ ViewOnApplyWindowInsetsListenerC3810j1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    W0(ViewOnApplyWindowInsetsListenerC3810j1 viewOnApplyWindowInsetsListenerC3810j1, WindowInsets windowInsets) {
        super(viewOnApplyWindowInsetsListenerC3810j1.f8283a);
        this.c = viewOnApplyWindowInsetsListenerC3810j1;
        this.b = windowInsets;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.c.f8283a.nativeOnApplyWindowInsets(this.b);
    }
}
