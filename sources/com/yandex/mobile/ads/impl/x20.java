package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.div.core.DivConfiguration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class x20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f10617a;

    static final class a extends Lambda implements Function0<DivConfiguration> {
        final /* synthetic */ Context b;
        final /* synthetic */ s20 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, s20 s20Var) {
            super(0);
            this.b = context;
            this.c = s20Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final DivConfiguration invoke() {
            DivConfiguration.Builder builderTypefaceProvider = new DivConfiguration.Builder(new g20(this.b)).divCustomContainerViewAdapter(new u10(new w10(), new a20(), new z10(), new v10(), new b20(), new x10())).typefaceProvider(new j30(this.b));
            s20 s20Var = this.c;
            if (s20Var != null) {
                builderTypefaceProvider = builderTypefaceProvider.extension(new t20(s20Var));
            }
            return builderTypefaceProvider.build();
        }
    }

    public x20(Context context, s20 s20Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10617a = LazyKt.lazy(new a(context, s20Var));
    }

    public final DivConfiguration a() {
        return (DivConfiguration) this.f10617a.getValue();
    }
}
