package com.yandex.div.core.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EaseInterpolator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/yandex/div/core/animation/EaseInterpolator;", "Lcom/yandex/div/core/animation/LookupTableInterpolator;", "()V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EaseInterpolator extends LookupTableInterpolator {
    private static final Companion Companion = new Companion(null);
    private static final float[] VALUES = {0.0f, 0.0021f, 0.0045f, 0.0071f, 0.01f, 0.0131f, 0.0165f, 0.0202f, 0.0242f, 0.0284f, 0.033f, 0.0378f, 0.0429f, 0.0483f, 0.0541f, 0.0601f, 0.0664f, 0.0731f, 0.08f, 0.0872f, 0.0948f, 0.1026f, 0.1108f, 0.1192f, 0.1279f, 0.1369f, 0.1461f, 0.1556f, 0.1653f, 0.1753f, 0.1855f, 0.1958f, 0.2064f, 0.2171f, 0.2279f, 0.2389f, 0.25f, 0.2612f, 0.2725f, 0.2839f, 0.2952f, 0.3067f, 0.3181f, 0.3295f, 0.341f, 0.3524f, 0.3637f, 0.375f, 0.3863f, 0.3974f, 0.4085f, 0.4195f, 0.4304f, 0.4412f, 0.4519f, 0.4624f, 0.4729f, 0.4832f, 0.4934f, 0.5034f, 0.5133f, 0.5231f, 0.5327f, 0.5422f, 0.5516f, 0.5608f, 0.5699f, 0.5788f, 0.5876f, 0.5963f, 0.6048f, 0.6132f, 0.6214f, 0.6295f, 0.6375f, 0.6453f, 0.653f, 0.6606f, 0.668f, 0.6754f, 0.6825f, 0.6896f, 0.6965f, 0.7034f, 0.7101f, 0.7166f, 0.7231f, 0.7295f, 0.7357f, 0.7418f, 0.7479f, 0.7538f, 0.7596f, 0.7653f, 0.7709f, 0.7764f, 0.7818f, 0.7871f, 0.7923f, 0.7974f, 0.8024f, 0.8073f, 0.8122f, 0.8169f, 0.8216f, 0.8261f, 0.8306f, 0.835f, 0.8394f, 0.8436f, 0.8478f, 0.8518f, 0.8558f, 0.8598f, 0.8636f, 0.8674f, 0.8711f, 0.8747f, 0.8783f, 0.8818f, 0.8852f, 0.8886f, 0.8919f, 0.8951f, 0.8983f, 0.9014f, 0.9044f, 0.9074f, 0.9103f, 0.9131f, 0.9159f, 0.9187f, 0.9213f, 0.924f, 0.9265f, 0.929f, 0.9315f, 0.9339f, 0.9362f, 0.9385f, 0.9408f, 0.943f, 0.9451f, 0.9472f, 0.9492f, 0.9512f, 0.9532f, 0.9551f, 0.9569f, 0.9587f, 0.9605f, 0.9622f, 0.9638f, 0.9655f, 0.967f, 0.9686f, 0.9701f, 0.9715f, 0.9729f, 0.9743f, 0.9756f, 0.9769f, 0.9782f, 0.9794f, 0.9805f, 0.9817f, 0.9828f, 0.9838f, 0.9848f, 0.9858f, 0.9868f, 0.9877f, 0.9886f, 0.9894f, 0.9902f, 0.991f, 0.9917f, 0.9924f, 0.9931f, 0.9937f, 0.9943f, 0.9949f, 0.9954f, 0.9959f, 0.9964f, 0.9969f, 0.9973f, 0.9977f, 0.998f, 0.9983f, 0.9986f, 0.9989f, 0.9991f, 0.9993f, 0.9995f, 0.9997f, 0.9998f, 0.9999f, 0.9999f, 1.0f, 1.0f};

    public EaseInterpolator() {
        super(VALUES);
    }

    /* JADX INFO: compiled from: EaseInterpolator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/animation/EaseInterpolator$Companion;", "", "()V", "VALUES", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
