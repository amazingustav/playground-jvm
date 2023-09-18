package br.com.amazingapps.playground.strings

/**
 * Given a string with brackets -> (, ), [, ], { and } you must return `true` if it is a valid string or `false` if it isn't.
 * A valid String in that structure means that ALL BRACKETS can be closed correctly.
 *
 * E.g.
 * (([])) -> valid
 * ((][)) -> invalid
 * ({[]}) -> valid
 * {{{[[]](()[]}}} -> invalid
 * f(e(0)) -> valid
 * */
class BalanceBrackets {

    fun isBalanced(brackets: String): Boolean {
        var s = brackets

        while (s.isNotEmpty()) {
            val temp = s
            s = s.replace(Regex("[^()\\[\\]{}]"), "")
                .replace("()", "")
                .replace("[]", "")
                .replace("{}", "")

            if (s == temp) break
        }

        return s.isEmpty()
    }

    fun isBalancedAlternative(s: String): Boolean {
        if (s.first().isCloseBracket() || s.last().isOpenBracket()) return false

        val openBrackets = mutableListOf<Char>()

        s.toCharArray().forEach {
            if (it.isCloseBracket()) {
                val lastOpenBracket = if (openBrackets.isEmpty()) null else openBrackets[openBrackets.size - 1]

                if (lastOpenBracket?.reverse() != it) {
                    return false
                } else openBrackets.removeLast()
            } else {
                openBrackets.add(it)
            }
        }

        return true
    }

    private fun Char.reverse() = when {
        this == '(' -> ')'
        this == '{' -> '}'
        this == '[' -> ']'
        this == ')' -> '('
        this == '}' -> '{'
        this == ']' -> '['
        else -> throw IllegalArgumentException("Character must be a bracket!")
    }

    private fun MutableList<Char>.removeLast() = this.removeAt(this.size - 1)

    private fun Char.isCloseBracket() = this == '}' || this == ']' || this == ')'

    private fun Char.isOpenBracket() = this == '{' || this == '[' || this == '('
}
