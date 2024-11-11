public class House {

    private String address;
    private Double price;
    private Double downPayment;
    private Double mortgageRate;


    //constructor 1 for address and price information.
    public House(String address, Double price){
        this.address = address;
        this.price = price;
        this.downPayment = 0.0;
        this.mortgageRate = 0.0;
    }//end constructor 1

    //constructor 2 for complete listings that include mortgage information.
    public House(String address, Double price, Double downPayment, Double mortgageRate){
        this.address = address;
        this.price = price;
        this.downPayment = downPayment;
        this.mortgageRate = mortgageRate;
    }//end constructor 2

    // getter and setter
    public void setAddress(String address){
        this.address = address;}
    public String getAddress(){
        return address;}
    public void setPrice(Double price){
        this.price = price;}
    public Double getPrice(){
        return price;}
    public void setDownPayment(Double downPayment){
        this.downPayment=downPayment;}
    public Double getDownPayment(){
        return downPayment;}
    public void setMortgageRate(Double mortgageRate){
        this.mortgageRate=mortgageRate;}
    public Double getMortgageRate(){
        return mortgageRate;}

    public Double calculateMortgage(){
        Double principal = getPrice()- getDownPayment();
        Double monthlyRate = (getMortgageRate()/ 100 ) / 12;
        long totalPayement;
        totalPayement = 360;
        Double power = Math.pow((1+monthlyRate),(-totalPayement));
        Double monthlyPayment = (principal * monthlyRate)/(1-power);
        return monthlyPayment;
    }

    public double calculateTotalCost() {
        double monthlyPayment = calculateMortgage();
        return (monthlyPayment * 360) + downPayment;
    }

    public void printHouseDetails() {
        System.out.println("Address: " + address);
        System.out.println("Price: $" + price);
        System.out.println("Down Payment: $" + (downPayment > 0 ? downPayment : "N/A"));
        System.out.println("Mortgage Rate (%): " + (mortgageRate > 0 ? mortgageRate + "%" : "N/A"));

        if (mortgageRate > 0) {
            System.out.printf("\nMonthly Mortgage Payment: $" +"%.2f", calculateMortgage());
            System.out.printf("\nTotal Cost of house (including interest: $" +"%.2f", calculateTotalCost());
        } else {
            System.out.println("Mortgage details not available.");
        }
    }















}//end house class
