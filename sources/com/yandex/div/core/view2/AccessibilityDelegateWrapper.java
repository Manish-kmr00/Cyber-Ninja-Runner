package com.yandex.div.core.view2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityDelegateWrapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012<\b\u0002\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004\u0012<\b\u0002\u0010\f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001d\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010 \u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\"H\u0016J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016RN\u0010\f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RN\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/yandex/div/core/view2/AccessibilityDelegateWrapper;", "Landroidx/core/view/AccessibilityDelegateCompat;", "originalDelegate", "initializeAccessibilityNodeInfo", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "actionsAccessibilityNodeInfo", "(Landroidx/core/view/AccessibilityDelegateCompat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getActionsAccessibilityNodeInfo", "()Lkotlin/jvm/functions/Function2;", "setActionsAccessibilityNodeInfo", "(Lkotlin/jvm/functions/Function2;)V", "getInitializeAccessibilityNodeInfo", "setInitializeAccessibilityNodeInfo", "dispatchPopulateAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "onInitializeAccessibilityEvent", "onInitializeAccessibilityNodeInfo", "onPopulateAccessibilityEvent", "onRequestSendAccessibilityEvent", "Landroid/view/ViewGroup;", "child", "performAccessibilityAction", "action", "", "args", "Landroid/os/Bundle;", "sendAccessibilityEvent", "eventType", "sendAccessibilityEventUnchecked", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AccessibilityDelegateWrapper extends AccessibilityDelegateCompat {
    private Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> actionsAccessibilityNodeInfo;
    private Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> initializeAccessibilityNodeInfo;
    private final AccessibilityDelegateCompat originalDelegate;

    public final Function2<View, AccessibilityNodeInfoCompat, Unit> getInitializeAccessibilityNodeInfo() {
        return this.initializeAccessibilityNodeInfo;
    }

    public final void setInitializeAccessibilityNodeInfo(Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.initializeAccessibilityNodeInfo = function2;
    }

    public /* synthetic */ AccessibilityDelegateWrapper(AccessibilityDelegateCompat accessibilityDelegateCompat, AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(accessibilityDelegateCompat, (i & 2) != 0 ? new Function2<View, AccessibilityNodeInfoCompat, Unit>() { // from class: com.yandex.div.core.view2.AccessibilityDelegateWrapper.1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                invoke2(view, accessibilityNodeInfoCompat);
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 4) != 0 ? new Function2<View, AccessibilityNodeInfoCompat, Unit>() { // from class: com.yandex.div.core.view2.AccessibilityDelegateWrapper.2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                invoke2(view, accessibilityNodeInfoCompat);
                return Unit.INSTANCE;
            }
        } : anonymousClass2);
    }

    public final Function2<View, AccessibilityNodeInfoCompat, Unit> getActionsAccessibilityNodeInfo() {
        return this.actionsAccessibilityNodeInfo;
    }

    public final void setActionsAccessibilityNodeInfo(Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.actionsAccessibilityNodeInfo = function2;
    }

    public AccessibilityDelegateWrapper(AccessibilityDelegateCompat accessibilityDelegateCompat, Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> initializeAccessibilityNodeInfo, Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> actionsAccessibilityNodeInfo) {
        Intrinsics.checkNotNullParameter(initializeAccessibilityNodeInfo, "initializeAccessibilityNodeInfo");
        Intrinsics.checkNotNullParameter(actionsAccessibilityNodeInfo, "actionsAccessibilityNodeInfo");
        this.originalDelegate = accessibilityDelegateCompat;
        this.initializeAccessibilityNodeInfo = initializeAccessibilityNodeInfo;
        this.actionsAccessibilityNodeInfo = actionsAccessibilityNodeInfo;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void sendAccessibilityEvent(View host, int eventType) {
        Unit unit;
        Intrinsics.checkNotNullParameter(host, "host");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.sendAccessibilityEvent(host, eventType);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.sendAccessibilityEvent(host, eventType);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        Unit unit;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.sendAccessibilityEventUnchecked(host, event);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.sendAccessibilityEventUnchecked(host, event);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(host, event) : super.dispatchPopulateAccessibilityEvent(host, event);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        Unit unit;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onPopulateAccessibilityEvent(host, event);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onPopulateAccessibilityEvent(host, event);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        Unit unit;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onInitializeAccessibilityEvent(host, event);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onInitializeAccessibilityEvent(host, event);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        Unit unit;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(host, info);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onInitializeAccessibilityNodeInfo(host, info);
        }
        this.initializeAccessibilityNodeInfo.invoke(host, info);
        this.actionsAccessibilityNodeInfo.invoke(host, info);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.onRequestSendAccessibilityEvent(host, child, event) : super.onRequestSendAccessibilityEvent(host, child, event);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        AccessibilityNodeProviderCompat accessibilityNodeProvider;
        Intrinsics.checkNotNullParameter(host, "host");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        return (accessibilityDelegateCompat == null || (accessibilityNodeProvider = accessibilityDelegateCompat.getAccessibilityNodeProvider(host)) == null) ? super.getAccessibilityNodeProvider(host) : accessibilityNodeProvider;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        Intrinsics.checkNotNullParameter(host, "host");
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.originalDelegate;
        return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.performAccessibilityAction(host, action, args) : super.performAccessibilityAction(host, action, args);
    }
}
