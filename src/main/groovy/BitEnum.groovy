/**
 * Created by salavat on 26.07.2015.
 */
class BitEnum {
    enum Bits {
        ONE(0b1), TWO(0b10), FOUR(0b100), EIGHT(0b1000)

        def getValue() {
            return value
        }

        void setValue(value) {
            this.value = value
        }
        def private value

        Bits(int val) {
            this.value = val
        }
    }

}

