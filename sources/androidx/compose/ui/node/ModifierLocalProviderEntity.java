package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierLocalProviderEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0018\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"J\u001c\u0010#\u001a\u00020\u00022\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u0010$\u001a\u00020\u000eH\u0002J\t\u0010%\u001a\u00020\u0002H\u0096\u0002R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006&"}, d2 = {"Landroidx/compose/ui/node/ModifierLocalProviderEntity;", "Lkotlin/Function0;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "modifier", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/modifier/ModifierLocalProvider;)V", "consumers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/ModifierLocalConsumerEntity;", "getConsumers", "()Landroidx/compose/runtime/collection/MutableVector;", "<set-?>", "", "isAttached", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "getModifier", "()Landroidx/compose/ui/modifier/ModifierLocalProvider;", "next", "getNext", "()Landroidx/compose/ui/node/ModifierLocalProviderEntity;", "setNext", "(Landroidx/compose/ui/node/ModifierLocalProviderEntity;)V", "prev", "getPrev", "setPrev", "attach", "attachDelayed", "detach", "findModifierLocalProvider", "local", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidateConsumersOf", "stopIfProvided", "invoke", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ModifierLocalProviderEntity implements Function0<Unit> {
    private final MutableVector<ModifierLocalConsumerEntity> consumers;
    private boolean isAttached;
    private final LayoutNode layoutNode;
    private final ModifierLocalProvider<?> modifier;
    private ModifierLocalProviderEntity next;
    private ModifierLocalProviderEntity prev;

    public ModifierLocalProviderEntity(LayoutNode layoutNode, ModifierLocalProvider<?> modifier) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.layoutNode = layoutNode;
        this.modifier = modifier;
        this.consumers = new MutableVector<>(new ModifierLocalConsumerEntity[16], 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final ModifierLocalProvider<?> getModifier() {
        return this.modifier;
    }

    public final ModifierLocalProviderEntity getNext() {
        return this.next;
    }

    public final void setNext(ModifierLocalProviderEntity modifierLocalProviderEntity) {
        this.next = modifierLocalProviderEntity;
    }

    public final ModifierLocalProviderEntity getPrev() {
        return this.prev;
    }

    public final void setPrev(ModifierLocalProviderEntity modifierLocalProviderEntity) {
        this.prev = modifierLocalProviderEntity;
    }

    /* JADX INFO: renamed from: isAttached, reason: from getter */
    public final boolean getIsAttached() {
        return this.isAttached;
    }

    public final MutableVector<ModifierLocalConsumerEntity> getConsumers() {
        return this.consumers;
    }

    public final void attach() {
        this.isAttached = true;
        int i = 0;
        invalidateConsumersOf(this.modifier.getKey(), false);
        MutableVector<ModifierLocalConsumerEntity> mutableVector = this.consumers;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            do {
                content[i].attach();
                i++;
            } while (i < size);
        }
    }

    public final void attachDelayed() {
        this.isAttached = true;
        Owner owner = this.layoutNode.getOwner();
        if (owner != null) {
            owner.registerOnEndApplyChangesListener(this);
        }
        MutableVector<ModifierLocalConsumerEntity> mutableVector = this.consumers;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].attachDelayed();
                i++;
            } while (i < size);
        }
    }

    public final void detach() {
        this.isAttached = false;
        MutableVector<ModifierLocalConsumerEntity> mutableVector = this.consumers;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].detach();
                i++;
            } while (i < size);
        }
        invalidateConsumersOf(this.modifier.getKey(), false);
    }

    private final void invalidateConsumersOf(ModifierLocal<?> local, boolean stopIfProvided) {
        Unit unit;
        MutableVector<LayoutNode> mutableVector;
        int size;
        if (stopIfProvided && Intrinsics.areEqual(this.modifier.getKey(), local)) {
            return;
        }
        MutableVector<ModifierLocalConsumerEntity> mutableVector2 = this.consumers;
        int size2 = mutableVector2.getSize();
        int i = 0;
        if (size2 > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector2.getContent();
            int i2 = 0;
            do {
                content[i2].invalidateConsumersOf(local);
                i2++;
            } while (i2 < size2);
        }
        ModifierLocalProviderEntity modifierLocalProviderEntity = this.next;
        if (modifierLocalProviderEntity != null) {
            modifierLocalProviderEntity.invalidateConsumersOf(local, true);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null || (size = (mutableVector = this.layoutNode.get_children$ui_release()).getSize()) <= 0) {
            return;
        }
        LayoutNode[] content2 = mutableVector.getContent();
        do {
            content2[i].getModifierLocalsHead().invalidateConsumersOf(local, true);
            i++;
        } while (i < size);
    }

    public final ModifierLocalProvider<?> findModifierLocalProvider(ModifierLocal<?> local) {
        ModifierLocalProviderEntity modifierLocalsTail;
        ModifierLocalProvider<?> modifierLocalProviderFindModifierLocalProvider;
        Intrinsics.checkNotNullParameter(local, "local");
        if (Intrinsics.areEqual(this.modifier.getKey(), local)) {
            return this.modifier;
        }
        ModifierLocalProviderEntity modifierLocalProviderEntity = this.prev;
        if (modifierLocalProviderEntity != null && (modifierLocalProviderFindModifierLocalProvider = modifierLocalProviderEntity.findModifierLocalProvider(local)) != null) {
            return modifierLocalProviderFindModifierLocalProvider;
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release == null || (modifierLocalsTail = parent$ui_release.getModifierLocalsTail()) == null) {
            return null;
        }
        return modifierLocalsTail.findModifierLocalProvider(local);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        if (this.isAttached) {
            invalidateConsumersOf(this.modifier.getKey(), false);
        }
    }
}
