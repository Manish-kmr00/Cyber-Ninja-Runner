package com.bytedance.sdk.component.JG.pA.pA.pA.pA;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class pA extends KZx {
    private final Context KZx;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ZZv;
    protected List<String> pA;

    public byte KZx() {
        return (byte) 2;
    }

    public byte ZZv() {
        return (byte) 0;
    }

    public pA(Context context, com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        super(context);
        this.pA = new ArrayList();
        this.KZx = context;
        this.ZZv = pAVar;
        if (pAVar == null) {
            this.ZZv = com.bytedance.sdk.component.JG.pA.ZZv.Og.pA.KZx();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0025 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
  0x0025: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0030, B:6:0x0023] A[DONT_GENERATE, DONT_INLINE]
  0x0025: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0030, B:6:0x0023] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int pA() {
        Cursor cursorPA = null;
        int i = 0;
        try {
            cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursorPA != null) {
                cursorPA.moveToFirst();
                i = cursorPA.getInt(0);
            }
        } catch (Exception unused) {
        } finally {
            if (cursorPA != null) {
                try {
                    cursorPA.close();
                } catch (Exception unused2) {
                }
            }
        }
        return i;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.KZx
    public String Og() {
        com.bytedance.sdk.component.JG.pA.pA.ML mlZZv = omh.SD().ZZv();
        if (mlZZv != null) {
            return mlZZv.Og();
        }
        return null;
    }

    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(int i, String str) {
        String str2;
        String[] strArr;
        byte b;
        String str3;
        Cursor cursorPA;
        long jPA = com.bytedance.sdk.component.JG.pA.Og.pA.pA(i, ML());
        Og();
        if (jPA <= 0) {
            jPA = 1;
        } else if (jPA > 100) {
            jPA = 100;
        }
        String str4 = str + " DESC limit " + jPA;
        ArrayList arrayList = new ArrayList();
        this.pA.clear();
        long jABv = omh.SD().aBv();
        if (jABv > 0) {
            strArr = new String[]{String.valueOf(System.currentTimeMillis() - jABv)};
            str2 = "gen_time>?";
        } else {
            str2 = null;
            strArr = null;
        }
        if (com.bytedance.sdk.component.JG.pA.KZx.pA.ZZv() && ZZv() == 3) {
            b = 3;
            cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), new String[]{"id", "value", "encrypt", "channel"}, str2, strArr, null, null, str4);
            str3 = "id";
        } else {
            b = 3;
            str3 = "id";
            cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), new String[]{"id", "value", "encrypt"}, str2, strArr, null, null, str4);
        }
        if (cursorPA != null) {
            try {
                com.bytedance.sdk.component.JG.pA.ML mlOX = omh.SD().oX();
                while (cursorPA.moveToNext()) {
                    try {
                        String string = cursorPA.getString(cursorPA.getColumnIndex(str3));
                        String string2 = cursorPA.getString(cursorPA.getColumnIndex("value"));
                        int i2 = cursorPA.getInt(cursorPA.getColumnIndex("encrypt"));
                        int i3 = (com.bytedance.sdk.component.JG.pA.KZx.pA.ZZv() && ZZv() == b) ? cursorPA.getInt(cursorPA.getColumnIndex("channel")) : 0;
                        if (i2 == 1) {
                            try {
                                string2 = mlOX.pA(string2);
                            } catch (Throwable th) {
                                th = th;
                                th.getMessage();
                            }
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.pA.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(string2);
                            com.bytedance.sdk.component.JG.pA.ZZv.pA.pA pAVar = new com.bytedance.sdk.component.JG.pA.ZZv.pA.pA(string, jSONObjectJsonObjectInit);
                            pAVar.pA(ZZv());
                            pAVar.Og(KZx());
                            if (com.bytedance.sdk.component.JG.pA.KZx.pA.ZZv() && ZZv() == b) {
                                pAVar.pA(i3);
                            }
                            com.bytedance.sdk.component.JG.pA.KZx.pA.pA(jSONObjectJsonObjectInit, pAVar);
                            arrayList.add(pAVar);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (cursorPA != null) {
                    try {
                        cursorPA.close();
                        if (!this.pA.isEmpty()) {
                            pA(this.pA);
                            this.pA.clear();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th3) {
                if (cursorPA != null) {
                    try {
                        cursorPA.close();
                        if (!this.pA.isEmpty()) {
                            pA(this.pA);
                            this.pA.clear();
                        }
                    } catch (Exception unused2) {
                    }
                }
                throw th3;
            }
        }
        Og();
        arrayList.size();
        return arrayList;
    }

    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(String str) {
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar = this.ZZv;
        if (pAVar == null) {
            return new ArrayList();
        }
        return pA(pAVar.Og(), str);
    }

    protected void pA(List<String> list) {
        Og();
        list.size();
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), "DELETE FROM " + Og() + " WHERE " + pA("id", list, 1000, true));
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.vA(), list.size());
        KZx(list);
    }

    public void Og(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar : list) {
            linkedList.add(pAVar.KZx());
            com.bytedance.sdk.component.JG.pA.KZx.pA.SGo(pAVar);
        }
        Og();
        linkedList.size();
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), "DELETE FROM " + Og() + " WHERE " + pA("id", linkedList, 1000, true));
        KZx(linkedList);
    }

    public void pA(int i, long j) {
        Og(i, j);
    }

    private void Og(int i, long j) {
        if (j > 0 || i > 0) {
            com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), "gen_time <? OR retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
            Og();
        }
    }

    public boolean pA(int i) {
        if (this.ZZv == null) {
            return false;
        }
        int iPA = pA();
        int iPA2 = this.ZZv.pA();
        Og();
        if (com.bytedance.sdk.component.JG.pA.KZx.pA.KZx() && (i == 1 || i == 2)) {
            return iPA > 0;
        }
        return iPA >= iPA2;
    }

    public static String Og(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private static String pA(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strPA = pA(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strPA).append("')");
        }
        return pA(sb.toString(), str + str2 + "('')");
    }

    private static String pA(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
