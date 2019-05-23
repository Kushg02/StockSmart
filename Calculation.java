
/**
 * Write a description of class RiskCalculation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculation
{
    // instance variables - replace the example below with your own
    
    public static double stockSmartScore1 = 0.0; //corralates to the score calculated with the 1st calculation (Calc1)
    
    public static void Calc1(double beta, double currPrice, int numOfStock, double histLow, double histHigh, double estHigh, double stopLoss)
    //histLow & histHigh must be the low & high before the current stock price
    // StopLoss is the price which trading stops, estHigh is the predicted future stock price
    {
        double returnRiskRatio = ((estHigh-currPrice))/((currPrice-stopLoss));
            double maxLoss = ((currPrice-stopLoss)*numOfStock);
            double minLoss = ((currPrice-stopLoss)*numOfStock);
        
        double voltatility = beta; //maybe add something else here
        
        double goodTimeToBuy = 0.0; //Has a max of 50 (unless huge beta)
        
        if((currPrice >= histHigh) && (beta > 1)){
            goodTimeToBuy = 0.0;
        }else if((currPrice > histHigh) && (beta > 1)){
            goodTimeToBuy = (30.0)*beta; //Dont want to buy in last minute as the stock rises
        }else if((currPrice < histLow) && (beta > 1)){
            goodTimeToBuy = (40.0)*beta; //Want to buy in last minute as the stock rises
        }else if((currPrice <= histLow) && (beta < 0.95)){
            goodTimeToBuy = -10*(1/beta); //Removes Score In Case of Major decline
        }else{
            goodTimeToBuy = 25;}
        
        stockSmartScore1 = (25*(voltatility*1)) + goodTimeToBuy + (12.5*returnRiskRatio);
    }
    
    public double getScore1(){
        return stockSmartScore1;
    }
}
