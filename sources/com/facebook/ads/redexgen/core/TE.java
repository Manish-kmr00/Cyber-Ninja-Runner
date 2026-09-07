package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TE implements InterfaceC2013Wv {
    public static String[] A02 = {"a2t7hKlINZLuDHqFYaKIJCn3zbxvPUfQ", "94a1Zn", "G2LSQtUOdoxhw3yWQ5b88lZyXtNm5pHf", "28AZETnBhQYLiv3atlnXlfqyoKufPAYL", "A4QfPXHGL9Vbw1YpM4HcmTEDUw1R", "ldpwbSFR8wjokhW3", "VArigWWU5dYMGcXAaIZ6Dasx6MsC8ix5", "DEiyKpuf8STflGLQJbYr6CV2LmYUMPhK"};
    public final long[] A00;
    public final C1853Qh[] A01;

    public TE(C1853Qh[] c1853QhArr, long[] jArr) {
        this.A01 = c1853QhArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final List<C1853Qh> A7N(long j) {
        int iA0L = AbstractC2471gE.A0L(this.A00, j, true, false);
        if (iA0L == -1 || this.A01[iA0L] == C1853Qh.A0J) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.A01[iA0L]);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final long A7t(int i) {
        boolean z = true;
        AbstractC2388es.A07(i >= 0);
        String[] strArr = A02;
        if (strArr[5].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[6] = "9ioBXMOLlW8mQ3fTIVT8oSqJ6BOqH8Vr";
        strArr2[7] = "rImW2whSLRJhLvWc0fieWmjFVtuIvTRn";
        if (i >= this.A00.length) {
            z = false;
        }
        AbstractC2388es.A07(z);
        long[] jArr = this.A00;
        String[] strArr3 = A02;
        if (strArr3[6].charAt(11) == strArr3[7].charAt(11)) {
            return jArr[i];
        }
        String[] strArr4 = A02;
        strArr4[3] = "B7EXgVCi8Il3EYqtjheKhCzhnCsyDEIA";
        strArr4[0] = "XAUrJtUU1J6gmYL2gcldbU7vIAVfMsyc";
        return jArr[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A7u() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A8Q(long j) {
        int iA0K = AbstractC2471gE.A0K(this.A00, j, false, false);
        int index = this.A00.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
