package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.EntityList;
import androidx.compose.ui.node.LayoutNodeEntity;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemanticsEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ'\u0010\r\u001a\u0004\u0018\u00010\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u000fH\u0080\bø\u0001\u0000¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsEntity;", "Landroidx/compose/ui/node/LayoutNodeEntity;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/semantics/SemanticsModifier;)V", "useMinimumTouchTarget", "", "getUseMinimumTouchTarget", "()Z", "collapsedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "nearestSemantics", "predicate", "Lkotlin/Function1;", "nearestSemantics$ui_release", "onAttach", "", "onDetach", "toString", "", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SemanticsEntity extends LayoutNodeEntity<SemanticsEntity, SemanticsModifier> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemanticsEntity(LayoutNodeWrapper wrapped, SemanticsModifier modifier) {
        super(wrapped, modifier);
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
    }

    private final boolean getUseMinimumTouchTarget() {
        return SemanticsConfigurationKt.getOrNull(getModifier().getSemanticsConfiguration(), SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public final SemanticsConfiguration collapsedSemanticsConfiguration() {
        SemanticsEntity next = getNext();
        SemanticsEntity semanticsEntity = null;
        if (next == null) {
            LayoutNodeWrapper wrapped$ui_release = getLayoutNodeWrapper().getWrapped();
            if (wrapped$ui_release != null) {
                while (wrapped$ui_release != null && !EntityList.m3224has0OSVbXo(wrapped$ui_release.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3235getSemanticsEntityTypeEEbPh1w())) {
                    wrapped$ui_release = wrapped$ui_release.getWrapped();
                }
                if (wrapped$ui_release != null && (next = (SemanticsEntity) EntityList.m3226head0OSVbXo(wrapped$ui_release.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3235getSemanticsEntityTypeEEbPh1w())) != null) {
                    LayoutNodeWrapper layoutNodeWrapper = next.getLayoutNodeWrapper();
                    while (layoutNodeWrapper != null) {
                        if (next != null) {
                            semanticsEntity = next;
                            break;
                        }
                        layoutNodeWrapper = layoutNodeWrapper.getWrapped();
                        next = layoutNodeWrapper != null ? (SemanticsEntity) EntityList.m3226head0OSVbXo(layoutNodeWrapper.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3235getSemanticsEntityTypeEEbPh1w()) : null;
                    }
                }
            }
        } else {
            LayoutNodeWrapper layoutNodeWrapper2 = next.getLayoutNodeWrapper();
            while (layoutNodeWrapper2 != null) {
                if (next != null) {
                    semanticsEntity = next;
                    break;
                }
                layoutNodeWrapper2 = layoutNodeWrapper2.getWrapped();
                next = layoutNodeWrapper2 != null ? (SemanticsEntity) EntityList.m3226head0OSVbXo(layoutNodeWrapper2.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3235getSemanticsEntityTypeEEbPh1w()) : null;
            }
        }
        if (semanticsEntity == null || getModifier().getSemanticsConfiguration().getIsClearingSemantics()) {
            return getModifier().getSemanticsConfiguration();
        }
        SemanticsConfiguration semanticsConfigurationCopy = getModifier().getSemanticsConfiguration().copy();
        semanticsConfigurationCopy.collapsePeer$ui_release(semanticsEntity.collapsedSemanticsConfiguration());
        return semanticsConfigurationCopy;
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onDetach() {
        super.onDetach();
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onSemanticsChange();
        }
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onAttach() {
        super.onAttach();
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onSemanticsChange();
        }
    }

    public String toString() {
        return super.toString() + " id: " + getModifier().getId() + " config: " + getModifier().getSemanticsConfiguration();
    }

    public final Rect touchBoundsInRoot() {
        if (!getIsAttached()) {
            return Rect.INSTANCE.getZero();
        }
        if (!getUseMinimumTouchTarget()) {
            return LayoutCoordinatesKt.boundsInRoot(getLayoutNodeWrapper());
        }
        return getLayoutNodeWrapper().touchBoundsInRoot();
    }

    public final SemanticsEntity nearestSemantics$ui_release(Function1<? super SemanticsEntity, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        LayoutNodeWrapper layoutNodeWrapper = getLayoutNodeWrapper();
        SemanticsEntity next = this;
        while (layoutNodeWrapper != null) {
            while (next != null) {
                if (predicate.invoke(next).booleanValue()) {
                    return next;
                }
                next = next.getNext();
            }
            layoutNodeWrapper = layoutNodeWrapper.getWrapped();
            next = layoutNodeWrapper != null ? (SemanticsEntity) EntityList.m3226head0OSVbXo(layoutNodeWrapper.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3235getSemanticsEntityTypeEEbPh1w()) : null;
        }
        return null;
    }
}
