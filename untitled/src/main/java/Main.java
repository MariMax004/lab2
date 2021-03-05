import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.decrementExact;

public class Main {

    static double f(float x){
        double f;
        return f = Math.pow(x, 3)-3.125*(Math.pow(x, 2))-3.5*x+2.458;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DrawChart draw = new DrawChart();
        try {
            System.out.println("Начало работы программы");
            while(true) {
                System.out.println("Выбирете метод решения:\n" +
                        "1. Метод половинного деления\n" +
                        "2. Метод секущих\n" +
                        "3. Метод простых итераций");
                try {
                    int num_method = Integer.parseInt(in.nextLine());
                    if(num_method == 1){
                        System.out.println("Введите интервалы а, b и точность");
                        double a=0;
                        double b=0;
                        while (true) {
                            try {
                                System.out.print("а: ");
                                a = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр a введено не число");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("b: ");
                                b = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр b введено не число");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("точность: ");
                                double e = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                while (true){
                                    System.out.print("Вывести данные в файл y/n: ");
                                    String input = in.nextLine().toLowerCase().trim();
                                    if(input.equals("y") || input.equals("")){
                                        Method1 method1 = new Method1();
                                        String to_file = method1.start(a, b, e, true);
                                        try {
                                            FileWriter writer = new FileWriter("out1.txt", false);
                                            writer.write(to_file);
                                            writer.flush();
                                        }catch (IOException ex){
                                            System.out.println("файл не найлден");
                                        }
                                        draw.draw(Math.round(a),Math.round(b));
                                        System.out.println("Метод 1 выполнен. Результат выполнения в файле out1.txt\n");
                                        break;
                                    }else if(input.equals("n")){
                                        Method1 method1 = new Method1();
                                        method1.start(a, b, e, false);
                                        draw.draw(Math.round(a),Math.round(b));
                                        System.out.println("Метод 1 выполнен\n");
                                        break;
                                    }else{
                                        System.out.println("Введите двнные корректно");
                                    }
                                }

                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр точночти введено не число");
                            }
                        }

                    }else if(num_method == 2){
                        System.out.println("Введите интервалы X0, X1 и точность");
                        double a=0;
                        double b=0;
                        while (true) {
                            try {
                                System.out.print("X0: ");
                                a = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр X0 введено не число");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("X1: ");
                                b = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр X1 введено не число");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("точность: ");
                                double e = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));

                                while (true) {
                                    System.out.print("Вывести данные в файл y/n: ");
                                    String input = in.nextLine().toLowerCase().trim();
                                    if (input.equals("y") || input.equals("")) {
                                        Method_sec method_sec = new Method_sec();
                                        String to_file = method_sec.start(a, b, e, true);
                                        try {
                                            FileWriter writer = new FileWriter("out2.txt", false);
                                            writer.write(to_file);
                                            writer.flush();
                                        } catch (IOException ex) {
                                            System.out.println("файл не найлден");
                                        }
                                        draw.draw(Math.round(a),Math.round(a) + 5);
                                        System.out.println("Метод 2 выполнен. Результат выполнения в файле out2.txt\n");
                                        break;
                                    } else if (input.equals("n")) {
                                        Method_sec method_sec = new Method_sec();
                                        method_sec.start(a, b, e, false);
                                        draw.draw(Math.round(a),Math.round(a) + 5);
                                        System.out.println("Метод 2 выполнен\n");
                                        break;
                                    } else {
                                        System.out.println("Введите двнные корректно");
                                    }
                                }

                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр точночти введено не число");
                            }
                        }

                    }else if(num_method == 3){
                        System.out.println("Введите интервалы а, b и точность");
                        double a=0;
                        double b=0;
                        while (true) {
                            try {
                                System.out.print("а: ");
                                a = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр a введено не число");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("b: ");
                                b = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр b введено не число");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("точность: ");
                                double e = Double.parseDouble(in.nextLine().trim().replaceAll(",", "\\."));
                                while (true) {
                                    System.out.print("Вывести данные в файл y/n: ");
                                    String input = in.nextLine().toLowerCase().trim();
                                    if (input.equals("y") || input.equals("")) {
                                        Method3 method3 = new Method3();
                                        String to_file = method3.startMethod(a,b,e, true);
                                        try {
                                            FileWriter writer = new FileWriter("out3.txt", false);
                                            writer.write(to_file);
                                            writer.flush();
                                        } catch (IOException ex) {
                                            System.out.println("файл не найлден");
                                        }
                                        draw.drawMethod3(a,b,e);
                                        System.out.println("Метод 3 выполнен. Результат выполнения в файле out3.txt\n");
                                        break;
                                    } else if (input.equals("n")) {
                                        Method3 method3 = new Method3();
                                        method3.startMethod(a,b,e, false);
                                        draw.drawMethod3(a,b,e);
                                        System.out.println("Метод 3 выполнен\n");
                                        break;
                                    } else {
                                        System.out.println("Введите двнные корректно");
                                    }
                                }
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("В параметр точночти введено не число");
                            }
                        }

                    }else{
                        System.out.println("Метод выбран некорректно");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Введено не число");
                }
            }


        }catch (NoSuchElementException ex){
            System.out.println("Программа завершилась экстренным способом, через ctrl+d ");
        }
/*
        double e= 0.01;
        double a= -2;
        double b= -1.5;

        Method1 method1=new Method1();
        method1.start(-2,-1,0.01);


        Method_sec method_sec=new Method_sec();
        method_sec.start(a,b,e);



        Method3 method3 = new Method3();
        method3.startMethod(-2,-1,0.001);


 */
    }

}
