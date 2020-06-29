import spock.lang.Specification
import spock.lang.Unroll

class SpockTestOnCalculator extends Specification {

    @Unroll
    def 'Addition'(){

        given: 'Setup'
        TestSetup.setup()

        when: 'Calculation'
        TestSetup.CalculatorSession.findElementByName("One").click()
        TestSetup.CalculatorSession.findElementByName("Plus").click()
        TestSetup.CalculatorSession.findElementByName("Seven").click()
        TestSetup.CalculatorSession.findElementByName("Equals").click()


        then: 'Assert the result'
        assert _GetCalculatorResultText() == "8"

        cleanup: 'Closing calculator and cmd'
        TestSetup.TearDown()


    }

    @Unroll
    def 'Combination'(){

        given: 'Setup'
        TestSetup.setup()

        when: 'Calculation'
        TestSetup.CalculatorSession.findElementByName("Seven").click()
        TestSetup.CalculatorSession.findElementByName("Multiply by").click()
        TestSetup.CalculatorSession.findElementByName("Nine").click()
        TestSetup.CalculatorSession.findElementByName("Plus").click()
        TestSetup.CalculatorSession.findElementByName("One").click()
        TestSetup.CalculatorSession.findElementByName("Equals").click()
        TestSetup.CalculatorSession.findElementByName("Divide by").click()
        TestSetup.CalculatorSession.findElementByName("Eight").click()
        TestSetup.CalculatorSession.findElementByName("Equals").click()

        then: 'Assert the result'
        assert _GetCalculatorResultText() == "8"

        cleanup: 'Closing calculator and cmd'
        TestSetup.TearDown()
    }

    @Unroll
    def 'Division'(){

        given: 'Setup'
        TestSetup.setup()

        when: 'Calculation'
        TestSetup.CalculatorSession.findElementByName("Eight").click()
        TestSetup.CalculatorSession.findElementByName("Eight").click()
        TestSetup.CalculatorSession.findElementByName("Divide by").click()
        TestSetup.CalculatorSession.findElementByName("One").click()
        TestSetup.CalculatorSession.findElementByName("One").click()
        TestSetup.CalculatorSession.findElementByName("Equals").click()

        then: 'Assert the result'
        assert _GetCalculatorResultText() == "8"

        cleanup: 'Closing calculator and cmd'
        TestSetup.TearDown()
    }

    @Unroll
    def 'Multiplication'(){

        given: 'Setup'
        TestSetup.setup()

        when: 'Calculation'
        TestSetup.CalculatorSession.findElementByName("Nine").click()
        TestSetup.CalculatorSession.findElementByName("Multiply by").click()
        TestSetup.CalculatorSession.findElementByName("Nine").click()
        TestSetup.CalculatorSession.findElementByName("Equals").click()

        then: 'Assert the result'
        assert _GetCalculatorResultText() == "81"

        cleanup: 'Closing calculator and cmd'
        TestSetup.TearDown()
    }

    @Unroll
    def 'Subtraction'(){

        given: 'Setup'
        TestSetup.setup()

        when: 'Calculation'
        TestSetup.CalculatorSession.findElementByName("Nine").click()
        TestSetup.CalculatorSession.findElementByName("Minus").click()
        TestSetup.CalculatorSession.findElementByName("One").click()
        TestSetup.CalculatorSession.findElementByName("Equals").click()

        then: 'Assert the result'
        assert _GetCalculatorResultText() == "8"

        cleanup: 'Closing calculator and cmd'
        TestSetup.TearDown()
    }

    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return TestSetup.CalculatorResult.getText().replace("Display is", "").trim()
    }

}