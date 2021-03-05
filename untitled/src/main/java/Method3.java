public class Method3{

        private double cf1 = 1;
        //private double cf2 = -3.125;
        private double cf2 = -1;
        private double cf3 = -3.5;
        //private double free = 2.458;
        private double free = 4;
        private double leambda = -1;

        private double last_x = 0;
        private double next_x = 0;

        private String answer_file = "";

        private double f_(double x ){
               // return 3*Math.pow(x,2)-1;
              return 3*Math.pow(x,2) - 25*x/4 - 7/2;
        }

        private double f(double x){
              //  return Math.pow(x,3)-x+4;
                return Math.pow(x,3) - 3.125*Math.pow(x,2) - 3.5*x + 2.458;
        }

        public double F(double x){
               // return cf1*Math.pow(x,3)+cf2*x+free;
               return cf1*Math.pow(x,3) + cf2*Math.pow(x,2) + cf3*x + free;
        }

        private double getMax(double a, double b){
                return Math.max(f_(a), f_(b));
        }

        private void outLineTable(int i, double l_x, double n_x, double F_x, double f_x, double abs){
                //System.out.println("|\t"+i+"\t|\t"+l_x+"\t|\t"+n_x+"\t|\t"+F_x+"\t|\t"+f_x+"\t|\t"+abs+"\t|");
                System.out.println("|\t"+i+"\t|\t"+String.format("%.4f",l_x)+"\t|\t"+String.format("%.4f",n_x)+"\t|\t"
                        +String.format("%.4f",F_x)+"\t|\t"+String.format("%.4f",f_x)+"|\t"+String.format("%.4f",abs)+"\t|");
        }

        private void startIteration(double eps, boolean flag_file){
                if(!flag_file)
                        System.out.println("|\t№\t|\t\txi\t|\txi+1\t|\tF(xi+1)\t|\tf(xi+1)\t||xi+1 - xi||");
                else{
                        answer_file += "|\t№\t|\t\txi\t|\txi+1\t|\tF(xi+1)\t|\tf(xi+1)\t||xi+1 - xi||\n";
                }

                double abs = Math.abs(next_x - last_x);
                int iteration = 0;
                while(eps < abs) {
                        next_x = F(last_x);
                        abs = Math.abs(next_x - last_x);
                        if (!flag_file)
                                outLineTable(iteration, last_x, next_x, F(next_x), f(next_x), abs);
                        else{
                                answer_file +=  "|\t"+iteration+"\t|\t"+String.format("%.4f",last_x)+"\t|\t"+String.format("%.4f",next_x)+"\t|\t"
                                        +String.format("%.4f",F(next_x))+"\t|\t"+String.format("%.4f",f(next_x))+"|\t"+String.format("%.4f",abs)+"\t|\n";
                        }
                        last_x = next_x;
                        iteration++;
                }
        }


        public String startMethod(double a, double b, double eps, boolean flag_file){
                if(!flag_file){
                        System.out.println("Найти корень уравнения x^3-3,125x^2-3,5x+2,458=0 на интервале [" + a + ";" + b + "] c точностью = " + eps);
                        System.out.println();
                        System.out.println("Метод простой итерации: ");
                }else{
                        answer_file += "Найти корень уравнения x^3-3,125x^2-3,5x+2,458=0 на интервале [" + a + ";" +
                                b + "] c точностью = " + eps + "\n\n" +
                                "Метод простой итерации: \n";
                }

                last_x = a;
                leambda = leambda / getMax(a,b);
                cf1 = cf1 * leambda;
                cf2 = cf2 * leambda;
                cf3 =  1 +cf3 * leambda;
                free = free * leambda;
                //System.out.println(cf1+" "+cf2+" "+free);
               // System.out.println(leambda);
                startIteration(eps, flag_file);

                return answer_file;
              //  System.out.println("x = " + String.format("%.3f",last_x) + " f(x) = " + String.format("%.3f",f(last_x)));
        }


}
