package com.unity3d.player;

import android.view.accessibility.CaptioningManager;
import java.util.Objects;

/* JADX INFO: renamed from: com.unity3d.player.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C3836u0 extends CaptioningManager.CaptioningChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityAccessibilityDelegate f8307a;

    C3836u0(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f8307a = unityAccessibilityDelegate;
        unityAccessibilityDelegate.e.addCaptioningChangeListener(this);
        onEnabledChanged(unityAccessibilityDelegate.e.isEnabled());
    }

    protected void cleanup() {
        this.f8307a.e.removeCaptioningChangeListener(this);
    }

    @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
    public final void onEnabledChanged(boolean z) {
        UnityPlayer unityPlayer = this.f8307a.f8252a;
        Objects.requireNonNull(unityPlayer);
        this.f8307a.f8252a.invokeOnMainThread((Runnable) new C3834t0(unityPlayer, z));
    }
}
