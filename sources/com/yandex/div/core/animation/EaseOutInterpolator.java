package com.yandex.div.core.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EaseOutInterpolator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/yandex/div/core/animation/EaseOutInterpolator;", "Lcom/yandex/div/core/animation/LookupTableInterpolator;", "()V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EaseOutInterpolator extends LookupTableInterpolator {
    private static final Companion Companion = new Companion(null);
    private static final float[] VALUES = {0.0f, 0.0085f, 0.0169f, 0.0252f, 0.0335f, 0.0418f, 0.0499f, 0.0581f, 0.0662f, 0.0742f, 0.0822f, 0.0902f, 0.0982f, 0.1061f, 0.114f, 0.1218f, 0.1296f, 0.1374f, 0.1452f, 0.1529f, 0.1606f, 0.1682f, 0.1759f, 0.1835f, 0.191f, 0.1986f, 0.2061f, 0.2136f, 0.221f, 0.2285f, 0.2359f, 0.2432f, 0.2506f, 0.2579f, 0.2652f, 0.2725f, 0.2797f, 0.2869f, 0.2941f, 0.3012f, 0.3084f, 0.3155f, 0.3225f, 0.3296f, 0.3366f, 0.3436f, 0.3506f, 0.3575f, 0.3644f, 0.3713f, 0.3781f, 0.385f, 0.3918f, 0.3985f, 0.4053f, 0.412f, 0.4187f, 0.4254f, 0.432f, 0.4386f, 0.4452f, 0.4517f, 0.4583f, 0.4648f, 0.4712f, 0.4777f, 0.4841f, 0.4905f, 0.4968f, 0.5032f, 0.5095f, 0.5157f, 0.522f, 0.5282f, 0.5344f, 0.5405f, 0.5467f, 0.5528f, 0.5588f, 0.5649f, 0.5709f, 0.5769f, 0.5828f, 0.5887f, 0.5946f, 0.6005f, 0.6063f, 0.6121f, 0.6179f, 0.6236f, 0.6293f, 0.635f, 0.6406f, 0.6463f, 0.6518f, 0.6574f, 0.6629f, 0.6684f, 0.6738f, 0.6793f, 0.6846f, 0.69f, 0.6953f, 0.7006f, 0.7059f, 0.7111f, 0.7163f, 0.7214f, 0.7265f, 0.7316f, 0.7367f, 0.7417f, 0.7466f, 0.7516f, 0.7565f, 0.7614f, 0.7662f, 0.771f, 0.7757f, 0.7805f, 0.7851f, 0.7898f, 0.7944f, 0.799f, 0.8035f, 0.808f, 0.8124f, 0.8168f, 0.8212f, 0.8255f, 0.8298f, 0.8341f, 0.8383f, 0.8425f, 0.8466f, 0.8507f, 0.8547f, 0.8587f, 0.8627f, 0.8666f, 0.8704f, 0.8742f, 0.878f, 0.8817f, 0.8854f, 0.8891f, 0.8927f, 0.8962f, 0.8997f, 0.9031f, 0.9065f, 0.9099f, 0.9132f, 0.9164f, 0.9196f, 0.9228f, 0.9259f, 0.9289f, 0.9319f, 0.9348f, 0.9377f, 0.9405f, 0.9433f, 0.946f, 0.9487f, 0.9513f, 0.9538f, 0.9563f, 0.9588f, 0.9611f, 0.9634f, 0.9657f, 0.9679f, 0.97f, 0.972f, 0.974f, 0.9759f, 0.9778f, 0.9796f, 0.9813f, 0.983f, 0.9846f, 0.9861f, 0.9875f, 0.9889f, 0.9902f, 0.9914f, 0.9926f, 0.9936f, 0.9946f, 0.9955f, 0.9964f, 0.9971f, 0.9978f, 0.9984f, 0.9989f, 0.9993f, 0.9996f, 0.9998f, 1.0f, 1.0f};

    public EaseOutInterpolator() {
        super(VALUES);
    }

    /* JADX INFO: compiled from: EaseOutInterpolator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/animation/EaseOutInterpolator$Companion;", "", "()V", "VALUES", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
