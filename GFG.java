import java.util.*;
public class GFG {
static String[] board;
static String[] board2;
static String turn;
static boolean freeze1;
static boolean freeze2;
//checks for winner for the 3x3
static String checkWinner()
{
    for (int a = 0; a < 8; a++) {
        String line = null;
        switch (a) 
        {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
        }
      if (line.equals("XXX")) {
         return "X";
      }

      else if (line.equals("OOO")) {
          return "O";
      }
    }

    for (int a = 0; a < 9; a++) {
        if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
            break;
        }
        else if (a == 8) {
            return "draw";
        }
    }
    System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in: ");
    return null;
}
//Checks for the winner the 5x5
static String checkWinner2()
{
    for (int a = 0; a < 12; a++) {
        String line = null;

        switch (a) {
            case 0:
                line = board2[0] + board2[1] + board2[2] +board2[3] + board2[4];
                break;
            case 1:
                line = board2[5] + board2[6] + board2[7] +board2[8] + board2[9];
                break;
            case 2:
                line = board2[10] + board2[11] + board2[12] +board2[13] + board2[14];
                break;
            case 3:
                line = board2[15] + board2[16] + board2[17] +board2[18] + board2[19];
                break;
            case 4:
                line = board2[20] + board2[21] + board2[22] +board2[23] + board2[24];
                break;
            case 5:
                line = board2[0] + board2[5] + board2[10] +board2[15] + board2[20];
                break;
            case 6:
                line = board2[1] + board2[6] + board2[11] +board2[16] + board2[21];
                break;
            case 7:
                line = board2[2] + board2[7] + board2[12] +board2[17] + board2[22];
                break;
            case 8:
                line = board2[3] + board2[8] + board2[13] +board2[18] + board2[23];
                break;
            case 9:
                line = board2[4] + board2[9] + board2[14] +board2[19] + board2[24];
                break;
            case 10:
                line = board2[0] + board2[6] + board2[12] +board2[18] + board2[24];
                break;
            case 11:
                line = board2[4] + board2[8] + board2[12] +board2[16] + board2[20];
                break;
        }
        if (line.equals("XXXXX") || line.equals("XX X X X ") || line.equals("XXX X X ") || line.equals("X X X X X ")) {
            return "X";
        }

        else if (line.equals("OOOOO") || line.equals("OOO O O ") || line.equals("OO O O O ") || line.equals("O O O O O ")) {
            return "O";
        }
    }

    for (int a = 0; a < 25; a++) {
        if (Arrays.asList(board2).contains(String.valueOf(a + 1))) {
            break;
        }
        else if (a == 24) {
            return "draw";
        }
    }

    System.out.println(turn + "'s turn; chose your move");
    return null;
}
// read it, shows board for 3x3
static void printBoard()
{
    System.out.println("    |   |    ");
    System.out.println("  " + board[0] + " | " + board[1] + " | " + board[2] + "  ");
    System.out.println("----|---|----");
    System.out.println("  " + board[3] + " | " + board[4] + " | " + board[5] + "  ");
    System.out.println("----|---|----");
    System.out.println("  " + board[6] + " | " + board[7] + " | " + board[8] + "  ");
    System.out.println("    |   |    ");
}
// shows board for 5x5
static void printBoard2()
{
    System.out.println("     |    |    |    |     ");
    System.out.println("  " + board2[0] + "  | " + board2[1] + "  | " + board2[2] + "  | " + board2[3] + "  | "  + board2[4] + "  ");
    System.out.println("-----|----|----|----|-----");
    System.out.println("  " + board2[5] + "  | " + board2[6] + "  | " + board2[7] + "  | " + board2[8] + "  | "  + board2[9] + "  ");
    System.out.println("-----|----|----|----|-----");
    System.out.println("  " + board2[10] + " | " + board2[11] + " | " + board2[12] + " | " + board2[13] + " | "  + board2[14] + "  ");
    System.out.println("-----|----|----|----|-----");
    System.out.println("  " + board2[15] + " | " + board2[16] + " | " + board2[17] + " | " + board2[18] + " | "  + board2[19] + "  ");
    System.out.println("-----|----|----|----|-----");
    System.out.println("  " + board2[20] + " | " + board2[21] + " | " + board2[22] + " | " + board2[23] + " | "  + board2[24] + "  ");
    System.out.println("     |    |    |    |     ");
}

