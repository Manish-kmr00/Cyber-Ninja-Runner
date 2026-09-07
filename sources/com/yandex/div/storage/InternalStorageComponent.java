package com.yandex.div.storage;

import com.json.b9;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalStorageComponent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/storage/InternalStorageComponent;", "Lcom/yandex/div/storage/DivStorageComponent;", "repository", "Lcom/yandex/div/storage/DivDataRepository;", "rawJsonRepository", "Lcom/yandex/div/storage/RawJsonRepository;", b9.a.k, "Lcom/yandex/div/storage/DivStorage;", "(Lcom/yandex/div/storage/DivDataRepository;Lcom/yandex/div/storage/RawJsonRepository;Lcom/yandex/div/storage/DivStorage;)V", "getRawJsonRepository", "()Lcom/yandex/div/storage/RawJsonRepository;", "getRepository", "()Lcom/yandex/div/storage/DivDataRepository;", "getStorage", "()Lcom/yandex/div/storage/DivStorage;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InternalStorageComponent implements DivStorageComponent {
    private final RawJsonRepository rawJsonRepository;
    private final DivDataRepository repository;
    private final DivStorage storage;

    public InternalStorageComponent(DivDataRepository repository, RawJsonRepository rawJsonRepository, DivStorage storage) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(rawJsonRepository, "rawJsonRepository");
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.repository = repository;
        this.rawJsonRepository = rawJsonRepository;
        this.storage = storage;
    }

    @Override // com.yandex.div.storage.DivStorageComponent
    public DivDataRepository getRepository() {
        return this.repository;
    }

    @Override // com.yandex.div.storage.DivStorageComponent
    public RawJsonRepository getRawJsonRepository() {
        return this.rawJsonRepository;
    }

    public final DivStorage getStorage() {
        return this.storage;
    }
}
