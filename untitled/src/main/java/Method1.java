public class Method1 {
    double a;
    double b;
    double c;
    double x = 0;
    double e = 0.01d;
    String answer_file = "";


    public double f(double x){
        //  return Math.pow(x,3)-x+4;
       return Math.pow(x, 3)-3.125*(Math.pow(x, 2))-3.5*x+2.458;
    }
    public String start(double a,double b, double e, boolean flag_file) {
        if(!flag_file) {
            System.out.println("Найти корень уравнения x^3-3,125x^2-3,5x+2,458=0 на интервале [" + a + ";" + b + "] c точностью = " + e);
            System.out.println();
            System.out.println("Метод половинного деления: ");
            System.out.println();
            System.out.println("|\t№\t|\t\ta\t|\t\tb\t|\t\tx\t|\tf(a)\t|\tf(b)\t|\tf(x)\t|\t|a-b|\t|");
        }else{
            answer_file+= "Найти корень уравнения x^3-3,125x^2-3,5x+2,458=0 на интервале [" + a + ";" +
                    b + "] c точностью = " + e + "\n\n"+
                    "Метод половинного деления: \n\n" +
                    "|\t№\t|\t\ta\t|\t\tb\t|\t\tx\t|\tf(a)\t|\tf(b)\t|\tf(x)\t|\t|a-b|\t|\n";
        }
        int iteration = 0;

        while (Math.abs(a - b) > e) {
            c = (a + b) / 2;
            if (f(a) * f(c) <= 0) b = c;
            else {
                a = c;
                x = (a + b) / 2;
            }
            if(!flag_file) {
                outLineTable(iteration, a, b, x, f(a), f(b), f(x), Math.abs(a - b));
            }else {
                answer_file += "|\t"+iteration+"\t|\t"+String.format("%.4f",a)+"\t|\t"+String.format("%.4f",b)+"\t|\t"
                        +String.format("%.4f",x)+"\t|\t"+String.format("%.4f",f(a))+"\t|\t"+String.format("%.4f",f(b))+
                        "\t|\t"+String.format("%.4f",f(x))+"\t|\t"+String.format("%.4f",Math.abs(a-b))+"\t|\n";
            }

            iteration++;
           //System.out.println("a = " + a + " b = " + b + " x = " + x + " f(a) = " + String.format("%.3f",f(a)) + " f(b) = " + String.format("%.3f",f(b)) + " f(x) = " + String.format("%.3f",f(x)) + " |a-b| = " + Math.abs(a - b));
        }
        if(!flag_file) {
            System.out.println();
            System.out.println("x = " + String.format("%.3f", x) + " f(x) = " + String.format("%.3f", f(x)));
        }else{
            answer_file += "\nx = " + String.format("%.3f", x) + " f(x) = " + String.format("%.3f", f(x));
        }

        if(flag_file){
            return answer_file;
        }else{
            return null;
        }
    }
    private void outLineTable(int i, double a, double b, double x, double f_a, double f_b, double f_x, double abs){
        System.out.println("|\t"+i+"\t|\t"+String.format("%.4f",a)+"\t|\t"+String.format("%.4f",b)+"\t|\t"
                +String.format("%.4f",x)+"\t|\t"+String.format("%.4f",f_a)+"\t|\t"+String.format("%.4f",f_b)+
                "\t|\t"+String.format("%.4f",f_x)+"\t|\t"+String.format("%.4f",abs)+"\t|");
        //System.out.println("|\t"+i+"\t|\t"+a+"\t|\t"+b+"\t|\t"+x+"\t|\t"+f_a+"\t|\t"+f_b+"\t|\t"+f_x+"\t|\t"+abs+"\t|");

    }


    }
