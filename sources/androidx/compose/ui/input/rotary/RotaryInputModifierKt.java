package androidx.compose.ui.input.rotary;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.focus.FocusAwareEvent;
import androidx.compose.ui.input.focus.FocusAwareInputModifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RotaryInputModifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0003\u001a \u0010\f\u001a\u00020\r*\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0007\u001a \u0010\u000e\u001a\u00020\r*\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0007\"*\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"ModifierLocalRotaryScrollParent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getModifierLocalRotaryScrollParent$annotations", "()V", "getModifierLocalRotaryScrollParent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "focusAwareCallback", "Lkotlin/Function1;", "Landroidx/compose/ui/input/focus/FocusAwareEvent;", "", "onPreRotaryScrollEvent", "Landroidx/compose/ui/Modifier;", "onRotaryScrollEvent", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RotaryInputModifierKt {
    private static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> ModifierLocalRotaryScrollParent = ModifierLocalKt.modifierLocalOf(new Function0<FocusAwareInputModifier<RotaryScrollEvent>>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$ModifierLocalRotaryScrollParent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusAwareInputModifier<RotaryScrollEvent> invoke() {
            return null;
        }
    });

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getModifierLocalRotaryScrollParent$annotations() {
    }

    public static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> getModifierLocalRotaryScrollParent() {
        return ModifierLocalRotaryScrollParent;
    }

    @ExperimentalComposeUiApi
    private static final Function1<FocusAwareEvent, Boolean> focusAwareCallback(final Function1<? super RotaryScrollEvent, Boolean> function1) {
        return new Function1<FocusAwareEvent, Boolean>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt.focusAwareCallback.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusAwareEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (!(e instanceof RotaryScrollEvent)) {
                    throw new IllegalStateException("FocusAwareEvent is dispatched to the wrong FocusAwareParent.".toString());
                }
                return function1.invoke(e);
            }
        };
    }

    @ExperimentalComposeUiApi
    public static final Modifier onRotaryScrollEvent(Modifier modifier, final Function1<? super RotaryScrollEvent, Boolean> onRotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onRotaryScrollEvent, "onRotaryScrollEvent");
        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onRotaryScrollEvent");
                inspectorInfo.getProperties().set("onRotaryScrollEvent", onRotaryScrollEvent);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        return InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, new FocusAwareInputModifier(focusAwareCallback(onRotaryScrollEvent), null, ModifierLocalRotaryScrollParent));
    }

    @ExperimentalComposeUiApi
    public static final Modifier onPreRotaryScrollEvent(Modifier modifier, final Function1<? super RotaryScrollEvent, Boolean> onPreRotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onPreRotaryScrollEvent, "onPreRotaryScrollEvent");
        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onPreRotaryScrollEvent");
                inspectorInfo.getProperties().set("onPreRotaryScrollEvent", onPreRotaryScrollEvent);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        return InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, new FocusAwareInputModifier(null, focusAwareCallback(onPreRotaryScrollEvent), ModifierLocalRotaryScrollParent));
    }
}
