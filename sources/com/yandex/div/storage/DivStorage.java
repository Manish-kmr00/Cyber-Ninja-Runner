package com.yandex.div.storage;

import com.yandex.div.storage.database.ExecutionResult;
import com.yandex.div.storage.database.Migration;
import com.yandex.div.storage.database.StorageException;
import com.yandex.div.storage.rawjson.RawJson;
import com.yandex.div.storage.templates.RawTemplateData;
import com.yandex.div.storage.templates.Template;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivStorage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001:\u00041234J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH&J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H'J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019H'J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011H&J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0019H'J\u001c\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\"H'J\n\u0010$\u001a\u0004\u0018\u00010%H'J\n\u0010&\u001a\u0004\u0018\u00010%H'J\u001c\u0010'\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\"H'J4\u0010(\u001a\u00020)2\u0006\u0010\r\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\u00142\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00142\u0006\u0010-\u001a\u00020.H'J\u001e\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010-\u001a\u00020.H'R*\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/DivStorage;", "", "migrations", "", "Lkotlin/Pair;", "", "Lcom/yandex/div/storage/database/Migration;", "getMigrations", "()Ljava/util/Map;", "isCardExists", "", "id", "", "groupId", "isTemplateExists", "templateHash", "loadData", "Lcom/yandex/div/storage/DivStorage$LoadDataResult;", "Lcom/yandex/div/storage/DivStorage$RestoredRawData;", "ids", "", "idsToExclude", "readRawJsons", "Lcom/yandex/div/storage/rawjson/RawJson;", "rawJsonIds", "", "readTemplateReferences", "Lcom/yandex/div/storage/DivStorage$TemplateReference;", "readTemplates", "Lcom/yandex/div/storage/templates/RawTemplateData;", "templateHashes", "remove", "Lcom/yandex/div/storage/DivStorage$RemoveResult;", "predicate", "Lkotlin/Function1;", "Lcom/yandex/div/storage/RawDataAndMetadata;", "removeAllCards", "Lcom/yandex/div/storage/DivStorageErrorException;", "removeAllTemplates", "removeRawJsons", "saveData", "Lcom/yandex/div/storage/database/ExecutionResult;", "divs", "templatesByHash", "Lcom/yandex/div/storage/templates/Template;", "actionOnError", "Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "saveRawJsons", "rawJsons", "LoadDataResult", "RemoveResult", "RestoredRawData", "TemplateReference", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivStorage {
    Map<Pair<Integer, Integer>, Migration> getMigrations();

    boolean isCardExists(String id, String groupId) throws DivStorageErrorException;

    boolean isTemplateExists(String templateHash) throws DivStorageErrorException;

    LoadDataResult<RestoredRawData> loadData(List<String> ids, List<String> idsToExclude);

    LoadDataResult<RawJson> readRawJsons(Set<String> rawJsonIds);

    LoadDataResult<TemplateReference> readTemplateReferences();

    LoadDataResult<RawTemplateData> readTemplates(Set<String> templateHashes);

    RemoveResult remove(Function1<? super RawDataAndMetadata, Boolean> predicate);

    DivStorageErrorException removeAllCards();

    DivStorageErrorException removeAllTemplates();

    RemoveResult removeRawJsons(Function1<? super RawJson, Boolean> predicate);

    ExecutionResult saveData(String groupId, List<? extends RawDataAndMetadata> divs, List<Template> templatesByHash, DivDataRepository.ActionOnError actionOnError);

    ExecutionResult saveRawJsons(List<? extends RawJson> rawJsons, DivDataRepository.ActionOnError actionOnError);

    /* JADX INFO: compiled from: DivStorage.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000e\u0010\u0012\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0013J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/storage/DivStorage$RestoredRawData;", "", "id", "", "divData", "Lorg/json/JSONObject;", "metadata", "groupId", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V", "getDivData", "()Lorg/json/JSONObject;", "getGroupId$div_storage_release", "()Ljava/lang/String;", "getId", "getMetadata", "component1", "component2", "component3", "component4", "component4$div_storage_release", "copy", "equals", "", "other", "hashCode", "", "toString", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class RestoredRawData {
        private final JSONObject divData;
        private final String groupId;
        private final String id;
        private final JSONObject metadata;

        public static /* synthetic */ RestoredRawData copy$default(RestoredRawData restoredRawData, String str, JSONObject jSONObject, JSONObject jSONObject2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = restoredRawData.id;
            }
            if ((i & 2) != 0) {
                jSONObject = restoredRawData.divData;
            }
            if ((i & 4) != 0) {
                jSONObject2 = restoredRawData.metadata;
            }
            if ((i & 8) != 0) {
                str2 = restoredRawData.groupId;
            }
            return restoredRawData.copy(str, jSONObject, jSONObject2, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JSONObject getDivData() {
            return this.divData;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final JSONObject getMetadata() {
            return this.metadata;
        }

        /* JADX INFO: renamed from: component4$div_storage_release, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        public final RestoredRawData copy(String id, JSONObject divData, JSONObject metadata, String groupId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(divData, "divData");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            return new RestoredRawData(id, divData, metadata, groupId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RestoredRawData)) {
                return false;
            }
            RestoredRawData restoredRawData = (RestoredRawData) other;
            return Intrinsics.areEqual(this.id, restoredRawData.id) && Intrinsics.areEqual(this.divData, restoredRawData.divData) && Intrinsics.areEqual(this.metadata, restoredRawData.metadata) && Intrinsics.areEqual(this.groupId, restoredRawData.groupId);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.divData.hashCode()) * 31;
            JSONObject jSONObject = this.metadata;
            return ((iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31) + this.groupId.hashCode();
        }

        public String toString() {
            return "RestoredRawData(id=" + this.id + ", divData=" + this.divData + ", metadata=" + this.metadata + ", groupId=" + this.groupId + ')';
        }

        public RestoredRawData(String id, JSONObject divData, JSONObject jSONObject, String groupId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(divData, "divData");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            this.id = id;
            this.divData = divData;
            this.metadata = jSONObject;
            this.groupId = groupId;
        }

        public /* synthetic */ RestoredRawData(String str, JSONObject jSONObject, JSONObject jSONObject2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jSONObject, (i & 4) != 0 ? null : jSONObject2, str2);
        }

        public final String getId() {
            return this.id;
        }

        public final JSONObject getDivData() {
            return this.divData;
        }

        public final JSONObject getMetadata() {
            return this.metadata;
        }

        public final String getGroupId$div_storage_release() {
            return this.groupId;
        }
    }

    /* JADX INFO: compiled from: DivStorage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0096\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J/\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/storage/DivStorage$LoadDataResult;", "T", "", "restoredData", "", "errors", "Lcom/yandex/div/storage/database/StorageException;", "(Ljava/util/List;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getRestoredData", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static /* data */ class LoadDataResult<T> {
        private final List<StorageException> errors;
        private final List<T> restoredData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoadDataResult copy$default(LoadDataResult loadDataResult, List list, List list2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
            }
            if ((i & 1) != 0) {
                list = loadDataResult.getRestoredData();
            }
            if ((i & 2) != 0) {
                list2 = loadDataResult.getErrors();
            }
            return loadDataResult.copy(list, list2);
        }

        public final List<T> component1() {
            return getRestoredData();
        }

        public final List<StorageException> component2() {
            return getErrors();
        }

        public final LoadDataResult<T> copy(List<? extends T> restoredData, List<? extends StorageException> errors) {
            Intrinsics.checkNotNullParameter(restoredData, "restoredData");
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new LoadDataResult<>(restoredData, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadDataResult)) {
                return false;
            }
            LoadDataResult loadDataResult = (LoadDataResult) other;
            return Intrinsics.areEqual(getRestoredData(), loadDataResult.getRestoredData()) && Intrinsics.areEqual(getErrors(), loadDataResult.getErrors());
        }

        public int hashCode() {
            return (getRestoredData().hashCode() * 31) + getErrors().hashCode();
        }

        public String toString() {
            return "LoadDataResult(restoredData=" + getRestoredData() + ", errors=" + getErrors() + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LoadDataResult(List<? extends T> restoredData, List<? extends StorageException> errors) {
            Intrinsics.checkNotNullParameter(restoredData, "restoredData");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.restoredData = restoredData;
            this.errors = errors;
        }

        public List<T> getRestoredData() {
            return this.restoredData;
        }

        public /* synthetic */ LoadDataResult(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public List<StorageException> getErrors() {
            return this.errors;
        }
    }

    /* JADX INFO: compiled from: DivStorage.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/storage/DivStorage$RemoveResult;", "", "ids", "", "", "errors", "", "Lcom/yandex/div/storage/database/StorageException;", "(Ljava/util/Set;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getIds", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class RemoveResult {
        private final List<StorageException> errors;
        private final Set<String> ids;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoveResult copy$default(RemoveResult removeResult, Set set, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                set = removeResult.ids;
            }
            if ((i & 2) != 0) {
                list = removeResult.errors;
            }
            return removeResult.copy(set, list);
        }

        public final Set<String> component1() {
            return this.ids;
        }

        public final List<StorageException> component2() {
            return this.errors;
        }

        public final RemoveResult copy(Set<String> ids, List<? extends StorageException> errors) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new RemoveResult(ids, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoveResult)) {
                return false;
            }
            RemoveResult removeResult = (RemoveResult) other;
            return Intrinsics.areEqual(this.ids, removeResult.ids) && Intrinsics.areEqual(this.errors, removeResult.errors);
        }

        public int hashCode() {
            return (this.ids.hashCode() * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "RemoveResult(ids=" + this.ids + ", errors=" + this.errors + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RemoveResult(Set<String> ids, List<? extends StorageException> errors) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.ids = ids;
            this.errors = errors;
        }

        public final Set<String> getIds() {
            return this.ids;
        }

        public /* synthetic */ RemoveResult(Set set, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(set, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<StorageException> getErrors() {
            return this.errors;
        }
    }

    /* JADX INFO: compiled from: DivStorage.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/storage/DivStorage$TemplateReference;", "", "groupId", "", "templateId", "templateHash", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "getTemplateHash", "getTemplateId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class TemplateReference {
        private final String groupId;
        private final String templateHash;
        private final String templateId;

        public static /* synthetic */ TemplateReference copy$default(TemplateReference templateReference, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = templateReference.groupId;
            }
            if ((i & 2) != 0) {
                str2 = templateReference.templateId;
            }
            if ((i & 4) != 0) {
                str3 = templateReference.templateHash;
            }
            return templateReference.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTemplateId() {
            return this.templateId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTemplateHash() {
            return this.templateHash;
        }

        public final TemplateReference copy(String groupId, String templateId, String templateHash) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            Intrinsics.checkNotNullParameter(templateHash, "templateHash");
            return new TemplateReference(groupId, templateId, templateHash);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TemplateReference)) {
                return false;
            }
            TemplateReference templateReference = (TemplateReference) other;
            return Intrinsics.areEqual(this.groupId, templateReference.groupId) && Intrinsics.areEqual(this.templateId, templateReference.templateId) && Intrinsics.areEqual(this.templateHash, templateReference.templateHash);
        }

        public int hashCode() {
            return (((this.groupId.hashCode() * 31) + this.templateId.hashCode()) * 31) + this.templateHash.hashCode();
        }

        public String toString() {
            return "TemplateReference(groupId=" + this.groupId + ", templateId=" + this.templateId + ", templateHash=" + this.templateHash + ')';
        }

        public TemplateReference(String groupId, String templateId, String templateHash) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            Intrinsics.checkNotNullParameter(templateHash, "templateHash");
            this.groupId = groupId;
            this.templateId = templateId;
            this.templateHash = templateHash;
        }

        public final String getGroupId() {
            return this.groupId;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final String getTemplateHash() {
            return this.templateHash;
        }
    }
}
