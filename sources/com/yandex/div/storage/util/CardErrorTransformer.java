package com.yandex.div.storage.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CardErrorTransformer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/util/CardErrorTransformer;", "", "tryTransformAndLog", "", "cardError", "Lcom/yandex/div/storage/util/CardErrorTransformer$CardDetailedErrorException;", "CardDetailedErrorException", "Composite", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CardErrorTransformer {
    boolean tryTransformAndLog(CardDetailedErrorException cardError);

    /* JADX INFO: compiled from: CardErrorTransformer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/storage/util/CardErrorTransformer$CardDetailedErrorException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cardId", "", "message", "cause", "", "templateId", "details", "", "groupId", "metadata", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lorg/json/JSONObject;)V", "getCardId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/Map;", "getGroupId$div_storage_release", "getMetadata", "()Lorg/json/JSONObject;", "getTemplateId", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CardDetailedErrorException extends Exception {
        private final String cardId;
        private final Map<String, String> details;
        private final String groupId;
        private final JSONObject metadata;
        private final String templateId;

        public final String getCardId() {
            return this.cardId;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public /* synthetic */ CardDetailedErrorException(String str, String str2, Throwable th, String str3, Map map, String str4, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : th, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? MapsKt.emptyMap() : map, str4, jSONObject);
        }

        public final Map<String, String> getDetails() {
            return this.details;
        }

        /* JADX INFO: renamed from: getGroupId$div_storage_release, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        public final JSONObject getMetadata() {
            return this.metadata;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardDetailedErrorException(String cardId, String str, Throwable th, String str2, Map<String, String> details, String groupId, JSONObject jSONObject) {
            super(str, th);
            Intrinsics.checkNotNullParameter(cardId, "cardId");
            Intrinsics.checkNotNullParameter(details, "details");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            this.cardId = cardId;
            this.templateId = str2;
            this.details = details;
            this.groupId = groupId;
            this.metadata = jSONObject;
        }
    }

    /* JADX INFO: compiled from: CardErrorTransformer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/yandex/div/storage/util/CardErrorTransformer$Composite;", "Lcom/yandex/div/storage/util/CardErrorTransformer;", "transformers", "", "([Lcom/yandex/div/storage/util/CardErrorTransformer;)V", "[Lcom/yandex/div/storage/util/CardErrorTransformer;", "tryTransformAndLog", "", "cardError", "Lcom/yandex/div/storage/util/CardErrorTransformer$CardDetailedErrorException;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Composite implements CardErrorTransformer {
        private final CardErrorTransformer[] transformers;

        public Composite(CardErrorTransformer... transformers) {
            Intrinsics.checkNotNullParameter(transformers, "transformers");
            this.transformers = transformers;
        }

        @Override // com.yandex.div.storage.util.CardErrorTransformer
        public boolean tryTransformAndLog(CardDetailedErrorException cardError) {
            Intrinsics.checkNotNullParameter(cardError, "cardError");
            for (CardErrorTransformer cardErrorTransformer : this.transformers) {
                if (cardErrorTransformer.tryTransformAndLog(cardError)) {
                    return true;
                }
            }
            return false;
        }
    }
}
