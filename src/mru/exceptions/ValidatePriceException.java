package mru.exceptions;

public abstract class ValidatePriceException {
    public static void Validate(double price) throws PriceException{
        if (price<0){
            throw new PriceException("Price can not be less then 0!");
        }
    }
}
