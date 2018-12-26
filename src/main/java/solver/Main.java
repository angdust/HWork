package solver;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.paint.Color.WHITE;

public class Main extends Application {
    public static Cube rCube = new Cube();
    public static String results = new String();
    private static Pane app = new Pane();
    private String[][] input = new String[6][9];
    private int counter = 0;
    private boolean isCorrect = true;

    public static void main(String[] args) {
        launch(args);
//        Cube cube = new Cube();
//        cube.colors = getColors1();
//        System.out.println("Checkpoint");
//        CubeSlover cubeSlover = new CubeSlover();
//        cube = cubeSlover.makeSolution(cube);
//        System.out.println("Checkpoint");
//
//        for (int t = 0; t < 6; t++) {
//            for (int d = 0; d < 9; d++) {
//                System.out.print(cube.colors[t][d] + " ");
//            }
//            System.out.println();
//        }
    }

    public static int[][] getColors1() {
        int input[][] = new int[6][9];
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
        return input;
    }

    private int[][] getColors() {
        int rInput[][] = new int[6][9];
        int c = 0;
        int[] check = new int[6];
        while (c < 6) {
            int i = 0;
            while (i < 9) {
                rInput[c][i] = Integer.parseInt(this.input[c][i]);
                i++;
            }
            c++;
        }
        for (int j = 0; j < 6; j++) {
            for (int t = 0; t < 9; t++) {
                if (rInput[j][t] == 1) {
                    check[0]++;
                } else if (rInput[j][t] == 2) {
                    check[1]++;
                } else if (rInput[j][t] == 3) {
                    check[2]++;
                } else if (rInput[j][t] == 4) {
                    check[3]++;
                } else if (rInput[j][t] == 5) {
                    check[4]++;
                } else if (rInput[j][t] == 6) {
                    check[5]++;
                }
            }
        }
            for (int t = 0; t < 6; t++) {
                if (check[t] >= 10) {
                    isCorrect = false;
                }
            }
        return rInput;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(app, 1000, 700, WHITE);
        primaryStage.setTitle("Rubik's solver");
        primaryStage.setScene(scene);
        Text rule = new Text("Введите цвета клеток по порядку, указзаному на схеме.\n" +
                "По одной стороне куба (пример: 1 2 3 4 5 6 7 8 9).");
        rule.setLayoutX(30);
        rule.setLayoutY(30);
        TextField textField = new TextField();
        textField.setLayoutX(30);
        textField.setLayoutY(80);
        Text codeOfColors = new Text("Коды цветов клеток\n1 = GREEN\n2 = WHITE\n3 = BLUE\n" +
                "4 = YELLOW\n5 = ORANGE\n6 = RED");
        Button loadB = new Button("Загрузить сторону");
        codeOfColors.setLayoutX(30);
        codeOfColors.setLayoutY(135);
        Text currentCube = new Text("Заданное значение по строкам:\n");
        currentCube.setLayoutY(135);
        currentCube.setLayoutX(220);
        loadB.setLayoutY(80);
        loadB.setLayoutX(220);
        loadB.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Pattern p = Pattern.compile("[1-6] [1-6] [1-6] [1-6] [1-6] [1-6] [1-6] [1-6] [1-6]");
                Matcher m = p.matcher(textField.getText());
                if (m.matches() && counter < 6) {
                    input[counter] = textField.getText().split(" ");
                    counter++;
                    textField.clear();
                }
            }
        });
        Button fromFileB = new Button("из файла");
        fromFileB.setLayoutX(370);
        fromFileB.setLayoutY(80);
        fromFileB.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(new File("input/input1.txt")));
                    int count = 0;
                    String line;
                    while (((line = bufferedReader.readLine()) != null) && (count <= 6)) {
                        input[count] = line.split(" ");
                        count++;
                        counter = 6;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button startB = new Button("Старт");
        startB.setLayoutX(420);
        startB.setLayoutY(20);
        startB.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (counter >= 5) {
                    rCube.colors = getColors();
                    String curStr = new String();
                    for (int t = 0; t < 6; t++) {
                        for (int d = 0; d < 9; d++) {
                            curStr += rCube.colors[t][d] + " ";
                        }
                        curStr += "\n";
                    }
                    Text cuCube = new Text(curStr);
                    cuCube.setLayoutX(250);
                    cuCube.setLayoutY(150);

                    CubeSlover cubeSlover = new CubeSlover();
                    if (isCorrect) {
                        rCube = cubeSlover.makeSolution(rCube);
                    }
                    System.out.println("Checkpoint");
                    for (int t = 0; t < 6; t++) {
                        for (int d = 0; d < 9; d++) {
                            if (rCube.colors[t][d] != t + 1){
                                isCorrect = false;
                            }
                        }
                    }
                    System.out.println("Cheсkpoint");
                    ScrollPane resultTXT = new ScrollPane();
                    resultTXT.setLayoutX(700);
                    resultTXT.setLayoutY(10);
                    resultTXT.setPrefViewportHeight(650);
                    if (isCorrect) {
                        resultTXT.setContent(new Label(results));
                    } else {
                        resultTXT.setContent(new Label("Ошибка ввода.\n Проверьте входные данные\n " +
                                "и перезапустите программу."));
                    }
                    app.getChildren().add(new Group(cuCube, resultTXT));
                    for (int t = 0; t < 6; t++) {
                        for (int d = 0; d < 9; d++) {
                            System.out.print(rCube.colors[t][d] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        });
        ImageView iVCube = new ImageView(new Image("cube.png"));
        iVCube.setFitWidth(600);
        iVCube.setFitHeight(350);
        iVCube.setLayoutX(10);
        iVCube.setLayoutY(340);
        Group group = new Group(rule, textField, loadB, startB, iVCube, codeOfColors, currentCube, fromFileB);
        app.getChildren().add(group);
        primaryStage.show();
    }
}
