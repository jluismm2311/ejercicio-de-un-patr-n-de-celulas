package cellPatterns

import spock.lang.*

class CellPatternSpec extends Specification {

    @Shared
    CellPattern cellPattern

    def setup(){
      cellPattern = new CellPattern();
    }

    def "calculate automata"(){
        when:
        def resp = cellPattern.calculateAutomata()
        then:
        resp.size() == 10
    }

    def "get values in file"() {
        when:
        def resp = cellPattern.getInfoFromFile()
        then:
        resp.size == 10
    }
}