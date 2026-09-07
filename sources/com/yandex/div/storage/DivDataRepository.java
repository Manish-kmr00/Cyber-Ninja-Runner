package com.yandex.div.storage;

import com.yandex.div2.DivData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivDataRepository.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0007\u001a\u00020\u0003H'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH'J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/DivDataRepository;", "", "get", "Lcom/yandex/div/storage/DivDataRepositoryResult;", "ids", "", "", "getAll", "put", "payload", "Lcom/yandex/div/storage/DivDataRepository$Payload;", "remove", "Lcom/yandex/div/storage/DivDataRepositoryRemoveResult;", "predicate", "Lkotlin/Function1;", "Lcom/yandex/div/storage/RawDataAndMetadata;", "", "ActionOnError", "DivDataWithMeta", "Payload", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivDataRepository {

    /* JADX INFO: compiled from: DivDataRepository.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "", "(Ljava/lang/String;I)V", "ABORT_TRANSACTION", "SKIP_ELEMENT", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ActionOnError {
        ABORT_TRANSACTION,
        SKIP_ELEMENT
    }

    DivDataRepositoryResult get(List<String> ids);

    DivDataRepositoryResult getAll();

    DivDataRepositoryResult put(Payload payload);

    DivDataRepositoryRemoveResult remove(Function1<? super RawDataAndMetadata, Boolean> predicate);

    /* JADX INFO: compiled from: DivDataRepository.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/storage/DivDataRepository$DivDataWithMeta;", "", "id", "", "divData", "Lcom/yandex/div2/DivData;", "metadata", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lcom/yandex/div2/DivData;Lorg/json/JSONObject;)V", "getDivData", "()Lcom/yandex/div2/DivData;", "getId", "()Ljava/lang/String;", "getMetadata", "()Lorg/json/JSONObject;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DivDataWithMeta {
        private final DivData divData;
        private final String id;
        private final JSONObject metadata;

        public DivDataWithMeta(String id, DivData divData, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(divData, "divData");
            this.id = id;
            this.divData = divData;
            this.metadata = jSONObject;
        }

        public final String getId() {
            return this.id;
        }

        public final DivData getDivData() {
            return this.divData;
        }

        public final JSONObject getMetadata() {
            return this.metadata;
        }
    }

    /* JADX INFO: compiled from: DivDataRepository.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/yandex/div/storage/DivDataRepository$Payload;", "", "divs", "", "Lcom/yandex/div/storage/RawDataAndMetadata;", "templates", "", "", "Lorg/json/JSONObject;", "sourceType", "actionOnError", "Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Lcom/yandex/div/storage/DivDataRepository$ActionOnError;)V", "getActionOnError", "()Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "getDivs", "()Ljava/util/List;", "getSourceType", "()Ljava/lang/String;", "getTemplates", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Payload {
        private final ActionOnError actionOnError;
        private final List<RawDataAndMetadata> divs;
        private final String sourceType;
        private final Map<String, JSONObject> templates;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Payload copy$default(Payload payload, List list, Map map, String str, ActionOnError actionOnError, int i, Object obj) {
            if ((i & 1) != 0) {
                list = payload.divs;
            }
            if ((i & 2) != 0) {
                map = payload.templates;
            }
            if ((i & 4) != 0) {
                str = payload.sourceType;
            }
            if ((i & 8) != 0) {
                actionOnError = payload.actionOnError;
            }
            return payload.copy(list, map, str, actionOnError);
        }

        public final List<RawDataAndMetadata> component1() {
            return this.divs;
        }

        public final Map<String, JSONObject> component2() {
            return this.templates;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSourceType() {
            return this.sourceType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ActionOnError getActionOnError() {
            return this.actionOnError;
        }

        public final Payload copy(List<? extends RawDataAndMetadata> divs, Map<String, ? extends JSONObject> templates, String sourceType, ActionOnError actionOnError) {
            Intrinsics.checkNotNullParameter(divs, "divs");
            Intrinsics.checkNotNullParameter(templates, "templates");
            Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
            return new Payload(divs, templates, sourceType, actionOnError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Payload)) {
                return false;
            }
            Payload payload = (Payload) other;
            return Intrinsics.areEqual(this.divs, payload.divs) && Intrinsics.areEqual(this.templates, payload.templates) && Intrinsics.areEqual(this.sourceType, payload.sourceType) && this.actionOnError == payload.actionOnError;
        }

        public int hashCode() {
            int iHashCode = ((this.divs.hashCode() * 31) + this.templates.hashCode()) * 31;
            String str = this.sourceType;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.actionOnError.hashCode();
        }

        public String toString() {
            return "Payload(divs=" + this.divs + ", templates=" + this.templates + ", sourceType=" + this.sourceType + ", actionOnError=" + this.actionOnError + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Payload(List<? extends RawDataAndMetadata> divs, Map<String, ? extends JSONObject> templates, String str, ActionOnError actionOnError) {
            Intrinsics.checkNotNullParameter(divs, "divs");
            Intrinsics.checkNotNullParameter(templates, "templates");
            Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
            this.divs = divs;
            this.templates = templates;
            this.sourceType = str;
            this.actionOnError = actionOnError;
        }

        public final List<RawDataAndMetadata> getDivs() {
            return this.divs;
        }

        public /* synthetic */ Payload(List list, Map map, String str, ActionOnError actionOnError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? null : str, (i & 8) != 0 ? ActionOnError.ABORT_TRANSACTION : actionOnError);
        }

        public final Map<String, JSONObject> getTemplates() {
            return this.templates;
        }

        public final String getSourceType() {
            return this.sourceType;
        }

        public final ActionOnError getActionOnError() {
            return this.actionOnError;
        }
    }
}
