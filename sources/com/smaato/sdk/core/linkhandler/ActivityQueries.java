package com.smaato.sdk.core.linkhandler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class ActivityQueries {
    private final Context context;

    public ActivityQueries(Context context) {
        this.context = context;
    }

    public Set<String> queryTargetActivityNames(String str) {
        PackageManager packageManager = this.context.getPackageManager();
        HashSet hashSet = new HashSet();
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)).addCategory("android.intent.category.BROWSABLE").addCategory("android.intent.category.DEFAULT"), 0).iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().activityInfo.targetActivity);
        }
        return hashSet;
    }

    public boolean canBeLaunched(Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }
}
