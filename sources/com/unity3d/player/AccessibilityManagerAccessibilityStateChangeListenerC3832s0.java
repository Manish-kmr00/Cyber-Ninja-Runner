package com.unity3d.player;

import android.view.accessibility.AccessibilityManager;
import java.util.Objects;

/* JADX INFO: renamed from: com.unity3d.player.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class AccessibilityManagerAccessibilityStateChangeListenerC3832s0 implements AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityAccessibilityDelegate f8302a;

    AccessibilityManagerAccessibilityStateChangeListenerC3832s0(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f8302a = unityAccessibilityDelegate;
        unityAccessibilityDelegate.c.addAccessibilityStateChangeListener(this);
        unityAccessibilityDelegate.c.addTouchExplorationStateChangeListener(this);
        if (unityAccessibilityDelegate.c.isEnabled()) {
            onAccessibilityStateChanged(true);
        }
    }

    protected void cleanup() {
        this.f8302a.c.removeAccessibilityStateChangeListener(this);
        this.f8302a.c.removeTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        if (!z) {
            this.f8302a.b.setAccessibilityDelegate(null);
            this.f8302a.b.setWillNotDraw(true);
            onTouchExplorationStateChanged(false);
        } else {
            UnityAccessibilityDelegate unityAccessibilityDelegate = this.f8302a;
            unityAccessibilityDelegate.b.setAccessibilityDelegate(unityAccessibilityDelegate);
            this.f8302a.b.setWillNotDraw(false);
            onTouchExplorationStateChanged(this.f8302a.c.isTouchExplorationEnabled());
        }
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        boolean z2 = this.f8302a.c.isEnabled() && z;
        UnityAccessibilityDelegate unityAccessibilityDelegate = this.f8302a;
        if (z2) {
            unityAccessibilityDelegate.b.setOnHoverListener(new ViewOnHoverListenerC3838v0(unityAccessibilityDelegate));
        } else {
            unityAccessibilityDelegate.b.setOnHoverListener(null);
        }
        UnityAccessibilityDelegate unityAccessibilityDelegate2 = this.f8302a;
        if (unityAccessibilityDelegate2.i == z2) {
            return;
        }
        unityAccessibilityDelegate2.i = z2;
        UnityPlayer unityPlayer = unityAccessibilityDelegate2.f8252a;
        Objects.requireNonNull(unityPlayer);
        this.f8302a.f8252a.invokeOnMainThread((Runnable) new C3830r0(unityPlayer, z2));
    }
}
