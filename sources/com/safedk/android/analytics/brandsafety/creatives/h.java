package com.safedk.android.analytics.brandsafety.creatives;

import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.LinkedHashSetWithItemLimit;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.k;
import com.safedk.android.utils.n;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public class h extends e {
    private static final String d = "VastAdParser";
    private static final CharSequence e = "acao/yes";
    public static final LinkedHashSetWithItemLimit<i> c = new LinkedHashSetWithItemLimit<>(50);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8080a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private List<Pair<String, String>> i;
        private List<String> j;
        private List<String> k;
        private List<String> l;
        private List<String> m;
        private List<String> n;
        private List<String> o;
        private List<String> p;
        private List<String> q;
        private List<String> r;
        private List<String> s;

        a(String str, String str2, String str3, String str4, ArrayList<String> arrayList, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8, boolean z, String str5, List<String> list9, String str6, List<Pair<String, String>> list10) {
            this.f8080a = false;
            this.k = new ArrayList();
            this.l = new ArrayList();
            this.m = new ArrayList();
            this.n = new ArrayList();
            this.o = new ArrayList();
            this.d = str;
            this.e = str2;
            this.b = str3;
            this.c = str4;
            this.k = arrayList;
            this.l = list;
            this.m = list2;
            this.n = list3;
            this.o = list4;
            this.p = list5;
            this.q = list6;
            this.r = list7;
            this.s = list8;
            this.f8080a = z;
            this.g = z ? str5 : null;
            this.j = list9;
            this.h = str6;
            this.i = list10;
            n.b(h.d, "Vast ad created:\nvastAdId=" + str + "\nadSystem=" + str2 + "\nclickUrl=" + str3 + "\nvideoUrl=" + str4 + "\nprefetchResourceUrls=" + (arrayList != null ? arrayList.toString() : "null") + "\nstaticResourceUrls=" + (list != null ? list.toString() : "null") + "\nscriptResourceUrls=" + (list2 != null ? list2.toString() : "null") + "\nhtmlResourceUrls=" + (list3 != null ? list3.toString() : "null") + "\nvideoCompletedUrls=" + (list5 != null ? list5.toString() : "null") + "\nvideoTrackingEventUrls=" + (list6 != null ? list6.toString() : "null") + "\nclickTrackingUrls=" + (list7 != null ? list7.toString() : "null") + "\ncompanionClickTrackingUrls=" + (list8 != null ? list8.toString() : "null") + "\ncontainsMediaFileWithJsAppAttribute=" + z + "\nadParameters=" + str5 + "\nimpressionUrls=" + (list9 != null ? list9.toString() : "null") + "\nmediaUrlList=" + (list10 != null ? list10.toString() : "null"));
        }

        a(String str, String str2, String str3, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
            this.f8080a = false;
            this.k = new ArrayList();
            this.l = new ArrayList();
            this.m = new ArrayList();
            this.n = new ArrayList();
            this.o = new ArrayList();
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.j = list;
            this.p = list2;
            this.q = list3;
            this.r = list4;
            this.s = list5;
            n.b(h.d, "Vast ad created:\nvastAdId=" + str + "\nadSystem=" + str2 + "\nvastAdUri=" + str3 + "\nvideoCompletedUrls=" + (list2 != null ? list2.toString() : "null") + "\nvideoTrackingEventUrls=" + (list3 != null ? list3.toString() : "null") + "\nclickTrackingUrls=" + (list4 != null ? list4.toString() : "null") + "\ncompanionClickTrackingUrls=" + (list5 != null ? list5.toString() : "null") + "\nimpressionUrls=" + (list != null ? list.toString() : "null"));
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.d;
        }

        public void a(String str) {
            this.d = str;
        }

        public String d() {
            return this.e;
        }

        public void b(String str) {
            this.e = str;
        }

        public String e() {
            return this.f;
        }

        public void c(String str) {
            this.f = str;
        }

        public String f() {
            return this.g;
        }

        public String g() {
            return this.h;
        }

        public List<String> h() {
            ArrayList arrayList = new ArrayList();
            if (this.i != null) {
                Iterator<Pair<String, String>> it = this.i.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().second);
                }
            }
            return arrayList;
        }

        public List<String> i() {
            return this.j;
        }

        public void a(List<String> list) {
            this.j = list;
        }

        public List<String> j() {
            return this.k;
        }

        public List<String> k() {
            return this.l;
        }

        public List<String> l() {
            return this.m;
        }

        public List<String> m() {
            return this.n;
        }

        public List<String> n() {
            return this.o;
        }

        public List<String> o() {
            return this.p;
        }

        public void b(List<String> list) {
            this.p = list;
        }

        public List<String> p() {
            return this.q;
        }

        public void c(List<String> list) {
            this.q = list;
        }

        public List<String> q() {
            return this.r;
        }

        public void d(List<String> list) {
            this.r = list;
        }

        public List<String> r() {
            return this.s;
        }

        public void e(List<String> list) {
            this.s = list;
        }

        public boolean s() {
            return this.f8080a && !t();
        }

        private boolean t() {
            for (Pair<String, String> pair : this.i) {
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                if (str.startsWith("video")) {
                    Logger.d(h.d, "video file exists: " + str2);
                    return true;
                }
            }
            n.b(h.d, "video file doesn't exist: " + this.i);
            return false;
        }

        public String toString() {
            return "vastAdId=" + (this.d == null ? "null" : this.d) + ", adSystem=" + (this.e == null ? "null" : this.e) + ", clickUrl=" + (this.b == null ? "null" : this.b) + ", videoUrl=" + (this.c == null ? "null" : this.c) + ", vastAdUri=" + (this.f == null ? "null" : this.f) + ", mediaUrlList=" + (this.i == null ? "null" : this.i.toString());
        }
    }

    public static ArrayList<a> a(String str, boolean z, String str2) {
        ArrayList<a> arrayList = new ArrayList<>();
        List<String> listA = n.a(com.safedk.android.utils.g.w(), str);
        if (listA.isEmpty()) {
            Logger.d(d, "No ad blocks detected, exiting");
            return arrayList;
        }
        Iterator<String> it = listA.iterator();
        while (it.hasNext()) {
            a aVarB = b(it.next(), z, str2);
            if (aVarB != null) {
                arrayList.add(aVarB);
            }
        }
        return arrayList;
    }

    private static String a(String str, String str2) throws UnsupportedEncodingException {
        if (CreativeInfoManager.a(str2, AdNetworkConfiguration.SHOULD_DECODE_AD_TAG_TWICE, false) && str.contains("%25")) {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            Logger.d(d, "Decoding URL - url was decoded once");
            if (strDecode.contains("%25")) {
                strDecode = URLDecoder.decode(strDecode, "UTF-8");
                Logger.d(d, "Decoding URL - url was decoded twice");
            }
            return strDecode;
        }
        return str;
    }

    public static a b(String str, boolean z, String str2) {
        try {
            n.b(d, "vast ad info parse started, response = " + str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (a(com.safedk.android.utils.g.u(), str, -1, z).isEmpty()) {
                Logger.d(d, "No ad blocks detected, exiting");
                return null;
            }
            String strA = null;
            String strA2 = null;
            List<String> listA = a(com.safedk.android.utils.g.v(), str, 2, z);
            if (!listA.isEmpty()) {
                strA = a(listA.get(0), false);
                Logger.d(d, "Ad ID detected: " + strA);
            }
            String strA3 = null;
            List<String> listA2 = a(com.safedk.android.utils.g.m(), str, 1, z);
            if (!listA2.isEmpty()) {
                strA3 = a(CreativeInfoManager.d(str2), a(k.f(a(listA2.get(0), z)), str2));
                n.b(d, "Vast ad uri added to followed urls : " + strA3);
                a(new f(strA3));
            }
            List<String> listA3 = a(com.safedk.android.utils.g.s(), str, 1, z);
            if (!listA3.isEmpty()) {
                strA2 = a(listA3.get(0), false);
                Logger.d(d, "Ad system detected : " + strA2);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = a(com.safedk.android.utils.g.d(), str, 1, z).iterator();
            while (it.hasNext()) {
                String strReplace = k.f(a(it.next(), z)).replace("\\/", RemoteSettings.FORWARD_SLASH_STRING);
                arrayList.add(strReplace);
                Logger.d(d, "impression url identified : " + strReplace);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            List<String> listA4 = a(com.safedk.android.utils.g.g(), str, 1, 2, z);
            for (int i = 0; i < listA4.size(); i += 2) {
                listA4.get(i);
                arrayList2.add(k.f(a(listA4.get(i + 1), z)));
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator<String> it2 = a(com.safedk.android.utils.g.f(), str, 1, z).iterator();
            while (it2.hasNext()) {
                arrayList4.add(k.f(a(it2.next(), z)));
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator<String> it3 = a(com.safedk.android.utils.g.e(), str, 1, z).iterator();
            while (it3.hasNext()) {
                arrayList5.add(k.f(a(it3.next(), z)));
            }
            if (strA3 != null) {
                return a(strA3, strA, strA2, arrayList, arrayList3, arrayList2, arrayList4, arrayList5);
            }
            return a(str, z, str, strA, strA2, arrayList, arrayList3, arrayList2, arrayList4, arrayList5);
        } catch (Throwable th) {
            new CrashReporter().caughtException(th);
            Logger.e(d, "failed to parse vast data", th);
            return null;
        }
    }

    private static a a(String str, String str2, String str3, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        if (str == null) {
            return null;
        }
        Logger.d(d, "vast ad uri detected: " + str);
        return new a(str2, str3, str, list, list2, list3, list4, list5);
    }

    private static a a(String str, boolean z, String str2, String str3, String str4, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        String strA;
        String str5;
        String str6;
        String str7;
        String str8;
        Logger.d(d, "no vast ad tag uri");
        boolean z2 = false;
        String str9 = null;
        String str10 = null;
        String strA2 = null;
        String strA3 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        List<String> listA = a(com.safedk.android.utils.g.t(), str2, 0, false);
        Logger.d(d, "Number of creatives XML elements: " + listA.size());
        if (listA.isEmpty()) {
            n.b(d, "Number of creatives XML elements is 0, the xml is:\n" + str2);
        }
        String str11 = null;
        for (String str12 : listA) {
            List<String> listA2 = a(com.safedk.android.utils.g.n(), str12, 1, false);
            if (!listA2.isEmpty()) {
                Logger.d(d, "companion click url list: " + listA2.toString());
                strA = a(listA2.get(0), true);
            } else {
                Logger.d(d, "companion click url list is empty");
                strA = str11;
            }
            List<String> listA3 = a(com.safedk.android.utils.g.r(), str12, 1, false);
            if (!listA3.isEmpty()) {
                Logger.d(d, "click url list: " + listA3);
                strA3 = a(listA3.get(0), z);
                if (strA == null) {
                    strA = a(listA3.get(0), true);
                }
                Iterator<String> it = listA3.iterator();
                while (it.hasNext()) {
                    arrayList.add(a(it.next(), z));
                }
                str5 = strA;
            } else {
                Logger.d(d, "click url list is empty");
                str5 = strA;
            }
            if (!TextUtils.isEmpty(str5)) {
                str9 = str5;
            }
            for (String str13 : a(com.safedk.android.utils.g.p(), str12, -1, z)) {
                List<String> listA4 = a(com.safedk.android.utils.g.o(), str13, -1, z);
                List<String> listA5 = a(com.safedk.android.utils.g.p(), str13, 1, z);
                String strA4 = a(listA5.get(0), z);
                List<String> listA6 = a(com.safedk.android.utils.g.q(), str13, 1, z);
                if (listA6.isEmpty()) {
                    listA6 = a(com.safedk.android.utils.g.q(), str13.replace(" ", ""), 1, z);
                }
                String str14 = !listA6.isEmpty() ? listA6.get(0) : "";
                if (str14.isEmpty()) {
                    Logger.d(d, "empty media type: " + str13);
                }
                if (!listA4.isEmpty()) {
                    z2 = true;
                    arrayList.add(strA4);
                    Logger.d(d, "contains media file with JS app attribute");
                } else if (!listA5.isEmpty()) {
                    arrayList5.add(new Pair(str14, strA4));
                    Logger.d(d, "adding media file : " + strA4);
                } else {
                    Logger.d(d, "cannot detect media resource in. skipping");
                }
            }
            List<String> listA7 = a(com.safedk.android.utils.g.h(), str12, 1, z);
            if (!listA7.isEmpty()) {
                strA2 = a(listA7.get(0), z);
                if (n.n(strA2)) {
                    n.b(d, "ad parameters is JSON : " + strA2);
                    ArrayList<String> arrayListG = n.g(strA2);
                    if (!arrayListG.isEmpty()) {
                        for (String str15 : arrayListG) {
                            Logger.d(d, "ad parameters media url : " + str15);
                            if (n.s(str15)) {
                                Logger.d(d, "ad parameters media url is video url : " + str15);
                                arrayList5.add(new Pair("video/*", a(str15, z)));
                            }
                        }
                    }
                } else {
                    n.b(d, "found ad parameters = " + strA2);
                }
            }
            List<String> listA8 = a(com.safedk.android.utils.g.l(), str2, 1, z);
            if (!listA8.isEmpty()) {
                arrayList.add("element:ytId:" + listA8.get(0));
                Logger.d(d, "handle no vast ad Uri - added element to prefetch collection: " + listA8.get(0));
            }
            Iterator it2 = arrayList5.iterator();
            String str16 = null;
            String str17 = null;
            String str18 = null;
            while (true) {
                if (!it2.hasNext()) {
                    str6 = null;
                    break;
                }
                Pair pair = (Pair) it2.next();
                String strA5 = a((Pair<String, String>) pair);
                String str19 = (String) pair.second;
                Logger.d(d, "found extension : " + strA5 + " for media: " + pair);
                if (((String) pair.first).contains("video") && str19.contains(e)) {
                    if (strA5 != null && strA5.equals(n.d)) {
                        Logger.d(d, "found google videoUrl mp4: " + pair);
                        str6 = str19;
                        break;
                    }
                    Logger.d(d, "found google videoUrl regular: " + pair);
                    str7 = str19;
                } else {
                    str7 = str16;
                }
                if (strA5 != null && strA5.equals(n.d) && str18 == null) {
                    Logger.d(d, "setting first mp4 media file as: " + pair);
                    str18 = str19;
                }
                if (strA5 == null || strA5.equals(n.d) || str17 != null) {
                    str8 = str17;
                } else {
                    Logger.d(d, "setting first non-mp4 media file as: " + pair);
                    str8 = str19;
                }
                str16 = str7;
                str17 = str8;
            }
            if (str6 == null) {
                if (str16 != null) {
                    str6 = str16;
                } else if (str18 != null) {
                    Logger.d(d, "found first MP4 videoUrl : " + str18);
                    str6 = str18;
                } else if (str17 != null) {
                    Logger.d(d, "found first non-MP4 videoUrl : " + str17);
                    str6 = str17;
                }
            }
            if (!TextUtils.isEmpty(str6)) {
                if (arrayList.contains(str6)) {
                    str10 = str6;
                } else {
                    arrayList.add(str6);
                    str10 = str6;
                }
            } else {
                Logger.d(d, "VAST ad did NOT found video url");
            }
            if (!TextUtils.isEmpty(str5)) {
                Logger.d(d, "VAST ad found click Url = " + str5);
            }
            str11 = str5;
        }
        a(str, z, arrayList2, com.safedk.android.utils.g.k());
        a(str, z, arrayList3, com.safedk.android.utils.g.j());
        a(str, z, arrayList4, com.safedk.android.utils.g.i());
        List<String> listA9 = a(com.safedk.android.utils.g.i(), str, 1, z);
        if (str9 != null) {
            arrayList.remove(str9);
        }
        return new a(str3, str4, str9, str10, arrayList, arrayList2, arrayList3, arrayList4, listA9, list2, list3, list4, list5, z2, strA2, list, strA3, arrayList5);
    }

    private static void a(String str, boolean z, List<String> list, Pattern pattern) {
        Iterator<String> it = a(pattern, str, 1, z).iterator();
        while (it.hasNext()) {
            String strZ = n.z(it.next());
            List<String> listA = a(com.safedk.android.utils.g.x(), strZ, 1, z);
            if (!listA.isEmpty()) {
                strZ = listA.get(0);
            }
            try {
                new URL(strZ);
                list.add(strZ);
            } catch (MalformedURLException e2) {
                Logger.d(d, "resources inner text is malformed. cannot add this url to the resources list");
            }
        }
    }

    public static boolean a(String str) {
        return com.safedk.android.utils.g.b().matcher(str).find();
    }

    public static void a(String str, String[] strArr, String str2) {
        List<String> listA = a(com.safedk.android.utils.g.m(), str, 1, true);
        if (!listA.isEmpty()) {
            String strF = k.f(a(listA.get(0), true));
            n.b(d, "Vast ad uri added to followed urls : " + strF);
            a(new f(a(strArr, strF)));
        }
    }

    private static String a(String[] strArr, String str) {
        if (strArr != null && strArr.length > 0) {
            String strA = k.a(str, strArr);
            Logger.d(d, "Vast ad uri, query params removed : " + strArr);
            return strA;
        }
        return str;
    }

    protected static void a(i iVar) {
        c.add(iVar);
    }

    protected static String a(Pair<String, String> pair) {
        String[] strArrSplit = ((String) pair.first).split(RemoteSettings.FORWARD_SLASH_STRING);
        if (strArrSplit.length <= 1 || !"video".equals(strArrSplit[0])) {
            return null;
        }
        return strArrSplit[1];
    }
}
