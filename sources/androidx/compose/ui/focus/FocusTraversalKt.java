package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusTraversal.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b*\u00020\u0004H\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u0004H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0004H\u0000\u001a=\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"invalidFocusDirection", "", "isEligibleForFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)Z", "lastOf", "Landroidx/compose/ui/input/key/KeyInputModifier;", "one", "two", "activatedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findActiveFocusNode", "findActiveParent", "findLastKeyInputModifier", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusModifier;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FocusTraversalKt {
    private static final String invalidFocusDirection = "Invalid FocusDirection";

    /* JADX INFO: compiled from: FocusTraversal.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            iArr[LayoutDirection.Ltr.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            iArr2[FocusStateImpl.Active.ordinal()] = 1;
            iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr2[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr2[FocusStateImpl.Inactive.ordinal()] = 5;
            iArr2[FocusStateImpl.Deactivated.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: focusSearch-sMXa3k8, reason: not valid java name */
    public static final boolean m1348focusSearchsMXa3k8(FocusModifier focusSearch, int i, LayoutDirection layoutDirection, Function1<? super FocusModifier, Boolean> onFound) {
        int iM1339getLeftdhqQ8s;
        Intrinsics.checkNotNullParameter(focusSearch, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1340getNextdhqQ8s()) ? true : FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1342getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m1351oneDimensionalFocusSearchOMvw8(focusSearch, i, onFound);
        }
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1339getLeftdhqQ8s()) ? true : FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1343getRightdhqQ8s()) ? true : FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1344getUpdhqQ8s()) ? true : FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1337getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m1360twoDimensionalFocusSearchOMvw8(focusSearch, i, onFound);
        }
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1338getIndhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                iM1339getLeftdhqQ8s = FocusDirection.INSTANCE.m1339getLeftdhqQ8s();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                iM1339getLeftdhqQ8s = FocusDirection.INSTANCE.m1343getRightdhqQ8s();
            }
            FocusModifier focusModifierFindActiveFocusNode = findActiveFocusNode(focusSearch);
            if (focusModifierFindActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m1360twoDimensionalFocusSearchOMvw8(focusModifierFindActiveFocusNode, iM1339getLeftdhqQ8s, onFound);
            }
        } else if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1341getOutdhqQ8s())) {
            FocusModifier focusModifierFindActiveFocusNode2 = findActiveFocusNode(focusSearch);
            FocusModifier focusModifierFindActiveParent = focusModifierFindActiveFocusNode2 != null ? findActiveParent(focusModifierFindActiveFocusNode2) : null;
            if (!Intrinsics.areEqual(focusModifierFindActiveParent, focusSearch) && focusModifierFindActiveParent != null) {
                return onFound.invoke(focusModifierFindActiveParent).booleanValue();
            }
        } else {
            throw new IllegalStateException(invalidFocusDirection.toString());
        }
        return false;
    }

    public static final FocusModifier findActiveFocusNode(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return focusModifier;
            case 3:
            case 4:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return findActiveFocusNode(focusedChild);
                }
                break;
            case 5:
            case 6:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    public static final FocusModifier findActiveParent(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        FocusModifier parent = focusModifier.getParent();
        if (parent == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return findActiveParent(parent);
            case 3:
                return focusModifier;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Rect focusRect(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper != null) {
            LayoutNodeWrapper layoutNodeWrapper2 = layoutNodeWrapper;
            Rect rectLocalBoundingBoxOf = LayoutCoordinatesKt.findRoot(layoutNodeWrapper2).localBoundingBoxOf(layoutNodeWrapper2, false);
            if (rectLocalBoundingBoxOf != null) {
                return rectLocalBoundingBoxOf;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public static final MutableVector<FocusModifier> activatedChildren(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size > 0) {
            FocusModifier[] content = children.getContent();
            int i = 0;
            int i2 = 0;
            while (!content[i2].getFocusState().isDeactivated()) {
                i2++;
                if (i2 >= size) {
                }
            }
            MutableVector<FocusModifier> mutableVector = new MutableVector<>(new FocusModifier[16], 0);
            MutableVector<FocusModifier> children2 = focusModifier.getChildren();
            int size2 = children2.getSize();
            if (size2 > 0) {
                FocusModifier[] content2 = children2.getContent();
                do {
                    FocusModifier focusModifier2 = content2[i];
                    if (focusModifier2.getFocusState().isDeactivated()) {
                        mutableVector.addAll(mutableVector.getSize(), activatedChildren(focusModifier2));
                    } else {
                        mutableVector.add(focusModifier2);
                    }
                    i++;
                } while (i < size2);
            }
            return mutableVector;
        }
        return focusModifier.getChildren();
    }

    public static final KeyInputModifier findLastKeyInputModifier(FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        KeyInputModifier keyInputModifierLastOf = null;
        if (layoutNodeWrapper == null || (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode()) == null) {
            return null;
        }
        MutableVector<KeyInputModifier> keyInputChildren = focusModifier.getKeyInputChildren();
        int size = keyInputChildren.getSize();
        if (size > 0) {
            KeyInputModifier[] content = keyInputChildren.getContent();
            int i = 0;
            do {
                KeyInputModifier keyInputModifier = content[i];
                if (Intrinsics.areEqual(keyInputModifier.getLayoutNode(), layoutNode$ui_release)) {
                    keyInputModifierLastOf = lastOf(keyInputModifier, keyInputModifierLastOf);
                }
                i++;
            } while (i < size);
        }
        return keyInputModifierLastOf != null ? keyInputModifierLastOf : focusModifier.getKeyInputModifier();
    }

    public static final boolean isEligibleForFocusSearch(FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        LayoutNodeWrapper layoutNodeWrapper;
        LayoutNode layoutNode$ui_release2;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper2 = focusModifier.getLayoutNodeWrapper();
        return (layoutNodeWrapper2 == null || (layoutNode$ui_release = layoutNodeWrapper2.getLayoutNode()) == null || !layoutNode$ui_release.getIsPlaced() || (layoutNodeWrapper = focusModifier.getLayoutNodeWrapper()) == null || (layoutNode$ui_release2 = layoutNodeWrapper.getLayoutNode()) == null || !layoutNode$ui_release2.isAttached()) ? false : true;
    }

    private static final KeyInputModifier lastOf(KeyInputModifier keyInputModifier, KeyInputModifier keyInputModifier2) {
        if (keyInputModifier2 == null) {
            return keyInputModifier;
        }
        LayoutNode layoutNode = keyInputModifier.getLayoutNode();
        KeyInputModifier parent = keyInputModifier2;
        while (!Intrinsics.areEqual(parent, keyInputModifier)) {
            parent = parent.getParent();
            if (parent == null || !Intrinsics.areEqual(parent.getLayoutNode(), layoutNode)) {
                return keyInputModifier;
            }
        }
        return keyInputModifier2;
    }
}
