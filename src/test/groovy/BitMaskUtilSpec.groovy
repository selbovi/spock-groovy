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

    @Unroll
    def "test enum BitEnum.Bits"() {
        expect:
        BitEnum.Bits.valueOf(a).value == b

        where:
        a       | b
        'ONE'   | 1
        'TWO'   | 2
        'FOUR'  | 4
        'EIGHT' | 8
    }

    @Unroll
    def "test flag result"() {
        expect:
        BitMaskUtil.getValueContainedResult(a, b) == c

        where:
        a     | b | c
        0b011 | 2 | 2
        0b010 | 1 | 0
        0b110 | 4 | 4
    }

    @Unroll
    def "test flag enabled"() {
        expect:
        BitMaskUtil.isValueContained(a, b) == c

        where:
        a     | b | c
        0b011 | 2 | true
        0b010 | 1 | false
        0b110 | 4 | true
    }

    @Unroll
    def "cartesian test"() {
        expect:
        BitMaskUtil.possibleValuesContainingCombinatios(arr, val).size() == size

        where:
        arr              | val | size
        [2]              | 1   | 0
        [2]              | 4   | 0
        [2]              | 2   | 1
        [1, 2, 4]        | 2   | 4
        [1, 2, 4]        | 1   | 4
        [1, 2, 4]        | 4   | 4
        [1, 2, 4]        | 6   | 2
        [1, 2, 4]        | 5   | 2
        [1, 2, 4]        | 8   | 0
        [1, 2, 4]        | 7   | 1
        [2, 8]           | 1   | 0
        [2, 8]           | 8   | 2
        [2, 8]           | 2   | 2
        [2, 8]           | 4   | 0
        [1, 2]           | 3   | 1
        [1, 2]           | 4   | 0
        [1, 2, 4, 8, 16] | 32  | 0
        [1, 2, 4, 8, 16] | 16  | 11
        [1, 2, 4, 8, 16] | 24  | 4
        [1, 2, 4, 8, 16] | 1   | 11
    }
}
