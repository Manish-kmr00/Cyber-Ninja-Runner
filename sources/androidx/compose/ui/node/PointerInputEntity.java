package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerInputModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PointerInputEntity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/node/PointerInputEntity;", "Landroidx/compose/ui/node/LayoutNodeEntity;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "layoutNodeWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/pointer/PointerInputModifier;)V", "onAttach", "", "onDetach", "shouldSharePointerInputWithSiblings", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointerInputEntity extends LayoutNodeEntity<PointerInputEntity, PointerInputModifier> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerInputEntity(LayoutNodeWrapper layoutNodeWrapper, PointerInputModifier modifier) {
        super(layoutNodeWrapper, modifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "layoutNodeWrapper");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onAttach() {
        super.onAttach();
        getModifier().getPointerInputFilter().setLayoutCoordinates$ui_release(getLayoutNodeWrapper());
        getModifier().getPointerInputFilter().setAttached$ui_release(true);
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onDetach() {
        super.onDetach();
        getModifier().getPointerInputFilter().setAttached$ui_release(false);
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        if (!getModifier().getPointerInputFilter().getShareWithSiblings()) {
            PointerInputEntity next = getNext();
            if (!(next != null ? next.shouldSharePointerInputWithSiblings() : false)) {
                return false;
            }
        }
        return true;
    }
}
