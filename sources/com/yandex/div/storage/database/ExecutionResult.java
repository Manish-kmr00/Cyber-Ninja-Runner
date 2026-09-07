package com.yandex.div.storage.database;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExecutionResult.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/storage/database/ExecutionResult;", "", "errors", "", "Lcom/yandex/div/storage/database/StorageException;", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "isSuccessful", "", "()Z", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ExecutionResult {
    private final List<StorageException> errors;

    public ExecutionResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExecutionResult(List<? extends StorageException> errors) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.errors = errors;
    }

    public /* synthetic */ ExecutionResult(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public List<StorageException> getErrors() {
        return this.errors;
    }

    public boolean isSuccessful() {
        return getErrors().isEmpty();
    }
}
