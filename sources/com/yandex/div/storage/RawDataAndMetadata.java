package com.yandex.div.storage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: RawDataAndMetadata.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u0000 \f2\u00020\u0001:\u0002\f\rR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/RawDataAndMetadata;", "", "divData", "Lorg/json/JSONObject;", "getDivData", "()Lorg/json/JSONObject;", "id", "", "getId", "()Ljava/lang/String;", "metadata", "getMetadata", "Companion", "Ready", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface RawDataAndMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    JSONObject getDivData();

    String getId();

    JSONObject getMetadata();

    /* JADX INFO: compiled from: RawDataAndMetadata.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/yandex/div/storage/RawDataAndMetadata$Ready;", "Lcom/yandex/div/storage/RawDataAndMetadata;", "id", "", "divData", "Lorg/json/JSONObject;", "metadata", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getDivData", "()Lorg/json/JSONObject;", "getId", "()Ljava/lang/String;", "getMetadata", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Ready implements RawDataAndMetadata {
        private final JSONObject divData;
        private final String id;
        private final JSONObject metadata;

        public Ready(String id, JSONObject divData, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(divData, "divData");
            this.id = id;
            this.divData = divData;
            this.metadata = jSONObject;
        }

        @Override // com.yandex.div.storage.RawDataAndMetadata
        public String getId() {
            return this.id;
        }

        @Override // com.yandex.div.storage.RawDataAndMetadata
        public JSONObject getDivData() {
            return this.divData;
        }

        @Override // com.yandex.div.storage.RawDataAndMetadata
        public JSONObject getMetadata() {
            return this.metadata;
        }
    }

    /* JADX INFO: compiled from: RawDataAndMetadata.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0086\u0002¨\u0006\n"}, d2 = {"Lcom/yandex/div/storage/RawDataAndMetadata$Companion;", "", "()V", "invoke", "Lcom/yandex/div/storage/RawDataAndMetadata;", "id", "", "divData", "Lorg/json/JSONObject;", "metadata", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ RawDataAndMetadata invoke$default(Companion companion, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
            if ((i & 4) != 0) {
                jSONObject2 = null;
            }
            return companion.invoke(str, jSONObject, jSONObject2);
        }

        public final RawDataAndMetadata invoke(String id, JSONObject divData, JSONObject metadata) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(divData, "divData");
            return new Ready(id, divData, metadata);
        }
    }
}
