package com.applovin.impl.sdk.nativeAd;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.e2;
import com.applovin.impl.g5;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class a extends g5 {
    private final AppLovinNativeAdImpl g;
    private final InterfaceC0142a h;
    private final String i;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.nativeAd.a$a, reason: collision with other inner class name */
    public interface InterfaceC0142a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, k kVar, InterfaceC0142a interfaceC0142a) {
        super("TaskCacheNativeAd", kVar);
        this.i = UUID.randomUUID().toString();
        this.g = appLovinNativeAdImpl;
        this.h = interfaceC0142a;
    }

    private float a(Uri uri) {
        File file = new File(uri.getPath());
        if (!file.exists()) {
            return -1.0f;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fileInputStream, null, options);
                int i = options.outWidth;
                int i2 = options.outHeight;
                if (i <= 0 || i2 <= 0) {
                    fileInputStream.close();
                    return -1.0f;
                }
                float f = i / i2;
                fileInputStream.close();
                return f;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            if (o.a()) {
                this.c.a(this.b, "Failed to calculate aspect ratio", e);
            }
        }
    }

    private Uri b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (o.a()) {
            this.c.a(this.b, "Attempting to cache resource: " + uri);
        }
        String strA = this.f424a.H().a(a(), uri.toString(), this.g.getCachePrefix(), Collections.emptyList(), false, false, 1, this.i, e2.a(this.g));
        if (TextUtils.isEmpty(strA)) {
            if (o.a()) {
                this.c.b(this.b, "Unable to cache resource for uri: " + uri);
            }
            return null;
        }
        File fileA = this.f424a.H().a(strA, a());
        if (fileA == null) {
            if (o.a()) {
                this.c.b(this.b, "Unable to retrieve File from cached image filename = " + strA);
            }
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile != null) {
            return uriFromFile;
        }
        if (o.a()) {
            this.c.b(this.b, "Unable to extract Uri from image file");
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (o.a()) {
            this.c.a(this.b, "Begin caching ad #" + this.g.getAdIdNumber() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        Uri uriB = b(this.g.getIconUri());
        if (uriB != null) {
            this.g.setIconUri(uriB);
        }
        Uri uriB2 = b(this.g.getMainImageUri());
        if (uriB2 != null) {
            this.g.setMainImageUri(uriB2);
            float fA = a(uriB2);
            if (fA > 0.0f) {
                this.g.setMainImageAspectRatio(fA);
            }
        }
        Uri uriB3 = b(this.g.getPrivacyIconUri());
        if (uriB3 != null) {
            this.g.setPrivacyIconUri(uriB3);
        }
        if (o.a()) {
            this.c.a(this.b, "Finished caching ad #" + this.g.getAdIdNumber());
        }
        this.h.a(this.g);
    }
}
