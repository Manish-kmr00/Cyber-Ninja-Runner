package com.chartboost.sdk.impl;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/chartboost/sdk/impl/w6;", "", "", SDKConstants.PARAM_DEEP_LINK, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Z", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "", "Landroid/content/pm/ResolveInfo;", "a", "(Landroid/content/Intent;)Ljava/util/List;", "Landroid/content/pm/PackageManager$ResolveInfoFlags;", "flags", "(Landroid/content/Intent;Landroid/content/pm/PackageManager$ResolveInfoFlags;)Ljava/util/List;", "url", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/pm/PackageManager;", "Landroid/content/pm/PackageManager;", "packageManager", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "intentFactory", "<init>", "(Landroid/content/pm/PackageManager;Lkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final PackageManager packageManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Function0<Intent> intentFactory;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/Intent;", "a", "()Landroid/content/Intent;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Intent> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Intent invoke() {
            return new Intent("android.intent.action.VIEW");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w6(PackageManager packageManager, Function0<? extends Intent> intentFactory) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(intentFactory, "intentFactory");
        this.packageManager = packageManager;
        this.intentFactory = intentFactory;
    }

    public final boolean b(String deepLink) {
        if (deepLink == null || deepLink.length() == 0) {
            return false;
        }
        try {
            return !a(a(deepLink)).isEmpty();
        } catch (Exception e) {
            b7.b("Cannot open URL", e);
            return false;
        }
    }

    public /* synthetic */ w6(PackageManager packageManager, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(packageManager, (i & 2) != 0 ? a.b : function0);
    }

    public final Intent a(String url) {
        Intent intentInvoke = this.intentFactory.invoke();
        intentInvoke.addFlags(268435456);
        intentInvoke.setData(Uri.parse(url));
        return intentInvoke;
    }

    public final List<ResolveInfo> a(Intent intent, PackageManager.ResolveInfoFlags flags) {
        List<ResolveInfo> listQueryIntentActivities = this.packageManager.queryIntentActivities(intent, flags);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…Activities(intent, flags)");
        return listQueryIntentActivities;
    }

    public final List<ResolveInfo> a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            PackageManager.ResolveInfoFlags resolveInfoFlagsOf = PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
            Intrinsics.checkNotNullExpressionValue(resolveInfoFlagsOf, "of(PackageManager.MATCH_DEFAULT_ONLY.toLong())");
            return a(intent, resolveInfoFlagsOf);
        }
        List<ResolveInfo> listQueryIntentActivities = this.packageManager.queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "{\n            packageMan…H_DEFAULT_ONLY)\n        }");
        return listQueryIntentActivities;
    }
}
