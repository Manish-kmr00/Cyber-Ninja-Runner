package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: LazyMeasuredItemProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/MeasuredItemFactory;", "", "createItem", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/DataIndex;", "key", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-HK0c1C0", "(ILjava/lang/Object;[Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MeasuredItemFactory {
    /* JADX INFO: renamed from: createItem-HK0c1C0 */
    LazyMeasuredItem mo539createItemHK0c1C0(int index, Object key, Placeable[] placeables);
}
