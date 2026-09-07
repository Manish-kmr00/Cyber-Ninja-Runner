package com.yandex.div.core.view2.divs.gallery;

import com.yandex.div2.DivGallery;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollPosition.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toScrollPosition", "Lcom/yandex/div/core/view2/divs/gallery/ScrollPosition;", "Lcom/yandex/div2/DivGallery$ScrollMode;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ScrollPositionKt {

    /* JADX INFO: compiled from: ScrollPosition.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivGallery.ScrollMode.values().length];
            try {
                iArr[DivGallery.ScrollMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivGallery.ScrollMode.PAGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ScrollPosition toScrollPosition(DivGallery.ScrollMode scrollMode) {
        Intrinsics.checkNotNullParameter(scrollMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[scrollMode.ordinal()];
        if (i == 1) {
            return ScrollPosition.DEFAULT;
        }
        if (i == 2) {
            return ScrollPosition.CENTER;
        }
        throw new NoWhenBranchMatchedException();
    }
}
