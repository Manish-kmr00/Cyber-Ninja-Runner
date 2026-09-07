package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import com.json.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierLocalConsumerEntity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001$B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0012\u0010 \u001a\u00020\u00022\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\u0013J\t\u0010\"\u001a\u00020\u0002H\u0096\u0002J\u0006\u0010#\u001a\u00020\u0002R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00190\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/ModifierLocalConsumerEntity;", "Lkotlin/Function0;", "", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", IronSourceConstants.EVENTS_PROVIDER, "Landroidx/compose/ui/node/ModifierLocalProviderEntity;", "modifier", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "(Landroidx/compose/ui/node/ModifierLocalProviderEntity;Landroidx/compose/ui/modifier/ModifierLocalConsumer;)V", "<set-?>", "", "isAttached", "()Z", "isValid", "getModifier", "()Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "modifierLocalsRead", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/modifier/ModifierLocal;", "getProvider", "()Landroidx/compose/ui/node/ModifierLocalProviderEntity;", "setProvider", "(Landroidx/compose/ui/node/ModifierLocalProviderEntity;)V", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "attach", "attachDelayed", "detach", "invalidateConsumer", "invalidateConsumersOf", "local", "invoke", "notifyConsumerOfChanges", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ModifierLocalConsumerEntity implements Function0<Unit>, OwnerScope, ModifierLocalReadScope {
    private boolean isAttached;
    private final ModifierLocalConsumer modifier;
    private final MutableVector<ModifierLocal<?>> modifierLocalsRead;
    private ModifierLocalProviderEntity provider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<ModifierLocalConsumerEntity, Unit> onReadValuesChanged = new Function1<ModifierLocalConsumerEntity, Unit>() { // from class: androidx.compose.ui.node.ModifierLocalConsumerEntity$Companion$onReadValuesChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModifierLocalConsumerEntity modifierLocalConsumerEntity) {
            invoke2(modifierLocalConsumerEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModifierLocalConsumerEntity node) {
            Intrinsics.checkNotNullParameter(node, "node");
            node.notifyConsumerOfChanges();
        }
    };
    private static final ModifierLocalReadScope DetachedModifierLocalReadScope = new ModifierLocalReadScope() { // from class: androidx.compose.ui.node.ModifierLocalConsumerEntity$Companion$DetachedModifierLocalReadScope$1
        @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
        public <T> T getCurrent(ModifierLocal<T> modifierLocal) {
            Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
            return modifierLocal.getDefaultFactory$ui_release().invoke();
        }
    };

    public ModifierLocalConsumerEntity(ModifierLocalProviderEntity provider, ModifierLocalConsumer modifier) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.provider = provider;
        this.modifier = modifier;
        this.modifierLocalsRead = new MutableVector<>(new ModifierLocal[16], 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public final ModifierLocalProviderEntity getProvider() {
        return this.provider;
    }

    public final void setProvider(ModifierLocalProviderEntity modifierLocalProviderEntity) {
        Intrinsics.checkNotNullParameter(modifierLocalProviderEntity, "<set-?>");
        this.provider = modifierLocalProviderEntity;
    }

    public final ModifierLocalConsumer getModifier() {
        return this.modifier;
    }

    /* JADX INFO: renamed from: isAttached, reason: from getter */
    public final boolean getIsAttached() {
        return this.isAttached;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return this.isAttached;
    }

    public final void attach() {
        this.isAttached = true;
        notifyConsumerOfChanges();
    }

    public final void attachDelayed() {
        this.isAttached = true;
        invalidateConsumer();
    }

    public final void detach() {
        this.modifier.onModifierLocalsUpdated(DetachedModifierLocalReadScope);
        this.isAttached = false;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    public <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        this.modifierLocalsRead.add(modifierLocal);
        ModifierLocalProvider<?> modifierLocalProviderFindModifierLocalProvider = this.provider.findModifierLocalProvider(modifierLocal);
        if (modifierLocalProviderFindModifierLocalProvider == null) {
            return modifierLocal.getDefaultFactory$ui_release().invoke();
        }
        return (T) modifierLocalProviderFindModifierLocalProvider.getValue();
    }

    public final void invalidateConsumersOf(ModifierLocal<?> local) {
        Owner owner;
        Intrinsics.checkNotNullParameter(local, "local");
        if (!this.modifierLocalsRead.contains(local) || (owner = this.provider.getLayoutNode().getOwner()) == null) {
            return;
        }
        owner.registerOnEndApplyChangesListener(this);
    }

    public final void notifyConsumerOfChanges() {
        if (this.isAttached) {
            this.modifierLocalsRead.clear();
            LayoutNodeKt.requireOwner(this.provider.getLayoutNode()).getSnapshotObserver().observeReads$ui_release(this, onReadValuesChanged, new Function0<Unit>() { // from class: androidx.compose.ui.node.ModifierLocalConsumerEntity.notifyConsumerOfChanges.1
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
                    ModifierLocalConsumerEntity.this.getModifier().onModifierLocalsUpdated(ModifierLocalConsumerEntity.this);
                }
            });
        }
    }

    public final void invalidateConsumer() {
        Owner owner = this.provider.getLayoutNode().getOwner();
        if (owner != null) {
            owner.registerOnEndApplyChangesListener(this);
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        notifyConsumerOfChanges();
    }

    /* JADX INFO: compiled from: ModifierLocalConsumerEntity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/ModifierLocalConsumerEntity$Companion;", "", "()V", "DetachedModifierLocalReadScope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "getDetachedModifierLocalReadScope", "()Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onReadValuesChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/ModifierLocalConsumerEntity;", "", "getOnReadValuesChanged", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<ModifierLocalConsumerEntity, Unit> getOnReadValuesChanged() {
            return ModifierLocalConsumerEntity.onReadValuesChanged;
        }

        public final ModifierLocalReadScope getDetachedModifierLocalReadScope() {
            return ModifierLocalConsumerEntity.DetachedModifierLocalReadScope;
        }
    }
}
