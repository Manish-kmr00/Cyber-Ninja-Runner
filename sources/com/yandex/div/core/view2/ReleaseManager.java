package com.yandex.div.core.view2;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.ExpressionsRuntimeProvider;
import com.yandex.div.internal.Log;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReleaseManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0012J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0016R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/view2/ReleaseManager;", "", "runtimeProvider", "Lcom/yandex/div/core/expression/ExpressionsRuntimeProvider;", "(Lcom/yandex/div/core/expression/ExpressionsRuntimeProvider;)V", "divToRelease", "Ljava/util/HashMap;", "Landroidx/lifecycle/LifecycleOwner;", "", "Lcom/yandex/div/core/view2/Div2View;", "Lkotlin/collections/HashMap;", "monitor", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "addLifecycleListener", "lifecycleOwner", "divView", "observeDivLifecycle", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class ReleaseManager {
    public static final String NOT_ATTACHED_TO_LIFECYCLE_WARNING = "Attempt to bind a Div2View, which has no LifecycleOwner. Release event will not be caught! If you're using some long-lived resources, like a video player, call cleanup explicitly when you don't need Div2View anymore";
    public static final String TAG = "ReleaseManager";
    private final HashMap<LifecycleOwner, Set<Div2View>> divToRelease;
    private final Object monitor;
    private final LifecycleEventObserver observer;
    private final ExpressionsRuntimeProvider runtimeProvider;

    /* JADX INFO: compiled from: ReleaseManager.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ReleaseManager(ExpressionsRuntimeProvider runtimeProvider) {
        Intrinsics.checkNotNullParameter(runtimeProvider, "runtimeProvider");
        this.runtimeProvider = runtimeProvider;
        this.divToRelease = new HashMap<>();
        this.monitor = new Object();
        this.observer = new LifecycleEventObserver() { // from class: com.yandex.div.core.view2.ReleaseManager$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ReleaseManager.observer$lambda$2(this.f$0, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$2(ReleaseManager this$0, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        synchronized (this$0.monitor) {
            if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] == 1) {
                Set<Div2View> set = this$0.divToRelease.get(source);
                if (set != null) {
                    Intrinsics.checkNotNullExpressionValue(set, "divToRelease[source]");
                    for (Div2View div2View : set) {
                        div2View.cleanup();
                        this$0.runtimeProvider.cleanupRuntime$div_release(div2View);
                    }
                }
                this$0.divToRelease.remove(source);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void observeDivLifecycle(final Div2View divView) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        LifecycleOwner lifecycleOwner = divView.getContext().getLifecycleOwner();
        if (lifecycleOwner != null) {
            addLifecycleListener(lifecycleOwner, divView);
            return;
        }
        final Div2View div2View = divView;
        if (div2View.isAttachedToWindow()) {
            LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(div2View);
            if (lifecycleOwner2 != null) {
                addLifecycleListener(lifecycleOwner2, divView);
                return;
            } else {
                Log.w(TAG, NOT_ATTACHED_TO_LIFECYCLE_WARNING);
                return;
            }
        }
        div2View.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.yandex.div.core.view2.ReleaseManager$observeDivLifecycle$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                div2View.removeOnAttachStateChangeListener(this);
                LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(divView);
                if (lifecycleOwner3 != null) {
                    this.addLifecycleListener(lifecycleOwner3, divView);
                } else {
                    Log.w(ReleaseManager.TAG, ReleaseManager.NOT_ATTACHED_TO_LIFECYCLE_WARNING);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object addLifecycleListener(LifecycleOwner lifecycleOwner, Div2View divView) {
        Object objValueOf;
        synchronized (this.monitor) {
            if (this.divToRelease.containsKey(lifecycleOwner)) {
                Set<Div2View> set = this.divToRelease.get(lifecycleOwner);
                objValueOf = set != null ? Boolean.valueOf(set.add(divView)) : null;
            } else {
                this.divToRelease.put(lifecycleOwner, SetsKt.mutableSetOf(divView));
                lifecycleOwner.getLifecycle().addObserver(this.observer);
                objValueOf = Unit.INSTANCE;
            }
        }
        return objValueOf;
    }
}
