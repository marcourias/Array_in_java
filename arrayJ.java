import java.util.Scanner;
import java.util.Arrays;




public class arrayJ {

    double avg = 0.0;

    // Método para capturar la entrada del usuario
    // Method that captures the input from user

    public static double[] entrada(){
        int length;

        Scanner input = new Scanner(System.in);
        System.out.println("How many values?\n (Enter an int)");
        length = input.nextInt();

        double[] nums = new double[length];

        for(int i=0; i < length; i++) {
            System.out.println("Value number "+(i+1)+":");
            nums[i] = input.nextInt();

                if (nums[i] < 0 || nums[i]>10) {
                    do {
                        System.out.println(("Please, enter a number between 0 and 10"));
                        nums[i] = input.nextInt();
                    } while 
                        ((nums[i] < 0 || nums[i]>10));
                }
                
                    
        }

        return nums;
    }

    // Método para calcular el promedio de un array
    // Method to calculate the average of an array
    public static double average(double... nums) {
        double sum = 0.0;

        //Calcula la suma del array
        //Sum of the array
        for (double d : nums) {
            sum += d;
        }

        //Dividir la suma entre el número de elementos del array
        //Dividing the sum between the number of elements in the array
        double avg = sum / nums.length;

        return avg;
    }


    // Método para calcular la varianza
    // Method to calculate the variance
    public static double varianza (double avg, double... nums) {
        double sum = 0.0;

        //Obtener la sumatoria de cada elemento menos el promedio, elevado al cuadrado
        //Obtaining the sum of each element minus the average, rised to the square
        for (int i =0; i < nums.length; i++) {
            sum += Math.pow((nums[i] - avg),2);
        }
        
        // Para obtener la varianza: Dividir la sumatoria entre el número de elementos
        // In order to obtain the variance: Dividing the sum between the number of elements of the array
        double varianza = sum / nums.length;
        return varianza;
    }


    // Método para calcular la desviación estándar
    // Method to calculate the standar deviation
    public static double stddev (double varianza) {
        double standardev = Math.pow(varianza, 0.5);
        return standardev;
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-".repeat(60)+"\n"+ " ".repeat(5)+" CALCULATING MEAN, VARIANCE AND STANDAR DEVIATION \n\n"+"-".repeat(60));
        System.out.println("\n\nCalculate statistics values using int numbers between 0 and 10.\n");
        boolean error = true;
        double[] nums = null;

        do {
            try {
                // Se declara la lista y su contenido
                nums = entrada();
                error = false;
            
            } catch (Exception e) {
                System.out.println("You didn't enter an int. Try again.\n\n");
            }
            
        } while (error);
        
        


        // Se invocan los 3 métodos para el cálculo de los valores correspondientes
        // We use the 3 methods to calculate the avg, variance and standard deviation.
        double promedio = average(nums);
        double varia = varianza(promedio, nums);
        double deviation = stddev(varia);

        System.out.print("\033[H\033[2J"); //Limpiar la consola
        System.out.flush();
        
        // ****** MENÚ ******
        int opcion = 0;

        
        do {System.out.println("-".repeat(40)+"\nMain menu\n"+"-".repeat(40)+"\n1. Mean\n2. Variance\n3. Standard deviation\n4. Exit\n"+"-".repeat(40));
            //input.nextLine();
            
            try {
                opcion = sc.nextInt();
                switch(opcion) {
                    case 1:
                        // Mostrar el resultado del cálculo del promedio y los valores empleados.
                        // Showing the result of average calculation and the used values
                        System.out.println("\n\n\nValues entered to calculate the mean: "+ Arrays.toString(nums));
                        System.out.printf("\nThe mean is: %.2f\n", promedio);
                        sc.nextLine();
                        System.out.println("Press ENTER to continue.");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J"); //Clean console
                        System.out.flush();
                        break;
                    case 2:
                        // Mostrar el resultado del cálculo de varianza y los valores empleados.
                        // Showing the result of variance and the used values
                        System.out.println("\n\n\nValues used to calculate the variance.\nMean: "+ promedio+"\nArray length: "+nums.length);
                        System.out.printf("\nThe variance is: %.2f", varia);
                        sc.nextLine();
                        System.out.println("\nPress ENTER to continue.");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J"); //Limpiar la consola
                        System.out.flush();
                        break;
                    case 3:
                        // Mostrar el resultado del cálculo de desviación estándar y los valores empleados.
                        // Showing the result of stardard deviation and the used values
                        System.out.println("\n\n\nValues used to calculate the standard deviation.\nVariance: "+ varia);
                        System.out.printf("The standard deviation is: %.2f \n\n\n\n", deviation);
                        sc.nextLine();
                        System.out.println("Press ENTER to continue.");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J"); //Limpiar la consola
                        System.out.flush();
                        break;
                    case 4:
                        System.out.printf("Exit selected. Ending program.");
                        //entrada.close();
                        break;
                        default:
                        System.out.println("Invalid option.");
                 } 

            } catch (Exception e) {
                boolean err = true;
                do {
                    
                    try {
                        System.out.println("Select one of the options.");
                        sc.nextLine();
                        opcion = sc.nextInt();
                        err = false;
                    } catch (Exception f) {
                        System.out.println("\nYou didn't select one of the options.\n");
                    }
                }   while (err);

            } 
        } while (opcion != 4);
}
}