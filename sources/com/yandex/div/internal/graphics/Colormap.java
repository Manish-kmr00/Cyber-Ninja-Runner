package com.yandex.div.internal.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Colormap.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/graphics/Colormap;", "", "colors", "", "positions", "", "([I[F)V", "getColors", "()[I", "getPositions", "()[F", "equals", "", "other", "hashCode", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Colormap {
    public static final Colormap EMPTY = new Colormap(new int[0], 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    private final int[] colors;
    private final float[] positions;

    public Colormap(int[] colors, float[] fArr) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.positions = fArr;
        if (colors.length != (fArr != null ? fArr.length : colors.length)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ Colormap(int[] iArr, float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, (i & 2) != 0 ? null : fArr);
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final float[] getPositions() {
        return this.positions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.yandex.div.internal.graphics.Colormap");
        Colormap colormap = (Colormap) other;
        return Arrays.equals(this.colors, colormap.colors) && Arrays.equals(this.positions, colormap.positions);
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.colors) * 31;
        float[] fArr = this.positions;
        return iHashCode + (fArr != null ? Arrays.hashCode(fArr) : 0);
    }
}
