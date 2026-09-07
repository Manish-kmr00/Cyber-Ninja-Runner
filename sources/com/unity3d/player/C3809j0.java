package com.unity3d.player;

import android.content.res.Configuration;

/* JADX INFO: renamed from: com.unity3d.player.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3809j0 extends V0 {
    final /* synthetic */ Configuration b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3809j0(UnityPlayer unityPlayer, Configuration configuration) {
        super(unityPlayer);
        this.b = configuration;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        UnityAccessibilityDelegate.sendFontScaleChangedNotification(this.b.fontScale);
    }
}
