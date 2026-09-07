package com.yandex.div.core.view2.divs.pager;

import com.json.b9;
import com.yandex.div2.DivPager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPagerPageSizeProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0002\u0010\fJ\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerPageSizeProvider;", "", "parentSize", "", "paddings", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "alignment", "Lcom/yandex/div2/DivPager$ItemAlignment;", "(ILcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;Lcom/yandex/div2/DivPager$ItemAlignment;)V", "getCenteredNeighbourSize", "", b9.h.L, "(I)Ljava/lang/Float;", "getItemSize", "getNextNeighbourSize", "getPrevNeighbourSize", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivPagerPageSizeProvider {
    private final DivPager.ItemAlignment alignment;
    private final DivPagerPaddingsHolder paddings;
    private final int parentSize;

    /* JADX INFO: compiled from: DivPagerPageSizeProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivPager.ItemAlignment.values().length];
            try {
                iArr[DivPager.ItemAlignment.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivPager.ItemAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivPager.ItemAlignment.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract Float getItemSize(int position);

    public DivPagerPageSizeProvider(int i, DivPagerPaddingsHolder paddings, DivPager.ItemAlignment alignment) {
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.parentSize = i;
        this.paddings = paddings;
        this.alignment = alignment;
    }

    public final Float getPrevNeighbourSize(int position) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i == 1) {
            return Float.valueOf(this.paddings.getStart());
        }
        if (i == 2) {
            return getCenteredNeighbourSize(position);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Float itemSize = getItemSize(position);
        if (itemSize == null) {
            return null;
        }
        return Float.valueOf((this.parentSize - this.paddings.getEnd()) - itemSize.floatValue());
    }

    public final Float getNextNeighbourSize(int position) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return getCenteredNeighbourSize(position);
            }
            if (i == 3) {
                return Float.valueOf(this.paddings.getEnd());
            }
            throw new NoWhenBranchMatchedException();
        }
        Float itemSize = getItemSize(position);
        if (itemSize == null) {
            return null;
        }
        return Float.valueOf((this.parentSize - this.paddings.getStart()) - itemSize.floatValue());
    }

    private final Float getCenteredNeighbourSize(int position) {
        Float itemSize = getItemSize(position);
        if (itemSize == null) {
            return null;
        }
        return Float.valueOf((this.parentSize - itemSize.floatValue()) / 2.0f);
    }
}
