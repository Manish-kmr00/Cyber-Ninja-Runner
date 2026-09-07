package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aa\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010(\u001a \u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0000ø\u0001\u0000¢\u0006\u0002\u0010-\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0006\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\f\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\b\"\u000e\u0010\u000e\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMinHeight;
    private static final float DropdownMenuVerticalPadding;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;
    private static final float DropdownMenuItemHorizontalPadding = Dp.m3843constructorimpl(16);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m3843constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m3843constructorimpl(280);

    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:59:0x010b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0171  */
    /* JADX WARN: Code duplicated, block: B:63:0x0174  */
    /* JADX WARN: Code duplicated, block: B:67:0x018f  */
    /* JADX WARN: Code duplicated, block: B:70:0x01de  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:77:0x0223  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public static final void DropdownMenuContent(final MutableTransitionState<Boolean> expandedStates, final MutableState<TransformOrigin> transformOriginState, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final int i3;
        Modifier modifier2;
        int i4;
        final Modifier modifier3;
        boolean zBooleanValue;
        float f;
        final State stateCreateTransitionAnimation;
        boolean zBooleanValue2;
        float f2;
        final State stateCreateTransitionAnimation2;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(expandedStates, "expandedStates");
        Intrinsics.checkNotNullParameter(transformOriginState, "transformOriginState");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1164283597);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuContent)P(1,3,2)68@2881L48,70@2959L666,96@3655L477,116@4185L153,115@4137L501:Menu.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(expandedStates) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(transformOriginState) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i3 & 14), 0);
                MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer composer2, int i6) {
                        TweenSpec tweenSpecTween$default;
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(365249092);
                        if (animateFloat.isTransitioningTo(false, true)) {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        } else {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                        }
                        composer2.endReplaceableGroup();
                        return tweenSpecTween$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                zBooleanValue = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1958825495);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
                if (zBooleanValue) {
                    f = 1.0f;
                } else {
                    f = 0.8f;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf = Float.valueOf(f);
                boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1958825495);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
                float f3 = zBooleanValue3 ? 1.0f : 0.8f;
                composerStartRestartGroup.endReplaceableGroup();
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f3), menuKt$DropdownMenuContent$scale$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer composer2, int i6) {
                        TweenSpec tweenSpecTween$default;
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(782718552);
                        if (animateFloat.isTransitioningTo(false, true)) {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                        } else {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                        }
                        composer2.endReplaceableGroup();
                        return tweenSpecTween$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                zBooleanValue2 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1541356035);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
                if (zBooleanValue2) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf2 = Float.valueOf(f2);
                boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1541356035);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
                float f4 = zBooleanValue4 ? 1.0f : 0.0f;
                composerStartRestartGroup.endReplaceableGroup();
                stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), menuKt$DropdownMenuContent$alpha$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(transformOriginState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                            invoke2(graphicsLayerScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GraphicsLayerScope graphicsLayer) {
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            graphicsLayer.setScaleX(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                            graphicsLayer.setScaleY(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                            graphicsLayer.setAlpha(MenuKt.m1087DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                            graphicsLayer.mo1792setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CardKt.m942CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -242468534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ComposerKt.sourceInformation(composer2, "C128@4569L21,124@4390L242:Menu.kt#jmzs0o");
                        if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m425paddingVpY3zN4$default(modifier3, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                            Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                            int i7 = i3 & 7168;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierVerticalScroll$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i7 >> 6) & 112) | 6));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 1769472, 30);
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    MenuKt.DropdownMenuContent(expandedStates, transformOriginState, modifier4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 5851) == 1170) {
            if (i5 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            Transition transitionUpdateTransition2 = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i3 & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$3 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$scale$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer composer2, int i6) {
                    TweenSpec tweenSpecTween$default;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(365249092);
                    if (animateFloat.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            zBooleanValue = ((Boolean) transitionUpdateTransition2.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1958825495);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf3 = Float.valueOf(f);
            boolean zBooleanValue5 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1958825495);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue5) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf3, Float.valueOf(f3), menuKt$DropdownMenuContent$scale$3.invoke(transitionUpdateTransition2.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$3 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer composer2, int i6) {
                    TweenSpec tweenSpecTween$default;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(782718552);
                    if (animateFloat.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            zBooleanValue2 = ((Boolean) transitionUpdateTransition2.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1541356035);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue2) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf4 = Float.valueOf(f2);
            boolean zBooleanValue6 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1541356035);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue6) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf4, Float.valueOf(f4), menuKt$DropdownMenuContent$alpha$3.invoke(transitionUpdateTransition2.getSegment(), composerStartRestartGroup, 0), vectorConverter4, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(transformOriginState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setAlpha(MenuKt.m1087DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                        graphicsLayer.mo1792setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setAlpha(MenuKt.m1087DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                        graphicsLayer.mo1792setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CardKt.m942CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -242468534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C128@4569L21,124@4390L242:Menu.kt#jmzs0o");
                    if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m425paddingVpY3zN4$default(modifier3, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                        Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                        int i7 = i3 & 7168;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density = (Density) objConsume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer2.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierVerticalScroll$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer2);
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                        function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i7 >> 6) & 112) | 6));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 1769472, 30);
            modifier4 = modifier3;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            Transition transitionUpdateTransition3 = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i3 & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$4 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$scale$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer composer2, int i6) {
                    TweenSpec tweenSpecTween$default;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(365249092);
                    if (animateFloat.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter5 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            zBooleanValue = ((Boolean) transitionUpdateTransition3.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1958825495);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf5 = Float.valueOf(f);
            boolean zBooleanValue7 = ((Boolean) transitionUpdateTransition3.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1958825495);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue7) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition3, fValueOf5, Float.valueOf(f3), menuKt$DropdownMenuContent$scale$4.invoke(transitionUpdateTransition3.getSegment(), composerStartRestartGroup, 0), vectorConverter5, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$4 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer composer2, int i6) {
                    TweenSpec tweenSpecTween$default;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(782718552);
                    if (animateFloat.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter6 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            zBooleanValue2 = ((Boolean) transitionUpdateTransition3.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1541356035);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue2) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf6 = Float.valueOf(f2);
            boolean zBooleanValue8 = ((Boolean) transitionUpdateTransition3.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1541356035);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Menu.kt#jmzs0o");
            if (zBooleanValue8) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition3, fValueOf6, Float.valueOf(f4), menuKt$DropdownMenuContent$alpha$4.invoke(transitionUpdateTransition3.getSegment(), composerStartRestartGroup, 0), vectorConverter6, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(transformOriginState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setAlpha(MenuKt.m1087DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                        graphicsLayer.mo1792setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(MenuKt.m1086DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setAlpha(MenuKt.m1087DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                        graphicsLayer.mo1792setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CardKt.m942CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -242468534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C128@4569L21,124@4390L242:Menu.kt#jmzs0o");
                    if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m425paddingVpY3zN4$default(modifier3, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                        Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                        int i7 = i3 & 7168;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density = (Density) objConsume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer2.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierVerticalScroll$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer2);
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                        function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i7 >> 6) & 112) | 6));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 1769472, 30);
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                MenuKt.DropdownMenuContent(expandedStates, transformOriginState, modifier4, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0284  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00db  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x010d  */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:91:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:95:0x01dd  */
    public static final void DropdownMenuItemContent(final Function0<Unit> onClick, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        int i10;
        final int i11;
        Modifier modifier3;
        boolean z3;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource3;
        Function0<ComposeUiNode> constructor;
        final PaddingValues paddingValues3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(87134531);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemContent)P(5,4,2,1,3)140@4912L39,150@5295L20,144@5084L996:Menu.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 32) != 0) {
                            if ((458752 & i) == 0) {
                                if (composerStartRestartGroup.changed(content)) {
                                    i10 = 131072;
                                } else {
                                    i10 = 65536;
                                }
                            }
                            i11 = i3;
                            if ((374491 & i11) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                if (i12 != 0) {
                                    modifier3 = Modifier.INSTANCE;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues2;
                                }
                                if (i8 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                PaddingValues paddingValues4 = dropdownMenuItemContentPadding;
                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues4);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                composerStartRestartGroup.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                composerStartRestartGroup.disableReusing();
                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composerStartRestartGroup.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                                composerStartRestartGroup.startReplaceableGroup(2058660585);
                                composerStartRestartGroup.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                                final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composerStartRestartGroup.startReplaceableGroup(1664959143);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                                final int i13 = 6;
                                final boolean z5 = z3;
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i14) {
                                        float disabled;
                                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                            if (z5) {
                                                composer2.startReplaceableGroup(-1945695285);
                                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                            } else {
                                                composer2.startReplaceableGroup(-1945695262);
                                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                            }
                                            composer2.endReplaceableGroup();
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                            final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                            final RowScope rowScope = rowScopeInstance;
                                            final int i15 = i13;
                                            final int i16 = i11;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i17) {
                                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                    } else {
                                                        function3.invoke(rowScope, composer3, Integer.valueOf((i15 & 14) | ((i16 >> 12) & 112)));
                                                    }
                                                }
                                            }), composer2, 56);
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), composerStartRestartGroup, 48);
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                paddingValues3 = paddingValues4;
                                modifier2 = modifier3;
                                z4 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z4 = z2;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i14) {
                                    MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                                }
                            });
                        }
                        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i3 |= i10;
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues5 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding2 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues5);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composerStartRestartGroup.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierPadding2);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i14 = 6;
                            final boolean z6 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z6) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance2;
                                        final int i16 = i14;
                                        final int i17 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i18) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i18 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i16 & 14) | ((i17 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues5;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues6 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding3 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues6);
                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume7 = composerStartRestartGroup.consume(localDensity3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density3 = (Density) objConsume7;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localViewConfiguration3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierPadding3);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance3 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i15 = 6;
                            final boolean z7 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i16) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z7) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance3;
                                        final int i17 = i15;
                                        final int i18 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i19) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i19 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i17 & 14) | ((i18 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues6;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i16) {
                                MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= 24576;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues7 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding4 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues7);
                            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume10 = composerStartRestartGroup.consume(localDensity4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density4 = (Density) objConsume10;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11 = composerStartRestartGroup.consume(localLayoutDirection4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection4 = (LayoutDirection) objConsume11;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume12 = composerStartRestartGroup.consume(localViewConfiguration4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume12;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierPadding4);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl4, density4, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl4, viewConfiguration4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance4 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i16 = 6;
                            final boolean z8 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i17) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z8) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance4;
                                        final int i18 = i16;
                                        final int i19 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i110) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i110 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i18 & 14) | ((i19 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues7;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues8 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding5 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues8);
                            Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume13 = composerStartRestartGroup.consume(localDensity5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density5 = (Density) objConsume13;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume14 = composerStartRestartGroup.consume(localLayoutDirection5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection5 = (LayoutDirection) objConsume14;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume15 = composerStartRestartGroup.consume(localViewConfiguration5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration5 = (ViewConfiguration) objConsume15;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierPadding5);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl5, density5, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl5, viewConfiguration5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance5 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i17 = 6;
                            final boolean z9 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i18) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z9) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance5;
                                        final int i19 = i17;
                                        final int i110 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i111) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i111 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i19 & 14) | ((i110 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues8;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i18) {
                                MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues9 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding6 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues9);
                        Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume16 = composerStartRestartGroup.consume(localDensity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density6 = (Density) objConsume16;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume17 = composerStartRestartGroup.consume(localLayoutDirection6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection6 = (LayoutDirection) objConsume17;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localViewConfiguration6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration6 = (ViewConfiguration) objConsume18;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierPadding6);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl6 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl6, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl6, density6, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl6, viewConfiguration6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf6.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance6 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i18 = 6;
                        final boolean z10 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i19) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z10) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance6;
                                    final int i110 = i18;
                                    final int i111 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i112) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i112 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i110 & 14) | ((i111 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues9;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues10 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding7 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues10);
                        Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localDensity7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density7 = (Density) objConsume19;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume110 = composerStartRestartGroup.consume(localLayoutDirection7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection7 = (LayoutDirection) objConsume110;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111 = composerStartRestartGroup.consume(localViewConfiguration7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration7 = (ViewConfiguration) objConsume111;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierPadding7);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl7 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl7, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl7, density7, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl7, viewConfiguration7, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf7.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance7 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i19 = 6;
                        final boolean z11 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i110) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z11) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance7;
                                    final int i111 = i19;
                                    final int i112 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i113) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i113 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i111 & 14) | ((i112 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues10;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i110) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 3072;
                paddingValues2 = paddingValues;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues11 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding8 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11);
                            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume112 = composerStartRestartGroup.consume(localDensity8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density8 = (Density) objConsume112;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume113 = composerStartRestartGroup.consume(localLayoutDirection8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection8 = (LayoutDirection) objConsume113;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume114 = composerStartRestartGroup.consume(localViewConfiguration8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration8 = (ViewConfiguration) objConsume114;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierPadding8);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl8 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl8, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl8, density8, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl8, layoutDirection8, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl8, viewConfiguration8, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf8.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance8 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i110 = 6;
                            final boolean z12 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i111) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z12) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance8;
                                        final int i112 = i110;
                                        final int i113 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i114) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i114 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i112 & 14) | ((i113 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues11;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues12 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding9 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues12);
                            Alignment.Vertical centerVertically9 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically9, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume115 = composerStartRestartGroup.consume(localDensity9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density9 = (Density) objConsume115;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume116 = composerStartRestartGroup.consume(localLayoutDirection9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection9 = (LayoutDirection) objConsume116;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration9 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume117 = composerStartRestartGroup.consume(localViewConfiguration9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration9 = (ViewConfiguration) objConsume117;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierPadding9);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl9 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl9, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl9, density9, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl9, layoutDirection9, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl9, viewConfiguration9, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf9.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance9 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i111 = 6;
                            final boolean z13 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i112) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z13) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance9;
                                        final int i113 = i111;
                                        final int i114 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i115) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i115 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i113 & 14) | ((i114 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues12;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i112) {
                                MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues13 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding10 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues13);
                        Alignment.Vertical centerVertically10 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically10, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume118 = composerStartRestartGroup.consume(localDensity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density10 = (Density) objConsume118;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume119 = composerStartRestartGroup.consume(localLayoutDirection10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection10 = (LayoutDirection) objConsume119;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration10 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1110 = composerStartRestartGroup.consume(localViewConfiguration10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration10 = (ViewConfiguration) objConsume1110;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf10 = LayoutKt.materializerOf(modifierPadding10);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl10 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl10, measurePolicyRowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl10, density10, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl10, layoutDirection10, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl10, viewConfiguration10, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf10.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance10 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i112 = 6;
                        final boolean z14 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i113) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i113 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z14) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance10;
                                    final int i114 = i112;
                                    final int i115 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i116) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i116 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i114 & 14) | ((i115 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues13;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues14 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues14);
                        Alignment.Vertical centerVertically11 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111 = composerStartRestartGroup.consume(localDensity11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density11 = (Density) objConsume1111;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1112 = composerStartRestartGroup.consume(localLayoutDirection11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection11 = (LayoutDirection) objConsume1112;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1113 = composerStartRestartGroup.consume(localViewConfiguration11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration11 = (ViewConfiguration) objConsume1113;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11 = LayoutKt.materializerOf(modifierPadding11);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl11 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11, measurePolicyRowMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl11, density11, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl11, layoutDirection11, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl11, viewConfiguration11, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf11.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance11 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i113 = 6;
                        final boolean z15 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i114) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z15) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance11;
                                    final int i115 = i113;
                                    final int i116 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i117) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i117 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i115 & 14) | ((i116 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues14;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i114) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues15 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding12 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues15);
                        Alignment.Vertical centerVertically12 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically12, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1114 = composerStartRestartGroup.consume(localDensity12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density12 = (Density) objConsume1114;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1115 = composerStartRestartGroup.consume(localLayoutDirection12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection12 = (LayoutDirection) objConsume1115;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration12 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1116 = composerStartRestartGroup.consume(localViewConfiguration12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration12 = (ViewConfiguration) objConsume1116;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf12 = LayoutKt.materializerOf(modifierPadding12);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl12 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl12, measurePolicyRowMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl12, density12, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl12, layoutDirection12, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl12, viewConfiguration12, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf12.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance12 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i114 = 6;
                        final boolean z16 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i115) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i115 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z16) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance12;
                                    final int i116 = i114;
                                    final int i117 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i118) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i118 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i116 & 14) | ((i117 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues15;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues16 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding13 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues16);
                        Alignment.Vertical centerVertically13 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically13, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1117 = composerStartRestartGroup.consume(localDensity13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density13 = (Density) objConsume1117;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1118 = composerStartRestartGroup.consume(localLayoutDirection13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection13 = (LayoutDirection) objConsume1118;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration13 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1119 = composerStartRestartGroup.consume(localViewConfiguration13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration13 = (ViewConfiguration) objConsume1119;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf13 = LayoutKt.materializerOf(modifierPadding13);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl13 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl13, measurePolicyRowMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl13, density13, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl13, layoutDirection13, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl13, viewConfiguration13, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf13.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance13 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i115 = 6;
                        final boolean z17 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i116) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z17) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance13;
                                    final int i117 = i115;
                                    final int i118 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i119) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i119 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i117 & 14) | ((i118 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues16;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i116) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues17 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding14 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues17);
                    Alignment.Vertical centerVertically14 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically14, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11110 = composerStartRestartGroup.consume(localDensity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density14 = (Density) objConsume11110;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111 = composerStartRestartGroup.consume(localLayoutDirection14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection14 = (LayoutDirection) objConsume11111;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration14 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11112 = composerStartRestartGroup.consume(localViewConfiguration14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration14 = (ViewConfiguration) objConsume11112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf14 = LayoutKt.materializerOf(modifierPadding14);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl14 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl14, measurePolicyRowMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl14, density14, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl14, layoutDirection14, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl14, viewConfiguration14, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf14.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance14 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i116 = 6;
                    final boolean z18 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i117) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i117 & 11) != 2 || !composer2.getSkipping()) {
                                if (z18) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance14;
                                final int i118 = i116;
                                final int i119 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1110) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1110 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i118 & 14) | ((i119 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues17;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues18 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding15 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues18);
                    Alignment.Vertical centerVertically15 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically15, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11113 = composerStartRestartGroup.consume(localDensity15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density15 = (Density) objConsume11113;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11114 = composerStartRestartGroup.consume(localLayoutDirection15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection15 = (LayoutDirection) objConsume11114;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration15 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11115 = composerStartRestartGroup.consume(localViewConfiguration15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration15 = (ViewConfiguration) objConsume11115;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf15 = LayoutKt.materializerOf(modifierPadding15);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl15 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl15, measurePolicyRowMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl15, density15, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl15, layoutDirection15, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl15, viewConfiguration15, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf15.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance15 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i117 = 6;
                    final boolean z19 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i118) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                                if (z19) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance15;
                                final int i119 = i117;
                                final int i1110 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i119 & 14) | ((i1110 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues18;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i118) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues19 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding16 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues19);
                            Alignment.Vertical centerVertically16 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically16, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11116 = composerStartRestartGroup.consume(localDensity16);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density16 = (Density) objConsume11116;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11117 = composerStartRestartGroup.consume(localLayoutDirection16);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection16 = (LayoutDirection) objConsume11117;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration16 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11118 = composerStartRestartGroup.consume(localViewConfiguration16);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration16 = (ViewConfiguration) objConsume11118;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf16 = LayoutKt.materializerOf(modifierPadding16);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl16 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl16, measurePolicyRowMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl16, density16, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl16, layoutDirection16, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl16, viewConfiguration16, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf16.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance16 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i118 = 6;
                            final boolean z110 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i119) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i119 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z110) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance16;
                                        final int i1110 = i118;
                                        final int i1111 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i1112) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i1112 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i1110 & 14) | ((i1111 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues19;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues110 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding17 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues110);
                            Alignment.Vertical centerVertically17 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy17 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically17, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11119 = composerStartRestartGroup.consume(localDensity17);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density17 = (Density) objConsume11119;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection17 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111110 = composerStartRestartGroup.consume(localLayoutDirection17);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection17 = (LayoutDirection) objConsume111110;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration17 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111 = composerStartRestartGroup.consume(localViewConfiguration17);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration17 = (ViewConfiguration) objConsume111111;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf17 = LayoutKt.materializerOf(modifierPadding17);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl17 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl17, measurePolicyRowMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl17, density17, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl17, layoutDirection17, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl17, viewConfiguration17, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf17.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance17 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i119 = 6;
                            final boolean z111 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i1110) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i1110 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z111) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance17;
                                        final int i1111 = i119;
                                        final int i1112 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i1113) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i1113 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i1111 & 14) | ((i1112 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues110;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1110) {
                                MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues111 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding18 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111);
                        Alignment.Vertical centerVertically18 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy18 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically18, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111112 = composerStartRestartGroup.consume(localDensity18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density18 = (Density) objConsume111112;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection18 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111113 = composerStartRestartGroup.consume(localLayoutDirection18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection18 = (LayoutDirection) objConsume111113;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration18 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111114 = composerStartRestartGroup.consume(localViewConfiguration18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration18 = (ViewConfiguration) objConsume111114;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf18 = LayoutKt.materializerOf(modifierPadding18);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl18 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl18, measurePolicyRowMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl18, density18, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl18, layoutDirection18, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl18, viewConfiguration18, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf18.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance18 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1110 = 6;
                        final boolean z112 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1111) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1111 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z112) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance18;
                                    final int i1112 = i1110;
                                    final int i1113 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i1114) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i1114 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1112 & 14) | ((i1113 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues111;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues112 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding19 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues112);
                        Alignment.Vertical centerVertically19 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy19 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically19, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111115 = composerStartRestartGroup.consume(localDensity19);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density19 = (Density) objConsume111115;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection19 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111116 = composerStartRestartGroup.consume(localLayoutDirection19);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection19 = (LayoutDirection) objConsume111116;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration19 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111117 = composerStartRestartGroup.consume(localViewConfiguration19);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration19 = (ViewConfiguration) objConsume111117;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf19 = LayoutKt.materializerOf(modifierPadding19);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl19 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl19, measurePolicyRowMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl19, density19, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl19, layoutDirection19, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl19, viewConfiguration19, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf19.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance19 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1111 = 6;
                        final boolean z113 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1112) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1112 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z113) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance19;
                                    final int i1113 = i1111;
                                    final int i1114 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i1115) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i1115 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1113 & 14) | ((i1114 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues112;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1112) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues113 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding110 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues113);
                        Alignment.Vertical centerVertically110 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically110, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111118 = composerStartRestartGroup.consume(localDensity110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density110 = (Density) objConsume111118;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection110 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111119 = composerStartRestartGroup.consume(localLayoutDirection110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection110 = (LayoutDirection) objConsume111119;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration110 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111110 = composerStartRestartGroup.consume(localViewConfiguration110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration110 = (ViewConfiguration) objConsume1111110;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf110 = LayoutKt.materializerOf(modifierPadding110);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl110, measurePolicyRowMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl110, density110, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl110, layoutDirection110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl110, viewConfiguration110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance110 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1112 = 6;
                        final boolean z114 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1113) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1113 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z114) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance110;
                                    final int i1114 = i1112;
                                    final int i1115 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i1116) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i1116 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1114 & 14) | ((i1115 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues113;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues114 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding111 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues114);
                        Alignment.Vertical centerVertically111 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111 = composerStartRestartGroup.consume(localDensity111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density111 = (Density) objConsume1111111;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111112 = composerStartRestartGroup.consume(localLayoutDirection111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection111 = (LayoutDirection) objConsume1111112;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111113 = composerStartRestartGroup.consume(localViewConfiguration111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration111 = (ViewConfiguration) objConsume1111113;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111 = LayoutKt.materializerOf(modifierPadding111);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl111, measurePolicyRowMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl111, density111, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl111, layoutDirection111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl111, viewConfiguration111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance111 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1113 = 6;
                        final boolean z115 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1114) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1114 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z115) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance111;
                                    final int i1115 = i1113;
                                    final int i1116 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i1117) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i1117 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1115 & 14) | ((i1116 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues114;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1114) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues115 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding112 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues115);
                    Alignment.Vertical centerVertically112 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically112, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111114 = composerStartRestartGroup.consume(localDensity112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density112 = (Density) objConsume1111114;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111115 = composerStartRestartGroup.consume(localLayoutDirection112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection112 = (LayoutDirection) objConsume1111115;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration112 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111116 = composerStartRestartGroup.consume(localViewConfiguration112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration112 = (ViewConfiguration) objConsume1111116;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf112 = LayoutKt.materializerOf(modifierPadding112);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl112, measurePolicyRowMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl112, density112, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl112, layoutDirection112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl112, viewConfiguration112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance112 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1114 = 6;
                    final boolean z116 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1115) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1115 & 11) != 2 || !composer2.getSkipping()) {
                                if (z116) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance112;
                                final int i1116 = i1114;
                                final int i1117 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1118) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1118 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i1116 & 14) | ((i1117 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues115;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues116 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding113 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues116);
                    Alignment.Vertical centerVertically113 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically113, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111117 = composerStartRestartGroup.consume(localDensity113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density113 = (Density) objConsume1111117;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection113 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111118 = composerStartRestartGroup.consume(localLayoutDirection113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection113 = (LayoutDirection) objConsume1111118;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration113 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111119 = composerStartRestartGroup.consume(localViewConfiguration113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration113 = (ViewConfiguration) objConsume1111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf113 = LayoutKt.materializerOf(modifierPadding113);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl113, measurePolicyRowMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl113, density113, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl113, layoutDirection113, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl113, viewConfiguration113, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf113.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance113 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1115 = 6;
                    final boolean z117 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1116) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1116 & 11) != 2 || !composer2.getSkipping()) {
                                if (z117) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance113;
                                final int i1117 = i1115;
                                final int i1118 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1119) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1119 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i1117 & 14) | ((i1118 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues116;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1116) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues117 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding114 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues117);
                        Alignment.Vertical centerVertically114 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically114, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111110 = composerStartRestartGroup.consume(localDensity114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density114 = (Density) objConsume11111110;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection114 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111 = composerStartRestartGroup.consume(localLayoutDirection114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection114 = (LayoutDirection) objConsume11111111;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration114 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111112 = composerStartRestartGroup.consume(localViewConfiguration114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration114 = (ViewConfiguration) objConsume11111112;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf114 = LayoutKt.materializerOf(modifierPadding114);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl114, measurePolicyRowMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl114, density114, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl114, layoutDirection114, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl114, viewConfiguration114, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf114.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance114 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1116 = 6;
                        final boolean z118 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1117) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1117 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z118) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance114;
                                    final int i1118 = i1116;
                                    final int i1119 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i11110) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i11110 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1118 & 14) | ((i1119 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues117;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues118 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding115 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues118);
                        Alignment.Vertical centerVertically115 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically115, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111113 = composerStartRestartGroup.consume(localDensity115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density115 = (Density) objConsume11111113;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection115 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111114 = composerStartRestartGroup.consume(localLayoutDirection115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection115 = (LayoutDirection) objConsume11111114;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration115 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111115 = composerStartRestartGroup.consume(localViewConfiguration115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration115 = (ViewConfiguration) objConsume11111115;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf115 = LayoutKt.materializerOf(modifierPadding115);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl115, measurePolicyRowMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl115, density115, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl115, layoutDirection115, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl115, viewConfiguration115, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf115.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance115 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1117 = 6;
                        final boolean z119 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1118) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1118 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z119) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance115;
                                    final int i1119 = i1117;
                                    final int i11110 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i11111) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i11111 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1119 & 14) | ((i11110 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues118;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1118) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues119 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding116 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues119);
                    Alignment.Vertical centerVertically116 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically116, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111116 = composerStartRestartGroup.consume(localDensity116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density116 = (Density) objConsume11111116;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection116 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111117 = composerStartRestartGroup.consume(localLayoutDirection116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection116 = (LayoutDirection) objConsume11111117;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration116 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111118 = composerStartRestartGroup.consume(localViewConfiguration116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration116 = (ViewConfiguration) objConsume11111118;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf116 = LayoutKt.materializerOf(modifierPadding116);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl116, measurePolicyRowMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl116, density116, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl116, layoutDirection116, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl116, viewConfiguration116, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf116.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance116 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1118 = 6;
                    final boolean z1110 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1119) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1119 & 11) != 2 || !composer2.getSkipping()) {
                                if (z1110) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance116;
                                final int i11110 = i1118;
                                final int i11111 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11112) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i11112 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i11110 & 14) | ((i11111 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues119;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues1110 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding117 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1110);
                    Alignment.Vertical centerVertically117 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically117, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111119 = composerStartRestartGroup.consume(localDensity117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density117 = (Density) objConsume11111119;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection117 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111110 = composerStartRestartGroup.consume(localLayoutDirection117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection117 = (LayoutDirection) objConsume111111110;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration117 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111 = composerStartRestartGroup.consume(localViewConfiguration117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration117 = (ViewConfiguration) objConsume111111111;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf117 = LayoutKt.materializerOf(modifierPadding117);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl117, measurePolicyRowMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl117, density117, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl117, layoutDirection117, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl117, viewConfiguration117, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf117.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance117 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1119 = 6;
                    final boolean z1111 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11110) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i11110 & 11) != 2 || !composer2.getSkipping()) {
                                if (z1111) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance117;
                                final int i11111 = i1119;
                                final int i11112 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11113) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i11113 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i11111 & 14) | ((i11112 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues1110;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11110) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues1111 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding118 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111);
                    Alignment.Vertical centerVertically118 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically118, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111112 = composerStartRestartGroup.consume(localDensity118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density118 = (Density) objConsume111111112;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection118 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111113 = composerStartRestartGroup.consume(localLayoutDirection118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection118 = (LayoutDirection) objConsume111111113;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration118 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111114 = composerStartRestartGroup.consume(localViewConfiguration118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration118 = (ViewConfiguration) objConsume111111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf118 = LayoutKt.materializerOf(modifierPadding118);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl118, measurePolicyRowMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl118, density118, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl118, layoutDirection118, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl118, viewConfiguration118, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf118.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance118 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i11110 = 6;
                    final boolean z1112 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11111) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i11111 & 11) != 2 || !composer2.getSkipping()) {
                                if (z1112) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance118;
                                final int i11112 = i11110;
                                final int i11113 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11114) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i11114 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i11112 & 14) | ((i11113 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues1111;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues1112 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding119 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1112);
                    Alignment.Vertical centerVertically119 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically119, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111115 = composerStartRestartGroup.consume(localDensity119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density119 = (Density) objConsume111111115;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection119 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111116 = composerStartRestartGroup.consume(localLayoutDirection119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection119 = (LayoutDirection) objConsume111111116;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration119 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111117 = composerStartRestartGroup.consume(localViewConfiguration119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration119 = (ViewConfiguration) objConsume111111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf119 = LayoutKt.materializerOf(modifierPadding119);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl119, measurePolicyRowMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl119, density119, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl119, layoutDirection119, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl119, viewConfiguration119, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf119.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance119 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i11111 = 6;
                    final boolean z1113 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11112) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i11112 & 11) != 2 || !composer2.getSkipping()) {
                                if (z1113) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance119;
                                final int i11113 = i11111;
                                final int i11114 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11115) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i11115 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i11113 & 14) | ((i11114 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues1112;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11112) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues1113 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1110 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1113);
                Alignment.Vertical centerVertically1110 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy1110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1110, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111118 = composerStartRestartGroup.consume(localDensity1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density1110 = (Density) objConsume111111118;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1110 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111119 = composerStartRestartGroup.consume(localLayoutDirection1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection1110 = (LayoutDirection) objConsume111111119;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1110 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111110 = composerStartRestartGroup.consume(localViewConfiguration1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration1110 = (ViewConfiguration) objConsume1111111110;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1110 = LayoutKt.materializerOf(modifierPadding1110);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl1110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1110, measurePolicyRowMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl1110, density1110, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl1110, layoutDirection1110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl1110, viewConfiguration1110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf1110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance1110 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i11112 = 6;
                final boolean z1114 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11113) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i11113 & 11) != 2 || !composer2.getSkipping()) {
                            if (z1114) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance1110;
                            final int i11114 = i11112;
                            final int i11115 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11116) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11116 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i11114 & 14) | ((i11115 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues1113;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues1114 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1111 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1114);
                Alignment.Vertical centerVertically1111 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy1111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111 = composerStartRestartGroup.consume(localDensity1111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density1111 = (Density) objConsume1111111111;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111112 = composerStartRestartGroup.consume(localLayoutDirection1111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection1111 = (LayoutDirection) objConsume1111111112;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111113 = composerStartRestartGroup.consume(localViewConfiguration1111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration1111 = (ViewConfiguration) objConsume1111111113;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111 = LayoutKt.materializerOf(modifierPadding1111);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl1111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111, measurePolicyRowMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl1111, density1111, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl1111, layoutDirection1111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl1111, viewConfiguration1111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf1111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance1111 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i11113 = 6;
                final boolean z1115 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11114) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i11114 & 11) != 2 || !composer2.getSkipping()) {
                            if (z1115) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance1111;
                            final int i11115 = i11113;
                            final int i11116 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11117) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11117 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i11115 & 14) | ((i11116 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues1114;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11114) {
                    MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues1115 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding1112 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1115);
                            Alignment.Vertical centerVertically1112 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy1112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1112, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity1112 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111114 = composerStartRestartGroup.consume(localDensity1112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density1112 = (Density) objConsume1111111114;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1112 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111115 = composerStartRestartGroup.consume(localLayoutDirection1112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection1112 = (LayoutDirection) objConsume1111111115;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1112 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111116 = composerStartRestartGroup.consume(localViewConfiguration1112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration1112 = (ViewConfiguration) objConsume1111111116;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1112 = LayoutKt.materializerOf(modifierPadding1112);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl1112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl1112, measurePolicyRowMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl1112, density1112, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl1112, layoutDirection1112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl1112, viewConfiguration1112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf1112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance1112 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i11114 = 6;
                            final boolean z1116 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i11115) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i11115 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z1116) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance1112;
                                        final int i11116 = i11114;
                                        final int i11117 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i11118) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i11118 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i11116 & 14) | ((i11117 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues1115;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            PaddingValues paddingValues1116 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding1113 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1116);
                            Alignment.Vertical centerVertically1113 = Alignment.INSTANCE.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy1113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1113, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity1113 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111117 = composerStartRestartGroup.consume(localDensity1113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density1113 = (Density) objConsume1111111117;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1113 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111118 = composerStartRestartGroup.consume(localLayoutDirection1113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection1113 = (LayoutDirection) objConsume1111111118;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1113 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111119 = composerStartRestartGroup.consume(localViewConfiguration1113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration1113 = (ViewConfiguration) objConsume1111111119;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1113 = LayoutKt.materializerOf(modifierPadding1113);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM1286constructorimpl1113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl1113, measurePolicyRowMeasurePolicy1113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl1113, density1113, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl1113, layoutDirection1113, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl1113, viewConfiguration1113, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf1113.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                            final RowScope rowScopeInstance1113 = RowScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1664959143);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                            final int i11115 = 6;
                            final boolean z1117 = z3;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i11116) {
                                    float disabled;
                                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                    if ((i11116 & 11) != 2 || !composer2.getSkipping()) {
                                        if (z1117) {
                                            composer2.startReplaceableGroup(-1945695285);
                                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                        } else {
                                            composer2.startReplaceableGroup(-1945695262);
                                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance1113;
                                        final int i11117 = i11115;
                                        final int i11118 = i11;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i11119) {
                                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                                if ((i11119 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                } else {
                                                    function3.invoke(rowScope, composer3, Integer.valueOf((i11117 & 14) | ((i11118 >> 12) & 112)));
                                                }
                                            }
                                        }), composer2, 56);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            paddingValues3 = paddingValues1116;
                            modifier2 = modifier3;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11116) {
                                MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues1117 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1114 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1117);
                        Alignment.Vertical centerVertically1114 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy1114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1114, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity1114 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111110 = composerStartRestartGroup.consume(localDensity1114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density1114 = (Density) objConsume11111111110;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1114 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111 = composerStartRestartGroup.consume(localLayoutDirection1114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection1114 = (LayoutDirection) objConsume11111111111;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1114 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111112 = composerStartRestartGroup.consume(localViewConfiguration1114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration1114 = (ViewConfiguration) objConsume11111111112;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1114 = LayoutKt.materializerOf(modifierPadding1114);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl1114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1114, measurePolicyRowMeasurePolicy1114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl1114, density1114, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl1114, layoutDirection1114, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl1114, viewConfiguration1114, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf1114.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance1114 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i11116 = 6;
                        final boolean z1118 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11117) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i11117 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z1118) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance1114;
                                    final int i11118 = i11116;
                                    final int i11119 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i111110) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i111110 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i11118 & 14) | ((i11119 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues1117;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues1118 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1115 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1118);
                        Alignment.Vertical centerVertically1115 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy1115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1115, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity1115 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111113 = composerStartRestartGroup.consume(localDensity1115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density1115 = (Density) objConsume11111111113;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1115 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111114 = composerStartRestartGroup.consume(localLayoutDirection1115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection1115 = (LayoutDirection) objConsume11111111114;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1115 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111115 = composerStartRestartGroup.consume(localViewConfiguration1115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration1115 = (ViewConfiguration) objConsume11111111115;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1115 = LayoutKt.materializerOf(modifierPadding1115);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl1115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1115, measurePolicyRowMeasurePolicy1115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl1115, density1115, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl1115, layoutDirection1115, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl1115, viewConfiguration1115, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf1115.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance1115 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i11117 = 6;
                        final boolean z1119 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11118) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i11118 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z1119) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance1115;
                                    final int i11119 = i11117;
                                    final int i111110 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i111111) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i111111 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i11119 & 14) | ((i111110 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues1118;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11118) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues1119 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1116 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1119);
                        Alignment.Vertical centerVertically1116 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy1116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1116, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity1116 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111116 = composerStartRestartGroup.consume(localDensity1116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density1116 = (Density) objConsume11111111116;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1116 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111117 = composerStartRestartGroup.consume(localLayoutDirection1116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection1116 = (LayoutDirection) objConsume11111111117;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1116 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111118 = composerStartRestartGroup.consume(localViewConfiguration1116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration1116 = (ViewConfiguration) objConsume11111111118;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1116 = LayoutKt.materializerOf(modifierPadding1116);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl1116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1116, measurePolicyRowMeasurePolicy1116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl1116, density1116, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl1116, layoutDirection1116, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl1116, viewConfiguration1116, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf1116.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance1116 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i11118 = 6;
                        final boolean z11110 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11119) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i11119 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z11110) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance1116;
                                    final int i111110 = i11118;
                                    final int i111111 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i111112) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i111112 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i111110 & 14) | ((i111111 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues1119;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues11110 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1117 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11110);
                        Alignment.Vertical centerVertically1117 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy1117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1117, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity1117 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111119 = composerStartRestartGroup.consume(localDensity1117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density1117 = (Density) objConsume11111111119;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1117 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111110 = composerStartRestartGroup.consume(localLayoutDirection1117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection1117 = (LayoutDirection) objConsume111111111110;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1117 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111 = composerStartRestartGroup.consume(localViewConfiguration1117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration1117 = (ViewConfiguration) objConsume111111111111;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1117 = LayoutKt.materializerOf(modifierPadding1117);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl1117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1117, measurePolicyRowMeasurePolicy1117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl1117, density1117, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl1117, layoutDirection1117, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl1117, viewConfiguration1117, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf1117.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance1117 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i11119 = 6;
                        final boolean z11111 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111110) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i111110 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z11111) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance1117;
                                    final int i111111 = i11119;
                                    final int i111112 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i111113) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i111113 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i111111 & 14) | ((i111112 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues11110;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111110) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues11111 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding1118 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11111);
                    Alignment.Vertical centerVertically1118 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy1118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1118, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity1118 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111112 = composerStartRestartGroup.consume(localDensity1118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density1118 = (Density) objConsume111111111112;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1118 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111113 = composerStartRestartGroup.consume(localLayoutDirection1118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection1118 = (LayoutDirection) objConsume111111111113;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1118 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111114 = composerStartRestartGroup.consume(localViewConfiguration1118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration1118 = (ViewConfiguration) objConsume111111111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1118 = LayoutKt.materializerOf(modifierPadding1118);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl1118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl1118, measurePolicyRowMeasurePolicy1118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl1118, density1118, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl1118, layoutDirection1118, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl1118, viewConfiguration1118, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf1118.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance1118 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i111110 = 6;
                    final boolean z11112 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111111) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i111111 & 11) != 2 || !composer2.getSkipping()) {
                                if (z11112) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance1118;
                                final int i111112 = i111110;
                                final int i111113 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i111114) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i111114 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i111112 & 14) | ((i111113 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues11111;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues11112 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding1119 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11112);
                    Alignment.Vertical centerVertically1119 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy1119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1119, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity1119 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111115 = composerStartRestartGroup.consume(localDensity1119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density1119 = (Density) objConsume111111111115;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1119 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111116 = composerStartRestartGroup.consume(localLayoutDirection1119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection1119 = (LayoutDirection) objConsume111111111116;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1119 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111117 = composerStartRestartGroup.consume(localViewConfiguration1119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration1119 = (ViewConfiguration) objConsume111111111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1119 = LayoutKt.materializerOf(modifierPadding1119);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl1119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl1119, measurePolicyRowMeasurePolicy1119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl1119, density1119, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl1119, layoutDirection1119, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl1119, viewConfiguration1119, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf1119.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance1119 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i111111 = 6;
                    final boolean z11113 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111112) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i111112 & 11) != 2 || !composer2.getSkipping()) {
                                if (z11113) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance1119;
                                final int i111113 = i111111;
                                final int i111114 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i111115) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i111115 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i111113 & 14) | ((i111114 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues11112;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111112) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues11113 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11110 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11113);
                        Alignment.Vertical centerVertically11110 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy11110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11110, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity11110 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111118 = composerStartRestartGroup.consume(localDensity11110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density11110 = (Density) objConsume111111111118;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11110 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111119 = composerStartRestartGroup.consume(localLayoutDirection11110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection11110 = (LayoutDirection) objConsume111111111119;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11110 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111110 = composerStartRestartGroup.consume(localViewConfiguration11110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration11110 = (ViewConfiguration) objConsume1111111111110;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11110 = LayoutKt.materializerOf(modifierPadding11110);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl11110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11110, measurePolicyRowMeasurePolicy11110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl11110, density11110, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl11110, layoutDirection11110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl11110, viewConfiguration11110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf11110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance11110 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i111112 = 6;
                        final boolean z11114 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111113) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i111113 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z11114) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance11110;
                                    final int i111114 = i111112;
                                    final int i111115 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i111116) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i111116 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i111114 & 14) | ((i111115 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues11113;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues11114 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11111 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11114);
                        Alignment.Vertical centerVertically11111 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy11111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11111, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity11111 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111111 = composerStartRestartGroup.consume(localDensity11111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density11111 = (Density) objConsume1111111111111;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11111 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111112 = composerStartRestartGroup.consume(localLayoutDirection11111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection11111 = (LayoutDirection) objConsume1111111111112;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11111 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111113 = composerStartRestartGroup.consume(localViewConfiguration11111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration11111 = (ViewConfiguration) objConsume1111111111113;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11111 = LayoutKt.materializerOf(modifierPadding11111);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl11111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11111, measurePolicyRowMeasurePolicy11111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl11111, density11111, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl11111, layoutDirection11111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl11111, viewConfiguration11111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf11111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance11111 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i111113 = 6;
                        final boolean z11115 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111114) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i111114 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z11115) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance11111;
                                    final int i111115 = i111113;
                                    final int i111116 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i111117) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i111117 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i111115 & 14) | ((i111116 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues11114;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111114) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues11115 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11112 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11115);
                    Alignment.Vertical centerVertically11112 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy11112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11112, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity11112 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111114 = composerStartRestartGroup.consume(localDensity11112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11112 = (Density) objConsume1111111111114;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111115 = composerStartRestartGroup.consume(localLayoutDirection11112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection11112 = (LayoutDirection) objConsume1111111111115;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11112 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111116 = composerStartRestartGroup.consume(localViewConfiguration11112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration11112 = (ViewConfiguration) objConsume1111111111116;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11112 = LayoutKt.materializerOf(modifierPadding11112);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl11112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11112, measurePolicyRowMeasurePolicy11112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl11112, density11112, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl11112, layoutDirection11112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl11112, viewConfiguration11112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf11112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance11112 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i111114 = 6;
                    final boolean z11116 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111115) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i111115 & 11) != 2 || !composer2.getSkipping()) {
                                if (z11116) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance11112;
                                final int i111116 = i111114;
                                final int i111117 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i111118) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i111118 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i111116 & 14) | ((i111117 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues11115;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues11116 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11113 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11116);
                    Alignment.Vertical centerVertically11113 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy11113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11113, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity11113 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111117 = composerStartRestartGroup.consume(localDensity11113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11113 = (Density) objConsume1111111111117;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11113 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111118 = composerStartRestartGroup.consume(localLayoutDirection11113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection11113 = (LayoutDirection) objConsume1111111111118;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11113 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111119 = composerStartRestartGroup.consume(localViewConfiguration11113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration11113 = (ViewConfiguration) objConsume1111111111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11113 = LayoutKt.materializerOf(modifierPadding11113);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl11113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11113, measurePolicyRowMeasurePolicy11113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl11113, density11113, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl11113, layoutDirection11113, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl11113, viewConfiguration11113, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf11113.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance11113 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i111115 = 6;
                    final boolean z11117 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111116) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i111116 & 11) != 2 || !composer2.getSkipping()) {
                                if (z11117) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance11113;
                                final int i111117 = i111115;
                                final int i111118 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i111119) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i111119 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i111117 & 14) | ((i111118 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues11116;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111116) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues11117 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11114 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11117);
                    Alignment.Vertical centerVertically11114 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy11114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11114, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity11114 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111110 = composerStartRestartGroup.consume(localDensity11114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11114 = (Density) objConsume11111111111110;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11114 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111111 = composerStartRestartGroup.consume(localLayoutDirection11114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection11114 = (LayoutDirection) objConsume11111111111111;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11114 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111112 = composerStartRestartGroup.consume(localViewConfiguration11114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration11114 = (ViewConfiguration) objConsume11111111111112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11114 = LayoutKt.materializerOf(modifierPadding11114);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl11114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11114, measurePolicyRowMeasurePolicy11114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl11114, density11114, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl11114, layoutDirection11114, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl11114, viewConfiguration11114, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf11114.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance11114 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i111116 = 6;
                    final boolean z11118 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111117) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i111117 & 11) != 2 || !composer2.getSkipping()) {
                                if (z11118) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance11114;
                                final int i111118 = i111116;
                                final int i111119 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111110) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111110 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i111118 & 14) | ((i111119 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues11117;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues11118 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11115 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11118);
                    Alignment.Vertical centerVertically11115 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy11115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11115, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity11115 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111113 = composerStartRestartGroup.consume(localDensity11115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11115 = (Density) objConsume11111111111113;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11115 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111114 = composerStartRestartGroup.consume(localLayoutDirection11115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection11115 = (LayoutDirection) objConsume11111111111114;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11115 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111115 = composerStartRestartGroup.consume(localViewConfiguration11115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration11115 = (ViewConfiguration) objConsume11111111111115;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11115 = LayoutKt.materializerOf(modifierPadding11115);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl11115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11115, measurePolicyRowMeasurePolicy11115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl11115, density11115, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl11115, layoutDirection11115, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl11115, viewConfiguration11115, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf11115.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance11115 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i111117 = 6;
                    final boolean z11119 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111118) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i111118 & 11) != 2 || !composer2.getSkipping()) {
                                if (z11119) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance11115;
                                final int i111119 = i111117;
                                final int i1111110 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111111) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111111 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i111119 & 14) | ((i1111110 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues11118;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111118) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues11119 = dropdownMenuItemContentPadding;
                Modifier modifierPadding11116 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11119);
                Alignment.Vertical centerVertically11116 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy11116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11116, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity11116 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111116 = composerStartRestartGroup.consume(localDensity11116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density11116 = (Density) objConsume11111111111116;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11116 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111117 = composerStartRestartGroup.consume(localLayoutDirection11116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection11116 = (LayoutDirection) objConsume11111111111117;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11116 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111118 = composerStartRestartGroup.consume(localViewConfiguration11116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration11116 = (ViewConfiguration) objConsume11111111111118;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11116 = LayoutKt.materializerOf(modifierPadding11116);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl11116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl11116, measurePolicyRowMeasurePolicy11116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl11116, density11116, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl11116, layoutDirection11116, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl11116, viewConfiguration11116, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf11116.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance11116 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i111118 = 6;
                final boolean z111110 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111119) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i111119 & 11) != 2 || !composer2.getSkipping()) {
                            if (z111110) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance11116;
                            final int i1111110 = i111118;
                            final int i1111111 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i1111112) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i1111112 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i1111110 & 14) | ((i1111111 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues11119;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues111110 = dropdownMenuItemContentPadding;
                Modifier modifierPadding11117 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111110);
                Alignment.Vertical centerVertically11117 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy11117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11117, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity11117 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111119 = composerStartRestartGroup.consume(localDensity11117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density11117 = (Density) objConsume11111111111119;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11117 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111110 = composerStartRestartGroup.consume(localLayoutDirection11117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection11117 = (LayoutDirection) objConsume111111111111110;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11117 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111 = composerStartRestartGroup.consume(localViewConfiguration11117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration11117 = (ViewConfiguration) objConsume111111111111111;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11117 = LayoutKt.materializerOf(modifierPadding11117);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl11117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl11117, measurePolicyRowMeasurePolicy11117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl11117, density11117, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl11117, layoutDirection11117, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl11117, viewConfiguration11117, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf11117.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance11117 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i111119 = 6;
                final boolean z111111 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111110) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i1111110 & 11) != 2 || !composer2.getSkipping()) {
                            if (z111111) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance11117;
                            final int i1111111 = i111119;
                            final int i1111112 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i1111113) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i1111113 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i1111111 & 14) | ((i1111112 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues111110;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i1111110) {
                    MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues111111 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11118 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111111);
                        Alignment.Vertical centerVertically11118 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy11118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11118, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity11118 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111112 = composerStartRestartGroup.consume(localDensity11118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density11118 = (Density) objConsume111111111111112;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11118 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111113 = composerStartRestartGroup.consume(localLayoutDirection11118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection11118 = (LayoutDirection) objConsume111111111111113;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11118 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111114 = composerStartRestartGroup.consume(localViewConfiguration11118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration11118 = (ViewConfiguration) objConsume111111111111114;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11118 = LayoutKt.materializerOf(modifierPadding11118);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl11118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11118, measurePolicyRowMeasurePolicy11118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl11118, density11118, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl11118, layoutDirection11118, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl11118, viewConfiguration11118, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf11118.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance11118 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1111110 = 6;
                        final boolean z111112 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1111111) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1111111 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z111112) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance11118;
                                    final int i1111112 = i1111110;
                                    final int i1111113 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i1111114) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i1111114 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1111112 & 14) | ((i1111113 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues111111;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        PaddingValues paddingValues111112 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11119 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111112);
                        Alignment.Vertical centerVertically11119 = Alignment.INSTANCE.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy11119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11119, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity11119 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111115 = composerStartRestartGroup.consume(localDensity11119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density11119 = (Density) objConsume111111111111115;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11119 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111116 = composerStartRestartGroup.consume(localLayoutDirection11119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection11119 = (LayoutDirection) objConsume111111111111116;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11119 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111117 = composerStartRestartGroup.consume(localViewConfiguration11119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration11119 = (ViewConfiguration) objConsume111111111111117;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11119 = LayoutKt.materializerOf(modifierPadding11119);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM1286constructorimpl11119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11119, measurePolicyRowMeasurePolicy11119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl11119, density11119, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl11119, layoutDirection11119, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl11119, viewConfiguration11119, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf11119.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance11119 = RowScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1664959143);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                        final int i1111111 = 6;
                        final boolean z111113 = z3;
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i1111112) {
                                float disabled;
                                ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                                if ((i1111112 & 11) != 2 || !composer2.getSkipping()) {
                                    if (z111113) {
                                        composer2.startReplaceableGroup(-1945695285);
                                        ComposerKt.sourceInformation(composer2, "164@5913L4");
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                    } else {
                                        composer2.startReplaceableGroup(-1945695262);
                                        ComposerKt.sourceInformation(composer2, "164@5936L8");
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance11119;
                                    final int i1111113 = i1111111;
                                    final int i1111114 = i11;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i1111115) {
                                            ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                            if ((i1111115 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                function3.invoke(rowScope, composer3, Integer.valueOf((i1111113 & 14) | ((i1111114 >> 12) & 112)));
                                            }
                                        }
                                    }), composer2, 56);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        paddingValues3 = paddingValues111112;
                        modifier2 = modifier3;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111112) {
                            MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues111113 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111110 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111113);
                    Alignment.Vertical centerVertically111110 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111110, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111110 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111118 = composerStartRestartGroup.consume(localDensity111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111110 = (Density) objConsume111111111111118;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111110 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111119 = composerStartRestartGroup.consume(localLayoutDirection111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111110 = (LayoutDirection) objConsume111111111111119;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111110 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111110 = composerStartRestartGroup.consume(localViewConfiguration111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111110 = (ViewConfiguration) objConsume1111111111111110;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111110 = LayoutKt.materializerOf(modifierPadding111110);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl111110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111110, measurePolicyRowMeasurePolicy111110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111110, density111110, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111110, layoutDirection111110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111110, viewConfiguration111110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance111110 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1111112 = 6;
                    final boolean z111114 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111113) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1111113 & 11) != 2 || !composer2.getSkipping()) {
                                if (z111114) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance111110;
                                final int i1111114 = i1111112;
                                final int i1111115 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111116) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111116 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i1111114 & 14) | ((i1111115 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues111113;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues111114 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111111 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111114);
                    Alignment.Vertical centerVertically111111 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111111, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111111 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111111 = composerStartRestartGroup.consume(localDensity111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111111 = (Density) objConsume1111111111111111;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111111 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111112 = composerStartRestartGroup.consume(localLayoutDirection111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111111 = (LayoutDirection) objConsume1111111111111112;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111111 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111113 = composerStartRestartGroup.consume(localViewConfiguration111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111111 = (ViewConfiguration) objConsume1111111111111113;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111111 = LayoutKt.materializerOf(modifierPadding111111);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl111111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111111, measurePolicyRowMeasurePolicy111111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111111, density111111, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111111, layoutDirection111111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111111, viewConfiguration111111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance111111 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1111113 = 6;
                    final boolean z111115 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111114) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1111114 & 11) != 2 || !composer2.getSkipping()) {
                                if (z111115) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance111111;
                                final int i1111115 = i1111113;
                                final int i1111116 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111117) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111117 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i1111115 & 14) | ((i1111116 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues111114;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111114) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues111115 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111112 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111115);
                    Alignment.Vertical centerVertically111112 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111112, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111112 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111114 = composerStartRestartGroup.consume(localDensity111112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111112 = (Density) objConsume1111111111111114;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111115 = composerStartRestartGroup.consume(localLayoutDirection111112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111112 = (LayoutDirection) objConsume1111111111111115;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111112 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111116 = composerStartRestartGroup.consume(localViewConfiguration111112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111112 = (ViewConfiguration) objConsume1111111111111116;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111112 = LayoutKt.materializerOf(modifierPadding111112);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl111112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111112, measurePolicyRowMeasurePolicy111112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111112, density111112, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111112, layoutDirection111112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111112, viewConfiguration111112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance111112 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1111114 = 6;
                    final boolean z111116 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111115) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1111115 & 11) != 2 || !composer2.getSkipping()) {
                                if (z111116) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance111112;
                                final int i1111116 = i1111114;
                                final int i1111117 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111118) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111118 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i1111116 & 14) | ((i1111117 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues111115;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues111116 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111113 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111116);
                    Alignment.Vertical centerVertically111113 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111113, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111113 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111117 = composerStartRestartGroup.consume(localDensity111113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111113 = (Density) objConsume1111111111111117;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111113 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111118 = composerStartRestartGroup.consume(localLayoutDirection111113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111113 = (LayoutDirection) objConsume1111111111111118;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111113 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111119 = composerStartRestartGroup.consume(localViewConfiguration111113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111113 = (ViewConfiguration) objConsume1111111111111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111113 = LayoutKt.materializerOf(modifierPadding111113);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl111113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111113, measurePolicyRowMeasurePolicy111113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111113, density111113, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111113, layoutDirection111113, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111113, viewConfiguration111113, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111113.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance111113 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1111115 = 6;
                    final boolean z111117 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111116) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1111116 & 11) != 2 || !composer2.getSkipping()) {
                                if (z111117) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance111113;
                                final int i1111117 = i1111115;
                                final int i1111118 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i1111119) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i1111119 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i1111117 & 14) | ((i1111118 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues111116;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111116) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues111117 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111114 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111117);
                Alignment.Vertical centerVertically111114 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy111114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111114, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity111114 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111110 = composerStartRestartGroup.consume(localDensity111114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density111114 = (Density) objConsume11111111111111110;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111114 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111111 = composerStartRestartGroup.consume(localLayoutDirection111114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection111114 = (LayoutDirection) objConsume11111111111111111;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111114 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111112 = composerStartRestartGroup.consume(localViewConfiguration111114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration111114 = (ViewConfiguration) objConsume11111111111111112;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111114 = LayoutKt.materializerOf(modifierPadding111114);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl111114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111114, measurePolicyRowMeasurePolicy111114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl111114, density111114, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl111114, layoutDirection111114, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl111114, viewConfiguration111114, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf111114.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance111114 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i1111116 = 6;
                final boolean z111118 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111117) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i1111117 & 11) != 2 || !composer2.getSkipping()) {
                            if (z111118) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance111114;
                            final int i1111118 = i1111116;
                            final int i1111119 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11111110) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11111110 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i1111118 & 14) | ((i1111119 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues111117;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues111118 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111115 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111118);
                Alignment.Vertical centerVertically111115 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy111115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111115, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity111115 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111113 = composerStartRestartGroup.consume(localDensity111115);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density111115 = (Density) objConsume11111111111111113;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111115 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111114 = composerStartRestartGroup.consume(localLayoutDirection111115);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection111115 = (LayoutDirection) objConsume11111111111111114;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111115 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111115 = composerStartRestartGroup.consume(localViewConfiguration111115);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration111115 = (ViewConfiguration) objConsume11111111111111115;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111115 = LayoutKt.materializerOf(modifierPadding111115);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl111115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111115, measurePolicyRowMeasurePolicy111115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl111115, density111115, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl111115, layoutDirection111115, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl111115, viewConfiguration111115, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf111115.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance111115 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i1111117 = 6;
                final boolean z111119 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111118) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i1111118 & 11) != 2 || !composer2.getSkipping()) {
                            if (z111119) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance111115;
                            final int i1111119 = i1111117;
                            final int i11111110 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11111111) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11111111 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i1111119 & 14) | ((i11111110 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues111118;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i1111118) {
                    MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues111119 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111116 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111119);
                    Alignment.Vertical centerVertically111116 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111116, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111116 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111111116 = composerStartRestartGroup.consume(localDensity111116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111116 = (Density) objConsume11111111111111116;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111116 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111111117 = composerStartRestartGroup.consume(localLayoutDirection111116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111116 = (LayoutDirection) objConsume11111111111111117;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111116 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111111118 = composerStartRestartGroup.consume(localViewConfiguration111116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111116 = (ViewConfiguration) objConsume11111111111111118;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111116 = LayoutKt.materializerOf(modifierPadding111116);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl111116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111116, measurePolicyRowMeasurePolicy111116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111116, density111116, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111116, layoutDirection111116, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111116, viewConfiguration111116, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111116.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance111116 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1111118 = 6;
                    final boolean z1111110 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111119) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i1111119 & 11) != 2 || !composer2.getSkipping()) {
                                if (z1111110) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance111116;
                                final int i11111110 = i1111118;
                                final int i11111111 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11111112) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i11111112 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i11111110 & 14) | ((i11111111 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues111119;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    PaddingValues paddingValues1111110 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111117 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111110);
                    Alignment.Vertical centerVertically111117 = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111117, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111117 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111111119 = composerStartRestartGroup.consume(localDensity111117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111117 = (Density) objConsume11111111111111119;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111117 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111111110 = composerStartRestartGroup.consume(localLayoutDirection111117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111117 = (LayoutDirection) objConsume111111111111111110;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111117 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111111111 = composerStartRestartGroup.consume(localViewConfiguration111117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111117 = (ViewConfiguration) objConsume111111111111111111;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111117 = LayoutKt.materializerOf(modifierPadding111117);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1286constructorimpl111117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111117, measurePolicyRowMeasurePolicy111117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111117, density111117, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111117, layoutDirection111117, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111117, viewConfiguration111117, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111117.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance111117 = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1664959143);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                    final int i1111119 = 6;
                    final boolean z1111111 = z3;
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11111110) {
                            float disabled;
                            ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                            if ((i11111110 & 11) != 2 || !composer2.getSkipping()) {
                                if (z1111111) {
                                    composer2.startReplaceableGroup(-1945695285);
                                    ComposerKt.sourceInformation(composer2, "164@5913L4");
                                    disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                                } else {
                                    composer2.startReplaceableGroup(-1945695262);
                                    ComposerKt.sourceInformation(composer2, "164@5936L8");
                                    disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final RowScope rowScope = rowScopeInstance111117;
                                final int i11111111 = i1111119;
                                final int i11111112 = i11;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11111113) {
                                        ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                        if ((i11111113 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            function3.invoke(rowScope, composer3, Integer.valueOf((i11111111 & 14) | ((i11111112 >> 12) & 112)));
                                        }
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    paddingValues3 = paddingValues1111110;
                    modifier2 = modifier3;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111110) {
                        MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues1111111 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111118 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111111);
                Alignment.Vertical centerVertically111118 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy111118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111118, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity111118 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111112 = composerStartRestartGroup.consume(localDensity111118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density111118 = (Density) objConsume111111111111111112;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111118 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111113 = composerStartRestartGroup.consume(localLayoutDirection111118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection111118 = (LayoutDirection) objConsume111111111111111113;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111118 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111114 = composerStartRestartGroup.consume(localViewConfiguration111118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration111118 = (ViewConfiguration) objConsume111111111111111114;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111118 = LayoutKt.materializerOf(modifierPadding111118);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl111118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111118, measurePolicyRowMeasurePolicy111118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl111118, density111118, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl111118, layoutDirection111118, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl111118, viewConfiguration111118, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf111118.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance111118 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i11111110 = 6;
                final boolean z1111112 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111111) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i11111111 & 11) != 2 || !composer2.getSkipping()) {
                            if (z1111112) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance111118;
                            final int i11111112 = i11111110;
                            final int i11111113 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11111114) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11111114 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i11111112 & 14) | ((i11111113 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues1111111;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues1111112 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111119 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111112);
                Alignment.Vertical centerVertically111119 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy111119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111119, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity111119 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111115 = composerStartRestartGroup.consume(localDensity111119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density111119 = (Density) objConsume111111111111111115;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111119 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111116 = composerStartRestartGroup.consume(localLayoutDirection111119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection111119 = (LayoutDirection) objConsume111111111111111116;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111119 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111117 = composerStartRestartGroup.consume(localViewConfiguration111119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration111119 = (ViewConfiguration) objConsume111111111111111117;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111119 = LayoutKt.materializerOf(modifierPadding111119);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl111119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111119, measurePolicyRowMeasurePolicy111119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl111119, density111119, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl111119, layoutDirection111119, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl111119, viewConfiguration111119, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf111119.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance111119 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i11111111 = 6;
                final boolean z1111113 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111112) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i11111112 & 11) != 2 || !composer2.getSkipping()) {
                            if (z1111113) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance111119;
                            final int i11111113 = i11111111;
                            final int i11111114 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11111115) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11111115 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i11111113 & 14) | ((i11111114 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues1111112;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111112) {
                    MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
            }
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues1111113 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1111110 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111113);
                Alignment.Vertical centerVertically1111110 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy1111110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111110, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity1111110 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111118 = composerStartRestartGroup.consume(localDensity1111110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density1111110 = (Density) objConsume111111111111111118;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111110 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111119 = composerStartRestartGroup.consume(localLayoutDirection1111110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection1111110 = (LayoutDirection) objConsume111111111111111119;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111110 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111111111110 = composerStartRestartGroup.consume(localViewConfiguration1111110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration1111110 = (ViewConfiguration) objConsume1111111111111111110;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111110 = LayoutKt.materializerOf(modifierPadding1111110);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl1111110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111110, measurePolicyRowMeasurePolicy1111110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl1111110, density1111110, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl1111110, layoutDirection1111110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl1111110, viewConfiguration1111110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf1111110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance1111110 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i11111112 = 6;
                final boolean z1111114 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111113) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i11111113 & 11) != 2 || !composer2.getSkipping()) {
                            if (z1111114) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance1111110;
                            final int i11111114 = i11111112;
                            final int i11111115 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11111116) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11111116 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i11111114 & 14) | ((i11111115 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues1111113;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                PaddingValues paddingValues1111114 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1111111 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111114);
                Alignment.Vertical centerVertically1111111 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy1111111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111111, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity1111111 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111111111111 = composerStartRestartGroup.consume(localDensity1111111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density1111111 = (Density) objConsume1111111111111111111;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111111 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111111111112 = composerStartRestartGroup.consume(localLayoutDirection1111111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection1111111 = (LayoutDirection) objConsume1111111111111111112;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111111 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111111111113 = composerStartRestartGroup.consume(localViewConfiguration1111111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration1111111 = (ViewConfiguration) objConsume1111111111111111113;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111111 = LayoutKt.materializerOf(modifierPadding1111111);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl1111111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111111, measurePolicyRowMeasurePolicy1111111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl1111111, density1111111, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl1111111, layoutDirection1111111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl1111111, viewConfiguration1111111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf1111111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance1111111 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1664959143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
                final int i11111113 = 6;
                final boolean z1111115 = z3;
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111114) {
                        float disabled;
                        ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                        if ((i11111114 & 11) != 2 || !composer2.getSkipping()) {
                            if (z1111115) {
                                composer2.startReplaceableGroup(-1945695285);
                                ComposerKt.sourceInformation(composer2, "164@5913L4");
                                disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                            } else {
                                composer2.startReplaceableGroup(-1945695262);
                                ComposerKt.sourceInformation(composer2, "164@5936L8");
                                disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final RowScope rowScope = rowScopeInstance1111111;
                            final int i11111115 = i11111113;
                            final int i11111116 = i11;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11111117) {
                                    ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                    if ((i11111117 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function3.invoke(rowScope, composer3, Integer.valueOf((i11111115 & 14) | ((i11111116 >> 12) & 112)));
                                    }
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                paddingValues3 = paddingValues1111114;
                modifier2 = modifier3;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111114) {
                    MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
                }
            });
        }
        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i10;
        i11 = i3;
        if ((374491 & i11) == 74898) {
            if (i12 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            } else {
                dropdownMenuItemContentPadding = paddingValues2;
            }
            if (i8 != 0) {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
            } else {
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            PaddingValues paddingValues1111115 = dropdownMenuItemContentPadding;
            Modifier modifierPadding1111112 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111115);
            Alignment.Vertical centerVertically1111112 = Alignment.INSTANCE.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy1111112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111112, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1111112 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111114 = composerStartRestartGroup.consume(localDensity1111112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density1111112 = (Density) objConsume1111111111111111114;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111112 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111115 = composerStartRestartGroup.consume(localLayoutDirection1111112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection1111112 = (LayoutDirection) objConsume1111111111111111115;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111112 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111116 = composerStartRestartGroup.consume(localViewConfiguration1111112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration1111112 = (ViewConfiguration) objConsume1111111111111111116;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111112 = LayoutKt.materializerOf(modifierPadding1111112);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1286constructorimpl1111112 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl1111112, measurePolicyRowMeasurePolicy1111112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl1111112, density1111112, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl1111112, layoutDirection1111112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl1111112, viewConfiguration1111112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf1111112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
            final RowScope rowScopeInstance1111112 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1664959143);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
            final int i11111114 = 6;
            final boolean z1111116 = z3;
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111115) {
                    float disabled;
                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                    if ((i11111115 & 11) != 2 || !composer2.getSkipping()) {
                        if (z1111116) {
                            composer2.startReplaceableGroup(-1945695285);
                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                        } else {
                            composer2.startReplaceableGroup(-1945695262);
                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                        final RowScope rowScope = rowScopeInstance1111112;
                        final int i11111116 = i11111114;
                        final int i11111117 = i11;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11111118) {
                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                if ((i11111118 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    function3.invoke(rowScope, composer3, Integer.valueOf((i11111116 & 14) | ((i11111117 >> 12) & 112)));
                                }
                            }
                        }), composer2, 56);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 48);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            paddingValues3 = paddingValues1111115;
            modifier2 = modifier3;
            z4 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
        } else {
            if (i12 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            } else {
                dropdownMenuItemContentPadding = paddingValues2;
            }
            if (i8 != 0) {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
            } else {
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            PaddingValues paddingValues1111116 = dropdownMenuItemContentPadding;
            Modifier modifierPadding1111113 = PaddingKt.padding(SizeKt.m468sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m193clickableO2vRcR0$default(modifier3, mutableInteractionSource3, RippleKt.m1265rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z3, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111116);
            Alignment.Vertical centerVertically1111113 = Alignment.INSTANCE.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy1111113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111113, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1111113 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111117 = composerStartRestartGroup.consume(localDensity1111113);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density1111113 = (Density) objConsume1111111111111111117;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111113 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111118 = composerStartRestartGroup.consume(localLayoutDirection1111113);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection1111113 = (LayoutDirection) objConsume1111111111111111118;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111113 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111119 = composerStartRestartGroup.consume(localViewConfiguration1111113);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration1111113 = (ViewConfiguration) objConsume1111111111111111119;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111113 = LayoutKt.materializerOf(modifierPadding1111113);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1286constructorimpl1111113 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl1111113, measurePolicyRowMeasurePolicy1111113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl1111113, density1111113, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl1111113, layoutDirection1111113, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl1111113, viewConfiguration1111113, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf1111113.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C80@3988L9:Row.kt#2w3rfo");
            final RowScope rowScopeInstance1111113 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1664959143);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C162@5796L10,163@5815L259:Menu.kt#jmzs0o");
            final int i11111115 = 6;
            final boolean z1111117 = z3;
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111116) {
                    float disabled;
                    ComposerKt.sourceInformation(composer2, "C165@5957L107:Menu.kt#jmzs0o");
                    if ((i11111116 & 11) != 2 || !composer2.getSkipping()) {
                        if (z1111117) {
                            composer2.startReplaceableGroup(-1945695285);
                            ComposerKt.sourceInformation(composer2, "164@5913L4");
                            disabled = ContentAlpha.INSTANCE.getHigh(composer2, 6);
                        } else {
                            composer2.startReplaceableGroup(-1945695262);
                            ComposerKt.sourceInformation(composer2, "164@5936L8");
                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                        final RowScope rowScope = rowScopeInstance1111113;
                        final int i11111117 = i11111115;
                        final int i11111118 = i11;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11111119) {
                                ComposerKt.sourceInformation(composer3, "C166@6041L9:Menu.kt#jmzs0o");
                                if ((i11111119 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    function3.invoke(rowScope, composer3, Integer.valueOf((i11111117 & 14) | ((i11111118 >> 12) & 112)));
                                }
                            }
                        }), composer2, 56);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 48);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            paddingValues3 = paddingValues1111116;
            modifier2 = modifier3;
            z4 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i11111116) {
                MenuKt.DropdownMenuItemContent(onClick, modifier2, z4, paddingValues3, mutableInteractionSource4, content, composer2, i | 1, i2);
            }
        });
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d  */
    /* JADX WARN: Code duplicated, block: B:4:0x0017  */
    public static final long calculateTransformOrigin(IntRect parentBounds, IntRect menuBounds) {
        float fMax;
        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
        float fMax2 = 1.0f;
        if (menuBounds.getLeft() >= parentBounds.getRight()) {
            fMax = 0.0f;
        } else if (menuBounds.getRight() <= parentBounds.getLeft()) {
            fMax = 1.0f;
        } else if (menuBounds.getWidth() == 0) {
            fMax = 0.0f;
        } else {
            fMax = (((Math.max(parentBounds.getLeft(), menuBounds.getLeft()) + Math.min(parentBounds.getRight(), menuBounds.getRight())) / 2) - menuBounds.getLeft()) / menuBounds.getWidth();
        }
        if (menuBounds.getTop() >= parentBounds.getBottom()) {
            fMax2 = 0.0f;
        } else if (menuBounds.getBottom() > parentBounds.getTop()) {
            if (menuBounds.getHeight() == 0) {
                fMax2 = 0.0f;
            } else {
                fMax2 = (((Math.max(parentBounds.getTop(), menuBounds.getTop()) + Math.min(parentBounds.getBottom(), menuBounds.getBottom())) / 2) - menuBounds.getTop()) / menuBounds.getHeight();
            }
        }
        return TransformOriginKt.TransformOrigin(fMax, fMax2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DropdownMenuContent$lambda-1, reason: not valid java name */
    public static final float m1086DropdownMenuContent$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DropdownMenuContent$lambda-3, reason: not valid java name */
    public static final float m1087DropdownMenuContent$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static {
        float f = 8;
        MenuElevation = Dp.m3843constructorimpl(f);
        float f2 = 48;
        MenuVerticalMargin = Dp.m3843constructorimpl(f2);
        DropdownMenuVerticalPadding = Dp.m3843constructorimpl(f);
        DropdownMenuItemDefaultMinHeight = Dp.m3843constructorimpl(f2);
    }
}
