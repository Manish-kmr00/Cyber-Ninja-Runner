package com.yandex.div.storage;

import androidx.exifinterface.media.ExifInterface;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.storage.database.StorageException;
import com.yandex.div.storage.rawjson.RawJson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawJsonRepositoryImpl.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u000fH\u0017J\u001a\u0010\u0013\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u001c\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u001aH\u0017J\u001a\u0010\u001b\u001a\u00020\u001c2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\rH\u0002J,\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\r\"\u0004\b\u0000\u0010\u001f\"\u0004\b\u0001\u0010 *\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u001f\u0012\u0004\u0012\u0002H 0!H\u0002J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0011*\b\u0012\u0004\u0012\u00020$0\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/yandex/div/storage/RawJsonRepositoryImpl;", "Lcom/yandex/div/storage/RawJsonRepository;", "divStorage", "Lcom/yandex/div/storage/DivStorage;", "(Lcom/yandex/div/storage/DivStorage;)V", "areJsonsSynchronizedWithInMemory", "", "inMemoryData", "", "", "Lcom/yandex/div/storage/JsonId;", "Lcom/yandex/div/storage/rawjson/RawJson;", "jsonIdsWithErrors", "", "get", "Lcom/yandex/div/storage/RawJsonRepositoryResult;", "ids", "", "getAll", "loadFromStorage", "put", "payload", "Lcom/yandex/div/storage/RawJsonRepository$Payload;", "remove", "Lcom/yandex/div/storage/RawJsonRepositoryRemoveResult;", "predicate", "Lkotlin/Function1;", "removeFromInMemory", "", "deletedRecords", "getKeysNotNull", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toRawJsonRepositoryExceptions", "Lcom/yandex/div/storage/RawJsonRepositoryException;", "Lcom/yandex/div/storage/database/StorageException;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RawJsonRepositoryImpl implements RawJsonRepository {
    private boolean areJsonsSynchronizedWithInMemory;
    private final DivStorage divStorage;
    private final Map<String, RawJson> inMemoryData;
    private Set<String> jsonIdsWithErrors;

    public RawJsonRepositoryImpl(DivStorage divStorage) {
        Intrinsics.checkNotNullParameter(divStorage, "divStorage");
        this.divStorage = divStorage;
        this.inMemoryData = new LinkedHashMap();
        this.jsonIdsWithErrors = SetsKt.emptySet();
    }

    @Override // com.yandex.div.storage.RawJsonRepository
    public RawJsonRepositoryResult put(RawJsonRepository.Payload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.assertMainThread();
        }
        List<RawJson> jsons = payload.getJsons();
        for (RawJson rawJson : jsons) {
            this.inMemoryData.put(rawJson.getId(), rawJson);
        }
        List<StorageException> errors = this.divStorage.saveRawJsons(jsons, payload.getActionOnError()).getErrors();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(toRawJsonRepositoryExceptions(errors));
        return new RawJsonRepositoryResult(jsons, arrayList);
    }

    @Override // com.yandex.div.storage.RawJsonRepository
    public RawJsonRepositoryResult get(List<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.assertMainThread();
        }
        if (ids.isEmpty()) {
            return RawJsonRepositoryResult.INSTANCE.getEMPTY();
        }
        List<String> list = ids;
        Set<String> mutableSet = CollectionsKt.toMutableSet(list);
        ArrayList arrayList = new ArrayList(ids.size());
        for (String str : list) {
            RawJson rawJson = this.inMemoryData.get(str);
            if (rawJson != null) {
                arrayList.add(rawJson);
                mutableSet.remove(str);
            }
        }
        if (!mutableSet.isEmpty()) {
            RawJsonRepositoryResult rawJsonRepositoryResultLoadFromStorage = loadFromStorage(mutableSet);
            for (RawJson rawJson2 : rawJsonRepositoryResultLoadFromStorage.getResultData()) {
                this.inMemoryData.put(rawJson2.getId(), rawJson2);
            }
            return rawJsonRepositoryResultLoadFromStorage.addData(arrayList);
        }
        return new RawJsonRepositoryResult(arrayList, CollectionsKt.emptyList());
    }

    @Override // com.yandex.div.storage.RawJsonRepository
    public RawJsonRepositoryResult getAll() {
        Set<String> setEmptySet;
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.assertMainThread();
        }
        if (this.areJsonsSynchronizedWithInMemory && this.jsonIdsWithErrors.isEmpty()) {
            return new RawJsonRepositoryResult(CollectionsKt.toList(this.inMemoryData.values()), CollectionsKt.emptyList());
        }
        if (this.areJsonsSynchronizedWithInMemory) {
            setEmptySet = this.jsonIdsWithErrors;
        } else {
            setEmptySet = SetsKt.emptySet();
        }
        RawJsonRepositoryResult rawJsonRepositoryResultLoadFromStorage = loadFromStorage(setEmptySet);
        RawJsonRepositoryResult rawJsonRepositoryResultAddData = rawJsonRepositoryResultLoadFromStorage.addData(this.inMemoryData.values());
        for (RawJson rawJson : rawJsonRepositoryResultLoadFromStorage.getResultData()) {
            this.inMemoryData.put(rawJson.getId(), rawJson);
        }
        this.areJsonsSynchronizedWithInMemory = true;
        List<RawJsonRepositoryException> errors = rawJsonRepositoryResultLoadFromStorage.getErrors();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : errors) {
            String jsonId = ((RawJsonRepositoryException) obj).getJsonId();
            Object obj2 = linkedHashMap.get(jsonId);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(jsonId, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.jsonIdsWithErrors = getKeysNotNull(linkedHashMap);
        return rawJsonRepositoryResultAddData;
    }

    @Override // com.yandex.div.storage.RawJsonRepository
    public RawJsonRepositoryRemoveResult remove(Function1<? super RawJson, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.assertMainThread();
        }
        DivStorage.RemoveResult removeResultRemoveRawJsons = this.divStorage.removeRawJsons(predicate);
        Set<String> setComponent1 = removeResultRemoveRawJsons.component1();
        List<RawJsonRepositoryException> rawJsonRepositoryExceptions = toRawJsonRepositoryExceptions(removeResultRemoveRawJsons.component2());
        removeFromInMemory(setComponent1);
        return new RawJsonRepositoryRemoveResult(setComponent1, rawJsonRepositoryExceptions);
    }

    private final RawJsonRepositoryResult loadFromStorage(Set<String> ids) {
        ArrayList arrayList = new ArrayList();
        DivStorage.LoadDataResult<RawJson> rawJsons = this.divStorage.readRawJsons(ids);
        List<RawJson> listComponent1 = rawJsons.component1();
        arrayList.addAll(toRawJsonRepositoryExceptions(rawJsons.component2()));
        return new RawJsonRepositoryResult(listComponent1, arrayList);
    }

    private final void removeFromInMemory(Set<String> deletedRecords) {
        Iterator<T> it = deletedRecords.iterator();
        while (it.hasNext()) {
            this.inMemoryData.remove((String) it.next());
        }
    }

    private final <K, V> Set<K> getKeysNotNull(Map<K, ? extends V> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            K key = it.next().getKey();
            if (key != null) {
                linkedHashSet.add(key);
            }
        }
        return linkedHashSet;
    }

    private final List<RawJsonRepositoryException> toRawJsonRepositoryExceptions(List<? extends StorageException> list) {
        List<? extends StorageException> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawJsonRepositoryException((StorageException) it.next()));
        }
        return arrayList;
    }
}
