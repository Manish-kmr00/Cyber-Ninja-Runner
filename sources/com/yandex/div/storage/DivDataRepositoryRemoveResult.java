package com.yandex.div.storage;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivDataRepositoryResult.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/storage/DivDataRepositoryRemoveResult;", "", "ids", "", "", "errors", "", "Lcom/yandex/div/storage/DivDataRepositoryException;", "(Ljava/util/Set;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getIds", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivDataRepositoryRemoveResult {
    private final List<DivDataRepositoryException> errors;
    private final Set<String> ids;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivDataRepositoryRemoveResult copy$default(DivDataRepositoryRemoveResult divDataRepositoryRemoveResult, Set set, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            set = divDataRepositoryRemoveResult.ids;
        }
        if ((i & 2) != 0) {
            list = divDataRepositoryRemoveResult.errors;
        }
        return divDataRepositoryRemoveResult.copy(set, list);
    }

    public final Set<String> component1() {
        return this.ids;
    }

    public final List<DivDataRepositoryException> component2() {
        return this.errors;
    }

    public final DivDataRepositoryRemoveResult copy(Set<String> ids, List<? extends DivDataRepositoryException> errors) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new DivDataRepositoryRemoveResult(ids, errors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivDataRepositoryRemoveResult)) {
            return false;
        }
        DivDataRepositoryRemoveResult divDataRepositoryRemoveResult = (DivDataRepositoryRemoveResult) other;
        return Intrinsics.areEqual(this.ids, divDataRepositoryRemoveResult.ids) && Intrinsics.areEqual(this.errors, divDataRepositoryRemoveResult.errors);
    }

    public int hashCode() {
        return (this.ids.hashCode() * 31) + this.errors.hashCode();
    }

    public String toString() {
        return "DivDataRepositoryRemoveResult(ids=" + this.ids + ", errors=" + this.errors + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivDataRepositoryRemoveResult(Set<String> ids, List<? extends DivDataRepositoryException> errors) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.ids = ids;
        this.errors = errors;
    }

    public final Set<String> getIds() {
        return this.ids;
    }

    public final List<DivDataRepositoryException> getErrors() {
        return this.errors;
    }
}
