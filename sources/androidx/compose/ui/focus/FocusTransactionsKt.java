package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusTransactions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0011"}, d2 = {"activateNode", "", "Landroidx/compose/ui/focus/FocusModifier;", "captureFocus", "", "clearChildFocus", "clearFocus", "forcedClear", "deactivateNode", "freeFocus", "grantFocus", "grantFocusToChild", "childNode", "requestFocus", "requestFocusForChild", "requestFocusForOwner", "sendOnFocusEvent", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void requestFocus(FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (((layoutNodeWrapper == null || (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode()) == null) ? null : layoutNode$ui_release.getOwner()) == null) {
            focusModifier.setFocusRequestedOnPlaced(true);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                sendOnFocusEvent(focusModifier);
                break;
            case 5:
                if (clearChildFocus(focusModifier)) {
                    grantFocus(focusModifier);
                }
                break;
            case 6:
                FocusModifier parent = focusModifier.getParent();
                if (parent != null) {
                    requestFocusForChild(parent, focusModifier);
                } else if (requestFocusForOwner(focusModifier)) {
                    grantFocus(focusModifier);
                }
                break;
        }
    }

    public static final void activateNode(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()];
        if (i == 3) {
            focusModifier.setFocusState(FocusStateImpl.Inactive);
        } else {
            if (i != 4) {
                return;
            }
            focusModifier.setFocusState(FocusStateImpl.ActiveParent);
        }
    }

    public static final void deactivateNode(FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        Owner owner;
        FocusManager focusManager;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()];
        if (i != 1 && i != 2) {
            if (i == 5) {
                focusModifier.setFocusState(FocusStateImpl.DeactivatedParent);
                return;
            } else {
                if (i != 6) {
                    return;
                }
                focusModifier.setFocusState(FocusStateImpl.Deactivated);
                return;
            }
        }
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper != null && (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode()) != null && (owner = layoutNode$ui_release.getOwner()) != null && (focusManager = owner.getFocusManager()) != null) {
            focusManager.clearFocus(true);
        }
        focusModifier.setFocusState(FocusStateImpl.Deactivated);
    }

    public static final boolean captureFocus(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.Captured);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean freeFocus(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                focusModifier.setFocusState(FocusStateImpl.Active);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusModifier focusModifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusModifier, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean clearFocus(FocusModifier focusModifier, boolean z) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.Inactive);
                return true;
            case 2:
                if (!z) {
                    return z;
                }
                focusModifier.setFocusState(FocusStateImpl.Inactive);
                return z;
            case 3:
            case 6:
                return true;
            case 4:
                if (clearChildFocus(focusModifier)) {
                    focusModifier.setFocusState(FocusStateImpl.Deactivated);
                    return true;
                }
                return false;
            case 5:
                if (clearChildFocus(focusModifier)) {
                    focusModifier.setFocusState(FocusStateImpl.Inactive);
                    return true;
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final void grantFocus(FocusModifier focusModifier) {
        FocusStateImpl focusStateImpl;
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 5:
            case 6:
                focusStateImpl = FocusStateImpl.Active;
                break;
            case 2:
                focusStateImpl = FocusStateImpl.Captured;
                break;
            case 3:
            case 4:
                throw new IllegalStateException("Granting focus to a deactivated node.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
        focusModifier.setFocusState(focusStateImpl);
    }

    private static final boolean grantFocusToChild(FocusModifier focusModifier, FocusModifier focusModifier2) {
        focusModifier.setFocusedChild(focusModifier2);
        grantFocus(focusModifier2);
        return true;
    }

    private static final boolean clearChildFocus(FocusModifier focusModifier) {
        FocusModifier focusedChild = focusModifier.getFocusedChild();
        if (focusedChild == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (!clearFocus$default(focusedChild, false, 1, null)) {
            return false;
        }
        focusModifier.setFocusedChild(null);
        return true;
    }

    private static final boolean requestFocusForChild(FocusModifier focusModifier, FocusModifier focusModifier2) {
        if (!focusModifier.getChildren().contains(focusModifier2)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
                focusModifier.setFocusState(FocusStateImpl.ActiveParent);
                return grantFocusToChild(focusModifier, focusModifier2);
            case 2:
                return false;
            case 3:
                activateNode(focusModifier);
                boolean zRequestFocusForChild = requestFocusForChild(focusModifier, focusModifier2);
                deactivateNode(focusModifier);
                return zRequestFocusForChild;
            case 4:
                if (focusModifier.getFocusedChild() == null || clearChildFocus(focusModifier)) {
                    return grantFocusToChild(focusModifier, focusModifier2);
                }
                return false;
            case 5:
                if (clearChildFocus(focusModifier)) {
                    return grantFocusToChild(focusModifier, focusModifier2);
                }
                return false;
            case 6:
                FocusModifier parent = focusModifier.getParent();
                if (parent == null && requestFocusForOwner(focusModifier)) {
                    focusModifier.setFocusState(FocusStateImpl.Active);
                    return requestFocusForChild(focusModifier, focusModifier2);
                }
                if (parent == null || !requestFocusForChild(parent, focusModifier)) {
                    return false;
                }
                return requestFocusForChild(focusModifier, focusModifier2);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean requestFocusForOwner(FocusModifier focusModifier) {
        LayoutNode layoutNode$ui_release;
        Owner owner;
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper == null || (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode()) == null || (owner = layoutNode$ui_release.getOwner()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner.requestFocus();
    }

    public static final void sendOnFocusEvent(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        FocusEventModifierLocal focusEventListener = focusModifier.getFocusEventListener();
        if (focusEventListener != null) {
            focusEventListener.propagateFocusEvent();
        }
    }
}
