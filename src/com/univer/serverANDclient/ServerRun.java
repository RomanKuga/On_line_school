package com.univer.serverANDclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServerRun implements Runnable {
    private static final int SERVER_PORT = 1234;
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    private boolean stanSelector;


    public boolean isStanSelector() {
        return stanSelector;
    }

    public void start() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        System.out.println("Server started and listening at port = " + SERVER_PORT);

        ServerSocket serverSocket = serverSocketChannel.socket();
        Selector selector = Selector.open();
        stanSelector = selector.isOpen();
        serverSocket.bind(new InetSocketAddress(SERVER_PORT));
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            int n = selector.select();

            if (n == 0) {
                continue;//nothig to do here
            }


            Iterator it = selector.selectedKeys().iterator();


            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = serverSocketChannel.accept();

                    String formIPchapter = "\\:\\d{4,5}";
                    String channelIp = String.valueOf(channel.getLocalAddress());
                    String channelIpTest = channelIp.substring(1);
                    channelIpTest=channelIpTest.replaceAll(formIPchapter, "");
                    if (!BlackListWriteRemove.printBlackList().contains(channelIpTest)){
                    registerChannel(selector, channel, n);
                    }else {
                    channel.close();
                    System.out.println("IP клієнта знаходиться в BlackList");}

                    //  readData(key);
                }
            }
        }
    }


    /**
     * method for registring channel
     *
     * @param selector
     * @param socketChannel
     * @param ops
     */
    public void registerChannel(Selector selector,
                                SocketChannel socketChannel,
                                int ops) throws IOException {

        socketChannel.configureBlocking(false);


        socketChannel.register(selector, ops);

    }

    //reading data from channel
    private void readData(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        int count;

        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }

            buffer.clear();
        }

    }


    @Override
    public void run() {
        try {

            new ServerRun().start();

        } catch (IOException e) {
            System.out.println("Помилка запуску сервера");
        }

    }
}
