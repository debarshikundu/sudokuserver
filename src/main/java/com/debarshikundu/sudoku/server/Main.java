package com.debarshikundu.sudoku.server;

/**
 * Created by debarshikundu on 6/24/17.
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import fi.iki.elonen.NanoHTTPD;

public class Main extends NanoHTTPD {
    Controller controller;

    public Main() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
        controller = new Controller();
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
        String uri = session.getUri();
        String msg="";
        System.out.println(uri);
        String[] arr= uri.split("/");

        if(arr.length==3&&arr[1].equals("startGame"))
        {
            msg = "You want to start a new game.";
            controller.startGame(null);

            String arrNumbers[]=arr[2].split("&");
            int intArray[]=new int[arrNumbers.length];

            for(int index=0; index<arrNumbers.length; index++)
            {
                intArray[index]=Integer.parseInt(arrNumbers[index]);
            }

            System.out.println(Arrays.toString(intArray));
        }

        else if(arr.length==3&&arr[1].equals("endGame"))
        {
            msg = "You want to quit the current game.";
            controller.exitGame(0);
        }


        return newFixedLengthResponse(msg);
    }
}