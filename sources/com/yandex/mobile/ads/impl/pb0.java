package com.yandex.mobile.ads.impl;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class pb0 implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9908a = new a();

    public static final class a extends Lifecycle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lifecycle.State f9909a = Lifecycle.State.STARTED;

        @Override // androidx.lifecycle.Lifecycle
        public final void addObserver(LifecycleObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        @Override // androidx.lifecycle.Lifecycle
        public final void removeObserver(LifecycleObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        a() {
        }

        @Override // androidx.lifecycle.Lifecycle
        /* JADX INFO: renamed from: getCurrentState */
        public final Lifecycle.State getState() {
            return this.f9909a;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f9908a;
    }
}
