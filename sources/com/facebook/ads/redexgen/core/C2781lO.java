package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2781lO implements C4R {
    public static String[] A02 = {"gru2Lda4S7GCbNBLtOIdQEnlbYeRFwfL", "XnGCgKT7Pg2", "mKUX8sgZfunspLF5wjmFH8sDBtb3K48d", "jKk7kH4cQGBiDg5TKe33YqGV3AsPygQR", "TZdQK9usf81OKXIWMb61JsmxOZFMnA3k", "eyC2dzaRwXiJKVGsgdgz1meLL5sRgImY", "S4mkNNYHIh7xNNZ0OEskqLhCY0hDyySt", "ZXfiglEYlIOoTIuj216uQxYNuz12aQjw"};
    public final Rect A00 = new Rect();
    public final /* synthetic */ C13314v A01;

    public C2781lO(C13314v c13314v) {
        this.A01 = c13314v;
    }

    @Override // com.facebook.ads.redexgen.core.C4R
    public final C13344y ACE(View view, C13344y c13344y) {
        C13344y c13344yA06 = C4h.A06(view, c13344y);
        if (c13344yA06.A07()) {
            return c13344yA06;
        }
        Rect rect = this.A00;
        rect.left = c13344yA06.A03();
        rect.top = c13344yA06.A05();
        rect.right = c13344yA06.A04();
        rect.bottom = c13344yA06.A02();
        int count = this.A01.getChildCount();
        for (int i = 0; i < count; i++) {
            C13344y c13344yA05 = C4h.A05(this.A01.getChildAt(i), c13344yA06);
            rect.left = Math.min(c13344yA05.A03(), rect.left);
            rect.top = Math.min(c13344yA05.A05(), rect.top);
            rect.right = Math.min(c13344yA05.A04(), rect.right);
            rect.bottom = Math.min(c13344yA05.A02(), rect.bottom);
        }
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        if (A02[1].length() != 11) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[6] = "4mRHs0uPE72ppwyI9I2NgTpzqE63n9j5";
        strArr[2] = "Zp0DshFYJF7gm0rY227qRNMYobzVhEjB";
        C13344y applied = c13344yA06.A06(i2, i3, i4, i5);
        return applied;
    }
}
