package org.example;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

public class CreateServer extends WebSocketServer {
    static private final int PORT = 7777;
    private Set<WebSocket> sockets;
    public CreateServer(){
        super(new InetSocketAddress(PORT));
        sockets = new HashSet<>();
    }
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        sockets.add(webSocket);

    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {

        JSONObject user = new JSONObject(s);



    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }
    public void broadcast(String message) {
        System.out.println(message);
        for (WebSocket socket : sockets) {
            if (socket.isOpen()) { // Проверяем, открыт ли сокет, чтобы избежать ошибок.
                socket.send(message);
            }
        }
    }
}
