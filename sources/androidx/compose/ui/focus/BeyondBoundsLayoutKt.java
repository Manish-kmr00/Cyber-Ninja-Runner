package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusModifier;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BeyondBoundsLayoutKt {
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m1327searchBeyondBoundsOMvw8(FocusModifier searchBeyondBounds, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int iM3110getBeforehoxUOeE;
        Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent = searchBeyondBounds.getBeyondBoundsLayoutParent();
        if (beyondBoundsLayoutParent == null) {
            return null;
        }
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1344getUpdhqQ8s())) {
            iM3110getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3108getAbovehoxUOeE();
        } else if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1337getDowndhqQ8s())) {
            iM3110getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3111getBelowhoxUOeE();
        } else if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1339getLeftdhqQ8s())) {
            iM3110getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3112getLefthoxUOeE();
        } else if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1343getRightdhqQ8s())) {
            iM3110getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3113getRighthoxUOeE();
        } else if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1340getNextdhqQ8s())) {
            iM3110getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3109getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1342getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iM3110getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3110getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo533layouto7g1Pn8(iM3110getBeforehoxUOeE, block);
    }
}
