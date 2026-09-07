package com.safedk.android.utils;

import android.util.Base64;
import com.safedk.android.analytics.reporters.CrashReporter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes10.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8161a = "SerializingUtils";

    public static String a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        String strEncodeToString = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            synchronized (obj) {
                                objectOutputStream.writeObject(obj);
                            }
                            objectOutputStream.flush();
                            strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                            n.a((Closeable) objectOutputStream);
                            n.a((Closeable) byteArrayOutputStream);
                        } catch (IOException e) {
                            e = e;
                            Logger.d(f8161a, "failed during serialization object: " + obj + " : " + e.getMessage(), e);
                            n.a((Closeable) objectOutputStream);
                            n.a((Closeable) byteArrayOutputStream);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        n.a((Closeable) 0);
                        n.a((Closeable) byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = null;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
                return strEncodeToString;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            Logger.d(f8161a, "failed during serializing object : " + th4.getMessage() + " for object : " + obj, th4);
            new CrashReporter().caughtException(th4);
        }
    }

    public static Object a(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 2));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    n.a((Closeable) objectInputStream);
                    n.a((Closeable) byteArrayInputStream);
                    return object;
                } catch (Throwable th) {
                    th = th;
                    n.a((Closeable) objectInputStream);
                    n.a((Closeable) byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            objectInputStream = null;
        }
    }
}
