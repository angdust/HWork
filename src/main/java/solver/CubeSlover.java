package solver;

import static solver.Cube.*;

public class CubeSlover {
    public static Cube makeSolution(Cube cube) {
        cube = doWhiteSide(cube);
        cube = doMiddleLayer(cube);
        cube = doYellowSide(cube);

        return cube;
    }

    public static Cube doWhiteSide(Cube cube) {
        cube = doWhiteCross(cube);
        cube = doWhiteCorners(cube);

        return cube;
    }

    public static Cube doWhiteCross(Cube cube) {
        cube = replaceFirstWPiece(cube);
        cube = replaceSecondWPiece(cube);
        cube = replaceThirdWPiece(cube);
        cube = replaceFourthWPiece(cube);
        Main.results += ("Белый крест сделан.\n");

        return cube;
    }

    public static Cube doYellowSide(Cube cube) {
        cube = doUnCYellowCross(cube);
        Main.results += ("Неправильный желтый крест сделан.\n");
        cube = doCYellowCross(cube);
        Main.results += ("Правильный желтый крест сделан.\n");
        cube = replaceYellowCorners(cube);
        Main.results += ("Желтые углы на местах.\n");
        cube = doYellowCorners(cube);
        Main.results += ("Кубик собран.\n");
        return cube;
    }

    //переставляем в желтом слое углы туда, где они должны быть
    public static Cube replaceYellowCorners(Cube cube) {
        boolean fi = false;
        boolean s = false;
        boolean t = false;
        boolean fo = false;
        if ((cube.colors[4][2] == 5 && cube.colors[2][2] == 3 && cube.colors[3][0] == 4) ||
                (cube.colors[4][2] == 4 && cube.colors[2][2] == 5 && cube.colors[3][0] == 3) ||
                (cube.colors[4][2] == 3 && cube.colors[2][2] == 4 && cube.colors[3][0] == 5)) {
            fi = true;
        }
        if ((cube.colors[0][0] == 1 && cube.colors[4][0] == 5 && cube.colors[3][2] == 4) ||
                (cube.colors[0][0] == 4 && cube.colors[4][0] == 1 && cube.colors[3][2] == 5) ||
                (cube.colors[0][0] == 5 && cube.colors[4][0] == 4 && cube.colors[3][2] == 1)) {
            s = true;
        }
        if ((cube.colors[5][6] == 6 && cube.colors[0][6] == 1 && cube.colors[3][8] == 4) ||
                (cube.colors[5][6] == 4 && cube.colors[0][6] == 6 && cube.colors[3][8] == 1) ||
                (cube.colors[5][6] == 1 && cube.colors[0][6] == 4 && cube.colors[3][8] == 6)) {
            t = true;
        }
        if ((cube.colors[2][8] == 3 && cube.colors[5][8] == 6 && cube.colors[3][6] == 4) ||
                (cube.colors[2][8] == 4 && cube.colors[5][8] == 3 && cube.colors[3][6] == 6) ||
                (cube.colors[2][8] == 6 && cube.colors[5][8] == 4 && cube.colors[3][6] == 3)) {
            fo = true;
        }

        if (!fi && !s && !t && !fo) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        }

