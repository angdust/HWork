package solver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        /*
         * The first and second array number is the location
         * and the value is the color
         * 1 = GREEN
         * 2 = WHITE
         * 3 = BLUE
         * 4 = YELLOW
         * 5 = ORANGE
         * 6 = RED
         */
        Cube cube = new Cube();
        //get the colors that is on the cube right now
        cube.colors = getColors();
        System.out.println("Checkpoint");
        CubeSlover cubeSlover = new CubeSlover();
        cube = cubeSlover.makeSolution(cube);
        System.out.println("Checkpoint");

        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(cube.colors[t][d] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] getColors() {
        int input[][] = new int[6][9];
//        int counter_0 = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the colors\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
                "4 = YELLOW\n5 = ORANGE\n6 = RED\n");
        int c = 0;
        while (c < 6) {
            int i = 0;
            String[] line = in.nextLine().split(" ");
            while (i < 9) {
                input[c][i] = Integer.parseInt(line[i]);
                i++;
            }
            c++;
        }
//        while (counter_0 <= 6) {
//            String[] line = in.nextLine().split(" ");
//            for(int i = 0; i < 9; i++) {
//                input[counter_0][i] = Integer.parseInt(line[i]);
//            }
//            counter_0++;
//        }
//        System.out.println("Enter the colors for the white side\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
//                "4 = YELLOW\n5 = ORANGE\n6 = RED\n"
//                + "The orange on top\n"
//                + "The blue to the right");
//        counter_0 = 0;
//        while (counter_0 <= 8) {
//            input[1][counter_0] = Integer.parseInt(in.nextLine());
//            counter_0++;
//        }
//        System.out.println("Enter the colors for the blue side\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
//                "4 = YELLOW\n5 = ORANGE\n6 = RED\n"
//                + "The orange on top\n"
//                + "The yellow to the right");
//        counter_0 = 0;
//        while (counter_0 <= 8) {
//            input[2][counter_0] = Integer.parseInt(in.nextLine());
//            counter_0++;
//        }
//        System.out.println("Enter the colors for the yellow side\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
//                "4 = YELLOW\n5 = ORANGE\n6 = RED\n"
//                + "The orange on top\n"
//                + "The green to the right");
//        counter_0 = 0;
//        while (counter_0 <= 8) {
//            input[3][counter_0] = Integer.parseInt(in.nextLine());
//            counter_0++;
//        }
//        System.out.println("Enter the colors for the orange side\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
//                "4 = YELLOW\n5 = ORANGE\n6 = RED\n"
//                + "The yellow on top\n"
//                + "The blue to the right");
//        counter_0 = 0;
//        while (counter_0 <= 8) {
//            input[4][counter_0] = Integer.parseInt(in.nextLine());
//            counter_0++;
//        }
//        System.out.println("Enter the colors for the red side\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
//                "4 = YELLOW\n5 = ORANGE\n6 = RED\n"
//                + "The white on top\n"
//                + "The blue to the right");
//        counter_0 = 0;
//        while (counter_0 <= 8) {
//            input[5][counter_0] = Integer.parseInt(in.nextLine());
//            counter_0++;
//        }
        return input;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
