package com.yandex.div.storage.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.yandex.div.storage.RawDataAndMetadata;
import com.yandex.div.storage.rawjson.RawJson;
import com.yandex.div.storage.templates.Template;
import com.yandex.div.storage.util.SqlExtensionsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: StorageStatements.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J9\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fJ1\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fJ)\u0010\u0017\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00140\u000fJ)\u0010\u001b\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00140\u000fJ8\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u001a\b\u0002\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001e\u0012\u0004\u0012\u00020\u00140\u000fJ0\u0010!\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001e2\u001a\b\u0002\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001e\u0012\u0004\u0012\u00020\u00140\u000fJ\u0014\u0010$\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001eJ\u001c\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001eJ\u0018\u0010(\u001a\u00020\u0007\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0*H\u0002¨\u0006+"}, d2 = {"Lcom/yandex/div/storage/database/StorageStatements;", "", "()V", "deleteCardsAndTemplates", "Lcom/yandex/div/storage/database/StorageStatement;", "elementIds", "", "", "deleteRawJsons", "deleteTemplatesWithoutLinksToCards", "dropAllTables", "isCardExists", "cardId", "groupId", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "exists", "", "isTemplateExists", "templateHash", "readData", "reader", "Lcom/yandex/div/storage/database/ReadState;", "r", "readRawJsons", "replaceCards", StorageSchema.TABLE_CARDS, "", "Lcom/yandex/div/storage/RawDataAndMetadata;", "onFailedTransactions", "replaceRawJsons", "rawJsons", "Lcom/yandex/div/storage/rawjson/RawJson;", "writeTemplates", "templates", "Lcom/yandex/div/storage/templates/Template;", "writeTemplatesUsages", "asSqlList", "T", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StorageStatements {
    public static final StorageStatements INSTANCE = new StorageStatements();

    private StorageStatements() {
    }

    public final StorageStatement writeTemplates(final List<Template> templates) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.writeTemplates.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                SQLiteStatement sQLiteStatementCompileStatement = compiler.compileStatement(StorageQueries.INSERT_TEMPLATE);
                for (Template template : templates) {
                    sQLiteStatementCompileStatement.bindString(1, template.getHash());
                    String string = template.getTemplate().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "it.template.toString()");
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    sQLiteStatementCompileStatement.bindBlob(2, bytes);
                    sQLiteStatementCompileStatement.executeInsert();
                }
            }

            public String toString() {
                return "Write templates " + CollectionsKt.joinToString$default(templates, null, null, null, 0, null, new Function1<Template, CharSequence>() { // from class: com.yandex.div.storage.database.StorageStatements$writeTemplates$1$toString$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Template it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getId() + '/' + it.getHash();
                    }
                }, 31, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StorageStatement replaceRawJsons$default(StorageStatements storageStatements, List list, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<List<? extends String>, Unit>() { // from class: com.yandex.div.storage.database.StorageStatements.replaceRawJsons.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list2) {
                    invoke2((List<String>) list2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<String> failedTransactions) {
                    Intrinsics.checkNotNullParameter(failedTransactions, "failedTransactions");
                    throw new SQLException("Insertion failed for raw jsons with ids: " + CollectionsKt.joinToString$default(failedTransactions, null, null, null, 0, null, null, 63, null));
                }
            };
        }
        return storageStatements.replaceRawJsons(list, function1);
    }

    public final StorageStatement replaceRawJsons(List<? extends RawJson> rawJsons, Function1<? super List<String>, Unit> onFailedTransactions) {
        Intrinsics.checkNotNullParameter(rawJsons, "rawJsons");
        Intrinsics.checkNotNullParameter(onFailedTransactions, "onFailedTransactions");
        return new StorageStatement(rawJsons, onFailedTransactions) { // from class: com.yandex.div.storage.database.StorageStatements.replaceRawJsons.2
            final /* synthetic */ Function1<List<String>, Unit> $onFailedTransactions;
            final /* synthetic */ List<RawJson> $rawJsons;

            /* JADX INFO: renamed from: cardIdsString$delegate, reason: from kotlin metadata */
            private final Lazy cardIdsString;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$rawJsons = rawJsons;
                this.$onFailedTransactions = onFailedTransactions;
                this.cardIdsString = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<String>() { // from class: com.yandex.div.storage.database.StorageStatements$replaceRawJsons$2$cardIdsString$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(rawJsons, null, null, null, 0, null, new Function1<RawJson, CharSequence>() { // from class: com.yandex.div.storage.database.StorageStatements$replaceRawJsons$2$cardIdsString$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(RawJson it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return it.getId();
                            }
                        }, 31, null);
                    }
                });
            }

            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                ArrayList arrayList = new ArrayList();
                SQLiteStatement sQLiteStatementCompileStatement = compiler.compileStatement(StorageQueries.REPLACE_RAW_JSON);
                for (RawJson rawJson : this.$rawJsons) {
                    sQLiteStatementCompileStatement.bindString(1, rawJson.getId());
                    String string = rawJson.getData().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "json.data.toString()");
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    sQLiteStatementCompileStatement.bindBlob(2, bytes);
                    Long lValueOf = Long.valueOf(sQLiteStatementCompileStatement.executeInsert());
                    if (lValueOf.longValue() >= 0) {
                        lValueOf = null;
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        arrayList.add(rawJson.getId());
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                this.$onFailedTransactions.invoke(arrayList);
            }

            public String toString() {
                return "Replace raw jsons (" + getCardIdsString() + ')';
            }

            private final String getCardIdsString() {
                return (String) this.cardIdsString.getValue();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StorageStatement replaceCards$default(StorageStatements storageStatements, String str, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<List<? extends String>, Unit>() { // from class: com.yandex.div.storage.database.StorageStatements.replaceCards.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list2) {
                    invoke2((List<String>) list2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<String> failedTransactions) {
                    Intrinsics.checkNotNullParameter(failedTransactions, "failedTransactions");
                    throw new SQLException("Insertion failed for cards with ids: " + CollectionsKt.joinToString$default(failedTransactions, null, null, null, 0, null, null, 63, null));
                }
            };
        }
        return storageStatements.replaceCards(str, list, function1);
    }

    public final StorageStatement replaceCards(String groupId, List<? extends RawDataAndMetadata> cards, Function1<? super List<String>, Unit> onFailedTransactions) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(onFailedTransactions, "onFailedTransactions");
        return new StorageStatement(cards, onFailedTransactions, groupId) { // from class: com.yandex.div.storage.database.StorageStatements.replaceCards.2
            final /* synthetic */ List<RawDataAndMetadata> $cards;
            final /* synthetic */ String $groupId;
            final /* synthetic */ Function1<List<String>, Unit> $onFailedTransactions;

            /* JADX INFO: renamed from: cardIdsString$delegate, reason: from kotlin metadata */
            private final Lazy cardIdsString;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$cards = cards;
                this.$onFailedTransactions = onFailedTransactions;
                this.$groupId = groupId;
                this.cardIdsString = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<String>() { // from class: com.yandex.div.storage.database.StorageStatements$replaceCards$2$cardIdsString$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(cards, null, null, null, 0, null, new Function1<RawDataAndMetadata, CharSequence>() { // from class: com.yandex.div.storage.database.StorageStatements$replaceCards$2$cardIdsString$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(RawDataAndMetadata it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return it.getId();
                            }
                        }, 31, null);
                    }
                });
            }

            private final String getCardIdsString() {
                return (String) this.cardIdsString.getValue();
            }

            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                byte[] byteArrayCatching;
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                final ArrayList arrayList = new ArrayList();
                SQLiteStatement sQLiteStatementCompileStatement = compiler.compileStatement(StorageQueries.REPLACE_CARD);
                List<RawDataAndMetadata> list = this.$cards;
                String str = this.$groupId;
                for (RawDataAndMetadata rawDataAndMetadata : list) {
                    final String id = rawDataAndMetadata.getId();
                    Function1<Exception, Unit> function1 = new Function1<Exception, Unit>() { // from class: com.yandex.div.storage.database.StorageStatements$replaceCards$2$execute$1$errorHandler$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            arrayList.add(id);
                            e.printStackTrace();
                        }
                    };
                    byte[] byteArrayCatching2 = toByteArrayCatching(rawDataAndMetadata.getDivData(), function1);
                    if (byteArrayCatching2 != null) {
                        JSONObject metadata = rawDataAndMetadata.getMetadata();
                        if (metadata != null) {
                            byteArrayCatching = toByteArrayCatching(metadata, function1);
                            if (byteArrayCatching == null) {
                            }
                        } else {
                            byteArrayCatching = null;
                        }
                        sQLiteStatementCompileStatement.bindString(1, id);
                        SqlExtensionsKt.bindNullableBlob(sQLiteStatementCompileStatement, 2, byteArrayCatching2);
                        SqlExtensionsKt.bindNullableBlob(sQLiteStatementCompileStatement, 3, byteArrayCatching);
                        sQLiteStatementCompileStatement.bindString(4, str);
                        Long lValueOf = Long.valueOf(sQLiteStatementCompileStatement.executeInsert());
                        Long l = lValueOf.longValue() < 0 ? lValueOf : null;
                        if (l != null) {
                            l.longValue();
                            arrayList.add(id);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                this.$onFailedTransactions.invoke(arrayList);
            }

            public String toString() {
                return "Replace cards (" + getCardIdsString() + ")}";
            }

            private final byte[] toByteArrayCatching(JSONObject jSONObject, Function1<? super Exception, Unit> function1) {
                try {
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString()");
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    return bytes;
                } catch (ConcurrentModificationException e) {
                    function1.invoke(e);
                    return null;
                }
            }
        };
    }

    public final StorageStatement deleteTemplatesWithoutLinksToCards() {
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.deleteTemplatesWithoutLinksToCards.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                compiler.compileStatement(StorageQueries.DELETE_UNUSED_TEMPLATE_REFERENCES).executeUpdateDelete();
                compiler.compileStatement(StorageQueries.DELETE_UNUSED_TEMPLATES).executeUpdateDelete();
            }

            public String toString() {
                return "Deleting unused templates";
            }
        };
    }

    public final StorageStatement deleteCardsAndTemplates(final Set<String> elementIds) {
        Intrinsics.checkNotNullParameter(elementIds, "elementIds");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.deleteCardsAndTemplates.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                SQLiteStatement sQLiteStatementCompileStatement = compiler.compileStatement("DELETE FROM cards WHERE layout_id IN  " + StorageStatements.INSTANCE.asSqlList(elementIds));
                SQLiteStatement sQLiteStatementCompileStatement2 = compiler.compileStatement("\n    DELETE FROM template_references WHERE group_id IN\n " + StorageStatements.INSTANCE.asSqlList(elementIds));
                sQLiteStatementCompileStatement.executeUpdateDelete();
                sQLiteStatementCompileStatement2.executeUpdateDelete();
            }

            public String toString() {
                return "Deleting cards with ids: " + elementIds;
            }
        };
    }

    public final StorageStatement deleteRawJsons(final Set<String> elementIds) {
        Intrinsics.checkNotNullParameter(elementIds, "elementIds");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.deleteRawJsons.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                compiler.compileStatement("DELETE FROM raw_json WHERE raw_json_id IN " + StorageStatements.INSTANCE.asSqlList(elementIds)).executeUpdateDelete();
            }

            public String toString() {
                return "Deleting raw jsons with ids: " + elementIds;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> String asSqlList(Collection<? extends T> collection) {
        return CollectionsKt.joinToString$default(collection, "', '", "('", "')", 0, null, null, 56, null);
    }

    public final StorageStatement isTemplateExists(final String templateHash, final Function1<? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(templateHash, "templateHash");
        Intrinsics.checkNotNullParameter(result, "result");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.isTemplateExists.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) throws IOException {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                ReadState readStateCompileQuery = compiler.compileQuery("SELECT 1 FROM templates WHERE template_hash == '" + templateHash + "' ", new String[0]);
                try {
                    result.invoke(Boolean.valueOf(readStateCompileQuery.getCursor().getCount() > 0));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(readStateCompileQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(readStateCompileQuery, th);
                        throw th2;
                    }
                }
            }

            public String toString() {
                return "Check template '" + templateHash + "' exists in group";
            }
        };
    }

    public final StorageStatement isCardExists(final String cardId, final String groupId, final Function1<? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(result, "result");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.isCardExists.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) throws IOException {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                ReadState readStateCompileQuery = compiler.compileQuery("SELECT 1 FROM cards WHERE layout_id == '" + cardId + "' AND group_id == '" + groupId + '\'', new String[0]);
                try {
                    result.invoke(Boolean.valueOf(readStateCompileQuery.getCursor().getCount() > 0));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(readStateCompileQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(readStateCompileQuery, th);
                        throw th2;
                    }
                }
            }

            public String toString() {
                return "Check card '" + cardId + "' with group '" + groupId + "' exists";
            }
        };
    }

    public final StorageStatement readData(final Function1<? super ReadState, Unit> reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.readData.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) throws IOException {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                ReadState readStateCompileQuery = compiler.compileQuery("SELECT * FROM cards", new String[0]);
                try {
                    reader.invoke(readStateCompileQuery);
                    CloseableKt.closeFinally(readStateCompileQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(readStateCompileQuery, th);
                        throw th2;
                    }
                }
            }

            public String toString() {
                return "Selecting all div data";
            }
        };
    }

    public final StorageStatement readRawJsons(final Function1<? super ReadState, Unit> reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.readRawJsons.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) throws IOException {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                ReadState readStateCompileQuery = compiler.compileQuery("SELECT * FROM raw_json", new String[0]);
                try {
                    reader.invoke(readStateCompileQuery);
                    CloseableKt.closeFinally(readStateCompileQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(readStateCompileQuery, th);
                        throw th2;
                    }
                }
            }

            public String toString() {
                return "Selecting all raw jsons";
            }
        };
    }

    public final StorageStatement writeTemplatesUsages(final String groupId, final List<Template> templates) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(templates, "templates");
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.writeTemplatesUsages.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                SQLiteStatement sQLiteStatementCompileStatement = compiler.compileStatement(StorageQueries.INSERT_TEMPLATE_USAGE);
                List<Template> list = templates;
                String str = groupId;
                for (Template template : list) {
                    sQLiteStatementCompileStatement.bindString(1, str);
                    sQLiteStatementCompileStatement.bindString(2, template.getId());
                    sQLiteStatementCompileStatement.bindString(3, template.getHash());
                    sQLiteStatementCompileStatement.executeInsert();
                }
            }

            public String toString() {
                return "Write template usages for " + groupId;
            }
        };
    }

    public final StorageStatement dropAllTables() {
        return new StorageStatement() { // from class: com.yandex.div.storage.database.StorageStatements.dropAllTables.1
            @Override // com.yandex.div.storage.database.StorageStatement
            public void execute(SqlCompiler compiler) throws IOException {
                Intrinsics.checkNotNullParameter(compiler, "compiler");
                ArrayList arrayList = new ArrayList();
                ReadState readStateCompileQuery = compiler.compileQuery("SELECT name FROM sqlite_master WHERE type='table'", new String[0]);
                try {
                    Cursor cursor = readStateCompileQuery.getCursor();
                    if (!cursor.moveToFirst()) {
                        CloseableKt.closeFinally(readStateCompileQuery, null);
                        return;
                    }
                    do {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.…lumnIndexOrThrow(\"name\"))");
                        arrayList.add(string);
                    } while (cursor.moveToNext());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(readStateCompileQuery, null);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        compiler.compileStatement("DROP TABLE IF EXISTS " + ((String) it.next())).execute();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(readStateCompileQuery, th);
                        throw th2;
                    }
                }
            }

            public String toString() {
                return "Drop all database tables";
            }
        };
    }
}
