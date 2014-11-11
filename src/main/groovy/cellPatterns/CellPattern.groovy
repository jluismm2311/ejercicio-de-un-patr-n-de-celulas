package cellPatterns

/**
 * Created by jluis on 10/11/14.
 */
class CellPattern {

  def getInfoFromFile(){
    def file = new File("/tmp/matriz.txt")
      file.eachLine{it->
        println it
      }
  }
}
