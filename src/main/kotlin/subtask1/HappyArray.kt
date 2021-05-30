package subtask1

class HappyArray {

    fun remove(arr: IntArray, index: Int): IntArray {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = IntArray(arr.size - 1)
        System.arraycopy(arr, 0, result, 0, index)
        System.arraycopy(arr, index + 1, result, index, arr.size - index - 1)
        return result
    }

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var tempArray = sadArray.copyOf()
        var isSadDetected : Boolean

        do {
            isSadDetected = false
            for (index in 1..tempArray.size - 2) {
                if (tempArray[index] > tempArray[index - 1] + tempArray[index + 1]) {
                    tempArray = remove(tempArray, index)
                    isSadDetected = true
                    break
                }
            }
        }while (isSadDetected)

        return tempArray
    }
}
