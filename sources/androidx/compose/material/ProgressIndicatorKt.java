package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.unity3d.services.UnityAdsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a;\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a3\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a9\u00100\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a9\u00108\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u00107\u001aA\u0010:\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a9\u0010=\u001a\u00020\u001f*\u0002012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010A\u001a)\u0010B\u001a\u00020\u001f*\u0002012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0013\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "backgroundColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", VastAttributes.STROKE_COLOR, "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m3843constructorimpl(240);
    private static final float CircularIndicatorDiameter = Dp.m3843constructorimpl(40);
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x011f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0127  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final void m1123LinearProgressIndicatoreaDK9VM(final float f, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long jM1630copywmQWz5c$default;
        final Modifier.Companion companion;
        final long jM979getPrimary0d7_KjU;
        boolean zChanged;
        Object objRememberedValue;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-850309746);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)74@3420L6,81@3655L175,77@3520L310:ProgressIndicator.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    int i5 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i3 |= i5;
                } else {
                    j3 = j;
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    jM1630copywmQWz5c$default = j2;
                    int i6 = composerStartRestartGroup.changed(jM1630copywmQWz5c$default) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
                i3 |= i6;
            } else {
                jM1630copywmQWz5c$default = j2;
            }
            if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j3;
                    }
                    if ((i2 & 8) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM979getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    jM979getPrimary0d7_KjU = j3;
                }
                composerStartRestartGroup.endDefaults();
                Modifier modifierM466sizeVpY3zN4 = SizeKt.m466sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(companion, f, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
                Color colorM1621boximpl = Color.m1621boximpl(jM1630copywmQWz5c$default);
                Float fValueOf = Float.valueOf(f);
                Color colorM1621boximpl2 = Color.m1621boximpl(jM979getPrimary0d7_KjU);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(colorM1621boximpl) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(colorM1621boximpl2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final long j5 = jM1630copywmQWz5c$default;
                    final long j6 = jM979getPrimary0d7_KjU;
                    objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope Canvas) {
                            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                            float fM1461getHeightimpl = Size.m1461getHeightimpl(Canvas.mo2125getSizeNHjbRc());
                            ProgressIndicatorKt.m1144drawLinearIndicatorBackgroundbw27NRU(Canvas, j5, fM1461getHeightimpl);
                            ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, 0.0f, f, j6, fM1461getHeightimpl);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM466sizeVpY3zN4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                jM979getPrimary0d7_KjU = j3;
            }
            j4 = jM1630copywmQWz5c$default;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    ProgressIndicatorKt.m1123LinearProgressIndicatoreaDK9VM(f, companion, jM979getPrimary0d7_KjU, j4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                jM1630copywmQWz5c$default = j2;
                if (composerStartRestartGroup.changed(jM1630copywmQWz5c$default)) {
                }
                i3 |= i6;
            } else {
                jM1630copywmQWz5c$default = j2;
            }
            i3 |= i6;
        } else {
            jM1630copywmQWz5c$default = j2;
        }
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM979getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM979getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
            }
            composerStartRestartGroup.endDefaults();
            Modifier modifierM466sizeVpY3zN5 = SizeKt.m466sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(companion, f, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            Color colorM1621boximpl3 = Color.m1621boximpl(jM1630copywmQWz5c$default);
            Float fValueOf2 = Float.valueOf(f);
            Color colorM1621boximpl4 = Color.m1621boximpl(jM979getPrimary0d7_KjU);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(colorM1621boximpl3) | composerStartRestartGroup.changed(fValueOf2) | composerStartRestartGroup.changed(colorM1621boximpl4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                final long j7 = jM1630copywmQWz5c$default;
                final long j8 = jM979getPrimary0d7_KjU;
                objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float fM1461getHeightimpl = Size.m1461getHeightimpl(Canvas.mo2125getSizeNHjbRc());
                        ProgressIndicatorKt.m1144drawLinearIndicatorBackgroundbw27NRU(Canvas, j7, fM1461getHeightimpl);
                        ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, 0.0f, f, j8, fM1461getHeightimpl);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final long j9 = jM1630copywmQWz5c$default;
                final long j10 = jM979getPrimary0d7_KjU;
                objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float fM1461getHeightimpl = Size.m1461getHeightimpl(Canvas.mo2125getSizeNHjbRc());
                        ProgressIndicatorKt.m1144drawLinearIndicatorBackgroundbw27NRU(Canvas, j9, fM1461getHeightimpl);
                        ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, 0.0f, f, j10, fM1461getHeightimpl);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM466sizeVpY3zN5, (Function1) objRememberedValue, composerStartRestartGroup, 0);
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM979getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j3;
                }
                if ((i2 & 8) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM979getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
            }
            composerStartRestartGroup.endDefaults();
            Modifier modifierM466sizeVpY3zN6 = SizeKt.m466sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(companion, f, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            Color colorM1621boximpl5 = Color.m1621boximpl(jM1630copywmQWz5c$default);
            Float fValueOf3 = Float.valueOf(f);
            Color colorM1621boximpl6 = Color.m1621boximpl(jM979getPrimary0d7_KjU);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(colorM1621boximpl5) | composerStartRestartGroup.changed(fValueOf3) | composerStartRestartGroup.changed(colorM1621boximpl6);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                final long j11 = jM1630copywmQWz5c$default;
                final long j12 = jM979getPrimary0d7_KjU;
                objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float fM1461getHeightimpl = Size.m1461getHeightimpl(Canvas.mo2125getSizeNHjbRc());
                        ProgressIndicatorKt.m1144drawLinearIndicatorBackgroundbw27NRU(Canvas, j11, fM1461getHeightimpl);
                        ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, 0.0f, f, j12, fM1461getHeightimpl);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final long j13 = jM1630copywmQWz5c$default;
                final long j14 = jM979getPrimary0d7_KjU;
                objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float fM1461getHeightimpl = Size.m1461getHeightimpl(Canvas.mo2125getSizeNHjbRc());
                        ProgressIndicatorKt.m1144drawLinearIndicatorBackgroundbw27NRU(Canvas, j13, fM1461getHeightimpl);
                        ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, 0.0f, f, j14, fM1461getHeightimpl);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM466sizeVpY3zN6, (Function1) objRememberedValue, composerStartRestartGroup, 0);
        }
        j4 = jM1630copywmQWz5c$default;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                ProgressIndicatorKt.m1123LinearProgressIndicatoreaDK9VM(f, companion, jM979getPrimary0d7_KjU, j4, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final void m1122LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long jM1630copywmQWz5c$default;
        final Modifier.Companion companion;
        final long jM979getPrimary0d7_KjU;
        Composer composerStartRestartGroup = composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)102@4593L6,105@4718L28,109@5000L319,120@5364L319,131@5729L323,142@6098L323,157@6553L557,153@6426L684:ProgressIndicator.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                int i5 = composerStartRestartGroup.changed(j3) ? 32 : 16;
                i3 |= i5;
            } else {
                j3 = j;
            }
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1630copywmQWz5c$default = j2;
                int i6 = composerStartRestartGroup.changed(jM1630copywmQWz5c$default) ? 256 : 128;
                i3 |= i6;
            } else {
                jM1630copywmQWz5c$default = j2;
            }
            i3 |= i6;
        } else {
            jM1630copywmQWz5c$default = j2;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                jM979getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU() : j3;
                if ((i2 & 4) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM979getPrimary0d7_KjU, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                jM979getPrimary0d7_KjU = j3;
            }
            composerStartRestartGroup.endDefaults();
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.FirstLineHeadEasing);
                    keyframes.at(Float.valueOf(1.0f), UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), 333), ProgressIndicatorKt.FirstLineTailEasing);
                    keyframes.at(Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), 1000), ProgressIndicatorKt.SecondLineHeadEasing);
                    keyframes.at(Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), 1267), ProgressIndicatorKt.SecondLineTailEasing);
                    keyframes.at(Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            Modifier modifierM466sizeVpY3zN4 = SizeKt.m466sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] objArr = {Color.m1621boximpl(jM1630copywmQWz5c$default), stateAnimateFloat, stateAnimateFloat2, Color.m1621boximpl(jM979getPrimary0d7_KjU), stateAnimateFloat3, stateAnimateFloat4};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i7 = 0; i7 < 6; i7++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i7]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final long j4 = jM1630copywmQWz5c$default;
                final long j5 = jM979getPrimary0d7_KjU;
                objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float fM1461getHeightimpl = Size.m1461getHeightimpl(Canvas.mo2125getSizeNHjbRc());
                        ProgressIndicatorKt.m1144drawLinearIndicatorBackgroundbw27NRU(Canvas, j4, fM1461getHeightimpl);
                        if (ProgressIndicatorKt.m1124LinearProgressIndicator_RIQooxk$lambda1(stateAnimateFloat) - ProgressIndicatorKt.m1125LinearProgressIndicator_RIQooxk$lambda2(stateAnimateFloat2) > 0.0f) {
                            ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, ProgressIndicatorKt.m1124LinearProgressIndicator_RIQooxk$lambda1(stateAnimateFloat), ProgressIndicatorKt.m1125LinearProgressIndicator_RIQooxk$lambda2(stateAnimateFloat2), j5, fM1461getHeightimpl);
                        }
                        if (ProgressIndicatorKt.m1126LinearProgressIndicator_RIQooxk$lambda3(stateAnimateFloat3) - ProgressIndicatorKt.m1127LinearProgressIndicator_RIQooxk$lambda4(stateAnimateFloat4) > 0.0f) {
                            ProgressIndicatorKt.m1143drawLinearIndicator42QJj7c(Canvas, ProgressIndicatorKt.m1126LinearProgressIndicator_RIQooxk$lambda3(stateAnimateFloat3), ProgressIndicatorKt.m1127LinearProgressIndicator_RIQooxk$lambda4(stateAnimateFloat4), j5, fM1461getHeightimpl);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM466sizeVpY3zN4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            jM979getPrimary0d7_KjU = j3;
        }
        final long j6 = jM1630copywmQWz5c$default;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                ProgressIndicatorKt.m1122LinearProgressIndicatorRIQooxk(companion, jM979getPrimary0d7_KjU, j6, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicator-42QJj7c, reason: not valid java name */
    public static final void m1143drawLinearIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, float f3) {
        float fM1464getWidthimpl = Size.m1464getWidthimpl(drawScope.mo2125getSizeNHjbRc());
        float fM1461getHeightimpl = Size.m1461getHeightimpl(drawScope.mo2125getSizeNHjbRc()) / 2;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        DrawScope.m2112drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset((z ? f : 1.0f - f2) * fM1464getWidthimpl, fM1461getHeightimpl), OffsetKt.Offset((z ? f2 : 1.0f - f) * fM1464getWidthimpl, fM1461getHeightimpl), f3, 0, null, 0.0f, null, 0, 496, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicatorBackground-bw27NRU, reason: not valid java name */
    public static final void m1144drawLinearIndicatorBackgroundbw27NRU(DrawScope drawScope, long j, float f) {
        m1143drawLinearIndicator42QJj7c(drawScope, 0.0f, 1.0f, j, f);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    /* JADX WARN: Code duplicated, block: B:40:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x0127  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final void m1116CircularProgressIndicatorMBs18nI(final float f, Modifier modifier, long j, float f2, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final long j2;
        int i4;
        float f3;
        int i5;
        Modifier.Companion companion;
        long jM979getPrimary0d7_KjU;
        final long j3;
        float fM1115getStrokeWidthD9Ej5fM;
        Modifier modifier3;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-409649739);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)226@9099L6,*229@9214L7,232@9300L296:ProgressIndicator.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    j2 = j;
                    int i7 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    j2 = j;
                }
                i3 |= i7;
            } else {
                j2 = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    f3 = f2;
                    if (composerStartRestartGroup.changed(f3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        } else {
                            jM979getPrimary0d7_KjU = j2;
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            j3 = jM979getPrimary0d7_KjU;
                            fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                        } else {
                            j3 = jM979getPrimary0d7_KjU;
                            fM1115getStrokeWidthD9Ej5fM = f3;
                            modifier3 = companion;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j2;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Stroke stroke = new Stroke(((Density) objConsume).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
                    CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope Canvas) {
                            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                            ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke);
                        }
                    }, composerStartRestartGroup, 0);
                    modifier2 = modifier3;
                    j2 = j3;
                    f4 = fM1115getStrokeWidthD9Ej5fM;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f4 = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        ProgressIndicatorKt.m1116CircularProgressIndicatorMBs18nI(f, modifier2, j2, f4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            f3 = f2;
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Stroke stroke2 = new Stroke(((Density) objConsume2).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
                CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke2);
                    }
                }, composerStartRestartGroup, 0);
                modifier2 = modifier3;
                j2 = j3;
                f4 = fM1115getStrokeWidthD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Stroke stroke3 = new Stroke(((Density) objConsume3).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
                CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke3);
                    }
                }, composerStartRestartGroup, 0);
                modifier2 = modifier3;
                j2 = j3;
                f4 = fM1115getStrokeWidthD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    ProgressIndicatorKt.m1116CircularProgressIndicatorMBs18nI(f, modifier2, j2, f4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i7;
            } else {
                j2 = j;
            }
            i3 |= i7;
        } else {
            j2 = j;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                f3 = f2;
                if (composerStartRestartGroup.changed(f3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Stroke stroke4 = new Stroke(((Density) objConsume4).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
                CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke4);
                    }
                }, composerStartRestartGroup, 0);
                modifier2 = modifier3;
                j2 = j3;
                f4 = fM1115getStrokeWidthD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    } else {
                        j3 = jM979getPrimary0d7_KjU;
                        fM1115getStrokeWidthD9Ej5fM = f3;
                        modifier3 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Stroke stroke5 = new Stroke(((Density) objConsume5).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
                CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke5);
                    }
                }, composerStartRestartGroup, 0);
                modifier2 = modifier3;
                j2 = j3;
                f4 = fM1115getStrokeWidthD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    ProgressIndicatorKt.m1116CircularProgressIndicatorMBs18nI(f, modifier2, j2, f4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        f3 = f2;
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = f3;
                    modifier3 = companion;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = f3;
                    modifier3 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Stroke stroke6 = new Stroke(((Density) objConsume6).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
            CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke6);
                }
            }, composerStartRestartGroup, 0);
            modifier2 = modifier3;
            j2 = j3;
            f4 = fM1115getStrokeWidthD9Ej5fM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = f3;
                    modifier3 = companion;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    j3 = jM979getPrimary0d7_KjU;
                    fM1115getStrokeWidthD9Ej5fM = f3;
                    modifier3 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Stroke stroke7 = new Stroke(((Density) objConsume7).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1935getButtKaPHkGw(), 0, null, 26, null);
            CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    ProgressIndicatorKt.m1141drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, j3, stroke7);
                }
            }, composerStartRestartGroup, 0);
            modifier2 = modifier3;
            j2 = j3;
            f4 = fM1115getStrokeWidthD9Ej5fM;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                ProgressIndicatorKt.m1116CircularProgressIndicatorMBs18nI(f, modifier2, j2, f4, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x008e A[PHI: r1 r3
  0x008e: PHI (r1v10 androidx.compose.ui.Modifier) = (r1v4 androidx.compose.ui.Modifier), (r1v11 androidx.compose.ui.Modifier) binds: [B:55:0x00a9, B:46:0x0089] A[DONT_GENERATE, DONT_INLINE]
  0x008e: PHI (r3v11 long) = (r3v6 long), (r3v12 long) binds: [B:55:0x00a9, B:46:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final void m1117CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float f2;
        Modifier.Companion companion;
        long jM979getPrimary0d7_KjU;
        float fM1115getStrokeWidthD9Ej5fM;
        final Modifier modifier3;
        final long j3;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-392089979);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)257@10275L6,*260@10390L7,264@10496L28,266@10654L278,278@11047L230,289@11395L345,301@11775L354,312@12134L582:ProgressIndicator.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j2 = j;
                int i5 = composerStartRestartGroup.changed(j2) ? 32 : 16;
                i3 |= i5;
            } else {
                j2 = j;
            }
            i3 |= i5;
        } else {
            j2 = j;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 896) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    jM979getPrimary0d7_KjU = j2;
                } else {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    } else {
                        jM979getPrimary0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Stroke stroke = new Stroke(((Density) objConsume).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1937getSquareKaPHkGw(), 0, null, 26, null);
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
                    final State stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12));
                    final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
                    final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                            keyframes.setDurationMillis(1332);
                            keyframes.with(keyframes.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                            keyframes.at(Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                        }
                    }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
                    final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                            keyframes.setDurationMillis(1332);
                            keyframes.with(keyframes.at(Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3), ProgressIndicatorKt.CircularEasing);
                            keyframes.at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                        }
                    }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
                    final float f4 = fM1115getStrokeWidthD9Ej5fM;
                    final long j4 = jM979getPrimary0d7_KjU;
                    CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope Canvas) {
                            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                            ProgressIndicatorKt.m1142drawIndeterminateCircularIndicatorhrjfTZI(Canvas, ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat3) + (((ProgressIndicatorKt.m1120CircularProgressIndicator_aM_cp0Q$lambda8(stateAnimateValue) * 216.0f) % 360.0f) - 90.0f) + ProgressIndicatorKt.m1121CircularProgressIndicator_aM_cp0Q$lambda9(stateAnimateFloat), f4, Math.abs(ProgressIndicatorKt.m1118CircularProgressIndicator_aM_cp0Q$lambda10(stateAnimateFloat2) - ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat3)), j4, stroke);
                        }
                    }, composerStartRestartGroup, 0);
                    modifier3 = companion;
                    j3 = jM979getPrimary0d7_KjU;
                    f3 = fM1115getStrokeWidthD9Ej5fM;
                }
                fM1115getStrokeWidthD9Ej5fM = f2;
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Stroke stroke2 = new Stroke(((Density) objConsume2).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1937getSquareKaPHkGw(), 0, null, 26, null);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
                final State<Integer> stateAnimateValue2 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition2, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12));
                final State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
                final State<Float> stateAnimateFloat5 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                        keyframes.setDurationMillis(1332);
                        keyframes.with(keyframes.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                        keyframes.at(Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                    }
                }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
                final State<Float> stateAnimateFloat6 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                        keyframes.setDurationMillis(1332);
                        keyframes.with(keyframes.at(Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3), ProgressIndicatorKt.CircularEasing);
                        keyframes.at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                    }
                }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
                final float f5 = fM1115getStrokeWidthD9Ej5fM;
                final long j5 = jM979getPrimary0d7_KjU;
                CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        ProgressIndicatorKt.m1142drawIndeterminateCircularIndicatorhrjfTZI(Canvas, ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat6) + (((ProgressIndicatorKt.m1120CircularProgressIndicator_aM_cp0Q$lambda8(stateAnimateValue2) * 216.0f) % 360.0f) - 90.0f) + ProgressIndicatorKt.m1121CircularProgressIndicator_aM_cp0Q$lambda9(stateAnimateFloat4), f5, Math.abs(ProgressIndicatorKt.m1118CircularProgressIndicator_aM_cp0Q$lambda10(stateAnimateFloat5) - ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat6)), j5, stroke2);
                    }
                }, composerStartRestartGroup, 0);
                modifier3 = companion;
                j3 = jM979getPrimary0d7_KjU;
                f3 = fM1115getStrokeWidthD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    ProgressIndicatorKt.m1117CircularProgressIndicatoraMcp0Q(modifier3, j3, f3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        f2 = f;
        if ((i3 & 731) == 146) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    fM1115getStrokeWidthD9Ej5fM = f2;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    fM1115getStrokeWidthD9Ej5fM = f2;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Stroke stroke3 = new Stroke(((Density) objConsume3).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1937getSquareKaPHkGw(), 0, null, 26, null);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition3 = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
            final State<Integer> stateAnimateValue3 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition3, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12));
            final State<Float> stateAnimateFloat7 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, BaseRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat8 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                    keyframes.at(Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat9 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3), ProgressIndicatorKt.CircularEasing);
                    keyframes.at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final float f6 = fM1115getStrokeWidthD9Ej5fM;
            final long j6 = jM979getPrimary0d7_KjU;
            CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    ProgressIndicatorKt.m1142drawIndeterminateCircularIndicatorhrjfTZI(Canvas, ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat9) + (((ProgressIndicatorKt.m1120CircularProgressIndicator_aM_cp0Q$lambda8(stateAnimateValue3) * 216.0f) % 360.0f) - 90.0f) + ProgressIndicatorKt.m1121CircularProgressIndicator_aM_cp0Q$lambda9(stateAnimateFloat7), f6, Math.abs(ProgressIndicatorKt.m1118CircularProgressIndicator_aM_cp0Q$lambda10(stateAnimateFloat8) - ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat9)), j6, stroke3);
                }
            }, composerStartRestartGroup, 0);
            modifier3 = companion;
            j3 = jM979getPrimary0d7_KjU;
            f3 = fM1115getStrokeWidthD9Ej5fM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    fM1115getStrokeWidthD9Ej5fM = f2;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                } else {
                    jM979getPrimary0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM1115getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m1115getStrokeWidthD9Ej5fM();
                } else {
                    fM1115getStrokeWidthD9Ej5fM = f2;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Stroke stroke4 = new Stroke(((Density) objConsume4).mo318toPx0680j_4(fM1115getStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m1937getSquareKaPHkGw(), 0, null, 26, null);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition4 = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
            final State<Integer> stateAnimateValue4 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition4, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12));
            final State<Float> stateAnimateFloat10 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, BaseRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat11 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                    keyframes.at(Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State<Float> stateAnimateFloat12 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, JumpRotationAngle, AnimationSpecKt.m113infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    keyframes.with(keyframes.at(Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3), ProgressIndicatorKt.CircularEasing);
                    keyframes.at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                }
            }), null, 0L, 6, null), composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final float f7 = fM1115getStrokeWidthD9Ej5fM;
            final long j7 = jM979getPrimary0d7_KjU;
            CanvasKt.Canvas(SizeKt.m464size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    ProgressIndicatorKt.m1142drawIndeterminateCircularIndicatorhrjfTZI(Canvas, ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat12) + (((ProgressIndicatorKt.m1120CircularProgressIndicator_aM_cp0Q$lambda8(stateAnimateValue4) * 216.0f) % 360.0f) - 90.0f) + ProgressIndicatorKt.m1121CircularProgressIndicator_aM_cp0Q$lambda9(stateAnimateFloat10), f7, Math.abs(ProgressIndicatorKt.m1118CircularProgressIndicator_aM_cp0Q$lambda10(stateAnimateFloat11) - ProgressIndicatorKt.m1119CircularProgressIndicator_aM_cp0Q$lambda11(stateAnimateFloat12)), j7, stroke4);
                }
            }, composerStartRestartGroup, 0);
            modifier3 = companion;
            j3 = jM979getPrimary0d7_KjU;
            f3 = fM1115getStrokeWidthD9Ej5fM;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                ProgressIndicatorKt.m1117CircularProgressIndicatoraMcp0Q(modifier3, j3, f3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m1140drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float fM1464getWidthimpl = Size.m1464getWidthimpl(drawScope.mo2125getSizeNHjbRc()) - (f3 * width);
        DrawScope.m2105drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.ui.geometry.SizeKt.Size(fM1464getWidthimpl, fM1464getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m1141drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m1140drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m1142drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m1140drawCircularIndicator42QJj7c(drawScope, f + (((f2 / Dp.m3843constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LinearProgressIndicator_RIQooxk$lambda-1, reason: not valid java name */
    public static final float m1124LinearProgressIndicator_RIQooxk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LinearProgressIndicator_RIQooxk$lambda-2, reason: not valid java name */
    public static final float m1125LinearProgressIndicator_RIQooxk$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LinearProgressIndicator_RIQooxk$lambda-3, reason: not valid java name */
    public static final float m1126LinearProgressIndicator_RIQooxk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LinearProgressIndicator_RIQooxk$lambda-4, reason: not valid java name */
    public static final float m1127LinearProgressIndicator_RIQooxk$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularProgressIndicator_aM_cp0Q$lambda-8, reason: not valid java name */
    public static final int m1120CircularProgressIndicator_aM_cp0Q$lambda8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularProgressIndicator_aM_cp0Q$lambda-9, reason: not valid java name */
    public static final float m1121CircularProgressIndicator_aM_cp0Q$lambda9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularProgressIndicator_aM_cp0Q$lambda-10, reason: not valid java name */
    public static final float m1118CircularProgressIndicator_aM_cp0Q$lambda10(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularProgressIndicator_aM_cp0Q$lambda-11, reason: not valid java name */
    public static final float m1119CircularProgressIndicator_aM_cp0Q$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }
}
