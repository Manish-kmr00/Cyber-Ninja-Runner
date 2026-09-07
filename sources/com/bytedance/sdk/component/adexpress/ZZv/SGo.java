package com.bytedance.sdk.component.adexpress.ZZv;

import android.net.Uri;
import android.text.TextUtils;
import com.pubmatic.sdk.common.POBCommonConstants;

/* JADX INFO: loaded from: classes8.dex */
public class SGo {
    public static pA pA(String str) {
        pA pAVar = pA.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        pAVar = pA.CSS;
                    } else if (path.endsWith(".js")) {
                        pAVar = pA.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        pAVar = pA.IMAGE;
                    } else if (path.endsWith(".html")) {
                        pAVar = pA.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return pAVar;
    }

    public static boolean Og(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public enum pA {
        HTML(POBCommonConstants.CONTENT_TYPE_HTML),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String ML;

        pA(String str) {
            this.ML = str;
        }

        public String pA() {
            return this.ML;
        }
    }
}
