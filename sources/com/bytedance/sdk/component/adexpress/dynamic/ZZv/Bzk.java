package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public class Bzk {
    public float Og;
    public float pA;

    public Bzk(float f, float f2) {
        this.pA = f;
        this.Og = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Bzk bzk = (Bzk) obj;
            if (Float.compare(bzk.pA, this.pA) == 0 && Float.compare(bzk.Og, this.Og) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.pA), Float.valueOf(this.Og)});
    }
}
