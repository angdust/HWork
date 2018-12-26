import org.junit.Test;
import solver.Cube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static solver.CubeSlover.makeSolution;

public class TestRubic {
    int[][] correctCube = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3, 3, 3, 3, 3},
            {4, 4, 4, 4, 4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {6, 6, 6, 6, 6, 6, 6, 6, 6}};

    private static String[][] getFromFile(String inputFileName) throws IOException {
        String[][] input = new String[6][9];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(inputFileName)));
        int count = 0;
        String line;
        while (((line = bufferedReader.readLine()) != null) && (count <= 6)) {
            input[count] = line.split(" ");
            count++;
        }
        return input;
    }

    public static boolean equalsArray(double[] a, double[] b) {
        if (a.length != b.length)
            return false;
        else {
            for (int i = 0; i < a.length; i++)
                if (a[i] != b[i])
                    return false;
        }
        return true;
    }

    private int[][] getColors(String[][] input) throws IOException {
        int rInput[][] = new int[6][9];
        int c = 0;
        int[] check = new int[5];
        while (c < 6) {
            int i = 0;
            while (i < 9) {
                rInput[c][i] = Integer.parseInt(input[c][i]);
                i++;
            }
            c++;
        }
        return rInput;
    }

    @Test
    public void doTests() throws IOException {
        Boolean isCorrect = true;
        Cube cube = new Cube();
        cube.colors = getColors(getFromFile("input/input.txt"));
        cube = makeSolution(cube);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cube.colors[t][d] != t + 1) {
                    isCorrect = false;
                }
            }
        }
        Boolean isCorrect1 = true;
        Cube cube1 = new Cube();
        cube1.colors = getColors(getFromFile("input/input1.txt"));
        cube1 = makeSolution(cube1);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cube1.colors[t][d] != t + 1) {
                    isCorrect1 = false;
                }
            }
        }
        Boolean isCorrect2 = true;
        Cube cube2 = new Cube();
        cube2.colors = getColors(getFromFile("input/input2.txt"));
        cube2 = makeSolution(cube2);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cube2.colors[t][d] != t + 1) {
                    isCorrect2 = false;
                }
            }
        }
        Boolean isCorrect3 = true;
        Cube cube3 = new Cube();
        cube3.colors = getColors(getFromFile("input/input3.txt"));
        cube3 = makeSolution(cube3);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cube3.colors[t][d] != t + 1) {
                    isCorrect3 = false;
                }
            }
        }
        Boolean isCorrect4 = true;
        Cube cube4 = new Cube();
        cube4.colors = getColors(getFromFile("input/input4.txt"));
        cube4 = makeSolution(cube4);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cube4.colors[t][d] != t + 1) {
                    isCorrect4 = false;
                }
            }
        }
        Boolean isCorrect5 = true;
        Cube cube5 = new Cube();
        cube5.colors = getColors(getFromFile("input/input5.txt"));
        cube5 = makeSolution(cube5);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cube5.colors[t][d] != t + 1) {
                    isCorrect5 = false;
                }
            }
        }
        Boolean isCorrect6 = true;
        Cube cubeEr1 = new Cube();
        cubeEr1.colors = getColors(getFromFile("input/inputError1.txt"));
        cubeEr1 = makeSolution(cubeEr1);
        for (int t = 0; t < 6; t++) {
            for (int d = 0; d < 9; d++) {
                if (cubeEr1.colors[t][d] != t + 1) {
                    isCorrect6 = false;
                }
            }
        }
        Boolean isCorrect7 = true;
        Cube cubeEr2 = new Cube();
        int[] check = new int[6];
        cubeEr2.colors = getColors(getFromFile("input/inputError2.txt"));
        for (int j = 0; j < 6; j++) {
            for (int t = 0; t < 9; t++) {
                if (cube.colors[j][t] == 1) {
                    check[0]++;
                } else if (cube.colors[j][t] == 2) {
                    check[1]++;
                } else if (cube.colors[j][t] == 3) {
                    check[2]++;
                } else if (cube.colors[j][t] == 4) {
                    check[3]++;
                } else if (cube.colors[j][t] == 5) {
                    check[4]++;
                } else if (cube.colors[j][t] == 6) {
                    check[5]++;
                }
            }
        }
        for (int t = 0; t < 6; t++) {
            if (check[t] >= 10) {
                isCorrect7 = false;
            }
        }
        System.out.println("hi");
        assertTrue(isCorrect);
        assertTrue(isCorrect1);
        assertTrue(isCorrect2);
        assertTrue(isCorrect3);
        assertTrue(isCorrect4);
        assertTrue(isCorrect5);
        assertFalse(isCorrect6);
        assertTrue(isCorrect7);
    }
}
