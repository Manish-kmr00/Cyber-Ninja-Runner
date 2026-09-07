package com.yandex.div.core.view2.divs.gallery;

import android.view.ViewGroup;
import com.yandex.div.internal.widget.DivLayoutParams;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivGalleryItemLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0003"}, d2 = {"setBy", "Landroid/view/ViewGroup$LayoutParams;", "other", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivGalleryItemLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup.LayoutParams setBy(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2) {
        if (layoutParams2 == null) {
            return layoutParams;
        }
        layoutParams.width = layoutParams2.width;
        layoutParams.height = layoutParams2.height;
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.leftMargin = marginLayoutParams2.leftMargin;
            marginLayoutParams.topMargin = marginLayoutParams2.topMargin;
            marginLayoutParams.rightMargin = marginLayoutParams2.rightMargin;
            marginLayoutParams.bottomMargin = marginLayoutParams2.bottomMargin;
            if (marginLayoutParams2.isMarginRelative()) {
                marginLayoutParams.setMarginStart(marginLayoutParams2.getMarginStart());
                marginLayoutParams.setMarginEnd(marginLayoutParams2.getMarginEnd());
            }
        }
        if ((layoutParams instanceof DivLayoutParams) && (layoutParams2 instanceof DivLayoutParams)) {
            DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
            DivLayoutParams divLayoutParams2 = (DivLayoutParams) layoutParams2;
            divLayoutParams.setMaxWidth(divLayoutParams2.getMaxWidth());
            divLayoutParams.setMaxHeight(divLayoutParams2.getMaxHeight());
        }
        return layoutParams;
    }
}
