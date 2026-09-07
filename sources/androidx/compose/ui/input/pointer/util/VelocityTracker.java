package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.VelocityKt;
import com.json.b9;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "index", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/PointAtTime;", "[Landroidx/compose/ui/input/pointer/util/PointAtTime;", "useImpulse", "", "addPosition", "", "timeMillis", "", b9.h.L, "Landroidx/compose/ui/geometry/Offset;", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "()J", "getImpulseVelocity", "getImpulseVelocity-9UxMQ8M", "getLsq2VelocityEstimate", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "resetTracking", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VelocityTracker {
    public static final int $stable = 8;
    private int index;
    private final PointAtTime[] samples;
    private final boolean useImpulse;

    public VelocityTracker() {
        PointAtTime[] pointAtTimeArr = new PointAtTime[20];
        for (int i = 0; i < 20; i++) {
            pointAtTimeArr[i] = null;
        }
        this.samples = pointAtTimeArr;
        this.useImpulse = true;
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m3099addPositionUv8p0NA(long timeMillis, long position) {
        int i = (this.index + 1) % 20;
        this.index = i;
        this.samples[i] = new PointAtTime(position, timeMillis, null);
    }

    /* JADX INFO: renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m3100calculateVelocity9UxMQ8M() {
        if (this.useImpulse) {
            return m3098getImpulseVelocity9UxMQ8M();
        }
        long jM3097getPixelsPerSecondF1C5BW0 = getLsq2VelocityEstimate().m3097getPixelsPerSecondF1C5BW0();
        return VelocityKt.Velocity(Offset.m1395getXimpl(jM3097getPixelsPerSecondF1C5BW0), Offset.m1396getYimpl(jM3097getPixelsPerSecondF1C5BW0));
    }

    /* JADX INFO: renamed from: getImpulseVelocity-9UxMQ8M, reason: not valid java name */
    private final long m3098getImpulseVelocity9UxMQ8M() {
        PointAtTime pointAtTime = this.samples[this.index];
        if (pointAtTime == null) {
            return VelocityKt.Velocity(0.0f, 0.0f);
        }
        ImpulseCalculator impulseCalculator = new ImpulseCalculator();
        ImpulseCalculator impulseCalculator2 = new ImpulseCalculator();
        int i = this.index;
        int i2 = 0;
        do {
            i = (i + 1) % 20;
            PointAtTime pointAtTime2 = this.samples[i];
            if (pointAtTime2 != null) {
                long time = pointAtTime.getTime() - pointAtTime2.getTime();
                long jAbs = Math.abs(pointAtTime2.getTime() - pointAtTime.getTime());
                if (time <= 100) {
                    if (jAbs > 40) {
                        impulseCalculator.reset();
                        impulseCalculator2.reset();
                    }
                    long j = -time;
                    impulseCalculator.addPosition(j, Offset.m1395getXimpl(pointAtTime2.m3091getPointF1C5BW0()));
                    impulseCalculator2.addPosition(j, Offset.m1396getYimpl(pointAtTime2.m3091getPointF1C5BW0()));
                    i2++;
                }
            }
            if (i == this.index) {
                break;
            }
        } while (i2 < 20);
        if (i2 < 3) {
            return VelocityKt.Velocity(0.0f, 0.0f);
        }
        return VelocityKt.Velocity(impulseCalculator.getVelocity(), impulseCalculator2.getVelocity());
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, (Object) null, 0, 0, 6, (Object) null);
    }

    private final VelocityEstimate getLsq2VelocityEstimate() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = this.index;
        PointAtTime pointAtTime = this.samples[i];
        if (pointAtTime == null) {
            return VelocityEstimate.INSTANCE.getNone();
        }
        int i2 = 0;
        PointAtTime pointAtTime2 = pointAtTime;
        while (true) {
            PointAtTime pointAtTime3 = this.samples[i];
            if (pointAtTime3 == null) {
                break;
            }
            float time = pointAtTime.getTime() - pointAtTime3.getTime();
            float fAbs = Math.abs(pointAtTime3.getTime() - pointAtTime2.getTime());
            if (time > 100.0f || fAbs > 40.0f) {
                break;
            }
            long jM3091getPointF1C5BW0 = pointAtTime3.m3091getPointF1C5BW0();
            arrayList.add(Float.valueOf(Offset.m1395getXimpl(jM3091getPointF1C5BW0)));
            arrayList2.add(Float.valueOf(Offset.m1396getYimpl(jM3091getPointF1C5BW0)));
            arrayList3.add(Float.valueOf(-time));
            if (i == 0) {
                i = 20;
            }
            i--;
            i2++;
            if (i2 >= 20) {
                pointAtTime2 = pointAtTime3;
                break;
            }
            pointAtTime2 = pointAtTime3;
        }
        if (i2 >= 3) {
            try {
                PolynomialFit polynomialFitPolyFitLeastSquares = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList, 2);
                PolynomialFit polynomialFitPolyFitLeastSquares2 = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList2, 2);
                float f = 1000;
                return new VelocityEstimate(OffsetKt.Offset(polynomialFitPolyFitLeastSquares.getCoefficients().get(1).floatValue() * f, polynomialFitPolyFitLeastSquares2.getCoefficients().get(1).floatValue() * f), polynomialFitPolyFitLeastSquares.getConfidence() * polynomialFitPolyFitLeastSquares2.getConfidence(), pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1399minusMKHz9U(pointAtTime.m3091getPointF1C5BW0(), pointAtTime2.m3091getPointF1C5BW0()), null);
            } catch (IllegalArgumentException unused) {
                return VelocityEstimate.INSTANCE.getNone();
            }
        }
        return new VelocityEstimate(Offset.INSTANCE.m1411getZeroF1C5BW0(), 1.0f, pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1399minusMKHz9U(pointAtTime.m3091getPointF1C5BW0(), pointAtTime2.m3091getPointF1C5BW0()), null);
    }
}
