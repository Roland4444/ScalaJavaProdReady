package samples

import org.junit._
import Assert._
import uk.roland.abstractions.*
@Test
class AppTest {

    @Test
    def testOK() = assertTrue(2 == 2)

    @Test
    def testAdd(): Unit = {

    val Parser = ParseDSL()
    assertEquals(4, Parser.add(2, 2))
}
    val parser = ParseDSL()

    @Test
    def testgetDSLRulestoObject(): Unit ={
        val readRole: Role = Role("read","", parser)
        val writeRole: Role = Role("write","", parser)
        val createRole: Role = Role("create","", parser)
        var Roles: List[Role] = List(readRole, writeRole, createRole)
        var ObjectRules : DSLRole = DSLRole("requests", Roles)
        assertEquals(ObjectRules, parser.getDSLRulesfromString(input))
    }

//    @Test
//    def testKO() = assertTrue(false)

}


