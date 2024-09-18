import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        drawPattern();

    }
    public static void drawPattern(){
        int option = 0, number1 = 0, number2 = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Select a pattern to draw: \n1.Triangle \n2.Inverse triangle \n3.Number triangle \n4.Box \n5.Rhombus");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    do {
                        number1 = inputLevels();
                        if (number1 <= 0) {
                            System.out.println("Please enter a valid number");
                        } else
                            drawATriangle(number1);

                    } while (number1 <= 0);

                    break;
                case 2:
                    do {
                        number1 = inputLevels();
                        if (number1 <= 0) {
                            System.out.println("Please enter a valid number");
                        } else
                            drawAnInverseTriangle(number1);

                    } while (number1 <= 0);

                    break;
                case 3:
                    do {
                        number1 = inputLevels();
                        if (number1 <= 0 || number1 > 9) {
                            System.out.println("Please enter a valid number");
                        } else
                            drawANumTriangle(number1);

                    } while (number1 <= 0 || number1 > 9);

                    break;
                case 4:
                    do {
                        System.out.println("Insert width: ");
                        number1 = scanner.nextInt();
                        if (number1 <= 0) {
                            System.out.println("Please enter a valid number");
                        }
                    } while (number1 <= 0);
                    do {
                        System.out.println("Insert height: ");
                        number2 = scanner.nextInt();
                        if (number2 <= 0) {
                            System.out.println("Please enter a valid number");
                        } else
                            drawABox(number1, number2);
                    } while (number2 <= 0);

                    break;
                case 5:
                    do {
                        number1 = inputLevels();
                        if (number1 <= 0) {
                            System.out.println("Please enter a valid number");
                        } else
                            drawARhombus(number1);

                    } while (number1 <= 0);
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }while(option <1 || option > 5);
    }

    public static void drawATriangle(int nLevels) {
        StringBuilder stringBuilder = new StringBuilder(" *");
        for (int i = 1; i < nLevels; i++) {
            stringBuilder.insert(0, " ");
        }
        for (int j = 0; j < nLevels; j++) {
            System.out.println(stringBuilder);
            stringBuilder.insert(stringBuilder.length() - 1, "**");
            stringBuilder = stringBuilder.deleteCharAt(0);
        }

    }
    public static void drawAnInverseTriangle(int nLevels) {
        StringBuilder stringBuilder = new StringBuilder(" *");
        for (int i = 1; i < nLevels; i++) {
            stringBuilder.insert(1, "**");
        }
        for (int j = 0; j < nLevels; j++) {
            System.out.println(stringBuilder);
            stringBuilder.replace(j+1, j+2, " ");
            stringBuilder.replace(stringBuilder.length() -(j+1), stringBuilder.length() -j, " ");
        }

    }

    public static void drawABox(int width, int height) {
        StringBuilder strWidth = new StringBuilder("");
        StringBuilder strHeight = new StringBuilder("*");
        for (int i = 0; i < width - 1; i++) {
            strWidth.insert(0, "*  ");
            strHeight.insert(1, "   ");//fix
        }
        strWidth.insert(strWidth.length(), "*");
        strHeight.replace(strHeight.length() - 1, strHeight.length(), "*");
        System.out.println(strWidth);
        for (int j = 0; j < height - 2; j++) {
            System.out.println(strHeight);
        }
        System.out.println(strWidth);
    }

    public static void drawANumTriangle(int nLevels) {//max 9
        StringBuilder stringBuilder = new StringBuilder(" 1");
        int number = 1, position = 4;
        for (int i = 0; i < nLevels*2; i++) {
            stringBuilder.insert(0, " ");
        }
        for (int j = 0; j < nLevels; j++) {
            System.out.println(stringBuilder);
            number++;
            stringBuilder.insert(stringBuilder.length(), " " + number);
            stringBuilder.insert(stringBuilder.length() - position, number);
            stringBuilder = stringBuilder.deleteCharAt(0);
            position+= 4;

        }

    }
    public static void drawARhombus(int nLevels){
        int middle = 0, odd = 0;
        if(nLevels%2 == 0){
            middle= nLevels/2;
        }else{
            middle = Math.round(nLevels/2)+1;
            System.out.println(middle);
            odd = 1;
        }

        drawATriangle(middle);
        drawAnInverseTriangle(middle -odd);//missing a space in drawARhombus function
    }
    public static int inputLevels(){
        int level = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the amount of levels that you want: ");
        level= scanner.nextInt();
        return level;
    }
}


