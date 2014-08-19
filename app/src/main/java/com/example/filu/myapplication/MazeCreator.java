package com.example.filu.myapplication;

import java.util.Random;

/**
 * Created by Filu on 2014-08-19.
 */
public class MazeCreator {

    private int level;
    private int size_x, size_y;

    private Field[][] maze;

    public MazeCreator(int level) {
        this.level = level;

        size_x = ((level * 3) + 12)/3;
        size_y = ((level * 2) +10)/2;

       this.maze = generateMaze();

    }

    private void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    private void setSize_y(int size_y) {
        this.size_y = size_y;
    }
    public int getSize_x(){
        return size_x;
    }

    public int getSize_y(){
        return size_y;
    }

    public Field[][] generateMaze() {

        maze = new Field[size_x][size_y];
        setEndings();
        generatePath();




        return maze;
    }

    private void setEndings() {

        maze[0][0].north = true;
        maze[0][0].visited = true;
        maze[size_x][size_y].south = true;
        maze[size_x][size_y].visited = true;


    }

    /**
     * case 0 - north
     * case 1 - east
     * case 2 - west
     * case 3 - south
     */
    private void generatePath() {


        int position_y=0;
        int position_x=0;
        int counter = size_x*size_y;
        while(counter<0) {

            Random r = new Random();
            int direction = r.nextInt(4 - 1) +4;
            switch (direction) {
                case 0:
                    --position_y;
                    if(position_y<0) {
                        position_y++;
                    }
                    break;
                case 1:
                    ++position_x;
                    if(position_x>size_x) {
                        position_x--;
                    }
                    break;
                case 2:
                    --position_x;
                    if(position_x<0) {
                        position_x++;
                    }
                    break;
                case 3:
                    ++position_y;
                    if(position_y<size_y) {
                        position_y--;
                    }
                    break;
            }


        }


    }


}

