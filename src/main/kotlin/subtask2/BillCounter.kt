package subtask2

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val halfValue = (bill.sum() - bill[k])/2
        return  if (b - halfValue == 0) "Bon Appetit" else (b - halfValue).toString()
    }
}
