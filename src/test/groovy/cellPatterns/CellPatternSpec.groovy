package cellPatterns

import spock.lang.*

class CellPatternSpec extends Specification {

    @Shared
    CellPattern cellPattern

    @Shared
    def matrix

    def setup(){
      cellPattern = new CellPattern()
        matrix = [['.','.','.','.','.','.','.','.','.','*'],
                  ['.','*','.','*','.','.','.','*','.','.'],
                  ['.','.','.','.','.','.','.','.','.','.'],
                  ['.','.','*','.','*','.','.','.','.','*'],
                  ['.','*','.','.','*','.','.','.','*','.'],
                  ['.','.','.','.','.','.','.','.','.','*'],
                  ['.','.','.','.','.','.','.','.','.','.'],
                  ['.','.','.','.','.','*','.','.','*','.'],
                  ['.','*','.','.','.','.','*','.','.','.'],
                  ['.','.','.','.','.','*','*','.','.','.']]
    }

    def "calculate automata"(){
        when:
        def resp = cellPattern.calculateAutomata()
        then:
        resp.size() == 10
        resp == respMatrix()
    }

    def "get values in file"() {
        when:
        def resp = cellPattern.getInfoFromFile()
        then:
        resp.size == 10
    }

    
    def "iterate automata"(){
    when:
    def resp = cellPattern.iterateAutomata(matrix, 10, 0)
    then:
    resp == respMatrix()
    }

    private def "respMatrix"(){
        [['.','.','.','.','.','.','.','.','.','.'],
        ['.','.','.','*','.','.','.','.','.','.'],
        ['.','.','*','.','*','.','.','.','.','.'],
        ['.','.','*','.','*','.','.','.','.','.'],
        ['.','.','.','*','.','.','.','.','.','.'],
        ['.','.','.','.','.','.','.','.','.','.'],
        ['.','.','.','.','.','.','.','.','.','.'],
        ['.','.','.','.','.','.','.','.','.','.'],
        ['.','.','.','.','.','.','.','.','.','.'],
        ['.','.','.','.','.','.','.','.','.','.']]
    }


}