public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    board = new String[9];
    turn = "X";
    String winner = null;
    for (int a = 0; a < 9; a++) {
        board[a] = String.valueOf(a + 1);
    }
    
    System.out.println("Welcome to 3x3 Tic Tac Toe.");
    printBoard();
    System.out.println("X will play first. Enter a slot number to place X in:");

    while (winner == null) {
        int numInput;

        try {
            numInput = in.nextInt();
            if (!(numInput > 0 && numInput <= 9)) {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input; re-enter slot number:");
            String killtest = in.nextLine();
            continue;
        }

        if (board[numInput - 1].equals(String.valueOf(numInput))) {
            board[numInput - 1] = turn;

            if (turn.equals("X")) {
                turn = "O";
            }
            else {
                turn = "X";
            }

            printBoard();
            winner = checkWinner();
        }
        else {
            System.out.println("Slot already taken; re-enter slot number:");
        }
    }

    if (winner.equalsIgnoreCase("draw")) {
        System.out.println("It's a draw! Round two.");
        int fren1 = 1;
        int fren2 = 1;
        int bold1 = 1;
        int bold2 = 1;
        int bomb1 = 1;
        int bomb2 = 1;
        int stick1 = 1;
        int stick2 = 1;
        int stal1 = 1;
        int stal2 = 1;
        int con1 = 0;
        int con2 = 0;
        int dri1 = 1;
        int dri2 = 1;
        boolean freeze1 = false;
        boolean freeze2 = false;
        board2 = new String[25];
        String clearing = in.nextLine();
        turn = "X";
        String winner2 = null;
        for (int a = 0; a < 25; a++) {
            board2[a] = String.valueOf(a + 1);
        }
        System.out.println("Welcome to 5x5 Tic Tac Toe. This round you have powers using a power that does not use your turn: \n  type \"N\" to activate a nuke which clears the entire board \n  type \"B\" to place a bolder which makes it so no one can place their piece on that spot\n  type \"F\" to freeze your opponent's next turn \n  type \"G\" to glue a spot causing the next person to place a piece on that spot to lose their next turn \n  type \"s\" to stall for a turn (acts as a secondary freeze) \n  type \"D\" to drill glue, boulders, and pieces away\n  type \"P\" to place a piece \n each player has one activation of each power.");
        printBoard2();
        System.out.println("X will play first. chose your move: ");
        while (winner2 == null) {
            int numInput;
            String typeMove;
            //String clearing = in.nextLine();
            try{
                typeMove = in.nextLine().toUpperCase();
                if (!(typeMove.equals("N") || typeMove.equals("B") || typeMove.equals("F") || typeMove.equals("G") || typeMove.equals("P") || typeMove.equals("C") || typeMove.equals("S") || typeMove.equals("D")))
                {
                    System.out.println("Invalid input; re-enter move choice:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter move:");
                continue;
            }
            if (typeMove.equals("D"))
            {
                if (turn.equals("X")){
                    if (dri1 > 0)
                    {
                        System.out.println("where to drill: ");
                        int binput;
                        try {
                            binput = in.nextInt();
                            if (!(binput > 0 && binput <= 25)) {
                                System.out.println("Invalid input; re-enter slot number:");
                                continue;
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            String killtest = in.nextLine();
                            continue;
                        }
                        board2[binput - 1] = "" + binput;
                        printBoard2();
                        String killtest = in.nextLine();
                        System.out.println(turn + "'s turn; choose your move: ");
                    }
                    else {
                        System.out.println("out of uses, try something else");
                        
                    }
                }
                else {
                    if (bold2 > 0)
                    {
                        System.out.println("where to put bolder: ");
                        int binput;
                        try {
                            binput = in.nextInt();
                            if (!(binput > 0 && binput <= 25)) {
                                System.out.println("Invalid input; re-enter move:");
                                continue;
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            String killtest = in.nextLine();
                            continue;
                        }
                        if (board2[binput - 1].equals(String.valueOf(binput))){
                            if (binput >= 10){
                                board2[binput - 1] = "B ";
                            }
                            else
                            {
                                board2[binput - 1] = "B";
                            }
                            bold2--;
                        }
                        else {
                            System.out.println("Slot already filled; re-enter slot number:");
                        }
                        printBoard2();
                        String killtest = in.nextLine();
                        System.out.println(turn + "'s turn; choose your move: ");
                    }
                    else {
                        System.out.println("out of uses, try something else :");
                    }
                }
            }
            if (typeMove.equals("N"))
            {
                if (turn.equals("X")){
                    if (bomb1 > 0)
                    {
                        System.out.println("god speed");
                        for (int a = 0; a < 25; a++) {
                            board2[a] = String.valueOf(a + 1);
                        }
                        printBoard2();
                        System.out.println(turn + "'s turn; choose your move: ");
                        bomb1--;
                    }
                    else{
                        System.out.println("out of uses, try something else :");
                    }
                }
                else {
                    if (bomb2 > 0)
                    {
                        System.out.println("god speed");
                        for (int a = 0; a < 25; a++) {
                            board2[a] = String.valueOf(a + 1);
                        }
                        printBoard2();
                        System.out.println(turn + "'s turn; choose your move:");
                        bomb2--;
                    }
                    else{
                        System.out.println("out of uses, try something else :");
                    }
                }
            }
            if (typeMove.equals("B"))
            {
                if (turn.equals("X")){
                    if (bold1 > 0)
                    {
                        System.out.println("where to put bolder: ");
                        int binput;
                        try {
                            binput = in.nextInt();
                            if (!(binput > 0 && binput <= 25)) {
                                System.out.println("Invalid input; re-enter slot number:");
                                continue;
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            String killtest = in.nextLine();
                            continue;
                        }
                        if (board2[binput - 1].equals(String.valueOf(binput))){
                            if (binput >= 10){
                                board2[binput - 1] = "B ";
                            }
                            else
                            {
                                board2[binput - 1] = "B";
                            }
                            bold1--;
                        }
                        else {
                            System.out.println("Slot already filled; re-enter slot number:");
                        }
                        printBoard2();
                        String killtest = in.nextLine();
                        System.out.println(turn + "'s turn; choose your move: ");
                    }
                    else {
                        System.out.println("out of uses, try something else");
                        
                    }
                }
                else {
                    if (bold2 > 0)
                    {
                        System.out.println("where to put bolder: ");
                        int binput;
                        try {
                            binput = in.nextInt();
                            if (!(binput > 0 && binput <= 25)) {
                                System.out.println("Invalid input; re-enter move:");
                                continue;
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            String killtest = in.nextLine();
                            continue;
                        }
                        if (board2[binput - 1].equals(String.valueOf(binput))){
                            if (binput >= 10){
                                board2[binput - 1] = "B ";
                            }
                            else
                            {
                                board2[binput - 1] = "B";
                            }
                            bold2--;
                        }
                        else {
                            System.out.println("Slot already filled; re-enter slot number:");
                        }
                        printBoard2();
                        String killtest = in.nextLine();
                        System.out.println(turn + "'s turn; choose your move: ");
                    }
                    else {
                        System.out.println("out of uses, try something else :");
                    }
                }
            }
            if (typeMove.equals("F"))
            {
                if (turn.equals("X")){
                    if (fren1 > 0)
                    {
                        System.out.println("O has been frozen");
                        freeze1 = true;
                        fren1--;
                    }
                    else{
                        System.out.println("out of uses, try something else :");
                    }
                }
                else {
                    if (fren2 > 0)
                    {
                        System.out.println("X has been frozen");
                        freeze2 = true;
                        fren2--;
                    }
                    else{
                        System.out.println("out of uses, try something else :");
                    }
                }
                System.out.println(turn + "'s turn; choose your move: ");
            }
            if (typeMove.equals("G"))
            {
                if (turn.equals("X")){
                    if (stick1 > 0)
                    {
                        System.out.println("where to put glue: ");
                        int binput;
                        try {
                            binput = in.nextInt();
                            if (!(binput > 0 && binput <= 25)) {
                                System.out.println("Invalid input; re-enter slot number:");
                                continue;
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            String killtest = in.nextLine();
                            continue;
                        }
                        if (board2[binput - 1].equals(String.valueOf(binput))){
                            if (binput >= 10){
                                board2[binput - 1] = "G ";
                            }
                            else
                            {
                                board2[binput - 1] = "G";
                            }
                            stick1--;
                        }
                        else {
                            System.out.println("Slot already filled; re-enter slot number:");
                        }
                        printBoard2();
                        String killtest = in.nextLine();
                        System.out.println(turn + "'s turn; choose your move: ");
                    }
                    else {
                        System.out.println("out of uses, try something else");
                        
                    }
                }
                else {
                    if (stick2 > 0)
                    {
                        System.out.println("where to put glue: ");
                        int binput;
                        try {
                            binput = in.nextInt();
                            if (!(binput > 0 && binput <= 25)) {
                                System.out.println("Invalid input; re-enter move:");
                                continue;
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            String killtest = in.nextLine();
                            continue;
                        }
                        if (board2[binput - 1].equals(String.valueOf(binput))){
                            if (binput >= 10){
                                board2[binput - 1] = "G ";
                            }
                            else
                            {
                                board2[binput - 1] = "G";
                            }
                            stick2--;
                        }
                        else {
                            System.out.println("Slot already filled; re-enter slot number:");
                        }
                        printBoard2();
                        String killtest = in.nextLine();
                        System.out.println(turn + "'s turn; choose your move: ");
                    }
                    else {
                        System.out.println("out of uses, try something else :");
                    }
                }
            }
            if (typeMove.equals("S"))
            {
                if (turn.equals("X")){
                    if (stal1 > 0)
                    {
                        System.out.println("you have stalled for time");
                        freeze1 = true;
                        stal1--;
                        con1 = 2;
                    }
                    else{
                        System.out.println("out of uses, try something else :");
                    }
                }
                else {
                    if (stal2 > 0)
                    {
                        System.out.println("you have stalled for time");
                        freeze2 = true;
                        stal2--;
                        con2 = 2;
                    }
                    else{
                        System.out.println("out of uses, try something else :");
                    }
                }
                System.out.println(turn + "'s turn; choose your move ");
            }
            if (typeMove.equals("C"))
            {
                System.out.println("car");
                System.out.println("you got hit by a car, you recover after 14 years. Time to finish what you started.");
                System.out.println(turn + "'s turn; choose your move: ");
            }
            if (typeMove.equals("P")){
                System.out.println("where to place:");
                try {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 25)) {
                        System.out.println("Invalid input; re-enter slot number:");
                        continue;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input; re-enter slot number:");
                    String killtest = in.nextLine();
                    continue;
                }
                if (board2[numInput - 1].equals(String.valueOf(numInput)) || board2[numInput - 1].equals("G")) {
                    boolean gl = false;
                    if (board2[numInput - 1].equals("G"))
                    {
                        gl = true;
                    }
                    if (numInput >= 10){
                        board2[numInput - 1] = turn + " ";
                    }
                    else{
                        board2[numInput - 1] = turn;
                    }
                    if (turn.equals("X")){
                        if (con1 == 1)
                        {
                            freeze1 = true;
                            con1--;
                        }
                        if (con1 > 0)
                        {
                            con1--;
                        }
                        if (freeze1 == true)
                        {
                            System.out.println("O's turn has been skipped");
                            freeze1 = false;
                        }
                        else{
                            turn = "O";
                            if (gl == true)
                            {
                                System.out.println("steped in glue");
                                freeze2 = true;
                            }
                        }
                    }
                    else{
                        if (con2 == 1)
                        {
                            freeze2 = true;
                            con2--;
                        }
                        if (con2 > 0)
                        {
                            con2--;
                        }
                        if (freeze2 == true)
                        {
                            System.out.println("X's turn has been skipped");
                            freeze2 = false;
                        }
                        else{
                            turn = "X";
                            if (gl == true)
                            {
                                System.out.print("steped in glue");
                                freeze1 = true;
                            }
                        }
                    }
                    printBoard2();
                    String killtest = in.nextLine();
                    winner2 = checkWinner2();
                }
                else {
                    System.out.println("Slot already taken; re-enter slot number:");
                }
            }
        }
        if (winner2.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! bruh. `HOW DID YOU MANAGE THAT?!");
        }
        else {
            System.out.println("Congratulations! " + winner2 + "'s have won! Thanks for playing.");
        }
    }
    else {
    System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
    }
    in.close();
}
}

