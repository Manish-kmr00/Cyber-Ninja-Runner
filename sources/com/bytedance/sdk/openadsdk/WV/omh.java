package com.bytedance.sdk.openadsdk.WV;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: loaded from: classes9.dex */
public class omh {
    private final AudioManager pA;
    private int Og = -1;
    private boolean KZx = false;

    public omh(Context context) {
        this.pA = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int pA() {
        return this.Og;
    }

    public void pA(int i) {
        this.Og = i;
    }

    public boolean Og() {
        if (!this.KZx) {
            return false;
        }
        this.KZx = false;
        return true;
    }

    public void pA(boolean z) {
        pA(z, false);
    }

    public void pA(boolean z, boolean z2) {
        if (this.pA == null) {
            return;
        }
        int i = 0;
        if (z) {
            int iSD = DeviceUtils.SD();
            if (iSD != 0) {
                this.Og = iSD;
            } else if (!z2) {
                return;
            }
            pA(3, 0, 0);
            this.KZx = true;
            return;
        }
        int iBzk = this.Og;
        if (iBzk == 0) {
            iBzk = DeviceUtils.Bzk() / 15;
        } else {
            if (iBzk == -1) {
                if (!z2) {
                    return;
                } else {
                    iBzk = DeviceUtils.Bzk() / 15;
                }
            }
            this.Og = -1;
            pA(3, iBzk, i);
            this.KZx = true;
        }
        i = 1;
        this.Og = -1;
        pA(3, iBzk, i);
        this.KZx = true;
    }

    private void pA(int i, int i2, int i3) {
        try {
            this.pA.setStreamVolume(i, i2, i3);
        } catch (Throwable unused) {
        }
    }
}
