package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class w {

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MolocoInitializationListener f6288a;
        public final /* synthetic */ MolocoInitStatus b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MolocoInitializationListener molocoInitializationListener, MolocoInitStatus molocoInitStatus) {
            super(0);
            this.f6288a = molocoInitializationListener;
            this.b = molocoInitStatus;
        }

        public final void a() {
            this.f6288a.onMolocoInitializationStatus(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final void a(MolocoInitializationListener molocoInitializationListener, MolocoInitStatus initStatus) {
        Intrinsics.checkNotNullParameter(molocoInitializationListener, "<this>");
        Intrinsics.checkNotNullParameter(initStatus, "initStatus");
        com.moloco.sdk.internal.scheduling.d.a(new a(molocoInitializationListener, initStatus));
    }
}
