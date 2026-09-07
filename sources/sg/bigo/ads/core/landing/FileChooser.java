package sg.bigo.ads.core.landing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.safedk.android.utils.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes5.dex */
public class FileChooser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Activity f13619a;
    ValueCallback<Uri> b;
    ValueCallback<Uri[]> c;

    public FileChooser(Activity activity) {
        this.f13619a = activity;
    }

    public static void safedk_Activity_startActivityForResult_206f42f0b65887e835d87ee52d14d221(Activity p0, Intent p1, int p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V");
        if (p1 == null) {
            return;
        }
        p0.startActivityForResult(p1, p2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Serializable, java.lang.Object[]] */
    final void a(String... strArr) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                if (!q.a((CharSequence) str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.isEmpty()) {
            intent.setType("*/*");
        } else {
            intent.setType((String) arrayList.get(0));
            if (arrayList.size() > 1) {
                intent.putExtra("android.intent.extra.MIME_TYPES", (Serializable) arrayList.toArray());
            }
        }
        safedk_Activity_startActivityForResult_206f42f0b65887e835d87ee52d14d221(this.f13619a, Intent.createChooser(intent, "Select File"), 101);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        sg.bigo.ads.common.t.a.a(0, 3, "FileChooser", "openFileChooser");
        this.b = valueCallback;
        a(str);
    }
}
