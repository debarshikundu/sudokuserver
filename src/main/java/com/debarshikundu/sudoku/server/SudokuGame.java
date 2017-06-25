package com.debarshikundu.sudoku.server;

import java.util.Map;

/**
 * Created by debarshikundu on 6/25/17.
 */
public class SudokuGame {
    private String gameID;
    SudokuTile[][] board=new SudokuTile[9][9];
    User[] players;

    public SudokuGame(String gameID)
    {
        this.gameID=gameID;
    }

    public boolean checkGuess(User user, SudokuTile tile)
    {
        return false;
    }

    Map<User,UserStat> getStats()
    {
        return null;
    }


}
