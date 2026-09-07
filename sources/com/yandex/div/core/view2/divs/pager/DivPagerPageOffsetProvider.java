package com.yandex.div.core.view2.divs.pager;

import com.json.b9;
import com.yandex.div2.DivPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.utils.svgparser.utils.CSSFontFeatureSettings;

/* JADX INFO: compiled from: DivPagerPageOffsetProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J \u0010!\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002J\u001e\u0010$\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000bJ \u0010%\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0014\u0010&\u001a\u00020\u000b*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006("}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerPageOffsetProvider;", "", "parentSize", "", "itemSpacing", "", "pageSizeProvider", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPageSizeProvider;", "paddings", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "infiniteScroll", "", "adapter", "Lcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;", "alignment", "Lcom/yandex/div2/DivPager$ItemAlignment;", "(IFLcom/yandex/div/core/view2/divs/pager/DivPagerPageSizeProvider;Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;ZLcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;Lcom/yandex/div2/DivPager$ItemAlignment;)V", CSSFontFeatureSettings.FEATURE_FRAC, "getFrac", "(F)F", "fracInverted", "getFracInverted", "contentIsSmallerThanPager", b9.h.L, "prevActivePage", "nextActivePage", "getEndOffset", "getInitialOffset", "pagePosition", "isOverlap", "getInitialStartOffset", "part", "getOffset", "getOffsetForSmallContent", "getOnePositionOffset", "sign", "getPageOffset", "getStartOffset", "biggerThan", "maxOffset", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerPageOffsetProvider {
    private final DivPagerAdapter adapter;
    private final DivPager.ItemAlignment alignment;
    private final boolean infiniteScroll;
    private final float itemSpacing;
    private final DivPagerPaddingsHolder paddings;
    private final DivPagerPageSizeProvider pageSizeProvider;
    private final int parentSize;

    public DivPagerPageOffsetProvider(int i, float f, DivPagerPageSizeProvider pageSizeProvider, DivPagerPaddingsHolder paddings, boolean z, DivPagerAdapter adapter, DivPager.ItemAlignment alignment) {
        Intrinsics.checkNotNullParameter(pageSizeProvider, "pageSizeProvider");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.parentSize = i;
        this.itemSpacing = f;
        this.pageSizeProvider = pageSizeProvider;
        this.paddings = paddings;
        this.infiniteScroll = z;
        this.adapter = adapter;
        this.alignment = alignment;
    }

    public final float getPageOffset(float position, int pagePosition, boolean isOverlap) {
        return getOffset(position, pagePosition) - getInitialOffset(position, pagePosition, isOverlap);
    }

    private final float getOffset(float position, int pagePosition) {
        if (position == 0.0f) {
            return 0.0f;
        }
        int iSignum = (int) Math.signum(position);
        int iAbs = (int) Math.abs(position);
        int i = 1;
        float onePositionOffset = 0.0f;
        if (1 <= iAbs) {
            while (true) {
                onePositionOffset += getOnePositionOffset(pagePosition, iSignum);
                pagePosition -= iSignum;
                if (i == iAbs) {
                    break;
                }
                i++;
            }
        }
        float frac = getFrac(position);
        return onePositionOffset + (frac > 0.0f ? frac * getOnePositionOffset(pagePosition, iSignum) : 0.0f);
    }

    private final float getOnePositionOffset(int position, int sign) {
        Float prevNeighbourSize = this.pageSizeProvider.getPrevNeighbourSize(sign > 0 ? position : position + 1);
        if (prevNeighbourSize != null) {
            float fFloatValue = prevNeighbourSize.floatValue();
            DivPagerPageSizeProvider divPagerPageSizeProvider = this.pageSizeProvider;
            if (sign > 0) {
                position--;
            }
            Float nextNeighbourSize = divPagerPageSizeProvider.getNextNeighbourSize(position);
            if (nextNeighbourSize != null) {
                return ((fFloatValue + nextNeighbourSize.floatValue()) - this.itemSpacing) * sign;
            }
        }
        return 0.0f;
    }

    private final float getInitialOffset(float position, int pagePosition, boolean isOverlap) {
        if (isOverlap) {
            return 0.0f;
        }
        double d = position;
        int iCeil = pagePosition - ((int) Math.ceil(d));
        int iFloor = pagePosition - ((int) Math.floor(d));
        if (contentIsSmallerThanPager(position, iCeil, iFloor)) {
            return getOffsetForSmallContent(position, iCeil, iFloor);
        }
        if (this.infiniteScroll) {
            return 0.0f;
        }
        float startOffset = getStartOffset(position, iCeil, iFloor);
        if (startOffset != 0.0f) {
            return startOffset;
        }
        float endOffset = getEndOffset(position, iCeil, iFloor);
        if (endOffset == 0.0f) {
            return 0.0f;
        }
        return endOffset;
    }

    private final float getStartOffset(float position, int prevActivePage, int nextActivePage) {
        Float itemSize;
        if (this.alignment == DivPager.ItemAlignment.START) {
            return 0.0f;
        }
        float frac = position <= 0.0f ? getFrac(position) : getFracInverted(position);
        float initialStartOffset = getInitialStartOffset(prevActivePage, nextActivePage, frac);
        if (initialStartOffset == 0.0f || (itemSize = this.pageSizeProvider.getItemSize(prevActivePage)) == null) {
            return 0.0f;
        }
        float fFloatValue = itemSize.floatValue() * frac;
        if (biggerThan(fFloatValue, initialStartOffset)) {
            return 0.0f;
        }
        do {
            prevActivePage--;
            if (-1 >= prevActivePage) {
                return fFloatValue - initialStartOffset;
            }
            Float itemSize2 = this.pageSizeProvider.getItemSize(prevActivePage);
            if (itemSize2 == null) {
                return 0.0f;
            }
            fFloatValue += itemSize2.floatValue() + this.itemSpacing;
        } while (!biggerThan(fFloatValue, initialStartOffset));
        return 0.0f;
    }

    private final float getEndOffset(float position, int prevActivePage, int nextActivePage) {
        Float nextNeighbourSize;
        Float itemSize;
        if (this.alignment != DivPager.ItemAlignment.END && (nextNeighbourSize = this.pageSizeProvider.getNextNeighbourSize(prevActivePage)) != null) {
            float fFloatValue = nextNeighbourSize.floatValue();
            Float nextNeighbourSize2 = this.pageSizeProvider.getNextNeighbourSize(nextActivePage);
            if (nextNeighbourSize2 != null) {
                float fFloatValue2 = nextNeighbourSize2.floatValue();
                float frac = position > 0.0f ? getFrac(position) : getFracInverted(position);
                float end = ((fFloatValue * frac) + (fFloatValue2 * (1 - frac))) - this.paddings.getEnd();
                if (end != 0.0f && (itemSize = this.pageSizeProvider.getItemSize(nextActivePage)) != null) {
                    float fFloatValue3 = itemSize.floatValue() * frac;
                    if (biggerThan(fFloatValue3, end)) {
                        return 0.0f;
                    }
                    int itemCount = this.adapter.getItemCount();
                    for (int i = nextActivePage + 1; i < itemCount; i++) {
                        Float itemSize2 = this.pageSizeProvider.getItemSize(i);
                        if (itemSize2 == null) {
                            return 0.0f;
                        }
                        fFloatValue3 += itemSize2.floatValue() + this.itemSpacing;
                        if (biggerThan(fFloatValue3, end)) {
                            return 0.0f;
                        }
                    }
                    return end - fFloatValue3;
                }
            }
        }
        return 0.0f;
    }

    private final float getFrac(float f) {
        float fAbs = Math.abs(f);
        return fAbs - ((float) Math.floor(fAbs));
    }

    private final float getFracInverted(float f) {
        float frac = getFrac(f);
        if (frac > 0.0f) {
            return 1 - frac;
        }
        return 0.0f;
    }

    private final boolean biggerThan(float f, float f2) {
        return f >= Math.abs(f2);
    }

    private final boolean contentIsSmallerThanPager(float position, int prevActivePage, int nextActivePage) {
        float start = (this.parentSize - this.paddings.getStart()) - this.paddings.getEnd();
        float frac = position > 0.0f ? getFrac(position) : getFracInverted(position);
        Float itemSize = this.pageSizeProvider.getItemSize(prevActivePage);
        if (itemSize != null) {
            float fFloatValue = itemSize.floatValue() * frac;
            if (fFloatValue >= start) {
                return false;
            }
            float f = 1 - frac;
            Float itemSize2 = this.pageSizeProvider.getItemSize(nextActivePage);
            if (itemSize2 != null) {
                float fFloatValue2 = fFloatValue + (f * itemSize2.floatValue());
                if (fFloatValue2 >= start) {
                    return false;
                }
                if (prevActivePage != nextActivePage) {
                    fFloatValue2 += this.itemSpacing;
                    if (fFloatValue2 >= start) {
                        return false;
                    }
                }
                for (int i = prevActivePage - 1; -1 < i; i--) {
                    float f2 = this.itemSpacing;
                    Float itemSize3 = this.pageSizeProvider.getItemSize(i);
                    if (itemSize3 == null) {
                        break;
                    }
                    fFloatValue2 += f2 + itemSize3.floatValue();
                    if (fFloatValue2 >= start) {
                        return false;
                    }
                }
                int itemCount = this.adapter.getItemCount();
                for (int i2 = nextActivePage + 1; i2 < itemCount; i2++) {
                    float f3 = this.itemSpacing;
                    Float itemSize4 = this.pageSizeProvider.getItemSize(i2);
                    if (itemSize4 == null) {
                        break;
                    }
                    fFloatValue2 += f3 + itemSize4.floatValue();
                    if (fFloatValue2 >= start) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final float getOffsetForSmallContent(float position, int prevActivePage, int nextActivePage) {
        float frac = position <= 0.0f ? getFrac(position) : getFracInverted(position);
        Float itemSize = this.pageSizeProvider.getItemSize(prevActivePage);
        if (itemSize == null) {
            return 0.0f;
        }
        float fFloatValue = itemSize.floatValue() * frac;
        for (int i = prevActivePage - 1; -1 < i; i--) {
            Float itemSize2 = this.pageSizeProvider.getItemSize(i);
            if (itemSize2 == null) {
                return 0.0f;
            }
            fFloatValue += itemSize2.floatValue() + this.itemSpacing;
        }
        return fFloatValue - getInitialStartOffset(prevActivePage, nextActivePage, frac);
    }

    private final float getInitialStartOffset(int prevActivePage, int nextActivePage, float part) {
        Float prevNeighbourSize = this.pageSizeProvider.getPrevNeighbourSize(prevActivePage);
        if (prevNeighbourSize != null) {
            float fFloatValue = prevNeighbourSize.floatValue();
            Float prevNeighbourSize2 = this.pageSizeProvider.getPrevNeighbourSize(nextActivePage);
            if (prevNeighbourSize2 != null) {
                return ((fFloatValue * (1 - part)) + (prevNeighbourSize2.floatValue() * part)) - this.paddings.getStart();
            }
        }
        return 0.0f;
    }
}
