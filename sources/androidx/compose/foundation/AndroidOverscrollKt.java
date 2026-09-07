package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidOverscroll.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"NoOpOverscrollEffect", "androidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1", "getNoOpOverscrollEffect$annotations", "()V", "Landroidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1;", "StretchOverscrollNonClippingLayer", "Landroidx/compose/ui/Modifier;", "rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidOverscrollKt {
    private static final AndroidOverscrollKt$NoOpOverscrollEffect$1 NoOpOverscrollEffect = new OverscrollEffect() { // from class: androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1
        private boolean isEnabled;

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: consumePostScroll-l7mfB5k */
        public void mo169consumePostScrolll7mfB5k(long initialDragDelta, long overscrollDelta, Offset pointerPosition, int source) {
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public boolean isInProgress() {
            return false;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: consumePreScroll-A0NYTsA */
        public long mo171consumePreScrollA0NYTsA(long scrollDelta, Offset pointerPosition, int source) {
            return Offset.INSTANCE.m1411getZeroF1C5BW0();
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: consumePreFling-QWom1Mo */
        public Object mo170consumePreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
            return Velocity.m4059boximpl(Velocity.INSTANCE.m4079getZero9UxMQ8M());
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: consumePostFling-sF-c-tU */
        public Object mo168consumePostFlingsFctU(long j, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: isEnabled, reason: from getter */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public void setEnabled(boolean z) {
            this.isEnabled = z;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public Modifier getEffectModifier() {
            return Modifier.INSTANCE;
        }
    };
    private static final Modifier StretchOverscrollNonClippingLayer;

    private static /* synthetic */ void getNoOpOverscrollEffect$annotations() {
    }

    public static final OverscrollEffect rememberOverscrollEffect(Composer composer, int i) {
        composer.startReplaceableGroup(-81138291);
        ComposerKt.sourceInformation(composer, "C(rememberOverscrollEffect)57@2452L7,58@2506L7,59@2525L186:AndroidOverscroll.kt#71ulvw");
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ProvidableCompositionLocal<OverscrollConfiguration> localOverscrollConfiguration = OverscrollConfigurationKt.getLocalOverscrollConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localOverscrollConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) objConsume2;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(context) | composer.changed(overscrollConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (overscrollConfiguration != null) {
                objRememberedValue = (OverscrollEffect) new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
            } else {
                objRememberedValue = (OverscrollEffect) NoOpOverscrollEffect;
            }
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        OverscrollEffect overscrollEffect = (OverscrollEffect) objRememberedValue;
        composer.endReplaceableGroup();
        return overscrollEffect;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1] */
    static {
        Modifier.Companion companionLayout;
        if (Build.VERSION.SDK_INT >= 31) {
            companionLayout = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m173invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m173invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable placeableMo3124measureBRTryo0 = measurable.mo3124measureBRTryo0(j);
                    final int i = layout.mo312roundToPx0680j_4(Dp.m3843constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
                    return MeasureScope.layout$default(layout, placeableMo3124measureBRTryo0.getMeasuredWidth() - i, placeableMo3124measureBRTryo0.getMeasuredHeight() - i, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable placeable = placeableMo3124measureBRTryo0;
                            Placeable.PlacementScope.placeWithLayer$default(layout2, placeable, ((-i) / 2) - ((placeable.getWidth() - placeableMo3124measureBRTryo0.getMeasuredWidth()) / 2), ((-i) / 2) - ((placeableMo3124measureBRTryo0.getHeight() - placeableMo3124measureBRTryo0.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
                        }
                    }, 4, null);
                }
            }), new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m174invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m174invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable placeableMo3124measureBRTryo0 = measurable.mo3124measureBRTryo0(j);
                    final int i = layout.mo312roundToPx0680j_4(Dp.m3843constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
                    return MeasureScope.layout$default(layout, placeableMo3124measureBRTryo0.getWidth() + i, placeableMo3124measureBRTryo0.getHeight() + i, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable placeable = placeableMo3124measureBRTryo0;
                            int i2 = i;
                            Placeable.PlacementScope.place$default(layout2, placeable, i2 / 2, i2 / 2, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            });
        } else {
            companionLayout = Modifier.INSTANCE;
        }
        StretchOverscrollNonClippingLayer = companionLayout;
    }
}
