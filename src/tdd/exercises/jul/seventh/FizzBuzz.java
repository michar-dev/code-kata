package tdd.exercises.jul.seventh;

public final class FizzBuzz {
    public void print(final int number) {
        String output = "";

        if (number % 3 == 0) {
            output += "Fizz";
        }

        if (number % 5 == 0) {
            output += "Buzz";
        }

        if (output.isEmpty()) {
            System.out.println(number);
        } else {
            System.out.println(output);
        }
    }
}
