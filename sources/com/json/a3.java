package com.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public class a3 implements Parcelable {
    public static final Parcelable.Creator<a3> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3508a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private ArrayList<String> f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private ArrayList<String> i;
    private String j;
    private String k;
    private Map<String, String> l;

    class a implements Parcelable.Creator<a3> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a3 createFromParcel(Parcel parcel) {
            return new a3(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a3[] newArray(int i) {
            return new a3[i];
        }
    }

    public a3() {
        i();
    }

    private a3(Parcel parcel) {
        i();
        try {
            this.d = parcel.readByte() != 0;
            this.e = parcel.readInt();
            this.f3508a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = a(parcel.readString());
        } catch (Throwable th) {
            o9.d().a(th);
            i();
        }
    }

    /* synthetic */ a3(Parcel parcel, a aVar) {
        this(parcel);
    }

    private Map<String, String> a(String str) {
        IronLog ironLog;
        String string;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
            Iterator<String> itKeys = jSONObjectJsonObjectInit.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectJsonObjectInit.getString(next));
            }
        } catch (JSONException e) {
            o9.d().a(e);
            ironLog = IronLog.INTERNAL;
            string = e.toString();
            ironLog.error(string);
        } catch (Throwable th) {
            o9.d().a(th);
            ironLog = IronLog.INTERNAL;
            string = th.toString();
            ironLog.error(string);
        }
        return map;
    }

    private void i() {
        this.d = false;
        this.e = -1;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = "";
        this.j = "";
        this.l = new HashMap();
    }

    public void a() {
        this.e = -1;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.g.remove(str);
        } else if (this.g.indexOf(str) == -1) {
            this.g.add(str);
        }
    }

    public void a(Map<String, String> map) {
        this.l = map;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public String b() {
        return this.c;
    }

    public void b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.i.remove(str);
        } else if (this.i.indexOf(str) == -1) {
            this.i.add(str);
        }
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && this.g.indexOf(str) > -1;
    }

    public int c() {
        return this.e;
    }

    public void c(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.f.remove(str);
        } else if (this.f.indexOf(str) == -1) {
            this.f.add(str);
        }
    }

    public boolean c(String str) {
        return !TextUtils.isEmpty(str) && this.i.indexOf(str) > -1;
    }

    public String d() {
        return this.j;
    }

    public void d(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.h.remove(str);
        } else if (this.h.indexOf(str) == -1) {
            this.h.add(str);
        }
    }

    public boolean d(String str) {
        return !TextUtils.isEmpty(str) && this.f.indexOf(str) > -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> e() {
        return this.l;
    }

    public boolean e(String str) {
        return !TextUtils.isEmpty(str) && this.h.indexOf(str) > -1;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.c = str;
    }

    public String g() {
        return this.f3508a;
    }

    public void g(String str) {
        this.j = str;
    }

    public String h() {
        return this.b;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.f3508a = str;
    }

    public void j(String str) {
        this.b = str;
    }

    public boolean j() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:").append(this.d).append(", ");
            sb.append("displayedProduct:").append(this.e).append(", ");
            sb.append("ISReportInit:").append(this.f).append(", ");
            sb.append("ISInitSuccess:").append(this.g).append(", ");
            sb.append("ISAppKey").append(this.j).append(", ");
            sb.append("ISUserId").append(this.k).append(", ");
            sb.append("ISExtraParams").append(this.l).append(", ");
        } catch (Throwable th) {
            o9.d().a(th);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.e);
            parcel.writeString(this.f3508a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(new JSONObject(this.l).toString());
        } catch (Throwable th) {
            o9.d().a(th);
        }
    }
}
