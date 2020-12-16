import java.util.ArrayList;

public class Table {
    private double[][] simplexTable; //симплекс таблица

    private final int m;
    private int n;

    private final ArrayList<Integer> basis; //список базисных переменных

    Table(double[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        simplexTable = new double[m][n + m - 1];
        basis = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < simplexTable[0].length; j++) {
                simplexTable[i][j] = (j < n) ?matrix[i][j] :0;
            }
            //выставляем коэффициент 1 перед базисной переменной в строке
            if ((n + i) < simplexTable[0].length) {
                simplexTable[i][n + i] = 1;
                basis.add(n + i);
            }
        }

        n = simplexTable[0].length;
    }

    public double[] calculate(int length) {
        int mainColumn;
        int mainRow;

        while (!isItEnd()) {
            mainColumn = findMainCol();
            mainRow = findMainRow(mainColumn);
            basis.set(mainRow, mainColumn);

            double[][] newSimplexTable = new double[m][n];

            for (int j = 0; j < n; j++) {
                newSimplexTable[mainRow][j] =simplexTable[mainRow][j] / simplexTable[mainRow][mainColumn];
            }

            for (int i = 0; i < m; i++) {
                if (i == mainRow)
                    continue;

                for (int j = 0; j < n; j++) {
                    newSimplexTable[i][j] = simplexTable[i][j] -
                            simplexTable[i][mainColumn] * newSimplexTable[mainRow][j];
                }
            }

            simplexTable = newSimplexTable;
        }

        double[] result = new double[length];

        //заносим в result найденные значения X
        for (int i = 0; i < result.length; i++) {
            int k = basis.indexOf(i+1);
            result[i] = (k != -1) ?simplexTable[k][0] :0;
        }

        return result;
    }

    private boolean isItEnd() {
        for (int j = 1; j < n; j++) {
            if (simplexTable[m - 1][j] < 0){
                return false;
            }
        }

        return true;
    }

    private int findMainCol() {
        int mainColumn = 1;

        for (int j = 2; j < n; j++) {
            if (simplexTable[m - 1][j] < simplexTable[m - 1][mainColumn]) {
                mainColumn = j;
            }
        }

        return mainColumn;
    }

    private int findMainRow(int mainColumn) {
        int mainRow = 0;

        for (int i = 0; i < m - 1; i++) {
            if (simplexTable[i][mainColumn] >0) {
                mainRow = i;
                break;
            }
        }

        for (int i = mainRow + 1; i < m - 1; i++) {
            if ((simplexTable[i][mainColumn] >0) &&((simplexTable[i][0] / simplexTable[i][mainColumn]) <
                    (simplexTable[mainRow][0] / simplexTable[mainRow][mainColumn]))){

                mainRow = i;
            }
        }

        return mainRow;
    }
}