        if (fi && s && t && fo) {
            return cube;
        } else if ((cube.colors[0][0] == 1 && cube.colors[4][0] == 5 && cube.colors[3][2] == 4) ||
                (cube.colors[0][0] == 4 && cube.colors[4][0] == 1 && cube.colors[3][2] == 5) ||
                (cube.colors[0][0] == 5 && cube.colors[4][0] == 4 && cube.colors[3][2] == 1)) {
            if ((cube.colors[5][6] == 5 && cube.colors[0][6] == 3 && cube.colors[3][8] == 4) ||
                    (cube.colors[5][6] == 4 && cube.colors[0][6] == 5 && cube.colors[3][8] == 3) ||
                    (cube.colors[5][6] == 3 && cube.colors[0][6] == 4 && cube.colors[3][8] == 5)) {
                cube.colors = yellowCW(cube.colors);
                cube.colors = orangeCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = redCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = orangeCCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = redCW(cube.colors);
            } else {
                cube.colors = yellowCCW(cube.colors);
                cube.colors = greenCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = blueCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = greenCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = blueCCW(cube.colors);
            }
        } else if ((cube.colors[4][2] == 5 && cube.colors[2][2] == 3 && cube.colors[3][0] == 4) ||
                (cube.colors[4][2] == 4 && cube.colors[2][2] == 5 && cube.colors[3][0] == 3) ||
                (cube.colors[4][2] == 3 && cube.colors[2][2] == 4 && cube.colors[3][0] == 5)) {
            if ((cube.colors[0][0] == 3 && cube.colors[4][0] == 6 && cube.colors[3][2] == 4) ||
                    (cube.colors[0][0] == 4 && cube.colors[4][0] == 3 && cube.colors[3][2] == 6) ||
                    (cube.colors[0][0] == 6 && cube.colors[4][0] == 4 && cube.colors[3][2] == 3)) {
                cube.colors = yellowCW(cube.colors);
                cube.colors = blueCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = greenCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = blueCCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = greenCW(cube.colors);
            } else {
                cube.colors = yellowCCW(cube.colors);
                cube.colors = orangeCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = redCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = orangeCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = redCCW(cube.colors);
            }
        } else if ((cube.colors[5][6] == 6 && cube.colors[0][6] == 1 && cube.colors[3][8] == 4) ||
                (cube.colors[5][6] == 4 && cube.colors[0][6] == 6 && cube.colors[3][8] == 1) ||
                (cube.colors[5][6] == 1 && cube.colors[0][6] == 4 && cube.colors[3][8] == 6)) {
            if ((cube.colors[2][8] == 1 && cube.colors[5][8] == 5 && cube.colors[3][6] != 4) ||
                    (cube.colors[2][8] == 4 && cube.colors[5][8] == 1 && cube.colors[3][6] == 5) ||
                    (cube.colors[2][8] == 5 && cube.colors[5][8] == 4 && cube.colors[3][6] == 1)) {
                cube.colors = yellowCW(cube.colors);
                cube.colors = greenCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = blueCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = greenCCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = blueCW(cube.colors);
            } else {
                cube.colors = yellowCCW(cube.colors);
                cube.colors = redCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = orangeCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = redCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = orangeCCW(cube.colors);
            }
        } else if ((cube.colors[2][8] == 3 && cube.colors[5][8] == 6 && cube.colors[3][6] == 4) ||
                (cube.colors[2][8] == 4 && cube.colors[5][8] == 3 && cube.colors[3][6] == 6) ||
                (cube.colors[2][8] == 6 && cube.colors[5][8] == 4 && cube.colors[3][6] == 3)) {
            if ((cube.colors[4][2] == 6 && cube.colors[2][2] == 1 && cube.colors[3][0] == 4) ||
                    (cube.colors[4][2] == 4 && cube.colors[2][2] == 6 && cube.colors[3][0] == 1) ||
                    (cube.colors[4][2] == 1 && cube.colors[2][2] == 4 && cube.colors[3][0] == 6)) {
                cube.colors = yellowCW(cube.colors);
                cube.colors = redCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = orangeCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = redCCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = orangeCW(cube.colors);
            } else {
                cube.colors = yellowCCW(cube.colors);
                cube.colors = blueCCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = greenCW(cube.colors);
                cube.colors = yellowCCW(cube.colors);
                cube.colors = blueCW(cube.colors);
                cube.colors = yellowCW(cube.colors);
                cube.colors = greenCCW(cube.colors);
            }
        }

