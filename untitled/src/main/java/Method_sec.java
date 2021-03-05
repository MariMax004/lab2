import static java.lang.Math.abs;

public class Method_sec {
    double last_x;
    double current_x;
    double next_x = 0;
    double e;
    String answer_file;



    public double f2(double x){
        return Math.pow(x,3)-x+4;
        //return Math.pow(x, 3)-3.125*(Math.pow(x, 2))-3.5*x+2.458;
    }
    public String start(double last_x, double current_x, double e, boolean flag_file){
        if(!flag_file) {
            System.out.println("Найти корень уравнения x^3-3,125x^2-3,5x+2,458=0 с х0 = " + current_x + " и х1 = " + next_x + " c точностью = " + e);
            System.out.println();
            System.out.println("Метод секущих: ");
            System.out.println();
            System.out.println("|\t№\t|\txi-1\t|\tf(xi-1)\t|\t\txi\t|\tf(xi)\t|\txi+1\t|\tf(xi+1)\t|\t|xi+1 - xi|\t|");
        }else{
            answer_file += "Найти корень уравнения x^3-3,125x^2-3,5x+2,458=0 с х0 = " + current_x + " и х1 = " +
                    next_x + " c точностью = " + e + "\n\n" +
                    "Метод секущих: " + "\n\n" +
                    "|\t№\t|\txi-1\t|\tf(xi-1)\t|\t\txi\t|\tf(xi)\t|\txi+1\t|\tf(xi+1)\t|\t|xi+1 - xi|\t|\n";
        }

        int iteration=0;
        double abs = Math.abs(current_x-next_x);
        while (e<abs){
            next_x=getNext_x(current_x,last_x);
            abs = Math.abs(current_x- next_x);
            if(!flag_file)
                outLineTable(iteration, last_x, f2(last_x), current_x,f2(current_x), next_x, f2(next_x), abs);
            else{
                answer_file += "|\t"+iteration+"\t|\t"+String.format("%.4f",last_x)+"\t|\t"+String.format("%.4f",f2(last_x))+"\t|\t"
                        +String.format("%.4f",current_x)+"\t|\t"+String.format("%.4f",f2(current_x))+"\t|\t"+String.format("%.4f",next_x)+
                        "\t|\t"+String.format("%.4f",f2(next_x))+"\t|\t"+String.format("%.4f",abs)+"\t\t|\n";
            }
          //  System.out.println("X(i-1) = " + String.format("%.3f",last_x) + " X(i) = " + String.format("%.3f",current_x) + " X(i+1) = " + String.format("%.3f",next_x) + " f(i+1) = " + String.format("%.3f", f2(next_x)) + " |a-b| = " + String.format("%.3f", abs(current_x-next_x)));
            last_x = current_x;
            current_x = next_x;
            iteration++;
        }
        if(!flag_file) {
            System.out.println();
            System.out.println("x = " + String.format("%.3f", next_x));
        }else{
            answer_file += "\nx = " + String.format("%.3f", next_x);
        }

        return answer_file;
    }
    public double getNext_x(double current_x, double last_x){
        return current_x-((current_x-last_x)*(f2(current_x))/(f2(current_x)-f2(last_x)));


    }
    private void outLineTable(int i, double a, double b, double x, double f_a, double f_b, double f_x,double abs){
        // System.out.println("|\t"+i+"\t|\t"+a+"\t|\t"+b+"\t|\t"+x+"\t|\t"+String.format("%.3f",f_a)+"\t|\t"+String.format("%.3f",f_b)+"\t|\t"+String.format("%.3f",f_x)+"\t|\t"+abs+"\t|");
        System.out.println("|\t"+i+"\t|\t"+String.format("%.4f",a)+"\t|\t"+String.format("%.4f",b)+"\t|\t"
                +String.format("%.4f",x)+"\t|\t"+String.format("%.4f",f_a)+"\t|\t"+String.format("%.4f",f_b)+
                "\t|\t"+String.format("%.4f",f_x)+"\t|\t"+String.format("%.4f",abs)+"\t\t|");
    }

}
