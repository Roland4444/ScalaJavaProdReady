package uk.roland.abstractions

import uk.roland.util.Checker


class ParseDSL  {

    val checker: Checker = Checker()
    extension (c: String)
    def circumference: Double = c.radius * math.Pi * 2

    def add(A: Int, B: Int): Int= A+ B
    def getDSLRulesfromString(input: String): DSLRole = {
        val objectName: String = input.substring(input.indexOf("'")+1, input.lastIndexOf("'"))
        println("""Loading rules for object <$objectName>""")
        return DSLRole(objectName, parseRoles(input))
    }

    def parseRole(input: String): Role= {
        if (input.indexOf("{") == -1)
            return null
        val rolename: String= input.substring(input.indexOf("::")+2, input.indexOf("{"))
        var params =""
        if (input.indexOf("{")<input.indexOf("}")-1)
            params = input.substring(input.indexOf("{") + 1, input.indexOf("}"))
        else params=""
        if ((rolename.length == 0) || (rolename ==null))
            return null;
        return Role(rolename, params, this)
    }
    def parseRoles(input: String): List[Role]={
        var input__ = input.prepare()
        var result: Seq[Role]  = Seq[Role]()
        var initialString = input
        var role: Role = parseRole(initialString)
        while (role != null){
        result.add(role)
        initialString = initialString.substring(initialString.indexOf("}")+1)
        role  = parseRole(initialString)
    };
        return result
    }
}