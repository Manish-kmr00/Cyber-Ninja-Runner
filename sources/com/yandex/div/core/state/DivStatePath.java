package com.yandex.div.core.state;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DivStatePath.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-B;\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\tJ\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0007J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÂ\u0003J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÀ\u0003¢\u0006\u0002\b!J?\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0018\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005J\t\u0010'\u001a\u00020(HÖ\u0001J\u000e\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0000J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020\u0000J\b\u0010,\u001a\u00020\u0007H\u0016R\u001b\u0010\n\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/yandex/div/core/state/DivStatePath;", "", "topLevelStateId", "", "states", "", "Lkotlin/Pair;", "", "path", "(JLjava/util/List;Ljava/util/List;)V", "fullPath", "getFullPath$div_release", "()Ljava/lang/String;", "fullPath$delegate", "Lkotlin/Lazy;", "lastStateId", "getLastStateId", "getPath$div_release", "()Ljava/util/List;", "pathToLastState", "getPathToLastState", "stringValue", "getStringValue", "stringValue$delegate", "getTopLevelStateId", "()J", "append", "divId", "stateId", "appendDiv", "component1", "component2", "component3", "component3$div_release", "copy", "equals", "", "other", "getStates", "hashCode", "", "isAncestorOf", "isRootPath", "parentState", "toString", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivStatePath {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: fullPath$delegate, reason: from kotlin metadata */
    private final Lazy fullPath;
    private final List<String> path;
    private final List<Pair<String, String>> states;

    /* JADX INFO: renamed from: stringValue$delegate, reason: from kotlin metadata */
    private final Lazy stringValue;
    private final long topLevelStateId;

    private final List<Pair<String, String>> component2() {
        return this.states;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivStatePath copy$default(DivStatePath divStatePath, long j, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = divStatePath.topLevelStateId;
        }
        if ((i & 2) != 0) {
            list = divStatePath.states;
        }
        if ((i & 4) != 0) {
            list2 = divStatePath.path;
        }
        return divStatePath.copy(j, list, list2);
    }

    @JvmStatic
    public static final DivStatePath parse(String str) throws PathFormatException {
        return INSTANCE.parse(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTopLevelStateId() {
        return this.topLevelStateId;
    }

    public final List<String> component3$div_release() {
        return this.path;
    }

    public final DivStatePath copy(long topLevelStateId, List<Pair<String, String>> states, List<String> path) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(path, "path");
        return new DivStatePath(topLevelStateId, states, path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivStatePath)) {
            return false;
        }
        DivStatePath divStatePath = (DivStatePath) other;
        return this.topLevelStateId == divStatePath.topLevelStateId && Intrinsics.areEqual(this.states, divStatePath.states) && Intrinsics.areEqual(this.path, divStatePath.path);
    }

    public int hashCode() {
        return (((Long.hashCode(this.topLevelStateId) * 31) + this.states.hashCode()) * 31) + this.path.hashCode();
    }

    public DivStatePath(long j, List<Pair<String, String>> states, List<String> path) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(path, "path");
        this.topLevelStateId = j;
        this.states = states;
        this.path = path;
        this.fullPath = LazyKt.lazy(new Function0<String>() { // from class: com.yandex.div.core.state.DivStatePath$fullPath$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(this.this$0.getPath$div_release(), RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null);
            }
        });
        this.stringValue = LazyKt.lazy(new Function0<String>() { // from class: com.yandex.div.core.state.DivStatePath$stringValue$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (!this.this$0.states.isEmpty()) {
                    StringBuilder sbAppend = new StringBuilder().append(this.this$0.getTopLevelStateId()).append('/');
                    List<Pair> list = this.this$0.states;
                    ArrayList arrayList = new ArrayList();
                    for (Pair pair : list) {
                        CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new String[]{DivStatePathKt.getDivId(pair), DivStatePathKt.getStateId(pair)}));
                    }
                    return sbAppend.append(CollectionsKt.joinToString$default(arrayList, RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null)).toString();
                }
                return String.valueOf(this.this$0.getTopLevelStateId());
            }
        });
    }

    public final long getTopLevelStateId() {
        return this.topLevelStateId;
    }

    public /* synthetic */ DivStatePath(long j, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.listOf(String.valueOf(j)) : list2);
    }

    public final List<String> getPath$div_release() {
        return this.path;
    }

    public final String getLastStateId() {
        if (this.states.isEmpty()) {
            return null;
        }
        return DivStatePathKt.getStateId((Pair) CollectionsKt.last((List) this.states));
    }

    public final String getPathToLastState() {
        if (this.states.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        long j = this.topLevelStateId;
        List<Pair<String, String>> list = this.states;
        return sb.append(new DivStatePath(j, list.subList(0, list.size() - 1), null, 4, null)).append('/').append(DivStatePathKt.getDivId((Pair) CollectionsKt.last((List) this.states))).toString();
    }

    public final String getFullPath$div_release() {
        return (String) this.fullPath.getValue();
    }

    private final String getStringValue() {
        return (String) this.stringValue.getValue();
    }

    public String toString() {
        return getStringValue();
    }

    public final DivStatePath append(String divId, String stateId) {
        Intrinsics.checkNotNullParameter(divId, "divId");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        ArrayList arrayList = new ArrayList(this.states.size() + 1);
        arrayList.addAll(this.states);
        arrayList.add(TuplesKt.to(divId, stateId));
        ArrayList arrayList2 = new ArrayList(this.path.size() + 2);
        arrayList2.addAll(this.path);
        arrayList2.add(divId);
        arrayList2.add(stateId);
        return new DivStatePath(this.topLevelStateId, arrayList, arrayList2);
    }

    public final DivStatePath appendDiv(String divId) {
        Intrinsics.checkNotNullParameter(divId, "divId");
        ArrayList arrayList = new ArrayList(this.path.size() + 1);
        arrayList.addAll(this.path);
        arrayList.add(divId);
        return new DivStatePath(this.topLevelStateId, this.states, arrayList);
    }

    public final List<Pair<String, String>> getStates() {
        return this.states;
    }

    public final DivStatePath parentState() {
        if (isRootPath()) {
            return this;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) this.states);
        CollectionsKt.removeLast(mutableList);
        return new DivStatePath(this.topLevelStateId, mutableList, null, 4, null);
    }

    public final boolean isRootPath() {
        return this.states.isEmpty();
    }

    public final boolean isAncestorOf(DivStatePath other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.topLevelStateId != other.topLevelStateId || this.states.size() >= other.states.size()) {
            return false;
        }
        int i = 0;
        for (Object obj : this.states) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            Pair<String, String> pair2 = other.states.get(i);
            if (!Intrinsics.areEqual(DivStatePathKt.getDivId(pair), DivStatePathKt.getDivId(pair2)) || !Intrinsics.areEqual(DivStatePathKt.getStateId(pair), DivStatePathKt.getStateId(pair2))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    /* JADX INFO: compiled from: DivStatePath.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0000¢\u0006\u0002\b\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/state/DivStatePath$Companion;", "", "()V", "alphabeticalComparator", "Ljava/util/Comparator;", "Lcom/yandex/div/core/state/DivStatePath;", "Lkotlin/Comparator;", "alphabeticalComparator$div_release", "fromState", "stateId", "", "lowestCommonAncestor", "somePath", "otherPath", "lowestCommonAncestor$div_release", "parse", "path", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Comparator<DivStatePath> alphabeticalComparator$div_release() {
            return new Comparator() { // from class: com.yandex.div.core.state.DivStatePath$Companion$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DivStatePath.Companion.alphabeticalComparator$lambda$1((DivStatePath) obj, (DivStatePath) obj2);
                }
            };
        }

        private Companion() {
        }

        @JvmStatic
        public final DivStatePath parse(String path) throws PathFormatException {
            Intrinsics.checkNotNullParameter(path, "path");
            ArrayList arrayList = new ArrayList();
            List listSplit$default = StringsKt.split$default((CharSequence) path, new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null);
            try {
                long j = Long.parseLong((String) listSplit$default.get(0));
                if (listSplit$default.size() % 2 != 1) {
                    throw new PathFormatException("Must be even number of states in path: " + path, null, 2, null);
                }
                IntProgression intProgressionStep = RangesKt.step(RangesKt.until(1, listSplit$default.size()), 2);
                int first = intProgressionStep.getFirst();
                int last = intProgressionStep.getLast();
                int step = intProgressionStep.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        arrayList.add(TuplesKt.to(listSplit$default.get(first), listSplit$default.get(first + 1)));
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
                return new DivStatePath(j, arrayList, null, 4, null);
            } catch (NumberFormatException e) {
                throw new PathFormatException("Top level id must be number: " + path, e);
            }
        }

        public final DivStatePath fromState(long stateId) {
            return new DivStatePath(stateId, new ArrayList(), null, 4, null);
        }

        public final DivStatePath lowestCommonAncestor$div_release(DivStatePath somePath, DivStatePath otherPath) {
            Intrinsics.checkNotNullParameter(somePath, "somePath");
            Intrinsics.checkNotNullParameter(otherPath, "otherPath");
            if (somePath.getTopLevelStateId() != otherPath.getTopLevelStateId()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : somePath.states) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                Pair pair2 = (Pair) CollectionsKt.getOrNull(otherPath.states, i);
                if (pair2 == null || !Intrinsics.areEqual(pair, pair2)) {
                    return new DivStatePath(somePath.getTopLevelStateId(), arrayList, null, 4, null);
                }
                arrayList.add(pair);
                i = i2;
            }
            return new DivStatePath(somePath.getTopLevelStateId(), arrayList, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int alphabeticalComparator$lambda$1(DivStatePath lhs, DivStatePath rhs) {
            if (lhs.getTopLevelStateId() != rhs.getTopLevelStateId()) {
                return (int) (lhs.getTopLevelStateId() - rhs.getTopLevelStateId());
            }
            Intrinsics.checkNotNullExpressionValue(lhs, "lhs");
            int size = lhs.states.size();
            Intrinsics.checkNotNullExpressionValue(rhs, "rhs");
            int iMin = Math.min(size, rhs.states.size());
            for (int i = 0; i < iMin; i++) {
                Pair pair = (Pair) lhs.states.get(i);
                Pair pair2 = (Pair) rhs.states.get(i);
                int iCompareTo = DivStatePathKt.getDivId(pair).compareTo(DivStatePathKt.getDivId(pair2));
                if (iCompareTo != 0 || DivStatePathKt.getStateId(pair).compareTo(DivStatePathKt.getStateId(pair2)) != 0) {
                    return iCompareTo;
                }
            }
            return lhs.states.size() - rhs.states.size();
        }
    }
}
