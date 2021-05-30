package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        var bracketPairList = mutableListOf<Pair<Char, Int>>()
        val bracketList = listOf('>', '<', '[', ']', '(', ')')
        val resultArray = mutableListOf<String>()

        for ((index, char) in inputString.withIndex()) {
            if (bracketList.contains(char))
                bracketPairList.add(Pair(char, index))
        }

        bracketPairList = sortBracketList(bracketPairList) as MutableList<Pair<Char, Int>>

        while(bracketPairList.isNotEmpty()) {
            resultArray.add(inputString.substring(bracketPairList[0].second + 1, bracketPairList[1].second))
            bracketPairList.removeAt(0)
            bracketPairList.removeAt(0)
        }
        return resultArray.toTypedArray()
    }

    fun sortBracketList(bracketsList: List<Pair<Char, Int>>): List<Pair<Char, Int>> {
        val sortedBracketList = mutableListOf<Pair<Char, Int>>()
        var parenthesisOpen: Int
        var angleOpen : Int
        var squareOpen : Int
        var parenthesisClose : Int
        var angleClose : Int
        var squareClose : Int

        loop@ for ((index, pair) in bracketsList.withIndex()) {
            parenthesisOpen = 0
            parenthesisClose = 0
            squareOpen = 0
            squareClose = 0
            angleOpen = 0
            angleClose = 0

            when(pair.first) {
                '(' -> parenthesisOpen++
                '<' -> angleOpen++
                '[' -> squareOpen++
                ')', '>', ']' -> continue@loop
            }

            if (parenthesisOpen == 1 || angleOpen == 1 || squareOpen == 1) {
                sortedBracketList.add(pair)
            }

            for (i in index + 1 until bracketsList.size) {
                when (bracketsList[i].first) {
                    '(' -> parenthesisOpen++
                    '<' -> angleOpen++
                    '[' -> squareOpen++
                    ']' -> squareClose++
                    '>' -> angleClose++
                    ')' -> parenthesisClose++
                }

                if (parenthesisOpen == parenthesisClose && (pair.first == '(' && parenthesisOpen > 0)) {
                    sortedBracketList.add(bracketsList[i])
                    break
                } else if (angleOpen == angleClose && (pair.first == '<' && angleOpen > 0)) {
                    sortedBracketList.add(bracketsList[i])
                    break
                } else if (squareOpen == squareClose && (pair.first == '[' && squareOpen > 0)) {
                    sortedBracketList.add(bracketsList[i])
                    break
                }
            }
        }
        return sortedBracketList
    }
}
