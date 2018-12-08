package com.raymondjcox.challenges;

import com.raymondjcox.utils.FileUtils;

public class Challenge3 {
    public static void main(String[] args) throws Exception {
        String lines[] = FileUtils.readFile("input3.txt");
        System.out.println(Part2(lines));
    }

    static class Square {
        public final int startX, startY, endX, endY, width, height;
        public final String id;

        public Square(String id, int startX, int startY, int endX, int endY) {
            this.id = id;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.width = this.endX - this.startX;
            this.height = this.endY - this.startY;
        }

        public static Square fromString(String str) {
            String[] parts = str.split(" ");
            String[] dimensions = parts[2].split(",");
            String[] area = parts[3].split("x");
            String id = parts[0];
            int startX = Integer.valueOf(dimensions[0]);
            int startY = Integer.valueOf(dimensions[1].substring(0, dimensions[1].length() - 1));
            int endX = Integer.valueOf(area[0]) + startX;
            int endY = Integer.valueOf(area[1]) + startY;
            return new Square(id, startX, startY, endX, endY);
        }

        public boolean overlaps(Square square) {
            return this.overlapsX(square) && this.overlapsY(square);
        }

        @Override
        public String toString() {
            return String.valueOf(this.startX) + "," + String.valueOf(this.startY) + "," +
                    String.valueOf(this.endX) + "," + String.valueOf(this.endY);
        }

        private boolean overlapsX(Square square) {
            return startX >= square.startX && startX <= square.endX || square.startX >= startX && square.startX <= endX ;
        }

        private boolean overlapsY(Square square) {
            return startY >= square.startY && startY <= square.endY || square.startY >= startY && square.startY <= endY;
        }
    }

    private static Square[] buildSquares(String[] lines) {
        Square[] squares = new Square[lines.length];

        for (int i=0; i<lines.length; i++) {
            String line = lines[i];
            squares[i] = Square.fromString(line);
        }

        return squares;
    }


    public static long Part1(String[] lines) {
        final int sizeX = 10000;
        final int sizeY = 10000;
        int arr[][] = new int[sizeX][sizeY];

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                arr[x][y] = 0;
            }
        }


        for (int i=0; i<lines.length; i++) {
            String line = lines[i];
            Square square = Square.fromString(line);
            for (int x=square.startX; x<square.endX; x++) {
                for (int y=square.startY; y<square.endY; y++) {
                    arr[x][y] += 1;
                }
            }

        }

        int answer = 0;
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (arr[x][y] > 1) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static String Part2(String[] lines) {
        Square[] squares = buildSquares(lines);

        for (int i = 0; i < squares.length; i++) {
            boolean overlaps = false;
            for (int j = 0; j < squares.length; j++) {
                if (i == j) {
                    continue;
                }

                if (squares[i].overlaps(squares[j])) {
                    overlaps = true;
                    break;
                }
            }
            if (overlaps == false) {
                return squares[i].id;
            }
        }
        return null;
    }
}
