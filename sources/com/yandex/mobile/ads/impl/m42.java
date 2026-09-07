package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Ascii;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class m42 extends qi0 {
    public static final Parcelable.Creator<m42> CREATOR = new a();
    public final String c;
    public final String d;

    final class a implements Parcelable.Creator<m42> {
        @Override // android.os.Parcelable.Creator
        public final m42 createFromParcel(Parcel parcel) {
            return new m42(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final m42[] newArray(int i) {
            return new m42[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0
    public final String toString() {
        return this.b + ": description=" + this.c + ": value=" + this.d;
    }

    private static ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    m42(Parcel parcel) {
        super((String) x82.a(parcel.readString()));
        this.c = parcel.readString();
        this.d = (String) x82.a(parcel.readString());
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final void a(iw0.a aVar) {
        byte b;
        String str = this.b;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "TAL":
                b = 0;
                break;
            case "TCM":
                b = 1;
                break;
            case "TDA":
                b = 2;
                break;
            case "TP1":
                b = 3;
                break;
            case "TP2":
                b = 4;
                break;
            case "TP3":
                b = 5;
                break;
            case "TRK":
                b = 6;
                break;
            case "TT2":
                b = 7;
                break;
            case "TXT":
                b = 8;
                break;
            case "TYE":
                b = 9;
                break;
            case "TALB":
                b = 10;
                break;
            case "TCOM":
                b = Ascii.VT;
                break;
            case "TDAT":
                b = Ascii.FF;
                break;
            case "TDRC":
                b = Ascii.CR;
                break;
            case "TDRL":
                b = Ascii.SO;
                break;
            case "TEXT":
                b = Ascii.SI;
                break;
            case "TIT2":
                b = Ascii.DLE;
                break;
            case "TPE1":
                b = 17;
                break;
            case "TPE2":
                b = Ascii.DC2;
                break;
            case "TPE3":
                b = 19;
                break;
            case "TRCK":
                b = Ascii.DC4;
                break;
            case "TYER":
                b = Ascii.NAK;
                break;
            default:
                b = -1;
                break;
        }
        try {
            switch (b) {
                case 0:
                case 10:
                    aVar.b(this.d);
                    break;
                case 1:
                case 11:
                    aVar.d(this.d);
                    break;
                case 2:
                case 12:
                    aVar.b(Integer.valueOf(Integer.parseInt(this.d.substring(2, 4)))).a(Integer.valueOf(Integer.parseInt(this.d.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    aVar.c(this.d);
                    break;
                case 4:
                case 18:
                    aVar.a(this.d);
                    break;
                case 5:
                case 19:
                    aVar.e(this.d);
                    break;
                case 6:
                case 20:
                    String str2 = this.d;
                    int i = x82.f10629a;
                    String[] strArrSplit = str2.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                    aVar.h(Integer.valueOf(Integer.parseInt(strArrSplit[0]))).g(strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null);
                    break;
                case 7:
                case 16:
                    aVar.i(this.d);
                    break;
                case 8:
                case 15:
                    aVar.j(this.d);
                    break;
                case 9:
                case 21:
                    aVar.c(Integer.valueOf(Integer.parseInt(this.d)));
                    break;
                case 13:
                    ArrayList arrayListA = a(this.d);
                    int size = arrayListA.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                aVar.a((Integer) arrayListA.get(2));
                            }
                        }
                        aVar.b((Integer) arrayListA.get(1));
                    }
                    aVar.c((Integer) arrayListA.get(0));
                    break;
                case 14:
                    ArrayList arrayListA2 = a(this.d);
                    int size2 = arrayListA2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                aVar.d((Integer) arrayListA2.get(2));
                            }
                        }
                        aVar.e((Integer) arrayListA2.get(1));
                    }
                    aVar.f((Integer) arrayListA2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public m42(String str, String str2, String str3) {
        super(str);
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m42.class != obj.getClass()) {
            return false;
        }
        m42 m42Var = (m42) obj;
        return x82.a(this.b, m42Var.b) && x82.a(this.c, m42Var.c) && x82.a(this.d, m42Var.d);
    }

    public final int hashCode() {
        int iA = v3.a(this.b, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31);
        String str = this.c;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
