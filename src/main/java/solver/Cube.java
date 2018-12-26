package solver;

public class Cube {

    public int[][] colors = new int[6][9];

    public static int[][] greenCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[0][0];
        primaryFace[1] = colors[0][1];
        primaryFace[2] = colors[0][2];
        primaryFace[3] = colors[0][3];
        primaryFace[4] = colors[0][4];
        primaryFace[5] = colors[0][5];
        primaryFace[6] = colors[0][6];
        primaryFace[7] = colors[0][7];
        primaryFace[8] = colors[0][8];

        colors[0][2] = primaryFace[0];
        colors[0][5] = primaryFace[1];
        colors[0][8] = primaryFace[2];
        colors[0][1] = primaryFace[3];
        colors[0][4] = primaryFace[4];
        colors[0][7] = primaryFace[5];
        colors[0][0] = primaryFace[6];
        colors[0][3] = primaryFace[7];
        colors[0][6] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[40] = colors[4][0];
        primaryOuter[43] = colors[4][3];
        primaryOuter[46] = colors[4][6];
        primaryOuter[10] = colors[1][0];
        primaryOuter[13] = colors[1][3];
        primaryOuter[16] = colors[1][6];
        primaryOuter[50] = colors[5][0];
        primaryOuter[53] = colors[5][3];
        primaryOuter[56] = colors[5][6];
        primaryOuter[38] = colors[3][8];
        primaryOuter[35] = colors[3][5];
        primaryOuter[32] = colors[3][2];

        colors[1][0] = primaryOuter[40];
        colors[1][3] = primaryOuter[43];
        colors[1][6] = primaryOuter[46];
        colors[5][0] = primaryOuter[10];
        colors[5][3] = primaryOuter[13];
        colors[5][6] = primaryOuter[16];
        colors[3][8] = primaryOuter[50];
        colors[3][5] = primaryOuter[53];
        colors[3][2] = primaryOuter[56];
        colors[4][0] = primaryOuter[38];
        colors[4][3] = primaryOuter[35];
        colors[4][6] = primaryOuter[32];

