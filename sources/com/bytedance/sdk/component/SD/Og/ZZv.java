package com.bytedance.sdk.component.SD.Og;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.Bzk;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.JG;
import com.bytedance.sdk.component.Og.pA.Sn;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.bytedance.sdk.component.Og.pA.oX;
import com.bytedance.sdk.component.utils.WV;
import com.json.cc;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv extends KZx {
    Sn pA;

    public ZZv(BSW bsw) {
        super(bsw);
        this.pA = null;
    }

    public void ZZv(String str) {
        if (TextUtils.isEmpty(str)) {
            str = JsonUtils.EMPTY_JSON;
        }
        this.pA = Sn.pA(Bzk.pA("application/json; charset=utf-8"), str);
    }

    public void pA(JSONObject jSONObject) {
        String string;
        if (jSONObject == null) {
            string = JsonUtils.EMPTY_JSON;
        } else {
            string = jSONObject.toString();
        }
        this.pA = Sn.pA(Bzk.pA("application/json; charset=utf-8"), string);
    }

    public void pA(String str, byte[] bArr) {
        this.pA = Sn.pA(Bzk.pA(str), bArr);
    }

    public void pA(final com.bytedance.sdk.component.SD.pA.pA pAVar) {
        try {
            Wx.pA pAVar2 = new Wx.pA();
            if (TextUtils.isEmpty(this.omh)) {
                pAVar.pA(this, new IOException("Url is Empty"));
                return;
            }
            if (!TextUtils.isEmpty(this.ML)) {
                pAVar2.pA(this.ML);
            }
            if (this.JG > 0) {
                pAVar2.pA(this.JG);
            }
            pAVar2.Og(this.omh);
            if (this.pA == null) {
                if (pAVar != null) {
                    pAVar.pA(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                pA(pAVar2);
                pAVar2.pA((Object) KZx());
                this.KZx.pA(pAVar2.pA(this.pA).Og()).pA(new com.bytedance.sdk.component.Og.pA.KZx() { // from class: com.bytedance.sdk.component.SD.Og.ZZv.1
                    @Override // com.bytedance.sdk.component.Og.pA.KZx
                    public void pA(com.bytedance.sdk.component.Og.pA.Og og, IOException iOException) {
                        com.bytedance.sdk.component.SD.pA.pA pAVar3 = pAVar;
                        if (pAVar3 != null) {
                            pAVar3.pA(ZZv.this, iOException);
                        }
                    }

                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.bytedance.sdk.component.Og.pA.KZx
                    public void pA(com.bytedance.sdk.component.Og.pA.Og og, DX dx) throws IOException {
                        com.bytedance.sdk.component.SD.Og og2;
                        com.bytedance.sdk.component.SD.pA.pA pAVar3 = pAVar;
                        if (pAVar3 != null) {
                            if (dx == null) {
                                pAVar3.pA(ZZv.this, new IOException("No response"));
                                return;
                            }
                            com.bytedance.sdk.component.SD.Og og3 = null;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                JG jgSD = dx.SD();
                                if (jgSD != null) {
                                    for (int i = 0; i < jgSD.pA(); i++) {
                                        String strPA = jgSD.pA(i);
                                        String strOg = jgSD.Og(i);
                                        map.put(strPA, strOg);
                                        if (strPA != null && strPA.equalsIgnoreCase("content-type")) {
                                            map.put("content-type", strOg == null ? "" : strOg.toLowerCase());
                                        }
                                    }
                                }
                                try {
                                    if (com.bytedance.sdk.component.SD.ZZv.pA.pA(map)) {
                                        byte[] bArrZZv = dx.JG().ZZv();
                                        og2 = new com.bytedance.sdk.component.SD.Og(dx.ZZv(), dx.KZx(), dx.ML(), map, null, dx.Og(), dx.pA());
                                        og2.pA(bArrZZv);
                                    } else if (ZZv.this.Bzk) {
                                        byte[] bArrZZv2 = dx.JG().ZZv();
                                        ZZv zZv = ZZv.this;
                                        og2 = new com.bytedance.sdk.component.SD.Og(dx.ZZv(), dx.KZx(), dx.ML(), map, new String(bArrZZv2, zZv.pA(zZv.pA(dx.JG()))), dx.Og(), dx.pA());
                                        og2.pA(bArrZZv2);
                                    } else {
                                        og2 = new com.bytedance.sdk.component.SD.Og(dx.ZZv(), dx.KZx(), dx.ML(), map, dx.JG().Og(), dx.Og(), dx.pA());
                                    }
                                    ZZv.this.pA(og2, dx);
                                } catch (Throwable th) {
                                    th = th;
                                    og3 = og2;
                                    og2 = og3;
                                    iOException = new IOException(th);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (og2 != null) {
                                pAVar.pA(ZZv.this, og2);
                                return;
                            }
                            com.bytedance.sdk.component.SD.pA.pA pAVar4 = pAVar;
                            if (pAVar4 instanceof com.bytedance.sdk.component.SD.pA.Og) {
                                com.bytedance.sdk.component.SD.pA.Og og4 = (com.bytedance.sdk.component.SD.pA.Og) pAVar4;
                                ZZv zZv2 = ZZv.this;
                                if (iOException == null) {
                                    iOException = new IOException("Unexpected exception");
                                }
                                og4.pA(zZv2, iOException, new com.bytedance.sdk.component.SD.Og(dx.ZZv(), dx.KZx(), dx.ML(), null, null, dx.Og(), dx.pA()));
                                return;
                            }
                            ZZv zZv3 = ZZv.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            pAVar4.pA(zZv3, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            pAVar.pA(this, new IOException(th.getMessage()));
        }
    }

    public com.bytedance.sdk.component.SD.Og pA() {
        com.bytedance.sdk.component.SD.Og og;
        try {
            Wx.pA pAVar = new Wx.pA();
            if (TextUtils.isEmpty(this.omh)) {
                return new com.bytedance.sdk.component.SD.Og(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            pAVar.Og(this.omh);
            if (this.pA == null) {
                return new com.bytedance.sdk.component.SD.Og(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            pA(pAVar);
            pAVar.pA((Object) KZx());
            DX dxOg = this.KZx.pA(pAVar.pA(this.pA).Og()).Og();
            if (dxOg == null) {
                return null;
            }
            HashMap map = new HashMap();
            JG jgSD = dxOg.SD();
            if (jgSD != null) {
                for (int i = 0; i < jgSD.pA(); i++) {
                    String strPA = jgSD.pA(i);
                    String strOg = jgSD.Og(i);
                    map.put(strPA, strOg);
                    if (strPA != null && strPA.equalsIgnoreCase("content-type")) {
                        map.put("content-type", strOg == null ? "" : strOg.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.SD.ZZv.pA.pA(map)) {
                byte[] bArrZZv = dxOg.JG().ZZv();
                og = new com.bytedance.sdk.component.SD.Og(dxOg.ZZv(), dxOg.KZx(), dxOg.ML(), map, null, dxOg.Og(), dxOg.pA());
                og.pA(bArrZZv);
            } else if (this.Bzk) {
                byte[] bArrZZv2 = dxOg.JG().ZZv();
                og = new com.bytedance.sdk.component.SD.Og(dxOg.ZZv(), dxOg.KZx(), dxOg.ML(), map, new String(bArrZZv2, pA(pA(dxOg.JG()))), dxOg.Og(), dxOg.pA());
                og.pA(bArrZZv2);
            } else {
                og = new com.bytedance.sdk.component.SD.Og(dxOg.ZZv(), dxOg.KZx(), dxOg.ML(), map, dxOg.JG().Og(), dxOg.Og(), dxOg.pA());
            }
            pA(og, dxOg);
            return og;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.SD.Og(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public Sn ZZv() {
        return this.pA;
    }

    public void pA(String str, boolean z) {
        if (z) {
            pA("application/json; charset=utf-8", ML(str));
            Og("Content-Encoding", "gzip");
        } else {
            ZZv(str);
        }
    }

    private byte[] ML(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes(cc.N));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e) {
                                WV.pA("PostExecutor", e.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            gZIPOutputStream = gZIPOutputStream2;
                            WV.pA("PostExecutor", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e3) {
                                    WV.pA("PostExecutor", e3.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e4) {
                                    WV.pA("PostExecutor", e4.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e5) {
                                    WV.pA("PostExecutor", e5.toString());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e = e7;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (IOException e8) {
            WV.pA("PostExecutor", e8.toString());
        }
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset pA(Bzk bzk) {
        try {
            return bzk != null ? bzk.pA(com.bytedance.sdk.component.Og.pA.Og.Bzk.pA) : com.bytedance.sdk.component.Og.pA.Og.Bzk.pA;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.Og.pA.Og.Bzk.pA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bzk pA(oX oXVar) {
        try {
            return oXVar.ML();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.component.SD.Og og, DX dx) {
        if (og == null || dx == null) {
            return;
        }
        og.pA(dx.Bzk());
    }
}
