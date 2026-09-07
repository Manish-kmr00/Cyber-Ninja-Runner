package com.unity3d.player;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.Objects;

/* JADX INFO: renamed from: com.unity3d.player.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
final class C3828q0 extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityAccessibilityDelegate f8297a;

    C3828q0(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f8297a = unityAccessibilityDelegate;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        if (i != -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            if (UnityAccessibilityDelegate.populateNodeInfo(accessibilityNodeInfoObtain, i, this.f8297a.b)) {
                return accessibilityNodeInfoObtain;
            }
            return null;
        }
        AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain(this.f8297a.b);
        Object parent = this.f8297a.b.getParent();
        if (parent instanceof View) {
            accessibilityNodeInfoObtain2.setParent((View) parent);
        }
        int[] rootNodeIds = UnityAccessibilityDelegate.getRootNodeIds();
        if (rootNodeIds != null) {
            for (int i2 : rootNodeIds) {
                accessibilityNodeInfoObtain2.addChild(this.f8297a.b, i2);
            }
        }
        return accessibilityNodeInfoObtain2;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        UnityAccessibilityDelegate unityAccessibilityDelegate;
        int i3;
        if (i2 == 64) {
            unityAccessibilityDelegate = this.f8297a;
            i3 = 32768;
        } else {
            if (i2 != 128) {
                if (i2 == 16) {
                    if (!UnityAccessibilityDelegate.isNodeSelectable(i)) {
                        return false;
                    }
                    UnityPlayer unityPlayer = this.f8297a.f8252a;
                    Objects.requireNonNull(unityPlayer);
                    this.f8297a.f8252a.invokeOnMainThread((Runnable) new C3821n0(this, unityPlayer, i));
                    return true;
                }
                if (i2 == 4096 || i2 == 8192) {
                    UnityPlayer unityPlayer2 = this.f8297a.f8252a;
                    Objects.requireNonNull(unityPlayer2);
                    this.f8297a.f8252a.invokeOnMainThread((Runnable) new C3824o0(this, unityPlayer2, i2, i));
                    return true;
                }
                if (i2 != 1048576 || !UnityAccessibilityDelegate.isNodeDismissable(i)) {
                    return false;
                }
                UnityPlayer unityPlayer3 = this.f8297a.f8252a;
                Objects.requireNonNull(unityPlayer3);
                this.f8297a.f8252a.invokeOnMainThread((Runnable) new C3826p0(unityPlayer3, i));
                return true;
            }
            unityAccessibilityDelegate = this.f8297a;
            i3 = 65536;
        }
        return unityAccessibilityDelegate.sendEventForVirtualViewId(i, i3);
    }
}
