package com.applovin.impl;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class y7 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f766a;
    private List b;
    private int c;
    private Uri d;
    private final Set e;
    private r7 f;
    private final Map g;

    private y7() {
        this.f766a = Collections.emptyList();
        this.b = Collections.emptyList();
        this.e = new HashSet();
        this.g = new HashMap();
    }

    public static y7 a(m8 m8Var, y7 y7Var, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        m8 m8VarC;
        r7 r7VarA;
        List listA;
        m8 m8VarC2;
        List listA2;
        m8 m8VarC3;
        int iA;
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (p7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (y7Var == null) {
            try {
                y7Var = new y7(p7Var);
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastVideoCreative", "Error occurred while initializing", th);
                }
                kVar.E().a("VastVideoCreative", th);
                return null;
            }
        }
        if (y7Var.c == 0 && (m8VarC3 = m8Var.c("Duration")) != null && (iA = a(m8VarC3.d(), kVar)) > 0) {
            y7Var.c = iA;
        }
        m8 m8VarC4 = m8Var.c("MediaFiles");
        if (m8VarC4 != null && (listA2 = a(m8VarC4, kVar)) != null && listA2.size() > 0) {
            List list = y7Var.f766a;
            if (list != null) {
                listA2.addAll(list);
            }
            y7Var.f766a = listA2;
        }
        m8 m8VarC5 = m8Var.c("VideoClicks");
        if (m8VarC5 != null) {
            if (y7Var.d == null && (m8VarC2 = m8VarC5.c("ClickThrough")) != null) {
                String strD = m8VarC2.d();
                if (StringUtils.isValidString(strD)) {
                    y7Var.d = Uri.parse(strD);
                }
            }
            x7.a(m8VarC5.a("ClickTracking"), y7Var.e, p7Var, kVar);
        }
        m8 m8VarC6 = m8Var.c("Icons");
        if (m8VarC6 != null && (r7VarA = r7.a((m8VarC = m8VarC6.c("Icon")), kVar)) != null) {
            m8 m8VarC7 = m8VarC.c("IconClicks");
            if (m8VarC7 != null && (listA = m8VarC7.a("IconClickTracking")) != null) {
                x7.a(listA, r7VarA.f605a, p7Var, kVar);
            }
            List listA3 = m8VarC.a("IconViewTracking");
            if (listA3 != null) {
                x7.a(listA3, r7VarA.b, p7Var, kVar);
            }
            y7Var.f = r7VarA;
        }
        x7.a(m8Var, y7Var.g, p7Var, kVar);
        return y7Var;
    }

    public Set b() {
        return this.e;
    }

    public Uri c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public Map e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y7)) {
            return false;
        }
        y7 y7Var = (y7) obj;
        if (this.c != y7Var.c) {
            return false;
        }
        List list = this.f766a;
        if (list == null ? y7Var.f766a != null : !list.equals(y7Var.f766a)) {
            return false;
        }
        Uri uri = this.d;
        if (uri == null ? y7Var.d != null : !uri.equals(y7Var.d)) {
            return false;
        }
        Set set = this.e;
        if (set == null ? y7Var.e != null : !set.equals(y7Var.e)) {
            return false;
        }
        Map map = this.g;
        Map map2 = y7Var.g;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public r7 f() {
        return this.f;
    }

    public List g() {
        return this.f766a;
    }

    public int hashCode() {
        List list = this.f766a;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.c) * 31;
        Uri uri = this.d;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set set = this.e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.g;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f766a + ", durationSeconds=" + this.c + ", destinationUri=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.g + ", industryIcon=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    private y7(p7 p7Var) {
        this.f766a = Collections.emptyList();
        this.b = Collections.emptyList();
        this.e = new HashSet();
        this.g = new HashMap();
        this.b = p7Var.f();
    }

    private static int a(String str, com.applovin.impl.sdk.k kVar) {
        try {
            List<String> listExplode = CollectionUtils.explode(str, ":");
            if (listExplode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(listExplode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(listExplode.get(1))) + ((long) StringUtils.parseInt(listExplode.get(2))));
            }
        } catch (Throwable unused) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List a(m8 m8Var, com.applovin.impl.sdk.k kVar) {
        List listA = m8Var.a("MediaFile");
        ArrayList arrayList = new ArrayList(listA.size());
        List<String> listExplode = CollectionUtils.explode((String) kVar.a(v4.I4));
        List<String> listExplode2 = CollectionUtils.explode((String) kVar.a(v4.H4));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            z7 z7VarA = z7.a((m8) it.next(), kVar);
            if (z7VarA != null) {
                try {
                    String strC = z7VarA.c();
                    if (StringUtils.isValidString(strC) && !listExplode.contains(strC)) {
                        arrayList.add(z7VarA);
                    } else {
                        if (((Boolean) kVar.a(v4.J4)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(z7VarA.e().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !listExplode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(z7VarA);
                            }
                        }
                        kVar.O();
                        if (com.applovin.impl.sdk.o.a()) {
                            kVar.O().k("VastVideoCreative", "Video file not supported: " + z7VarA);
                        }
                    }
                } catch (Throwable th) {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("VastVideoCreative", "Failed to validate video file: " + z7VarA, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public z7 a(long j) {
        List list = this.f766a;
        z7 z7Var = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<z7> arrayList = new ArrayList(3);
        for (String str : this.b) {
            for (z7 z7Var2 : this.f766a) {
                String strC = z7Var2.c();
                if (StringUtils.isValidString(strC) && str.equalsIgnoreCase(strC)) {
                    arrayList.add(z7Var2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f766a;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.applovin.impl.y7$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return y7.a((z7) obj, (z7) obj2);
            }
        });
        for (z7 z7Var3 : arrayList) {
            if (z7Var3.b() > j) {
                break;
            }
            z7Var = z7Var3;
        }
        return z7Var != null ? z7Var : (z7) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(z7 z7Var, z7 z7Var2) {
        return Long.compare(z7Var.b(), z7Var2.b());
    }

    public static y7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        y7 y7Var = new y7();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "video_files", new JSONArray());
        y7Var.f766a = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            z7 z7VarA = z7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (z7VarA != null) {
                y7Var.f766a.add(z7VarA);
            }
        }
        y7Var.b = JsonUtils.getStringList(jSONObject, "preferred_video_file_types", Collections.emptyList());
        y7Var.c = JsonUtils.getInt(jSONObject, "duration_seconds", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        y7Var.d = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            v7 v7VarA = v7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (v7VarA != null) {
                y7Var.e.add(v7VarA);
            }
        }
        y7Var.f = r7.a(JsonUtils.getJSONObject(jSONObject, "industry_icon", (JSONObject) null), kVar);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "event_trackers", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            HashSet hashSet = new HashSet();
            String next = itKeys.next();
            JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject2, next, new JSONArray());
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                v7 v7VarA2 = v7.a(JsonUtils.getJSONObject(jSONArray3, i3, (JSONObject) null), kVar);
                if (v7VarA2 != null) {
                    hashSet.add(v7VarA2);
                }
            }
            y7Var.g.put(next, hashSet);
        }
        return y7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List list = this.f766a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((z7) it.next()).a());
            }
        }
        JsonUtils.putJsonArray(jSONObject, "video_files", jSONArray);
        JsonUtils.putJsonArray(jSONObject, "preferred_video_file_types", new JSONArray((Collection) this.b));
        JsonUtils.putInt(jSONObject, "duration_seconds", this.c);
        Uri uri = this.d;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            jSONArray2.put(((v7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray2);
        r7 r7Var = this.f;
        if (r7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "industry_icon", r7Var.a());
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.g.keySet()) {
            Set set = (Set) this.g.get(str);
            if (set != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((v7) it3.next()).a());
                }
                JsonUtils.putJsonArray(jSONObject2, str, jSONArray3);
            }
        }
        JsonUtils.putJSONObject(jSONObject, "event_trackers", jSONObject2);
        return jSONObject;
    }
}
