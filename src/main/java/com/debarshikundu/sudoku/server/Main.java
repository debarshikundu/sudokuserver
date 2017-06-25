package com.debarshikundu.sudoku.server;

/**
 * Created by debarshikundu on 6/24/17.
 */


import java.io.IOException;
import java.util.Map;
import fi.iki.elonen.NanoHTTPD;

public class Main extends NanoHTTPD {

    public Main() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1></body></html>";
        return newFixedLengthResponse(msg);
    }
}