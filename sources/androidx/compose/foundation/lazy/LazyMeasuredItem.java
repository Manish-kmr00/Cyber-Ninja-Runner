package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.json.b9;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyMeasuredItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B|\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "(I[Landroidx/compose/ui/layout/Placeable;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIILandroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;IJLjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "getKey", "()Ljava/lang/Object;", "[Landroidx/compose/ui/layout/Placeable;", ContentDisposition.Parameters.Size, "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", b9.h.L, "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "offset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private final Placeable[] placeables;
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    @ExperimentalFoundationApi
    public /* synthetic */ LazyMeasuredItem(int i, Placeable[] placeableArr, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, placeableArr, z, horizontal, vertical, layoutDirection, z2, i2, i3, lazyListItemPlacementAnimator, i4, j, obj);
    }

    private LazyMeasuredItem(int i, Placeable[] placeableArr, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj) {
        this.index = i;
        this.placeables = placeableArr;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        int height = 0;
        int iMax = 0;
        for (Placeable placeable : placeableArr) {
            height += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.sizeWithSpacings = height + this.spacing;
        this.crossAxisSize = iMax;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0082  */
    /* JADX WARN: Code duplicated, block: B:37:0x0087  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3 A[SYNTHETIC] */
    public final LazyListPositionedItem position(int offset, int layoutWidth, int layoutHeight) {
        Placeable placeable;
        int size;
        Alignment.Vertical vertical;
        long jIntOffset;
        int width;
        Alignment.Horizontal horizontal;
        ArrayList arrayList = new ArrayList();
        int i = this.isVertical ? layoutHeight : layoutWidth;
        boolean z = this.reverseLayout;
        int i2 = z ? (i - offset) - this.size : offset;
        int lastIndex = z ? ArraysKt.getLastIndex(this.placeables) : 0;
        while (true) {
            boolean z2 = this.reverseLayout;
            if (z2) {
                if (lastIndex < 0) {
                    break;
                }
                placeable = this.placeables[lastIndex];
                if (z2) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                if (this.isVertical) {
                    horizontal = this.horizontalAlignment;
                    if (horizontal != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    jIntOffset = IntOffsetKt.IntOffset(horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection), i2);
                } else {
                    vertical = this.verticalAlignment;
                    if (vertical != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    jIntOffset = IntOffsetKt.IntOffset(i2, vertical.align(placeable.getHeight(), layoutHeight));
                }
                long j = jIntOffset;
                if (this.isVertical) {
                    width = placeable.getHeight();
                } else {
                    width = placeable.getWidth();
                }
                i2 += width;
                arrayList.add(size, new LazyListPlaceableWrapper(j, placeable, this.placeables[lastIndex].getParentData(), null));
                lastIndex = this.reverseLayout ? lastIndex - 1 : lastIndex + 1;
            } else {
                if (lastIndex >= this.placeables.length) {
                    break;
                }
                placeable = this.placeables[lastIndex];
                if (z2) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                if (this.isVertical) {
                    horizontal = this.horizontalAlignment;
                    if (horizontal != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    jIntOffset = IntOffsetKt.IntOffset(horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection), i2);
                } else {
                    vertical = this.verticalAlignment;
                    if (vertical != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    jIntOffset = IntOffsetKt.IntOffset(i2, vertical.align(placeable.getHeight(), layoutHeight));
                }
                long j2 = jIntOffset;
                if (this.isVertical) {
                    width = placeable.getHeight();
                } else {
                    width = placeable.getWidth();
                }
                i2 += width;
                arrayList.add(size, new LazyListPlaceableWrapper(j2, placeable, this.placeables[lastIndex].getParentData(), null));
                if (this.reverseLayout) {
                }
            }
        }
        int i3 = this.index;
        Object obj = this.key;
        int i4 = this.size;
        int i5 = this.sizeWithSpacings;
        boolean z3 = this.reverseLayout;
        return new LazyListPositionedItem(offset, i3, obj, i4, i5, -(!z3 ? this.beforeContentPadding : this.afterContentPadding), i + (!z3 ? this.afterContentPadding : this.beforeContentPadding), this.isVertical, arrayList, this.placementAnimator, this.visualOffset, null);
    }
}
