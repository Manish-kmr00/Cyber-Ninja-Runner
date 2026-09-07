package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j5 extends g5 implements s3.a {
    protected final com.applovin.impl.sdk.ad.b g;
    private AppLovinAdLoadListener h;
    protected final String i;
    private final com.applovin.impl.sdk.m j;
    private final Collection k;
    private boolean l;
    protected ExecutorService m;
    protected ExecutorService n;
    protected List o;
    private d0 p;

    class a implements e0.a {
        a() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            j5.this.g.b(uri);
            com.applovin.impl.sdk.o oVar = j5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                j5 j5Var = j5.this;
                j5Var.c.a(j5Var.b, "Ad updated with muteImageUri = " + uri);
            }
        }
    }

    class b implements e0.a {
        b() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            j5.this.g.c(uri);
            com.applovin.impl.sdk.o oVar = j5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                j5 j5Var = j5.this;
                j5Var.c.a(j5Var.b, "Ad updated with unmuteImageUri = " + uri);
            }
        }
    }

    class c implements e0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e0.a f465a;

        c(e0.a aVar) {
            this.f465a = aVar;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.o oVar = j5.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    j5 j5Var = j5.this;
                    j5Var.c.a(j5Var.b, "Finish caching video for ad #" + j5.this.g.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
                }
                this.f465a.a(uri);
                return;
            }
            com.applovin.impl.sdk.o oVar2 = j5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                j5 j5Var2 = j5.this;
                j5Var2.c.b(j5Var2.b, "Failed to cache video");
            }
            j5.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            Bundle bundle = new Bundle();
            bundle.putLong(CreativeInfo.c, j5.this.g.getAdIdNumber());
            j5.this.f424a.u().a(bundle, "video_caching_failed");
        }
    }

    class d implements d0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f466a;

        d(e eVar) {
            this.f466a = eVar;
        }

        @Override // com.applovin.impl.d0.c
        public void a(String str, boolean z) {
            if (z) {
                j5.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                return;
            }
            e eVar = this.f466a;
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }

    public interface e {
        void a(String str);
    }

    j5(String str, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, kVar);
        this.i = UUID.randomUUID().toString();
        if (bVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.g = bVar;
        this.h = appLovinAdLoadListener;
        this.j = kVar.H();
        this.k = h();
        if (((Boolean) kVar.a(v4.I0)).booleanValue()) {
            if (kVar.r0().f()) {
                this.m = kVar.r0().a();
                this.n = kVar.r0().e();
            } else {
                String mediationServeId = StringUtils.isValidString(bVar.getMediationServeId()) ? bVar.getMediationServeId() : UUID.randomUUID().toString();
                this.m = kVar.r0().a("com.applovin.sdk.caching." + mediationServeId, ((Integer) kVar.a(v4.K0)).intValue());
                this.n = kVar.r0().a("com.applovin.sdk.caching.html." + mediationServeId, ((Integer) kVar.a(v4.L0)).intValue());
            }
        }
    }

    private Collection h() {
        HashSet hashSet = new HashSet();
        for (char c2 : ((String) this.f424a.a(v4.D0)).toCharArray()) {
            hashSet.add(Character.valueOf(c2));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.h;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.g);
            this.h = null;
        }
    }

    @Override // com.applovin.impl.s3.a
    public void a(v2 v2Var) {
        if (v2Var.P().equalsIgnoreCase(this.g.getMediationServeId())) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Updating flag for timeout...");
            }
            g();
        }
        this.f424a.Z().b(this);
    }

    protected e0 b(String str, e0.a aVar) {
        return a(str, this.g.c0(), true, aVar);
    }

    Uri c(String str) {
        return b(str, this.g.c0(), true);
    }

    protected List e() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.g.Q() != null) {
            arrayList.add(a(this.g.Q().toString(), new a()));
        }
        if (this.g.i0() != null) {
            arrayList.add(a(this.g.i0().toString(), new b()));
        }
        return arrayList;
    }

    void f() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendered new ad:" + this.g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.j5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.i();
            }
        });
    }

    protected void g() {
        this.l = true;
        List list = this.o;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                ((c0) it.next()).a(true);
            }
        }
        if (this.f424a.r0().f()) {
            d0 d0Var = this.p;
            if (d0Var != null) {
                d0Var.c();
                return;
            }
            return;
        }
        ExecutorService executorService = this.m;
        if (executorService != null) {
            executorService.shutdown();
            this.m = null;
        }
        ExecutorService executorService2 = this.n;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.n = null;
        }
    }

    void j() {
        if (o0.e()) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching mute images...");
        }
        Uri uriA = a(this.g.Q(), "mute");
        if (uriA != null) {
            this.g.b(uriA);
        }
        Uri uriA2 = a(this.g.i0(), "unmute");
        if (uriA2 != null) {
            this.g.c(uriA2);
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Ad updated with muteImageFilename = " + this.g.Q() + ", unmuteImageFilename = " + this.g.i0());
        }
    }

    protected void k() {
        this.f424a.Z().b(this);
        if (!this.f424a.r0().f()) {
            ExecutorService executorService = this.m;
            if (executorService != null) {
                executorService.shutdown();
                this.m = null;
            }
            ExecutorService executorService2 = this.n;
            if (executorService2 != null) {
                executorService2.shutdown();
                this.n = null;
            }
        }
        MaxAdFormat maxAdFormatD = this.g.getAdZone().d();
        if (((Boolean) this.f424a.a(v4.W0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f424a.h().b(this.g);
        }
        this.f424a.d0().a(this.i);
    }

    protected boolean l() {
        return this.l;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.g.o1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Subscribing to timeout events...");
            }
            this.f424a.Z().a(this);
        }
    }

    Uri b(String str, List list, boolean z) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video " + str + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        int iA = this.f424a.H().a(str, this.g);
        Map mapA = e2.a((AppLovinAdImpl) this.g);
        String strA = this.j.a(a(), str, this.g.getCachePrefix(), list, z, iA, this.i, mapA);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache video: " + str);
            }
            a(str, "cacheVideo", mapA);
            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            return null;
        }
        File fileA = this.j.a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to retrieve File from cached video filename = " + strA);
            }
            a(strA, "retrieveVideoFile", mapA);
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Finish caching video for ad #" + this.g.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + strA);
            }
            return uriFromFile;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to create URI from cached video file = " + fileA);
        }
        a(strA, "extractUriFromVideoFile", mapA);
        return null;
    }

    protected String c(String str, List list, boolean z) {
        try {
            InputStream inputStreamA = this.j.a(str, list, z, e2.a((AppLovinAdImpl) this.g));
            if (inputStreamA == null) {
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                return null;
            }
            try {
                String strA = this.j.a(inputStreamA);
                inputStreamA.close();
                return strA;
            } catch (Throwable th) {
                try {
                    inputStreamA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unknown failure to read input stream.", th3);
            }
            this.c.a(this.b, th3);
            this.f424a.E().a(this.b, "readInputStreamAsString", th3);
            return null;
        }
    }

    protected List a(List list) {
        this.o = list;
        return this.f424a.r0().a(list, this.m);
    }

    protected e0 a(String str, e0.a aVar) {
        return new e0(str, this.g, this.i, this.f424a, aVar);
    }

    protected e0 a(String str, List list, boolean z, e0.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            this.c.a(this.b, "No video to cache, skipping...");
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video " + str + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        return new e0(str, this.g, list, z, this.i, this.f424a, new c(aVar));
    }

    protected d0 a(String str, List list, e eVar) {
        d0 d0Var = new d0(str, this.g, list, this.n, this.i, this.f424a, new d(eVar));
        this.p = d0Var;
        return d0Var;
    }

    protected Uri a(Uri uri, String str) {
        if (uri == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No " + str + " image to cache");
            }
            return null;
        }
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to cache " + str + " image");
            }
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching " + str + " image...");
        }
        return b(string);
    }

    Uri a(String str, List list, boolean z) {
        try {
            int iA = this.f424a.H().a(str, this.g);
            Map mapA = e2.a((AppLovinAdImpl) this.g);
            String strA = this.j.a(a(), str, this.g.getCachePrefix(), list, z, iA, this.i, mapA);
            if (StringUtils.isValidString(strA)) {
                File fileA = this.j.a(strA, a());
                if (fileA != null) {
                    Uri uriFromFile = Uri.fromFile(fileA);
                    if (uriFromFile != null) {
                        return uriFromFile;
                    }
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.b(this.b, "Unable to extract Uri from image file");
                    }
                    a(strA, "extractUriFromImageFile", mapA);
                    return null;
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to retrieve File from cached image filename = " + strA);
                }
                a(strA, "retrieveImageFile", mapA);
                return null;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache image: " + str);
            }
            a(str, "cacheImageResource", mapA);
            return null;
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to cache image at url = " + str, th);
            }
            Map mapA2 = e2.a((AppLovinAdImpl) this.g);
            CollectionUtils.putStringIfValid("url", str, mapA2);
            this.f424a.E().a(this.b, "cacheImageResource", th, mapA2);
            return null;
        }
    }

    protected Uri b(String str) {
        return a(str, this.g.c0(), true);
    }

    void a(com.applovin.impl.sdk.ad.b bVar) {
        String strK0 = bVar.k0();
        if (bVar.V0() && StringUtils.isValidString(strK0)) {
            String strA = a(strK0, bVar.c0(), bVar);
            bVar.c(strA);
            this.c.f(this.b, "Ad updated with video button HTML assets cached = " + strA);
        }
    }

    String a(String str, List list, com.applovin.impl.sdk.ad.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!((Boolean) this.f424a.a(v4.E0)).booleanValue()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Resource caching is disabled, skipping cache...");
            }
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        List listA0 = bVar.a0();
        List listR = bVar.R();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            int iIndexOf = 0;
            int i = 0;
            while (iIndexOf < sb.length()) {
                if (l()) {
                    return str;
                }
                iIndexOf = sb.indexOf(str2, i);
                if (iIndexOf == -1) {
                    break;
                }
                int length = sb.length();
                int i2 = iIndexOf;
                while (!this.k.contains(Character.valueOf(sb.charAt(i2))) && i2 < length) {
                    i2++;
                }
                if (i2 > iIndexOf && i2 != length) {
                    String strSubstring = sb.substring(str2.length() + iIndexOf, i2);
                    String str3 = str2 + strSubstring;
                    if (StringUtils.isValidString(strSubstring) && !listR.contains(str3)) {
                        Uri uriA = a(str2, strSubstring);
                        if (uriA != null) {
                            sb.replace(iIndexOf, i2, uriA.toString());
                            bVar.a(uriA);
                        } else {
                            if (listA0.contains(str3)) {
                                a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                                this.l = true;
                            }
                            if (com.applovin.impl.sdk.o.a()) {
                                this.c.b(this.b, "Failed to cache HTML Resource: " + str3);
                            }
                            a(str3, "cacheHtmlResource", e2.a((AppLovinAdImpl) bVar));
                        }
                    } else if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "Skip caching of optional or non-resource: " + strSubstring);
                    }
                    i = i2;
                } else {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.b(this.b, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return str;
                }
            }
        }
        return sb.toString();
    }

    private Uri a(String str, String str2) {
        File fileA = this.j.a(k7.a(Uri.parse(str2), this.g.getCachePrefix(), this.f424a), com.applovin.impl.sdk.k.o());
        if (fileA == null) {
            return null;
        }
        if (!((Boolean) this.f424a.a(v4.E6)).booleanValue() && this.j.a(fileA)) {
            return Uri.parse(AdPayload.FILE_SCHEME + fileA.getAbsolutePath());
        }
        String str3 = str + str2;
        if (this.j.a(fileA, str3, Arrays.asList(str), this.f424a.H().a(str3, this.g), this.i, e2.a((AppLovinAdImpl) this.g))) {
            return Uri.parse(AdPayload.FILE_SCHEME + fileA.getAbsolutePath());
        }
        return null;
    }

    void a(int i) {
        if (this.h != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Calling back ad load failed with error code: " + i);
            }
            this.h.failedToReceiveAd(i);
            this.h = null;
        }
        g();
    }

    protected void a(String str, String str2, Map map) {
        HashMap map2 = new HashMap(map);
        CollectionUtils.putStringIfValid("url", str, map2);
        this.f424a.E().a(c2.z0, str2, map2);
    }
}
