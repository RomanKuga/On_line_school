package com.univer.serverANDclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServerRun implements Runnable {
    private static final int SERVER_PORT = 1234;
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    private static final String BlackList_STORAGE_FILE = "src/com/univer/BlackList.txt";
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


            Iterator<SelectionKey> it = selector.selectedKeys().iterator();


            while (it.hasNext()) {
                SelectionKey key =  it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = serverSocketChannel.accept();



                    if (!isInBlacklist(channel.getLocalAddress(),loadBlacklistFromFile())){
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
    private static Set<String> loadBlacklistFromFile() throws IOException {
        Set<String> blacklist = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(BlackList_STORAGE_FILE), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                blacklist.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error loading blacklist from file: " + e.getMessage());
            throw e;
        }
        return blacklist;
    }

    private static boolean isInBlacklist(SocketAddress socketAddress, Set<String> blacklist) {
        String ip = ((InetSocketAddress) socketAddress).getAddress().getHostAddress();
        return blacklist.contains(ip);
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
