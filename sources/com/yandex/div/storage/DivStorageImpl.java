package com.yandex.div.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteStatement;
import com.facebook.appevents.UserDataStore;
import com.safedk.android.analytics.reporters.b;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.storage.database.DatabaseOpenHelper;
import com.yandex.div.storage.database.DatabaseOpenHelperProvider;
import com.yandex.div.storage.database.ExecutionResult;
import com.yandex.div.storage.database.Migration;
import com.yandex.div.storage.database.ReadState;
import com.yandex.div.storage.database.SingleTransactionDataSavePerformer;
import com.yandex.div.storage.database.StorageException;
import com.yandex.div.storage.database.StorageQueries;
import com.yandex.div.storage.database.StorageSchema;
import com.yandex.div.storage.database.StorageStatementExecutor;
import com.yandex.div.storage.database.StorageStatements;
import com.yandex.div.storage.rawjson.RawJson;
import com.yandex.div.storage.templates.RawTemplateData;
import com.yandex.div.storage.templates.Template;
import com.yandex.div.storage.util.SqlExtensionsKt;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivStorageImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000 h2\u00020\u0001:\u0003hijB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 H\u0013J\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020$0#H\u0013J\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020$0#H\u0013J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0017J+\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00072\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070/\"\u00020\u0007H\u0013¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0017J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u0007H\u0016J*\u00107\u001a\b\u0012\u0004\u0012\u000209082\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0017J\u0010\u0010<\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0017J \u0010=\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0011H\u0017J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001e082\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 H\u0017J!\u0010A\u001a\u00020B2\u0017\u0010C\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020D0#¢\u0006\u0002\bEH\u0013J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020G08H\u0016J\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020I082\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070 H\u0017J\u001c\u0010K\u001a\u00020L2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020$0#H\u0017J\n\u0010M\u001a\u0004\u0018\u00010,H\u0017J\n\u0010N\u001a\u0004\u0018\u00010,H\u0017J\u001c\u0010O\u001a\u00020L2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020$0#H\u0017J4\u0010P\u001a\u00020Q2\u0006\u00104\u001a\u00020\u00072\f\u0010R\u001a\b\u0012\u0004\u0012\u00020&0\u001d2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u001d2\u0006\u0010U\u001a\u00020VH\u0017J\u001e\u0010W\u001a\u00020Q2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010U\u001a\u00020VH\u0017J\u001c\u0010Y\u001a\u0004\u0018\u000109*\u00020D2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0012J\u0012\u0010]\u001a\b\u0012\u0004\u0012\u00020G0\u001d*\u00020DH\u0012J\u0012\u0010^\u001a\b\u0012\u0004\u0012\u00020I0\u001d*\u00020DH\u0012J\u0014\u0010_\u001a\u00020\u0011*\u00020D2\u0006\u0010`\u001a\u00020\u0007H\u0012J\f\u0010a\u001a\u00020b*\u00020cH\u0012J$\u0010d\u001a\u00020,*\u00060ej\u0002`f2\u0006\u0010-\u001a\u00020\u00072\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0007H\u0012R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0092\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u00178\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006k"}, d2 = {"Lcom/yandex/div/storage/DivStorageImpl;", "Lcom/yandex/div/storage/DivStorage;", "context", "Landroid/content/Context;", "openHelperProvider", "Lcom/yandex/div/storage/database/DatabaseOpenHelperProvider;", "databaseNamePrefix", "", "(Landroid/content/Context;Lcom/yandex/div/storage/database/DatabaseOpenHelperProvider;Ljava/lang/String;)V", "dataSaveUseCase", "Lcom/yandex/div/storage/database/SingleTransactionDataSavePerformer;", "dbName", "defaultDropAllMigration", "Lcom/yandex/div/storage/database/Migration;", "migrations", "", "Lkotlin/Pair;", "", "getMigrations", "()Ljava/util/Map;", "openHelper", "Lcom/yandex/div/storage/database/DatabaseOpenHelper;", "statementExecutor", "Lcom/yandex/div/storage/database/StorageStatementExecutor;", "getStatementExecutor$annotations", "()V", "getStatementExecutor", "()Lcom/yandex/div/storage/database/StorageStatementExecutor;", "collectsRawJsons", "", "Lcom/yandex/div/storage/rawjson/RawJson;", "rawJsonIds", "", "collectsRawJsonsIdsFor", "predicate", "Lkotlin/Function1;", "", "collectsRecordsFor", "Lcom/yandex/div/storage/RawDataAndMetadata;", "createTables", "", UserDataStore.DATE_OF_BIRTH, "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "deleteTablesTransaction", "Lcom/yandex/div/storage/DivStorageErrorException;", "actionDesc", "queries", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/yandex/div/storage/DivStorageErrorException;", "dropTables", "isCardExists", "id", "groupId", "isTemplateExists", "templateHash", "loadData", "Lcom/yandex/div/storage/DivStorage$LoadDataResult;", "Lcom/yandex/div/storage/DivStorage$RestoredRawData;", "ids", "idsToExclude", "onCreate", "onUpgrade", "oldVersion", "newVersion", "readRawJsons", "readStateFor", "Lcom/yandex/div/storage/database/ReadState;", "func", "Landroid/database/Cursor;", "Lkotlin/ExtensionFunctionType;", "readTemplateReferences", "Lcom/yandex/div/storage/DivStorage$TemplateReference;", "readTemplates", "Lcom/yandex/div/storage/templates/RawTemplateData;", "templateHashes", "remove", "Lcom/yandex/div/storage/DivStorage$RemoveResult;", "removeAllCards", "removeAllTemplates", "removeRawJsons", "saveData", "Lcom/yandex/div/storage/database/ExecutionResult;", "divs", "templatesByHash", "Lcom/yandex/div/storage/templates/Template;", "actionOnError", "Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "saveRawJsons", "rawJsons", "getRestoredRawData", b.f8128a, "", "Lcom/yandex/div/storage/database/StorageException;", "getTemplateReferences", "getTemplates", "indexOf", "columnName", "toJSONObject", "Lorg/json/JSONObject;", "", "toStorageException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cardId", "Companion", "CursorDrivenRawDataAndMetadata", "CursorDrivenRawJson", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivStorageImpl implements DivStorage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SingleTransactionDataSavePerformer dataSaveUseCase;
    private final String dbName;
    private final Migration defaultDropAllMigration;
    private final Map<Pair<Integer, Integer>, Migration> migrations;
    private final DatabaseOpenHelper openHelper;
    private final StorageStatementExecutor statementExecutor;

    public static /* synthetic */ void getStatementExecutor$annotations() {
    }

    public DivStorageImpl(Context context, DatabaseOpenHelperProvider openHelperProvider, String databaseNamePrefix) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(openHelperProvider, "openHelperProvider");
        Intrinsics.checkNotNullParameter(databaseNamePrefix, "databaseNamePrefix");
        String str = databaseNamePrefix.length() == 0 ? "div-storage.db" : databaseNamePrefix + "-div-storage.db";
        this.dbName = str;
        this.openHelper = openHelperProvider.provide(context, str, 3, new DivStorageImpl$openHelper$1(this), new DivStorageImpl$openHelper$2(this));
        this.statementExecutor = new StorageStatementExecutor(new Function0<DatabaseOpenHelper.Database>() { // from class: com.yandex.div.storage.DivStorageImpl$statementExecutor$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DatabaseOpenHelper.Database invoke() {
                return this.this$0.openHelper.getWritableDatabase();
            }
        });
        this.dataSaveUseCase = new SingleTransactionDataSavePerformer(getStatementExecutor());
        this.migrations = MapsKt.mapOf(TuplesKt.to(TuplesKt.to(2, 3), new Migration() { // from class: com.yandex.div.storage.DivStorageImpl$$ExternalSyntheticLambda1
            @Override // com.yandex.div.storage.database.Migration
            public final void migrate(DatabaseOpenHelper.Database database) {
                DivStorageImpl.migrations$lambda$0(database);
            }
        }));
        this.defaultDropAllMigration = new Migration() { // from class: com.yandex.div.storage.DivStorageImpl$$ExternalSyntheticLambda2
            @Override // com.yandex.div.storage.database.Migration
            public final void migrate(DatabaseOpenHelper.Database database) {
                DivStorageImpl.defaultDropAllMigration$lambda$1(this.f$0, database);
            }
        };
    }

    public /* synthetic */ DivStorageImpl(Context context, DatabaseOpenHelperProvider databaseOpenHelperProvider, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, databaseOpenHelperProvider, (i & 4) != 0 ? "" : str);
    }

    public StorageStatementExecutor getStatementExecutor() {
        return this.statementExecutor;
    }

    @Override // com.yandex.div.storage.DivStorage
    public Map<Pair<Integer, Integer>, Migration> getMigrations() {
        return this.migrations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void migrations$lambda$0(DatabaseOpenHelper.Database db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            db.execSQL(StorageSchema.CREATE_TABLE_RAW_JSON);
        } catch (SQLException e) {
            throw new SQLException("Create \"raw_json\" table", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void defaultDropAllMigration$lambda$1(DivStorageImpl this$0, DatabaseOpenHelper.Database db) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(db, "db");
        this$0.dropTables(db);
        this$0.createTables(db);
    }

    public void onCreate(DatabaseOpenHelper.Database db) {
        Intrinsics.checkNotNullParameter(db, "db");
        createTables(db);
    }

    public void onUpgrade(DatabaseOpenHelper.Database db, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db, "db");
        KAssert kAssert = KAssert.INSTANCE;
        Integer numValueOf = Integer.valueOf(newVersion);
        if (Assert.isEnabled()) {
            Assert.assertEquals("", (Object) numValueOf, (Object) 3);
        }
        if (oldVersion == 3) {
            return;
        }
        Migration migration = getMigrations().get(TuplesKt.to(Integer.valueOf(oldVersion), Integer.valueOf(newVersion)));
        if (migration == null) {
            migration = this.defaultDropAllMigration;
        }
        try {
            migration.migrate(db);
        } catch (SQLException e) {
            KAssert kAssert2 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Migration from " + oldVersion + " to " + newVersion + " throws exception", e);
            }
            this.defaultDropAllMigration.migrate(db);
        }
    }

    public void createTables(DatabaseOpenHelper.Database db) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            db.execSQL(StorageSchema.CREATE_TABLE_CARDS);
            db.execSQL(StorageSchema.CREATE_TABLE_TEMPLATE_REFERENCES);
            db.execSQL(StorageSchema.CREATE_TABLE_TEMPLATES);
            db.execSQL(StorageSchema.CREATE_TABLE_RAW_JSON);
        } catch (SQLException e) {
            throw new SQLException("Create tables", e);
        }
    }

    public void dropTables(final DatabaseOpenHelper.Database db) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        new StorageStatementExecutor(new Function0<DatabaseOpenHelper.Database>() { // from class: com.yandex.div.storage.DivStorageImpl.dropTables.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DatabaseOpenHelper.Database invoke() {
                return db;
            }
        }).execute(StorageStatements.INSTANCE.dropAllTables());
    }

    @Override // com.yandex.div.storage.DivStorage
    public ExecutionResult saveData(String groupId, List<? extends RawDataAndMetadata> divs, List<Template> templatesByHash, DivDataRepository.ActionOnError actionOnError) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(divs, "divs");
        Intrinsics.checkNotNullParameter(templatesByHash, "templatesByHash");
        Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
        return this.dataSaveUseCase.saveDivData(groupId, divs, templatesByHash, actionOnError);
    }

    @Override // com.yandex.div.storage.DivStorage
    public ExecutionResult saveRawJsons(List<? extends RawJson> rawJsons, DivDataRepository.ActionOnError actionOnError) {
        Intrinsics.checkNotNullParameter(rawJsons, "rawJsons");
        Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
        return this.dataSaveUseCase.saveRawJsons(rawJsons, actionOnError);
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorage.LoadDataResult<DivStorage.RestoredRawData> loadData(List<String> ids, List<String> idsToExclude) throws IOException {
        final String string;
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(idsToExclude, "idsToExclude");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList(ids.size());
        ArrayList arrayList2 = new ArrayList();
        if (ids.isEmpty() && idsToExclude.isEmpty()) {
            string = null;
        } else if (!ids.isEmpty()) {
            if (!idsToExclude.isEmpty()) {
                StringBuilder sb = new StringBuilder("layout_id NOT IN ");
                Companion companion = INSTANCE;
                string = sb.append(companion.asSqlList(idsToExclude)).append(" AND layout_id IN ").append(companion.asSqlList(ids)).toString();
            } else {
                string = "layout_id IN " + INSTANCE.asSqlList(ids);
            }
        } else {
            string = "layout_id NOT IN " + INSTANCE.asSqlList(idsToExclude);
        }
        try {
            ReadState stateFor = readStateFor(new Function1<DatabaseOpenHelper.Database, Cursor>() { // from class: com.yandex.div.storage.DivStorageImpl$loadData$cardsReadState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Cursor invoke(DatabaseOpenHelper.Database readStateFor) {
                    Intrinsics.checkNotNullParameter(readStateFor, "$this$readStateFor");
                    return readStateFor.query(StorageSchema.TABLE_CARDS, null, string, null, null, null, null, null);
                }
            });
            try {
                Cursor cursor = stateFor.getCursor();
                if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                    do {
                        DivStorage.RestoredRawData restoredRawData = getRestoredRawData(cursor, arrayList2);
                        if (restoredRawData != null) {
                            arrayList.add(restoredRawData);
                            linkedHashSet.add(restoredRawData.getGroupId$div_storage_release());
                        }
                    } while (cursor.moveToNext());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(stateFor, null);
                    return new DivStorage.LoadDataResult<>(arrayList, arrayList2);
                }
                DivStorage.LoadDataResult<DivStorage.RestoredRawData> loadDataResult = new DivStorage.LoadDataResult<>(CollectionsKt.emptyList(), arrayList2);
                CloseableKt.closeFinally(stateFor, null);
                return loadDataResult;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(stateFor, th);
                    throw th2;
                }
            }
        } catch (SQLiteDatabaseLockedException e) {
            arrayList2.add(toStorageException$default(this, e, "Exception on load data from storage", null, 2, null));
        } catch (IllegalStateException e2) {
            arrayList2.add(toStorageException$default(this, e2, "Exception on load data from storage", null, 2, null));
        }
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorage.RemoveResult remove(Function1<? super RawDataAndMetadata, Boolean> predicate) throws SQLException {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Set<String> setCollectsRecordsFor = collectsRecordsFor(predicate);
        return new DivStorage.RemoveResult(setCollectsRecordsFor, getStatementExecutor().execute(DivDataRepository.ActionOnError.SKIP_ELEMENT, StorageStatements.INSTANCE.deleteCardsAndTemplates(setCollectsRecordsFor), StorageStatements.INSTANCE.deleteTemplatesWithoutLinksToCards()).getErrors());
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorageErrorException removeAllCards() {
        return deleteTablesTransaction("delete all cards", StorageQueries.DELETE_CARDS);
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorage.LoadDataResult<RawJson> readRawJsons(Set<String> rawJsonIds) throws IOException {
        Intrinsics.checkNotNullParameter(rawJsonIds, "rawJsonIds");
        String str = "Read raw jsons with ids: " + rawJsonIds;
        ArrayList arrayList = new ArrayList();
        List<RawJson> listEmptyList = CollectionsKt.emptyList();
        try {
            listEmptyList = collectsRawJsons(rawJsonIds);
        } catch (SQLiteDatabaseLockedException e) {
            arrayList.add(toStorageException$default(this, e, str, null, 2, null));
        } catch (SQLException e2) {
            arrayList.add(toStorageException$default(this, e2, str, null, 2, null));
        } catch (IllegalStateException e3) {
            arrayList.add(toStorageException$default(this, e3, str, null, 2, null));
        }
        return new DivStorage.LoadDataResult<>(listEmptyList, arrayList);
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorage.RemoveResult removeRawJsons(Function1<? super RawJson, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Set<String> setCollectsRawJsonsIdsFor = collectsRawJsonsIdsFor(predicate);
        return new DivStorage.RemoveResult(setCollectsRawJsonsIdsFor, getStatementExecutor().execute(DivDataRepository.ActionOnError.SKIP_ELEMENT, StorageStatements.INSTANCE.deleteRawJsons(setCollectsRawJsonsIdsFor)).getErrors());
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorage.LoadDataResult<RawTemplateData> readTemplates(final Set<String> templateHashes) throws IOException {
        Intrinsics.checkNotNullParameter(templateHashes, "templateHashes");
        String str = "Read templates with hashes: " + templateHashes;
        ArrayList arrayList = new ArrayList();
        List<RawTemplateData> listEmptyList = CollectionsKt.emptyList();
        try {
            ReadState stateFor = readStateFor(new Function1<DatabaseOpenHelper.Database, Cursor>() { // from class: com.yandex.div.storage.DivStorageImpl$readTemplates$readState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Cursor invoke(DatabaseOpenHelper.Database readStateFor) {
                    Intrinsics.checkNotNullParameter(readStateFor, "$this$readStateFor");
                    return readStateFor.rawQuery("\n    SELECT t.template_hash, t.template_data\n    FROM templates AS t\n    WHERE t.template_hash in\n  " + DivStorageImpl.INSTANCE.asSqlList(templateHashes), new String[0]);
                }
            });
            try {
                List<RawTemplateData> templates = getTemplates(stateFor.getCursor());
                CloseableKt.closeFinally(stateFor, null);
                listEmptyList = templates;
                return new DivStorage.LoadDataResult<>(listEmptyList, arrayList);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(stateFor, th);
                    throw th2;
                }
            }
        } catch (SQLiteDatabaseLockedException e) {
            arrayList.add(toStorageException$default(this, e, str, null, 2, null));
        } catch (SQLException e2) {
            arrayList.add(toStorageException$default(this, e2, str, null, 2, null));
        } catch (IllegalStateException e3) {
            arrayList.add(toStorageException$default(this, e3, str, null, 2, null));
        }
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorageErrorException removeAllTemplates() {
        return deleteTablesTransaction("Delete all templates", StorageQueries.DELETE_TEMPLATE_USAGES, "DELETE FROM templates");
    }

    @Override // com.yandex.div.storage.DivStorage
    public boolean isCardExists(String id, String groupId) throws DivStorageErrorException {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ExecutionResult executionResultExecute = getStatementExecutor().execute(StorageStatements.INSTANCE.isCardExists(id, groupId, new Function1<Boolean, Unit>() { // from class: com.yandex.div.storage.DivStorageImpl$isCardExists$executionResult$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                booleanRef.element = z;
            }
        }));
        if (!executionResultExecute.isSuccessful() && !executionResultExecute.getErrors().isEmpty()) {
            throw toStorageException((Exception) CollectionsKt.first((List) executionResultExecute.getErrors()), "Check card exists", id);
        }
        return booleanRef.element;
    }

    @Override // com.yandex.div.storage.DivStorage
    public boolean isTemplateExists(String templateHash) throws DivStorageErrorException {
        Intrinsics.checkNotNullParameter(templateHash, "templateHash");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ExecutionResult executionResultExecute = getStatementExecutor().execute(StorageStatements.INSTANCE.isTemplateExists(templateHash, new Function1<Boolean, Unit>() { // from class: com.yandex.div.storage.DivStorageImpl$isTemplateExists$executionResult$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                booleanRef.element = z;
            }
        }));
        if (!executionResultExecute.isSuccessful() && !executionResultExecute.getErrors().isEmpty()) {
            throw toStorageException$default(this, (Exception) CollectionsKt.first((List) executionResultExecute.getErrors()), "Check template " + templateHash + " exists", null, 2, null);
        }
        return booleanRef.element;
    }

    @Override // com.yandex.div.storage.DivStorage
    public DivStorage.LoadDataResult<DivStorage.TemplateReference> readTemplateReferences() throws IOException {
        DivStorage.LoadDataResult<DivStorage.TemplateReference> loadDataResult;
        try {
            ReadState stateFor = readStateFor(new Function1<DatabaseOpenHelper.Database, Cursor>() { // from class: com.yandex.div.storage.DivStorageImpl$readTemplateReferences$readState$1
                @Override // kotlin.jvm.functions.Function1
                public final Cursor invoke(DatabaseOpenHelper.Database readStateFor) {
                    Intrinsics.checkNotNullParameter(readStateFor, "$this$readStateFor");
                    return readStateFor.query(StorageSchema.TABLE_TEMPLATE_REFERENCES, null, null, null, null, null, null, null);
                }
            });
            try {
                List<DivStorage.TemplateReference> templateReferences = getTemplateReferences(stateFor.getCursor());
                CloseableKt.closeFinally(stateFor, null);
                return new DivStorage.LoadDataResult<>(templateReferences, null, 2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(stateFor, th);
                    throw th2;
                }
            }
        } catch (SQLiteDatabaseLockedException e) {
            loadDataResult = new DivStorage.LoadDataResult<>(CollectionsKt.emptyList(), CollectionsKt.listOf(toStorageException$default(this, e, "Template references", null, 2, null)));
            return loadDataResult;
        } catch (SQLException e2) {
            loadDataResult = new DivStorage.LoadDataResult<>(CollectionsKt.emptyList(), CollectionsKt.listOf(toStorageException$default(this, e2, "Template references", null, 2, null)));
            return loadDataResult;
        } catch (IllegalStateException e3) {
            loadDataResult = new DivStorage.LoadDataResult<>(CollectionsKt.emptyList(), CollectionsKt.listOf(toStorageException$default(this, e3, "Template references", null, 2, null)));
            return loadDataResult;
        }
    }

    private DivStorage.RestoredRawData getRestoredRawData(Cursor cursor, List<StorageException> list) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String id = cursor.getString(indexOf(cursor, StorageSchema.COLUMN_LAYOUT_ID));
        String groupId = cursor.getString(indexOf(cursor, "group_id"));
        int iIndexOf = indexOf(cursor, StorageSchema.COLUMN_CARD_DATA);
        byte[] blob = cursor.isNull(iIndexOf) ? null : cursor.getBlob(iIndexOf);
        int iIndexOf2 = indexOf(cursor, "metadata");
        byte[] blob2 = cursor.isNull(iIndexOf2) ? null : cursor.getBlob(iIndexOf2);
        if (blob == null) {
            list.add(new DivStorageErrorException("DivData is null for card with id " + id + '.', null, id, 2, null));
            return null;
        }
        try {
            jSONObject = toJSONObject(blob);
        } catch (JSONException e) {
            list.add(new DivStorageErrorException("DivData is invalid for card with id " + id, e, id));
            jSONObject = null;
        }
        if (blob2 != null) {
            try {
                jSONObject2 = toJSONObject(blob2);
            } catch (JSONException e2) {
                list.add(new DivStorageErrorException("Metadata is invalid for card with id " + id, e2, id));
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(id, "id");
        Intrinsics.checkNotNullExpressionValue(groupId, "groupId");
        return new DivStorage.RestoredRawData(id, jSONObject, jSONObject2, groupId);
    }

    private List<RawTemplateData> getTemplates(Cursor cursor) throws SQLException {
        if (cursor.getCount() == 0 || !cursor.moveToFirst()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(cursor.getCount());
        do {
            String string = cursor.getString(indexOf(cursor, StorageSchema.COLUMN_TEMPLATE_HASH));
            Intrinsics.checkNotNullExpressionValue(string, "getString(indexOf(COLUMN_TEMPLATE_HASH))");
            byte[] blob = cursor.getBlob(indexOf(cursor, "template_data"));
            Intrinsics.checkNotNullExpressionValue(blob, "getBlob(indexOf(COLUMN_TEMPLATE_DATA))");
            arrayList.add(new RawTemplateData(string, blob));
        } while (cursor.moveToNext());
        return arrayList;
    }

    private Set<String> collectsRecordsFor(final Function1<? super RawDataAndMetadata, Boolean> predicate) throws SQLException {
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        getStatementExecutor().execute(StorageStatements.INSTANCE.readData(new Function1<ReadState, Unit>() { // from class: com.yandex.div.storage.DivStorageImpl.collectsRecordsFor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReadState readState) {
                invoke2(readState);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReadState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Cursor cursor = it.getCursor();
                if (cursor.getCount() == 0 || !cursor.moveToFirst()) {
                    return;
                }
                do {
                    CursorDrivenRawDataAndMetadata cursorDrivenRawDataAndMetadata = new CursorDrivenRawDataAndMetadata(DivStorageImpl.this, cursor);
                    if (predicate.invoke(cursorDrivenRawDataAndMetadata).booleanValue()) {
                        linkedHashSet.add(cursorDrivenRawDataAndMetadata.getId());
                    }
                    cursorDrivenRawDataAndMetadata.close();
                } while (cursor.moveToNext());
            }
        }));
        return linkedHashSet;
    }

    private List<RawJson> collectsRawJsons(final Set<String> rawJsonIds) throws IOException, SQLException {
        ArrayList arrayList = new ArrayList(rawJsonIds.size());
        ReadState stateFor = readStateFor(new Function1<DatabaseOpenHelper.Database, Cursor>() { // from class: com.yandex.div.storage.DivStorageImpl.collectsRawJsons.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Cursor invoke(DatabaseOpenHelper.Database readStateFor) {
                Intrinsics.checkNotNullParameter(readStateFor, "$this$readStateFor");
                return readStateFor.rawQuery("\n    SELECT raw_json_id, raw_json_data\n    FROM raw_json\n    WHERE raw_json_id IN\n " + DivStorageImpl.INSTANCE.asSqlList(rawJsonIds), new String[0]);
            }
        });
        try {
            Cursor cursor = stateFor.getCursor();
            if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                do {
                    CursorDrivenRawJson cursorDrivenRawJson = new CursorDrivenRawJson(this, cursor);
                    arrayList.add(new RawJson.Ready(cursorDrivenRawJson.getId(), cursorDrivenRawJson.getData()));
                    cursorDrivenRawJson.close();
                } while (cursor.moveToNext());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(stateFor, null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(stateFor, th);
                throw th2;
            }
        }
    }

    private Set<String> collectsRawJsonsIdsFor(final Function1<? super RawJson, Boolean> predicate) throws SQLException {
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        getStatementExecutor().execute(StorageStatements.INSTANCE.readRawJsons(new Function1<ReadState, Unit>() { // from class: com.yandex.div.storage.DivStorageImpl.collectsRawJsonsIdsFor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReadState readState) {
                invoke2(readState);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReadState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Cursor cursor = it.getCursor();
                if (cursor.getCount() == 0 || !cursor.moveToFirst()) {
                    return;
                }
                do {
                    CursorDrivenRawJson cursorDrivenRawJson = new CursorDrivenRawJson(DivStorageImpl.this, cursor);
                    if (predicate.invoke(cursorDrivenRawJson).booleanValue()) {
                        linkedHashSet.add(cursorDrivenRawJson.getId());
                    }
                    cursorDrivenRawJson.close();
                } while (cursor.moveToNext());
            }
        }));
        return linkedHashSet;
    }

    private DivStorageErrorException deleteTablesTransaction(String actionDesc, String... queries) {
        DatabaseOpenHelper.Database writableDatabase = this.openHelper.getWritableDatabase();
        ArrayList arrayList = new ArrayList(queries.length);
        for (String str : queries) {
            arrayList.add(writableDatabase.compileStatement(str));
        }
        ArrayList arrayList2 = arrayList;
        try {
            writableDatabase.beginTransaction();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((SQLiteStatement) it.next()).executeUpdateDelete();
            }
            writableDatabase.setTransactionSuccessful();
            return null;
        } catch (SQLException e) {
            return toStorageException$default(this, e, actionDesc, null, 2, null);
        } finally {
            SqlExtensionsKt.endTransactionSilently(writableDatabase);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                SqlExtensionsKt.closeSilently((SQLiteStatement) it2.next());
            }
            SqlExtensionsKt.closeSilently(writableDatabase);
        }
    }

    private List<DivStorage.TemplateReference> getTemplateReferences(Cursor cursor) throws SQLException {
        if (cursor.getCount() == 0 || !cursor.moveToFirst()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(cursor.getCount());
        do {
            String string = cursor.getString(indexOf(cursor, "group_id"));
            String string2 = cursor.getString(indexOf(cursor, StorageSchema.COLUMN_TEMPLATE_HASH));
            String string3 = cursor.getString(indexOf(cursor, "template_id"));
            Intrinsics.checkNotNullExpressionValue(string, "getString(indexOf(COLUMN_GROUP_ID))");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(indexOf(COLUMN_TEMPLATE_ID))");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(indexOf(COLUMN_TEMPLATE_HASH))");
            arrayList.add(new DivStorage.TemplateReference(string, string3, string2));
        } while (cursor.moveToNext());
        return arrayList;
    }

    static /* synthetic */ DivStorageErrorException toStorageException$default(DivStorageImpl divStorageImpl, Exception exc, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toStorageException");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return divStorageImpl.toStorageException(exc, str, str2);
    }

    private DivStorageErrorException toStorageException(Exception exc, String str, String str2) {
        return new DivStorageErrorException("Unexpected exception on database access: " + str, exc, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivStorageImpl.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0015\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/storage/DivStorageImpl$CursorDrivenRawDataAndMetadata;", "Lcom/yandex/div/storage/RawDataAndMetadata;", "Ljava/io/Closeable;", "cursor", "Landroid/database/Cursor;", "(Lcom/yandex/div/storage/DivStorageImpl;Landroid/database/Cursor;)V", "getCursor", "()Landroid/database/Cursor;", "cursorInvalid", "", "divData", "Lorg/json/JSONObject;", "getDivData", "()Lorg/json/JSONObject;", "divData$delegate", "Lkotlin/Lazy;", "id", "", "getId", "()Ljava/lang/String;", "metadata", "getMetadata", "metadata$delegate", "close", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class CursorDrivenRawDataAndMetadata implements RawDataAndMetadata, Closeable {
        private final Cursor cursor;
        private boolean cursorInvalid;

        /* JADX INFO: renamed from: divData$delegate, reason: from kotlin metadata */
        private final Lazy divData;
        private final String id;

        /* JADX INFO: renamed from: metadata$delegate, reason: from kotlin metadata */
        private final Lazy metadata;
        final /* synthetic */ DivStorageImpl this$0;

        public CursorDrivenRawDataAndMetadata(final DivStorageImpl divStorageImpl, Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            this.this$0 = divStorageImpl;
            this.cursor = cursor;
            String string = cursor.getString(divStorageImpl.indexOf(cursor, StorageSchema.COLUMN_LAYOUT_ID));
            Intrinsics.checkNotNull(string);
            this.id = string;
            this.divData = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<JSONObject>() { // from class: com.yandex.div.storage.DivStorageImpl$CursorDrivenRawDataAndMetadata$divData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final JSONObject invoke() {
                    if (this.this$0.cursorInvalid) {
                        throw new IllegalStateException("Data no longer valid!");
                    }
                    DivStorageImpl divStorageImpl2 = divStorageImpl;
                    byte[] blob = this.this$0.getCursor().getBlob(divStorageImpl.indexOf(this.this$0.getCursor(), StorageSchema.COLUMN_CARD_DATA));
                    Intrinsics.checkNotNullExpressionValue(blob, "cursor.getBlob(cursor.indexOf(COLUMN_CARD_DATA))");
                    return divStorageImpl2.toJSONObject(blob);
                }
            });
            this.metadata = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<JSONObject>() { // from class: com.yandex.div.storage.DivStorageImpl$CursorDrivenRawDataAndMetadata$metadata$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final JSONObject invoke() {
                    if (this.this$0.cursorInvalid) {
                        throw new IllegalStateException("Data no longer valid!");
                    }
                    Cursor cursor2 = this.this$0.getCursor();
                    int iIndexOf = divStorageImpl.indexOf(this.this$0.getCursor(), "metadata");
                    byte[] blob = cursor2.isNull(iIndexOf) ? null : cursor2.getBlob(iIndexOf);
                    if (blob != null) {
                        return divStorageImpl.toJSONObject(blob);
                    }
                    return null;
                }
            });
        }

        public final Cursor getCursor() {
            return this.cursor;
        }

        @Override // com.yandex.div.storage.RawDataAndMetadata
        public String getId() {
            return this.id;
        }

        @Override // com.yandex.div.storage.RawDataAndMetadata
        public JSONObject getDivData() {
            return (JSONObject) this.divData.getValue();
        }

        @Override // com.yandex.div.storage.RawDataAndMetadata
        public JSONObject getMetadata() {
            return (JSONObject) this.metadata.getValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.cursorInvalid = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivStorageImpl.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/storage/DivStorageImpl$CursorDrivenRawJson;", "Lcom/yandex/div/storage/rawjson/RawJson;", "Ljava/io/Closeable;", "cursor", "Landroid/database/Cursor;", "(Lcom/yandex/div/storage/DivStorageImpl;Landroid/database/Cursor;)V", "getCursor", "()Landroid/database/Cursor;", "cursorInvalid", "", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "data$delegate", "Lkotlin/Lazy;", "id", "", "getId", "()Ljava/lang/String;", "close", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class CursorDrivenRawJson implements RawJson, Closeable {
        private final Cursor cursor;
        private boolean cursorInvalid;

        /* JADX INFO: renamed from: data$delegate, reason: from kotlin metadata */
        private final Lazy data;
        private final String id;
        final /* synthetic */ DivStorageImpl this$0;

        public CursorDrivenRawJson(final DivStorageImpl divStorageImpl, Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            this.this$0 = divStorageImpl;
            this.cursor = cursor;
            String string = cursor.getString(divStorageImpl.indexOf(cursor, StorageSchema.COLUMN_RAW_JSON_ID));
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.…exOf(COLUMN_RAW_JSON_ID))");
            this.id = string;
            this.data = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<JSONObject>() { // from class: com.yandex.div.storage.DivStorageImpl$CursorDrivenRawJson$data$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final JSONObject invoke() {
                    if (this.this$0.cursorInvalid) {
                        throw new IllegalStateException("Data no longer valid!");
                    }
                    DivStorageImpl divStorageImpl2 = divStorageImpl;
                    byte[] blob = this.this$0.getCursor().getBlob(divStorageImpl.indexOf(this.this$0.getCursor(), StorageSchema.COLUMN_RAW_JSON_DATA));
                    Intrinsics.checkNotNullExpressionValue(blob, "cursor.getBlob(cursor.in…Of(COLUMN_RAW_JSON_DATA))");
                    return divStorageImpl2.toJSONObject(blob);
                }
            });
        }

        public final Cursor getCursor() {
            return this.cursor;
        }

        @Override // com.yandex.div.storage.rawjson.RawJson
        public String getId() {
            return this.id;
        }

        @Override // com.yandex.div.storage.rawjson.RawJson
        public JSONObject getData() {
            return (JSONObject) this.data.getValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.cursorInvalid = true;
        }
    }

    private ReadState readStateFor(final Function1<? super DatabaseOpenHelper.Database, ? extends Cursor> func) {
        final DatabaseOpenHelper.Database readableDatabase = this.openHelper.getReadableDatabase();
        return new ReadState(new Function0<Unit>() { // from class: com.yandex.div.storage.DivStorageImpl.readStateFor.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SqlExtensionsKt.closeSilently(readableDatabase);
            }
        }, new Provider() { // from class: com.yandex.div.storage.DivStorageImpl$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider
            public final Object get() {
                return DivStorageImpl.readStateFor$lambda$12(readableDatabase, func);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor readStateFor$lambda$12(DatabaseOpenHelper.Database db, Function1 func) {
        Intrinsics.checkNotNullParameter(db, "$db");
        Intrinsics.checkNotNullParameter(func, "$func");
        return (Cursor) func.invoke(db);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalStateException("Column '" + str + "' not found in cursor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject toJSONObject(byte[] bArr) {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new JSONObject(new String(bArr, UTF_8));
    }

    /* JADX INFO: compiled from: DivStorageImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/storage/DivStorageImpl$Companion;", "", "()V", "asSqlList", "", "T", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> String asSqlList(Collection<? extends T> collection) {
            return CollectionsKt.joinToString$default(collection, "', '", "('", "')", 0, null, null, 56, null);
        }
    }
}
