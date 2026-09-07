package com.yandex.div.state.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.yandex.div.internal.Assert;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DivStateDaoImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\u00020\b*\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\n \u001c*\u0004\u0018\u00010\f0\f*\u00020\u001aH\u0002J\u0014\u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\f0\f*\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\u0004\u0018\u00010\f*\u00020\u001aH\u0002J\u001a\u0010\u001f\u001a\u00020\b*\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/state/db/DivStateDaoImpl;", "Lcom/yandex/div/state/db/DivStateDao;", "writableDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "upsertStatement", "Landroid/database/sqlite/SQLiteStatement;", "deleteAll", "", "deleteAllExcept", "cardIds", "", "", "deleteByCardId", "cardId", "deleteCardRootState", "deleteModifiedBefore", "timestamp", "", "getRootStateId", "getStates", "Lcom/yandex/div/state/db/PathToState;", "updateState", "state", "Lcom/yandex/div/state/db/DivStateEntity;", "applyAndClose", "Landroid/database/Cursor;", "getPath", "kotlin.jvm.PlatformType", "getStateId", "getStateIdOrNull", "inTransaction", "block", "Lkotlin/Function0;", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStateDaoImpl implements DivStateDao {
    private final SQLiteStatement upsertStatement;
    private final SQLiteDatabase writableDatabase;

    public DivStateDaoImpl(SQLiteDatabase writableDatabase) {
        Intrinsics.checkNotNullParameter(writableDatabase, "writableDatabase");
        this.writableDatabase = writableDatabase;
        if (writableDatabase.isReadOnly()) {
            Assert.fail(getClass().getName() + " require writable database!");
        }
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement(StateSchema.SQL_UPSERT_QUERY_TEMPLATE);
        Intrinsics.checkNotNullExpressionValue(sQLiteStatementCompileStatement, "writableDatabase.compile…QL_UPSERT_QUERY_TEMPLATE)");
        this.upsertStatement = sQLiteStatementCompileStatement;
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public List<PathToState> getStates(final String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        final ArrayList arrayList = new ArrayList();
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.getStates.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws IOException {
                Cursor cursor = DivStateDaoImpl.this.writableDatabase.rawQuery(StateSchema.SQL_GET_STATES_QUERY_TEMPLATE, new String[]{cardId});
                Cursor cursor2 = cursor;
                List<PathToState> list = arrayList;
                DivStateDaoImpl divStateDaoImpl = DivStateDaoImpl.this;
                try {
                    while (cursor.moveToNext()) {
                        Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
                        String path = divStateDaoImpl.getPath(cursor);
                        Intrinsics.checkNotNullExpressionValue(path, "cursor.getPath()");
                        String stateId = divStateDaoImpl.getStateId(cursor);
                        Intrinsics.checkNotNullExpressionValue(stateId, "cursor.getStateId()");
                        list.add(new PathToState(path, stateId));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor2, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor2, th);
                        throw th2;
                    }
                }
            }
        });
        return arrayList;
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public void updateState(final DivStateEntity state) {
        Intrinsics.checkNotNullParameter(state, "state");
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.updateState.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DivStateDaoImpl.this.upsertStatement.bindString(1, state.getCardId());
                DivStateDaoImpl.this.upsertStatement.bindString(2, state.getPath());
                DivStateDaoImpl.this.upsertStatement.bindString(3, state.getStateId());
                DivStateDaoImpl.this.upsertStatement.bindString(4, String.valueOf(state.getModificationTime()));
                DivStateDaoImpl.this.upsertStatement.execute();
                DivStateDaoImpl.this.upsertStatement.clearBindings();
            }
        });
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public void deleteAll() {
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.deleteAll.1
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
                DivStateDaoImpl.this.writableDatabase.rawQuery(StateSchema.SQL_DELETE_ALL_QUERY, new String[0]).close();
            }
        });
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public void deleteByCardId(final String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.deleteByCardId.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DivStateDaoImpl divStateDaoImpl = DivStateDaoImpl.this;
                Cursor cursorRawQuery = divStateDaoImpl.writableDatabase.rawQuery(StateSchema.SQL_DELETE_BY_CARD_ID_QUERY_TEMPLATE, new String[]{cardId});
                Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "writableDatabase.rawQuer…yOf(cardId)\n            )");
                divStateDaoImpl.applyAndClose(cursorRawQuery);
            }
        });
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public void deleteAllExcept(final List<String> cardIds) {
        Intrinsics.checkNotNullParameter(cardIds, "cardIds");
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.deleteAllExcept.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                int size = cardIds.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    strArr[i] = "?";
                }
                String strJoinToString$default = ArraysKt.joinToString$default(strArr, StringUtils.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                DivStateDaoImpl divStateDaoImpl = this;
                SQLiteDatabase sQLiteDatabase = divStateDaoImpl.writableDatabase;
                String str = String.format(StateSchema.SQL_DELETE_ALL_EXCEPT_CARD_ID_QUERY_TEMPLATE, Arrays.copyOf(new Object[]{strJoinToString$default}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, (String[]) cardIds.toArray(new String[0]));
                Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "writableDatabase.rawQuer…  cardIds.toTypedArray())");
                divStateDaoImpl.applyAndClose(cursorRawQuery);
            }
        });
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public void deleteModifiedBefore(final long timestamp) {
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.deleteModifiedBefore.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DivStateDaoImpl divStateDaoImpl = DivStateDaoImpl.this;
                Cursor cursorRawQuery = divStateDaoImpl.writableDatabase.rawQuery(StateSchema.SQL_DELETE_ALL_MODIFIED_BEFORE_QUERY_TEMPLATE, new String[]{String.valueOf(timestamp)});
                Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "writableDatabase.rawQuer…toString())\n            )");
                divStateDaoImpl.applyAndClose(cursorRawQuery);
            }
        });
    }

    @Override // com.yandex.div.state.db.DivStateDao
    public void deleteCardRootState(final String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.deleteCardRootState.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DivStateDaoImpl divStateDaoImpl = DivStateDaoImpl.this;
                Cursor cursorRawQuery = divStateDaoImpl.writableDatabase.rawQuery(StateSchema.SQL_DELETE_CARD_ROOT_STATE_QUERY_TEMPLATE, new String[]{cardId});
                Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "writableDatabase.rawQuer…yOf(cardId)\n            )");
                divStateDaoImpl.applyAndClose(cursorRawQuery);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.div.state.db.DivStateDao
    public String getRootStateId(final String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        inTransaction(this.writableDatabase, new Function0<Unit>() { // from class: com.yandex.div.state.db.DivStateDaoImpl.getRootStateId.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.String] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws IOException {
                Cursor cursor = DivStateDaoImpl.this.writableDatabase.rawQuery(StateSchema.SQL_GET_ROOT_STATE_ID_QUERY_TEMPLATE, new String[]{cardId});
                Cursor cursor2 = cursor;
                Ref.ObjectRef<String> objectRef2 = objectRef;
                DivStateDaoImpl divStateDaoImpl = DivStateDaoImpl.this;
                try {
                    if (cursor.moveToNext()) {
                        Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
                        objectRef2.element = divStateDaoImpl.getStateIdOrNull(cursor);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor2, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor2, th);
                        throw th2;
                    }
                }
            }
        });
        return (String) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPath(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("path"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStateId(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(StateEntry.COLUMN_STATE_ID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStateIdOrNull(Cursor cursor) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(StateEntry.COLUMN_STATE_ID);
        if (cursor.isNull(columnIndexOrThrow)) {
            return null;
        }
        return cursor.getString(columnIndexOrThrow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAndClose(Cursor cursor) {
        cursor.moveToLast();
        cursor.close();
    }

    private final void inTransaction(SQLiteDatabase sQLiteDatabase, Function0<Unit> function0) {
        sQLiteDatabase.beginTransaction();
        try {
            function0.invoke();
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
