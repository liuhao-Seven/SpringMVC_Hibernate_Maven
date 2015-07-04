package com.lh.adapter.mina;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
//import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TcpServer extends IoHandlerAdapter {
    public static final int PORT = 18567;

    public static final int MAX_RECEIVED = 100000;

//    private static long t0;

    private AtomicInteger nbReceived = new AtomicInteger(0);

    /**
     * {@inheritDoc}
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
        session.close(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

//        int nb = nbReceived.incrementAndGet();
//
//        if (nb == 1) {
//            t0 = System.currentTimeMillis();
//        }
//
//        if (nb == MAX_RECEIVED) {
//            long t1 = System.currentTimeMillis();
//            System.out.println("-------------> end " + (t1 - t0));
//        }
        System.out.println("Received from client:--> " + String.valueOf(message));
//        if (nb % 10000 == 0) {
//            System.out.println("Received " + nb + " messages");
//        }

        // If we want to test the write operation, uncomment this line
        session.write(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("Session closed...");

        // Reinitialize the counter and expose the number of received messages
        System.out.println("Nb message received : " + nbReceived.get());
        nbReceived.set(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("Session created...");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("Session idle...");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("Session Opened...");
    }

    /**
     * Create the TCP server
     */
    public TcpServer() throws IOException {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new TextLineCodecFactory()));
        // The logger, if needed. Commented atm
        //DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //chain.addLast("logger", new LoggingFilter());
        acceptor.setHandler(this);
        acceptor.bind(new InetSocketAddress(PORT));

        System.out.println("Server started...");
    }

    public static void main(String[] args) throws IOException {
        new TcpServer();
    }
}