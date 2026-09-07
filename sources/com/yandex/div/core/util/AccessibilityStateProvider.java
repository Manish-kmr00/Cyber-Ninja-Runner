package com.yandex.div.core.util;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityStateProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/util/AccessibilityStateProvider;", "", "a11yConfigurationEnabled", "", "(Z)V", "getA11yConfigurationEnabled", "()Z", "isAccessibilityEnabled", "context", "Landroid/content/Context;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class AccessibilityStateProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Boolean touchModeEnabled;
    private final boolean a11yConfigurationEnabled;

    @Inject
    public AccessibilityStateProvider(@ExperimentFlag(experiment = Experiment.ACCESSIBILITY_ENABLED) boolean z) {
        this.a11yConfigurationEnabled = z;
    }

    public final boolean getA11yConfigurationEnabled() {
        return this.a11yConfigurationEnabled;
    }

    public final boolean isAccessibilityEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.a11yConfigurationEnabled) {
            return false;
        }
        Boolean bool = touchModeEnabled;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        INSTANCE.evaluateTouchModeEnabled(context);
        Boolean bool2 = touchModeEnabled;
        Intrinsics.checkNotNull(bool2);
        return bool2.booleanValue();
    }

    /* JADX INFO: compiled from: AccessibilityStateProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/util/AccessibilityStateProvider$Companion;", "", "()V", "touchModeEnabled", "", "getTouchModeEnabled", "()Ljava/lang/Boolean;", "setTouchModeEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "evaluateTouchModeEnabled", "", "context", "Landroid/content/Context;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Boolean getTouchModeEnabled() {
            return AccessibilityStateProvider.touchModeEnabled;
        }

        public final void setTouchModeEnabled(Boolean bool) {
            AccessibilityStateProvider.touchModeEnabled = bool;
        }

        public final void evaluateTouchModeEnabled(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (getTouchModeEnabled() != null) {
                return;
            }
            Object systemService = context.getSystemService("accessibility");
            AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
            setTouchModeEnabled(Boolean.valueOf(accessibilityManager != null ? accessibilityManager.isTouchExplorationEnabled() : false));
        }
    }
}
