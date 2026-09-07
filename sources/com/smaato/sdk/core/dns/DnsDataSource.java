package com.smaato.sdk.core.dns;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
final class DnsDataSource {
    DnsDataSource() {
    }

    public DnsQueryResult query(DnsMessage dnsMessage, InetAddress inetAddress, int i) throws DnsException {
        ArrayList arrayList = new ArrayList();
        try {
            DnsMessage dnsMessageQueryUdp = queryUdp(dnsMessage, inetAddress, i);
            if (!dnsMessageQueryUdp.truncated) {
                return new DnsQueryResult(inetAddress, DnsQueryResult.QueryMethod.UDP, dnsMessage, dnsMessageQueryUdp, i);
            }
        } catch (IOException e) {
            arrayList.add(e);
        }
        try {
            return new DnsQueryResult(inetAddress, DnsQueryResult.QueryMethod.TCP, dnsMessage, queryTcp(dnsMessage, inetAddress, i), i);
        } catch (IOException e2) {
            arrayList.add(e2);
            throw new DnsException.MultipleDnsException(arrayList);
        }
    }

    private DnsMessage queryUdp(DnsMessage dnsMessage, InetAddress inetAddress, int i) {
        DatagramPacket datagramPacketAsDatagram = dnsMessage.asDatagram(inetAddress, i);
        byte[] bArr = new byte[1024];
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(5000);
            datagramSocket.send(datagramPacketAsDatagram);
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 1024);
            datagramSocket.receive(datagramPacket);
            DnsMessage dnsMessage2 = new DnsMessage(datagramPacket.getData());
            if (dnsMessage2.id != dnsMessage.id) {
                throw new DnsException.IdMismatch(dnsMessage, dnsMessage2);
            }
            datagramSocket.close();
            return dnsMessage2;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private DnsMessage queryTcp(DnsMessage dnsMessage, InetAddress inetAddress, int i) throws IOException {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(inetAddress, i), 5000);
            socket.setSoTimeout(5000);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dnsMessage.writeTo(dataOutputStream);
            dataOutputStream.flush();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int unsignedShort = dataInputStream.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            for (int i2 = 0; i2 < unsignedShort; i2 += dataInputStream.read(bArr, i2, unsignedShort - i2)) {
            }
            DnsMessage dnsMessage2 = new DnsMessage(bArr);
            if (dnsMessage2.id != dnsMessage.id) {
                throw new DnsException.IdMismatch(dnsMessage, dnsMessage2);
            }
            socket.close();
            return dnsMessage2;
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
