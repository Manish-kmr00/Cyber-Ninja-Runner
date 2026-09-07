package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PointerInputEventProcessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "isProcessing", "", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private final HitTestResult<PointerInputFilter> hitResult;
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;
    private final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.hitPathTracker = new HitPathTracker(root.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult<>();
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: process-BIzXfog$default, reason: not valid java name */
    public static /* synthetic */ int m3015processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m3016processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006e A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:7:0x001b, B:9:0x0031, B:21:0x005a, B:22:0x0068, B:24:0x006e, B:26:0x0076, B:28:0x007c, B:30:0x00a4, B:31:0x00b7, B:46:0x0100, B:34:0x00cc, B:36:0x00da, B:39:0x00e4, B:40:0x00e8, B:42:0x00ee, B:44:0x00fa, B:12:0x003b, B:13:0x003f, B:15:0x0045, B:17:0x0051), top: B:52:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ca A[EDGE_INSN: B:33:0x00ca->B:46:0x0100 BREAK  A[LOOP:1: B:40:0x00e8->B:65:0x00e8]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00cc A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:7:0x001b, B:9:0x0031, B:21:0x005a, B:22:0x0068, B:24:0x006e, B:26:0x0076, B:28:0x007c, B:30:0x00a4, B:31:0x00b7, B:46:0x0100, B:34:0x00cc, B:36:0x00da, B:39:0x00e4, B:40:0x00e8, B:42:0x00ee, B:44:0x00fa, B:12:0x003b, B:13:0x003f, B:15:0x0045, B:17:0x0051), top: B:52:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e4 A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:7:0x001b, B:9:0x0031, B:21:0x005a, B:22:0x0068, B:24:0x006e, B:26:0x0076, B:28:0x007c, B:30:0x00a4, B:31:0x00b7, B:46:0x0100, B:34:0x00cc, B:36:0x00da, B:39:0x00e4, B:40:0x00e8, B:42:0x00ee, B:44:0x00fa, B:12:0x003b, B:13:0x003f, B:15:0x0045, B:17:0x0051), top: B:52:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ee A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:7:0x001b, B:9:0x0031, B:21:0x005a, B:22:0x0068, B:24:0x006e, B:26:0x0076, B:28:0x007c, B:30:0x00a4, B:31:0x00b7, B:46:0x0100, B:34:0x00cc, B:36:0x00da, B:39:0x00e4, B:40:0x00e8, B:42:0x00ee, B:44:0x00fa, B:12:0x003b, B:13:0x003f, B:15:0x0045, B:17:0x0051), top: B:52:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX INFO: renamed from: process-BIzXfog, reason: not valid java name */
    public final int m3016processBIzXfog(PointerInputEvent pointerEvent, PositionCalculator positionCalculator, boolean isInBounds) {
        boolean z;
        Collection<PointerInputChange> collectionValues;
        Iterator<T> it;
        PointerInputChange pointerInputChange;
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z2 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent internalPointerEventProduce = this.pointerInputChangeEventProducer.produce(pointerEvent, positionCalculator);
            Collection<PointerInputChange> collectionValues2 = internalPointerEventProduce.getChanges().values();
            if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
                Iterator<T> it2 = collectionValues2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        PointerInputChange pointerInputChange2 = (PointerInputChange) it2.next();
                        if (pointerInputChange2.getPressed() || pointerInputChange2.getPreviousPressed()) {
                            z = false;
                        }
                    }
                    for (PointerInputChange pointerInputChange3 : internalPointerEventProduce.getChanges().values()) {
                        if (!z || PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange3)) {
                            LayoutNode.m3246hitTestM_7yMNQ$ui_release$default(this.root, pointerInputChange3.getPosition(), this.hitResult, PointerType.m3068equalsimpl0(pointerInputChange3.getType(), PointerType.INSTANCE.m3075getTouchT8wyACA()), false, 8, null);
                            if (!this.hitResult.isEmpty()) {
                                this.hitPathTracker.m2930addHitPathKNwqfcY(pointerInputChange3.getId(), this.hitResult);
                                this.hitResult.clear();
                            }
                        }
                    }
                    this.hitPathTracker.removeDetachedPointerInputFilters();
                    boolean zDispatchChanges = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, isInBounds);
                    if (!internalPointerEventProduce.getSuppressMovementConsumption()) {
                        collectionValues = internalPointerEventProduce.getChanges().values();
                        if ((collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                            it = collectionValues.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    pointerInputChange = (PointerInputChange) it.next();
                                    if (!PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange) && pointerInputChange.isConsumed()) {
                                        break;
                                    }
                                }
                            }
                        }
                        z2 = false;
                        break;
                    }
                    z2 = false;
                    break;
                    return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges, z2);
                }
            }
            z = true;
            while (r5.hasNext()) {
                if (!z) {
                }
                LayoutNode.m3246hitTestM_7yMNQ$ui_release$default(this.root, pointerInputChange3.getPosition(), this.hitResult, PointerType.m3068equalsimpl0(pointerInputChange3.getType(), PointerType.INSTANCE.m3075getTouchT8wyACA()), false, 8, null);
                if (!this.hitResult.isEmpty()) {
                    this.hitPathTracker.m2930addHitPathKNwqfcY(pointerInputChange3.getId(), this.hitResult);
                    this.hitResult.clear();
                }
            }
            this.hitPathTracker.removeDetachedPointerInputFilters();
            boolean zDispatchChanges2 = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, isInBounds);
            if (!internalPointerEventProduce.getSuppressMovementConsumption()) {
                z2 = false;
                break;
            }
            collectionValues = internalPointerEventProduce.getChanges().values();
            if (collectionValues instanceof Collection) {
                it = collectionValues.iterator();
                while (true) {
                    if (it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    pointerInputChange = (PointerInputChange) it.next();
                    if (!PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange)) {
                    }
                }
            } else {
                it = collectionValues.iterator();
                while (true) {
                    if (it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    pointerInputChange = (PointerInputChange) it.next();
                    if (!PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange)) {
                    }
                }
            }
            return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges2, z2);
        } finally {
            this.isProcessing = false;
        }
    }

    public final void processCancel() {
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }
}
