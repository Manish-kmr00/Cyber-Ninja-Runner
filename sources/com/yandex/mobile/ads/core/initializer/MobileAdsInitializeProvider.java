package com.yandex.mobile.ads.core.initializer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.yandex.mobile.ads.impl.eg;
import com.yandex.mobile.ads.impl.wm2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/yandex/mobile/ads/core/initializer/MobileAdsInitializeProvider;", "Landroid/content/ContentProvider;", "Lcom/yandex/mobile/ads/impl/eg;", "appStartupInitializer", "<init>", "(Lcom/yandex/mobile/ads/impl/eg;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class MobileAdsInitializeProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eg f8334a;

    public MobileAdsInitializeProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return true;
        }
        eg egVar = this.f8334a;
        wm2 wm2Var = new wm2(context);
        egVar.getClass();
        eg.a(context, wm2Var);
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    public MobileAdsInitializeProvider(eg appStartupInitializer) {
        Intrinsics.checkNotNullParameter(appStartupInitializer, "appStartupInitializer");
        this.f8334a = appStartupInitializer;
    }

    public /* synthetic */ MobileAdsInitializeProvider(eg egVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new eg() : egVar);
    }
}
