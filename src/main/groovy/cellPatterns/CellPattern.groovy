package cellPatterns

/**
 * Created by jluis on 10/11/14.
 */
class CellPattern {

  def calculateAutomata(){
    def matriz = getInfoFromFile()
    matriz
  }


  def getInfoFromFile(){
    def matriz = []
    def file = new File("/tmp/matriz.txt")
      file.eachLine{it->
        matriz.add it.toString().toCharArray()
      }
    matriz
  }
}
