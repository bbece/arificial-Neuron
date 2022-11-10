import java.util.Random;

public class ArtificialNeuron {

    Random random = new Random();

    private double x1;
    private double x2;

    private double weight1 = -1 + 2 * random.nextDouble(); //initializes a random weight between -1 and 1
    private double weight2 = -1 + 2 * random.nextDouble();

    private double accurateCount = 0; //number of accurate results
    private double accuracy;

    private int y; //is either 1 or -1
    private double totalValue;

    public ArtificialNeuron(double newx1, double newx2){ //constructor method
        setX1(newx1);
        setX2(newx2);
    }

    public void addingMethod(){
        setTotalValue(((x1*weight1) + (x2*weight2)));
    } //sum of products of weights and data sets

    public void thresholdMethod(){
        if (getTotalValue() <0.5)
            setY(-1);
        else if (getTotalValue() >=0.5)
            setY(1);
    }

    public void addWeight(int targetValue){
        weight1 += 0.05*x1*(targetValue-y);
        weight2 += 0.05*x2*(targetValue-y);
    }


    //set and get methods
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getWeight1() {
        return weight1;
    }

    public void setWeight1(double weight1) {
        this.weight1 = weight1;
    }

    public double getWeight2() {
        return weight2;
    }

    public void setWeight2(double weight2) {
        this.weight2 = weight2;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getAccurateCount() {
        return accurateCount;
    }

    public void setAccurateCount(double accurateCount) {
        this.accurateCount = accurateCount;
    }
}
