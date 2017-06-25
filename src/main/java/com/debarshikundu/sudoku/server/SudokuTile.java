package com.debarshikundu.sudoku.server;

/**
 * Created by debarshikundu on 6/25/17.
 */
public class SudokuTile {
    private int value;
    private String source;
    public SudokuTile(int value, String source)
    {
        this.value=value;
        this.source=source;
    }
}

