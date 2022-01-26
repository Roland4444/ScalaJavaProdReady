package samples

import org.junit.*
import Assert.*
import uk.roland.abstractions.*

import scala.collection.mutable.ArrayBuffer
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
    val input: String = """'requests' => ::read{}, ::write{}, ::create{}."""

    @Test
    def testgetDSLRulestoObject(): Unit ={
        val readRole: Role = Role("read","", parser)
        val writeRole: Role = Role("write","", parser)
        val createRole: Role = Role("create","", parser)
        var Roles: ArrayBuffer[Role] = ArrayBuffer(readRole, writeRole, createRole)
        var ObjectRules : DSLRole = DSLRole("requests", Roles)
        assertEquals(ObjectRules, parser.getDSLRulesfromString(input))
    }

//    @Test
//    def testKO() = assertTrue(false)

}


