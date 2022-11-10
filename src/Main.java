
public class Main {
    public static void main(String[] args) {

        double[][] dataSets = {{0.6, 0.5}, {0.2, 0.4}, {-0.3, -0.5}, {-0.1, -0.1}, {0.1, 0.1}, {-0.2, 0.7}, {-0.4, -0.2}, {-0.6, 0.3}}; //data sets
        int[] targetValues = {1, 1, -1, -1, 1, 1, -1, -1}; //target values

        double[][] testDataSets = {{2.5, -0.5}, {0.8, -0.7}, {-0.8, 0.5}, {1.0, 1.1}, {-1.9, 0.8}};
        int[] testTargetValues = {1, 1, -1, 1, -1};

        ArtificialNeuron perceptron = new ArtificialNeuron(0, 0); //creates the perceptron

        for (int epoch = 1; epoch < 101; epoch++) {
            perceptron.setAccurateCount(0); // initializes the accurate count at the beginning of each epoch
            perceptron.setAccuracy(0);

            for (int i = 0; i < 8; i++) { //tests the data sets
                perceptron.setX1(dataSets[i][0]);
                perceptron.setX2(dataSets[i][1]);

                perceptron.addingMethod();
                perceptron.thresholdMethod();

                learning(perceptron, targetValues[i]);
            }

            perceptron.setAccuracy(perceptron.getAccurateCount() / 8); //calculates the accuracy

            if (epoch == 10 || epoch == 100 ) {
                System.out.println(epoch + "th Epoch's Accuracy: ");

                perceptron.setAccurateCount(0);
                perceptron.setAccuracy(0);

                for (int i = 0; i < 5; i++) { //tests the data sets
                    perceptron.setX1(testDataSets[i][0]);
                    perceptron.setX2(testDataSets[i][1]);

                    perceptron.addingMethod();
                    perceptron.thresholdMethod();
                    accuracyCalculation(perceptron, testTargetValues[i]);
                }

                perceptron.setAccuracy(perceptron.getAccurateCount() / 5); //calculates the accuracy

                System.out.println("Accurate count for our external test results: " + perceptron.getAccurateCount() + "\nAccuracy: " + perceptron.getAccuracy() * 100 + "%");
                System.out.println();
            }
        }
    }

    public static void learning(ArtificialNeuron perceptron, int targetValue) {
        if (perceptron.getY() != targetValue) { //if the y value is -1 and the target value is 1 increase the weights
            perceptron.addWeight(targetValue);
            return;
        }
        //if the y value and target value is the same, increases the accuracy
        accuracyCalculation(perceptron, targetValue);
    }

    public static void accuracyCalculation(ArtificialNeuron perceptron, int targetValue){
        if(perceptron.getY() == targetValue)
            perceptron.setAccurateCount(perceptron.getAccurateCount()+1);
    }
}