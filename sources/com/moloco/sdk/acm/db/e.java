package com.moloco.sdk.acm.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.moloco.sdk.acm.db.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f6010a;
    public final EntityInsertionAdapter<com.moloco.sdk.acm.db.b> b;
    public final com.moloco.sdk.acm.db.a c = new com.moloco.sdk.acm.db.a();
    public final EntityInsertionAdapter<com.moloco.sdk.acm.db.b> d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;

    public class a extends EntityInsertionAdapter<com.moloco.sdk.acm.db.b> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement stmt, com.moloco.sdk.acm.db.b value) {
            stmt.bindLong(1, value.i());
            if (value.j() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.j());
            }
            stmt.bindLong(3, value.l());
            String strA = e.this.c.a(value.h());
            if (strA == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, strA);
            }
            if (value.g() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindLong(5, value.g().longValue());
            }
            String strA2 = e.this.c.a(value.k());
            if (strA2 == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, strA2);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `events` (`id`,`name`,`timestamp`,`eventType`,`data`,`tags`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }
    }

    public class b extends EntityInsertionAdapter<com.moloco.sdk.acm.db.b> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement stmt, com.moloco.sdk.acm.db.b value) {
            stmt.bindLong(1, value.i());
            if (value.j() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.j());
            }
            stmt.bindLong(3, value.l());
            String strA = e.this.c.a(value.h());
            if (strA == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, strA);
            }
            if (value.g() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindLong(5, value.g().longValue());
            }
            String strA2 = e.this.c.a(value.k());
            if (strA2 == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, strA2);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `events` (`id`,`name`,`timestamp`,`eventType`,`data`,`tags`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM events";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM sqlite_sequence WHERE name='events'";
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.acm.db.e$e, reason: collision with other inner class name */
    public class CallableC0527e implements Callable<Unit> {
        public CallableC0527e() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            SupportSQLiteStatement supportSQLiteStatementAcquire = e.this.e.acquire();
            e.this.f6010a.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                e.this.f6010a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                e.this.f6010a.endTransaction();
                e.this.e.release(supportSQLiteStatementAcquire);
            }
        }
    }

    public class f implements Callable<Unit> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            SupportSQLiteStatement supportSQLiteStatementAcquire = e.this.f.acquire();
            e.this.f6010a.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                e.this.f6010a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                e.this.f6010a.endTransaction();
                e.this.f.release(supportSQLiteStatementAcquire);
            }
        }
    }

    public class g implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6017a;

        public g(final List val$ids) {
            this.f6017a = val$ids;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
            sbNewStringBuilder.append("DELETE FROM events WHERE id IN (");
            StringUtil.appendPlaceholders(sbNewStringBuilder, this.f6017a.size());
            sbNewStringBuilder.append(")");
            SupportSQLiteStatement supportSQLiteStatementCompileStatement = e.this.f6010a.compileStatement(sbNewStringBuilder.toString());
            Iterator it = this.f6017a.iterator();
            int i = 1;
            while (it.hasNext()) {
                supportSQLiteStatementCompileStatement.bindLong(i, ((Long) it.next()).longValue());
                i++;
            }
            e.this.f6010a.beginTransaction();
            try {
                supportSQLiteStatementCompileStatement.executeUpdateDelete();
                e.this.f6010a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                e.this.f6010a.endTransaction();
            }
        }
    }

    public e(RoomDatabase __db) {
        this.f6010a = __db;
        this.b = new a(__db);
        this.d = new b(__db);
        this.e = new c(__db);
        this.f = new d(__db);
    }

    public final /* synthetic */ Object e(Continuation continuation) {
        return com.moloco.sdk.acm.db.d.a.a(this, continuation);
    }

    public final /* synthetic */ Object f(Continuation continuation) {
        return com.moloco.sdk.acm.db.d.a.b(this, continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public long a(final com.moloco.sdk.acm.db.b event) {
        this.f6010a.assertNotSuspendingTransaction();
        this.f6010a.beginTransaction();
        try {
            long jInsertAndReturnId = this.b.insertAndReturnId(event);
            this.f6010a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.f6010a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<Long> b(final List<com.moloco.sdk.acm.db.b> events) {
        this.f6010a.assertNotSuspendingTransaction();
        this.f6010a.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.d.insertAndReturnIdsList(events);
            this.f6010a.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.f6010a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object c(final Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.f6010a, new Function1() { // from class: com.moloco.sdk.acm.db.e$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.f((Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object d(final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f6010a, true, new f(), continuation);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<Long> a(final List<com.moloco.sdk.acm.db.b> events) {
        this.f6010a.assertNotSuspendingTransaction();
        this.f6010a.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.b.insertAndReturnIdsList(events);
            this.f6010a.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.f6010a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object b(final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f6010a, true, new CallableC0527e(), continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<com.moloco.sdk.acm.db.b> b() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM events LIMIT 900", 0);
        this.f6010a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f6010a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tags");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new com.moloco.sdk.acm.db.b(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), this.c.a(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), this.c.b(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object a(final Continuation<? super List<com.moloco.sdk.acm.db.b>> continuation) {
        return RoomDatabaseKt.withTransaction(this.f6010a, new Function1() { // from class: com.moloco.sdk.acm.db.e$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.e((Continuation) obj);
            }
        }, continuation);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.moloco.sdk.acm.db.d
    public com.moloco.sdk.acm.db.b a(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM events WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.f6010a.assertNotSuspendingTransaction();
        com.moloco.sdk.acm.db.b bVar = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.f6010a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tags");
            if (cursorQuery.moveToFirst()) {
                long j2 = cursorQuery.getLong(columnIndexOrThrow);
                String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                long j3 = cursorQuery.getLong(columnIndexOrThrow3);
                com.moloco.sdk.acm.db.c cVarA = this.c.a(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    string = cursorQuery.getString(columnIndexOrThrow6);
                }
                bVar = new com.moloco.sdk.acm.db.b(j2, string2, j3, cVarA, lValueOf, this.c.b(string));
            }
            return bVar;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<com.moloco.sdk.acm.db.b> a() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM events", 0);
        this.f6010a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f6010a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tags");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new com.moloco.sdk.acm.db.b(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), this.c.a(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), this.c.b(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object a(final List<Long> ids, final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f6010a, true, new g(ids), continuation);
    }
}
