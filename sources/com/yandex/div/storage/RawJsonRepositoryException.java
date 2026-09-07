package com.yandex.div.storage;

import com.yandex.div.storage.database.StorageException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawJsonRepositoryException.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div/storage/RawJsonRepositoryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "storageException", "Lcom/yandex/div/storage/database/StorageException;", "(Lcom/yandex/div/storage/database/StorageException;)V", "jsonId", "", "getJsonId", "()Ljava/lang/String;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RawJsonRepositoryException extends Exception {
    private final String jsonId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawJsonRepositoryException(StorageException storageException) {
        super(storageException.getMessage(), storageException);
        Intrinsics.checkNotNullParameter(storageException, "storageException");
        this.jsonId = storageException.getCardId();
    }

    public final String getJsonId() {
        return this.jsonId;
    }
}
