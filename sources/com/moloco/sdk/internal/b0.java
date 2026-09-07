package com.moloco.sdk.internal;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements a0, LifecycleOwner, SavedStateRegistryOwner {
    public static final a c = new a(null);
    public static final String d = "ViewLifecycleOwner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f6067a = new LifecycleRegistry(this);
    public final SavedStateRegistryController b = SavedStateRegistryController.INSTANCE.create(this);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f6068a;
        public final /* synthetic */ b0 b;

        public static final class a implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f6069a;
            public final /* synthetic */ b0 b;
            public final /* synthetic */ View c;

            public a(View view, b0 b0Var, View view2) {
                this.f6069a = view;
                this.b = b0Var;
                this.c = view2;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f6069a.removeOnAttachStateChangeListener(this);
                this.b.f(this.c);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, b0 b0Var) {
            super(0);
            this.f6068a = view;
            this.b = b0Var;
        }

        public final void a() {
            View view = this.f6068a;
            b0 b0Var = this.b;
            if (ViewCompat.isAttachedToWindow(view)) {
                b0Var.f(view);
            } else {
                view.addOnAttachStateChangeListener(new a(view, b0Var, view));
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Override // com.moloco.sdk.internal.a0
    public void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View rootView = view.getRootView();
        if (rootView == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, d, "RootView is absent, skipping", null, false, 12, null);
            return;
        }
        if (Intrinsics.areEqual(ViewTreeSavedStateRegistryOwner.get(rootView), this)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Removing ViewTreeSavedStateRegistryOwner", null, false, 12, null);
            ViewTreeSavedStateRegistryOwner.set(rootView, null);
        }
        if (e(rootView)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Removing ViewTreeLifecycleOwner", null, false, 12, null);
            ViewTreeLifecycleOwner.set(rootView, null);
        }
    }

    @Override // com.moloco.sdk.internal.a0
    public void c(View view) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(view, "view");
        View pause$lambda$9 = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(pause$lambda$9, "pause$lambda$9");
        if (e(pause$lambda$9)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.f6067a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "lifecycle pause success " + Result.m7911isSuccessimpl(objM7904constructorimpl), Result.m7907exceptionOrNullimpl(objM7904constructorimpl), false, 8, null);
        }
    }

    @Override // com.moloco.sdk.internal.a0
    public void d(View view) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(view, "view");
        View resume$lambda$7 = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(resume$lambda$7, "resume$lambda$7");
        if (e(resume$lambda$7)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.f6067a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "lifecycle resume success", null, false, 12, null);
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, d, "lifecycle resume failure", thM7907exceptionOrNullimpl, false, 8, null);
            }
        }
    }

    public final boolean e(View view) {
        return Intrinsics.areEqual(ViewTreeLifecycleOwner.get(view), this);
    }

    public final void f(View view) {
        View rootView = view.getRootView();
        if (rootView == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, d, "RootView is absent, skipping", null, false, 12, null);
            return;
        }
        if (ViewTreeSavedStateRegistryOwner.get(rootView) == null) {
            ViewTreeSavedStateRegistryOwner.set(rootView, this);
            try {
                Result.Companion companion = Result.INSTANCE;
                this.b.performRestore(null);
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "ViewTreeSavedStateRegistryOwner is absent, setting custom one", null, false, 12, null);
        }
        if (ViewTreeLifecycleOwner.get(rootView) == null) {
            ViewTreeLifecycleOwner.set(rootView, this);
            this.f6067a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            this.f6067a.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.f6067a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "ViewTreeLifecycleOwner is absent, setting custom one", null, false, 12, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f6067a;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.b.getSavedStateRegistry();
    }

    @Override // com.moloco.sdk.internal.a0
    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.moloco.sdk.internal.scheduling.d.a(new b(view, this));
    }
}
