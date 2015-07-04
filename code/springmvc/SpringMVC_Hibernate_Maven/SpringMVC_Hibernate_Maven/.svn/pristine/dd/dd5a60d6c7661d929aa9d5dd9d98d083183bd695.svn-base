package com.lh.adapter.mina;


import java.net.InetSocketAddress;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class TcpClient extends IoHandlerAdapter {
    /** The connector */
    private IoConnector connector;

    /** The session */
    private static IoSession session;

    private boolean received = false;

    /**
     * Create the UdpClient's instance
     */
    public TcpClient() {
        connector = new NioSocketConnector();
        connector.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new TextLineCodecFactory()));
        connector.setHandler(this);
        ConnectFuture connFuture = connector.connect(new InetSocketAddress("localhost", TcpServer.PORT));

        connFuture.awaitUninterruptibly();

        session = connFuture.getSession();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        received = true;
        System.out.println("received message from server:-->"+String.valueOf(message));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
    }

    public static void main(String[] args) throws Exception {
        TcpClient client = new TcpClient();

        long t0 = System.currentTimeMillis();

        for (int i = 0; i <= TcpServer.MAX_RECEIVED; i++) {
            IoBuffer buffer = IoBuffer.allocate(4);
            buffer.setAutoExpand(true);
            buffer.put(("welcome,xiaoe!"+i+"\r\n").getBytes());
            buffer.flip();
            session.write(buffer);

            while (client.received == false) {
                Thread.sleep(1);
            }

            client.received = false;

//            if (i % 10000 == 0) {
//                System.out.println("Sent " + i + " messages");
//            }
        }

        long t1 = System.currentTimeMillis();

        System.out.println("Sent messages delay : " + (t1 - t0));

        Thread.sleep(100000);

        client.connector.dispose(true);
    }
}
