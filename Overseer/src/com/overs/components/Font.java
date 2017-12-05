package com.overs.components;

import org.jetbrains.annotations.NotNull;

public class Font {

    private static String[] defaultFont = new String[]{
            "......   ......   ......   ......   ......   ......",
            ".###..   ####..   .####.   ####..   #####.   #####.",
            "#...#.   #...#.   #.....   #...#.   #.....   #.....",
            "#####.   ####..   #.....   #...#.   ###...   ###...",
            "#...#.   #...#.   #.....   #...#.   #.....   #.....",
            "#...#.   ####..   .####.   ####..   #####.   #.....",
            "                                                   ",
            "                                                   ",
            "......   ......   ......   ......   ......   ......",
            ".###..   #...#.   #####.   #####.   #..#..   #.....",
            "#.....   #...#.   ..#...   ....#.   #.#...   #.....",
            "#.##..   #####.   ..#...   ....#.   ##....   #.....",
            "#...#.   #...#.   ..#...   ....#.   #.#...   #.....",
            ".###..   #...#.   #####.   ####..   #..#..   #####.",
            "                                                   ",
            "                                                   ",
            "......   ......   ......   ......   ......   ......",
            "#...#.   #...#.   .###..   ####..   .###..   ####..",
            "##.##.   ##..#.   #...#.   #...#.   #...#.   #...#.",
            "#.#.#.   #.#.#.   #...#.   ####..   #...#.   ####..",
            "#...#.   #..##.   #...#.   #.....   #..##.   #..#..",
            "#...#.   #...#.   .###..   #.....   .####.   #...#.",
            "                                                   ",
            "                                                   ",
            "......   ......   ......   ......   ......   ......",
            ".###..   #####.   #...#.   #...#.   #...#.   #...#.",
            "#.....   ..#...   #...#.   #...#.   #...#.   .#.#..",
            ".##...   ..#...   #...#.   #...#.   #.#.#.   ..#...",
            "...#..   ..#...   #...#.   .#.#..   ##.##.   .#.#..",
            "###...   ..#...   .###..   ..#...   #...#.   #...#.",
            "                                                   ",
            "                                                   ",
            "......   ......   ......   ......   ......   ......",
            "#...#.   #####.   ......   .#....   .##...   ......",
            "#...#.   ...#..   ......   .#....   #..#..   ......",
            ".#.#..   ..#...   ......   .#....   ..#...   ......",
            "..#...   .#....   ......   ......   ......   ......",
            "..#...   #####.   ......   .#....   ..#...   ......",
            "                                                   ",
            "                                                   ",
    };

    private int font_size = 6;
    private int vGap = 3;
    private int hGap = 2;

    public String[] GetChar(char c){
        switch(c){
            case 'A':
                return GetCharPos(0, 0);
            case 'B':
                return GetCharPos(1, 0);

            case 'C':
                return GetCharPos(2, 0);

            case 'D':
                return GetCharPos(3, 0);

            case 'E':
                return GetCharPos(4, 0);

            case 'F':
                return GetCharPos(5, 0);

            case 'G':
                return GetCharPos(0, 1);

            case 'H':
                return GetCharPos(1, 1);

            case 'I':
                return GetCharPos(2, 1);

            case 'J':
                return GetCharPos(3, 1);

            case 'K':
                return GetCharPos(4, 1);

            case 'L':
                return GetCharPos(5, 1);

            case 'M':
                return GetCharPos(0, 2);

            case 'N':
                return GetCharPos(1, 2);

            case 'O':
                return GetCharPos(2, 2);

            case 'P':
                return GetCharPos(3, 2);

            case 'Q':
                return GetCharPos(4, 2);

            case 'R':
                return GetCharPos(5, 2);

            case 'S':
                return GetCharPos(0, 3);

            case 'T':
                return GetCharPos(1, 3);

            case 'U':
                return GetCharPos(2, 3);

            case 'V':
                return GetCharPos(3, 3);

            case 'W':
                return GetCharPos(4, 3);

            case 'X':
                return GetCharPos(5, 3);

            case 'Y':
                return GetCharPos(0, 4);

            case 'Z':
                return GetCharPos(1, 4);

            case ' ':
                return GetCharPos(2, 4);

            case '!':
                return GetCharPos(3, 4);

            case '?':
                return GetCharPos(4, 4);

            default:
                return null;
        }
    }

    public int GetFontSize() { return font_size; }

    private String[] GetCharPos(int x, int y){
        String[] temp = new String[font_size];

        int startX = (x < 0) ? 0 : (font_size + vGap) * x;
        int endX = startX + font_size;

        int startY = (y < 0) ? 0 : (font_size + hGap) * y;
        int endY = startY + font_size;

        for(int i = 0; i < temp.length; i++){
            temp[i] = defaultFont[startY].substring(startX, endX);
            if(startY < endY)
                startY++;
        }

        return temp;
    }
}
