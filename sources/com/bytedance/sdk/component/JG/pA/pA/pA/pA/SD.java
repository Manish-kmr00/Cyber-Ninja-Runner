package com.bytedance.sdk.component.JG.pA.pA.pA.pA;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class SD extends KZx {
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA KZx;
    protected List<String> pA;

    public byte KZx() {
        return (byte) 2;
    }

    public byte pA() {
        return (byte) 1;
    }

    public SD(Context context, com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        super(context);
        this.pA = new ArrayList();
        this.KZx = pAVar;
        if (pAVar == null) {
            this.KZx = com.bytedance.sdk.component.JG.pA.ZZv.Og.pA.KZx();
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.KZx
    public String Og() {
        return omh.SD().ZZv().ZZv();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0024 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0024: PHI (r0v2 int) = (r0v0 int), (r0v6 int) binds: [B:10:0x0029, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0024: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:10:0x0029, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int ZZv() {
        Cursor cursorPA;
        int i = 0;
        try {
            cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursorPA != null) {
                try {
                    cursorPA.moveToFirst();
                    i = cursorPA.getInt(0);
                } catch (Throwable unused) {
                    if (cursorPA != null) {
                        try {
                            cursorPA.close();
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (cursorPA != null) {
                cursorPA.close();
            }
        } catch (Throwable unused3) {
            cursorPA = null;
        }
        return i;
    }

    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(int i, String str) {
        long jPA = com.bytedance.sdk.component.JG.pA.Og.pA.pA(i, ML());
        if (jPA <= 0) {
            jPA = 1;
        } else if (jPA > 100) {
            jPA = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.pA.clear();
        Cursor cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), new String[]{"id", "value", "encrypt"}, null, null, null, null, str + " DESC limit " + jPA);
        if (cursorPA != null) {
            while (cursorPA.moveToNext()) {
                try {
                    try {
                        String string = cursorPA.getString(cursorPA.getColumnIndex("id"));
                        String string2 = cursorPA.getString(cursorPA.getColumnIndex("value"));
                        if (cursorPA.getInt(cursorPA.getColumnIndex("encrypt")) == 1) {
                            string2 = omh.SD().oX().pA(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.pA.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.JG.pA.ZZv.pA.pA pAVar = new com.bytedance.sdk.component.JG.pA.ZZv.pA.pA(string, PangleNetworkBridge.jsonObjectInit(string2));
                            pAVar.Og(KZx());
                            pAVar.pA(pA());
                            arrayList.add(pAVar);
                        }
                    } catch (Throwable unused) {
                    }
                } finally {
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
                }
            }
        }
        return arrayList;
    }

    protected void pA(List<String> list) {
        Og();
        list.size();
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), "DELETE FROM " + Og() + " WHERE " + pA("id", list, 1000, true));
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.vA(), list.size());
        KZx(list);
    }

    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> Og(String str) {
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar = this.KZx;
        if (pAVar == null) {
            return new ArrayList();
        }
        return pA(pAVar.Og(), str);
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
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), "gen_time <? AND retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
    }

    public boolean pA(int i) {
        return this.KZx != null && ZZv() >= this.KZx.pA();
    }

    public static String KZx(String str) {
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
