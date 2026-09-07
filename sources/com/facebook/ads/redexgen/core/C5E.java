package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C5E {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.5C] */
    public static C5C A00(final C5D c5d) {
        return new AccessibilityNodeProvider() { // from class: com.facebook.ads.redexgen.X.5C
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c5d.A56(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c5d.A6O(str, i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c5d.A6P(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final boolean performAction(int i, int i2, Bundle bundle) {
                return c5d.AG3(i, i2, bundle);
            }
        };
    }
}
