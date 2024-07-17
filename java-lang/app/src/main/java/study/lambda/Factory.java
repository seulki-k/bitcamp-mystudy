package study.lambda;

import study.lambda.Test04.InterestCalculator;

public class Factory {

  static InterestCalculator create(double rate) {
    class My implements InterestCalculator{
      double rate;

      public My(double rate) {
        this.rate = rate;
      }

      @Override
      public double compute(int money) {
        return money + (money*rate);
      }
    }
    return new My(rate);
  }
}