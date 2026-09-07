package sg.bigo.ads.core.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.f;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements sg.bigo.ads.common.h.b.a, sg.bigo.ads.core.player.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f13692a = new b();
    public Context c;
    public List<o> d;
    public List<o> e;
    public Map<String, a> f;
    public sg.bigo.ads.common.h.b g;
    public sg.bigo.ads.core.player.a h;
    public sg.bigo.ads.common.h.a.a i;
    private sg.bigo.ads.core.player.a.d k;
    public final AtomicBoolean b = new AtomicBoolean(false);
    private long j = 0;

    public interface a {
        void a();

        void a(int i);

        void a(String str, sg.bigo.ads.common.h.a aVar);

        void b(int i);
    }

    private b() {
    }

    private static sg.bigo.ads.api.a.d a(o oVar) {
        h hVar;
        if (!oVar.aQ() || oVar.aR() || (hVar = i.f13093a) == null || hVar.r() == null) {
            return null;
        }
        return hVar.r();
    }

    private static sg.bigo.ads.common.h.a a(Context context, String str, String str2, o oVar, sg.bigo.ads.api.a.d dVar) {
        if (dVar == null) {
            return new sg.bigo.ads.common.h.a(str, oVar.a(context), str2, oVar.aQ(), oVar.al(), oVar.aR(), null);
        }
        return new sg.bigo.ads.common.h.a(str, oVar.a(context), str2, oVar.aQ(), oVar.al(), false, new sg.bigo.ads.common.h.c(dVar.a(oVar.v(), oVar.x()), dVar.c(oVar.x()), dVar.a(oVar.x()), dVar.b(oVar.x()), dVar.d(oVar.x())));
    }

    public static b a() {
        return f13692a;
    }

    private void a(File file) {
        sg.bigo.ads.common.h.b.a("filterAdFiles dir = " + file.getAbsolutePath(), (sg.bigo.ads.common.h.a) null);
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strD = sg.bigo.ads.common.o.d(this.c);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: sg.bigo.ads.core.player.b.4
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file2, File file3) {
                    long jLastModified = file2.lastModified() - file3.lastModified();
                    if (jLastModified > 0) {
                        return -1;
                    }
                    return jLastModified == 0 ? 0 : 1;
                }
            });
            int i = 0;
            while (i < fileArrListFiles.length) {
                File file2 = fileArrListFiles[i];
                sg.bigo.ads.common.h.a.a aVar = this.i;
                long jLastModified = file2.lastModified();
                int iA = aVar.a();
                boolean z = aVar.d + jLastModified < jCurrentTimeMillis || i >= iA;
                sg.bigo.ads.common.t.a.a(0, 3, "DownloadConfig", "needDelete lastModifiedTs=" + jLastModified + ", numTmp=" + iA);
                if (z) {
                    sg.bigo.ads.common.h.b.a("delete expired file name = " + file2.getName(), (sg.bigo.ads.common.h.a) null);
                    File file3 = new File(strD, file2.getName());
                    if (file3.exists()) {
                        sg.bigo.ads.common.h.b.a("delete expired cover name = " + file2.getName(), (sg.bigo.ads.common.h.a) null);
                        file3.delete();
                    }
                    file2.delete();
                }
                i++;
            }
        }
    }

    private boolean a(o oVar, sg.bigo.ads.common.h.a aVar) {
        return TextUtils.equals(oVar.b(this.c), aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, o oVar, a aVar) {
        String strAO = oVar.aO();
        String strAP = oVar.aP();
        sg.bigo.ads.common.h.a aVarA = a(context, strAO, strAP, oVar, a(oVar));
        if (aVarA.c()) {
            sg.bigo.ads.common.t.a.a(0, 3, "DownloadInfo", "info SupportFillTime: " + aVarA.toString());
            this.e.add(oVar);
        }
        boolean z = i.f13093a.n().a(9) && URLUtil.isHttpUrl(strAO);
        if (z) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) oVar, strAO, "Invalid http url", 0L, 0L, 2, "", false);
        }
        if (!z && !q.a((CharSequence) strAO) && !q.a((CharSequence) strAP)) {
            this.d.add(oVar);
            this.f.put(oVar.aI(), aVar);
            sg.bigo.ads.common.h.b.a("downloadMedia", aVarA);
            this.g.a(aVarA, false);
            this.h.a(aVarA);
            return;
        }
        oVar.i(5);
        if (!aVarA.c()) {
            aVar.b(z ? 10118 : 10103);
            return;
        }
        aVar.a();
        this.f.put(oVar.aI(), aVar);
        this.h.c(aVarA);
    }

    static /* synthetic */ void b(b bVar) {
        bVar.a(new File(sg.bigo.ads.common.o.b(bVar.c)));
        bVar.a(new File(sg.bigo.ads.common.o.c(bVar.c)));
    }

    private static sg.bigo.ads.core.player.a.d d() {
        sg.bigo.ads.common.h.b.a("start HttpProxyCacheServer ServerSocket", (sg.bigo.ads.common.h.a) null);
        return new sg.bigo.ads.core.player.a.d();
    }

    private void e() {
        if (System.currentTimeMillis() - this.j > 3600000) {
            c();
        }
    }

    public final void a(final Context context, final o oVar, final a aVar) {
        if (!this.b.get()) {
            sg.bigo.ads.common.h.b.a("please execute initAdResource first", (sg.bigo.ads.common.h.a) null);
        } else if (sg.bigo.ads.common.n.d.a()) {
            b(context, oVar, aVar);
        } else {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(context, oVar, aVar);
                }
            });
        }
    }

    public final void a(final String str, final ValueCallback<Boolean> valueCallback) {
        if (this.b.get()) {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    ValueCallback valueCallback2 = valueCallback;
                    sg.bigo.ads.common.h.b bVar = b.this.g;
                    String str2 = str;
                    valueCallback2.onReceiveValue(Boolean.valueOf(sg.bigo.ads.common.h.b.a(bVar.f13192a, str2) || sg.bigo.ads.common.h.b.a(bVar.c, str2)));
                }
            });
        } else {
            valueCallback.onReceiveValue(Boolean.FALSE);
        }
    }

    @Override // sg.bigo.ads.common.h.b.a
    public final void a(sg.bigo.ads.common.h.a aVar) {
        Iterator<o> it = this.d.iterator();
        boolean zA = q.a((CharSequence) aVar.p);
        while (!zA && it.hasNext()) {
            o next = it.next();
            if (a(next, aVar)) {
                next.d(aVar.p);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:117:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0115  */
    /* JADX WARN: Code duplicated, block: B:49:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0140  */
    /* JADX WARN: Code duplicated, block: B:53:0x0147  */
    /* JADX WARN: Code duplicated, block: B:54:0x014b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x01be  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:79:0x021b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0227  */
    /* JADX WARN: Code duplicated, block: B:86:0x0235  */
    /* JADX WARN: Code duplicated, block: B:89:0x0258  */
    /* JADX WARN: Code duplicated, block: B:91:0x0263  */
    /* JADX WARN: Code duplicated, block: B:94:0x0272  */
    /* JADX WARN: Code duplicated, block: B:95:0x029e  */
    /* JADX WARN: Code duplicated, block: B:97:0x02a8  */
    @Override // sg.bigo.ads.common.h.b.a
    public final void a(sg.bigo.ads.common.h.a aVar, int i, long j) {
        String strExtractMetadata;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        n nVar;
        boolean z;
        boolean zA;
        a aVarRemove;
        o.d dVarAA;
        sg.bigo.ads.core.player.a aVar2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean z2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        boolean z3;
        int i2;
        int i3 = i;
        sg.bigo.ads.common.h.b.a("callback download completed source=".concat(String.valueOf(i)), aVar);
        int i4 = 1;
        int i5 = 2;
        boolean z4 = i3 == 2;
        n nVar2 = new n();
        if (sg.bigo.ads.common.o.a(this.c, aVar.c) && aVar.e == 1 && !aVar.f) {
            File file = new File(sg.bigo.ads.common.o.d(this.c), aVar.d);
            if ((!file.exists() || file.length() < 0) && aVar != null && aVar.a() != null && !TextUtils.isEmpty(aVar.d)) {
                String strA = aVar.a();
                if (z4) {
                    strA = f.d(strA);
                }
                Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(strA, 1);
                if (bitmapCreateVideoThumbnail != null) {
                    String strD = sg.bigo.ads.common.o.d(this.c);
                    f.a(strD + File.separator, aVar.d);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(strD, aVar.d));
                        bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                }
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(z4 ? f.d(aVar.a()) : aVar.a());
                    nVar2.f13112a = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    nVar2.b = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    nVar2.c = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    mediaMetadataRetriever.release();
                    strExtractMetadata = "";
                    str = strExtractMetadata;
                    boolean zA2 = b().a();
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    while (r19.hasNext()) {
                        if (a(oVar, aVar)) {
                            if (i3 != 0) {
                                if (i3 != i4) {
                                    oVar.h(4);
                                } else if (i3 == i5) {
                                    oVar.h(3);
                                    oVar.i(3);
                                }
                                if (oVar.aN()) {
                                    arrayList3 = arrayList;
                                    arrayList4 = arrayList2;
                                    String str3 = str;
                                    n nVar3 = nVar2;
                                    z2 = z4;
                                    int i6 = i5;
                                    if (z2) {
                                        arrayList5 = arrayList3;
                                        arrayList6 = arrayList4;
                                    } else {
                                        arrayList3.add(oVar);
                                        arrayList4.add(oVar);
                                        arrayList6 = arrayList4;
                                        arrayList5 = arrayList3;
                                        sg.bigo.ads.core.d.b.a(oVar, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                                    }
                                    str = str3;
                                    nVar2 = nVar3;
                                    z4 = z2;
                                    i5 = i6;
                                    arrayList = arrayList5;
                                    arrayList2 = arrayList6;
                                } else {
                                    arrayList3 = arrayList;
                                    arrayList4 = arrayList2;
                                    String str4 = str;
                                    n nVar4 = nVar2;
                                    z2 = z4;
                                    int i7 = i5;
                                    if (z2) {
                                        arrayList3.add(oVar);
                                        arrayList4.add(oVar);
                                        arrayList6 = arrayList4;
                                        arrayList5 = arrayList3;
                                        sg.bigo.ads.core.d.b.a(oVar, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                                    } else {
                                        arrayList5 = arrayList3;
                                        arrayList6 = arrayList4;
                                    }
                                    str = str4;
                                    nVar2 = nVar4;
                                    z4 = z2;
                                    i5 = i7;
                                    arrayList = arrayList5;
                                    arrayList2 = arrayList6;
                                }
                                i4 = 1;
                                i3 = i;
                            } else {
                                oVar.h(i4);
                            }
                            oVar.i(4);
                            if (oVar.aN()) {
                                arrayList3 = arrayList;
                                arrayList4 = arrayList2;
                                String str5 = str;
                                n nVar5 = nVar2;
                                z2 = z4;
                                int i8 = i5;
                                if (z2) {
                                    arrayList3.add(oVar);
                                    arrayList4.add(oVar);
                                    arrayList6 = arrayList4;
                                    arrayList5 = arrayList3;
                                    sg.bigo.ads.core.d.b.a(oVar, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                                } else {
                                    arrayList5 = arrayList3;
                                    arrayList6 = arrayList4;
                                }
                                str = str5;
                                nVar2 = nVar5;
                                z4 = z2;
                                i5 = i8;
                                arrayList = arrayList5;
                                arrayList2 = arrayList6;
                            } else {
                                arrayList3 = arrayList;
                                arrayList4 = arrayList2;
                                String str6 = str;
                                n nVar6 = nVar2;
                                z2 = z4;
                                int i9 = i5;
                                if (z2) {
                                    arrayList3.add(oVar);
                                    arrayList4.add(oVar);
                                    arrayList6 = arrayList4;
                                    arrayList5 = arrayList3;
                                    sg.bigo.ads.core.d.b.a(oVar, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                                } else {
                                    arrayList5 = arrayList3;
                                    arrayList6 = arrayList4;
                                }
                                str = str6;
                                nVar2 = nVar6;
                                z4 = z2;
                                i5 = i9;
                                arrayList = arrayList5;
                                arrayList2 = arrayList6;
                            }
                            i4 = 1;
                            i3 = i;
                        } else {
                            sg.bigo.ads.common.h.b.a("not match addata=" + oVar.aJ(), aVar);
                        }
                    }
                    ArrayList<o> arrayList7 = arrayList;
                    str2 = str;
                    nVar = nVar2;
                    z = z4;
                    this.d.removeAll(arrayList2);
                    zA = q.a((CharSequence) str2);
                    if (!zA) {
                        aVar.p = str2;
                    }
                    for (o oVar : arrayList7) {
                        if (oVar.aV()) {
                            if (!zA) {
                                oVar.d(str2);
                            }
                            nVar.d = aVar.i;
                            nVar.e = aVar.h();
                            oVar.a(nVar);
                            aVarRemove = this.f.remove(oVar.aI());
                            this.e.remove(oVar);
                            if (aVarRemove != null) {
                                sg.bigo.ads.common.h.b.a("listener is valid, execute AdProxy successful callback", aVar);
                                dVarAA = oVar.aA();
                                if (dVarAA != null) {
                                    dVarAA.a(z);
                                }
                                aVar2 = this.h;
                                if (aVar2.b.containsKey(aVar.f13189a)) {
                                    sg.bigo.ads.common.n.d.a(aVar2.b.get(aVar.f13189a));
                                    aVar2.b.remove(aVar.f13189a);
                                    sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", "stopFillTime: " + aVar.f13189a);
                                }
                                aVar2.b(aVar);
                                aVarRemove.a(i);
                            } else {
                                sg.bigo.ads.common.h.b.a("Not found target listener.", aVar);
                            }
                            oVar.aW();
                        }
                    }
                    if (z) {
                    }
                    e();
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                strExtractMetadata = "";
            }
        } else {
            strExtractMetadata = "";
        }
        str = strExtractMetadata;
        boolean zA3 = b().a();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        for (o oVar2 : this.d) {
            if (a(oVar2, aVar)) {
                sg.bigo.ads.common.h.b.a("not match addata=" + oVar2.aJ(), aVar);
            } else {
                if (i3 != 0) {
                    if (i3 != i4) {
                        oVar2.h(4);
                    } else if (i3 == i5) {
                        oVar2.h(3);
                        oVar2.i(3);
                    }
                    if (oVar2.aN() || !z4) {
                        arrayList3 = arrayList;
                        arrayList4 = arrayList2;
                        String str7 = str;
                        n nVar7 = nVar2;
                        z2 = z4;
                        int i10 = i5;
                        if (z2) {
                            arrayList3.add(oVar2);
                            arrayList4.add(oVar2);
                            arrayList6 = arrayList4;
                            arrayList5 = arrayList3;
                            sg.bigo.ads.core.d.b.a(oVar2, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                        } else {
                            arrayList5 = arrayList3;
                            arrayList6 = arrayList4;
                        }
                        str = str7;
                        nVar2 = nVar7;
                        z4 = z2;
                        i5 = i10;
                        arrayList = arrayList5;
                        arrayList2 = arrayList6;
                    } else {
                        long j2 = aVar.i > 0 ? (aVar.g * 100) / aVar.i : 0L;
                        if (zA3 && !oVar2.aV() && oVar2.c(j2)) {
                            sg.bigo.ads.common.h.b.a("Video partial download done, target callback.", aVar);
                            arrayList.add(oVar2);
                            z3 = z4;
                            i2 = 2;
                            sg.bigo.ads.core.d.b.a(oVar2, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                        } else {
                            z3 = z4;
                            i2 = 2;
                        }
                        str = str;
                        nVar2 = nVar2;
                        z4 = z3;
                        i5 = i2;
                        arrayList = arrayList;
                        arrayList2 = arrayList2;
                    }
                    i4 = 1;
                    i3 = i;
                } else {
                    oVar2.h(i4);
                }
                oVar2.i(4);
                if (oVar2.aN()) {
                    arrayList3 = arrayList;
                    arrayList4 = arrayList2;
                    String str8 = str;
                    n nVar8 = nVar2;
                    z2 = z4;
                    int i11 = i5;
                    if (z2) {
                        arrayList3.add(oVar2);
                        arrayList4.add(oVar2);
                        arrayList6 = arrayList4;
                        arrayList5 = arrayList3;
                        sg.bigo.ads.core.d.b.a(oVar2, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                    } else {
                        arrayList5 = arrayList3;
                        arrayList6 = arrayList4;
                    }
                    str = str8;
                    nVar2 = nVar8;
                    z4 = z2;
                    i5 = i11;
                    arrayList = arrayList5;
                    arrayList2 = arrayList6;
                } else {
                    arrayList3 = arrayList;
                    arrayList4 = arrayList2;
                    String str9 = str;
                    n nVar9 = nVar2;
                    z2 = z4;
                    int i12 = i5;
                    if (z2) {
                        arrayList3.add(oVar2);
                        arrayList4.add(oVar2);
                        arrayList6 = arrayList4;
                        arrayList5 = arrayList3;
                        sg.bigo.ads.core.d.b.a(oVar2, aVar.b, i, j, aVar.g / 1024, aVar.k, 2, "video", aVar.o);
                    } else {
                        arrayList5 = arrayList3;
                        arrayList6 = arrayList4;
                    }
                    str = str9;
                    nVar2 = nVar9;
                    z4 = z2;
                    i5 = i12;
                    arrayList = arrayList5;
                    arrayList2 = arrayList6;
                }
                i4 = 1;
                i3 = i;
            }
        }
        ArrayList<o> arrayList8 = arrayList;
        str2 = str;
        nVar = nVar2;
        z = z4;
        this.d.removeAll(arrayList2);
        zA = q.a((CharSequence) str2);
        if (!zA) {
            aVar.p = str2;
        }
        while (r4.hasNext()) {
            if (oVar.aV()) {
                if (!zA) {
                    oVar.d(str2);
                }
                nVar.d = aVar.i;
                nVar.e = aVar.h();
                oVar.a(nVar);
                aVarRemove = this.f.remove(oVar.aI());
                this.e.remove(oVar);
                if (aVarRemove != null) {
                    sg.bigo.ads.common.h.b.a("listener is valid, execute AdProxy successful callback", aVar);
                    dVarAA = oVar.aA();
                    if (dVarAA != null) {
                        dVarAA.a(z);
                    }
                    aVar2 = this.h;
                    if (aVar2.b.containsKey(aVar.f13189a)) {
                        sg.bigo.ads.common.n.d.a(aVar2.b.get(aVar.f13189a));
                        aVar2.b.remove(aVar.f13189a);
                        sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", "stopFillTime: " + aVar.f13189a);
                    }
                    aVar2.b(aVar);
                    aVarRemove.a(i);
                } else {
                    sg.bigo.ads.common.h.b.a("Not found target listener.", aVar);
                }
                oVar.aW();
            }
        }
        if (z) {
            e();
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x010d  */
    @Override // sg.bigo.ads.common.h.b.a
    public final void a(sg.bigo.ads.common.h.a aVar, String str, long j, long j2) {
        boolean z;
        String str2;
        String str3;
        int i;
        sg.bigo.ads.common.h.b.a("callback download failed error= ".concat(String.valueOf(str)), aVar);
        this.h.b(aVar);
        Iterator<o> it = this.d.iterator();
        boolean zA = q.a((CharSequence) aVar.p);
        while (it.hasNext()) {
            o next = it.next();
            if (a(next, aVar)) {
                if (!zA) {
                    next.d(aVar.p);
                }
                if (next != null) {
                    if ("Unable to download media file.".equals(str) || "internal storage is not enough".equals(str)) {
                        i = 5;
                    } else {
                        i = j2 == 0 ? 0 : 1;
                    }
                    next.i(i);
                }
                if (!aVar.c() || "internal storage is not enough".equalsIgnoreCase(str)) {
                    z = zA;
                    str2 = "internal storage is not enough";
                    a aVarRemove = this.f.remove(next.aI());
                    if (aVarRemove != null) {
                        sg.bigo.ads.core.d.b.a(next, aVar.b, str, j, aVar.g / 1024, 2, "video", aVar.o);
                        sg.bigo.ads.common.h.b.a("listener is valid, execute AdProxy failure callback", aVar);
                        aVarRemove.b(q.a(str, -1));
                        this.f.remove(next.aI());
                    }
                    if (str2.equalsIgnoreCase(str)) {
                        this.e.remove(next);
                    }
                    it.remove();
                } else {
                    a aVar2 = this.f.get(next.aI());
                    if (aVar2 != null) {
                        z = zA;
                        str2 = "internal storage is not enough";
                        sg.bigo.ads.core.d.b.a(next, aVar.b, str, j, aVar.g / 1024, 2, "video", aVar.o);
                        if (next.bc() != 2) {
                            str3 = "video download failed when support fillStrategy, so download backupImg";
                        } else if (aVar.d()) {
                            str3 = "video download failed but filled success, so download backupImg";
                        } else {
                            sg.bigo.ads.common.h.b.a("video download failed and filled fail, so don't download backupImg", aVar);
                        }
                        sg.bigo.ads.common.h.b.a(str3, aVar);
                        aVar2.a();
                    } else {
                        z = zA;
                        str2 = "internal storage is not enough";
                    }
                }
                if (str2.equalsIgnoreCase(str)) {
                    this.e.remove(next);
                }
                it.remove();
            } else {
                it = it;
                z = zA;
            }
            it = it;
            zA = z;
        }
        e();
    }

    public final sg.bigo.ads.core.player.a.d b() {
        sg.bigo.ads.core.player.a.d dVar = this.k;
        if (dVar != null) {
            return dVar;
        }
        sg.bigo.ads.core.player.a.d dVarD = d();
        this.k = dVarD;
        return dVarD;
    }

    @Override // sg.bigo.ads.core.player.a.c
    public final void b(sg.bigo.ads.common.h.a aVar) {
        sg.bigo.ads.common.h.b.a("callback download fill time source=", aVar);
        sg.bigo.ads.common.h.b.a("callback download fill time", aVar);
        Iterator<o> it = this.e.iterator();
        boolean zA = q.a((CharSequence) aVar.p);
        while (it.hasNext()) {
            o next = it.next();
            if (a(next, aVar)) {
                if (!zA) {
                    next.d(aVar.p);
                }
                next.i(2);
                a aVar2 = this.f.get(next.aI());
                if (aVar2 != null) {
                    aVar2.a("", aVar);
                    if (aVar.b == null) {
                        this.f.remove(next.aI());
                    }
                }
                it.remove();
            }
        }
        e();
    }

    public final void c() {
        this.j = System.currentTimeMillis();
        sg.bigo.ads.common.h.b.a("start resource delete task", (sg.bigo.ads.common.h.a) null);
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.b(b.this);
            }
        }, 30000L);
    }

    @Override // sg.bigo.ads.core.player.a.c
    public final void c(sg.bigo.ads.common.h.a aVar) {
        sg.bigo.ads.common.h.b.a("callback download check Process source=", aVar);
        int iG = aVar.g();
        if (aVar.i > 0 && aVar.g * 100 >= aVar.i * ((long) iG)) {
            sg.bigo.ads.common.h.b.a("video download process is enough. download percent: " + aVar.g + ", total size:" + aVar.i, aVar);
            return;
        }
        sg.bigo.ads.common.h.b.a("video download process is not enough. download size: " + aVar.g + ", total size:" + aVar.i + ", begin to download backup", aVar);
        boolean zA = q.a((CharSequence) aVar.p);
        for (o oVar : this.d) {
            if (a(oVar, aVar)) {
                if (!zA) {
                    oVar.d(aVar.p);
                }
                a aVar2 = this.f.get(oVar.aI());
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }
    }
}
