package com.yandex.div.storage;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivDataRepositoryResult.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/storage/DivDataRepositoryResult;", "", "resultData", "", "Lcom/yandex/div/storage/DivDataRepository$DivDataWithMeta;", "errors", "Lcom/yandex/div/storage/DivDataRepositoryException;", "(Ljava/util/List;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getResultData", "addData", "data", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivDataRepositoryResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivDataRepositoryResult EMPTY = new DivDataRepositoryResult(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    private final List<DivDataRepositoryException> errors;
    private final List<DivDataRepository.DivDataWithMeta> resultData;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivDataRepositoryResult copy$default(DivDataRepositoryResult divDataRepositoryResult, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = divDataRepositoryResult.resultData;
        }
        if ((i & 2) != 0) {
            list2 = divDataRepositoryResult.errors;
        }
        return divDataRepositoryResult.copy(list, list2);
    }

    public final List<DivDataRepository.DivDataWithMeta> component1() {
        return this.resultData;
    }

    public final List<DivDataRepositoryException> component2() {
        return this.errors;
    }

    public final DivDataRepositoryResult copy(List<DivDataRepository.DivDataWithMeta> resultData, List<? extends DivDataRepositoryException> errors) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new DivDataRepositoryResult(resultData, errors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivDataRepositoryResult)) {
            return false;
        }
        DivDataRepositoryResult divDataRepositoryResult = (DivDataRepositoryResult) other;
        return Intrinsics.areEqual(this.resultData, divDataRepositoryResult.resultData) && Intrinsics.areEqual(this.errors, divDataRepositoryResult.errors);
    }

    public int hashCode() {
        return (this.resultData.hashCode() * 31) + this.errors.hashCode();
    }

    public String toString() {
        return "DivDataRepositoryResult(resultData=" + this.resultData + ", errors=" + this.errors + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivDataRepositoryResult(List<DivDataRepository.DivDataWithMeta> resultData, List<? extends DivDataRepositoryException> errors) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.resultData = resultData;
        this.errors = errors;
    }

    public final List<DivDataRepository.DivDataWithMeta> getResultData() {
        return this.resultData;
    }

    public final List<DivDataRepositoryException> getErrors() {
        return this.errors;
    }

    public final DivDataRepositoryResult addData(Collection<DivDataRepository.DivDataWithMeta> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return copy$default(this, CollectionsKt.plus((Collection) this.resultData, (Iterable) data), null, 2, null);
    }

    /* JADX INFO: compiled from: DivDataRepositoryResult.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/storage/DivDataRepositoryResult$Companion;", "", "()V", "EMPTY", "Lcom/yandex/div/storage/DivDataRepositoryResult;", "getEMPTY", "()Lcom/yandex/div/storage/DivDataRepositoryResult;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DivDataRepositoryResult getEMPTY() {
            return DivDataRepositoryResult.EMPTY;
        }
    }
}
