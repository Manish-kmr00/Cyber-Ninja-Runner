package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PinnableParent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"ModifierLocalPinnableParent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "getModifierLocalPinnableParent$annotations", "()V", "getModifierLocalPinnableParent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PinnableParentKt {
    private static final ProvidableModifierLocal<PinnableParent> ModifierLocalPinnableParent = ModifierLocalKt.modifierLocalOf(new Function0<PinnableParent>() { // from class: androidx.compose.foundation.lazy.layout.PinnableParentKt$ModifierLocalPinnableParent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PinnableParent invoke() {
            return null;
        }
    });

    @ExperimentalFoundationApi
    public static /* synthetic */ void getModifierLocalPinnableParent$annotations() {
    }

    @ExperimentalFoundationApi
    public static final ProvidableModifierLocal<PinnableParent> getModifierLocalPinnableParent() {
        return ModifierLocalPinnableParent;
    }
}
