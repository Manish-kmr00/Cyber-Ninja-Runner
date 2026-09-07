package androidx.compose.ui.input.key;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import com.json.c9;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyInputModifier.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B4\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u001b\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010'J\u001b\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010'R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "<set-?>", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreviewKeyEvent", "parent", "getParent", "()Landroidx/compose/ui/input/key/KeyInputModifier;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPlaced", c9.COORDINATES, "Landroidx/compose/ui/layout/LayoutCoordinates;", "processKeyInput", "keyEvent", "processKeyInput-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "propagateKeyEvent", "propagateKeyEvent-ZmokQxo", "propagatePreviewKeyEvent", "propagatePreviewKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeyInputModifier implements ModifierLocalConsumer, ModifierLocalProvider<KeyInputModifier>, OnPlacedModifier {
    private FocusModifier focusModifier;
    private LayoutNode layoutNode;
    private final Function1<KeyEvent, Boolean> onKeyEvent;
    private final Function1<KeyEvent, Boolean> onPreviewKeyEvent;
    private KeyInputModifier parent;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public KeyInputModifier getValue() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeyInputModifier(Function1<? super KeyEvent, Boolean> function1, Function1<? super KeyEvent, Boolean> function2) {
        this.onKeyEvent = function1;
        this.onPreviewKeyEvent = function2;
    }

    public final Function1<KeyEvent, Boolean> getOnKeyEvent() {
        return this.onKeyEvent;
    }

    public final Function1<KeyEvent, Boolean> getOnPreviewKeyEvent() {
        return this.onPreviewKeyEvent;
    }

    public final KeyInputModifier getParent() {
        return this.parent;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<KeyInputModifier> getKey() {
        return KeyInputModifierKt.getModifierLocalKeyInput();
    }

    /* JADX INFO: renamed from: processKeyInput-ZmokQxo, reason: not valid java name */
    public final boolean m2872processKeyInputZmokQxo(android.view.KeyEvent keyEvent) {
        FocusModifier focusModifierFindActiveFocusNode;
        KeyInputModifier keyInputModifierFindLastKeyInputModifier;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusModifier focusModifier = this.focusModifier;
        if (focusModifier == null || (focusModifierFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier)) == null || (keyInputModifierFindLastKeyInputModifier = FocusTraversalKt.findLastKeyInputModifier(focusModifierFindActiveFocusNode)) == null) {
            throw new IllegalStateException("KeyEvent can't be processed because this key input node is not active.".toString());
        }
        if (keyInputModifierFindLastKeyInputModifier.m2874propagatePreviewKeyEventZmokQxo(keyEvent)) {
            return true;
        }
        return keyInputModifierFindLastKeyInputModifier.m2873propagateKeyEventZmokQxo(keyEvent);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        MutableVector<KeyInputModifier> keyInputChildren;
        MutableVector<KeyInputModifier> keyInputChildren2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        FocusModifier focusModifier = this.focusModifier;
        if (focusModifier != null && (keyInputChildren2 = focusModifier.getKeyInputChildren()) != null) {
            keyInputChildren2.remove(this);
        }
        FocusModifier focusModifier2 = (FocusModifier) scope.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        this.focusModifier = focusModifier2;
        if (focusModifier2 != null && (keyInputChildren = focusModifier2.getKeyInputChildren()) != null) {
            keyInputChildren.add(this);
        }
        this.parent = (KeyInputModifier) scope.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
    }

    /* JADX INFO: renamed from: propagatePreviewKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m2874propagatePreviewKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        KeyInputModifier keyInputModifier = this.parent;
        Boolean boolValueOf = keyInputModifier != null ? Boolean.valueOf(keyInputModifier.m2874propagatePreviewKeyEventZmokQxo(keyEvent)) : null;
        if (Intrinsics.areEqual((Object) boolValueOf, (Object) true)) {
            return boolValueOf.booleanValue();
        }
        Function1<KeyEvent, Boolean> function1 = this.onPreviewKeyEvent;
        if (function1 != null) {
            return function1.invoke(KeyEvent.m2848boximpl(keyEvent)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: propagateKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m2873propagateKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        Function1<KeyEvent, Boolean> function1 = this.onKeyEvent;
        Boolean boolInvoke = function1 != null ? function1.invoke(KeyEvent.m2848boximpl(keyEvent)) : null;
        if (Intrinsics.areEqual((Object) boolInvoke, (Object) true)) {
            return boolInvoke.booleanValue();
        }
        KeyInputModifier keyInputModifier = this.parent;
        if (keyInputModifier != null) {
            return keyInputModifier.m2873propagateKeyEventZmokQxo(keyEvent);
        }
        return false;
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.layoutNode = ((LayoutNodeWrapper) coordinates).getLayoutNode();
    }
}
