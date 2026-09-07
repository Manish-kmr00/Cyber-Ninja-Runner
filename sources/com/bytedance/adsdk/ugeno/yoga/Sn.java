package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes13.dex */
public class Sn extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            WV();
        } finally {
            super.finalize();
        }
    }

    public void WV() {
        if (this.pA != 0) {
            long j = this.pA;
            this.pA = 0L;
            YogaNative.jni_YGNodeDeallocateJNI(j);
        }
    }
}
