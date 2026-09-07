package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import com.safedk.android.analytics.brandsafety.l;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: compiled from: SnapshotStateList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001MB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0096\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\u0082\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J)\u0010I\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ3\u0010J\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bKH\u0082\b¢\u0006\u0002\u00107J3\u0010L\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bKH\u0082\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0080\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006N"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", ContentDisposition.Parameters.Size, "getSize", l.l, "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) value;
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) getFirstStateRecord(), this);
    }

    /* JADX INFO: compiled from: SnapshotStateList.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public StateListStateRecord(PersistentList<? extends T> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        /* JADX INFO: renamed from: getModification$runtime_release, reason: from getter */
        public final int getModification() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    @Override // java.util.List
    public T get(int index) {
        return (T) getReadable$runtime_release().getList$runtime_release().get(index);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new StateListIterator(this, index);
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex > toIndex || toIndex > size()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return new SubList(this, fromIndex, toIndex);
    }

    @Override // java.util.List
    public boolean addAll(final int index, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.addAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.addAll(index, elements));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        synchronized (SnapshotStateListKt.sync) {
            StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification() + 1);
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    public T removeAt(int index) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(index);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent());
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListRemoveAt = list$runtime_release.removeAt(index);
            if (Intrinsics.areEqual(persistentListRemoveAt, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListRemoveAt);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.retainAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.retainAll(elements));
            }
        });
    }

    @Override // java.util.List
    public T set(int index, T element) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(index);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent());
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(index, element);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentList);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return t;
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> elements, int start, int end) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent());
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(start, end).retainAll(elements);
            Unit unit2 = Unit.INSTANCE;
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return size - size();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        Snapshot current;
        R rInvoke;
        StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                rInvoke = block.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return rInvoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        return block.invoke(SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent()));
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> block) {
        int modification;
        PersistentList<T> list$runtime_release;
        R rInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent());
                    modification = stateListStateRecord.getModification();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            rInvoke = block.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = Snapshot.INSTANCE.getCurrent();
                            StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                            if (stateListStateRecord3.getModification() == modification) {
                                stateListStateRecord3.setList$runtime_release(persistentListBuild);
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th2) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th2;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th3) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th3;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z);
        return rInvoke;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0096 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean conditionalUpdate(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r10) {
        /*
            r9 = this;
            r0 = r9
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L3:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            r1 = 1
            androidx.compose.runtime.snapshots.StateRecord r2 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.StateRecord r2 = (androidx.compose.runtime.snapshots.StateRecord) r2     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.Snapshot$Companion r3 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.Snapshot r3 = r3.getCurrent()     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r2, r3)     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L9f
            int r3 = r2.getModification()     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r2.getList$runtime_release()     // Catch: java.lang.Throwable -> L9f
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9f
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r0 = r10.invoke(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r0
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            r4 = 0
            if (r2 == 0) goto L40
            r1 = r4
            goto L8c
        L40:
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.StateRecord r5 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r5 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r5     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.StateRecord r5 = (androidx.compose.runtime.snapshots.StateRecord) r5     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L96
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L96
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L8d
            androidx.compose.runtime.snapshots.Snapshot r7 = r7.getCurrent()     // Catch: java.lang.Throwable -> L8d
            r8 = r9
            androidx.compose.runtime.snapshots.StateObject r8 = (androidx.compose.runtime.snapshots.StateObject) r8     // Catch: java.lang.Throwable -> L8d
            androidx.compose.runtime.snapshots.StateRecord r5 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r5, r8, r7)     // Catch: java.lang.Throwable -> L8d
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r5 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r5     // Catch: java.lang.Throwable -> L8d
            int r8 = r5.getModification()     // Catch: java.lang.Throwable -> L8d
            if (r8 != r3) goto L76
            r5.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L8d
            int r0 = r5.getModification()     // Catch: java.lang.Throwable -> L8d
            int r0 = r0 + r1
            r5.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L8d
            r4 = r1
        L76:
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L96
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch: java.lang.Throwable -> L96
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r7, r0)     // Catch: java.lang.Throwable -> L96
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            if (r4 == 0) goto L3
        L8c:
            return r1
        L8d:
            r10 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L96
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch: java.lang.Throwable -> L96
            throw r10     // Catch: java.lang.Throwable -> L96
        L96:
            r10 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r10
        L9f:
            r10 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(kotlin.jvm.functions.Function1):boolean");
    }

    public final int getModification$runtime_release() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent())).getModification();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007c */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean add(T r10) {
        /*
            r9 = this;
            r0 = r9
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L3:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.getCurrent()     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1, r2)     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7f
            int r2 = r1.getModification()     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7f
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7f
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.add(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L36
            goto L78
        L36:
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r1)
            androidx.compose.runtime.snapshots.StateRecord r4 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L7c
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L79
            r7 = r9
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r4, r7, r6)     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L79
            int r7 = r4.getModification()     // Catch: java.lang.Throwable -> L79
            r8 = 1
            if (r7 != r2) goto L6d
            r4.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L79
            int r0 = r4.getModification()     // Catch: java.lang.Throwable -> L79
            int r0 = r0 + r8
            r4.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L79
            r3 = r8
        L6d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7c
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r0)     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r1)
            if (r3 == 0) goto L3
            r3 = r8
        L78:
            return r3
        L79:
            r10 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7c
            throw r10     // Catch: java.lang.Throwable -> L7c
        L7c:
            r10 = move-exception
            monitor-exit(r1)
            throw r10
        L7f:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(java.lang.Object):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void add(int r8, T r9) {
        /*
            r7 = this;
            r0 = r7
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L3:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.getCurrent()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.add(r8, r9)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r1 == 0) goto L35
            goto L77
        L35:
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r1)
            androidx.compose.runtime.snapshots.StateRecord r3 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.StateRecord r3 = (androidx.compose.runtime.snapshots.StateRecord) r3     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L78
            r6 = r7
            androidx.compose.runtime.snapshots.StateObject r6 = (androidx.compose.runtime.snapshots.StateObject) r6     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.StateRecord r3 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r6, r5)     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch: java.lang.Throwable -> L78
            int r6 = r3.getModification()     // Catch: java.lang.Throwable -> L78
            if (r6 != r2) goto L6c
            r3.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r3.getModification()     // Catch: java.lang.Throwable -> L78
            r2 = 1
            int r0 = r0 + r2
            r3.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            goto L6d
        L6c:
            r2 = 0
        L6d:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L7b
            r0 = r7
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r0)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r1)
            if (r2 == 0) goto L3
        L77:
            return
        L78:
            r8 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L7b
            throw r8     // Catch: java.lang.Throwable -> L7b
        L7b:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        L7e:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(int, java.lang.Object):void");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0081 */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean addAll(java.util.Collection<? extends T> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = r9
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L8:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.getCurrent()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1, r2)     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L84
            int r2 = r1.getModification()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L84
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L84
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.addAll(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L3b
            goto L7d
        L3b:
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r1)
            androidx.compose.runtime.snapshots.StateRecord r4 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L81
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L81
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L7e
            r7 = r9
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r4, r7, r6)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L7e
            int r7 = r4.getModification()     // Catch: java.lang.Throwable -> L7e
            r8 = 1
            if (r7 != r2) goto L72
            r4.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L7e
            int r0 = r4.getModification()     // Catch: java.lang.Throwable -> L7e
            int r0 = r0 + r8
            r4.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L7e
            r3 = r8
        L72:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L81
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r0)     // Catch: java.lang.Throwable -> L81
            monitor-exit(r1)
            if (r3 == 0) goto L8
            r3 = r8
        L7d:
            return r3
        L7e:
            r10 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L81
            throw r10     // Catch: java.lang.Throwable -> L81
        L81:
            r10 = move-exception
            monitor-exit(r1)
            throw r10
        L84:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.addAll(java.util.Collection):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007c */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = r9
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L3:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.getCurrent()     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1, r2)     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7f
            int r2 = r1.getModification()     // Catch: java.lang.Throwable -> L7f
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7f
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7f
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.remove(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L36
            goto L78
        L36:
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r1)
            androidx.compose.runtime.snapshots.StateRecord r4 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L7c
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L79
            r7 = r9
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r4, r7, r6)     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L79
            int r7 = r4.getModification()     // Catch: java.lang.Throwable -> L79
            r8 = 1
            if (r7 != r2) goto L6d
            r4.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L79
            int r0 = r4.getModification()     // Catch: java.lang.Throwable -> L79
            int r0 = r0 + r8
            r4.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L79
            r3 = r8
        L6d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7c
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L7c
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r0)     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r1)
            if (r3 == 0) goto L3
            r3 = r8
        L78:
            return r3
        L79:
            r10 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7c
            throw r10     // Catch: java.lang.Throwable -> L7c
        L7c:
            r10 = move-exception
            monitor-exit(r1)
            throw r10
        L7f:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.remove(java.lang.Object):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0081 */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = r9
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L8:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.getCurrent()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1, r2)     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L84
            int r2 = r1.getModification()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L84
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L84
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.removeAll(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L3b
            goto L7d
        L3b:
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r1)
            androidx.compose.runtime.snapshots.StateRecord r4 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L81
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L81
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L7e
            r7 = r9
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r4, r7, r6)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L7e
            int r7 = r4.getModification()     // Catch: java.lang.Throwable -> L7e
            r8 = 1
            if (r7 != r2) goto L72
            r4.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L7e
            int r0 = r4.getModification()     // Catch: java.lang.Throwable -> L7e
            int r0 = r0 + r8
            r4.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L7e
            r3 = r8
        L72:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L81
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L81
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r0)     // Catch: java.lang.Throwable -> L81
            monitor-exit(r1)
            if (r3 == 0) goto L8
            r3 = r8
        L7d:
            return r3
        L7e:
            r10 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L81
            throw r10     // Catch: java.lang.Throwable -> L81
        L81:
            r10 = move-exception
            monitor-exit(r1)
            throw r10
        L84:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeAll(java.util.Collection):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0087 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeRange(int r8, int r9) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.getCurrent()     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1, r2)     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L8b
            int r2 = r1.getModification()     // Catch: java.lang.Throwable -> L8b
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L8b
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r0 = r1.builder()
            r3 = r0
            java.util.List r3 = (java.util.List) r3
            java.util.List r3 = r3.subList(r8, r9)
            r3.clear()
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.build()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r1 != 0) goto L8a
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r1)
            androidx.compose.runtime.snapshots.StateRecord r3 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.StateRecord r3 = (androidx.compose.runtime.snapshots.StateRecord) r3     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L87
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L87
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L84
            r6 = r7
            androidx.compose.runtime.snapshots.StateObject r6 = (androidx.compose.runtime.snapshots.StateObject) r6     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.StateRecord r3 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r6, r5)     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch: java.lang.Throwable -> L84
            int r6 = r3.getModification()     // Catch: java.lang.Throwable -> L84
            if (r6 != r2) goto L78
            r3.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L84
            int r0 = r3.getModification()     // Catch: java.lang.Throwable -> L84
            r2 = 1
            int r0 = r0 + r2
            r3.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L84
            goto L79
        L78:
            r2 = 0
        L79:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L87
            r0 = r7
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r0)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r1)
            if (r2 == 0) goto L0
            goto L8a
        L84:
            r8 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L87
            throw r8     // Catch: java.lang.Throwable -> L87
        L87:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        L8a:
            return
        L8b:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeRange(int, int):void");
    }

    public final List<T> getDebuggerDisplayValue() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent())).getList$runtime_release();
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> block) {
        int modification;
        PersistentList<T> list$runtime_release;
        Boolean boolInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.INSTANCE.getCurrent());
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            boolInvoke = block.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return boolInvoke.booleanValue();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0096 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void update(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r9) {
        /*
            r8 = this;
            r0 = r8
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
        L3:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            r1 = 1
            androidx.compose.runtime.snapshots.StateRecord r2 = r8.getFirstStateRecord()     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.StateRecord r2 = (androidx.compose.runtime.snapshots.StateRecord) r2     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.Snapshot$Companion r3 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.Snapshot r3 = r3.getCurrent()     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r2, r3)     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L9f
            int r3 = r2.getModification()     // Catch: java.lang.Throwable -> L9f
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r2.getList$runtime_release()     // Catch: java.lang.Throwable -> L9f
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9f
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r0 = r9.invoke(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r0
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L3e
            goto L8c
        L3e:
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.StateRecord r4 = r8.getFirstStateRecord()     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch: java.lang.Throwable -> L96
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch: java.lang.Throwable -> L96
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L8d
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L8d
            r7 = r8
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch: java.lang.Throwable -> L8d
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r4, r7, r6)     // Catch: java.lang.Throwable -> L8d
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch: java.lang.Throwable -> L8d
            int r7 = r4.getModification()     // Catch: java.lang.Throwable -> L8d
            if (r7 != r3) goto L75
            r4.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L8d
            int r0 = r4.getModification()     // Catch: java.lang.Throwable -> L8d
            int r0 = r0 + r1
            r4.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L8d
            r0 = r1
            goto L76
        L75:
            r0 = 0
        L76:
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L96
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch: java.lang.Throwable -> L96
            r3 = r8
            androidx.compose.runtime.snapshots.StateObject r3 = (androidx.compose.runtime.snapshots.StateObject) r3     // Catch: java.lang.Throwable -> L96
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r3)     // Catch: java.lang.Throwable -> L96
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            if (r0 == 0) goto L3
        L8c:
            return
        L8d:
            r9 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L96
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch: java.lang.Throwable -> L96
            throw r9     // Catch: java.lang.Throwable -> L96
        L96:
            r9 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r9
        L9f:
            r9 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.update(kotlin.jvm.functions.Function1):void");
    }
}
