package com.yandex.div.evaluable.function;

import kotlin.Metadata;

/* JADX INFO: compiled from: ColorFunctions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toColorFloatComponentValue", "", "", "toColorIntComponentValue", "div-evaluable"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ColorFunctionsKt {
    public static final double toColorFloatComponentValue(int i) throws IllegalArgumentException {
        if (i < 0 || i >= 256) {
            throw new IllegalArgumentException("Value out of channel range 0..255");
        }
        return ((double) i) / ((double) 255.0f);
    }

    public static final int toColorIntComponentValue(double d) throws IllegalArgumentException {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException();
        }
        return (int) ((d * ((double) 255.0f)) + ((double) 0.5f));
    }
}