        Main.results +=("GreenClockWise\n");
        return colors;
    }

    public static int[][] greenCCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[0][0];
        primaryFace[1] = colors[0][1];
        primaryFace[2] = colors[0][2];
        primaryFace[3] = colors[0][3];
        primaryFace[4] = colors[0][4];
        primaryFace[5] = colors[0][5];
        primaryFace[6] = colors[0][6];
        primaryFace[7] = colors[0][7];
        primaryFace[8] = colors[0][8];

        colors[0][6] = primaryFace[0];
        colors[0][3] = primaryFace[1];
        colors[0][0] = primaryFace[2];
        colors[0][7] = primaryFace[3];
        colors[0][4] = primaryFace[4];
        colors[0][1] = primaryFace[5];
        colors[0][8] = primaryFace[6];
        colors[0][5] = primaryFace[7];
        colors[0][2] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[40] = colors[4][0];
        primaryOuter[43] = colors[4][3];
        primaryOuter[46] = colors[4][6];
        primaryOuter[10] = colors[1][0];
        primaryOuter[13] = colors[1][3];
        primaryOuter[16] = colors[1][6];
        primaryOuter[50] = colors[5][0];
        primaryOuter[53] = colors[5][3];
        primaryOuter[56] = colors[5][6];
        primaryOuter[38] = colors[3][8];
        primaryOuter[35] = colors[3][5];
        primaryOuter[32] = colors[3][2];

        colors[3][8] = primaryOuter[40];
        colors[3][5] = primaryOuter[43];
        colors[3][2] = primaryOuter[46];
        colors[4][0] = primaryOuter[10];
        colors[4][3] = primaryOuter[13];
        colors[4][6] = primaryOuter[16];
        colors[1][0] = primaryOuter[50];
        colors[1][3] = primaryOuter[53];
        colors[1][6] = primaryOuter[56];
        colors[5][0] = primaryOuter[38];
        colors[5][3] = primaryOuter[35];
        colors[5][6] = primaryOuter[32];

        Main.results +=("GreenCounterClockWise\n");
        return colors;
    }

    public static int[][] whiteCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[1][0];
        primaryFace[1] = colors[1][1];
        primaryFace[2] = colors[1][2];
        primaryFace[3] = colors[1][3];
        primaryFace[4] = colors[1][4];
        primaryFace[5] = colors[1][5];
        primaryFace[6] = colors[1][6];
        primaryFace[7] = colors[1][7];
        primaryFace[8] = colors[1][8];

        colors[1][2] = primaryFace[0];
        colors[1][5] = primaryFace[1];
        colors[1][8] = primaryFace[2];
        colors[1][1] = primaryFace[3];
        colors[1][4] = primaryFace[4];
        colors[1][7] = primaryFace[5];
        colors[1][0] = primaryFace[6];
        colors[1][3] = primaryFace[7];
        colors[1][6] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[46] = colors[4][6];
        primaryOuter[47] = colors[4][7];
        primaryOuter[48] = colors[4][8];
        primaryOuter[20] = colors[2][0];
        primaryOuter[23] = colors[2][3];
        primaryOuter[26] = colors[2][6];
        primaryOuter[52] = colors[5][2];
        primaryOuter[51] = colors[5][1];
        primaryOuter[50] = colors[5][0];
        primaryOuter[8] = colors[0][8];
        primaryOuter[5] = colors[0][5];
        primaryOuter[2] = colors[0][2];

        colors[2][0] = primaryOuter[46];
        colors[2][3] = primaryOuter[47];
        colors[2][6] = primaryOuter[48];
        colors[5][2] = primaryOuter[20];
        colors[5][1] = primaryOuter[23];
        colors[5][0] = primaryOuter[26];
        colors[0][8] = primaryOuter[52];
        colors[0][5] = primaryOuter[51];
        colors[0][2] = primaryOuter[50];
        colors[4][6] = primaryOuter[8];
        colors[4][7] = primaryOuter[5];
        colors[4][8] = primaryOuter[2];

        Main.results +=("WhiteClockWise\n");
        return colors;
    }

    public static int[][] whiteCCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[1][0];
        primaryFace[1] = colors[1][1];
        primaryFace[2] = colors[1][2];
        primaryFace[3] = colors[1][3];
        primaryFace[4] = colors[1][4];
        primaryFace[5] = colors[1][5];
        primaryFace[6] = colors[1][6];
        primaryFace[7] = colors[1][7];
        primaryFace[8] = colors[1][8];

        colors[1][6] = primaryFace[0];
        colors[1][3] = primaryFace[1];
        colors[1][0] = primaryFace[2];
        colors[1][7] = primaryFace[3];
        colors[1][4] = primaryFace[4];
        colors[1][1] = primaryFace[5];
        colors[1][8] = primaryFace[6];
        colors[1][5] = primaryFace[7];
        colors[1][2] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[46] = colors[4][6];
        primaryOuter[47] = colors[4][7];
        primaryOuter[48] = colors[4][8];
        primaryOuter[20] = colors[2][0];
        primaryOuter[23] = colors[2][3];
        primaryOuter[26] = colors[2][6];
        primaryOuter[52] = colors[5][2];
        primaryOuter[51] = colors[5][1];
        primaryOuter[50] = colors[5][0];
        primaryOuter[8] = colors[0][8];
        primaryOuter[5] = colors[0][5];
        primaryOuter[2] = colors[0][2];

        colors[0][8] = primaryOuter[46];
        colors[0][5] = primaryOuter[47];
        colors[0][2] = primaryOuter[48];
        colors[4][6] = primaryOuter[20];
        colors[4][7] = primaryOuter[23];
        colors[4][8] = primaryOuter[26];
        colors[2][0] = primaryOuter[52];
        colors[2][3] = primaryOuter[51];
        colors[2][6] = primaryOuter[50];
        colors[5][2] = primaryOuter[8];
        colors[5][1] = primaryOuter[5];
        colors[5][0] = primaryOuter[2];

        Main.results +=("WhiteCounterClockWise\n");
        return colors;
    }

    public static int[][] blueCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[2][0];
        primaryFace[1] = colors[2][1];
        primaryFace[2] = colors[2][2];
        primaryFace[3] = colors[2][3];
        primaryFace[4] = colors[2][4];
        primaryFace[5] = colors[2][5];
        primaryFace[6] = colors[2][6];
        primaryFace[7] = colors[2][7];
        primaryFace[8] = colors[2][8];

        colors[2][2] = primaryFace[0];
        colors[2][5] = primaryFace[1];
        colors[2][8] = primaryFace[2];
        colors[2][1] = primaryFace[3];
        colors[2][4] = primaryFace[4];
        colors[2][7] = primaryFace[5];
        colors[2][0] = primaryFace[6];
        colors[2][3] = primaryFace[7];
        colors[2][6] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[48] = colors[4][8];
        primaryOuter[45] = colors[4][5];
        primaryOuter[42] = colors[4][2];
        primaryOuter[30] = colors[3][0];
        primaryOuter[33] = colors[3][3];
        primaryOuter[36] = colors[3][6];
        primaryOuter[58] = colors[5][8];
        primaryOuter[55] = colors[5][5];
        primaryOuter[52] = colors[5][2];
        primaryOuter[18] = colors[1][8];
        primaryOuter[15] = colors[1][5];
        primaryOuter[12] = colors[1][2];

        colors[3][0] = primaryOuter[48];
        colors[3][3] = primaryOuter[45];
        colors[3][6] = primaryOuter[42];
        colors[5][8] = primaryOuter[30];
        colors[5][5] = primaryOuter[33];
        colors[5][2] = primaryOuter[36];
        colors[1][8] = primaryOuter[58];
        colors[1][5] = primaryOuter[55];
        colors[1][2] = primaryOuter[52];
        colors[4][8] = primaryOuter[18];
        colors[4][5] = primaryOuter[15];
        colors[4][2] = primaryOuter[12];

        Main.results +=("BlueClockWise\n");
        return colors;
    }

    public static int[][] blueCCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[2][0];
        primaryFace[1] = colors[2][1];
        primaryFace[2] = colors[2][2];
        primaryFace[3] = colors[2][3];
        primaryFace[4] = colors[2][4];
        primaryFace[5] = colors[2][5];
        primaryFace[6] = colors[2][6];
        primaryFace[7] = colors[2][7];
        primaryFace[8] = colors[2][8];

        colors[2][6] = primaryFace[0];
        colors[2][3] = primaryFace[1];
        colors[2][0] = primaryFace[2];
        colors[2][7] = primaryFace[3];
        colors[2][4] = primaryFace[4];
        colors[2][1] = primaryFace[5];
        colors[2][8] = primaryFace[6];
        colors[2][5] = primaryFace[7];
        colors[2][2] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[48] = colors[4][8];
        primaryOuter[45] = colors[4][5];
        primaryOuter[42] = colors[4][2];
        primaryOuter[30] = colors[3][0];
        primaryOuter[33] = colors[3][3];
        primaryOuter[36] = colors[3][6];
        primaryOuter[58] = colors[5][8];
        primaryOuter[55] = colors[5][5];
        primaryOuter[52] = colors[5][2];
        primaryOuter[18] = colors[1][8];
        primaryOuter[15] = colors[1][5];
        primaryOuter[12] = colors[1][2];

        colors[1][8] = primaryOuter[48];
        colors[1][5] = primaryOuter[45];
        colors[1][2] = primaryOuter[42];
        colors[4][8] = primaryOuter[30];
        colors[4][5] = primaryOuter[33];
        colors[4][2] = primaryOuter[36];
        colors[3][0] = primaryOuter[58];
        colors[3][3] = primaryOuter[55];
        colors[3][6] = primaryOuter[52];
        colors[5][8] = primaryOuter[18];
        colors[5][5] = primaryOuter[15];
        colors[5][2] = primaryOuter[12];

        Main.results +=("BlueCounterClockWise\n");
        return colors;
    }

    public static int[][] yellowCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[3][0];
        primaryFace[1] = colors[3][1];
        primaryFace[2] = colors[3][2];
        primaryFace[3] = colors[3][3];
        primaryFace[4] = colors[3][4];
        primaryFace[5] = colors[3][5];
        primaryFace[6] = colors[3][6];
        primaryFace[7] = colors[3][7];
        primaryFace[8] = colors[3][8];

        colors[3][2] = primaryFace[0];
        colors[3][5] = primaryFace[1];
        colors[3][8] = primaryFace[2];
        colors[3][1] = primaryFace[3];
        colors[3][4] = primaryFace[4];
        colors[3][7] = primaryFace[5];
        colors[3][0] = primaryFace[6];
        colors[3][3] = primaryFace[7];
        colors[3][6] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[42] = colors[4][2];
        primaryOuter[41] = colors[4][1];
        primaryOuter[40] = colors[4][0];
        primaryOuter[00] = colors[0][0];
        primaryOuter[03] = colors[0][3];
        primaryOuter[06] = colors[0][6];
        primaryOuter[56] = colors[5][6];
        primaryOuter[57] = colors[5][7];
        primaryOuter[58] = colors[5][8];
        primaryOuter[28] = colors[2][8];
        primaryOuter[25] = colors[2][5];
        primaryOuter[22] = colors[2][2];

        colors[0][0] = primaryOuter[42];
        colors[0][3] = primaryOuter[41];
        colors[0][6] = primaryOuter[40];
        colors[5][6] = primaryOuter[00];
        colors[5][7] = primaryOuter[03];
        colors[5][8] = primaryOuter[06];
        colors[2][8] = primaryOuter[56];
        colors[2][5] = primaryOuter[57];
        colors[2][2] = primaryOuter[58];
        colors[4][2] = primaryOuter[28];
        colors[4][1] = primaryOuter[25];
        colors[4][0] = primaryOuter[22];

        Main.results +=("YellowClockWise\n");
        return colors;
    }

    public static int[][] yellowCCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[3][0];
        primaryFace[1] = colors[3][1];
        primaryFace[2] = colors[3][2];
        primaryFace[3] = colors[3][3];
        primaryFace[4] = colors[3][4];
        primaryFace[5] = colors[3][5];
        primaryFace[6] = colors[3][6];
        primaryFace[7] = colors[3][7];
        primaryFace[8] = colors[3][8];

        colors[3][6] = primaryFace[0];
        colors[3][3] = primaryFace[1];
        colors[3][0] = primaryFace[2];
        colors[3][7] = primaryFace[3];
        colors[3][4] = primaryFace[4];
        colors[3][1] = primaryFace[5];
        colors[3][8] = primaryFace[6];
        colors[3][5] = primaryFace[7];
        colors[3][2] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[42] = colors[4][2];
        primaryOuter[41] = colors[4][1];
        primaryOuter[40] = colors[4][0];
        primaryOuter[00] = colors[0][0];
        primaryOuter[03] = colors[0][3];
        primaryOuter[06] = colors[0][6];
        primaryOuter[56] = colors[5][6];
        primaryOuter[57] = colors[5][7];
        primaryOuter[58] = colors[5][8];
        primaryOuter[28] = colors[2][8];
        primaryOuter[25] = colors[2][5];
        primaryOuter[22] = colors[2][2];

        colors[2][8] = primaryOuter[42];
        colors[2][5] = primaryOuter[41];
        colors[2][2] = primaryOuter[40];
        colors[4][2] = primaryOuter[00];
        colors[4][1] = primaryOuter[03];
        colors[4][0] = primaryOuter[06];
        colors[0][0] = primaryOuter[56];
        colors[0][3] = primaryOuter[57];
        colors[0][6] = primaryOuter[58];
        colors[5][6] = primaryOuter[28];
        colors[5][7] = primaryOuter[25];
        colors[5][8] = primaryOuter[22];

        Main.results +=("YellowCounterClockWise\n");
        return colors;
    }

    public static int[][] orangeCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[4][0];
        primaryFace[1] = colors[4][1];
        primaryFace[2] = colors[4][2];
        primaryFace[3] = colors[4][3];
        primaryFace[4] = colors[4][4];
        primaryFace[5] = colors[4][5];
        primaryFace[6] = colors[4][6];
        primaryFace[7] = colors[4][7];
        primaryFace[8] = colors[4][8];

        colors[4][2] = primaryFace[0];
        colors[4][5] = primaryFace[1];
        colors[4][8] = primaryFace[2];
        colors[4][1] = primaryFace[3];
        colors[4][4] = primaryFace[4];
        colors[4][7] = primaryFace[5];
        colors[4][0] = primaryFace[6];
        colors[4][3] = primaryFace[7];
        colors[4][6] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[32] = colors[3][2];
        primaryOuter[31] = colors[3][1];
        primaryOuter[30] = colors[3][0];
        primaryOuter[22] = colors[2][2];
        primaryOuter[21] = colors[2][1];
        primaryOuter[20] = colors[2][0];
        primaryOuter[12] = colors[1][2];
        primaryOuter[11] = colors[1][1];
        primaryOuter[10] = colors[1][0];
        primaryOuter[02] = colors[0][2];
        primaryOuter[01] = colors[0][1];
        primaryOuter[00] = colors[0][0];

        colors[2][2] = primaryOuter[32];
        colors[2][1] = primaryOuter[31];
        colors[2][0] = primaryOuter[30];
        colors[1][2] = primaryOuter[22];
        colors[1][1] = primaryOuter[21];
        colors[1][0] = primaryOuter[20];
        colors[0][2] = primaryOuter[12];
        colors[0][1] = primaryOuter[11];
        colors[0][0] = primaryOuter[10];
        colors[3][2] = primaryOuter[02];
        colors[3][1] = primaryOuter[01];
        colors[3][0] = primaryOuter[00];

        Main.results +=("OrangeClockWise\n");
        return colors;
    }

    public static int[][] orangeCCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[4][0];
        primaryFace[1] = colors[4][1];
        primaryFace[2] = colors[4][2];
        primaryFace[3] = colors[4][3];
        primaryFace[4] = colors[4][4];
        primaryFace[5] = colors[4][5];
        primaryFace[6] = colors[4][6];
        primaryFace[7] = colors[4][7];
        primaryFace[8] = colors[4][8];

        colors[4][6] = primaryFace[0];
        colors[4][3] = primaryFace[1];
        colors[4][0] = primaryFace[2];
        colors[4][7] = primaryFace[3];
        colors[4][4] = primaryFace[4];
        colors[4][1] = primaryFace[5];
        colors[4][8] = primaryFace[6];
        colors[4][5] = primaryFace[7];
        colors[4][2] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[32] = colors[3][2];
        primaryOuter[31] = colors[3][1];
        primaryOuter[30] = colors[3][0];
        primaryOuter[22] = colors[2][2];
        primaryOuter[21] = colors[2][1];
        primaryOuter[20] = colors[2][0];
        primaryOuter[12] = colors[1][2];
        primaryOuter[11] = colors[1][1];
        primaryOuter[10] = colors[1][0];
        primaryOuter[02] = colors[0][2];
        primaryOuter[01] = colors[0][1];
        primaryOuter[00] = colors[0][0];

        colors[0][2] = primaryOuter[32];
        colors[0][1] = primaryOuter[31];
        colors[0][0] = primaryOuter[30];
        colors[3][2] = primaryOuter[22];
        colors[3][1] = primaryOuter[21];
        colors[3][0] = primaryOuter[20];
        colors[2][2] = primaryOuter[12];
        colors[2][1] = primaryOuter[11];
        colors[2][0] = primaryOuter[10];
        colors[1][2] = primaryOuter[02];
        colors[1][1] = primaryOuter[01];
        colors[1][0] = primaryOuter[00];

        Main.results +=("OrangeCounterClockWise\n");
        return colors;
    }

    public static int[][] redCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[5][0];
        primaryFace[1] = colors[5][1];
        primaryFace[2] = colors[5][2];
        primaryFace[3] = colors[5][3];
        primaryFace[4] = colors[5][4];
        primaryFace[5] = colors[5][5];
        primaryFace[6] = colors[5][6];
        primaryFace[7] = colors[5][7];
        primaryFace[8] = colors[5][8];

        colors[5][2] = primaryFace[0];
        colors[5][5] = primaryFace[1];
        colors[5][8] = primaryFace[2];
        colors[5][1] = primaryFace[3];
        colors[5][4] = primaryFace[4];
        colors[5][7] = primaryFace[5];
        colors[5][0] = primaryFace[6];
        colors[5][3] = primaryFace[7];
        colors[5][6] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[16] = colors[1][6];
        primaryOuter[17] = colors[1][7];
        primaryOuter[18] = colors[1][8];
        primaryOuter[26] = colors[2][6];
        primaryOuter[27] = colors[2][7];
        primaryOuter[28] = colors[2][8];
        primaryOuter[36] = colors[3][6];
        primaryOuter[37] = colors[3][7];
        primaryOuter[38] = colors[3][8];
        primaryOuter[6] = colors[0][6];
        primaryOuter[7] = colors[0][7];
        primaryOuter[8] = colors[0][8];

        colors[2][6] = primaryOuter[16];
        colors[2][7] = primaryOuter[17];
        colors[2][8] = primaryOuter[18];
        colors[3][6] = primaryOuter[26];
        colors[3][7] = primaryOuter[27];
        colors[3][8] = primaryOuter[28];
        colors[0][6] = primaryOuter[36];
        colors[0][7] = primaryOuter[37];
        colors[0][8] = primaryOuter[38];
        colors[1][6] = primaryOuter[6];
        colors[1][7] = primaryOuter[7];
        colors[1][8] = primaryOuter[8];

        Main.results +=("RedClockWise\n");
        return colors;
    }

    public static int[][] redCCW(int colors[][]) {
        int[] primaryFace = new int[62];
        primaryFace[0] = colors[5][0];
        primaryFace[1] = colors[5][1];
        primaryFace[2] = colors[5][2];
        primaryFace[3] = colors[5][3];
        primaryFace[4] = colors[5][4];
        primaryFace[5] = colors[5][5];
        primaryFace[6] = colors[5][6];
        primaryFace[7] = colors[5][7];
        primaryFace[8] = colors[5][8];

        colors[5][6] = primaryFace[0];
        colors[5][3] = primaryFace[1];
        colors[5][0] = primaryFace[2];
        colors[5][7] = primaryFace[3];
        colors[5][4] = primaryFace[4];
        colors[5][1] = primaryFace[5];
        colors[5][8] = primaryFace[6];
        colors[5][5] = primaryFace[7];
        colors[5][2] = primaryFace[8];

        int[] primaryOuter = new int[62];
        primaryOuter[16] = colors[1][6];
        primaryOuter[17] = colors[1][7];
        primaryOuter[18] = colors[1][8];
        primaryOuter[26] = colors[2][6];
        primaryOuter[27] = colors[2][7];
        primaryOuter[28] = colors[2][8];
        primaryOuter[36] = colors[3][6];
        primaryOuter[37] = colors[3][7];
        primaryOuter[38] = colors[3][8];
        primaryOuter[6] = colors[0][6];
        primaryOuter[7] = colors[0][7];
        primaryOuter[8] = colors[0][8];

        colors[0][6] = primaryOuter[16];
        colors[0][7] = primaryOuter[17];
        colors[0][8] = primaryOuter[18];
        colors[1][6] = primaryOuter[26];
        colors[1][7] = primaryOuter[27];
        colors[1][8] = primaryOuter[28];
        colors[2][6] = primaryOuter[36];
        colors[2][7] = primaryOuter[37];
        colors[2][8] = primaryOuter[38];
        colors[3][6] = primaryOuter[6];
        colors[3][7] = primaryOuter[7];
        colors[3][8] = primaryOuter[8];

        Main.results +=("RedCounterClockWise\n");
        return colors;
    }
}

