package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a$a, reason: collision with other inner class name */
    public static final class C0630a extends Lambda implements Function1<LayoutCoordinates, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c f6728a;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0630a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVar, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1) {
            super(1);
            this.f6728a = cVar;
            this.b = function1;
        }

        public final void a(LayoutCoordinates it) {
            Intrinsics.checkNotNullParameter(it, "it");
            c cVar = c.f6784a;
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVarA = cVar.a(it, this.f6728a.d());
            if (!cVar.a(cVarA) || Intrinsics.areEqual(cVarA, this.f6728a)) {
                return;
            }
            this.b.invoke(cVarA);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
            a(layoutCoordinates);
            return Unit.INSTANCE;
        }
    }

    public static final Modifier a(Modifier modifier, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c savedStateButton, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> updateButtonState) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(savedStateButton, "savedStateButton");
        Intrinsics.checkNotNullParameter(updateButtonState, "updateButtonState");
        return OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new C0630a(savedStateButton, updateButtonState));
    }
}
