package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerInputChange;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a,\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "MinSampleSize", "kineticEnergyToVelocity", "work", "polyFitLeastSquares", "Landroidx/compose/ui/input/pointer/util/PolynomialFit;", VastAttributes.HORIZONTAL_POSITION, "", VastAttributes.VERTICAL_POSITION, "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static final int MinSampleSize = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public static final float kineticEnergyToVelocity(float f) {
        return Math.signum(f) * ((float) Math.sqrt(2 * Math.abs(f)));
    }

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange event) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        List<HistoricalChange> historical = event.getHistorical();
        int size = historical.size();
        for (int i = 0; i < size; i++) {
            HistoricalChange historicalChange = historical.get(i);
            velocityTracker.m3099addPositionUv8p0NA(historicalChange.getUptimeMillis(), historicalChange.getPosition());
        }
        velocityTracker.m3099addPositionUv8p0NA(event.getUptimeMillis(), event.getPosition());
    }

    public static final PolynomialFit polyFitLeastSquares(List<Float> x, List<Float> y, int i) {
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        if (i < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        }
        if (x.isEmpty()) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        int size = i >= x.size() ? x.size() - 1 : i;
        int i2 = i + 1;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(0.0f));
        }
        ArrayList arrayList2 = arrayList;
        int size2 = x.size();
        int i4 = size + 1;
        Matrix matrix = new Matrix(i4, size2);
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                break;
            }
            matrix.set(0, i5, 1.0f);
            for (int i6 = 1; i6 < i4; i6++) {
                matrix.set(i6, i5, matrix.get(i6 - 1, i5) * x.get(i5).floatValue());
            }
            i5++;
        }
        Matrix matrix2 = new Matrix(i4, size2);
        Matrix matrix3 = new Matrix(i4, i4);
        int i7 = 0;
        while (i7 < i4) {
            for (int i8 = 0; i8 < size2; i8++) {
                matrix2.set(i7, i8, matrix.get(i7, i8));
            }
            for (int i9 = 0; i9 < i7; i9++) {
                float fTimes = matrix2.getRow(i7).times(matrix2.getRow(i9));
                for (int i10 = 0; i10 < size2; i10++) {
                    matrix2.set(i7, i10, matrix2.get(i7, i10) - (matrix2.get(i9, i10) * fTimes));
                }
            }
            float fNorm = matrix2.getRow(i7).norm();
            if (fNorm < 1.0E-6d) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float f = 1.0f / fNorm;
            for (int i11 = 0; i11 < size2; i11++) {
                matrix2.set(i7, i11, matrix2.get(i7, i11) * f);
            }
            int i12 = 0;
            while (i12 < i4) {
                matrix3.set(i7, i12, i12 < i7 ? 0.0f : matrix2.getRow(i7).times(matrix.getRow(i12)));
                i12++;
            }
            i7++;
        }
        Vector vector = new Vector(size2);
        for (int i13 = 0; i13 < size2; i13++) {
            vector.set(i13, y.get(i13).floatValue() * 1.0f);
        }
        for (int i14 = size; -1 < i14; i14--) {
            arrayList2.set(i14, Float.valueOf(matrix2.getRow(i14).times(vector)));
            int i15 = i14 + 1;
            if (i15 <= size) {
                int i16 = size;
                while (true) {
                    arrayList2.set(i14, Float.valueOf(((Number) arrayList2.get(i14)).floatValue() - (matrix3.get(i14, i16) * ((Number) arrayList2.get(i16)).floatValue())));
                    if (i16 != i15) {
                        i16--;
                    }
                }
            }
            arrayList2.set(i14, Float.valueOf(((Number) arrayList2.get(i14)).floatValue() / matrix3.get(i14, i14)));
        }
        float fFloatValue = 0.0f;
        for (int i17 = 0; i17 < size2; i17++) {
            fFloatValue += y.get(i17).floatValue();
        }
        float f2 = fFloatValue / size2;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i18 = 0; i18 < size2; i18++) {
            float fFloatValue2 = y.get(i18).floatValue() - ((Number) arrayList2.get(0)).floatValue();
            float fFloatValue3 = 1.0f;
            for (int i19 = 1; i19 < i4; i19++) {
                fFloatValue3 *= x.get(i18).floatValue();
                fFloatValue2 -= ((Number) arrayList2.get(i19)).floatValue() * fFloatValue3;
            }
            f3 += fFloatValue2 * 1.0f * fFloatValue2;
            float fFloatValue4 = y.get(i18).floatValue() - f2;
            f4 += fFloatValue4 * 1.0f * fFloatValue4;
        }
        return new PolynomialFit(arrayList2, f4 > 1.0E-6f ? 1.0f - (f3 / f4) : 1.0f);
    }
}
