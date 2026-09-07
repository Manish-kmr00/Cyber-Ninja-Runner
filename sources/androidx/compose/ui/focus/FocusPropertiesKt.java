package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusProperties.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a#\u0010\b\u001a\u00020\t*\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"ModifierLocalFocusProperties", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "getModifierLocalFocusProperties", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "clear", "", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "refreshFocusProperties", "Landroidx/compose/ui/focus/FocusModifier;", "setUpdatedProperties", "properties", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FocusPropertiesKt {
    private static final ProvidableModifierLocal<FocusPropertiesModifier> ModifierLocalFocusProperties = ModifierLocalKt.modifierLocalOf(new Function0<FocusPropertiesModifier>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$ModifierLocalFocusProperties$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusPropertiesModifier invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal<FocusPropertiesModifier> getModifierLocalFocusProperties() {
        return ModifierLocalFocusProperties;
    }

    public static final Modifier focusProperties(Modifier modifier, final Function1<? super FocusProperties, Unit> scope) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return modifier.then(new FocusPropertiesModifier(scope, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$focusProperties$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("focusProperties");
                inspectorInfo.getProperties().set("scope", scope);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final void setUpdatedProperties(FocusModifier focusModifier, FocusProperties properties) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        if (properties.getCanFocus()) {
            FocusTransactionsKt.activateNode(focusModifier);
        } else {
            FocusTransactionsKt.deactivateNode(focusModifier);
        }
    }

    public static final void clear(FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "<this>");
        focusProperties.setCanFocus(true);
        focusProperties.setNext(FocusRequester.INSTANCE.getDefault());
        focusProperties.setPrevious(FocusRequester.INSTANCE.getDefault());
        focusProperties.setUp(FocusRequester.INSTANCE.getDefault());
        focusProperties.setDown(FocusRequester.INSTANCE.getDefault());
        focusProperties.setLeft(FocusRequester.INSTANCE.getDefault());
        focusProperties.setRight(FocusRequester.INSTANCE.getDefault());
        focusProperties.setStart(FocusRequester.INSTANCE.getDefault());
        focusProperties.setEnd(FocusRequester.INSTANCE.getDefault());
    }

    public static final void refreshFocusProperties(final FocusModifier focusModifier) {
        OwnerSnapshotObserver snapshotObserver;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        LayoutNodeWrapper layoutNodeWrapper = focusModifier.getLayoutNodeWrapper();
        if (layoutNodeWrapper == null) {
            return;
        }
        clear(focusModifier.getFocusProperties());
        Owner owner = layoutNodeWrapper.getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(focusModifier, FocusModifier.INSTANCE.getRefreshFocusProperties(), new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt.refreshFocusProperties.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FocusPropertiesModifier focusPropertiesModifier = focusModifier.getFocusPropertiesModifier();
                    if (focusPropertiesModifier != null) {
                        focusPropertiesModifier.calculateProperties(focusModifier.getFocusProperties());
                    }
                }
            });
        }
        setUpdatedProperties(focusModifier, focusModifier.getFocusProperties());
    }
}