        return cube;
    }

    //разворот углов, чтобы желтый был вверху
    public static Cube doYellowCorners(Cube cube) {
        for (int i = 0; i <= 3; i++) {
            if (cube.colors[3][0] != 4) {
                while (cube.colors[3][0] != 4) {
                    cube.colors = blueCCW(cube.colors);
                    cube.colors = whiteCCW(cube.colors);
                    cube.colors = blueCW(cube.colors);
                    cube.colors = whiteCW(cube.colors);
                }
            }
            cube.colors = yellowCW(cube.colors);
            Main.results += ("Поворот\n");
        }

        return cube;
    }

    //делает правильный желтый крест(совмещает ребра с центрами)
    public static Cube doCYellowCross(Cube cube) {
        if (cube.colors[5][7] == 6 && cube.colors[2][5] == 1 && cube.colors[4][1] == 5 && cube.colors[0][3] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[2][5] == 6 && cube.colors[4][1] == 1 &&
                cube.colors[0][3] == 5) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 5 && cube.colors[4][1] == 3 &&
                cube.colors[0][3] == 6) {
            cube.colors = yellowCCW(cube.colors);
        }

        if (cube.colors[5][7] == 5 && cube.colors[2][5] == 3 && cube.colors[4][1] == 6 && cube.colors[0][3] == 1) {
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
        }

        if (cube.colors[5][7] == 3 && cube.colors[2][5] == 5 && cube.colors[4][1] == 1 && cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[2][5] == 1 && cube.colors[4][1] == 6 && cube.colors[0][3] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 6 && cube.colors[4][1] == 3 && cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
        }

        if (cube.colors[5][7] == 5 && cube.colors[2][5] == 3 && cube.colors[4][1] == 1 && cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[2][5] == 1 && cube.colors[4][1] == 6 &&
                cube.colors[0][3] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 6 && cube.colors[4][1] == 4 &&
                cube.colors[0][3] == 3) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[2][5] == 1 && cube.colors[4][1] == 5 &&
                cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 5 && cube.colors[4][1] == 6 &&
                cube.colors[0][3] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[2][5] == 6 && cube.colors[4][1] == 3 &&
                cube.colors[0][3] == 1) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[2][5] == 5 && cube.colors[4][1] == 6 &&
                cube.colors[0][3] == 1) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[2][5] == 6 && cube.colors[4][1] == 1 &&
                cube.colors[0][3] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 6 && cube.colors[2][5] == 1 && cube.colors[4][1] == 3 &&
                cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 6 && cube.colors[2][5] == 5 && cube.colors[4][1] == 1 &&
                cube.colors[0][3] == 3) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[2][5] == 1 && cube.colors[4][1] == 3 &&
                cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 3 && cube.colors[4][1] == 6 &&
                cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[2][5] == 5 && cube.colors[4][1] == 1 &&
                cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[2][5] == 1 && cube.colors[4][1] == 6 && //
                cube.colors[0][3] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 6 && cube.colors[4][1] == 3 &&
                cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
        }

        //RG
        if (cube.colors[5][7] == 6 && cube.colors[2][5] == 5 && cube.colors[4][1] == 3 && cube.colors[0][3] == 1) {
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 6 && cube.colors[2][5] == 3 && cube.colors[4][1] == 1 &&  //BR
                cube.colors[0][3] == 5) {
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[2][5] == 3 && cube.colors[4][1] == 5 &&  //OB
                cube.colors[0][3] == 6) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[2][5] == 6 && cube.colors[4][1] == 5 &&  //GO
                cube.colors[0][3] == 1) {
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        }

        return cube;
    }

    //собирает любой крест(необязательно правильный)
    public static Cube doUnCYellowCross(Cube cube) {
        if (cube.colors[3][1] != 4 && cube.colors[3][3] != 4 && cube.colors[3][5] != 4 && cube.colors[3][7] != 4) {
            cube.colors = redCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
        }

        if (cube.colors[3][1] == 4 && cube.colors[3][3] != 4 && cube.colors[3][5] == 4 && cube.colors[3][7] != 4) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[3][1] != 4 && cube.colors[3][3] != 4 && cube.colors[3][5] == 4 &&
                cube.colors[3][7] == 4) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[3][1] != 4 && cube.colors[3][3] == 4 && cube.colors[3][5] != 4 &&
                cube.colors[3][7] == 4) {
            cube.colors = yellowCW(cube.colors);
        }

        if (cube.colors[3][1] == 4 && cube.colors[3][3] == 4 && cube.colors[3][5] != 4 && cube.colors[3][7] != 4) {
            cube.colors = redCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
        }

        if (cube.colors[3][1] == 4 && cube.colors[3][3] != 4 && cube.colors[3][5] != 4 && cube.colors[3][7] == 4) {
            cube.colors = yellowCW(cube.colors);
        }

        if (cube.colors[3][1] != 4 && cube.colors[3][3] == 4 && cube.colors[3][5] == 4 && cube.colors[3][7] != 4) {
            cube.colors = redCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
        }

        return cube;
    }

    public static Cube doMiddleLayer(Cube cube) {
        cube = replaceFirstToMiddle(cube);
        Main.results += ("GO на месте\n");
        cube = replaceSecondToMiddle(cube);
        Main.results += ("RG на месте\n");
        cube = replaceThirdToMiddle(cube);
        Main.results += ("RB на месте\n");
        cube = replaceFourthToMiddle(cube);
        Main.results += ("OB на месте\n");

        return cube;
    }

    //GO
    private static Cube replaceFirstToMiddle(Cube cube) {
        if (cube.colors[4][3] == 1 && cube.colors[0][1] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if ((cube.colors[0][7] == 1 && cube.colors[5][3] == 5) ||
                (cube.colors[0][7] == 5 && cube.colors[5][3] == 1)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if ((cube.colors[5][5] == 1 && cube.colors[2][7] == 5) ||
                (cube.colors[5][5] == 5 && cube.colors[2][7] == 1)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if ((cube.colors[2][1] == 1 && cube.colors[4][5] == 5) ||
                (cube.colors[2][1] == 5 && cube.colors[4][5] == 1)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        }

        if (cube.colors[4][1] == 1 && cube.colors[3][1] == 5) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[2][5] == 1 && cube.colors[3][3] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[2][5] == 5 && cube.colors[3][3] == 1) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[3][7] == 5) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[3][7] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[3][5] == 1 && cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
        }

        if (cube.colors[3][1] == 1 && cube.colors[4][1] == 5) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
        } else if (cube.colors[0][3] == 1 && cube.colors[3][5] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        }

        return cube;
    }

    //RG
    private static Cube replaceSecondToMiddle(Cube cube) {
        if ((cube.colors[4][3] == 1 && cube.colors[0][1] == 6) ||
                (cube.colors[4][3] == 6 && cube.colors[0][1] == 1)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[0][7] == 6 && cube.colors[5][3] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if ((cube.colors[5][5] == 1 && cube.colors[2][7] == 6) ||
                (cube.colors[5][5] == 6 && cube.colors[2][7] == 1)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if ((cube.colors[2][1] == 1 && cube.colors[4][5] == 6) ||
                (cube.colors[2][1] == 6 && cube.colors[4][5] == 1)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        }

        if (cube.colors[4][1] == 1 && cube.colors[3][1] == 6) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[4][1] == 6 && cube.colors[3][1] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[2][5] == 1 && cube.colors[3][3] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[2][5] == 6 && cube.colors[3][3] == 1) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 1 && cube.colors[3][7] == 6) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[3][5] == 1 && cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
        }

        if (cube.colors[0][3] == 1 && cube.colors[3][5] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
        } else if (cube.colors[3][7] == 1 && cube.colors[5][7] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        }

        return cube;
    }

    //RB
    private static Cube replaceThirdToMiddle(Cube cube) {
        if (cube.colors[5][5] == 3 && cube.colors[2][7] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if ((cube.colors[2][1] == 3 && cube.colors[4][5] == 6) ||
                (cube.colors[2][1] == 6 && cube.colors[4][5] == 3)) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        }

        if (cube.colors[4][1] == 3 && cube.colors[3][1] == 6) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[4][1] == 6 && cube.colors[3][1] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[3][7] == 6) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[2][5] == 6 && cube.colors[3][3] == 3) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[0][3] == 3 && cube.colors[3][5] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[3][5] == 3 && cube.colors[0][3] == 6) {
            cube.colors = yellowCW(cube.colors);
        }

        if (cube.colors[3][7] == 3 && cube.colors[5][7] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
        } else if (cube.colors[2][5] == 3 && cube.colors[3][3] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        }

        return cube;
    }

    //OB
    private static Cube replaceFourthToMiddle(Cube cube) {
        if (cube.colors[2][1] == 5 && cube.colors[4][5] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        }

        if (cube.colors[4][1] == 3 && cube.colors[3][1] == 5) {
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[5][7] == 5 && cube.colors[3][7] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[5][7] == 3 && cube.colors[3][7] == 5) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[2][5] == 5 && cube.colors[3][3] == 3) {
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[0][3] == 3 && cube.colors[3][5] == 5) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
        } else if (cube.colors[3][5] == 3 && cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
        }

        if (cube.colors[2][5] == 3 && cube.colors[3][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
        } else if (cube.colors[3][1] == 3 && cube.colors[4][1] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        }

        return cube;
    }

    public static Cube doWhiteCorners(Cube cube) {
        cube = replaceFirstWCorner(cube);
        Main.results += ("Первый угол\n");
        cube = replaceSecondWCorner(cube);
        Main.results += ("Второй угол\n");
        cube = replaceThirdWCorner(cube);
        Main.results += ("Третий угол\n");
        cube = replaceFourthWCorner(cube);
        Main.results += ("Четвертый угол\n");
        return cube;
    }

    //GWO
    public static Cube replaceFirstWCorner(Cube cube) {
        if (cube.colors[0][0] == 2 && cube.colors[4][0] == 5 && cube.colors[3][2] == 1) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[0][2] == 2 && cube.colors[1][0] == 5 && cube.colors[4][6] == 1) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
        } else if (cube.colors[0][6] == 2 && cube.colors[3][8] == 5 && cube.colors[5][6] == 1) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[0][8] == 2 && cube.colors[5][0] == 5 && cube.colors[1][6] == 1) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[1][2] == 2 && cube.colors[2][0] == 5 && cube.colors[4][8] == 1) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[1][6] == 2 && cube.colors[0][8] == 5 && cube.colors[5][0] == 1) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[2][0] == 2 && cube.colors[4][8] == 5 && cube.colors[1][2] == 1) {
            cube.colors = blueCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[1][8] == 2 && cube.colors[5][2] == 5 && cube.colors[2][6] == 1) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[2][2] == 2 && cube.colors[3][0] == 5 && cube.colors[4][2] == 1) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[2][6] == 2 && cube.colors[1][8] == 5 && cube.colors[5][2] == 1) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[2][8] == 2 && cube.colors[5][8] == 5 && cube.colors[3][6] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[3][0] == 2 && cube.colors[4][2] == 5 && cube.colors[2][2] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[3][2] == 2 && cube.colors[0][0] == 5 && cube.colors[4][0] == 1) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[3][6] == 2 && cube.colors[2][8] == 5 && cube.colors[5][8] == 1) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[3][8] == 2 && cube.colors[5][6] == 5 && cube.colors[0][6] == 1) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][0] == 2 && cube.colors[3][2] == 5 && cube.colors[0][0] == 1) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][2] == 2 && cube.colors[2][2] == 5 && cube.colors[3][0] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][6] == 2 && cube.colors[0][2] == 5 && cube.colors[1][0] == 1) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][8] == 2 && cube.colors[1][2] == 5 && cube.colors[2][0] == 1) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[5][0] == 2 && cube.colors[1][6] == 5 && cube.colors[0][8] == 1) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[5][2] == 2 && cube.colors[2][6] == 5 && cube.colors[1][8] == 1) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[5][6] == 2 && cube.colors[0][6] == 5 && cube.colors[3][8] == 1) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[5][8] == 2 && cube.colors[3][6] == 5 && cube.colors[2][8] == 1) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        }
        return cube;
    }

    //GWR
    public static Cube replaceSecondWCorner(Cube cube) {
        if (cube.colors[0][0] == 2 && cube.colors[4][0] == 1 && cube.colors[3][2] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[0][6] == 2 && cube.colors[3][8] == 1 && cube.colors[5][6] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[0][8] == 2 && cube.colors[5][0] == 1 && cube.colors[1][6] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[1][2] == 2 && cube.colors[2][0] == 1 && cube.colors[4][8] == 6) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[1][8] == 2 && cube.colors[5][2] == 1 && cube.colors[2][6] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[2][0] == 2 && cube.colors[4][8] == 1 && cube.colors[1][2] == 6) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[2][2] == 2 && cube.colors[3][0] == 1 && cube.colors[4][2] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[2][6] == 2 && cube.colors[1][8] == 1 && cube.colors[5][2] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[2][8] == 2 && cube.colors[5][8] == 1 && cube.colors[3][6] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[3][0] == 2 && cube.colors[4][2] == 1 && cube.colors[2][2] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[3][2] == 2 && cube.colors[0][0] == 1 && cube.colors[4][0] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[3][6] == 2 && cube.colors[2][8] == 1 && cube.colors[5][8] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[3][8] == 2 && cube.colors[5][6] == 1 && cube.colors[0][6] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[4][0] == 2 && cube.colors[3][2] == 1 && cube.colors[0][0] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[4][2] == 2 && cube.colors[2][2] == 1 && cube.colors[3][0] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[4][8] == 2 && cube.colors[1][2] == 1 && cube.colors[2][0] == 6) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[5][0] == 2 && cube.colors[1][6] == 1 && cube.colors[0][8] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[5][2] == 2 && cube.colors[2][6] == 1 && cube.colors[1][8] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[5][6] == 2 && cube.colors[0][6] == 1 && cube.colors[3][8] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[5][8] == 2 && cube.colors[3][6] == 1 && cube.colors[2][8] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCW(cube.colors);
        }
        return cube;
    }

    //OWB
    public static Cube replaceThirdWCorner(Cube cube) {
        if (cube.colors[0][0] == 2 && cube.colors[4][0] == 3 && cube.colors[3][2] == 5) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[0][6] == 2 && cube.colors[5][6] == 5 && cube.colors[3][8] == 3) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[1][8] == 2 && cube.colors[2][6] == 5 && cube.colors[5][2] == 3) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[2][0] == 2 && cube.colors[1][2] == 5 && cube.colors[4][8] == 3) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[2][2] == 2 && cube.colors[4][2] == 5 && cube.colors[3][0] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[2][6] == 2 && cube.colors[5][2] == 5 && cube.colors[1][8] == 3) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
        } else if (cube.colors[2][8] == 2 && cube.colors[3][6] == 5 && cube.colors[5][8] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][0] == 2 && cube.colors[2][2] == 5 && cube.colors[4][2] == 3) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][2] == 2 && cube.colors[4][0] == 5 && cube.colors[0][0] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][6] == 2 && cube.colors[5][8] == 5 && cube.colors[2][8] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][8] == 2 && cube.colors[0][6] == 5 && cube.colors[5][6] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][0] == 2 && cube.colors[0][0] == 5 && cube.colors[3][2] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][2] == 2 && cube.colors[3][0] == 5 && cube.colors[2][2] == 3) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][8] == 2 && cube.colors[2][0] == 5 && cube.colors[1][2] == 3) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[5][2] == 2 && cube.colors[1][8] == 5 && cube.colors[2][6] == 3) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[5][6] == 2 && cube.colors[3][8] == 5 && cube.colors[0][6] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[5][8] == 2 && cube.colors[2][8] == 5 && cube.colors[3][6] == 3) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        }
        return cube;
    }

    //BWR
    public static Cube replaceFourthWCorner(Cube cube) {
        if (cube.colors[0][0] == 2 && cube.colors[3][2] == 3 && cube.colors[4][0] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[0][6] == 2 && cube.colors[5][6] == 3 && cube.colors[3][8] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[2][2] == 2 && cube.colors[4][2] == 3 && cube.colors[3][0] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[2][6] == 2 && cube.colors[5][2] == 3 && cube.colors[1][8] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[2][8] == 2 && cube.colors[3][6] == 3 && cube.colors[5][8] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[3][0] == 2 && cube.colors[2][2] == 3 && cube.colors[4][2] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[3][2] == 2 && cube.colors[4][0] == 3 && cube.colors[0][0] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[3][6] == 2 && cube.colors[5][8] == 3 && cube.colors[2][8] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[3][8] == 2 && cube.colors[0][6] == 3 && cube.colors[5][6] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[4][0] == 2 && cube.colors[0][0] == 3 && cube.colors[3][2] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[4][2] == 2 && cube.colors[2][2] == 6 && cube.colors[3][0] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[5][2] == 2 && cube.colors[1][8] == 3 && cube.colors[2][6] == 6) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[5][6] == 2 && cube.colors[3][8] == 3 && cube.colors[0][6] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[5][8] == 2 && cube.colors[2][8] == 3 && cube.colors[3][6] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        }
        return cube;
    }

    //GW
    public static Cube replaceFirstWPiece(Cube cube) {
        if (cube.colors[0][1] == 2 && cube.colors[4][3] == 1) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[0][3] == 2 && cube.colors[3][5] == 1) {
            cube.colors = greenCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[0][5] == 2 && cube.colors[1][3] == 1) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[0][7] == 2 && cube.colors[5][3] == 1) {
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[1][1] == 2 && cube.colors[4][7] == 1) {
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[1][5] == 2 && cube.colors[2][3] == 1) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[1][7] == 2 && cube.colors[5][1] == 1) {
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[2][1] == 2 && cube.colors[4][5] == 1) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[2][3] == 2 && cube.colors[1][5] == 1) {
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[2][5] == 2 && cube.colors[3][3] == 1) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[2][7] == 2 && cube.colors[5][5] == 1) {
            cube.colors = blueCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[3][1] == 2 && cube.colors[4][1] == 1) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[3][3] == 2 && cube.colors[2][5] == 1) {
            cube.colors = blueCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][5] == 2 && cube.colors[0][3] == 1) {
            cube.colors = greenCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[3][7] == 2 && cube.colors[5][7] == 1) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][1] == 2 && cube.colors[3][1] == 1) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][3] == 2 && cube.colors[0][1] == 1) {
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][5] == 2 && cube.colors[2][1] == 1) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[4][7] == 2 && cube.colors[1][1] == 1) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[5][1] == 2 && cube.colors[1][7] == 1) {
            cube.colors = redCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
        } else if (cube.colors[5][3] == 2 && cube.colors[0][7] == 1) {
            cube.colors = greenCCW(cube.colors);
        } else if (cube.colors[5][5] == 2 && cube.colors[2][7] == 1) {
            cube.colors = redCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
        } else if (cube.colors[5][7] == 2 && cube.colors[3][7] == 1) {
            cube.colors = redCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
        }
        return cube;

    }

    //BW
    public static Cube replaceSecondWPiece(Cube cube) {
        if (cube.colors[0][1] == 2 && cube.colors[4][3] == 5) {
            cube.colors = orangeCCW(cube.colors);
        } else if (cube.colors[0][3] == 2 && cube.colors[3][5] == 5) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[0][7] == 2 && cube.colors[5][3] == 5) {
            cube.colors = redCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[1][5] == 2 && cube.colors[2][3] == 5) {
            cube.colors = greenCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = greenCCW(cube.colors);

        } else if (cube.colors[1][7] == 2 && cube.colors[5][1] == 5) {
            cube.colors = greenCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCW(cube.colors);
        } else if (cube.colors[2][1] == 2 && cube.colors[4][5] == 5) {
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[2][3] == 2 && cube.colors[1][5] == 5) {
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[2][5] == 2 && cube.colors[3][3] == 5) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[2][7] == 2 && cube.colors[5][5] == 5) {
            cube.colors = blueCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][1] == 2 && cube.colors[4][1] == 5) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][3] == 2 && cube.colors[2][5] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][5] == 2 && cube.colors[0][3] == 5) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[3][7] == 2 && cube.colors[5][7] == 5) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][1] == 2 && cube.colors[3][1] == 5) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][3] == 2 && cube.colors[0][1] == 5) {
            cube.colors = orangeCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][5] == 2 && cube.colors[2][1] == 5) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = yellowCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
        } else if (cube.colors[4][7] == 2 && cube.colors[1][1] == 5) {
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[5][1] == 2 && cube.colors[1][7] == 5) {
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[5][3] == 2 && cube.colors[0][7] == 5) {
            cube.colors = redCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[5][5] == 2 && cube.colors[2][7] == 5) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[5][7] == 2 && cube.colors[3][7] == 5) {
            cube.colors = redCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        }
        return cube;
    }

    //YW
    public static Cube replaceThirdWPiece(Cube cube) {
        if (cube.colors[0][1] == 2 && cube.colors[4][3] == 3) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[0][3] == 2 && cube.colors[3][5] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[0][7] == 2 && cube.colors[5][3] == 3) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[1][7] == 2 && cube.colors[5][1] == 3) {
            cube.colors = redCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[2][1] == 2 && cube.colors[4][5] == 3) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[2][3] == 2 && cube.colors[1][5] == 3) {
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[2][5] == 2 && cube.colors[3][3] == 3) {
            cube.colors = blueCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[2][7] == 2 && cube.colors[5][5] == 3) {
            cube.colors = blueCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][1] == 2 && cube.colors[4][1] == 3) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][3] == 2 && cube.colors[2][5] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][5] == 2 && cube.colors[0][3] == 3) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][7] == 2 && cube.colors[5][7] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[4][1] == 2 && cube.colors[3][1] == 3) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = redCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[4][3] == 2 && cube.colors[0][1] == 3) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[4][5] == 2 && cube.colors[2][1] == 3) {
            cube.colors = blueCCW(cube.colors);
        } else if (cube.colors[5][1] == 2 && cube.colors[1][7] == 3) {
            cube.colors = redCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[5][3] == 2 && cube.colors[0][7] == 3) {
            cube.colors = redCW(cube.colors);
            cube.colors = redCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        } else if (cube.colors[5][5] == 2 && cube.colors[2][7] == 3) {
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[5][7] == 2 && cube.colors[3][7] == 3) {
            cube.colors = redCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
        }
        return cube;
    }

    //RW
    public static Cube replaceFourthWPiece(Cube cube) {
        if (cube.colors[0][1] == 2 && cube.colors[4][3] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[0][3] == 2 && cube.colors[3][5] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[0][7] == 2 && cube.colors[5][3] == 6) {
            cube.colors = redCW(cube.colors);
        } else if (cube.colors[2][1] == 2 && cube.colors[4][5] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[2][5] == 2 && cube.colors[3][3] == 6) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = redCCW(cube.colors);
        } else if (cube.colors[2][7] == 2 && cube.colors[5][5] == 6) {
            cube.colors = redCCW(cube.colors);
        } else if (cube.colors[3][1] == 2 && cube.colors[4][1] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][3] == 2 && cube.colors[2][5] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][5] == 2 && cube.colors[0][3] == 6) {
            cube.colors = yellowCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[3][7] == 2 && cube.colors[5][7] == 6) {
            cube.colors = yellowCW(cube.colors);
            cube.colors = yellowCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[4][1] == 2 && cube.colors[3][1] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = orangeCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[4][3] == 2 && cube.colors[0][1] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[4][5] == 2 && cube.colors[2][1] == 6) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = blueCCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[5][1] == 2 && cube.colors[1][7] == 6) {
            cube.colors = redCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[5][3] == 2 && cube.colors[0][7] == 6) {
            cube.colors = whiteCW(cube.colors);
            cube.colors = greenCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
        } else if (cube.colors[5][5] == 2 && cube.colors[2][7] == 6) {
            cube.colors = whiteCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        } else if (cube.colors[5][7] == 2 && cube.colors[3][7] == 6) {
            cube.colors = redCCW(cube.colors);
            cube.colors = whiteCCW(cube.colors);
            cube.colors = blueCW(cube.colors);
            cube.colors = whiteCW(cube.colors);
        }
        return cube;
    }
}
