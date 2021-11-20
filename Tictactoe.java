import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tictactoe {
    // Specify the input as : start player 1 player 2
    // player 1/ player 2 : user, easy, medium
    // exit terminates the program

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static char[][] arr = new char[3][5];
    static String input1;
    static String input2;

    public static void main(String[] args) {
        start();
    }

    public static String command() {
        boolean check = true;
        String temp = null;
        while (check) {
            System.out.print("Input command:");

            String string = sc.nextLine();
            String string1 = string.trim();
            if (string1.equals("exit")) {

                return string;
            } else {
                String str[] = string1.split(" ");
                if (str.length == 3 && str[0].equals("start")
                        && (str[1].equals("easy") || str[1].equals("user") || str[1].equals("medium"))
                        && (str[2].equals("easy") || str[2].equals("user") || str[2].equals("medium"))) {
                    temp = str[1] + " " + str[2];

                    return temp;
                } else {
                    System.out.println("Bad parameters!");

                }
            }
        }
        return null;
    }

    public static String check() {
        String test = command();
        if (!test.equals("exit")) {
            return test;
        }
        return null;
    }

    public static void code() {
        String input0 = check();

        if (input0 != null) {
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 4; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("---------");
            int flag = 1;
            char ch;
            int i = 1;
            String strarr[] = input0.split(" ");
            input1 = strarr[0];
            input2 = strarr[1];
            while (i <= 9) {
                if (i % 2 != 0) {
                    if (input1.equals("user")) {
                        userInput(i);
                    } else if (input1.equals("easy")) {
                        computerInput(i);
                    } else {
                        computerMedium(i);
                    }
                } else {
                    if (input2.equals("user")) {
                        userInput(i);
                    } else if (input2.equals("easy")) {
                        computerInput(i);
                    } else {
                        computerMedium(i);
                    }
                }
                System.out.println("---------");
                for (int z = 0; z < 3; z++) {
                    for (int j = 0; j <= 4; j++) {
                        System.out.print(arr[z][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("---------");

                i++;
                ch = ' ';
                for (int g = 0; g <= 2; g++) {
                    if ((arr[g][1] == arr[g][2]) && (arr[g][1] == arr[g][3] && arr[g][1] != ' ')) {
                        ch = arr[g][1];
                        flag = 2;
                        break;
                    }

                }
                for (int g = 1; g <= 3; g++) {
                    if ((arr[0][g] == arr[1][g]) && (arr[0][g] == arr[2][g] && arr[0][g] != ' ')) {
                        ch = arr[0][g];
                        flag = 2;
                        break;
                    }

                }
                if (arr[0][1] == arr[1][2] && arr[0][1] == arr[2][3] && arr[0][1] != ' ') {
                    ch = arr[0][1];
                    flag = 2;

                }
                if ((arr[0][3] == arr[1][2]) && (arr[0][3] == arr[2][1] && arr[0][3] != ' ')) {
                    ch = arr[0][3];
                    flag = 2;
                }
                if (flag == 2) {
                    if (ch == 'X') {
                        System.out.println("X wins");

                        break;
                    } else {
                        System.out.println("O wins");

                        break;
                    }
                }

            }
            if (flag == 1) {
                System.out.println("Draw");

            }
            sc.nextLine();
            start();

        }
    }

    public static void userInput(int i) {
        while (true) {
            int c1, c2;
            System.out.print("Enter the coordinates:");
            try {
                c1 = sc.nextInt();
                c2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                sc.nextLine();
                continue;

            }

            if (c1 < 1 || c1 > 3 || c2 < 1 || c2 > 3) {
                System.out.println("Coordinates should be from 1 to 3!");

            } else if (arr[c1 - 1][c2] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");

            } else {
                if (i % 2 != 0) {
                    arr[c1 - 1][c2] = 'X';
                } else {
                    arr[c1 - 1][c2] = 'O';
                }
                break;
            }
        }
    }

    public static void computerMedium(int i) {
        System.out.println("Making move level \"medium\"");
        int win, block;
        if (input1.equals("medium")) {
            win = 4;
            block = 2;
        } else {
            win = 2;
            block = 4;
        }

        int x1 = 0, y1 = 0, count1 = 0;
        int u, v;
        int x2 = 0, y2 = 0, count2 = 0;
        int s1;
        int s2;
        int s3 = 0;
        int s4 = 0;
        int x3 = 0, y3 = 0, count3 = 0;
        int x4 = 0, y4 = 0, count4 = 0;
        int con = 3;
        int p = 0;
        while (true) {
            for (u = 0; u <= 2; u++) {
                if (arr[u][u + 1] == 'X') {
                    s3 = s3 + 1;
                }
                if (arr[u][u + 1] == 'O') {
                    s3 = s3 + 0;
                }
                if (arr[u][con] == 'X') {
                    s4 = s4 + 1;
                }
                if (arr[u][con] == 'O') {
                    s4 = s4 + 0;
                }
                if (arr[u][u + 1] == ' ') {
                    s3 = s3 + 2;
                    count3++;
                    x3 = u;
                    y3 = u + 1;
                }
                if (arr[u][con] == ' ') {
                    s4 = s4 + 2;
                    count4++;
                    x4 = u;
                    y4 = con;
                }
                con--;
            }
            if (s3 == win && count3 == 1) {
                if (i % 2 != 0) {
                    arr[x3][y3] = 'X';
                } else {
                    arr[x3][y3] = 'O';
                }
                break;
            }
            if (s4 == win && count4 == 1) {
                if (i % 2 != 0) {
                    arr[x4][y4] = 'X';
                } else {
                    arr[x4][y4] = 'O';
                }
                break;
            }

            for (u = 1; u <= 3; u++) {
                s1 = 0;
                s2 = 0;
                for (v = 0; v <= 2; v++) {
                    if (arr[v][u] == 'X') {
                        s1 = s1 + 1;

                    }
                    if (arr[u - 1][v + 1] == 'X') {
                        s2 = s2 + 1;
                    }
                    if (arr[v][u] == 'O') {
                        s1 = s1 + 0;

                    }
                    if (arr[u - 1][v + 1] == 'O') {
                        s2 = s2 + 0;
                    }
                    if (arr[v][u] == ' ') {
                        count1++;
                        s1 = s1 + 2;
                        x1 = v;
                        y1 = u;
                    }
                    if (arr[u - 1][v + 1] == ' ') {
                        count2++;
                        s2 = s2 + 2;
                        x2 = u - 1;
                        y2 = v + 1;
                    }

                }
                if (s1 == win && count1 == 1) {
                    if (i % 2 != 0) {
                        arr[x1][y1] = 'X';
                    } else {
                        arr[x1][y1] = 'O';
                    }
                    p = 1;
                    break;
                }
                if (s2 == win && count2 == 1) {
                    if (i % 2 != 0) {
                        arr[x2][y2] = 'X';
                    } else {
                        arr[x2][y2] = 'O';
                    }
                    p = 1;
                    break;
                }

            }
            if (p == 1) {
                break;
            }

            if (s3 == block && count3 == 1) {
                if (i % 2 != 0) {
                    arr[x3][y3] = 'X';
                } else {
                    arr[x3][y3] = 'O';
                }
                break;
            }
            if (s4 == block && count4 == 1) {
                if (i % 2 != 0) {
                    arr[x4][y4] = 'X';
                } else {
                    arr[x4][y4] = 'O';
                }
                break;
            }
            for (u = 1; u <= 3; u++) {
                s1 = 0;
                s2 = 0;
                for (v = 0; v <= 2; v++) {
                    if (arr[v][u] == 'X') {
                        s1 = s1 + 1;

                    }
                    if (arr[u - 1][v + 1] == 'X') {
                        s2 = s2 + 1;
                    }
                    if (arr[v][u] == 'O') {
                        s1 = s1 + 0;

                    }
                    if (arr[u - 1][v + 1] == 'O') {
                        s2 = s2 + 0;
                    }
                    if (arr[v][u] == ' ') {
                        count1++;
                        s1 = s1 + 2;
                        x1 = v;
                        y1 = u;
                    }
                    if (arr[u - 1][v + 1] == ' ') {
                        count2++;
                        s2 = s2 + 2;
                        x2 = u - 1;
                        y2 = v + 1;
                    }

                }
                if (s1 == block && count1 == 1) {
                    if (i % 2 != 0) {
                        arr[x1][y1] = 'X';
                    } else {
                        arr[x1][y1] = 'O';
                    }
                    p = 1;
                    break;
                }
                if (s2 == block && count2 == 1) {
                    if (i % 2 != 0) {
                        arr[x2][y2] = 'X';
                    } else {
                        arr[x2][y2] = 'O';
                    }
                    p = 1;
                    break;
                }

            }
            if (p == 1) {
                break;
            }
            boolean b = true;
            while (b) {

                int c1 = rand.nextInt(3);
                int c2 = rand.nextInt(3) + 1;
                if (arr[c1][c2] != ' ') {
                    continue;
                } else {
                    if (i % 2 != 0) {
                        arr[c1][c2] = 'X';
                    } else {
                        arr[c1][c2] = 'O';
                    }
                    b = false;
                    p = 1;
                }
            }
            if (p == 1) {
                break;
            }

        }
    }

    public static void computerInput(int i) {
        int c1, c2;
        System.out.println("Making move level \"easy\"");
        boolean b = true;
        while (b) {
            c1 = rand.nextInt(3);
            c2 = rand.nextInt(3) + 1;
            if (arr[c1][c2] != ' ') {

            } else {
                if (i % 2 != 0) {
                    arr[c1][c2] = 'X';
                } else {
                    arr[c1][c2] = 'O';
                }
                b = false;
            }
        }
    }

    public static void start() {
        for (int i = 0; i < 3; i++) {
            arr[i][0] = '|';
            arr[i][4] = '|';
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = ' ';
            }
        }
        code();
    }
}
