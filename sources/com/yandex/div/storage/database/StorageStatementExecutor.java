package com.yandex.div.storage.database;

import android.database.SQLException;
import android.database.sqlite.SQLiteFullException;
import com.yandex.div.storage.DivDataRepository;
import com.yandex.div.storage.DivStorageErrorException;
import com.yandex.div.storage.util.SqlExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: StorageStatementExecutor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0007¢\u0006\u0002\u0010\rJ!\u0010\u0006\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0007¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/storage/database/StorageStatementExecutor;", "", "dbProvider", "Lkotlin/Function0;", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "(Lkotlin/jvm/functions/Function0;)V", "execute", "Lcom/yandex/div/storage/database/ExecutionResult;", "actionOnError", "Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "statements", "", "Lcom/yandex/div/storage/database/StorageStatement;", "(Lcom/yandex/div/storage/DivDataRepository$ActionOnError;[Lcom/yandex/div/storage/database/StorageStatement;)Lcom/yandex/div/storage/database/ExecutionResult;", "([Lcom/yandex/div/storage/database/StorageStatement;)Lcom/yandex/div/storage/database/ExecutionResult;", "throwWithLogging", "", "message", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StorageStatementExecutor {
    private final Function0<DatabaseOpenHelper.Database> dbProvider;

    /* JADX INFO: compiled from: StorageStatementExecutor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivDataRepository.ActionOnError.values().length];
            try {
                iArr[DivDataRepository.ActionOnError.ABORT_TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivDataRepository.ActionOnError.SKIP_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StorageStatementExecutor(Function0<? extends DatabaseOpenHelper.Database> dbProvider) {
        Intrinsics.checkNotNullParameter(dbProvider, "dbProvider");
        this.dbProvider = dbProvider;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e7 A[PHI: r20
  0x00e7: PHI (r20v6 com.yandex.div.storage.database.DatabaseOpenHelper$Database) = 
  (r20v4 com.yandex.div.storage.database.DatabaseOpenHelper$Database)
  (r20v5 com.yandex.div.storage.database.DatabaseOpenHelper$Database)
  (r20v8 com.yandex.div.storage.database.DatabaseOpenHelper$Database)
 binds: [B:58:0x0110, B:68:0x0136, B:48:0x00e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x0144  */
    /* JADX WARN: Code duplicated, block: B:78:0x014d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0152  */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, com.yandex.div.storage.database.StorageStatement] */
    public final ExecutionResult execute(DivDataRepository.ActionOnError actionOnError, StorageStatement... statements) throws Throwable {
        ClosableSqlCompiler closableSqlCompiler;
        ClosableSqlCompiler closableSqlCompiler2;
        DatabaseOpenHelper.Database database;
        DatabaseOpenHelper.Database database2;
        Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
        Intrinsics.checkNotNullParameter(statements, "statements");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ArrayList arrayList = new ArrayList();
        DatabaseOpenHelper.Database database3 = null;
        try {
            try {
                DatabaseOpenHelper.Database databaseInvoke = this.dbProvider.invoke();
                try {
                    ClosableSqlCompiler closableSqlCompiler3 = new ClosableSqlCompiler(databaseInvoke);
                    try {
                        databaseInvoke.beginTransaction();
                        int length = statements.length;
                        int i = 0;
                        while (i < length) {
                            ?? r4 = statements[i];
                            objectRef.element = r4;
                            int i2 = i;
                            int i3 = length;
                            closableSqlCompiler2 = closableSqlCompiler3;
                            database = databaseInvoke;
                            try {
                                execute$executeCatchingSqlException(objectRef, intRef, statements, actionOnError, this, arrayList, closableSqlCompiler3, r4);
                                intRef.element++;
                                i = i2 + 1;
                                length = i3;
                                closableSqlCompiler3 = closableSqlCompiler2;
                                databaseInvoke = database;
                            } catch (SQLiteFullException e) {
                                e = e;
                                arrayList.add(new DivStorageErrorException("Error during statements execution.", e, null, 4, null));
                                if (database != null) {
                                    SqlExtensionsKt.endTransactionSilently(database);
                                }
                                if (closableSqlCompiler2 != null) {
                                    closableSqlCompiler2.close();
                                }
                                if (database != null) {
                                    SqlExtensionsKt.closeSilently(database);
                                }
                                return new ExecutionResult(arrayList);
                            } catch (SQLException e2) {
                                e = e2;
                                arrayList.add(new DivStorageErrorException("Error during statements execution.", e, null, 4, null));
                                if (database != null) {
                                    SqlExtensionsKt.endTransactionSilently(database);
                                }
                                if (closableSqlCompiler2 != null) {
                                    closableSqlCompiler2.close();
                                }
                                if (database != null) {
                                    SqlExtensionsKt.closeSilently(database);
                                }
                                return new ExecutionResult(arrayList);
                            } catch (IllegalStateException e3) {
                                e = e3;
                                arrayList.add(new DivStorageErrorException("Error during statements execution.", e, null, 4, null));
                                if (database != null) {
                                    SqlExtensionsKt.endTransactionSilently(database);
                                }
                                if (closableSqlCompiler2 != null) {
                                    closableSqlCompiler2.close();
                                }
                                if (database != null) {
                                    SqlExtensionsKt.closeSilently(database);
                                }
                                return new ExecutionResult(arrayList);
                            }
                        }
                        closableSqlCompiler2 = closableSqlCompiler3;
                        database = databaseInvoke;
                        database.setTransactionSuccessful();
                        if (database != null) {
                            SqlExtensionsKt.endTransactionSilently(database);
                        }
                        closableSqlCompiler2.close();
                        if (database != null) {
                            SqlExtensionsKt.closeSilently(database);
                        }
                    } catch (SQLiteFullException e4) {
                        e = e4;
                        closableSqlCompiler2 = closableSqlCompiler3;
                        database = databaseInvoke;
                    } catch (SQLException e5) {
                        e = e5;
                        closableSqlCompiler2 = closableSqlCompiler3;
                        database = databaseInvoke;
                    } catch (IllegalStateException e6) {
                        e = e6;
                        closableSqlCompiler2 = closableSqlCompiler3;
                        database = databaseInvoke;
                    } catch (Throwable th) {
                        th = th;
                        closableSqlCompiler = closableSqlCompiler3;
                        database2 = databaseInvoke;
                        database3 = database2;
                        if (database3 != null) {
                            SqlExtensionsKt.endTransactionSilently(database3);
                        }
                        if (closableSqlCompiler != null) {
                            closableSqlCompiler.close();
                        }
                        if (database3 != null) {
                            SqlExtensionsKt.closeSilently(database3);
                        }
                        throw th;
                    }
                } catch (SQLiteFullException e7) {
                    e = e7;
                    database = databaseInvoke;
                    closableSqlCompiler2 = null;
                } catch (SQLException e8) {
                    e = e8;
                    database = databaseInvoke;
                    closableSqlCompiler2 = null;
                } catch (IllegalStateException e9) {
                    e = e9;
                    database = databaseInvoke;
                    closableSqlCompiler2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    database2 = databaseInvoke;
                    closableSqlCompiler = null;
                }
            } catch (SQLiteFullException e10) {
                e = e10;
                closableSqlCompiler2 = null;
                database = null;
            } catch (SQLException e11) {
                e = e11;
                closableSqlCompiler2 = null;
                database = null;
            } catch (IllegalStateException e12) {
                e = e12;
                closableSqlCompiler2 = null;
                database = null;
            } catch (Throwable th3) {
                th = th3;
                closableSqlCompiler = null;
                if (database3 != null) {
                    SqlExtensionsKt.endTransactionSilently(database3);
                }
                if (closableSqlCompiler != null) {
                    closableSqlCompiler.close();
                }
                if (database3 != null) {
                    SqlExtensionsKt.closeSilently(database3);
                }
                throw th;
            }
            return new ExecutionResult(arrayList);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static final void execute$handleException(Ref.ObjectRef<StorageStatement> objectRef, Ref.IntRef intRef, StorageStatement[] storageStatementArr, DivDataRepository.ActionOnError actionOnError, StorageStatementExecutor storageStatementExecutor, List<DivStorageErrorException> list, Exception exc) {
        String str = "Exception at statement '" + objectRef.element + "' (" + intRef.element + " out " + storageStatementArr.length + ')';
        int i = WhenMappings.$EnumSwitchMapping$0[actionOnError.ordinal()];
        if (i == 1) {
            storageStatementExecutor.throwWithLogging(str, exc);
            throw new KotlinNothingValueException();
        }
        if (i != 2) {
            return;
        }
        list.add(new DivStorageErrorException(str, exc, null, 4, null));
    }

    private static final void execute$executeCatchingSqlException(Ref.ObjectRef<StorageStatement> objectRef, Ref.IntRef intRef, StorageStatement[] storageStatementArr, DivDataRepository.ActionOnError actionOnError, StorageStatementExecutor storageStatementExecutor, List<DivStorageErrorException> list, ClosableSqlCompiler closableSqlCompiler, StorageStatement storageStatement) {
        try {
            storageStatement.execute(closableSqlCompiler);
        } catch (SQLException e) {
            execute$handleException(objectRef, intRef, storageStatementArr, actionOnError, storageStatementExecutor, list, e);
        } catch (IllegalStateException e2) {
            execute$handleException(objectRef, intRef, storageStatementArr, actionOnError, storageStatementExecutor, list, e2);
        }
    }

    public final ExecutionResult execute(StorageStatement... statements) throws SQLException {
        Intrinsics.checkNotNullParameter(statements, "statements");
        return execute(DivDataRepository.ActionOnError.ABORT_TRANSACTION, (StorageStatement[]) Arrays.copyOf(statements, statements.length));
    }

    private final Void throwWithLogging(String message, Exception exception) throws SQLException {
        throw new SQLException(message, exception);
    }
}
