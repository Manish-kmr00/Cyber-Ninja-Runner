package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0082\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Density {
    float getDensity();

    float getFontScale();

    /* JADX INFO: compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3836toPx0680j_4(Density density, float f) {
            return Density.super.mo318toPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3830roundToPx0680j_4(Density density, float f) {
            return Density.super.mo312roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3838toSp0xMU5do(Density density, float f) {
            return Density.super.mo320toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3835toPxR2X_6o(Density density, long j) {
            return Density.super.mo317toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3829roundToPxR2X_6o(Density density, long j) {
            return Density.super.mo311roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3831toDpGaN1DYA(Density density, long j) {
            return Density.super.mo313toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3833toDpu2uoSUM(Density density, int i) {
            return Density.super.mo315toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3840toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo322toSpkPz2Gy4(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3832toDpu2uoSUM(Density density, float f) {
            return Density.super.mo314toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3839toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo321toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return Density.super.toRect(receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3837toSizeXkaWNTQ(Density density, long j) {
            return Density.super.mo319toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3834toDpSizekrfVVM(Density density, long j) {
            return Density.super.mo316toDpSizekrfVVM(j);
        }
    }

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo318toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo312roundToPx0680j_4(float f) {
        float fMo318toPx0680j_4 = mo318toPx0680j_4(f);
        if (Float.isInfinite(fMo318toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(fMo318toPx0680j_4);
    }

    /* JADX INFO: renamed from: toSp-0xMU5do */
    default long mo320toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo317toPxR2X_6o(long j) {
        if (!TextUnitType.m4052equalsimpl0(TextUnit.m4023getTypeUIouoOA(j), TextUnitType.INSTANCE.m4057getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }
        return TextUnit.m4024getValueimpl(j) * getFontScale() * getDensity();
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo311roundToPxR2X_6o(long j) {
        return MathKt.roundToInt(mo317toPxR2X_6o(j));
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    default float mo313toDpGaN1DYA(long j) {
        if (!TextUnitType.m4052equalsimpl0(TextUnit.m4023getTypeUIouoOA(j), TextUnitType.INSTANCE.m4057getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }
        return Dp.m3843constructorimpl(TextUnit.m4024getValueimpl(j) * getFontScale());
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo315toDpu2uoSUM(int i) {
        return Dp.m3843constructorimpl(i / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo322toSpkPz2Gy4(int i) {
        return TextUnitKt.getSp(i / (getFontScale() * getDensity()));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo314toDpu2uoSUM(float f) {
        return Dp.m3843constructorimpl(f / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo321toSpkPz2Gy4(float f) {
        return TextUnitKt.getSp(f / (getFontScale() * getDensity()));
    }

    default Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return new Rect(mo318toPx0680j_4(dpRect.m3926getLeftD9Ej5fM()), mo318toPx0680j_4(dpRect.m3928getTopD9Ej5fM()), mo318toPx0680j_4(dpRect.m3927getRightD9Ej5fM()), mo318toPx0680j_4(dpRect.m3925getBottomD9Ej5fM()));
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo319toSizeXkaWNTQ(long j) {
        if (j != DpSize.INSTANCE.m3950getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(mo318toPx0680j_4(DpSize.m3941getWidthD9Ej5fM(j)), mo318toPx0680j_4(DpSize.m3939getHeightD9Ej5fM(j)));
        }
        return Size.INSTANCE.m1472getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo316toDpSizekrfVVM(long j) {
        if (j != Size.INSTANCE.m1472getUnspecifiedNHjbRc()) {
            return DpKt.m3865DpSizeYgX7TsA(mo314toDpu2uoSUM(Size.m1464getWidthimpl(j)), mo314toDpu2uoSUM(Size.m1461getHeightimpl(j)));
        }
        return DpSize.INSTANCE.m3950getUnspecifiedMYxV2XQ();
    }
}
