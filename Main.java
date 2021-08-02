import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
import java.util.Scanner;

public class Main {
    private static HttpURLConnection connection;

    public static String player1;
    public static String player2;
    public static String player3;
    public static String player4;

    private static int lastScorePlayer1 = 0;
    private static int sumPlayer1;

    private static int lastScorePlayer2 = 0;
    private static int sumPlayer2;

    private static int lastScorePlayer3 = 0;
    private static int sumPlayer3;

    private static int lastScorePlayer4 = 0;
    private static int sumPlayer4;

    public static int score() {

        BufferedReader reader;
        String line;

        try {

            URL url = new URL("http://developer-test.hishab.io/api/v1/roll-dice");
            connection = (HttpURLConnection) url.openConnection();
            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                line = reader.readLine();
                reader.close();

                try {
                    JSONObject json = new JSONObject(line);

                    int score = json.getInt("score");
                    return score;

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static int calculateScore4thPlayer() {

        Scanner scan1 = new Scanner(System.in);
        String line;

        int score = score();

        if (score >= 6 && lastScorePlayer4 == 0) {
            lastScorePlayer4 = score;
            sumPlayer4 = 0;

            return sumPlayer4;
        }

        if (score < 6 && lastScorePlayer4 == 0) {
            lastScorePlayer4 = score;
            return sumPlayer4;
        }

        if (score == 6 && sumPlayer4 == 0) {
            lastScorePlayer4 = score;
            sumPlayer3 = 0;

            return sumPlayer4;
        }

        if (score == 4 && lastScorePlayer4 > 0 && lastScorePlayer4 != 4) {
            lastScorePlayer4 = score;

            if (sumPlayer4 > 0) {
                sumPlayer4 = sumPlayer4 - 4;

                return sumPlayer4;
            } else {
                return sumPlayer4;
            }
        }

        if (sumPlayer4 > 0 && lastScorePlayer4 > 0) {

            lastScorePlayer4 = score;
            sumPlayer4 = sumPlayer4 + score;

            return sumPlayer4;
        }

        if (lastScorePlayer4 == 6 && sumPlayer4 > 0 && lastScorePlayer4 > 0) {

            lastScorePlayer4 = score;
            sumPlayer4 = sumPlayer4 + score;

            return calculateScore4thPlayer();
        }

        if (lastScorePlayer4 == 4) {
            lastScorePlayer4 = score;

            return sumPlayer4;
        }

        return sumPlayer4 = sumPlayer4 + score;
    }

    public static int calculateScore3rdPlayer() {

        Scanner scan1 = new Scanner(System.in);
        String line;        

        int score = score();

        if (score >= 6 && lastScorePlayer3 == 0) {
            lastScorePlayer3 = score;
            sumPlayer3 = 0;

            return sumPlayer3;
        }

        if (score < 6 && lastScorePlayer3 == 0) {
            lastScorePlayer3 = score;
            return sumPlayer3;
        }

        if (score == 6 && sumPlayer3 == 0) {
            lastScorePlayer3 = score;
            sumPlayer3 = 0;

            return sumPlayer3;
        }

        if (score == 4 && lastScorePlayer3 > 0 && lastScorePlayer3 != 4) {
            lastScorePlayer3 = score;

            if (sumPlayer3 > 0) {
                sumPlayer3 = sumPlayer3 - 4;

                return sumPlayer3;
            } else {
                return sumPlayer3;
            }
        }

        if (sumPlayer3 > 0 && lastScorePlayer3 > 0) {

            lastScorePlayer3 = score;
            sumPlayer3 = sumPlayer3 + score;

            return sumPlayer3;
        }

        if (lastScorePlayer3 == 6 && sumPlayer3 > 0 && lastScorePlayer3 > 0) {

            lastScorePlayer3 = score;
            sumPlayer3 = sumPlayer3 + score;

            return calculateScore3rdPlayer();
        }

        if (lastScorePlayer3 == 4) {
            lastScorePlayer3 = score;

            return sumPlayer3;
        }

        return sumPlayer3 = sumPlayer3 + score;
    }

    public static int calculateScore2ndPlayer() {

        Scanner scan1 = new Scanner(System.in);
        String line;        

        int score = score();

        if (score >= 6 && lastScorePlayer2 == 0) {
            lastScorePlayer2 = score;
            sumPlayer2 = 0;

            return sumPlayer2;
        }

        if (score < 6 && lastScorePlayer2 == 0) {
            lastScorePlayer2 = score;
            return sumPlayer2;
        }

        if (score == 6 && sumPlayer2 == 0) {
            lastScorePlayer2 = score;
            sumPlayer2 = 0;

            return sumPlayer2;
        }

        if (score == 4 && lastScorePlayer2 > 0 && lastScorePlayer2 != 4) {
            lastScorePlayer2 = score;

            if (sumPlayer2 > 0) {
                sumPlayer2 = sumPlayer2 - 4;

                return sumPlayer2;
            } else {
                return sumPlayer2;
            }
        }

        if (sumPlayer2 > 0 && lastScorePlayer2 > 0) {

            lastScorePlayer2 = score;
            sumPlayer2 = sumPlayer2 + score;

            return sumPlayer2;
        }

        if (lastScorePlayer2 == 6 && sumPlayer2 > 0 && lastScorePlayer2 > 0) {

            lastScorePlayer2 = score;
            sumPlayer2 = sumPlayer2 + score;

            return calculateScore2ndPlayer();
        }

        if (lastScorePlayer2 == 4) {
            lastScorePlayer2 = score;

            return sumPlayer2;
        }

        return sumPlayer2 = sumPlayer2 + score;
    }

    public static int calculateScoreFirstPlayer() {

        Scanner scan1 = new Scanner(System.in);
        String line;        

        int score = score();

        if (score >= 6 && lastScorePlayer1 == 0) {

            lastScorePlayer1 = score;
            sumPlayer1 = 0;

            return sumPlayer1;
        }

        if (score < 6 && lastScorePlayer1 == 0) {
            lastScorePlayer1 = score;
            return sumPlayer1;
        }

        if (score == 6 && sumPlayer1 == 0) {
            lastScorePlayer1 = score;
            sumPlayer1 = 0;

            return sumPlayer1;
        }

        if (score == 4 && lastScorePlayer1 > 0 && lastScorePlayer1 != 4) {
            lastScorePlayer1 = score;

            if (sumPlayer1 > 0) {
                sumPlayer1 = sumPlayer1 - 4;

                return sumPlayer1;
            } else {
                return sumPlayer1;
            }
        }

        if (sumPlayer1 > 0 && lastScorePlayer1 > 0) {

            lastScorePlayer1 = score;
            sumPlayer1 = sumPlayer1 + score;

            return sumPlayer1;
        }

        if (lastScorePlayer1 == 6 && sumPlayer1 > 0 && lastScorePlayer1 > 0) {
            lastScorePlayer1 = score;
            sumPlayer1 = sumPlayer1 + score;

            return calculateScoreFirstPlayer();
        }

        if (lastScorePlayer1 == 4) {
            lastScorePlayer1 = score;
            return sumPlayer1;
        }

        return sumPlayer1 = sumPlayer1 + score;
    }

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);

        String line;

        Integer playerNo = 0;

        System.out.println("Please, Put right number of player (Minimum 2 player and maximum 4 player): ");
        playerNo = Integer.parseInt(scan2.nextLine());

        if (playerNo >= 2 && playerNo <= 4) {

            switch (playerNo) {
                case 2:
                    System.out.println("Please, write the name of the first player: ");
                    player1 = scan1.nextLine();

                    System.out.println("Please, write the name of the 2nd player: ");
                    player2 = scan1.nextLine();

                    int nextTurn = 1;

                    for (int i = 0; i < nextTurn; i++) {

                        int sumOfFirst = calculateScoreFirstPlayer();
                        System.out.println("Player Name: " + player1 + "\nTotal Score: " + sumOfFirst
                                + "\nCurrent Value of Dice: " + lastScorePlayer1);

                        if (sumOfFirst > 20 && sumOfFirst < 25) {

                            System.out.println("Player Name: " + player1 + " Win!");
                            break;

                        } else {
                            System.out.println("Do you want to throw for player " + player2 + ", please press y");
                            line = scan3.nextLine();

                            String yesCharPlayer1 = line.toUpperCase();

                            if (yesCharPlayer1.equals("Y")) {
                                int sumOf2nd = calculateScore2ndPlayer();

                                System.out.println("Player Name: " + player2 + "\nTotal Score: " + sumOf2nd
                                        + "\nCurrent Value of Dice: " + lastScorePlayer2);

                                if (sumOf2nd > 20 && sumOf2nd < 25) {

                                    System.out.println("Player Name: " + player2 + " Win!");
                                    break;

                                } else {
                                    nextTurn = nextTurn + 1;
                                    System.out
                                            .println("Do you want to throw for player " + player1 + ", please press y");
                                    line = scan3.nextLine();

                                    String yesCharPlayer2 = line.toUpperCase();

                                    if (yesCharPlayer2.equals("Y")) {
                                        continue;
                                    }
                                }
                            }
                        }
                    }

                    break;

                case 3:
                    System.out.println("Please, write the name of the first player: ");
                    player1 = scan1.nextLine();

                    System.out.println("Please, write the name of the second player: ");
                    player2 = scan1.nextLine();

                    System.out.println("Please, write the name of the Third player: ");
                    player3 = scan1.nextLine();

                    int nextTurn3 = 1;

                    for (int i = 0; i < nextTurn3; i++) {

                        int sumOfFirst = calculateScoreFirstPlayer();
                        System.out.println("Player Name: " + player1 + "\nTotal Score: " + sumOfFirst
                                + "\nCurrent Value of Dice: " + lastScorePlayer1);

                        if (sumOfFirst > 20 && sumOfFirst < 25) {

                            System.out.println("Player Name: " + player1 + " Win!");
                            break;

                        } else {
                            System.out.println("Do you want to throw for player " + player2 + ", please press y");
                            line = scan3.nextLine();

                            String yesPlayer1 = line.toUpperCase();

                            if (yesPlayer1.equals("Y")) {
                                int sumOf2nd = calculateScore2ndPlayer();

                                System.out.println("Player Name: " + player2 + "\nTotal Score: " + sumOf2nd
                                        + "\nCurrent Value of Dice: " + lastScorePlayer2);

                                if (sumOf2nd > 20 && sumOf2nd < 25) {

                                    System.out.println("Player Name: " + player2 + " Win!");
                                    break;

                                } else {

                                    System.out
                                            .println("Do you want to throw for player " + player3 + ", please press y");
                                    line = scan3.nextLine();

                                    String yesPlayer3 = line.toUpperCase();

                                    if (yesPlayer3.equals("Y")) {

                                        if (yesPlayer3.equals("Y")) {
                                            int sumOf3rd = calculateScore3rdPlayer();

                                            System.out.println("Player Name: " + player3 + "\nTotal Score: " + sumOf3rd
                                                    + "\nCurrent Value of Dice: " + lastScorePlayer3);

                                            if (sumOf3rd > 20 && sumOf3rd < 25) {

                                                System.out.println("Player Name: " + player3 + " Win!");
                                                break;

                                            } else {
                                                nextTurn3 = nextTurn3 + 1;
                                                System.out.println("Do you want to throw for player " + player1
                                                        + ", please press y");
                                                line = scan3.nextLine();

                                                if (line.toUpperCase().equals("Y")) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;

                case 4:
                    System.out.println("Please, write the name of the First player: ");
                    player1 = scan1.nextLine();

                    System.out.println("Please, write the name of the second player: ");
                    player2 = scan1.nextLine();

                    System.out.println("Please, write the name of the Third player: ");
                    player3 = scan1.nextLine();

                    System.out.println("Please, write the name of the Fourth player: ");
                    player4 = scan1.nextLine();

                    int nextTurn4 = 1;

                    for (int i = 0; i < nextTurn4; i++) {

                        int sumOfFirst = calculateScoreFirstPlayer();
                        System.out.println("Player Name: " + player1 + "\nTotal Score: " + sumOfFirst
                                + "\nCurrent Value of Dice: " + lastScorePlayer1);

                        if (sumOfFirst > 20 && sumOfFirst < 25) {

                            System.out.println("Player Name: " + player1 + " Win!");
                            break;

                        } else {
                            System.out.println("Do you want to throw for player " + player2 + ", please press y");
                            line = scan3.nextLine();

                            String yesPlayer1 = line.toUpperCase();

                            if (yesPlayer1.equals("Y")) {
                                int sumOf2nd = calculateScore2ndPlayer();

                                System.out.println("Player Name: " + player2 + "\nTotal Score: " + sumOf2nd
                                        + "\nCurrent Value of Dice: " + lastScorePlayer2);

                                if (sumOf2nd > 20 && sumOf2nd < 25) {

                                    System.out.println("Player Name: " + player2 + " Win!");
                                    break;

                                } else {

                                    System.out
                                            .println("Do you want to throw for player " + player3 + ", please press y");
                                    line = scan3.nextLine();

                                    String yesPlayer3 = line.toUpperCase();

                                    if (yesPlayer3.equals("Y")) {

                                        if (yesPlayer3.equals("Y")) {
                                            int sumOf3rd = calculateScore3rdPlayer();

                                            System.out.println("Player Name: " + player3 + "\nTotal Score: " + sumOf3rd
                                                    + "\nCurrent Value of Dice: " + lastScorePlayer3);

                                            if (sumOf3rd > 20 && sumOf3rd < 25) {

                                                System.out.println("Player Name: " + player3 + " Win!");
                                                break;

                                            } else {

                                                System.out.println("Do you want to throw for player " + player4
                                                        + ", please press y");
                                                line = scan3.nextLine();

                                                if (line.toUpperCase().equals("Y")) {

                                                    int sumOf4th = calculateScore4thPlayer();

                                                    System.out.println(
                                                            "Player Name: " + player4 + "\nTotal Score: " + sumOf4th
                                                                    + "\nCurrent Value of Dice: " + lastScorePlayer4);

                                                    if (sumOf4th > 20 && sumOf4th < 25) {

                                                        System.out.println("Player Name: " + player4 + " Win!");
                                                        break;

                                                    } else {
                                                        nextTurn4 = nextTurn4 + 1;
                                                        System.out.println("Do you want to throw for player " + player1
                                                                + ", please press y");
                                                        line = scan3.nextLine();

                                                        if (line.toUpperCase().equals("Y")) {
                                                            continue;
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;

                default:
                    // code block
            }

        }

    }

}
