package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HW {
    public final int[] A00(View view, int i, int i2) {
        AnonymousClass63 anonymousClass63 = (AnonymousClass63) view.getLayoutParams();
        int childHeightSpec = ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), anonymousClass63.width);
        int childWidthSpec = view.getPaddingTop();
        view.measure(childHeightSpec, ViewGroup.getChildMeasureSpec(i2, childWidthSpec + view.getPaddingBottom(), anonymousClass63.height));
        int childWidthSpec2 = view.getMeasuredWidth();
        int childWidthSpec3 = view.getMeasuredHeight();
        return new int[]{childWidthSpec2 + anonymousClass63.leftMargin + anonymousClass63.rightMargin, childWidthSpec3 + anonymousClass63.bottomMargin + anonymousClass63.topMargin};
    }
}
