package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsModifier;
import com.safedk.android.analytics.brandsafety.l;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EntityList.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0081@\u0018\u0000 ;2\u00020\u0001:\u0002;<B$\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\n\u001a\u00020\u000b\"\u0012\b\u0000\u0010\f*\f\u0012\u0004\u0012\u0002H\f\u0012\u0002\b\u00030\u00042\u0006\u0010\r\u001a\u0002H\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"J/\u0010#\u001a\u00020\u000b2\u001a\u0010$\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u000b0%H\u0086\bø\u0001\u0001¢\u0006\u0004\b&\u0010'Ja\u0010#\u001a\u00020\u000b\"\u0014\b\u0000\u0010\f*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H(0\u0004\"\b\b\u0001\u0010(*\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H(0*2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u000b0%H\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\u00020\u001f2\u000e\u0010)\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030*ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b1\u00102JI\u00103\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0000\u0010\f*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H(0\u0004\"\b\b\u0001\u0010(*\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H(0*ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u000207HÖ\u0001¢\u0006\u0004\b8\u00109JR\u0010#\u001a\u00020\u000b\"\u0014\b\u0000\u0010\f*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H(0\u0004\"\b\b\u0001\u0010(*\u00020\u0016*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u000b0%H\u0082\b¢\u0006\u0004\b&\u0010:R#\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Landroidx/compose/ui/node/EntityList;", "", "entities", "", "Landroidx/compose/ui/node/LayoutNodeEntity;", "constructor-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;)[Landroidx/compose/ui/node/LayoutNodeEntity;", "getEntities", "()[Landroidx/compose/ui/node/LayoutNodeEntity;", "[Landroidx/compose/ui/node/LayoutNodeEntity;", l.l, "", "T", "entity", "index", "", "add-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;Landroidx/compose/ui/node/LayoutNodeEntity;I)V", "addAfterLayoutModifier", "layoutNodeWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "addAfterLayoutModifier-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/Modifier;)V", "addBeforeLayoutModifier", "addBeforeLayoutModifier-impl", "clear", "clear-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;)V", "equals", "", "other", "equals-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;Ljava/lang/Object;)Z", "forEach", "block", "Lkotlin/Function1;", "forEach-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;Lkotlin/jvm/functions/Function1;)V", "M", "entityType", "Landroidx/compose/ui/node/EntityList$EntityType;", "forEach-9r0pUL4", "([Landroidx/compose/ui/node/LayoutNodeEntity;ILkotlin/jvm/functions/Function1;)V", "has", "has-0OSVbXo", "([Landroidx/compose/ui/node/LayoutNodeEntity;I)Z", "hashCode", "hashCode-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;)I", "head", "head-0OSVbXo", "([Landroidx/compose/ui/node/LayoutNodeEntity;I)Landroidx/compose/ui/node/LayoutNodeEntity;", "toString", "", "toString-impl", "([Landroidx/compose/ui/node/LayoutNodeEntity;)Ljava/lang/String;", "([Landroidx/compose/ui/node/LayoutNodeEntity;Landroidx/compose/ui/node/LayoutNodeEntity;Lkotlin/jvm/functions/Function1;)V", "Companion", "EntityType", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class EntityList {
    private static final int TypeCount = 6;
    private final LayoutNodeEntity<?, ?>[] entities;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DrawEntityType = EntityType.m3237constructorimpl(0);
    private static final int PointerInputEntityType = EntityType.m3237constructorimpl(1);
    private static final int SemanticsEntityType = EntityType.m3237constructorimpl(2);
    private static final int ParentDataEntityType = EntityType.m3237constructorimpl(3);
    private static final int OnPlacedEntityType = EntityType.m3237constructorimpl(4);
    private static final int RemeasureEntityType = EntityType.m3237constructorimpl(5);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ EntityList m3215boximpl(LayoutNodeEntity[] layoutNodeEntityArr) {
        return new EntityList(layoutNodeEntityArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static LayoutNodeEntity<?, ?>[] m3217constructorimpl(LayoutNodeEntity<?, ?>[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        return entities;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3219equalsimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, Object obj) {
        return (obj instanceof EntityList) && Intrinsics.areEqual(layoutNodeEntityArr, ((EntityList) obj).getEntities());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3220equalsimpl0(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, LayoutNodeEntity<?, ?>[] layoutNodeEntityArr2) {
        return Intrinsics.areEqual(layoutNodeEntityArr, layoutNodeEntityArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3225hashCodeimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr) {
        return Arrays.hashCode(layoutNodeEntityArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3227toStringimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr) {
        return "EntityList(entities=" + Arrays.toString(layoutNodeEntityArr) + ')';
    }

    public boolean equals(Object obj) {
        return m3219equalsimpl(this.entities, obj);
    }

    public int hashCode() {
        return m3225hashCodeimpl(this.entities);
    }

    public String toString() {
        return m3227toStringimpl(this.entities);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ LayoutNodeEntity[] getEntities() {
        return this.entities;
    }

    private /* synthetic */ EntityList(LayoutNodeEntity[] layoutNodeEntityArr) {
        this.entities = layoutNodeEntityArr;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ LayoutNodeEntity[] m3218constructorimpl$default(LayoutNodeEntity[] layoutNodeEntityArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            layoutNodeEntityArr = new LayoutNodeEntity[6];
        }
        return m3217constructorimpl(layoutNodeEntityArr);
    }

    public final LayoutNodeEntity<?, ?>[] getEntities() {
        return this.entities;
    }

    /* JADX INFO: renamed from: addBeforeLayoutModifier-impl, reason: not valid java name */
    public static final void m3214addBeforeLayoutModifierimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, LayoutNodeWrapper layoutNodeWrapper, Modifier modifier) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "layoutNodeWrapper");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (modifier instanceof DrawModifier) {
            m3212addimpl(layoutNodeEntityArr, new DrawEntity(layoutNodeWrapper, (DrawModifier) modifier), DrawEntityType);
        }
        if (modifier instanceof PointerInputModifier) {
            m3212addimpl(layoutNodeEntityArr, new PointerInputEntity(layoutNodeWrapper, (PointerInputModifier) modifier), PointerInputEntityType);
        }
        if (modifier instanceof SemanticsModifier) {
            m3212addimpl(layoutNodeEntityArr, new SemanticsEntity(layoutNodeWrapper, (SemanticsModifier) modifier), SemanticsEntityType);
        }
        if (modifier instanceof ParentDataModifier) {
            m3212addimpl(layoutNodeEntityArr, new SimpleEntity(layoutNodeWrapper, modifier), ParentDataEntityType);
        }
    }

    /* JADX INFO: renamed from: addAfterLayoutModifier-impl, reason: not valid java name */
    public static final void m3213addAfterLayoutModifierimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, LayoutNodeWrapper layoutNodeWrapper, Modifier modifier) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "layoutNodeWrapper");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (modifier instanceof OnPlacedModifier) {
            m3212addimpl(layoutNodeEntityArr, new SimpleEntity(layoutNodeWrapper, modifier), OnPlacedEntityType);
        }
        if (modifier instanceof OnRemeasuredModifier) {
            m3212addimpl(layoutNodeEntityArr, new SimpleEntity(layoutNodeWrapper, modifier), RemeasureEntityType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    private static final <T extends LayoutNodeEntity<T, ?>> void m3212addimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, T t, int i) {
        t.setNext(layoutNodeEntityArr[i]);
        layoutNodeEntityArr[i] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: head-0OSVbXo, reason: not valid java name */
    public static final <T extends LayoutNodeEntity<T, M>, M extends Modifier> T m3226head0OSVbXo(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, int i) {
        return (T) layoutNodeEntityArr[i];
    }

    /* JADX INFO: renamed from: has-0OSVbXo, reason: not valid java name */
    public static final boolean m3224has0OSVbXo(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, int i) {
        return layoutNodeEntityArr[i] != null;
    }

    /* JADX INFO: renamed from: forEach-9r0pUL4, reason: not valid java name */
    public static final <T extends LayoutNodeEntity<T, M>, M extends Modifier> void m3221forEach9r0pUL4(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, int i, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (LayoutNodeEntity<?, ?> next = layoutNodeEntityArr[i]; next != null; next = next.getNext()) {
            block.invoke(next);
        }
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    private static final <T extends LayoutNodeEntity<T, M>, M extends Modifier> void m3222forEachimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, LayoutNodeEntity<?, ?> layoutNodeEntity, Function1<? super T, Unit> function1) {
        while (layoutNodeEntity != null) {
            function1.invoke(layoutNodeEntity);
            layoutNodeEntity = layoutNodeEntity.getNext();
        }
    }

    /* JADX INFO: compiled from: EntityList.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0088\u0001\u0006ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/EntityList$EntityType;", "T", "Landroidx/compose/ui/node/LayoutNodeEntity;", "M", "Landroidx/compose/ui/Modifier;", "", "index", "", "constructor-impl", "(I)I", "getIndex", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @JvmInline
    public static final class EntityType<T extends LayoutNodeEntity<T, M>, M extends Modifier> {
        private final int index;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ EntityType m3236boximpl(int i) {
            return new EntityType(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static <T extends LayoutNodeEntity<T, M>, M extends Modifier> int m3237constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3238equalsimpl(int i, Object obj) {
            return (obj instanceof EntityType) && i == ((EntityType) obj).m3242unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3239equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3240hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3241toStringimpl(int i) {
            return "EntityType(index=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m3238equalsimpl(this.index, obj);
        }

        public int hashCode() {
            return m3240hashCodeimpl(this.index);
        }

        public String toString() {
            return m3241toStringimpl(this.index);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m3242unboximpl() {
            return this.index;
        }

        private /* synthetic */ EntityType(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* JADX INFO: compiled from: EntityList.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR4\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\f0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\bR.\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0004\u0012\u00020\u00100\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\bR(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0015\u0010\bR.\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000b\u0012\u0004\u0012\u00020\u00170\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0018\u0010\bR(\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u001c\u0010\bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/EntityList$Companion;", "", "()V", "DrawEntityType", "Landroidx/compose/ui/node/EntityList$EntityType;", "Landroidx/compose/ui/node/DrawEntity;", "Landroidx/compose/ui/draw/DrawModifier;", "getDrawEntityType-EEbPh1w", "()I", "I", "OnPlacedEntityType", "Landroidx/compose/ui/node/SimpleEntity;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "getOnPlacedEntityType-EEbPh1w$annotations", "getOnPlacedEntityType-EEbPh1w", "ParentDataEntityType", "Landroidx/compose/ui/layout/ParentDataModifier;", "getParentDataEntityType-EEbPh1w", "PointerInputEntityType", "Landroidx/compose/ui/node/PointerInputEntity;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "getPointerInputEntityType-EEbPh1w", "RemeasureEntityType", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "getRemeasureEntityType-EEbPh1w", "SemanticsEntityType", "Landroidx/compose/ui/semantics/SemanticsEntity;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "getSemanticsEntityType-EEbPh1w", "TypeCount", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getOnPlacedEntityType-EEbPh1w$annotations, reason: not valid java name */
        public static /* synthetic */ void m3229getOnPlacedEntityTypeEEbPh1w$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDrawEntityType-EEbPh1w, reason: not valid java name */
        public final int m3230getDrawEntityTypeEEbPh1w() {
            return EntityList.DrawEntityType;
        }

        /* JADX INFO: renamed from: getPointerInputEntityType-EEbPh1w, reason: not valid java name */
        public final int m3233getPointerInputEntityTypeEEbPh1w() {
            return EntityList.PointerInputEntityType;
        }

        /* JADX INFO: renamed from: getSemanticsEntityType-EEbPh1w, reason: not valid java name */
        public final int m3235getSemanticsEntityTypeEEbPh1w() {
            return EntityList.SemanticsEntityType;
        }

        /* JADX INFO: renamed from: getParentDataEntityType-EEbPh1w, reason: not valid java name */
        public final int m3232getParentDataEntityTypeEEbPh1w() {
            return EntityList.ParentDataEntityType;
        }

        /* JADX INFO: renamed from: getOnPlacedEntityType-EEbPh1w, reason: not valid java name */
        public final int m3231getOnPlacedEntityTypeEEbPh1w() {
            return EntityList.OnPlacedEntityType;
        }

        /* JADX INFO: renamed from: getRemeasureEntityType-EEbPh1w, reason: not valid java name */
        public final int m3234getRemeasureEntityTypeEEbPh1w() {
            return EntityList.RemeasureEntityType;
        }
    }

    /* JADX INFO: renamed from: clear-impl, reason: not valid java name */
    public static final void m3216clearimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr) {
        for (LayoutNodeEntity<?, ?> next : layoutNodeEntityArr) {
            for (; next != null; next = next.getNext()) {
                if (next.getIsAttached()) {
                    next.onDetach();
                }
            }
        }
        int length = layoutNodeEntityArr.length;
        for (int i = 0; i < length; i++) {
            layoutNodeEntityArr[i] = null;
        }
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    public static final void m3223forEachimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, Function1<? super LayoutNodeEntity<?, ?>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (LayoutNodeEntity<?, ?> next : layoutNodeEntityArr) {
            for (; next != null; next = next.getNext()) {
                block.invoke(next);
            }
        }
    }
}
