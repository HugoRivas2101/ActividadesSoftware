package skeleton;
import io.cucumber.junit.java.en.When;

public class Stepdefs {
    // NOTE: because the regular expressions are within
    // Java strings, we have to make all backslashes double backslashes
    // for them to work correctly.  So, to find a decimal character,
    // rather than writing \d, you must write \\d.

    // NOTE 2: to explicitly force a pattern to start with the
    // beginning of the input string, start with ^.  To force it to
    // end at the end of the input string, use $.  For example:
    // @When("test_foo \\d") will match:
    //     test_foo 5
    // but will also match:
    //     some test_foo 5 dollars
    //     bugga bugga test_foo 1 yeeeeeehaaaaaaaaw
    //
    // On the other hand:
    // @When("^test_foo \\d$")
    // will only match: test_foo 5
    //

    // NOTE 3: to not 'capture' a pattern as an argument to the
    // Java method, use (?:<pattern>)
    // For example:
    //    @When("^match_four ((in|out)(foo|bar))$")
    // will match the words:
    //   infoo, inbar, outfoo, and outbar.
    // However, the associated Java function will require three
    // parameters: one for the 'in/out' value, one for the
    // 'foo/bar' value, and one for their concatenation.  To
    // only capture the concatenated value, use:
    //   @When("^match_four ((?:in|out)(?:foo|bar))$")
    //
    // You will probably need this to do the IP address example :)


    // Regular expression matcher for positive integers
    // Should match the string: test_posint followed by an sequence of
    // digits of arbitrary length
    @When("^test_posint FILL IN REGULAR EXPRESSION HERE$")
    public void test_posint(int number) throws Throwable {
        System.out.println("test_posint true for: " + number);
    }

    // Regular expression matcher for integers
    // Should match the string: test_int followed by an optional
    // minus sign followed by a sequence of
    // digits of arbitrary length
    //
    // I give you this one as a freebie!
    @When("^test_int (-?\\d+)$")
    public void test_int(int arg1) throws Throwable {
        System.out.println("test_int true for: " + arg1);
    }

    // Regular expression matcher for floats
    // Should match the string: test_float followed by an optional
    // minus sign followed by a sequence of
    // digits of arbitrary length followed by a period followed by
    // a second sequence of digits of arbitrary length.
    @When("^test_float FILL IN REGULAR EXPRESSION HERE$")
    public void test_float(float arg1) throws Throwable {
        System.out.println("test_int true for: " + arg1);
    }

    // Regular expression matcher for IP addresses (though inexact).
    // It should accept four digit sequences separated by periods
    // where a digit sequence is defined as follows:
    //    Any single digit
    //    Any two digit characters if the first character is non-zero
    //    A one followed by a zero, one, or two followed by any digit

    // SEE NOTE 3 :)
    @When("^test_ip_address FILL IN REGULAR EXPRESSION HERE$")
    public void test_ip_address(String arg1) throws Throwable {
        System.out.println("test_ip_address true for: " + arg1);
    }


    // Pattern distinguisher.
    // Should match the string starting with: test_splitter arg
    // Where <arg> should match the following positive examples
    // and not the negative examples.  Note: any string not in the
    // positive or negative examples can be accepted or rejected.
    //
    // Positive:		Negative:
    // =========		=========
    // spill			si
    // Sponge			egregious
    // tap				Foul
    // rebuild			Test
    //                  top
    //                  ta
    @When("^test_splitter FILL IN REGULAR EXPRESSION HERE$")
    public void test_splitter(String match) throws Throwable {
        System.out.println("test_splitter true for: " + match);
    }


    // Pattern distinguisher 2.
    // Should match the string starting with: test_splitter2 arg
    // Where <arg> should match the following positive examples
    // and not the negative examples.  Note: any string not in the
    // positive or negative examples can be accepted or rejected.
    //
    // Positive:		Negative:
    // =========		=========
    // spill			spall
    // Sponge			egregious
    // tap				foul
    // rebuild			test
    //                  top
    //                  tapper
    @When("^test_splitter2 FILL IN REGULAR EXPRESSION HERE$")
    public void test_splitter2(String match) throws Throwable {
        System.out.println("test_splitter2 true for: " + match);
    }
}

/*
package skeleton;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class Stepdefs {
	
	Belly belly = new Belly(); 
	
    @Given("^I have eaten (\\d+) cukes$")
    public void I_have_eaten_cukes(int cukes) throws Throwable {
        System.out.println("I'm eating " + cukes + " cukes!");
    	belly.eat(cukes);
    }
    
    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
        belly.wait(arg1);
    }

    @Then("^(?i)my\\s*belly\\s*should\\s*growl$")
    public void my_belly_should_growl() throws Throwable {
    	assertTrue(belly.isGrowling());
    }

    @Then("^(?i)my\\s*belly\\s*should\\s*not\\s*growl$")
    public void my_belly_should_not_growl() throws Throwable {
    	assertTrue(!belly.isGrowling());
    }
    
}
/*