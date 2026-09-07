package androidx.compose.ui.input.focus;

import androidx.compose.ui.input.focus.FocusAwareEvent;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusAwareInputModifier.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00000\u0004BG\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00000\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "T", "Landroidx/compose/ui/input/focus/FocusAwareEvent;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "onEvent", "Lkotlin/Function1;", "", "onPreEvent", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/modifier/ProvidableModifierLocal;)V", "focusAwareEventParent", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreEvent", "value", "getValue", "()Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "propagateEvent", "event", "(Landroidx/compose/ui/input/focus/FocusAwareEvent;)Z", "propagateFocusAwareEvent", "propagatePreEvent", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FocusAwareInputModifier<T extends FocusAwareEvent> implements ModifierLocalConsumer, ModifierLocalProvider<FocusAwareInputModifier<T>> {
    private FocusAwareInputModifier<T> focusAwareEventParent;
    private final ProvidableModifierLocal<FocusAwareInputModifier<T>> key;
    private final Function1<FocusAwareEvent, Boolean> onEvent;
    private final Function1<FocusAwareEvent, Boolean> onPreEvent;

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public FocusAwareInputModifier<T> getValue() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusAwareInputModifier(Function1<? super FocusAwareEvent, Boolean> function1, Function1<? super FocusAwareEvent, Boolean> function2, ProvidableModifierLocal<FocusAwareInputModifier<T>> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.onEvent = function1;
        this.onPreEvent = function2;
        this.key = key;
    }

    public final Function1<FocusAwareEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    public final Function1<FocusAwareEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<FocusAwareInputModifier<T>> getKey() {
        return this.key;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.focusAwareEventParent = (FocusAwareInputModifier) scope.getCurrent(getKey());
    }

    public final boolean propagateFocusAwareEvent(T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return propagatePreEvent(event) || propagateEvent(event);
    }

    private final boolean propagatePreEvent(T event) {
        FocusAwareInputModifier<T> focusAwareInputModifier = this.focusAwareEventParent;
        if (focusAwareInputModifier != null && focusAwareInputModifier.propagatePreEvent(event)) {
            return true;
        }
        Function1<FocusAwareEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return function1.invoke(event).booleanValue();
        }
        return false;
    }

    private final boolean propagateEvent(T event) {
        Function1<FocusAwareEvent, Boolean> function1 = this.onEvent;
        if (function1 != null && function1.invoke(event).booleanValue()) {
            return true;
        }
        FocusAwareInputModifier<T> focusAwareInputModifier = this.focusAwareEventParent;
        if (focusAwareInputModifier != null) {
            return focusAwareInputModifier.propagateEvent(event);
        }
        return false;
    }
}
