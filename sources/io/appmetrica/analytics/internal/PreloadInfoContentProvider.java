package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.C4262la;
import io.appmetrica.analytics.impl.J3;
import io.appmetrica.analytics.impl.K3;
import io.appmetrica.analytics.impl.N5;
import io.appmetrica.analytics.impl.O5;
import io.appmetrica.analytics.impl.Ve;
import io.appmetrica.analytics.impl.Vi;
import io.appmetrica.analytics.impl.We;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes12.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11888a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(O5 o5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object objInvoke = o5.f11278a.invoke(contentValues);
                if (objInvoke != null) {
                    o5.c.b(applicationContext);
                    if (((Boolean) o5.b.invoke(objInvoke)).booleanValue()) {
                        Vi.a("Successfully saved " + o5.d, new Object[0]);
                    } else {
                        Vi.a("Did not save " + o5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Vi.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f11888a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f11888a) {
                return null;
            }
            if (contentValues != null) {
                int iMatch = this.b.match(uri);
                if (iMatch == 1) {
                    a(new O5(new Ve(), new We(), C4262la.d, "preload info"), contentValues);
                } else if (iMatch != 2) {
                    Vi.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new O5(new J3(), new K3(), C4262la.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = N5.f11265a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        String str = (applicationContext != null ? applicationContext.getPackageName() : "") + ".appmetrica.preloadinfo.retail";
        this.b.addURI(str, "preloadinfo", 1);
        this.b.addURI(str, "clids", 2);
        N5.f11265a = new CountDownLatch(1);
        N5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Vi.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Vi.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
