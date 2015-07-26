/**
 * Created by salavat on 26.07.2015.
 */
class BitMaskUtil {

    /**получить int в виде бинарной строки*/
    def static intAsBinaryString(int intNum) {
        Integer.toBinaryString(intNum)
    }

    /**получить результат по максе*/
    def static getValueContainedResult(int actual, int val) {
        actual & val
    }

    /**получить булевый результат сравнения, содржится ли число в маске*/
    def static isValueContained(int actual, int val) {
        getValueContainedResult(actual, val) == val
    }

    /**
     * получить список картезиана из возможных битовых масок, куда может попадать
     * исходное значение
     * @param arr [1, 2, 4, 6 ...]
     * @param val
     * @return
     */
    def static possibleValuesContainingCombinatios(arr, val) {
        def result = new ObservableSet<Integer>()
        while (arr.size > 0) {
            arr.each {

                def a = it
                arr.each {
                    def b = it

                    if ((a | b) >= val) {
                        /*print("val=" + intAsBinaryString(val) + " | ")
                        print("a=$a , b=$b | ")
                        print("a|b = " + intAsBinaryString(a | b) + " " + (a | b))
                        print(' | ')
                        print(isValueContained((a | b), val))
                        println()*/
                        if (isValueContained((a | b), val)) {
                            result.add(a | b)
                        }
                    }
                    a = a | b
                }
            }
            arr = arr.subList(1, arr.size)
        }
        result
    }
}
