package cellPatterns

import spock.lang.*

class CellPatternSpec extends Specification {

    @Shared
    CellPattern cellPattern

    def setup(){
      cellPattern = new CellPattern();
    }


    def "get values in file"() {
        when:
        cellPattern.getInfoFromFile()
        then:
        false
    }
}