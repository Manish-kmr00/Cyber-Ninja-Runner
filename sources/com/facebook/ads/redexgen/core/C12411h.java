package com.facebook.ads.redexgen.core;

import android.os.Build;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C12411h extends MG {
    public static String[] A00 = {"4mrgyhu5NuMSfoRJ7wvth", "0QrbVGKHuGc2eSGsbm7N10peHve4GVgP", "Meba3O6SWeMBrZzPyfP10SBJe7jX", "3Oa5wanHMWuCrkjHvXNfwyLB0ZtCKHr4", "YOQh7xYBrfW2123ECT3lDkRgUFpenV07", "JuO7BKBrPjkMVs4", "5m", "UWhmaXdvjdchgK72Wd2HML9QO634NCpp"};

    public C12411h(C2699k1 c2699k1) {
        super(c2699k1);
        setCarouselLayoutManager(c2699k1);
    }

    public AbstractC2287dE getFullscreenCarouselRecyclerViewAdapter() {
        getAdapter();
        if (0 != 0) {
            getAdapter();
            return null;
        }
        if (A00[6].length() != 2) {
            throw new RuntimeException();
        }
        A00[2] = "XAsjP5XwQSgGjSaOGRXjEIyXW47w";
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.MG
    public C2771lC getLayoutManager() {
        return (C2771lC) super.getLayoutManager();
    }

    public AnonymousClass67 getOnScrollListener() {
        return new C2571ht(this);
    }

    private void setCarouselLayoutManager(C2699k1 c2699k1) {
        C2771lC c2771lC = new C2771lC(c2699k1, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c2771lC.A1R(true);
        }
        super.setLayoutManager(c2771lC);
    }

    @Override // com.facebook.ads.redexgen.core.MG
    public void setLayoutManager(AnonymousClass62 anonymousClass62) {
    }
}
