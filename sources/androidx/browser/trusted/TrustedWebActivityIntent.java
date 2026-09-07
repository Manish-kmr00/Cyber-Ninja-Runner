package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.safedk.android.utils.Logger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class TrustedWebActivityIntent {
    private final Intent mIntent;
    private final List<Uri> mSharedFileUris;

    public static void safedk_ContextCompat_startActivity_f482d8446b01c5580049a261a99b538c(Context p0, Intent p1, Bundle p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroidx/core/content/ContextCompat;->startActivity(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V");
        if (p1 == null) {
            return;
        }
        ContextCompat.startActivity(p0, p1, p2);
    }

    TrustedWebActivityIntent(Intent intent, List<Uri> list) {
        this.mIntent = intent;
        this.mSharedFileUris = list;
    }

    public void launchTrustedWebActivity(Context context) {
        grantUriPermissionToProvider(context);
        safedk_ContextCompat_startActivity_f482d8446b01c5580049a261a99b538c(context, this.mIntent, null);
    }

    private void grantUriPermissionToProvider(Context context) {
        Iterator<Uri> it = this.mSharedFileUris.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(this.mIntent.getPackage(), it.next(), 1);
        }
    }

    public Intent getIntent() {
        return this.mIntent;
    }
}
