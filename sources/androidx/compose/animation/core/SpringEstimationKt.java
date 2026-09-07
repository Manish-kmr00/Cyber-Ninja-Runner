package androidx.compose.animation.core;

import com.facebook.appevents.UserDataStore;
import com.moloco.sdk.internal.services.init.i;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a4\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a<\u0010\u0012\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0014\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0015\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\u0082\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0082\b¨\u0006\u001d"}, d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "roots", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "p0", i.f6407a, "estimateDurationInternal", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", VastAttributes.HORIZONTAL_POSITION, UserDataStore.FIRST_NAME, "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return estimateAnimationDurationMillis(f, f2, f3, f4, f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(1.0d, 2.0d * d2 * Math.sqrt(d), d), d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(d3, d2, d), d2 / (Math.sqrt(d * d3) * 2.0d), d4, d5, d6);
    }

    private static final double estimateUnderDamped(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3) {
        double real = pair.getFirst().getReal();
        double imaginary = (d2 - (real * d)) / pair.getFirst().getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    private static final double estimateCriticallyDamped(Pair<ComplexDouble, ComplexDouble> pair, final double d, double d2, double d3) {
        double d4;
        final double d5;
        final double real = pair.getFirst().getReal();
        double d6 = real * d;
        final double d7 = d2 - d6;
        double dLog = Math.log(Math.abs(d3 / d)) / real;
        double dEstimateCriticallyDamped$t2Iterate = estimateCriticallyDamped$t2Iterate(Math.log(Math.abs(d3 / d7)), real) / real;
        int i = 0;
        if ((Double.isInfinite(dLog) || Double.isNaN(dLog)) ? false : true) {
            if ((Double.isInfinite(dEstimateCriticallyDamped$t2Iterate) || Double.isNaN(dEstimateCriticallyDamped$t2Iterate)) ? false : true) {
                dLog = Math.max(dLog, dEstimateCriticallyDamped$t2Iterate);
            }
            d4 = dLog;
        } else {
            d4 = dEstimateCriticallyDamped$t2Iterate;
        }
        double d8 = (-(d6 + d7)) / (real * d7);
        if (Double.isNaN(d8) || d8 <= 0.0d) {
            d5 = -d3;
        } else if (d8 <= 0.0d || (-estimateCriticallyDamped$xInflection(d, real, d8, d7)) >= d3) {
            d4 = (-(2.0d / real)) - (d / d7);
            d5 = d3;
        } else {
            if (d7 < 0.0d && d > 0.0d) {
                d4 = 0.0d;
            }
            d5 = -d3;
        }
        Function1<Double, Double> function1 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double d9) {
                return Double.valueOf(((d + (d7 * d9)) * Math.exp(real * d9)) + d5);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d9) {
                return invoke(d9.doubleValue());
            }
        };
        Function1<Double, Double> function2 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double d9) {
                double d10 = d7;
                double d11 = real;
                return Double.valueOf(((d10 * ((d11 * d9) + ((double) 1))) + (d * d11)) * Math.exp(d11 * d9));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d9) {
                return invoke(d9.doubleValue());
            }
        };
        double d9 = Double.MAX_VALUE;
        while (d9 > 0.001d && i < 100) {
            i++;
            double dDoubleValue = d4 - (function1.invoke(Double.valueOf(d4)).doubleValue() / function2.invoke(Double.valueOf(d4)).doubleValue());
            double dAbs = Math.abs(d4 - dDoubleValue);
            d4 = dDoubleValue;
            d9 = dAbs;
        }
        return d4;
    }

    private static final double estimateCriticallyDamped$t2Iterate(double d, double d2) {
        double dLog = d;
        for (int i = 0; i < 6; i++) {
            dLog = d - Math.log(Math.abs(dLog / d2));
        }
        return dLog;
    }

    private static final double estimateCriticallyDamped$xInflection(double d, double d2, double d3, double d4) {
        double d5 = d2 * d3;
        return (d * Math.exp(d5)) + (d4 * d3 * Math.exp(d5));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fc  */
    private static final double estimateOverDamped(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3) {
        double dLog;
        double d4;
        Function1<Double, Double> function1;
        Function1<Double, Double> function2;
        double d5;
        int i;
        double d6 = d3;
        final double real = pair.getFirst().getReal();
        final double real2 = pair.getSecond().getReal();
        double d7 = real - real2;
        double d8 = ((real * d) - d2) / d7;
        final double d9 = d - d8;
        double dLog2 = Math.log(Math.abs(d6 / d9)) / real;
        double dLog3 = Math.log(Math.abs(d6 / d8)) / real2;
        if ((Double.isInfinite(dLog2) || Double.isNaN(dLog2)) ? false : true) {
            if ((Double.isInfinite(dLog3) || Double.isNaN(dLog3)) ? false : true) {
                dLog2 = Math.max(dLog2, dLog3);
            }
            dLog = dLog2;
        } else {
            dLog = dLog3;
        }
        double d10 = d9 * real;
        double dLog4 = Math.log(d10 / ((-d8) * real2)) / (real2 - real);
        if (!Double.isNaN(dLog4) && dLog4 > 0.0d) {
            if (dLog4 > 0.0d) {
                d4 = d8;
                if ((-m129estimateOverDamped$xInflection0(d9, real, dLog4, d8, real2)) < d6) {
                    if (d4 > 0.0d && d9 < 0.0d) {
                        dLog = 0.0d;
                    }
                }
                final double d11 = d6;
                final double d12 = d4;
                function1 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Double invoke(double d13) {
                        return Double.valueOf((d9 * Math.exp(real * d13)) + (d12 * Math.exp(real2 * d13)) + d11);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Double invoke(Double d13) {
                        return invoke(d13.doubleValue());
                    }
                };
                function2 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Double invoke(double d13) {
                        double d14 = d9;
                        double d15 = real;
                        double dExp = d14 * d15 * Math.exp(d15 * d13);
                        double d16 = d12;
                        double d17 = real2;
                        return Double.valueOf(dExp + (d16 * d17 * Math.exp(d17 * d13)));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Double invoke(Double d13) {
                        return invoke(d13.doubleValue());
                    }
                };
                if (Math.abs(function1.invoke(Double.valueOf(dLog)).doubleValue()) < 1.0E-4d) {
                    return dLog;
                }
                d5 = Double.MAX_VALUE;
                i = 0;
                while (d5 > 0.001d && i < 100) {
                    i++;
                    double dDoubleValue = dLog - (function1.invoke(Double.valueOf(dLog)).doubleValue() / function2.invoke(Double.valueOf(dLog)).doubleValue());
                    double dAbs = Math.abs(dLog - dDoubleValue);
                    dLog = dDoubleValue;
                    d5 = dAbs;
                }
                return dLog;
            }
            d4 = d8;
            dLog = Math.log((-((d4 * real2) * real2)) / (d10 * real)) / d7;
            final double d13 = d6;
            final double d14 = d4;
            function1 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Double invoke(double d15) {
                    return Double.valueOf((d9 * Math.exp(real * d15)) + (d14 * Math.exp(real2 * d15)) + d13);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Double invoke(Double d15) {
                    return invoke(d15.doubleValue());
                }
            };
            function2 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Double invoke(double d15) {
                    double d16 = d9;
                    double d17 = real;
                    double dExp = d16 * d17 * Math.exp(d17 * d15);
                    double d18 = d14;
                    double d19 = real2;
                    return Double.valueOf(dExp + (d18 * d19 * Math.exp(d19 * d15)));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Double invoke(Double d15) {
                    return invoke(d15.doubleValue());
                }
            };
            if (Math.abs(function1.invoke(Double.valueOf(dLog)).doubleValue()) < 1.0E-4d) {
                return dLog;
            }
            d5 = Double.MAX_VALUE;
            i = 0;
            while (d5 > 0.001d) {
                i++;
                double dDoubleValue2 = dLog - (function1.invoke(Double.valueOf(dLog)).doubleValue() / function2.invoke(Double.valueOf(dLog)).doubleValue());
                double dAbs2 = Math.abs(dLog - dDoubleValue2);
                dLog = dDoubleValue2;
                d5 = dAbs2;
            }
            return dLog;
        }
        d4 = d8;
        d6 = -d6;
        final double d15 = d6;
        final double d16 = d4;
        function1 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double d17) {
                return Double.valueOf((d9 * Math.exp(real * d17)) + (d16 * Math.exp(real2 * d17)) + d15);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d17) {
                return invoke(d17.doubleValue());
            }
        };
        function2 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double d17) {
                double d18 = d9;
                double d19 = real;
                double dExp = d18 * d19 * Math.exp(d19 * d17);
                double d110 = d16;
                double d111 = real2;
                return Double.valueOf(dExp + (d110 * d111 * Math.exp(d111 * d17)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d17) {
                return invoke(d17.doubleValue());
            }
        };
        if (Math.abs(function1.invoke(Double.valueOf(dLog)).doubleValue()) < 1.0E-4d) {
            return dLog;
        }
        d5 = Double.MAX_VALUE;
        i = 0;
        while (d5 > 0.001d) {
            i++;
            double dDoubleValue3 = dLog - (function1.invoke(Double.valueOf(dLog)).doubleValue() / function2.invoke(Double.valueOf(dLog)).doubleValue());
            double dAbs3 = Math.abs(dLog - dDoubleValue3);
            dLog = dDoubleValue3;
            d5 = dAbs3;
        }
        return dLog;
    }

    /* JADX INFO: renamed from: estimateOverDamped$xInflection-0, reason: not valid java name */
    private static final double m129estimateOverDamped$xInflection0(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3, double d4) {
        double dEstimateCriticallyDamped;
        if (d3 == 0.0d && d2 == 0.0d) {
            return 0L;
        }
        if (d3 < 0.0d) {
            d2 = -d2;
        }
        double d5 = d2;
        double dAbs = Math.abs(d3);
        if (d > 1.0d) {
            dEstimateCriticallyDamped = estimateOverDamped(pair, dAbs, d5, d4);
        } else if (d < 1.0d) {
            dEstimateCriticallyDamped = estimateUnderDamped(pair, dAbs, d5, d4);
        } else {
            dEstimateCriticallyDamped = estimateCriticallyDamped(pair, dAbs, d5, d4);
        }
        return (long) (dEstimateCriticallyDamped * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function2) {
        return d - (function1.invoke(Double.valueOf(d)).doubleValue() / function2.invoke(Double.valueOf(d)).doubleValue());
    }

    private static final boolean isNotFinite(double d) {
        return !((Double.isInfinite(d) || Double.isNaN(d)) ? false : true);
    }
}
