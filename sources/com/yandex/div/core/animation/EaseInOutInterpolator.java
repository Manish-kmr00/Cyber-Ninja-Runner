package com.yandex.div.core.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EaseInOutInterpolator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/yandex/div/core/animation/EaseInOutInterpolator;", "Lcom/yandex/div/core/animation/LookupTableInterpolator;", "()V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EaseInOutInterpolator extends LookupTableInterpolator {
    private static final Companion Companion = new Companion(null);
    private static final float[] VALUES = {0.0f, 0.0f, 2.0E-4f, 4.0E-4f, 8.0E-4f, 0.0012f, 0.0017f, 0.0024f, 0.0031f, 0.0039f, 0.0048f, 0.0059f, 0.007f, 0.0082f, 0.0095f, 0.011f, 0.0125f, 0.0142f, 0.0159f, 0.0178f, 0.0197f, 0.0218f, 0.024f, 0.0262f, 0.0286f, 0.0311f, 0.0337f, 0.0364f, 0.0392f, 0.0422f, 0.0452f, 0.0484f, 0.0516f, 0.055f, 0.0585f, 0.0621f, 0.0658f, 0.0696f, 0.0735f, 0.0775f, 0.0817f, 0.0859f, 0.0903f, 0.0948f, 0.0993f, 0.104f, 0.1088f, 0.1138f, 0.1188f, 0.1239f, 0.1292f, 0.1345f, 0.14f, 0.1455f, 0.1512f, 0.157f, 0.1629f, 0.1688f, 0.1749f, 0.1811f, 0.1874f, 0.1938f, 0.2003f, 0.2068f, 0.2135f, 0.2203f, 0.2272f, 0.2341f, 0.2411f, 0.2483f, 0.2555f, 0.2628f, 0.2702f, 0.2776f, 0.2852f, 0.2928f, 0.3005f, 0.3082f, 0.316f, 0.3239f, 0.3319f, 0.3399f, 0.348f, 0.3561f, 0.3643f, 0.3725f, 0.3808f, 0.3891f, 0.3975f, 0.4059f, 0.4143f, 0.4228f, 0.4313f, 0.4398f, 0.4484f, 0.457f, 0.4656f, 0.4742f, 0.4828f, 0.4914f, 0.5f, 0.5086f, 0.5172f, 0.5258f, 0.5344f, 0.543f, 0.5516f, 0.5602f, 0.5687f, 0.5772f, 0.5857f, 0.5941f, 0.6025f, 0.6109f, 0.6192f, 0.6275f, 0.6357f, 0.6439f, 0.652f, 0.6601f, 0.6681f, 0.6761f, 0.684f, 0.6918f, 0.6995f, 0.7072f, 0.7148f, 0.7224f, 0.7298f, 0.7372f, 0.7445f, 0.7517f, 0.7589f, 0.7659f, 0.7729f, 0.7797f, 0.7865f, 0.7932f, 0.7997f, 0.8062f, 0.8126f, 0.8189f, 0.8251f, 0.8312f, 0.8371f, 0.843f, 0.8488f, 0.8545f, 0.86f, 0.8655f, 0.8708f, 0.8761f, 0.8812f, 0.8862f, 0.8912f, 0.896f, 0.9007f, 0.9052f, 0.9097f, 0.9141f, 0.9183f, 0.9225f, 0.9265f, 0.9304f, 0.9342f, 0.9379f, 0.9415f, 0.945f, 0.9484f, 0.9516f, 0.9548f, 0.9578f, 0.9608f, 0.9636f, 0.9663f, 0.9689f, 0.9714f, 0.9738f, 0.976f, 0.9782f, 0.9803f, 0.9822f, 0.9841f, 0.9858f, 0.9875f, 0.989f, 0.9905f, 0.9918f, 0.993f, 0.9941f, 0.9952f, 0.9961f, 0.9969f, 0.9976f, 0.9983f, 0.9988f, 0.9992f, 0.9996f, 0.9998f, 1.0f, 1.0f};

    public EaseInOutInterpolator() {
        super(VALUES);
    }

    /* JADX INFO: compiled from: EaseInOutInterpolator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/animation/EaseInOutInterpolator$Companion;", "", "()V", "VALUES", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
