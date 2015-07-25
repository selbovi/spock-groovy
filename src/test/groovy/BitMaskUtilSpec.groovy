import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by salavat on 26.07.2015.
 */
class BitMaskUtilSpec extends Specification {
    @Unroll
    def "test int to binary string"() {
        expect:
        BitMaskUtil.intAsBinaryString(a).equals(b)

        where:
        a | b
        1 | '1'
        2 | '10'
        3 | '11'
        4 | '100'
        5 | '101'

    }
}
