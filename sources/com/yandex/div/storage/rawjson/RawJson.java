package com.yandex.div.storage.rawjson;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: RawJson.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/rawjson/RawJson;", "", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "id", "", "getId", "()Ljava/lang/String;", "Companion", "Ready", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface RawJson {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    JSONObject getData();

    String getId();

    /* JADX INFO: compiled from: RawJson.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/storage/rawjson/RawJson$Ready;", "Lcom/yandex/div/storage/rawjson/RawJson;", "id", "", "data", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Ready implements RawJson {
        private final JSONObject data;
        private final String id;

        public static /* synthetic */ Ready copy$default(Ready ready, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ready.id;
            }
            if ((i & 2) != 0) {
                jSONObject = ready.data;
            }
            return ready.copy(str, jSONObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JSONObject getData() {
            return this.data;
        }

        public final Ready copy(String id, JSONObject data) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(data, "data");
            return new Ready(id, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            Ready ready = (Ready) other;
            return Intrinsics.areEqual(this.id, ready.id) && Intrinsics.areEqual(this.data, ready.data);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "Ready(id=" + this.id + ", data=" + this.data + ')';
        }

        public Ready(String id, JSONObject data) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(data, "data");
            this.id = id;
            this.data = data;
        }

        @Override // com.yandex.div.storage.rawjson.RawJson
        public String getId() {
            return this.id;
        }

        @Override // com.yandex.div.storage.rawjson.RawJson
        public JSONObject getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: RawJson.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002¨\u0006\t"}, d2 = {"Lcom/yandex/div/storage/rawjson/RawJson$Companion;", "", "()V", "invoke", "Lcom/yandex/div/storage/rawjson/RawJson;", "id", "", "data", "Lorg/json/JSONObject;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final RawJson invoke(String id, JSONObject data) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(data, "data");
            return new Ready(id, data);
        }
    }
}
