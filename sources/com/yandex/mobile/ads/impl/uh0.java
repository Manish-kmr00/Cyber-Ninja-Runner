package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes11.dex */
public final class uh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f10386a;
    private static final ByteString b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f10386a = companion.encodeUtf8("\"\\");
        b = companion.encodeUtf8("\t ,=");
    }

    public static final ArrayList a(nf0 nf0Var, String headerName) {
        Intrinsics.checkNotNullParameter(nf0Var, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = nf0Var.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(headerName, nf0Var.a(i), true)) {
                try {
                    a(new Buffer().writeUtf8(nf0Var.b(i)), arrayList);
                } catch (EOFException e) {
                    nh1.f9731a.getClass();
                    nh1.a(5, "Unable to parse challenge", e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean a(oq1 oq1Var) {
        Intrinsics.checkNotNullParameter(oq1Var, "<this>");
        if (Intrinsics.areEqual(oq1Var.o().f(), "HEAD")) {
            return false;
        }
        int iD = oq1Var.d();
        return (((iD >= 100 && iD < 200) || iD == 204 || iD == 304) && y82.a(oq1Var) == -1 && !StringsKt.equals("chunked", oq1.a(oq1Var, HttpHeaders.TRANSFER_ENCODING), true)) ? false : true;
    }

    private static final boolean b(Buffer buffer) throws EOFException {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b2 = buffer.getByte(0L);
            if (b2 == 44) {
                buffer.readByte();
                z = true;
            } else {
                if (b2 != 32 && b2 != 9) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:76:0x0110 A[EDGE_INSN: B:76:0x0110->B:64:0x0110 BREAK  A[LOOP:2: B:22:0x0075->B:63:0x010d], SYNTHETIC] */
    private static final void a(Buffer buffer, ArrayList arrayList) throws EOFException {
        String strA;
        while (true) {
            String strA2 = null;
            while (true) {
                if (strA2 == null) {
                    b(buffer);
                    strA2 = a(buffer);
                    if (strA2 == null) {
                        return;
                    }
                }
                boolean zB = b(buffer);
                String strA3 = a(buffer);
                if (strA3 == null) {
                    if (buffer.exhausted()) {
                        arrayList.add(new fo(strA2, MapsKt.emptyMap()));
                        return;
                    }
                    return;
                }
                int iA = y82.a(buffer);
                boolean zB2 = b(buffer);
                if (!zB && (zB2 || buffer.exhausted())) {
                    Map mapSingletonMap = Collections.singletonMap(null, strA3 + StringsKt.repeat("=", iA));
                    Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(...)");
                    arrayList.add(new fo(strA2, mapSingletonMap));
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iA2 = y82.a(buffer) + iA;
                    while (true) {
                        if (strA3 != null) {
                            if (iA2 != 0) {
                                break;
                                break;
                            }
                            if (iA2 <= 1) {
                                return;
                            }
                            if (buffer.exhausted()) {
                                strA = a(buffer);
                            } else {
                                strA = a(buffer);
                            }
                            if (strA != null) {
                                return;
                            }
                            if (b(buffer)) {
                            }
                            strA3 = null;
                        } else {
                            strA3 = a(buffer);
                            if (!b(buffer)) {
                                iA2 = y82.a(buffer);
                                if (iA2 != 0) {
                                    break;
                                }
                                if (iA2 <= 1 || b(buffer)) {
                                    return;
                                }
                                if (buffer.exhausted() && buffer.getByte(0L) == 34) {
                                    if (buffer.readByte() == 34) {
                                        Buffer buffer2 = new Buffer();
                                        while (true) {
                                            long jIndexOfElement = buffer.indexOfElement(f10386a);
                                            if (jIndexOfElement != -1) {
                                                if (buffer.getByte(jIndexOfElement) == 34) {
                                                    buffer2.write(buffer, jIndexOfElement);
                                                    buffer.readByte();
                                                    strA = buffer2.readUtf8();
                                                    break;
                                                } else if (buffer.size() != jIndexOfElement + 1) {
                                                    buffer2.write(buffer, jIndexOfElement);
                                                    buffer.readByte();
                                                    buffer2.write(buffer, 1L);
                                                }
                                            }
                                            strA = null;
                                            break;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Failed requirement.".toString());
                                    }
                                } else {
                                    strA = a(buffer);
                                }
                                if (strA != null || ((String) linkedHashMap.put(strA3, strA)) != null) {
                                    return;
                                }
                                if (b(buffer) && !buffer.exhausted()) {
                                    return;
                                } else {
                                    strA3 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    arrayList.add(new fo(strA2, linkedHashMap));
                    strA2 = strA3;
                }
            }
        }
    }

    private static final String a(Buffer buffer) {
        long jIndexOfElement = buffer.indexOfElement(b);
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        if (jIndexOfElement != 0) {
            return buffer.readUtf8(jIndexOfElement);
        }
        return null;
    }

    public static final void a(ns nsVar, di0 url, nf0 headers) {
        Intrinsics.checkNotNullParameter(nsVar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (nsVar == ns.f9750a) {
            return;
        }
        int i = ls.n;
        List<ls> listA = ls.a.a(url, headers);
        if (listA.isEmpty()) {
            return;
        }
        nsVar.a(url, listA);
    }
}
