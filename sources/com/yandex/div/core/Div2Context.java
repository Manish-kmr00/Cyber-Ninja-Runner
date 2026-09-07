package com.yandex.div.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.LifecycleOwner;
import com.safedk.android.utils.j;
import com.yandex.div.DivDataTag;
import com.yandex.div.core.dagger.Div2Component;
import com.yandex.div.core.expression.variables.DivVariableController;
import com.yandex.div.core.expression.variables.GlobalVariableController;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.viewpool.ViewPreCreationProfile;
import com.yandex.div.internal.viewpool.optimization.PerformanceDependentSessionProfiler;
import com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Div2Context.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 @2\u00020\u0001:\u0003@ABB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB3\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB#\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\u0010\u00103\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u00103\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u00103\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u00104\u001a\u0004\u0018\u00010!H\u0012J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0016J\"\u00109\u001a\u00020:2\b\b\u0003\u0010;\u001a\u00020\u00072\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016J\b\u0010?\u001a\u00020:H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\u00020\u00198VX\u0097\u0084\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0092\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R$\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006C"}, d2 = {"Lcom/yandex/div/core/Div2Context;", "Landroid/content/ContextWrapper;", "baseContext", "Landroid/view/ContextThemeWrapper;", j.c, "Lcom/yandex/div/core/DivConfiguration;", "themeId", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/view/ContextThemeWrapper;Lcom/yandex/div/core/DivConfiguration;ILandroidx/lifecycle/LifecycleOwner;)V", "mask", "marker", "Lkotlin/jvm/internal/DefaultConstructorMarker;", "(Landroid/view/ContextThemeWrapper;Lcom/yandex/div/core/DivConfiguration;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "div2Component", "Lcom/yandex/div/core/dagger/Div2Component;", "(Landroid/view/ContextThemeWrapper;Lcom/yandex/div/core/dagger/Div2Component;Landroidx/lifecycle/LifecycleOwner;)V", "getDiv2Component$div_release", "()Lcom/yandex/div/core/dagger/Div2Component;", "divVariableController", "Lcom/yandex/div/core/expression/variables/DivVariableController;", "getDivVariableController", "()Lcom/yandex/div/core/expression/variables/DivVariableController;", "globalVariableController", "Lcom/yandex/div/core/expression/variables/GlobalVariableController;", "getGlobalVariableController$annotations", "()V", "getGlobalVariableController", "()Lcom/yandex/div/core/expression/variables/GlobalVariableController;", "globalVariableController$delegate", "Lkotlin/Lazy;", "inflater", "Landroid/view/LayoutInflater;", "getLifecycleOwner$div_release", "()Landroidx/lifecycle/LifecycleOwner;", "performanceDependentSessionProfiler", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;", "getPerformanceDependentSessionProfiler", "()Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;", "value", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "viewPreCreationProfile", "getViewPreCreationProfile", "()Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "setViewPreCreationProfile", "(Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;)V", "viewPreCreationProfileRepository", "Lcom/yandex/div/internal/viewpool/optimization/ViewPreCreationProfileRepository;", "getViewPreCreationProfileRepository", "()Lcom/yandex/div/internal/viewpool/optimization/ViewPreCreationProfileRepository;", "childContext", "getLayoutInflater", "getSystemService", "", "name", "", TimerController.RESET_COMMAND, "", "flags", "tags", "", "Lcom/yandex/div/DivDataTag;", "warmUp", "Companion", "Div2InflaterFactory", "ResetFlag", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class Div2Context extends ContextWrapper {
    public static final int RESET_ERROR_COLLECTORS = 2;
    public static final int RESET_EXPRESSION_RUNTIMES = 1;
    private static final int RESET_NONE = 0;
    public static final int RESET_SELECTED_STATES = 4;
    public static final int RESET_VISIBILITY_COUNTERS = 8;
    private final ContextThemeWrapper baseContext;
    private final Div2Component div2Component;

    /* JADX INFO: renamed from: globalVariableController$delegate, reason: from kotlin metadata */
    private final Lazy globalVariableController;
    private LayoutInflater inflater;
    private final LifecycleOwner lifecycleOwner;

    /* JADX INFO: compiled from: Div2Context.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/yandex/div/core/Div2Context$ResetFlag;", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public @interface ResetFlag {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Div2Context(ContextThemeWrapper baseContext, DivConfiguration configuration) {
        this(baseContext, configuration, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Div2Context(ContextThemeWrapper baseContext, DivConfiguration configuration, int i) {
        this(baseContext, configuration, i, null, 8, null);
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Deprecated(message = "Do not use this property")
    public static /* synthetic */ void getGlobalVariableController$annotations() {
    }

    /* synthetic */ Div2Context(ContextThemeWrapper contextThemeWrapper, Div2Component div2Component, LifecycleOwner lifecycleOwner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contextThemeWrapper, div2Component, (i & 4) != 0 ? null : lifecycleOwner);
    }

    /* JADX INFO: renamed from: getDiv2Component$div_release, reason: from getter */
    public Div2Component getDiv2Component() {
        return this.div2Component;
    }

    /* JADX INFO: renamed from: getLifecycleOwner$div_release, reason: from getter */
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    private Div2Context(ContextThemeWrapper contextThemeWrapper, Div2Component div2Component, LifecycleOwner lifecycleOwner) {
        super(contextThemeWrapper);
        this.baseContext = contextThemeWrapper;
        this.div2Component = div2Component;
        this.lifecycleOwner = lifecycleOwner;
        this.globalVariableController = LazyKt.lazy(new Function0<GlobalVariableController>() { // from class: com.yandex.div.core.Div2Context$globalVariableController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GlobalVariableController invoke() {
                DivVariableController divVariableController = this.this$0.getDiv2Component().getDivVariableController();
                Intrinsics.checkNotNullExpressionValue(divVariableController, "div2Component.divVariableController");
                return new GlobalVariableController(divVariableController);
            }
        });
        getDiv2Component().getDivCreationTracker().onContextCreationFinished();
    }

    public GlobalVariableController getGlobalVariableController() {
        return (GlobalVariableController) this.globalVariableController.getValue();
    }

    public DivVariableController getDivVariableController() {
        DivVariableController divVariableController = getDiv2Component().getDivVariableController();
        Intrinsics.checkNotNullExpressionValue(divVariableController, "div2Component.divVariableController");
        return divVariableController;
    }

    public PerformanceDependentSessionProfiler getPerformanceDependentSessionProfiler() {
        PerformanceDependentSessionProfiler performanceDependentSessionProfiler = getDiv2Component().getPerformanceDependentSessionProfiler();
        Intrinsics.checkNotNullExpressionValue(performanceDependentSessionProfiler, "div2Component.performanceDependentSessionProfiler");
        return performanceDependentSessionProfiler;
    }

    public ViewPreCreationProfileRepository getViewPreCreationProfileRepository() {
        ViewPreCreationProfileRepository viewPreCreationProfileRepository = getDiv2Component().getViewPreCreationProfileRepository();
        Intrinsics.checkNotNullExpressionValue(viewPreCreationProfileRepository, "div2Component.viewPreCreationProfileRepository");
        return viewPreCreationProfileRepository;
    }

    public ViewPreCreationProfile getViewPreCreationProfile() {
        return getDiv2Component().getDivViewCreator().getViewPreCreationProfile();
    }

    public void setViewPreCreationProfile(ViewPreCreationProfile value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getDiv2Component().getDivViewCreator().setViewPreCreationProfile(value);
    }

    public /* synthetic */ Div2Context(ContextThemeWrapper contextThemeWrapper, DivConfiguration divConfiguration, int i, LifecycleOwner lifecycleOwner, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(contextThemeWrapper, divConfiguration, (i2 & 4) != 0 ? com.yandex.div.R.style.Div_Theme : i, (i2 & 8) != 0 ? null : lifecycleOwner);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Div2Context(ContextThemeWrapper baseContext, DivConfiguration configuration, int i, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Div2Component div2ComponentBuild = DivKit.INSTANCE.getInstance(baseContext).getComponent().div2Component().baseContext(baseContext).configuration(configuration).themeId(i).divCreationTracker(new DivCreationTracker(SystemClock.uptimeMillis())).divVariableController(configuration.getDivVariableController()).build();
        Intrinsics.checkNotNullExpressionValue(div2ComponentBuild, "DivKit.getInstance(baseC…ler)\n            .build()");
        this(baseContext, div2ComponentBuild, lifecycleOwner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Do not use this constructor")
    public Div2Context(ContextThemeWrapper baseContext, DivConfiguration configuration, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseContext, configuration, i, null);
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            return getLayoutInflater();
        }
        return this.baseContext.getSystemService(name);
    }

    private LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflaterCloneInContext;
        LayoutInflater layoutInflater = this.inflater;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        synchronized (this) {
            layoutInflaterCloneInContext = this.inflater;
            if (layoutInflaterCloneInContext == null) {
                layoutInflaterCloneInContext = LayoutInflater.from(this.baseContext).cloneInContext(this);
                Intrinsics.checkNotNull(layoutInflaterCloneInContext, "null cannot be cast to non-null type android.view.LayoutInflater");
                LayoutInflaterCompat.setFactory2(layoutInflaterCloneInContext, new Div2InflaterFactory(this));
                this.inflater = layoutInflaterCloneInContext;
            }
        }
        return layoutInflaterCloneInContext;
    }

    public void warmUp() {
        getDiv2Component().getDiv2Builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reset$default(Div2Context div2Context, int i, List list, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reset");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        div2Context.reset(i, list);
    }

    public void reset(@ResetFlag int flags, List<? extends DivDataTag> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if ((flags & 1) != 0) {
            getDiv2Component().getExpressionsRuntimeProvider().reset(tags);
        }
        if ((flags & 2) != 0) {
            getDiv2Component().getErrorCollectors().reset(tags);
        }
        if ((flags & 4) != 0) {
            getDiv2Component().getStateManager().reset(tags);
        }
        if ((flags & 8) != 0) {
            getDiv2Component().getVisibilityActionDispatcher().reset(tags);
        }
    }

    public Div2Context childContext(ContextThemeWrapper baseContext) {
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        return new Div2Context(baseContext, getDiv2Component(), getLifecycleOwner());
    }

    public Div2Context childContext(LifecycleOwner lifecycleOwner) {
        return new Div2Context(this.baseContext, getDiv2Component(), lifecycleOwner);
    }

    public Div2Context childContext(ContextThemeWrapper baseContext, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        return new Div2Context(baseContext, getDiv2Component(), lifecycleOwner);
    }

    /* JADX INFO: compiled from: Div2Context.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J,\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/Div2Context$Div2InflaterFactory;", "Landroid/view/LayoutInflater$Factory2;", "div2Context", "Lcom/yandex/div/core/Div2Context;", "(Lcom/yandex/div/core/Div2Context;)V", "isDiv2View", "", "viewClassName", "", "onCreateView", "Landroid/view/View;", "parent", "name", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Div2InflaterFactory implements LayoutInflater.Factory2 {
        private static final String DIV_VIEW_CLASS_NAME = "com.yandex.div.core.view2.Div2View";
        private static final String DIV_VIEW_SIMPLE_CLASS_NAME = "Div2View";
        private final Div2Context div2Context;

        public Div2InflaterFactory(Div2Context div2Context) {
            Intrinsics.checkNotNullParameter(div2Context, "div2Context");
            this.div2Context = div2Context;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            return onCreateView(name, context, attrs);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            if (!isDiv2View(name)) {
                return null;
            }
            return new Div2View(this.div2Context, attrs, 0, 4, null);
        }

        private final boolean isDiv2View(String viewClassName) {
            return Intrinsics.areEqual(DIV_VIEW_CLASS_NAME, viewClassName) || Intrinsics.areEqual(DIV_VIEW_SIMPLE_CLASS_NAME, viewClassName);
        }
    }
}
