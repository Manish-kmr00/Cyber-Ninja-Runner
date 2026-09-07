package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.json.c9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0082\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "(Landroidx/compose/ui/input/pointer/PointerInputFilter;)V", c9.COORDINATES, "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds;
    private final PointerInputFilter pointerInputFilter;
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public Node(PointerInputFilter pointerInputFilter) {
        Intrinsics.checkNotNullParameter(pointerInputFilter, "pointerInputFilter");
        this.pointerInputFilter = pointerInputFilter;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    public final PointerInputFilter getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:59:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:64:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:66:0x01f8  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        PointerInputChange pointerInputChange;
        boolean z;
        int iM2956getExit7fucELk;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean zBuildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        if (!this.pointerInputFilter.getIsAttached()) {
            return true;
        }
        this.coordinates = this.pointerInputFilter.getLayoutCoordinates();
        Iterator<Map.Entry<PointerId, PointerInputChange>> it = changes.entrySet().iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<PointerId, PointerInputChange> next = it.next();
            long jM2987unboximpl = next.getKey().m2987unboximpl();
            PointerInputChange value = next.getValue();
            if (this.pointerIds.contains(PointerId.m2981boximpl(jM2987unboximpl))) {
                ArrayList arrayList = new ArrayList();
                List<HistoricalChange> historical = value.getHistorical();
                for (int size = historical.size(); i < size; size = size) {
                    HistoricalChange historicalChange = historical.get(i);
                    long uptimeMillis = historicalChange.getUptimeMillis();
                    LayoutCoordinates layoutCoordinates = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates);
                    arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo3127localPositionOfR5De75A(parentCoordinates, historicalChange.getPosition()), null));
                    i++;
                    historical = historical;
                }
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                PointerId pointerIdM2981boximpl = PointerId.m2981boximpl(jM2987unboximpl);
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                long jMo3127localPositionOfR5De75A = layoutCoordinates2.mo3127localPositionOfR5De75A(parentCoordinates, value.getPreviousPosition());
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                map.put(pointerIdM2981boximpl, value.m2995copyOHpmEuE((731 & 1) != 0 ? value.id : 0L, (731 & 2) != 0 ? value.uptimeMillis : 0L, (731 & 4) != 0 ? value.position : layoutCoordinates3.mo3127localPositionOfR5De75A(parentCoordinates, value.getPosition()), (731 & 8) != 0 ? value.pressed : false, (731 & 16) != 0 ? value.previousUptimeMillis : 0L, (731 & 32) != 0 ? value.previousPosition : jMo3127localPositionOfR5De75A, (731 & 64) != 0 ? value.previousPressed : false, (731 & 128) != 0 ? value.type : 0, arrayList, (731 & 512) != 0 ? value.scrollDelta : 0L));
            }
        }
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        for (int size2 = this.pointerIds.getSize() - 1; -1 < size2; size2--) {
            if (!changes.containsKey(PointerId.m2981boximpl(this.pointerIds.getContent()[size2].m2987unboximpl()))) {
                this.pointerIds.removeAt(size2);
            }
        }
        PointerEvent pointerEvent = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size3 = changes2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes2.get(i2);
            if (internalPointerEvent.m2931issuesEnterExitEvent0FcD4WY(pointerInputChange.getId())) {
                break;
            }
            i2++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null) {
            if (!isInBounds) {
                this.isIn = false;
            } else {
                if (!this.isIn && (pointerInputChange2.getPressed() || pointerInputChange2.getPreviousPressed())) {
                    LayoutCoordinates layoutCoordinates4 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates4);
                    z = true;
                    this.isIn = !PointerEventKt.m2946isOutOfBoundsO0kMr_c(pointerInputChange2, layoutCoordinates4.mo3126getSizeYbymL2g());
                }
                if (this.isIn == this.wasIn && (PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2957getMove7fucELk()) || PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2955getEnter7fucELk()) || PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk()))) {
                    if (this.isIn) {
                        iM2956getExit7fucELk = PointerEventType.INSTANCE.m2955getEnter7fucELk();
                    } else {
                        iM2956getExit7fucELk = PointerEventType.INSTANCE.m2956getExit7fucELk();
                    }
                    pointerEvent.m2945setTypeEhbLWgg$ui_release(iM2956getExit7fucELk);
                } else if (!PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2955getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                    pointerEvent.m2945setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m2957getMove7fucELk());
                } else if (PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk()) && this.isIn && pointerInputChange2.getPressed()) {
                    pointerEvent.m2945setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m2957getMove7fucELk());
                }
            }
            z = true;
            if (this.isIn == this.wasIn) {
                if (!PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2955getEnter7fucELk())) {
                    if (PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk())) {
                        pointerEvent.m2945setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m2957getMove7fucELk());
                    }
                } else if (PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk())) {
                    pointerEvent.m2945setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m2957getMove7fucELk());
                }
            } else if (!PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2955getEnter7fucELk())) {
                if (PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk())) {
                    pointerEvent.m2945setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m2957getMove7fucELk());
                }
            } else if (PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk())) {
                pointerEvent.m2945setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m2957getMove7fucELk());
            }
        } else {
            z = true;
        }
        boolean z2 = (zBuildCache || !PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2957getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z : false;
        this.pointerEvent = pointerEvent;
        return z2;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m1392equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
        this.pointerInputFilter.onCancel();
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPressed() && (!internalPointerEvent.m2931issuesEnterExitEvent0FcD4WY(pointerInputChange.getId()) || !this.isIn)) {
                this.pointerIds.remove(PointerId.m2981boximpl(pointerInputChange.getId()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m2951equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m2956getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        int i = 0;
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long jMo3126getSizeYbymL2g = layoutCoordinates.mo3126getSizeYbymL2g();
        this.pointerInputFilter.mo3018onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo3126getSizeYbymL2g);
        if (this.pointerInputFilter.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            do {
                Node node = content[i];
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(map, layoutCoordinates2, internalPointerEvent, isInBounds);
                i++;
            } while (i < size);
        }
        if (this.pointerInputFilter.getIsAttached()) {
            this.pointerInputFilter.mo3018onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo3126getSizeYbymL2g);
        }
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.pointerInputFilter.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            this.pointerInputFilter.mo3018onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, layoutCoordinates.mo3126getSizeYbymL2g());
            if (this.pointerInputFilter.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
