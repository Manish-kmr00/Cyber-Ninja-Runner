package com.unity3d.player;

import android.content.res.Configuration;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.CaptioningManager;
import java.util.Objects;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes11.dex */
class UnityAccessibilityDelegate extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UnityPlayer f8252a;
    private final SurfaceView b;
    private AccessibilityManager c;
    private AccessibilityManagerAccessibilityStateChangeListenerC3832s0 d;
    private CaptioningManager e;
    private C3836u0 f;
    private int g = -1;
    private int h = -1;
    private boolean i = false;
    private float j = 1.0f;
    private AccessibilityNodeProvider k = new C3828q0(this);

    UnityAccessibilityDelegate(UnityPlayer unityPlayer) {
        this.f8252a = unityPlayer;
        this.b = unityPlayer.getSurfaceView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int[] getRootNodeIds();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int hitTest(float f, float f2);

    protected static UnityAccessibilityDelegate init(UnityPlayer unityPlayer) {
        UnityAccessibilityDelegate unityAccessibilityDelegate = new UnityAccessibilityDelegate(unityPlayer);
        unityAccessibilityDelegate.c = (AccessibilityManager) unityAccessibilityDelegate.f8252a.getContext().getSystemService("accessibility");
        CaptioningManager captioningManager = (CaptioningManager) unityAccessibilityDelegate.f8252a.getContext().getSystemService("captioning");
        unityAccessibilityDelegate.e = captioningManager;
        if (unityAccessibilityDelegate.c != null || captioningManager != null) {
            Semaphore semaphore = new Semaphore(0);
            unityAccessibilityDelegate.f8252a.runOnUiThread(new RunnableC3806i0(unityAccessibilityDelegate, semaphore));
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
            }
        }
        unityAccessibilityDelegate.j = unityAccessibilityDelegate.f8252a.getContext().getResources().getConfiguration().fontScale;
        unityAccessibilityDelegate.f8252a.setAccessibilityDelegate(unityAccessibilityDelegate);
        return unityAccessibilityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isNodeDismissable(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isNodeSelectable(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onNodeDecremented(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeDismissed(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onNodeFocusChanged(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onNodeIncremented(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeSelected(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean populateNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo, int i, View view);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void sendClosedCaptioningChangedNotification(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void sendFontScaleChangedNotification(float f);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void sendScreenReaderStatusChangedNotification(boolean z);

    public final void a(Configuration configuration) {
        float f = configuration.fontScale;
        if (f != this.j) {
            this.j = f;
            UnityPlayer unityPlayer = this.f8252a;
            Objects.requireNonNull(unityPlayer);
            this.f8252a.invokeOnMainThread((Runnable) new C3809j0(unityPlayer, configuration));
        }
    }

    protected void cleanup() {
        AccessibilityManagerAccessibilityStateChangeListenerC3832s0 accessibilityManagerAccessibilityStateChangeListenerC3832s0 = this.d;
        if (accessibilityManagerAccessibilityStateChangeListenerC3832s0 != null) {
            accessibilityManagerAccessibilityStateChangeListenerC3832s0.cleanup();
        }
        C3836u0 c3836u0 = this.f;
        if (c3836u0 != null) {
            c3836u0.cleanup();
        }
        this.f8252a.setAccessibilityDelegate(null);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return this.k;
    }

    protected int getFocusedNodeId() {
        return this.g;
    }

    protected boolean sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ViewGroup viewGroup;
        if (accessibilityEvent == null || (viewGroup = (ViewGroup) this.b.getParent()) == null) {
            return false;
        }
        return viewGroup.requestSendAccessibilityEvent(this.b, accessibilityEvent);
    }

    protected boolean sendAnnouncementForVirtualViewId(int i, String str) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setSource(this.b, i);
        accessibilityEventObtain.getText().add(str);
        return sendAccessibilityEvent(accessibilityEventObtain);
    }

    protected boolean sendEventForVirtualViewId(int i, int i2) {
        if (!this.c.isEnabled()) {
            return false;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setSource(this.b, i);
        if (i2 == 2048) {
            accessibilityEventObtain.setContentChangeTypes(1);
        }
        if (i2 == 32768) {
            if (this.g == i) {
                return false;
            }
            this.g = i;
            this.b.invalidate();
            UnityPlayer unityPlayer = this.f8252a;
            Objects.requireNonNull(unityPlayer);
            this.f8252a.invokeOnMainThread((Runnable) new C3815l0(unityPlayer, i));
        }
        if (i2 == 65536) {
            if (this.g == i) {
                this.g = -1;
            }
            this.b.invalidate();
            UnityPlayer unityPlayer2 = this.f8252a;
            Objects.requireNonNull(unityPlayer2);
            this.f8252a.invokeOnMainThread((Runnable) new C3818m0(unityPlayer2, i));
        }
        return sendAccessibilityEvent(accessibilityEventObtain);
    }

    protected boolean sendEventForVirtualViewIdFromNative(int i, int i2) {
        this.f8252a.runOnUiThread(new RunnableC3812k0(this, i, i2));
        return true;
    }
}
