

class Ranges {

    fun join_interval (first : Range, second : Range) : Range
    {
        /* Check if end of an interval isn't bigger than the begin*/
        if(first.begin > first.end || second.begin > second.end)
            throw Exception("The end of an interval can't be bigger than the end");
        /* Check if they're off-set*/
        if(first.end < second.begin || first.begin > second.end)
            throw Exception("Off-set");
        var resultbegin = first.begin.coerceAtLeast(second.begin);
        var resultend = first.end.coerceAtMost(second.end);

        return Range(resultbegin, resultend);
    }

    fun bigger_range (first : Range, second : Range) : Range
    {
        /* Check if end of an interval isn't bigger than the begin*/
        if(first.begin > first.end || second.begin > second.end)
            throw Exception("The end of an interval can't be bigger than the end");

        return if(first.end - first.begin >= second.end - second.begin) first else second;

    }

}